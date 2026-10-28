package com.jade.pleos.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.*
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.jade.pleos.tokens.*
import java.math.BigDecimal
import kotlin.math.*

enum class PleosSliderSize {
    Large,
    Medium,
}

enum class PleosSliderSurface {
    Basic,
    Floating,
}

enum class PleosCenteredSliderType {
    Button,
    Basic,
    Number,
}

enum class PleosSliderVariant {
    Continuous,
    Centered,
}

/**
 * 02 §8 / C01. step은 값의 간격이며 기본 null은 연속입니다. 유한한 값·범위와 양수 step을 요구합니다. 외부 값은 clamp하고 max 끝점에 도달합니다.
 * min=max는 고정값입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 11_figma_sliders.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
fun normalizePleosValue(
    request: Float,
    range: ClosedFloatingPointRange<Float>,
    step: Float? = null,
): Float {
    require(
        request.isFinite() &&
            range.start.isFinite() &&
            range.endInclusive.isFinite() &&
            range.start <= range.endInclusive
    )
    require(range.endInclusive.toDouble() - range.start.toDouble() <= Float.MAX_VALUE)
    require(step == null || step.isFinite() && step > 0)
    val v = request.coerceIn(range.start, range.endInclusive)
    if (range.start == range.endInclusive || step == null || v == range.endInclusive) return v
    return (range.start.toDouble() + round((v - range.start).toDouble() / step) * step)
        .toFloat()
        .coerceIn(range.start, range.endInclusive)
}

/**
 * 02 §8 / C01. BigDecimal 값을 사용합니다. min≤max·step>0이 필요하며 외부 값은 범위에 clamp합니다. 기본 반복 입력은 없습니다. 원본
 * 노드·binding 식별자는 tools/spec_inventory.json의 12_figma_stepper.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며,
 * 값 변경 콜백은 호스트에 대한 요청입니다.
 */
fun stepPleosDecimal(
    value: BigDecimal,
    min: BigDecimal,
    max: BigDecimal,
    step: BigDecimal,
    direction: Int,
): BigDecimal {
    require(min <= max && step > BigDecimal.ZERO && direction in -1..1)
    return value.add(step.multiply(direction.toBigDecimal())).coerceIn(min, max)
}

enum class PleosVolumeLevel {
    Min,
    Low,
    Mid,
    High,
    Max,
}

/** 02 §8.1: 정규화한 0~1 비율의 0/25/75/100% 경계입니다. */
fun pleosVolumeLevel(fraction: Float): PleosVolumeLevel {
    require(fraction.isFinite())
    return when {
        fraction <= 0f -> PleosVolumeLevel.Min
        fraction >= 1f -> PleosVolumeLevel.Max
        fraction <= .25f -> PleosVolumeLevel.Low
        fraction <= .75f -> PleosVolumeLevel.Mid
        else -> PleosVolumeLevel.High
    }
}

@Composable
private fun VolumeIcon(level: PleosVolumeLevel) {
    PleosIcon(
        when (level) {
            PleosVolumeLevel.Min -> R.drawable.pleos_ic_sound_volume_mute__67_24437
            PleosVolumeLevel.Low -> R.drawable.pleos_ic_sound_volume_low__67_24431
            PleosVolumeLevel.Mid -> R.drawable.pleos_ic_sound_volume_mid__67_24424
            else -> R.drawable.pleos_ic_sound_volume_high__67_24418
        },
        Modifier.fillMaxSize(),
    )
}

internal fun shiftedPleosValue(
    value: Float,
    delta: Float,
    range: ClosedFloatingPointRange<Float>,
    step: Float?,
): Float =
    normalizePleosValue(
        (value.toDouble() + delta.toDouble())
            .coerceIn(range.start.toDouble(), range.endInclusive.toDouble())
            .toFloat(),
        range,
        step,
    )

