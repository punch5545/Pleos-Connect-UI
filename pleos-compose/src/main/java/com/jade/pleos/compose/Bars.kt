package com.jade.pleos.compose

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.*
import androidx.compose.ui.semantics.*
import androidx.compose.ui.unit.*
import com.jade.pleos.tokens.*
import kotlin.math.*

data class PleosScrollGeometry(
    val thumbLength: Float,
    val thumbOffset: Float,
    val maxOffset: Float,
)

/**
 * 02 §7 / B01. extent·offset·track은 같은 단위입니다. UI 콜백은 pixel offset입니다. 유한한 음수가 아닌 extent·track·최소
 * thumb와 유한한 offset을 요구합니다. offset은 clamp하고 content≤viewport는 스크롤을 차단합니다. 원본 노드·binding 식별자는
 * tools/spec_inventory.json의 21_figma_bars.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한
 * 요청입니다.
 */
fun pleosScrollGeometry(
    viewport: Float,
    content: Float,
    offset: Float,
    track: Float,
    minThumb: Float = 48f,
): PleosScrollGeometry {
    require(
        listOf(viewport, content, offset, track, minThumb).all { it.isFinite() } &&
            viewport >= 0 &&
            content >= 0 &&
            track >= 0 &&
            minThumb >= 0
    )
    val max = (content - viewport).coerceAtLeast(0f)
    val length =
        if (max == 0f) track
        else
            (track.toDouble() * viewport / content)
                .toFloat()
                .coerceIn(minThumb.coerceAtMost(track), track)
    return PleosScrollGeometry(
        length,
        if (max == 0f) 0f else offset.coerceIn(0f, max) / max * (track - length),
        max,
    )
}

/** 포인터를 소비하지 않고 down/up/cancel의 표시 상태만 관찰합니다. */
internal fun Modifier.observeControlPress(enabled: Boolean, onPressed: (Boolean) -> Unit) =
    pointerInput(enabled) {
        if (enabled)
            awaitEachGesture {
                awaitFirstDown(requireUnconsumed = false, pass = PointerEventPass.Initial)
                onPressed(true)
                try {
                    do {
                        val event = awaitPointerEvent(PointerEventPass.Initial)
                    } while (event.changes.any { it.pressed })
                } finally {
                    onPressed(false)
                }
            }
    }

