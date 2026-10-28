package com.jade.pleos.compose

import android.os.SystemClock
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.geometry.*
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.*
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.*
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.*
import com.jade.pleos.tokens.*
import java.util.UUID
import kotlinx.coroutines.delay

sealed interface PleosDismissReason {
    data object Back : PleosDismissReason

    data object Outside : PleosDismissReason

    data object Timeout : PleosDismissReason

    data object CloseAction : PleosDismissReason

    data class Action(val actionId: String) : PleosDismissReason

    data object Replaced : PleosDismissReason
}

enum class PleosPopupSize {
    Medium,
    Large,
}

enum class PleosPopupMetricsPreset {
    Standard,
    Extended,
}

enum class PleosActionLayout {
    Single,
    Horizontal,
    Vertical,
}

data class PleosDismissPolicy(
    val back: Boolean = true,
    val outside: Boolean = true,
    val close: Boolean = false,
)

data class PleosPopupAction(
    val id: String,
    val label: String,
    val onClick: () -> Unit,
    val enabled: Boolean = true,
    val loading: Boolean = false,
)

/**
 * 03 §4 / P01. Medium 760dp·Large 1200dp를 가용 창에 맞춥니다. Standard/Extended와 CTA 배치를 선택합니다.
 * Back·Outside·CloseAction을 구분하며 업무 action은 호스트가 닫힘을 결정합니다. 원본 노드·binding 식별자는
 * tools/spec_inventory.json의 16_figma_popups.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한
 * 요청입니다.
 */