@Composable
private fun ValueTrack(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier,
    range: ClosedFloatingPointRange<Float>,
    step: Float?,
    enabled: Boolean,
    centered: Boolean,
    off: Boolean,
    onFinished: (() -> Unit)?,
    formatter: (Float) -> String,
    centerValue: Float? = null,
    largeTrack: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    val v = normalizePleosValue(value, range, step)
    val span = range.endInclusive - range.start
    val effective = enabled && span > 0
    val frac = if (span == 0f) 0f else (v - range.start) / span
    val rtl = LocalLayoutDirection.current == LayoutDirection.Rtl
    val m = PleosTheme.metrics
    val source = remember { MutableInteractionSource() }
    var pressed by remember { mutableStateOf(false) }
    var editing by remember { mutableStateOf(false) }
    var keyChanged by remember { mutableStateOf(false) }
    val change by rememberUpdatedState(onValueChange)
    val finish by rememberUpdatedState(onFinished)
    val current by rememberUpdatedState(v)
    val c = PleosTheme.colors
    val rangeStep = step ?: if (span == 0f) 1f else span / 100
    fun request(next: Float): Boolean {
        if (!effective) return false
        val n = normalizePleosValue(next, range, step)
        if (n == current) return false
        change(n)
        return true
    }
    val controls =
        modifier
            .heightIn(
                min =
                    if (centered) m.dp("controller/slider/centered/value_height", 76f)
                    else m.dp("controller/slider/minimum_touch_height", 64f)
            )
            .focusIndication(source, m.dp("controller/slider/focus_radius", 24f))
            .onFocusChanged {
                if (!it.isFocused) {
                    editing = false
                    keyChanged = false
                }
            }
            .semantics {
                progressBarRangeInfo =
                    ProgressBarRangeInfo(
                        v,
                        range,
                        if (step != null && span > 0) (span / step).toInt().coerceAtLeast(1) - 1
                        else 0,
                    )
                stateDescription = formatter(v)
                if (!effective) disabled()
                if (effective) {
                    setProgress { request(it) }
                    customActions =
                        listOf(
                            CustomAccessibilityAction("감소") {
                                request(shiftedPleosValue(current, -rangeStep, range, step))
                            },
                            CustomAccessibilityAction("증가") {
                                request(shiftedPleosValue(current, rangeStep, range, step))
                            },
                        ) +
                            if (centerValue != null)
                                listOf(CustomAccessibilityAction("중립값") { request(centerValue) })
                            else emptyList()
                }
            }
            .onKeyEvent { e ->
                if (!effective) false
                else if (e.key == Key.Enter || e.key == Key.DirectionCenter) {
                    if (e.type == KeyEventType.KeyUp) {
                        editing = !editing
                        keyChanged = false
                    }
                    true
                } else if (e.key == Key.Back || e.key == Key.Escape) {
                    if (editing) {
                        if (e.type == KeyEventType.KeyUp) editing = false
                        true
                    } else false
                } else if (
                    e.key in
                        listOf(
                            Key.DirectionLeft,
                            Key.DirectionRight,
                            Key.DirectionUp,
                            Key.DirectionDown,
                        ) && editing
                ) {
                    if (e.type == KeyEventType.KeyDown) {
                        val increase =
                            e.key == Key.DirectionUp ||
                                e.key == if (rtl) Key.DirectionLeft else Key.DirectionRight
                        keyChanged =
                            request(
                                shiftedPleosValue(
                                    current,
                                    if (increase) rangeStep else -rangeStep,
                                    range,
                                    step,
                                )
                            ) || keyChanged
                    }
                    if (e.type == KeyEventType.KeyUp && keyChanged) {
                        finish?.invoke()
                        keyChanged = false
                    }
                    true
                } else false
            }
            .focusable(effective, source)
            .pointerInput(effective, range, step, rtl) {
                if (effective)
                    awaitEachGesture {
                        val down = awaitFirstDown()
                        down.consume()
                        pressed = true
                        fun at(x: Float) {
                            val baseRadius =
                                if (centered)
                                    m.dp("controller/slider/centered/knob/enabled_circle", 48f)
                                        .toPx() / 2
                                else 0f
                            val fraction =
                                ((x - baseRadius) / (size.width - baseRadius * 2).coerceAtLeast(1f))
                                    .coerceIn(0f, 1f)
                            val f = if (rtl) 1f - fraction else fraction
                            request(
                                (range.start.toDouble() + f * span.toDouble())
                                    .coerceIn(range.start.toDouble(), range.endInclusive.toDouble())
                                    .toFloat()
                            )
                        }
                        try {
                            at(down.position.x)
                            val success =
                                drag(down.id) {
                                    it.consume()
                                    at(it.position.x)
                                }
                            if (success) finish?.invoke()
                        } finally {
                            pressed = false
                        }
                    }
            }
    Box(controls) {
        Canvas(Modifier.matchParentSize()) {
            val x = (if (rtl) 1 - frac else frac) * size.width
            if (centered) {
                val trackH = m.dp("controller/slider/centered/track/height", 8f).toPx()
                val brush =
                    if (off) Brush.horizontalGradient(listOf(c["basic_200"], c["basic_200"]))
                    else
                        Brush.horizontalGradient(
                            listOf(
                                    c["controller/slider/gradient_start"],
                                    c["controller/slider/gradient_end"],
                                )
                                .let { if (rtl) it.reversed() else it }
                        )
                drawRoundRect(
                    brush,
                    Offset(0f, (size.height - trackH) / 2),
                    Size(size.width, trackH),
                    CornerRadius(trackH / 2),
                )
                val r =
                    (m.dp(
                            if (pressed) "controller/slider/centered/knob/pressed_circle"
                            else "controller/slider/centered/knob/enabled_circle",
                            if (pressed) 56f else 48f,
                        ) / 2)
                        .toPx()
                val baseRadius =
                    m.dp("controller/slider/centered/knob/enabled_circle", 48f).toPx() / 2
                val clamped =
                    if (size.width < baseRadius * 2) size.width / 2
                    else baseRadius + (if (rtl) 1 - frac else frac) * (size.width - baseRadius * 2)
                drawCircle(c["basic_700"], r, Offset(clamped, size.height / 2))
                drawCircle(
                    c["climate/slider_background"],
                    r - 3.dp.toPx(),
                    Offset(clamped, size.height / 2),
                    style = Stroke(6.dp.toPx()),
                )
            } else {
                drawRoundRect(
                    c[if (pressed) "controller/slider/pressed" else "controller/slider/normal"],
                    cornerRadius =
                        CornerRadius(
                            m.dp(
                                    "controller/slider/continuous/track/${if (largeTrack) "medium" else "small"}/radius_top_left",
                                    if (largeTrack) 24f else 20f,
                                )
                                .toPx()
                        ),
                )
                val inset =
                    m.dp(
                            "controller/slider/continuous/track/${if (largeTrack) "medium" else "small"}/item_padding",
                            4f,
                        )
                        .toPx()
                val fill = (size.width - 2 * inset) * frac
                if (fill > 0f)
                    drawRoundRect(
                        c["controller/slider/knop"],
                        Offset(if (rtl) size.width - inset - fill else inset, inset),
                        Size(fill, (size.height - 2 * inset).coerceAtLeast(0f)),
                        CornerRadius(
                            m.dp(
                                    "controller/slider/continuous/${if (largeTrack) "medium" else "small"}/knob/radius_top_left",
                                    if (largeTrack) 20f else 16f,
                                )
                                .toPx()
                        ),
                    )
            }
        }
        if (!centered && (leadingIcon != null || trailingIcon != null)) {
            val glyph =
                m.dp(
                    "controller/slider/continuous/track/${if (largeTrack) "medium" else "small"}/icon",
                    if (largeTrack) 48f else 40f,
                )
            Row(
                Modifier.matchParentSize()
                    .padding(
                        horizontal =
                            m.dp(
                                "controller/slider/continuous/track/${if (largeTrack) "medium" else "small"}/icon_padding_horizontal",
                                if (largeTrack) 20f else 16f,
                            )
                    )
                    .clearAndSetSemantics {},
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CompositionLocalProvider(
                    LocalPleosContentColor provides
                        c[if (enabled) "icon/dark/primary" else "icon/dark/quaternary"]
                ) {
                    if (leadingIcon != null)
                        Box(Modifier.size(glyph), contentAlignment = Alignment.Center) {
                            leadingIcon()
                        }
                    Spacer(Modifier.weight(1f))
                    if (trailingIcon != null)
                        Box(Modifier.size(glyph), contentAlignment = Alignment.Center) {
                            trailingIcon()
                        }
                }
            }
        }
    }
}