/**
 * 02 §7 / B01. drag delta는 물리 pixel입니다. 실제 창 이동·크기 변경은 호스트 콜백으로 전달합니다. cancel은 commit과 구분합니다. 원본
 * 노드·binding 식별자는 tools/spec_inventory.json의 21_figma_bars.md 및 22_figma_display_support.md 항목을
 * 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosWindowControlBar(
    onDragDelta: (Offset) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onDragStart: (() -> Unit)? = null,
    onDragEnd: (() -> Unit)? = null,
    onDragCancel: (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    var dragging by remember { mutableStateOf(false) }
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    var touching by remember { mutableStateOf(false) }
    var editing by remember { mutableStateOf(false) }
    val active = enabled
    val m = PleosTheme.metrics
    val motion = !PleosTheme.behavior.reducedMotion && LocalPleosCapabilities.current.animations
    val density = androidx.compose.ui.platform.LocalDensity.current
    val held = dragging || pressed || touching
    val length by
        animateDpAsState(
            m.dp(
                if (held) "window/handle/pressed_length" else "window/handle/enabled_length",
                if (held) 100f else 140f,
            ),
            tween(if (motion) 300 else 0, easing = CubicBezierEasing(.16f, 1f, .3f, 1f)),
            label = "windowHandle",
        )
    val alpha by
        animateFloatAsState(
            if (!active) 0f else if (held) .5f else .2f,
            tween(if (motion) 300 else 0, easing = CubicBezierEasing(.16f, 1f, .3f, 1f)),
            label = "windowAlpha",
        )
    val color = PleosTheme.colors["basic_900"].copy(alpha = alpha)
    val delta by rememberUpdatedState(onDragDelta)
    val start by rememberUpdatedState(onDragStart)
    val end by rememberUpdatedState(onDragEnd)
    val cancel by rememberUpdatedState(onDragCancel)
    fun adjustOnce(amount: Offset): Boolean {
        if (!active) return false
        start?.invoke()
        delta(amount)
        end?.invoke()
        return true
    }
    DisposableEffect(active) {
        onDispose {
            if (dragging) {
                dragging = false
                cancel?.invoke()
            }
        }
    }
    val base =
        modifier
            .sizeIn(minWidth = 48.dp, minHeight = 200.dp)
            .observeControlPress(active) { touching = it }
            .semantics {
                contentDescription = "창 크기 조절"
                if (!active) disabled()
                if (active)
                    customActions =
                        listOf(
                            CustomAccessibilityAction("왼쪽으로 조절") {
                                adjustOnce(Offset(with(density) { -48.dp.toPx() }, 0f))
                            },
                            CustomAccessibilityAction("오른쪽으로 조절") {
                                adjustOnce(Offset(with(density) { 48.dp.toPx() }, 0f))
                            },
                        )
            }
            .pointerInput(active) {
                if (active)
                    try {
                        detectDragGestures(
                            onDragStart = {
                                dragging = true
                                start?.invoke()
                            },
                            onDragEnd = {
                                dragging = false
                                end?.invoke()
                            },
                            onDragCancel = {
                                if (dragging) {
                                    dragging = false
                                    cancel?.invoke()
                                }
                            },
                        ) { change, amount ->
                            change.consume()
                            delta(amount)
                        }
                    } finally {
                        if (dragging) {
                            dragging = false
                            cancel?.invoke()
                        }
                    }
            }
    Box(
        if (onClick != null) actionModifier(base, source, active, 4.dp, onClick)
        else
            base
                .onFocusChanged { if (!it.isFocused) editing = false }
                .onKeyEvent { event ->
                    if (!active) false
                    else if (event.key == Key.Enter || event.key == Key.DirectionCenter) {
                        if (event.type == KeyEventType.KeyUp) editing = !editing
                        true
                    } else if (editing && (event.key == Key.Back || event.key == Key.Escape)) {
                        if (event.type == KeyEventType.KeyUp) editing = false
                        true
                    } else if (
                        editing &&
                            event.key in
                                listOf(
                                    Key.DirectionLeft,
                                    Key.DirectionRight,
                                    Key.DirectionUp,
                                    Key.DirectionDown,
                                )
                    ) {
                        if (event.type == KeyEventType.KeyDown) {
                            val step = with(density) { 48.dp.toPx() }
                            adjustOnce(
                                when (event.key) {
                                    Key.DirectionLeft -> Offset(-step, 0f)
                                    Key.DirectionRight -> Offset(step, 0f)
                                    Key.DirectionUp -> Offset(0f, -step)
                                    else -> Offset(0f, step)
                                }
                            )
                        }
                        true
                    } else false
                }
                .focusable(active, source)
                .focusIndication(source, 4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Box(Modifier.size(4.dp, length).background(color, RoundedCornerShape(2.dp)))
    }
}

/**
 * 02 §7 / B01. drag delta는 물리 pixel입니다. 실제 창 이동·크기 변경은 호스트 콜백으로 전달합니다. cancel은 commit과 구분합니다. 원본
 * 노드·binding 식별자는 tools/spec_inventory.json의 21_figma_bars.md 및 22_figma_display_support.md 항목을
 * 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosAppControlBar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onDragDelta: ((Offset) -> Unit)? = null,
    onDragEnd: (() -> Unit)? = null,
    onDragCancel: (() -> Unit)? = null,
) {
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    var dragging by remember { mutableStateOf(false) }
    val latestDrag by rememberUpdatedState(onDragDelta)
    val latestEnd by rememberUpdatedState(onDragEnd)
    val latestCancel by rememberUpdatedState(onDragCancel)
    Box(
        actionModifier(modifier.size(320.dp, 60.dp), source, enabled, 4.dp, onClick).pointerInput(
            enabled,
            onDragDelta != null,
        ) {
            if (enabled && latestDrag != null)
                try {
                    detectDragGestures(
                        onDragStart = { dragging = true },
                        onDragEnd = {
                            dragging = false
                            latestEnd?.invoke()
                        },
                        onDragCancel = {
                            if (dragging) {
                                dragging = false
                                latestCancel?.invoke()
                            }
                        },
                    ) { change, amount ->
                        change.consume()
                        latestDrag?.invoke(amount)
                    }
                } finally {
                    if (dragging) {
                        dragging = false
                        latestCancel?.invoke()
                    }
                }
        },
        contentAlignment = Alignment.TopCenter,
    ) {
        Box(
            Modifier.padding(top = 16.dp)
                .size(140.dp, 8.dp)
                .background(
                    PleosTheme.colors["basic_900"].copy(
                        alpha = if (!enabled) 0f else if (pressed || dragging) .5f else .2f
                    ),
                    RoundedCornerShape(4.dp),
                )
        )
    }
}

/**
 * 02 §7 / B01. extent·offset·track은 같은 단위입니다. UI 콜백은 pixel offset입니다. 유한한 음수가 아닌 extent·track·최소
 * thumb와 유한한 offset을 요구합니다. offset은 clamp하고 content≤viewport는 스크롤을 차단합니다. 원본 노드·binding 식별자는
 * tools/spec_inventory.json의 21_figma_bars.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한
 * 요청입니다.
 */