@Composable
fun PleosPopupSurface(
    title: String,
    confirmAction: PleosPopupAction?,
    modifier: Modifier = Modifier,
    size: PleosPopupSize = PleosPopupSize.Medium,
    metricsPreset: PleosPopupMetricsPreset = PleosPopupMetricsPreset.Standard,
    subtitle: String? = null,
    description: String? = null,
    icon: (@Composable () -> Unit)? = null,
    body: (@Composable () -> Unit)? = null,
    cancelAction: PleosPopupAction? = null,
    buttonAlign: PleosActionLayout = PleosActionLayout.Horizontal,
    onClose: (() -> Unit)? = null,
    bodyScroll: Boolean = true,
) {
    val extended = metricsPreset == PleosPopupMetricsPreset.Extended
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val pad =
        if (extended) m.dp("popup/system/extended/padding", 40f)
        else m.dp("popup/system/padding_large", 48f)
    val radius =
        if (extended) m.dp("popup/system/extended/radius", 40f)
        else m.dp("popup/system/radius_top_left", 48f)
    val gap =
        if (extended) m.dp("popup/system/extended/gap", 33f)
        else m.dp("popup/system/gap_extralarge", 40f)
    val width =
        m.dp(
            if (size == PleosPopupSize.Medium) "popup/medium/width" else "popup/large/width",
            if (size == PleosPopupSize.Medium) 760f else 1200f,
        )
    val headerBottom =
        if (extended) m.dp("popup/system/extended/header_padding_bottom", 12f)
        else m.dp("popup/system/padding_small", 16f)
    val hasHeader =
        title.isNotEmpty() ||
            subtitle != null ||
            description != null ||
            icon != null ||
            onClose != null
    val hasActions = confirmAction != null || cancelAction != null
    BoxWithConstraints(modifier.widthIn(max = width)) {
        val narrow = maxWidth < 600.dp || LocalDensity.current.fontScale > 1.4f
        val normalMaxHeight = m.dp("popup/system/max_height", 1152f)
        val tokenMaxHeight =
            if (extended)
                m.dp("popup/system/max_height_extended", 0f).takeIf { it > 0.dp } ?: normalMaxHeight
            else normalMaxHeight
        val maxH =
            if (maxHeight == Dp.Infinity) tokenMaxHeight else minOf(maxHeight, tokenMaxHeight)
        PleosSurface(
            Modifier.fillMaxWidth().heightIn(max = maxH),
            c["background/popup"],
            radius,
            c["divider/primary"],
            m.dp("popup/system/border", 2f),
            3,
        ) {
            // 액션을 먼저 측정하여 header/body가 커져도 접근 가능한 공간을 확보합니다.
            SubcomposeLayout(Modifier.fillMaxWidth().padding(pad)) { constraints ->
                val childWidth = constraints.maxWidth
                val available = constraints.maxHeight
                val spacing = gap.roundToPx()
                val actions =
                    if (!hasActions) null
                    else
                        subcompose("actions") {
                                PopupActions(
                                    confirmAction,
                                    cancelAction,
                                    buttonAlign,
                                    narrow,
                                    extended,
                                )
                            }
                            .single()
                            .measure(Constraints(0, childWidth, 0, available))
                val afterActions =
                    (available -
                            (actions?.height ?: 0) -
                            if (hasActions && (hasHeader || body != null)) spacing else 0)
                        .coerceAtLeast(0)
                val bodyReserve =
                    if (body != null) minOf(96.dp.roundToPx(), afterActions / 2) else 0
                val headerLimit =
                    (afterActions - bodyReserve - if (hasHeader && body != null) spacing else 0)
                        .coerceAtLeast(0)
                val header =
                    if (!hasHeader) null
                    else
                        subcompose("header") {
                                Column(
                                    Modifier.fillMaxWidth()
                                        .verticalScroll(rememberScrollState())
                                        .padding(bottom = headerBottom),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement =
                                        Arrangement.spacedBy(m.dp("popup/system/gap_large", 24f)),
                                ) {
                                    if (onClose != null) {
                                        val glyph = m.dp("popup/system/close_icon_square", 48f)
                                        PleosIconButton(
                                            "닫기",
                                            onClose,
                                            Modifier.align(Alignment.End),
                                            style = PleosIconButtonStyle.Plain,
                                            size = PleosButtonSize.Small,
                                            metrics =
                                                IconButtonMetrics(
                                                    smallSize =
                                                        maxOf(
                                                            glyph,
                                                            PleosTheme.behavior.minimumTouchTarget,
                                                        ),
                                                    smallIcon = glyph,
                                                ),
                                        ) {
                                            PleosIcon(CloseIcon, Modifier.fillMaxSize())
                                        }
                                    }
                                    if (icon != null)
                                        Box(
                                            Modifier.size(m.dp("popup/system/icon_square", 80f)),
                                            contentAlignment = Alignment.Center,
                                        ) {
                                            icon()
                                        }
                                    if (title.isNotEmpty())
                                        PleosText(
                                            title,
                                            Modifier.fillMaxWidth()
                                                .padding(
                                                    horizontal =
                                                        if (size == PleosPopupSize.Large)
                                                            m.dp(
                                                                "popup/system/header_padding_horizontal",
                                                                32f,
                                                            )
                                                        else 0.dp
                                                ),
                                            style = pleosTextStyle(40, 52, FontWeight.ExtraBold),
                                            textAlign = TextAlign.Center,
                                        )
                                    subtitle?.let {
                                        PleosText(
                                            it,
                                            Modifier.fillMaxWidth(),
                                            c["text/dark/secondary"],
                                            pleosTextStyle(36, 44, FontWeight.Bold),
                                            textAlign = TextAlign.Center,
                                        )
                                    }
                                    description?.let {
                                        PleosText(
                                            it,
                                            Modifier.fillMaxWidth(),
                                            c.scoped(.84f, "text/dark/secondary"),
                                            pleosTextStyle(30, 38),
                                            textAlign = TextAlign.Center,
                                        )
                                    }
                                }
                            }
                            .single()
                            .measure(Constraints(0, childWidth, 0, headerLimit))
                val bodyLimit =
                    (afterActions -
                            (header?.height ?: 0) -
                            if (hasHeader && body != null) spacing else 0)
                        .coerceAtLeast(0)
                val bodyPlaceable =
                    if (body == null) null
                    else
                        subcompose("body") {
                                Box(
                                    Modifier.fillMaxWidth()
                                        .then(
                                            if (bodyScroll)
                                                Modifier.verticalScroll(rememberScrollState())
                                            else Modifier
                                        )
                                ) {
                                    body()
                                }
                            }
                            .single()
                            .measure(Constraints(0, childWidth, 0, bodyLimit))
                val children =
                    listOfNotNull(header, bodyPlaceable, actions).filter { it.height > 0 }
                val count = (children.size - 1).coerceAtLeast(0)
                val actualSpacing =
                    if (count == 0) 0
                    else
                        minOf(
                            spacing,
                            ((available - children.sumOf { it.height }) / count).coerceAtLeast(0),
                        )
                val h =
                    (children.sumOf { it.height } + actualSpacing * count).coerceIn(
                        constraints.minHeight,
                        available,
                    )
                layout(childWidth, h) {
                    var y = 0
                    children.forEach { child ->
                        child.placeRelative(
                            0,
                            if (child === actions) (h - child.height).coerceAtLeast(0) else y,
                        )
                        y += child.height + actualSpacing
                    }
                }
            }
        }
    }
}