/**
 * 02 §8 / C01. step은 값의 간격이며 기본 null은 연속입니다. 유한한 값·범위와 양수 step을 요구합니다. 외부 값은 clamp하고 max 끝점에 도달합니다.
 * min=max는 고정값입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 11_figma_sliders.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosContinuousSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    step: Float? = null,
    size: PleosSliderSize = PleosSliderSize.Large,
    surface: PleosSliderSurface = PleosSliderSurface.Basic,
    enabled: Boolean = true,
    onValueChangeFinished: (() -> Unit)? = null,
    valueFormatter: (Float) -> String = { it.toString() },
    label: String? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    showVolumeIcon: Boolean = true,
) {
    val v = normalizePleosValue(value, valueRange, step)
    val large = size == PleosSliderSize.Large
    val floating = surface == PleosSliderSurface.Floating
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val increment =
        step ?: ((valueRange.endInclusive - valueRange.start) / 100).takeIf { it > 0 } ?: 1f
    val radius =
        m.dp(
            if (large) "controller/slider/continuous/medium/radius_top_left"
            else "controller/slider/continuous/small/radius_top_left",
            if (large) 32f else 24f,
        )
    PleosSurface(
        modifier
            .widthIn(
                max =
                    m.dp(
                        if (large) "controller/slider/continuous/width_large"
                        else "controller/slider/continuous/width_medium",
                        if (large) 808f else 560f,
                    )
            )
            .defaultMinSize(
                minHeight =
                    m.dp(
                        if (large) "controller/slider/height_large"
                        else "controller/slider/height_medium",
                        if (large) 100f else 80f,
                    )
            ),
        c[if (floating) "background/popup" else "dim/dark/primary"],
        radius,
        c["divider/secondary"],
        if (floating) 2.dp else 0.dp,
        if (floating) 2 else 0,
    ) {
        Row(
            Modifier.padding(
                horizontal =
                    m.dp(
                        if (large) "controller/slider/padding_horizontal_medium"
                        else "controller/slider/padding_horizontal_small",
                        if (large) 20f else 10f,
                    ),
                vertical =
                    m.dp(
                        if (large) "controller/slider/padding_vertical_medium"
                        else "controller/slider/padding_vertical_small",
                        if (large) 10f else 8f,
                    ),
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement =
                Arrangement.spacedBy(
                    m.dp(
                        if (large) "controller/slider/gap_horizontal_large"
                        else "controller/slider/gap_horizontal_small",
                        if (large) 16f else 12f,
                    )
                ),
        ) {
            PleosIconButton(
                "감소",
                {
                    onValueChange(shiftedPleosValue(v, -increment, valueRange, step))
                    onValueChangeFinished?.invoke()
                },
                size = if (large) PleosButtonSize.Medium else PleosButtonSize.Small,
                enabled = enabled && v > valueRange.start,
                style = PleosIconButtonStyle.Plain,
            ) {
                PleosIcon(BackIcon, Modifier.fillMaxSize())
            }
            label?.let {
                PleosText(
                    it,
                    Modifier.widthIn(
                        max = m.dp("controller/slider/continuous/medium/label_width", 180f)
                    ),
                    style =
                        pleosTextStyle(
                            if (large) 32 else 30,
                            if (large) 40 else 38,
                            FontWeight.Bold,
                        ),
                    maxLines = 2,
                )
            }
            ValueTrack(
                v,
                onValueChange,
                Modifier.weight(1f)
                    .height(
                        m.dp(
                            if (large) "controller/slider/continuous/medium/button_medium"
                            else "buttons/icon/small/height",
                            if (large) 80f else 64f,
                        )
                    ),
                valueRange,
                step,
                enabled,
                false,
                false,
                onValueChangeFinished,
                valueFormatter,
                largeTrack = large,
                leadingIcon =
                    leadingIcon
                        ?: if (showVolumeIcon)
                            ({
                                VolumeIcon(
                                    pleosVolumeLevel(
                                        if (valueRange.start == valueRange.endInclusive) 0f
                                        else
                                            (v - valueRange.start) /
                                                (valueRange.endInclusive - valueRange.start)
                                    )
                                )
                            })
                        else null,
                trailingIcon = trailingIcon,
            )
            PleosIconButton(
                "증가",
                {
                    onValueChange(shiftedPleosValue(v, increment, valueRange, step))
                    onValueChangeFinished?.invoke()
                },
                size = if (large) PleosButtonSize.Medium else PleosButtonSize.Small,
                enabled = enabled && v < valueRange.endInclusive,
                style = PleosIconButtonStyle.Plain,
            ) {
                PleosIcon(RightIcon, Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private fun CenteredValueLabel(text: String) {
    val match = Regex("([+-]?[0-9]{1,2})([.,][0-9]+)?").matchEntire(text)
    val m = PleosTheme.metrics
    if (match == null) {
        PleosText(text, style = pleosTextStyle(40, 52, FontWeight.Bold), maxLines = 1)
    } else
        Row(verticalAlignment = Alignment.CenterVertically) {
            PleosText(
                match.groupValues[1],
                Modifier.width(m.dp("gnb/temperature/number_width", 75f)).alignByBaseline(),
                style = pleosTextStyle(60, 68, FontWeight.Bold),
                maxLines = 1,
                textAlign = TextAlign.Center,
            )
            PleosText(
                match.groupValues[2],
                Modifier.width(m.dp("gnb/temperature/decimal_places_witdh", 38f)).alignByBaseline(),
                style = pleosTextStyle(40, 64, FontWeight.ExtraBold),
                maxLines = 1,
            )
        }
}

/**
 * 02 §8 / C01. step은 값의 간격이며 기본 null은 연속입니다. 유한한 값·범위와 양수 step을 요구합니다. 외부 값은 clamp하고 max 끝점에 도달합니다.
 * min=max는 고정값입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 11_figma_sliders.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosCenteredSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = -1f..1f,
    step: Float? = null,
    centerValue: Float =
        ((valueRange.start.toDouble() + valueRange.endInclusive.toDouble()) / 2).toFloat(),
    type: PleosCenteredSliderType = PleosCenteredSliderType.Basic,
    off: Boolean = false,
    enabled: Boolean = true,
    onValueChangeFinished: (() -> Unit)? = null,
    valueFormatter: (Float) -> String = { it.toString() },
    valueContent: (@Composable (String) -> Unit)? = null,
) {
    val v = normalizePleosValue(value, valueRange, step)
    require(centerValue.isFinite() && centerValue in valueRange)
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val increment =
        step ?: ((valueRange.endInclusive - valueRange.start) / 100).takeIf { it > 0 } ?: 1f
    val gap = m.dp("controller/slider/gap_horizontal_large", 16f)
    val side =
        m.dp(
            if (type == PleosCenteredSliderType.Button) "controller/slider/padding_horizontal_small"
            else "controller/slider/padding_horizontal_large",
            if (type == PleosCenteredSliderType.Button) 10f else 40f,
        )
    val preferred =
        m.dp("controller/slider/centered/track/min_width", 320f) +
            side * 2 +
            when (type) {
                PleosCenteredSliderType.Button ->
                    m.dp("buttons/icon/medium/width", 80f) * 2 + gap * 2
                PleosCenteredSliderType.Number ->
                    m.dp("gnb/temperature/number_width", 75f) +
                        m.dp("gnb/temperature/decimal_places_witdh", 38f) +
                        gap
                else -> 0.dp
            }
    PleosSurface(
        modifier
            .widthIn(max = preferred)
            .defaultMinSize(minHeight = m.dp("controller/slider/height_large", 100f)),
        c["climate/slider_background"],
        m.dp("controller/slider/radius_top_left", 32f),
        c["climate/button_border_enabled"],
        m.dp("controller/slider/border_medium", 3f),
        if (type == PleosCenteredSliderType.Button) 0 else 1,
    ) {
        Row(
            Modifier.padding(
                horizontal = side,
                vertical =
                    m.dp(
                        if (type == PleosCenteredSliderType.Button)
                            "controller/slider/padding_vertical_medium"
                        else "controller/slider/padding_vertical_large",
                        if (type == PleosCenteredSliderType.Button) 10f else 12f,
                    ),
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(gap),
        ) {
            if (type == PleosCenteredSliderType.Button)
                PleosIconButton(
                    "감소",
                    {
                        onValueChange(shiftedPleosValue(v, -increment, valueRange, step))
                        onValueChangeFinished?.invoke()
                    },
                    enabled = enabled && v > valueRange.start,
                    style = PleosIconButtonStyle.Plain,
                ) {
                    PleosIcon(BackIcon, Modifier.fillMaxSize())
                }
            if (type == PleosCenteredSliderType.Number) {
                val formatted = if (off) "OFF" else valueFormatter(v)
                Box(
                    Modifier.width(
                            m.dp("gnb/temperature/number_width", 75f) +
                                m.dp("gnb/temperature/decimal_places_witdh", 38f)
                        )
                        .heightIn(min = m.dp("controller/slider/centered/value_height", 76f)),
                    contentAlignment = Alignment.Center,
                ) {
                    if (valueContent != null) valueContent(formatted)
                    else CenteredValueLabel(formatted)
                }
            }
            ValueTrack(
                v,
                onValueChange,
                Modifier.weight(1f)
                    .height(
                        (m.dp("controller/slider/height_large", 100f) -
                                m.dp(
                                    if (type == PleosCenteredSliderType.Button)
                                        "controller/slider/padding_vertical_medium"
                                    else "controller/slider/padding_vertical_large",
                                    if (type == PleosCenteredSliderType.Button) 10f else 12f,
                                ) * 2)
                            .coerceAtLeast(48.dp)
                    ),
                valueRange,
                step,
                enabled,
                true,
                off,
                onValueChangeFinished,
                valueFormatter,
                centerValue,
            )
            if (type == PleosCenteredSliderType.Button)
                PleosIconButton(
                    "증가",
                    {
                        onValueChange(shiftedPleosValue(v, increment, valueRange, step))
                        onValueChangeFinished?.invoke()
                    },
                    enabled = enabled && v < valueRange.endInclusive,
                    style = PleosIconButtonStyle.Plain,
                ) {
                    PleosIcon(RightIcon, Modifier.fillMaxSize())
                }
        }
    }
}

/**
 * 02 §8 / C01. step은 값의 간격이며 기본 null은 연속입니다. 유한한 값·범위와 양수 step을 요구합니다. 외부 값은 clamp하고 max 끝점에 도달합니다.
 * min=max는 고정값입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 11_figma_sliders.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    variant: PleosSliderVariant = PleosSliderVariant.Continuous,
    step: Float? = null,
    enabled: Boolean = true,
    onValueChangeFinished: (() -> Unit)? = null,
    valueFormatter: (Float) -> String = { it.toString() },
) {
    if (variant == PleosSliderVariant.Continuous)
        PleosContinuousSlider(
            value,
            onValueChange,
            modifier,
            valueRange,
            step,
            enabled = enabled,
            onValueChangeFinished = onValueChangeFinished,
            valueFormatter = valueFormatter,
        )
    else
        PleosCenteredSlider(
            value,
            onValueChange,
            modifier,
            valueRange,
            step,
            enabled = enabled,
            onValueChangeFinished = onValueChangeFinished,
            valueFormatter = valueFormatter,
        )
}

/**
 * 02 §8 / C01. BigDecimal 값을 사용합니다. min≤max·step>0이 필요하며 외부 값은 범위에 clamp합니다. 기본 반복 입력은 없습니다. 원본
 * 노드·binding 식별자는 tools/spec_inventory.json의 12_figma_stepper.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며,
 * 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosStepper(
    value: BigDecimal,
    onValueChange: (BigDecimal) -> Unit,
    min: BigDecimal,
    max: BigDecimal,
    step: BigDecimal,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueFormatter: (BigDecimal) -> String = { it.stripTrailingZeros().toPlainString() },
) {
    require(min <= max && step > BigDecimal.ZERO)
    val v = value.coerceIn(min, max)
    val c = PleosTheme.colors
    PleosSurface(
        modifier
            .widthIn(max = PleosTheme.metrics.dp("controller/stepper/width", 400f))
            .heightIn(min = PleosTheme.metrics.dp("controller/stepper/height", 100f)),
        c["controller/stepper_background"],
        PleosTheme.metrics.dp("controller/stepper/radius_top_left", 24f),
        c["divider/secondary"],
        PleosTheme.metrics.dp("controller/stepper/border", 2f),
        1,
    ) {
        Row(
            Modifier.fillMaxWidth()
                .heightIn(min = PleosTheme.metrics.dp("controller/stepper/height", 100f)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            StepperAction(
                "감소",
                { onValueChange(stepPleosDecimal(v, min, max, step, -1)) },
                enabled && v > min,
                MinusIcon,
                Modifier.weight(112f),
            )
            Box(Modifier.weight(32f), contentAlignment = Alignment.Center) {
                Box(
                    Modifier.width(PleosTheme.metrics.dp("controller/stepper/divider", 2f))
                        .height(PleosTheme.metrics.dp("controller/stepper/divider_height", 64f))
                        .background(c["divider/tertiary"])
                )
            }
            PleosText(
                valueFormatter(v),
                Modifier.weight(112f),
                style = pleosTextStyle(36, 44, FontWeight.Bold),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            )
            Box(Modifier.weight(32f), contentAlignment = Alignment.Center) {
                Box(
                    Modifier.width(PleosTheme.metrics.dp("controller/stepper/divider", 2f))
                        .height(PleosTheme.metrics.dp("controller/stepper/divider_height", 64f))
                        .background(c["divider/tertiary"])
                )
            }
            StepperAction(
                "증가",
                { onValueChange(stepPleosDecimal(v, min, max, step, 1)) },
                enabled && v < max,
                PlusIcon,
                Modifier.weight(112f),
            )
        }
    }
}

@Composable
private fun StepperAction(
    label: String,
    onClick: () -> Unit,
    enabled: Boolean,
    icon: Int,
    modifier: Modifier,
) {
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    Box(
        actionModifier(
            modifier.heightIn(min = m.dp("controller/stepper/height", 100f)).semantics {
                contentDescription = label
            },
            source,
            enabled,
            24.dp,
            onClick,
        ),
        contentAlignment = Alignment.Center,
    ) {
        PleosSurface(
            Modifier.size(m.dp("buttons/icon/small/width", 64f)),
            if (enabled && pressed) c["button/basic/pressed"] else Color.Transparent,
            m.dp("buttons/icon/small/rounded_radius_top_left", 16f),
        ) {
            PleosIcon(
                icon,
                Modifier.size(m.dp("buttons/icon/small/content", 44f)).align(Alignment.Center),
                tint = c[if (enabled) "icon/dark/primary" else "icon/dark/quaternary"],
            )
        }
    }
}
