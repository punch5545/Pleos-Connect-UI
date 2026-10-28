package com.jade.pleos.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.jade.pleos.tokens.*
import kotlin.math.abs

sealed interface PleosNotificationImagery {
    data object None : PleosNotificationImagery

    data class App(val painter: Painter?, val description: String? = null) :
        PleosNotificationImagery

    data class Profile(
        val painter: Painter?,
        val badge: Painter?,
        val description: String? = null,
    ) : PleosNotificationImagery

    data class Image(val painter: Painter?, val description: String? = null) :
        PleosNotificationImagery
}

enum class PleosNotificationKind {
    ImageText,
    OnlyText,
    Call,
}

@Composable
private fun NotificationImagery(imagery: PleosNotificationImagery) {
    if (imagery == PleosNotificationImagery.None) return
    val painter =
        when (imagery) {
            is PleosNotificationImagery.App -> imagery.painter
            is PleosNotificationImagery.Profile -> imagery.painter
            is PleosNotificationImagery.Image -> imagery.painter
            else -> null
        }
    val description =
        when (imagery) {
            is PleosNotificationImagery.App -> imagery.description
            is PleosNotificationImagery.Profile -> imagery.description
            is PleosNotificationImagery.Image -> imagery.description
            else -> null
        }
    val m = PleosTheme.metrics
    val size = m.dp("notification/system/imagary_square", 100f)
    val badge = m.dp("notification/system/profile/app_square", 48f)
    val badgeOffset = size - badge + m.dp("notification/system/profile/badge_overhang", 8f)
    Box(Modifier.size(size)) {
        val shape =
            if (imagery is PleosNotificationImagery.Profile) CircleShape
            else RoundedCornerShape(m.dp("notification/system/images/radius_top_left", 24f))
        Box(Modifier.fillMaxSize().clip(shape).background(PleosTheme.colors["surface/high"])) {
            if (painter != null)
                Image(
                    painter,
                    description,
                    Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
        }
        if (imagery is PleosNotificationImagery.Profile)
            PleosSurface(
                Modifier.offset(badgeOffset, badgeOffset).size(badge),
                radius = m.dp("notification/system/profile/app_radius_top_left", 16f),
                shadowLevel = 2,
            ) {
                imagery.badge?.let {
                    Image(it, null, Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                }
            }
    }
}

/**
 * 03 §11 / SN01. CTA ID는 유일하고 1~2개입니다. Single은 1개·Call은 2개가 필요합니다. 이 API는 인앱 카드이며 실제 OS 알림 제출은 AAOS
 * adapter에서 수행합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 20_figma_notification.md 항목을
 * 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosSystemNotificationCard(
    title: String,
    description: String?,
    actions: List<PleosPopupAction>,
    modifier: Modifier = Modifier,
    imagery: PleosNotificationImagery = PleosNotificationImagery.None,
    actionLayout: PleosActionLayout = PleosActionLayout.Horizontal,
    kind: PleosNotificationKind = PleosNotificationKind.ImageText,
    onDismiss: (() -> Unit)? = null,
) {
    require(actions.map { it.id }.distinct().size == actions.size)
    require(actions.size in 1..2)
    if (actionLayout == PleosActionLayout.Single) require(actions.size == 1)
    if (kind == PleosNotificationKind.Call) require(actions.size == 2)
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    PleosSurface(
        modifier.widthIn(max = PleosTheme.metrics.dp("notification/system/width", 700f)).semantics {
            liveRegion = LiveRegionMode.Polite
        },
        c["gleo_surface_primary"],
        m.dp("notification/system/radius_top_left", 48f),
        c["divider/secondary"],
        m.dp("notification/border", 1f),
        3,
    ) {
        Column {
            val textMinimum =
                with(LocalDensity.current) {
                    pleosTextStyle(36, 44).lineHeight.toDp() +
                        pleosTextStyle(26, 34).lineHeight.toDp()
                } +
                    m.dp("notification/system/text_gap_vertical", 12f) +
                    m.dp("notification/system/text_padding_top", 4f)
            val headerContent =
                if (kind == PleosNotificationKind.OnlyText) textMinimum
                else m.dp("notification/system/imagary_square", 100f)
            Row(
                Modifier.fillMaxWidth()
                    .heightIn(
                        min =
                            headerContent +
                                m.dp("notification/padding_large", 32f) +
                                m.dp("notification/padding_small", 16f)
                    )
                    .padding(
                        start = m.dp("notification/padding_large", 32f),
                        end = m.dp("notification/padding_large", 32f),
                        top = m.dp("notification/padding_large", 32f),
                        bottom = m.dp("notification/padding_small", 16f),
                    ),
                horizontalArrangement = Arrangement.spacedBy(m.dp("notification/gap_large", 24f)),
                verticalAlignment = Alignment.Top,
            ) {
                if (kind != PleosNotificationKind.OnlyText) NotificationImagery(imagery)
                Column(
                    Modifier.weight(1f)
                        .padding(top = m.dp("notification/system/text_padding_top", 4f)),
                    verticalArrangement =
                        Arrangement.spacedBy(m.dp("notification/system/text_gap_vertical", 12f)),
                ) {
                    PleosText(title, style = pleosTextStyle(36, 44, FontWeight.ExtraBold))
                    description?.let {
                        PleosText(
                            it,
                            color = c.scoped(.64f, "text/dark/tertiary"),
                            style = pleosTextStyle(26, 34),
                        )
                    }
                }
                if (onDismiss != null)
                    PleosIconButton(
                        "알림 닫기",
                        onDismiss,
                        size = PleosButtonSize.Small,
                        style = PleosIconButtonStyle.Plain,
                    ) {
                        PleosIcon(CloseIcon, Modifier.fillMaxSize())
                    }
            }
            BoxWithConstraints(
                Modifier.fillMaxWidth().padding(m.dp("notification/padding_medium", 24f))
            ) {
                val vertical =
                    actionLayout == PleosActionLayout.Vertical ||
                        maxWidth < 480.dp ||
                        LocalDensity.current.fontScale > 1.5f
                @Composable
                fun action(a: PleosPopupAction, index: Int, mod: Modifier) {
                    if (kind != PleosNotificationKind.Call)
                        PleosBasicButton(
                            a.label,
                            a.onClick,
                            mod,
                            size = PleosButtonSize.Medium,
                            enabled = a.enabled,
                            loading = a.loading,
                        )
                    else {
                        val source = remember {
                            androidx.compose.foundation.interaction.MutableInteractionSource()
                        }
                        val pressed by source.collectIsPressedAsState()
                        PleosSurface(
                            actionModifier(
                                    mod.heightIn(
                                        min = pleosButtonMetrics(PleosButtonSize.Medium).height
                                    ),
                                    source,
                                    a.enabled,
                                    24.dp,
                                    a.onClick,
                                    blocked = a.loading,
                                )
                                .semantics {
                                    if (a.loading) {
                                        contentDescription = a.label
                                        stateDescription = "처리 중"
                                    }
                                },
                            c[
                                if (!a.enabled) "button/basic/disabled"
                                else if (index == 0)
                                    if (pressed) "phone_call_pressed" else "phone_call_normal"
                                else if (pressed) "phone_end_pressed" else "phone_end_normal"],
                            24.dp,
                        ) {
                            Box(Modifier.align(Alignment.Center).alpha(if (a.loading) 0f else 1f)) {
                                PleosText(
                                    a.label,
                                    Modifier.align(Alignment.Center).padding(16.dp),
                                    if (a.enabled) Color.White else c["text/dark/quaternary"],
                                    pleosTextStyle(30, 38, FontWeight.Bold),
                                    maxLines = 2,
                                )
                            }
                            if (a.loading)
                                PleosLoadingIndicator(Modifier.size(32.dp).align(Alignment.Center))
                        }
                    }
                }
                if (vertical)
                    Column(
                        verticalArrangement =
                            Arrangement.spacedBy(m.dp("notification/gap_medium", 16f))
                    ) {
                        actions.forEachIndexed { i, a -> action(a, i, Modifier.fillMaxWidth()) }
                    }
                else
                    Row(
                        horizontalArrangement =
                            Arrangement.spacedBy(m.dp("notification/gap_medium", 16f))
                    ) {
                        actions.forEachIndexed { i, a -> action(a, i, Modifier.weight(1f)) }
                    }
            }
        }
    }
}

/** 인앱 알림 목록의 상태는 stable ID로 유지합니다. */
@Stable
class PleosNotificationHostState {
    private val entries = mutableStateListOf<PleosInAppNotification>()
    val notifications: List<PleosInAppNotification>
        get() = entries.toList()

    fun post(notification: PleosInAppNotification) {
        val i = entries.indexOfFirst { it.id == notification.id }
        if (i < 0) entries.add(notification) else entries[i] = notification
    }

    fun dismiss(id: String) {
        entries.removeAll { it.id == id }
    }
}

data class PleosInAppNotification(
    val id: String,
    val title: String,
    val description: String?,
    val actions: List<PleosPopupAction>,
    val imagery: PleosNotificationImagery = PleosNotificationImagery.None,
    val layout: PleosActionLayout = PleosActionLayout.Horizontal,
    val kind: PleosNotificationKind = PleosNotificationKind.ImageText,
)

/**
 * 03 §11 / SN01. CTA ID는 유일하고 1~2개입니다. Single은 1개·Call은 2개가 필요합니다. 이 API는 인앱 카드이며 실제 OS 알림 제출은 AAOS
 * adapter에서 수행합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 20_figma_notification.md 항목을
 * 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosSystemNotificationHost(state: PleosNotificationHostState, modifier: Modifier = Modifier) {
    Column(
        modifier
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        state.notifications.forEach { n ->
            key(n.id) {
                PleosSystemNotificationCard(
                    n.title,
                    n.description,
                    n.actions,
                    imagery = n.imagery,
                    actionLayout = n.layout,
                    kind = n.kind,
                    onDismiss = { state.dismiss(n.id) },
                )
            }
        }
    }
}

enum class PleosWidgetVisibility {
    Show,
    Hidden,
}

data class PleosWidgetMetrics(
    val width: Dp = 792.dp,
    val height: Dp = 176.dp,
    val radius: Dp = 32.dp,
    val hiddenWidth: Dp = 160.dp,
    val hiddenHeight: Dp = 64.dp,
    val handleHitWidth: Dp = 240.dp,
    val hiddenHitHeight: Dp = 80.dp,
    val hideFraction: Float = .35f,
    val handleHitHeight: Dp = 60.dp,
    val hiddenRadius: Dp = 32.dp,
)

/** 03 §13의 별도 보완 서체입니다. 공통 24/28 Label 토큰과 분리합니다. */
data class WidgetTitleTypography(
    val fontSize: TextUnit = 24.sp,
    val lineHeight: TextUnit = 32.sp,
    val weight: FontWeight = FontWeight.Bold,
)

data class PleosWidgetItem(
    val key: String,
    val title: String,
    val action: (@Composable () -> Unit)? = null,
    val information: @Composable () -> Unit,
)

/**
 * 03 §13 / W01. item key는 유일하고 hideFraction은 0~1입니다. 페이지와 Show/Hidden은 호스트가 소유합니다. 터치 방향 잠금 및 접근성
 * 대체 action을 제공하는 인앱 HMI 카드입니다. 공통 근거는 docs/03_FIELDS_NAVIGATION_FEEDBACK.md §13이며 원본 식별자는
 * tools/spec_inventory.json에 보존합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosWidgetCard(
    title: String,
    modifier: Modifier = Modifier,
    action: (@Composable () -> Unit)? = null,
    information: @Composable () -> Unit,
    pagination: (@Composable () -> Unit)? = null,
    handle: (@Composable () -> Unit)? = null,
    metrics: PleosWidgetMetrics = PleosWidgetMetrics(),
    titleTypography: WidgetTitleTypography = WidgetTitleTypography(),
) {
    val c = PleosTheme.colors
    val titleStyle =
        pleosTextStyle(24, 32, titleTypography.weight)
            .copy(fontSize = titleTypography.fontSize, lineHeight = titleTypography.lineHeight)
    BoxWithConstraints(modifier.widthIn(max = metrics.width)) {
        val narrow = maxWidth < 720.dp
        PleosSurface(
            Modifier.fillMaxWidth().heightIn(min = metrics.height),
            c["basic_00"],
            metrics.radius,
            c["divider/secondary"],
            1.dp,
            2,
        ) {
            if (narrow)
                Column(
                    Modifier.padding(start = 24.dp, end = 24.dp, top = 40.dp, bottom = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    PleosText(title, style = titleStyle)
                    information()
                    action?.invoke()
                    pagination?.invoke()
                }
            else
                Row(
                    Modifier.padding(start = 24.dp, end = 24.dp, top = 40.dp, bottom = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    verticalAlignment = Alignment.Top,
                ) {
                    Column(
                        Modifier.width(224.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        PleosText(title, style = titleStyle)
                        if (action != null) Box(Modifier.heightIn(min = 64.dp)) { action() }
                    }
                    Column(Modifier.weight(1f).heightIn(min = 112.dp)) {
                        information()
                        pagination?.invoke()
                    }
                }
            Box(Modifier.align(Alignment.TopCenter)) {
                if (handle != null) handle()
                else
                    Box(
                        Modifier.padding(top = 12.dp)
                            .size(86.dp, 6.dp)
                            .background(c["basic_alpha_dark_200"], RoundedCornerShape(3.dp))
                    )
            }
        }
    }
}

/**
 * 03 §13 / W01. item key는 유일하고 hideFraction은 0~1입니다. 페이지와 Show/Hidden은 호스트가 소유합니다. 터치 방향 잠금 및 접근성
 * 대체 action을 제공하는 인앱 HMI 카드입니다. 공통 근거는 docs/03_FIELDS_NAVIGATION_FEEDBACK.md §13이며 원본 식별자는
 * tools/spec_inventory.json에 보존합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosWidgetHost(
    items: List<PleosWidgetItem>,
    currentKey: String?,
    onCurrentChanged: (String) -> Unit,
    visibility: PleosWidgetVisibility,
    onVisibilityChange: (PleosWidgetVisibility) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    metrics: PleosWidgetMetrics =
        PleosWidgetMetrics(hideFraction = PleosTheme.behavior.widgetHideFraction),
    emptyContent: (@Composable () -> Unit)? = null,
    titleTypography: WidgetTitleTypography = WidgetTitleTypography(),
) {
    require(items.map { it.key }.distinct().size == items.size && metrics.hideFraction in 0f..1f)
    val handleSource = remember {
        androidx.compose.foundation.interaction.MutableInteractionSource()
    }
    val hostSource = remember { androidx.compose.foundation.interaction.MutableInteractionSource() }
    var rootFocused by remember { mutableStateOf(false) }
    var handleTouching by remember { mutableStateOf(false) }
    var handleDragging by remember { mutableStateOf(false) }
    var handleKeyDown by remember { mutableStateOf(false) }
    var shellHeight by remember { mutableIntStateOf(0) }
    val handlePressed by handleSource.collectIsPressedAsState()
    val index = items.indexOfFirst { it.key == currentKey }
    val c = PleosTheme.colors
    val rtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    val density = LocalDensity.current
    val latestPage by rememberUpdatedState(onCurrentChanged)
    val latestVisibility by rememberUpdatedState(onVisibilityChange)
    fun canPage(delta: Int): Boolean =
        enabled &&
            visibility == PleosWidgetVisibility.Show &&
            index >= 0 &&
            index + delta in items.indices
    fun page(delta: Int): Boolean {
        if (!canPage(delta)) return false
        latestPage(items[index + delta].key)
        return true
    }
    val pageRequest by rememberUpdatedState<(Int) -> Boolean>({ page(it) })
    val host =
        modifier
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .onFocusChanged { rootFocused = it.isFocused }
            .semantics {
                stateDescription =
                    if (visibility == PleosWidgetVisibility.Hidden) "위젯 숨김" else "위젯 표시"
                if (!enabled) disabled()
                else
                    customActions = buildList {
                        if (visibility == PleosWidgetVisibility.Show) {
                            add(CustomAccessibilityAction("이전 위젯") { page(-1) })
                            add(CustomAccessibilityAction("다음 위젯") { page(1) })
                        }
                        add(
                            CustomAccessibilityAction(
                                if (visibility == PleosWidgetVisibility.Show) "숨기기" else "펼치기"
                            ) {
                                latestVisibility(
                                    if (visibility == PleosWidgetVisibility.Show)
                                        PleosWidgetVisibility.Hidden
                                    else PleosWidgetVisibility.Show
                                )
                                true
                            }
                        )
                    }
            }
            .onKeyEvent { e ->
                val delta =
                    when (e.key) {
                        Key.DirectionLeft -> if (rtl) 1 else -1
                        Key.DirectionRight -> if (rtl) -1 else 1
                        else -> 0
                    }
                val nextVisibility =
                    when (e.key) {
                        Key.DirectionDown -> PleosWidgetVisibility.Hidden
                        Key.DirectionUp -> PleosWidgetVisibility.Show
                        else -> visibility
                    }
                val handles =
                    rootFocused &&
                        enabled &&
                        (if (delta != 0) canPage(delta) else nextVisibility != visibility)
                if (!handles) false
                else {
                    if (e.type == KeyEventType.KeyUp) {
                        if (delta != 0) page(delta) else latestVisibility(nextVisibility)
                    }
                    true
                }
            }
    if (visibility == PleosWidgetVisibility.Hidden) {
        Box(
            actionModifier(
                host.size(metrics.handleHitWidth, metrics.hiddenHitHeight).semantics {
                    contentDescription = "위젯 펼치기"
                },
                handleSource,
                enabled,
                metrics.hiddenRadius,
                { latestVisibility(PleosWidgetVisibility.Show) },
            ),
            contentAlignment = Alignment.BottomCenter,
        ) {
            Box(
                Modifier.size(metrics.hiddenWidth, metrics.hiddenHeight)
                    .clip(
                        RoundedCornerShape(
                            topStart = metrics.hiddenRadius,
                            topEnd = metrics.hiddenRadius,
                        )
                    )
                    .background(
                        c[
                            if (enabled && handlePressed) "button/basic/pressed"
                            else "background/popup"]
                    ),
                contentAlignment = Alignment.Center,
            ) {
                PleosIcon(R.drawable.pleos_ic_arrow_direction_up__67_22102, Modifier.size(48.dp))
            }
        }
    } else if (index < 0) {
        Box(host.focusIndication(hostSource, metrics.radius).focusable(enabled, hostSource)) {
            if (emptyContent != null) emptyContent() else PleosText("표시할 위젯이 없습니다.")
        }
    } else {
        val item = items[index]
        PleosWidgetCard(
            item.title,
            host
                .focusIndication(hostSource, metrics.radius)
                .focusable(enabled, hostSource)
                .onSizeChanged { shellHeight = it.height }
                .pointerInput(enabled, index, items.map { it.key }, rtl) {
                    if (enabled) {
                        var distance = 0f
                        detectHorizontalDragGestures(
                            onDragStart = { distance = 0f },
                            onDragCancel = { distance = 0f },
                            onDragEnd = {
                                if (abs(distance) >= size.width * .15f)
                                    pageRequest(if ((distance < 0) != rtl) 1 else -1)
                            },
                        ) { event, amount ->
                            distance += amount
                            event.consume()
                        }
                    }
                },
            item.action,
            item.information,
            pagination = {
                PleosPageIndicator(
                    items.size,
                    index,
                    size = PleosIndicatorSize.Narrow,
                    dotGap = 10.dp,
                )
            },
            handle = {
                Box(
                    Modifier.size(metrics.handleHitWidth, metrics.handleHitHeight)
                        .observeControlPress(enabled) { handleTouching = it }
                        .onFocusChanged { if (!it.isFocused) handleKeyDown = false }
                        .focusIndication(handleSource, 4.dp)
                        .onKeyEvent { e ->
                            if (
                                !enabled ||
                                    e.key !in listOf(Key.Enter, Key.DirectionCenter, Key.Spacebar)
                            )
                                false
                            else {
                                if (e.type == KeyEventType.KeyDown) handleKeyDown = true
                                if (e.type == KeyEventType.KeyUp && handleKeyDown) {
                                    handleKeyDown = false
                                    latestVisibility(PleosWidgetVisibility.Hidden)
                                }
                                true
                            }
                        }
                        .focusable(enabled, handleSource)
                        .semantics {
                            contentDescription = "위젯 숨기기"
                            role = Role.Button
                            if (!enabled) disabled()
                            else
                                onClick("숨기기") {
                                    latestVisibility(PleosWidgetVisibility.Hidden)
                                    true
                                }
                        }
                        .pointerInput(enabled, metrics, shellHeight) {
                            if (enabled) {
                                var distance = 0f
                                try {
                                    detectVerticalDragGestures(
                                        onDragStart = { distance = 0f },
                                        onDragCancel = { handleDragging = false },
                                        onDragEnd = {
                                            val height =
                                                if (shellHeight > 0) shellHeight.toFloat()
                                                else with(density) { metrics.height.toPx() }
                                            if (distance >= height * metrics.hideFraction)
                                                latestVisibility(PleosWidgetVisibility.Hidden)
                                            handleDragging = false
                                        },
                                    ) { event, amount ->
                                        handleDragging = true
                                        distance += amount
                                        event.consume()
                                    }
                                } finally {
                                    handleDragging = false
                                }
                            }
                        },
                    contentAlignment = Alignment.TopCenter,
                ) {
                    Box(
                        Modifier.padding(top = 12.dp)
                            .size(86.dp, 6.dp)
                            .background(
                                c["basic_900"].copy(
                                    alpha =
                                        if (
                                            enabled &&
                                                (handleTouching || handleDragging || handleKeyDown)
                                        )
                                            .5f
                                        else .2f
                                ),
                                RoundedCornerShape(3.dp),
                            )
                    )
                }
            },
            metrics = metrics,
            titleTypography = titleTypography,
        )
    }
}