@Composable
private fun PopupActions(
    confirm: PleosPopupAction?,
    cancel: PleosPopupAction?,
    layout: PleosActionLayout,
    narrow: Boolean,
    extended: Boolean,
) {
    val actions =
        listOfNotNull(
            confirm?.let { it to true },
            cancel
                ?.takeIf { layout != PleosActionLayout.Single || confirm == null }
                ?.let { it to false },
        )
    val m = PleosTheme.metrics
    @Composable
    fun action(a: PleosPopupAction, primary: Boolean, modifier: Modifier) {
        PleosBasicButton(
            a.label,
            a.onClick,
            modifier,
            size = PleosButtonSize.Large,
            metrics =
                if (extended)
                    pleosButtonMetrics(PleosButtonSize.Large)
                        .copy(height = m.dp("popup/system/extended/button_height", 84f))
                else null,
            hierarchy =
                if (primary) PleosButtonHierarchy.Secondary else PleosButtonHierarchy.Primary,
            enabled = a.enabled,
            loading = a.loading,
        )
    }
    if ((layout == PleosActionLayout.Vertical || narrow) && actions.size > 1)
        Column(
            Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(m.dp("popup/system/gap_large", 24f)),
        ) {
            actions.forEach { (a, primary) -> action(a, primary, Modifier.fillMaxWidth()) }
        }
    else
        Row(
            Modifier.verticalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(m.dp("popup/system/gap_large", 24f)),
        ) {
            actions.forEach { (a, primary) -> action(a, primary, Modifier.weight(1f)) }
        }
}

/**
 * 03 §4 / P01. Medium 760dp·Large 1200dp를 가용 창에 맞춥니다. Standard/Extended와 CTA 배치를 선택합니다.
 * Back·Outside·CloseAction을 구분하며 업무 action은 호스트가 닫힘을 결정합니다. 원본 노드·binding 식별자는
 * tools/spec_inventory.json의 16_figma_popups.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한
 * 요청입니다.
 */
@Composable
fun PleosSystemPopup(
    title: String,
    confirmAction: PleosPopupAction?,
    onDismissRequest: (PleosDismissReason) -> Unit,
    modifier: Modifier = Modifier,
    size: PleosPopupSize = PleosPopupSize.Medium,
    metricsPreset: PleosPopupMetricsPreset = PleosPopupMetricsPreset.Standard,
    subtitle: String? = null,
    description: String? = null,
    icon: (@Composable () -> Unit)? = null,
    body: (@Composable () -> Unit)? = null,
    cancelAction: PleosPopupAction? = null,
    buttonAlign: PleosActionLayout = PleosActionLayout.Horizontal,
    dismissPolicy: PleosDismissPolicy = PleosDismissPolicy(),
    restoreFocusRequester: FocusRequester? = null,
    bodyScroll: Boolean = true,
) {
    var bounds by remember { mutableStateOf(Rect.Zero) }
    val dismiss by rememberUpdatedState(onDismissRequest)
    val policy by rememberUpdatedState(dismissPolicy)
    DisposableEffect(restoreFocusRequester) {
        onDispose { restoreFocusRequester?.let { runCatching { it.requestFocus() } } }
    }
    Dialog(
        onDismissRequest = { if (policy.back) dismiss(PleosDismissReason.Back) },
        properties =
            DialogProperties(
                dismissOnBackPress = dismissPolicy.back,
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false,
                decorFitsSystemWindows = false,
            ),
    ) {
        Box(
            Modifier.fillMaxSize()
                .onPreviewKeyEvent { event ->
                    if (event.key == Key.Escape) {
                        if (event.type == KeyEventType.KeyUp && policy.back)
                            dismiss(PleosDismissReason.Back)
                        true
                    } else false
                }
                .pointerInput(Unit) {
                    detectTapGestures {
                        if (policy.outside && !bounds.contains(it))
                            dismiss(PleosDismissReason.Outside)
                    }
                }
                .windowInsetsPadding(WindowInsets.safeDrawing.union(WindowInsets.ime))
                .padding(24.dp),
            contentAlignment = Alignment.Center,
        ) {
            PleosPopupSurface(
                title,
                confirmAction,
                modifier
                    .onGloballyPositioned { bounds = it.boundsInRoot() }
                    .semantics { paneTitle = title },
                size,
                metricsPreset,
                subtitle,
                description,
                icon,
                body,
                cancelAction,
                buttonAlign,
                if (dismissPolicy.close) {
                    { dismiss(PleosDismissReason.CloseAction) }
                } else null,
                bodyScroll = bodyScroll,
            )
        }
    }
}