@Composable
fun PleosScrollBar(
    viewportExtent: Float,
    contentExtent: Float,
    scrollOffset: Float,
    modifier: Modifier = Modifier,
    onScrollTo: ((Float) -> Unit)? = null,
    enabled: Boolean = true,
) {
    var dragging by remember { mutableStateOf(false) }
    var touching by remember { mutableStateOf(false) }
    val controllable = onScrollTo != null
    val density = androidx.compose.ui.platform.LocalDensity.current
    val change by rememberUpdatedState(onScrollTo)
    val offset by rememberUpdatedState(scrollOffset)
    val c = PleosTheme.colors
    val source = remember { MutableInteractionSource() }
    var editing by remember { mutableStateOf(false) }
    BoxWithConstraints(modifier.width(if (controllable) 96.dp else 6.dp).heightIn(min = 48.dp)) {
        val h = if (maxHeight == Dp.Infinity) 407.dp else maxHeight
        val px = with(density) { h.toPx() }
        val minimum = with(density) { 48.dp.toPx() }
        val geom = pleosScrollGeometry(viewportExtent, contentExtent, scrollOffset, px, minimum)
        val latestGeometry by rememberUpdatedState(geom)
        val active = enabled && controllable && geom.maxOffset > 0
        fun scrollTo(request: Float): Boolean {
            if (!active || !request.isFinite()) return false
            val next = request.coerceIn(0f, latestGeometry.maxOffset)
            if (next == offset.coerceIn(0f, latestGeometry.maxOffset)) return false
            change?.invoke(next)
            return true
        }
        var dragOffset by remember { mutableFloatStateOf(0f) }
        Box(
            Modifier.fillMaxWidth()
                .height(h)
                .observeControlPress(active) { touching = it }
                .focusIndication(source, 4.dp)
                .onFocusChanged { if (!it.isFocused) editing = false }
                .onKeyEvent { event ->
                    if (!active) false
                    else if (event.key == Key.Enter || event.key == Key.DirectionCenter) {
                        if (event.type == KeyEventType.KeyUp) editing = !editing
                        true
                    } else if (editing && (event.key == Key.Back || event.key == Key.Escape)) {
                        if (event.type == KeyEventType.KeyUp) editing = false
                        true
                    } else if (editing && event.key in listOf(Key.DirectionUp, Key.DirectionDown)) {
                        if (event.type == KeyEventType.KeyDown)
                            scrollTo(
                                offset +
                                    if (event.key == Key.DirectionUp) -viewportExtent / 10
                                    else viewportExtent / 10
                            )
                        true
                    } else false
                }
                .focusable(active, source)
                .semantics {
                    if (!enabled) disabled()
                    if (controllable) {
                        progressBarRangeInfo =
                            ProgressBarRangeInfo(
                                scrollOffset.coerceIn(0f, geom.maxOffset),
                                0f..geom.maxOffset,
                            )
                        if (active) setProgress { scrollTo(it) }
                        if (active)
                            customActions =
                                listOf(
                                    CustomAccessibilityAction("위로 스크롤") {
                                        scrollTo(offset - viewportExtent / 10)
                                    },
                                    CustomAccessibilityAction("아래로 스크롤") {
                                        scrollTo(offset + viewportExtent / 10)
                                    },
                                )
                    }
                }
                .pointerInput(active, px) {
                    if (active)
                        try {
                            detectDragGestures(
                                onDragStart = {
                                    dragging = true
                                    dragOffset = offset
                                },
                                onDragEnd = { dragging = false },
                                onDragCancel = { dragging = false },
                            ) { event, delta ->
                                event.consume()
                                val geometry = latestGeometry
                                val travel = px - geometry.thumbLength
                                if (travel > 0) {
                                    dragOffset =
                                        (dragOffset + delta.y / travel * geometry.maxOffset)
                                            .coerceIn(0f, geometry.maxOffset)
                                    change?.invoke(dragOffset)
                                }
                            }
                        } finally {
                            dragging = false
                        }
                }
        ) {
            if (enabled && geom.maxOffset > 0)
                Box(
                    Modifier.align(Alignment.TopCenter)
                        .offset(y = with(density) { geom.thumbOffset.toDp() })
                        .size(6.dp, with(density) { geom.thumbLength.toDp() })
                        .background(
                            c[if (dragging || touching) "basic_900" else "basic_alpha_dark_200"],
                            RoundedCornerShape(3.dp),
                        )
                )
        }
    }
}
