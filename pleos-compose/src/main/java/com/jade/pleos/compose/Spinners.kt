package com.jade.pleos.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.gestures.stopScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.*
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.jade.pleos.tokens.*
import java.time.*
import java.time.format.TextStyle as DateTextStyle
import java.util.Locale
import kotlin.math.abs
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

enum class PleosSpinnerSize {
    Large,
    Medium,
}

enum class PleosDatePart {
    Month,
    Day,
    Year,
}

/**
 * 03 §10 / SP01. 기본 날짜 범위는 1900~2100년입니다. min≤max·3개 날짜 part의 유일한 순서가 필요합니다. 월말·윤년은 clamp하고 외부 값
 * 보정만으로 콜백을 보내지 않습니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 19_figma_spinner.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
fun adjustPleosDate(
    value: LocalDate,
    year: Int = value.year,
    month: Int = value.monthValue,
    day: Int = value.dayOfMonth,
    min: LocalDate = LocalDate.of(1900, 1, 1),
    max: LocalDate = LocalDate.of(2100, 12, 31),
): LocalDate {
    require(min <= max)
    val ym = YearMonth.of(year, month)
    return ym.atDay(day.coerceIn(1, ym.lengthOfMonth())).coerceIn(min, max)
}

/**
 * 03 §10 / SP01. minuteStep은 60의 양수 약수입니다. 12 AM=00·12 PM=12이며 초·나노초를 제거합니다. 비정렬 분은 아래 격자로 표시합니다.
 * 원본 노드·binding 식별자는 tools/spec_inventory.json의 19_figma_spinner.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를
 * 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
fun pleosHour24(hour12: Int, pm: Boolean): Int {
    require(hour12 in 1..12)
    return hour12 % 12 + if (pm) 12 else 0
}

@Composable
private fun spinnerLayout(size: PleosSpinnerSize): Pair<Dp, Dp> {
    val m = PleosTheme.metrics
    val row =
        if (size == PleosSpinnerSize.Medium) m.dp("spinner/list_medium_height", 96f)
        else m.dp("spinner/list_height", 88f)
    val panel =
        if (size == PleosSpinnerSize.Medium) m.dp("spinner/panel/medium_height", 288f)
        else m.dp("spinner/panel/large_height", 384f)
    val textHeight =
        with(LocalDensity.current) { pleosTextStyle(60, 80, FontWeight.Bold).lineHeight.toDp() }
    val expanded = maxOf(row, textHeight)
    return expanded to (panel + (expanded - row) * 3)
}

/**
 * 03 §10 / SP01. wheel 목록은 비어 있지 않고 유일하며 selected를 포함해야 합니다. Enter로 편집·Back으로 종료합니다. 호스트가 거부하면 외부
 * 값으로 복원하고 확정한 값만 onSettled로 전달합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의
 * 19_figma_spinner.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun <T : Any> PleosWheelColumn(
    values: List<T>,
    selected: T,
    onSelected: (T) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    formatter: (T) -> String = { it.toString() },
    size: PleosSpinnerSize = PleosSpinnerSize.Large,
    enabled: Boolean = true,
    stableKey: (T) -> Any = { it as Any },
    onSettled: ((T) -> Unit)? = null,
    wrap: Boolean = false,
) {
    require(values.isNotEmpty() && values.distinct().size == values.size && selected in values)
    val (row, height) = spinnerLayout(size)
    val density = LocalDensity.current
    var measuredHeight by remember { mutableIntStateOf(0) }
    val viewportHeight =
        if (measuredHeight == 0) height else with(density) { measuredHeight.toDp() }
    val index = values.indexOf(selected)
    val state = rememberLazyListState(index)
    val scope = rememberCoroutineScope()
    val c = PleosTheme.colors
    val change by rememberUpdatedState(onSelected)
    val settled by rememberUpdatedState(onSettled)
    val current by rememberUpdatedState(selected)
    val currentValues by rememberUpdatedState(values)
    var editing by remember { mutableStateOf(false) }
    val source = remember { MutableInteractionSource() }
    val input = LocalPleosInputMode.current
    val focusManager = LocalFocusManager.current
    var programmatic by remember { mutableStateOf(false) }
    var pendingIndex by remember { mutableIntStateOf(index) }
    var commitJob by remember { mutableStateOf<Job?>(null) }
    var pendingRequest by remember { mutableStateOf<T?>(null) }
    var observed by remember { mutableStateOf(selected) }
    fun settleConfirmed() {
        if (pendingRequest != null && current == pendingRequest) {
            pendingRequest = null
            settled?.invoke(current)
        }
    }
    suspend fun synchronize() {
        programmatic = true
        try {
            state.stopScroll(MutatePriority.PreventUserInput)
            state.scrollToItem(currentValues.indexOf(current).coerceAtLeast(0))
        } finally {
            programmatic = false
            pendingIndex = currentValues.indexOf(current).coerceAtLeast(0)
        }
    }
    fun request(next: T) {
        pendingRequest = next
        change(next)
        commitJob?.cancel()
        commitJob =
            scope.launch {
                // 호스트가 거부하거나 보정한 결과가 다음 재구성에 반영된 후 확정합니다.
                withFrameNanos {}
                synchronize()
                settleConfirmed()
            }
    }
    val latestRequest by rememberUpdatedState<(T) -> Unit>({ request(it) })
    LaunchedEffect(index, values) {
        if (current != observed && pendingRequest != current) pendingRequest = null
        observed = current
        synchronize()
        settleConfirmed()
    }
    LaunchedEffect(state) {
        var userScrolling = false
        snapshotFlow { state.isScrollInProgress to programmatic }
            .distinctUntilChanged()
            .collect { (scrolling, syncing) ->
                if (syncing) {
                    userScrolling = false
                } else if (scrolling) userScrolling = true
                else if (userScrolling) {
                    userScrolling = false
                    val layout = state.layoutInfo
                    val center = (layout.viewportStartOffset + layout.viewportEndOffset) / 2
                    val i =
                        layout.visibleItemsInfo
                            .minByOrNull { abs(it.offset + it.size / 2 - center) }
                            ?.index
                            ?.coerceIn(currentValues.indices) ?: return@collect
                    latestRequest(currentValues[i])
                }
            }
    }
    fun move(delta: Int): Boolean {
        if (!enabled) return false
        val candidate = pendingIndex + delta
        val next =
            if (wrap) Math.floorMod(candidate, values.size) else candidate.coerceIn(values.indices)
        if (next == pendingIndex) return false
        pendingIndex = next
        request(values[next])
        return true
    }
    LazyColumn(
        state = state,
        userScrollEnabled = enabled,
        flingBehavior = rememberSnapFlingBehavior(state),
        contentPadding = PaddingValues(vertical = ((viewportHeight - row) / 2).coerceAtLeast(0.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            modifier
                .height(height)
                .onSizeChanged { measuredHeight = it.height }
                .focusIndication(
                    source,
                    PleosTheme.metrics.dp("spinner/focus_radius_top_left", 24f),
                )
                .onFocusChanged { if (!it.isFocused) editing = false }
                .onPreviewKeyEvent { e ->
                    if (!enabled) false
                    else
                        when (e.key) {
                            Key.Enter,
                            Key.DirectionCenter -> {
                                if (e.type == KeyEventType.KeyUp) editing = !editing
                                true
                            }
                            Key.Back,
                            Key.Escape ->
                                if (editing) {
                                    if (e.type == KeyEventType.KeyUp) editing = false
                                    true
                                } else false
                            Key.DirectionUp,
                            Key.DirectionDown ->
                                if (editing) {
                                    if (e.type == KeyEventType.KeyDown)
                                        move(if (e.key == Key.DirectionUp) -1 else 1)
                                    true
                                } else if (e.type == KeyEventType.KeyDown)
                                    focusManager.moveFocus(
                                        if (e.key == Key.DirectionUp) FocusDirection.Up
                                        else FocusDirection.Down
                                    )
                                else false
                            else -> false
                        }
                }
                .focusable(enabled, source)
                .clearAndSetSemantics {
                    contentDescription = label
                    stateDescription = formatter(selected)
                    if (!enabled) disabled()
                    if (enabled) {
                        customActions =
                            listOf(
                                CustomAccessibilityAction("감소") { move(-1) },
                                CustomAccessibilityAction("증가") { move(1) },
                            )
                        scrollBy { _, y -> move(if (y > 0) 1 else -1) }
                    }
                },
    ) {
        itemsIndexed(values, key = { _, v -> stableKey(v) }) { i, v ->
            val present = v == selected
            Box(
                Modifier.fillMaxWidth().height(row).pointerInput(enabled, v) {
                    if (enabled) detectTapGestures { if (v != current) latestRequest(v) }
                },
                contentAlignment = Alignment.Center,
            ) {
                PleosText(
                    formatter(v),
                    color =
                        if (present) c["text/dark/primary"]
                        else c.scoped(.32f, "text/dark/quaternary"),
                    style =
                        pleosTextStyle(
                            if (present) 60 else 48,
                            if (present) 80 else 64,
                            FontWeight.Bold,
                        ),
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Composable
private fun SpinnerPanel(
    width: Dp,
    size: PleosSpinnerSize,
    modifier: Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    val c = PleosTheme.colors
    val background = c["background/primary"]
    val (band, h) = spinnerLayout(size)
    val m = PleosTheme.metrics
    Box(modifier.widthIn(max = width).horizontalScroll(rememberScrollState())) {
        PleosSurface(
            Modifier.width(width).height(h),
            background,
            m.dp("spinner/wheel/radius_top_left", 32f),
        ) {
            Box(
                Modifier.align(Alignment.Center)
                    .padding(horizontal = m.dp("spinner/wheel/padding_horizontal", 16f))
                    .fillMaxWidth()
                    .height(band)
                    .background(
                        c["dim/dark/primary"],
                        androidx.compose.foundation.shape.RoundedCornerShape(
                            m.dp("spinner/focus_radius_top_left", 24f)
                        ),
                    )
            )
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement =
                    Arrangement.spacedBy(
                        m.dp("spinner/column_gap", 24f),
                        Alignment.CenterHorizontally,
                    ),
                verticalAlignment = Alignment.CenterVertically,
                content = content,
            )
            Canvas(Modifier.matchParentSize()) {
                val fade =
                    m.dp(
                            if (size == PleosSpinnerSize.Large) "spinner/web/fade_height"
                            else "spinner/list_mask_height",
                            60f,
                        )
                        .toPx()
                drawRect(
                    Brush.verticalGradient(
                        listOf(background, background.copy(alpha = 0f)),
                        0f,
                        fade,
                    ),
                    size = androidx.compose.ui.geometry.Size(this.size.width, fade),
                )
                drawRect(
                    Brush.verticalGradient(
                        listOf(background.copy(alpha = 0f), background),
                        this.size.height - fade,
                        this.size.height,
                    ),
                    topLeft = androidx.compose.ui.geometry.Offset(0f, this.size.height - fade),
                    size = androidx.compose.ui.geometry.Size(this.size.width, fade),
                )
            }
        }
    }
}

@Composable
private fun spinnerColumnWidth(base: Dp, labels: List<String>): Dp {
    val measurer = rememberTextMeasurer()
    val style = pleosTextStyle(60, 80, FontWeight.Bold)
    val density = LocalDensity.current
    val pixels =
        labels.maxOfOrNull {
            measurer.measure(AnnotatedString(it), style, softWrap = false).size.width
        } ?: 0
    return maxOf(base, with(density) { pixels.toDp() })
}

/**
 * 03 §10 / SP01. 기본 날짜 범위는 1900~2100년입니다. min≤max·3개 날짜 part의 유일한 순서가 필요합니다. 월말·윤년은 clamp하고 외부 값
 * 보정만으로 콜백을 보내지 않습니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 19_figma_spinner.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosDateSpinner(
    value: LocalDate,
    onDateChange: (LocalDate) -> Unit,
    modifier: Modifier = Modifier,
    minDate: LocalDate = LocalDate.of(1900, 1, 1),
    maxDate: LocalDate = LocalDate.of(2100, 12, 31),
    locale: Locale = Locale.getDefault(),
    size: PleosSpinnerSize = PleosSpinnerSize.Large,
    enabled: Boolean = true,
    onSettled: ((LocalDate) -> Unit)? = null,
    dateOrder: List<PleosDatePart> = localizedDateOrder(locale),
    panelWidth: Dp? = null,
) {
    require(
        minDate <= maxDate &&
            dateOrder.toSet() == PleosDatePart.entries.toSet() &&
            dateOrder.size == 3
    )
    val date = value.coerceIn(minDate, maxDate)
    val active = enabled && LocalPleosCapabilities.current.complexInteraction
    val m = PleosTheme.metrics
    val monthWidth =
        spinnerColumnWidth(
            m.dp("spinner/number_width_small", 120f),
            Month.entries.map { it.getDisplayName(DateTextStyle.SHORT, locale) },
        )
    val dayWidth =
        spinnerColumnWidth(
            m.dp("spinner/number_width_small", 120f),
            listOf(String.format(locale, "%d", 88)),
        )
    val yearWidth =
        spinnerColumnWidth(
            m.dp("spinner/number_width_large", 200f),
            listOf(
                String.format(locale, "%d", minDate.year),
                String.format(locale, "%d", maxDate.year),
                String.format(locale, "%d", 8888),
            ),
        )
    val preferred = panelWidth ?: m.dp("spinner/date/width", 600f)
    require(preferred.value.isFinite() && preferred > 0.dp)
    val width =
        maxOf(
            preferred,
            monthWidth +
                dayWidth +
                yearWidth +
                m.dp("spinner/column_gap", 24f) * 2 +
                m.dp("spinner/wheel/padding_horizontal", 16f) * 2,
        )
    SpinnerPanel(width, size, modifier) {
        dateOrder.forEach { part ->
            key(part) {
                when (part) {
                    PleosDatePart.Month -> {
                        val months =
                            (1..12).filter {
                                YearMonth.of(date.year, it).atEndOfMonth() >= minDate &&
                                    YearMonth.of(date.year, it).atDay(1) <= maxDate
                            }
                        PleosWheelColumn(
                            months,
                            date.monthValue,
                            {
                                onDateChange(
                                    adjustPleosDate(date, month = it, min = minDate, max = maxDate)
                                )
                            },
                            Modifier.width(monthWidth),
                            "월",
                            { Month.of(it).getDisplayName(DateTextStyle.SHORT, locale) },
                            size,
                            active,
                            onSettled = {
                                onSettled?.invoke(
                                    adjustPleosDate(date, month = it, min = minDate, max = maxDate)
                                )
                            },
                        )
                    }
                    PleosDatePart.Day -> {
                        val days =
                            (1..date.lengthOfMonth()).filter {
                                date.withDayOfMonth(it) in minDate..maxDate
                            }
                        PleosWheelColumn(
                            days,
                            date.dayOfMonth,
                            { onDateChange(date.withDayOfMonth(it)) },
                            Modifier.width(dayWidth),
                            "일",
                            { String.format(locale, "%d", it) },
                            size,
                            active,
                            onSettled = { onSettled?.invoke(date.withDayOfMonth(it)) },
                        )
                    }
                    PleosDatePart.Year ->
                        PleosWheelColumn(
                            (minDate.year..maxDate.year).toList(),
                            date.year,
                            {
                                onDateChange(
                                    adjustPleosDate(date, year = it, min = minDate, max = maxDate)
                                )
                            },
                            Modifier.width(yearWidth),
                            "연도",
                            { String.format(locale, "%d", it) },
                            size,
                            active,
                            onSettled = {
                                onSettled?.invoke(
                                    adjustPleosDate(date, year = it, min = minDate, max = maxDate)
                                )
                            },
                        )
                }
            }
        }
    }
}

/**
 * 03 §10 / SP01. 기본 날짜 범위는 1900~2100년입니다. min≤max·3개 날짜 part의 유일한 순서가 필요합니다. 월말·윤년은 clamp하고 외부 값
 * 보정만으로 콜백을 보내지 않습니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 19_figma_spinner.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
fun localizedDateOrder(locale: Locale): List<PleosDatePart> {
    val pattern =
        (java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT, locale)
                as? java.text.SimpleDateFormat)
            ?.toPattern() ?: "M/d/y"
    return pattern
        .mapNotNull {
            when (it) {
                'M',
                'L' -> PleosDatePart.Month
                'd' -> PleosDatePart.Day
                'y' -> PleosDatePart.Year
                else -> null
            }
        }
        .distinct()
        .takeIf { it.size == 3 }
        ?: listOf(PleosDatePart.Month, PleosDatePart.Day, PleosDatePart.Year)
}

/**
 * 03 §10 / SP01. minuteStep은 60의 양수 약수입니다. 12 AM=00·12 PM=12이며 초·나노초를 제거합니다. 비정렬 분은 아래 격자로 표시합니다.
 * 원본 노드·binding 식별자는 tools/spec_inventory.json의 19_figma_spinner.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를
 * 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosTimeSpinner(
    value: LocalTime,
    onTimeChange: (LocalTime) -> Unit,
    modifier: Modifier = Modifier,
    is24Hour: Boolean = false,
    minuteStep: Int = 1,
    locale: Locale = Locale.getDefault(),
    size: PleosSpinnerSize = PleosSpinnerSize.Large,
    enabled: Boolean = true,
    onSettled: ((LocalTime) -> Unit)? = null,
    panelWidth: Dp? = null,
) {
    require(minuteStep > 0 && 60 % minuteStep == 0)
    val time = value.withSecond(0).withNano(0)
    val active = enabled && LocalPleosCapabilities.current.complexInteraction
    val m = PleosTheme.metrics
    val numberWidth =
        spinnerColumnWidth(
            m.dp("spinner/number_width_small", 120f),
            listOf(String.format(locale, "%02d", 88)),
        )
    val periods = java.text.DateFormatSymbols(locale).amPmStrings
    val periodWidth =
        spinnerColumnWidth(m.dp("spinner/number_width_medium", 140f), periods.toList())
    val preferred = panelWidth ?: m.dp("spinner/time/width", 500f)
    require(preferred.value.isFinite() && preferred > 0.dp)
    val contentWidth =
        numberWidth * 2 +
            (if (is24Hour) 0.dp else periodWidth) +
            m.dp("spinner/column_gap", 24f) * (if (is24Hour) 1 else 2) +
            m.dp("spinner/wheel/padding_horizontal", 16f) * 2
    SpinnerPanel(maxOf(preferred, contentWidth), size, modifier) {
        val hours = if (is24Hour) (0..23).toList() else (1..12).toList()
        val hour = if (is24Hour) time.hour else ((time.hour + 11) % 12) + 1
        PleosWheelColumn(
            hours,
            hour,
            { onTimeChange(time.withHour(if (is24Hour) it else pleosHour24(it, time.hour >= 12))) },
            Modifier.width(numberWidth),
            "시",
            { String.format(locale, "%02d", it) },
            size,
            active,
            onSettled = {
                onSettled?.invoke(
                    time.withHour(if (is24Hour) it else pleosHour24(it, time.hour >= 12))
                )
            },
        )
        val minute = time.minute / minuteStep * minuteStep
        PleosWheelColumn(
            (0..59 step minuteStep).toList(),
            minute,
            { onTimeChange(time.withMinute(it)) },
            Modifier.width(numberWidth),
            "분",
            { String.format(locale, "%02d", it) },
            size,
            active,
            onSettled = { onSettled?.invoke(time.withMinute(it)) },
        )
        if (!is24Hour) {
            PleosWheelColumn(
                listOf(false, true),
                time.hour >= 12,
                { onTimeChange(time.withHour(pleosHour24(hour, it))) },
                Modifier.width(periodWidth),
                "오전 또는 오후",
                { periods[if (it) 1 else 0] },
                size,
                active,
                onSettled = { onSettled?.invoke(time.withHour(pleosHour24(hour, it))) },
            )
        }
    }
}

/**
 * 03 §10 / SP01. wheel 목록은 비어 있지 않고 유일하며 selected를 포함해야 합니다. Enter로 편집·Back으로 종료합니다. 호스트가 거부하면 외부
 * 값으로 복원하고 확정한 값만 onSettled로 전달합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의
 * 19_figma_spinner.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosDateTimeSpinner(
    value: LocalDateTime,
    onValueChange: (LocalDateTime) -> Unit,
    modifier: Modifier = Modifier,
    size: PleosSpinnerSize = PleosSpinnerSize.Large,
    is24Hour: Boolean = false,
    minuteStep: Int = 1,
    locale: Locale = Locale.getDefault(),
    enabled: Boolean = true,
    dateHeading: String? = null,
    timeHeading: String? = null,
    minDate: LocalDate = LocalDate.of(1900, 1, 1),
    maxDate: LocalDate = LocalDate.of(2100, 12, 31),
    onSettled: ((LocalDateTime) -> Unit)? = null,
    datePanelWidth: Dp? = null,
    timePanelWidth: Dp? = null,
) {
    val m = PleosTheme.metrics
    val dateWidth = datePanelWidth ?: m.dp("spinner/date/width", 600f)
    val timeWidth = timePanelWidth ?: m.dp("spinner/time/width", 500f)
    val gap = m.dp("spinner/column_gap", 24f)
    Row(
        modifier.widthIn(max = dateWidth + timeWidth + gap).horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(gap),
    ) {
        Column {
            dateHeading?.let {
                PleosText(
                    it,
                    Modifier.padding(
                        top = m.dp("spinner/title_top_padding", 16f),
                        bottom = m.dp("spinner/gap_small", 16f),
                    ),
                    color = PleosTheme.colors["text/dark/secondary"],
                    style = pleosTextStyle(36, 44, FontWeight.Bold),
                )
            }
            PleosDateSpinner(
                value.toLocalDate(),
                { onValueChange(LocalDateTime.of(it, value.toLocalTime())) },
                panelWidth = dateWidth,
                minDate = minDate,
                maxDate = maxDate,
                size = size,
                locale = locale,
                enabled = enabled,
                onSettled = { onSettled?.invoke(LocalDateTime.of(it, value.toLocalTime())) },
            )
        }
        Column {
            timeHeading?.let {
                PleosText(
                    it,
                    Modifier.padding(
                        top = m.dp("spinner/title_top_padding", 16f),
                        bottom = m.dp("spinner/gap_small", 16f),
                    ),
                    color = PleosTheme.colors["text/dark/secondary"],
                    style = pleosTextStyle(36, 44, FontWeight.Bold),
                )
            }
            PleosTimeSpinner(
                value.toLocalTime(),
                { onValueChange(LocalDateTime.of(value.toLocalDate(), it)) },
                panelWidth = timeWidth,
                is24Hour = is24Hour,
                minuteStep = minuteStep,
                size = size,
                locale = locale,
                enabled = enabled,
                onSettled = { onSettled?.invoke(LocalDateTime.of(value.toLocalDate(), it)) },
            )
        }
    }
}