sealed interface PleosToastDuration {
    data object Short : PleosToastDuration

    data object Long : PleosToastDuration

    data class Custom(val milliseconds: kotlin.Long) : PleosToastDuration {
        init {
            require(milliseconds > 0)
        }
    }
}

data class PleosToastMessage(
    val id: String,
    val message: String,
    val duration: PleosToastDuration = PleosToastDuration.Short,
    val icon: (@Composable () -> Unit)? = null,
    val onDismiss: ((PleosDismissReason) -> Unit)? = null,
    val generation: Long = 0,
)

/** FIFO, 최대 대기 수 제한, ID 중복 갱신. 타이머는 host의 수명 안에서만 실행됩니다. */
@Stable
class PleosToastHostState(val maxQueued: Int = 3) {
    init {
        require(maxQueued >= 0)
    }

    var current by mutableStateOf<PleosToastMessage?>(null)
        private set

    private val queue = mutableStateListOf<PleosToastMessage>()
    private var generation = 0L
    val queued: List<PleosToastMessage>
        get() = queue.toList()

    fun show(
        message: String,
        id: String = UUID.randomUUID().toString(),
        duration: PleosToastDuration = PleosToastDuration.Short,
        icon: (@Composable () -> Unit)? = null,
        onDismiss: ((PleosDismissReason) -> Unit)? = null,
    ) {
        if (message.isBlank()) {
            remove(id)
            return
        }
        val item = PleosToastMessage(id, message, duration, icon, onDismiss, ++generation)
        if (current == null || current?.id == id) {
            current = item
            return
        }
        val index = queue.indexOfFirst { it.id == id }
        if (index >= 0) {
            queue[index] = item
            return
        }
        if (maxQueued == 0) {
            item.onDismiss?.invoke(PleosDismissReason.Replaced)
            return
        }
        if (queue.size >= maxQueued)
            queue.removeAt(0).onDismiss?.invoke(PleosDismissReason.Replaced)
        queue.add(item)
    }

    /** 호스트가 표시 상태를 내렸거나 렌더러가 해제될 때 이벤트 없이 제거합니다. */
    fun remove(id: String) {
        if (current?.id == id) current = if (queue.isEmpty()) null else queue.removeAt(0)
        else queue.removeAll { it.id == id }
    }

    fun dismiss(id: String, reason: PleosDismissReason, expectedGeneration: Long? = null) {
        val item = current
        if (
            item?.id == id && (expectedGeneration == null || item.generation == expectedGeneration)
        ) {
            current = if (queue.isEmpty()) null else queue.removeAt(0)
            item.onDismiss?.invoke(reason)
        } else if (expectedGeneration == null) {
            val index = queue.indexOfFirst { it.id == id }
            if (index >= 0) queue.removeAt(index).onDismiss?.invoke(reason)
        }
    }
}

/**
 * 03 §12 / TO01. 기본 최대 대기는 3개입니다. FIFO·동일 ID 갱신·오래된 대기 교체를 적용합니다. host STARTED 이상에서만 남은 ms를 소모하며
 * generation으로 오래된 timer를 차단합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 16_figma_popups.md
 * 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun rememberPleosToastHostState(maxQueued: Int = PleosTheme.behavior.maxQueuedToasts) =
    remember(maxQueued) { PleosToastHostState(maxQueued) }

/**
 * 03 §12 / TO01. 기본 최대 대기는 3개입니다. FIFO·동일 ID 갱신·오래된 대기 교체를 적용합니다. host STARTED 이상에서만 남은 ms를 소모하며
 * generation으로 오래된 timer를 차단합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 16_figma_popups.md
 * 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosToastSurface(
    message: String,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    onClose: (() -> Unit)? = null,
) {
    if (message.isBlank()) {
        Box(modifier)
        return
    }
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    PleosSurface(
        modifier.widthIn(max = m.dp("popup/toast/max_width", 792f)).semantics {
            liveRegion = LiveRegionMode.Polite
        },
        if (c.dark) c["basic_600"]
        else androidx.compose.ui.graphics.Color(0xFF131417).copy(alpha = .84f),
        m.dp("popup/toast/radius_top_left", 16f),
    ) {
        CompositionLocalProvider(
            LocalPleosContentColor provides
                if (c.dark) c["basic_00"] else androidx.compose.ui.graphics.Color.White
        ) {
            Row(
                Modifier.padding(
                    horizontal = m.dp("popup/toast/padding_horizontal", 40f),
                    vertical = m.dp("popup/toast/padding_vertical", 24f),
                ),
                horizontalArrangement = Arrangement.spacedBy(m.dp("popup/toast/icon_gap", 16f)),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                icon?.let {
                    Box(
                        Modifier.size(m.dp("popup/toast/icon", 48f)),
                        contentAlignment = Alignment.Center,
                    ) {
                        it()
                    }
                }
                PleosText(
                    message,
                    Modifier.weight(1f, false)
                        .widthIn(max = m.dp("popup/toast/text_max_width", 712f)),
                    style = pleosTextStyle(26, 34, FontWeight.Bold),
                    textAlign = TextAlign.Center,
                )
                if (onClose != null)
                    PleosIconButton(
                        "알림 닫기",
                        onClose,
                        style = PleosIconButtonStyle.Plain,
                        size = PleosButtonSize.Small,
                    ) {
                        PleosIcon(CloseIcon, Modifier.fillMaxSize())
                    }
            }
        }
    }
}

@Composable
private fun ToastTimer(item: PleosToastMessage, onTimeout: () -> Unit) {
    val b = PleosTheme.behavior
    val millis =
        when (val d = item.duration) {
            PleosToastDuration.Short -> b.shortToastMillis
            PleosToastDuration.Long -> b.longToastMillis
            is PleosToastDuration.Custom -> d.milliseconds
        }
    val timeout =
        LocalAccessibilityManager.current?.calculateRecommendedTimeoutMillis(
            millis,
            item.icon != null,
            true,
            false,
        ) ?: millis
    val lifecycle by
        androidx.lifecycle.compose.LocalLifecycleOwner.current.lifecycle.currentStateAsState()
    val active = lifecycle.isAtLeast(Lifecycle.State.STARTED)
    var remaining by remember(item.id, item.generation, timeout) { mutableLongStateOf(timeout) }
    val callback by rememberUpdatedState(onTimeout)
    LaunchedEffect(item.id, item.generation, active, timeout) {
        if (active) {
            val start = SystemClock.uptimeMillis()
            try {
                delay(remaining)
                callback()
            } finally {
                remaining = (remaining - (SystemClock.uptimeMillis() - start)).coerceAtLeast(0)
            }
        }
    }
}

/**
 * 03 §12 / TO01. 기본 최대 대기는 3개입니다. FIFO·동일 ID 갱신·오래된 대기 교체를 적용합니다. host STARTED 이상에서만 남은 ms를 소모하며
 * generation으로 오래된 timer를 차단합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 16_figma_popups.md
 * 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosToastHost(
    state: PleosToastHostState,
    modifier: Modifier = Modifier,
    margin: Boolean = true,
) {
    Box(
        modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing.union(WindowInsets.ime))
            .then(
                if (margin) Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
                else Modifier
            ),
        contentAlignment = Alignment.BottomCenter,
    ) {
        state.current?.let { item ->
            key(item.id, item.generation) {
                ToastTimer(item) {
                    state.dismiss(item.id, PleosDismissReason.Timeout, item.generation)
                }
                PleosToastSurface(item.message, icon = item.icon)
            }
        }
    }
}

/**
 * 03 §12 / TO01. 기본 최대 대기는 3개입니다. FIFO·동일 ID 갱신·오래된 대기 교체를 적용합니다. host STARTED 이상에서만 남은 ms를 소모하며
 * generation으로 오래된 timer를 차단합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 16_figma_popups.md
 * 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosToast(state: PleosToastHostState, modifier: Modifier = Modifier) =
    PleosToastHost(state, modifier, true)

/**
 * 03 §5 / P02. visible 편의 API와 queue API가 같은 surface·timer를 사용합니다. Short 3000ms·Long 5000ms이며 접근성
 * timeout을 우선합니다. 인앱 표시입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 16_figma_popups.md 항목을
 * 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosToastPopup(
    state: PleosToastHostState,
    modifier: Modifier = Modifier,
    margin: Boolean = true,
) = PleosToastHost(state, modifier, margin)

data class PleosPopupRequest(
    val id: String,
    val title: String,
    val confirm: PleosPopupAction?,
    val cancel: PleosPopupAction? = null,
    val description: String? = null,
    val body: (@Composable () -> Unit)? = null,
    val onDismiss: (PleosDismissReason) -> Unit,
    val size: PleosPopupSize = PleosPopupSize.Medium,
    val policy: PleosDismissPolicy = PleosDismissPolicy(),
    val bodyScroll: Boolean = true,
)

@Stable
class PleosOverlayHostState(
    val toasts: PleosToastHostState = PleosToastHostState(),
    val notifications: PleosNotificationHostState = PleosNotificationHostState(),
) {
    var popup by mutableStateOf<PleosPopupRequest?>(null)
        private set

    fun showPopup(request: PleosPopupRequest) {
        val previous = popup
        popup = request
        if (previous != null && previous.id != request.id)
            previous.onDismiss(PleosDismissReason.Replaced)
    }

    fun dismissPopup(id: String, reason: PleosDismissReason) {
        val current = popup
        if (current?.id == id) {
            popup = null
            current.onDismiss(reason)
        }
    }
}

/**
 * 04 §1 / Overlay. 한 host 안에서 popup·toast·인앱 알림의 상태와 수명을 관리합니다. OS 전역 overlay 권한을 요구하지 않습니다. 상태·수명
 * 계약은 docs/04_AAOS_API_AND_ACCEPTANCE.md §1~3을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한
 * 요청입니다.
 */
@Composable
fun PleosOverlayHost(
    state: PleosOverlayHostState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(modifier) {
        content()
        if (state.notifications.notifications.isNotEmpty())
            PleosSystemNotificationHost(state.notifications, Modifier.align(Alignment.TopCenter))
        PleosToastHost(state.toasts)
    }
    state.popup?.let { request ->
        key(request.id) {
            PleosSystemPopup(
                request.title,
                request.confirm,
                { state.dismissPopup(request.id, it) },
                size = request.size,
                description = request.description,
                body = request.body,
                cancelAction = request.cancel,
                dismissPolicy = request.policy,
                bodyScroll = request.bodyScroll,
            )
        }
    }
}

/**
 * 03 §5 / P02. visible 편의 API와 queue API가 같은 surface·timer를 사용합니다. Short 3000ms·Long 5000ms이며 접근성
 * timeout을 우선합니다. 인앱 표시입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 16_figma_popups.md 항목을
 * 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosToastPopup(
    visible: Boolean,
    message: String,
    onDismiss: (PleosDismissReason) -> Unit,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    duration: PleosToastDuration = PleosToastDuration.Short,
    margin: Boolean = true,
    id: String = remember { UUID.randomUUID().toString() },
    state: PleosToastHostState = rememberPleosToastHostState(),
) {
    val callback by rememberUpdatedState(onDismiss)
    val latestIcon by rememberUpdatedState(icon)
    val stableIcon: (@Composable () -> Unit)? =
        if (icon == null) null else remember { { latestIcon?.invoke() } }
    LaunchedEffect(visible, id, message, duration, icon != null) {
        if (visible) state.show(message, id, duration, stableIcon) { callback(it) }
        else state.remove(id)
    }
    DisposableEffect(state, id) { onDispose { state.remove(id) } }
    PleosToastHost(state, modifier, margin)
}

/** 03 §12의 메시지 surface API입니다. 수명·배치가 필요하면 state 오버로드 또는 PleosToastHost를 사용합니다. */
@Composable
fun PleosToast(
    message: String,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    onClose: (() -> Unit)? = null,
) = PleosToastSurface(message, modifier, leadingIcon, onClose)
