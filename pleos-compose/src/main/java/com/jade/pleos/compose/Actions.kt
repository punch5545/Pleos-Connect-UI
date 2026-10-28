package com.jade.pleos.compose

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.compose.currentStateAsState
import com.jade.pleos.tokens.*

enum class PleosButtonSize {
    Large,
    Medium,
    Small,
}

enum class PleosButtonHierarchy {
    Primary,
    Secondary,
}

enum class PleosTextButtonSize {
    Medium,
    Small,
}

enum class PleosIconButtonStyle {
    Basic,
    Plain,
    Circle,
}

enum class PleosLoadingKind {
    Linear,
    Tension,
}

data class IconButtonMetrics(
    val largeSize: Dp = 100.dp,
    val largeIcon: Dp = 64.dp,
    val largeRadius: Dp = 24.dp,
    val smallSize: Dp? = null,
    val smallIcon: Dp? = null,
    val mediumSize: Dp? = null,
    val mediumIcon: Dp? = null,
)

data class LoadingIndicatorSpec(
    val kind: PleosLoadingKind = PleosLoadingKind.Linear,
    val animate: Boolean = true,
)

/**
 * 01 §6 / Loading. 30fps·61프레임입니다. 모션 제한 또는 비활성 lifecycle에서는 정적 busy 표시를 유지합니다. 원본 노드·binding 식별자는
 * tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에
 * 대한 요청입니다.
 */
@Composable
fun PleosLoadingIndicator(
    modifier: Modifier = Modifier,
    spec: LoadingIndicatorSpec = LoadingIndicatorSpec(),
) {
    val lifecycle by
        androidx.lifecycle.compose.LocalLifecycleOwner.current.lifecycle.currentStateAsState()
    val animate =
        lifecycle.isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED) &&
            spec.animate &&
            !PleosTheme.behavior.reducedMotion &&
            LocalPleosCapabilities.current.animations
    val transition = rememberInfiniteTransition(label = "PleosLoading")
    val frame =
        if (animate)
            transition
                .animateFloat(
                    0f,
                    61f,
                    infiniteRepeatable(tween(2033, easing = LinearEasing)),
                    label = "frame",
                )
                .value
        else 0f
    val progress = frame.coerceAtMost(60f) / 60f
    val sweep =
        if (spec.kind == PleosLoadingKind.Linear) 100.8f
        else
            (if (progress < .5f) .01f + progress * 1.18f else .60f - (progress - .5f) * 1.18f) *
                360f
    val color = if (PleosTheme.colors.dark) Color.White else Color(0xFF131417)
    Canvas(
        modifier.size(64.dp).semantics {
            stateDescription = "처리 중"
            progressBarRangeInfo = ProgressBarRangeInfo.Indeterminate
        }
    ) {
        val unit = size.minDimension / 64
        val stroke = Stroke(8 * unit, cap = StrokeCap.Round)
        val inset = 8 * unit
        drawArc(
            color.copy(alpha = .10f),
            0f,
            360f,
            false,
            androidx.compose.ui.geometry.Offset(inset, inset),
            androidx.compose.ui.geometry.Size(48 * unit, 48 * unit),
            style = stroke,
        )
        drawArc(
            color.copy(alpha = .84f),
            -90f + progress * 1080,
            sweep,
            false,
            androidx.compose.ui.geometry.Offset(inset, inset),
            androidx.compose.ui.geometry.Size(48 * unit, 48 * unit),
            style = stroke,
        )
    }
}

data class PleosButtonMetrics(
    val height: Dp,
    val minWidth: Dp,
    val horizontal: Dp,
    val vertical: Dp,
    val gap: Dp,
    val radius: Dp,
    val icon: Dp,
    val font: Int,
    val line: Int,
)

/**
 * 02 §2~5 / A01~A04. 크기·계층은 전용 열거형을 사용합니다. loading은 중복 실행을 막고 enabled와 독립입니다. Floating은 선택 상태와
 * 독립입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은
 * 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun pleosButtonMetrics(size: PleosButtonSize, toggle: Boolean = false): PleosButtonMetrics {
    val m = PleosTheme.metrics
    val s = size.name.lowercase()
    val p = "buttons/${if(toggle)"toggle" else "basic"}/$s/"
    val d =
        when (size) {
            PleosButtonSize.Large -> intArrayOf(100, 140, 40, 16, 16, 32, 52, 32, 40)
            PleosButtonSize.Medium -> intArrayOf(80, 120, 32, 16, 14, 24, 40, 30, 38)
            PleosButtonSize.Small -> intArrayOf(64, 100, 24, 8, 12, 16, 32, 26, 34)
        }
    fun v(k: String, i: Int) = m.dp(p + k, d[i].toFloat())
    val r =
        if (toggle) "radius_top_left"
        else
            when (size) {
                PleosButtonSize.Large -> "radius_top_left"
                PleosButtonSize.Medium -> "radius_top_left_medium"
                PleosButtonSize.Small -> "radius_bottom_right"
            }
    return PleosButtonMetrics(
        v("height", 0),
        v("min_width", 1),
        v("padding_horizontal", 2),
        v("padding_vertical", 3),
        v("gap_horizontal", 4),
        v(r, 5),
        v(if (toggle && size == PleosButtonSize.Medium) "icon_square" else "icon_sqaure", 6),
        d[7],
        d[8],
    )
}

@Composable
private fun ButtonContents(
    text: String,
    s: PleosButtonMetrics,
    color: Color,
    leading: (@Composable () -> Unit)?,
    trailing: (@Composable () -> Unit)?,
    underline: Boolean = false,
) {
    CompositionLocalProvider(LocalPleosContentColor provides color) {
        Row(
            Modifier.padding(s.horizontal, s.vertical),
            horizontalArrangement = Arrangement.spacedBy(s.gap, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            leading?.let {
                Box(Modifier.size(s.icon), contentAlignment = Alignment.Center) { it() }
            }
            PleosText(
                text,
                Modifier.weight(1f, false),
                style =
                    pleosTextStyle(s.font, s.line, FontWeight.Bold)
                        .copy(textDecoration = if (underline) TextDecoration.Underline else null),
                maxLines = 2,
                textAlign = TextAlign.Center,
            )
            trailing?.let {
                Box(Modifier.size(s.icon), contentAlignment = Alignment.Center) { it() }
            }
        }
    }
}

/**
 * 02 §2~5 / A01~A04. 크기·계층은 전용 열거형을 사용합니다. loading은 중복 실행을 막고 enabled와 독립입니다. Floating은 선택 상태와
 * 독립입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은
 * 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosBasicButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: PleosButtonSize = PleosButtonSize.Medium,
    hierarchy: PleosButtonHierarchy = PleosButtonHierarchy.Primary,
    enabled: Boolean = true,
    loading: Boolean = false,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    loadingIndicator: (@Composable () -> Unit)? = null,
    metrics: PleosButtonMetrics? = null,
) {
    val s = metrics ?: pleosButtonMetrics(size)
    val c = PleosTheme.colors
    val pressed by interactionSource.collectIsPressedAsState()
    val state = if (!enabled) "disabled" else if (pressed && !loading) "pressed" else "enabled"
    val family = if (hierarchy == PleosButtonHierarchy.Primary) "basic" else "filled"
    val fg =
        c[
            if (!enabled) "text/dark/quaternary"
            else if (family == "filled") "text/light/primary" else "text/dark/primary"]
    PleosSurface(
        actionModifier(
                modifier.defaultMinSize(s.minWidth, s.height),
                interactionSource,
                enabled,
                s.radius,
                onClick,
                blocked = loading,
            )
            .semantics {
                if (loading) {
                    stateDescription = "처리 중"
                    progressBarRangeInfo = ProgressBarRangeInfo.Indeterminate
                }
            },
        c["button/$family/$state"],
        s.radius,
        c["divider/secondary"],
        if (!enabled) PleosTheme.metrics.dp("buttons/basic/disabled_border", 2f) else 0.dp,
    ) {
        Box(Modifier.align(Alignment.Center).alpha(if (loading) 0f else 1f)) {
            ButtonContents(text, s, fg, leadingIcon, trailingIcon)
        }
        if (loading)
            Box(Modifier.align(Alignment.Center)) {
                if (loadingIndicator != null) loadingIndicator()
                else
                    PleosLoadingIndicator(
                        Modifier.size(
                            when (size) {
                                PleosButtonSize.Large -> 40.dp
                                PleosButtonSize.Medium -> 32.dp
                                PleosButtonSize.Small -> 24.dp
                            }
                        )
                    )
            }
    }
}

/**
 * 02 §2~5 / A01~A04. 크기·계층은 전용 열거형을 사용합니다. loading은 중복 실행을 막고 enabled와 독립입니다. Floating은 선택 상태와
 * 독립입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은
 * 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosToggleButton(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    size: PleosButtonSize = PleosButtonSize.Medium,
    enabled: Boolean = true,
    floating: Boolean = false,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val s = pleosButtonMetrics(size, true)
    val c = PleosTheme.colors
    val pressed by interactionSource.collectIsPressedAsState()
    val state = if (!enabled) "disabled" else if (pressed) "pressed" else "enabled"
    val fg =
        c[
            if (!enabled) "text/dark/quaternary"
            else if (checked) "text/dark/primary" else "text/dark/secondary"]
    PleosSurface(
        modifier
            .defaultMinSize(s.minWidth, s.height)
            .focusIndication(interactionSource, s.radius)
            .toggleable(checked, interactionSource, null, enabled, Role.Checkbox) {
                onCheckedChange(it)
            },
        c["button/${if(checked)"switch" else "basic"}/$state"],
        s.radius,
        c["divider/secondary"],
        if (!enabled) PleosTheme.metrics.dp("buttons/toggle/disabled_border", 2f) else 0.dp,
        if (floating && checked && enabled) 2 else 0,
    ) {
        Box(Modifier.align(Alignment.Center)) {
            ButtonContents(text, s, fg, leadingIcon, trailingIcon)
        }
    }
}

/**
 * 02 §2~5 / A01~A04. 크기·계층은 전용 열거형을 사용합니다. loading은 중복 실행을 막고 enabled와 독립입니다. Floating은 선택 상태와
 * 독립입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은
 * 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: PleosTextButtonSize = PleosTextButtonSize.Medium,
    enabled: Boolean = true,
    loading: Boolean = false,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val medium = size == PleosTextButtonSize.Medium
    val m = PleosTheme.metrics
    val key = "buttons/text/${size.name.lowercase()}/"
    val s =
        PleosButtonMetrics(
            0.dp,
            0.dp,
            0.dp,
            0.dp,
            m.dp(key + "gap", if (medium) 8f else 4f),
            0.dp,
            m.dp(key + "icon", if (medium) 32f else 28f),
            if (medium) 30 else 26,
            if (medium) 38 else 34,
        )
    val pressed by interactionSource.collectIsPressedAsState()
    val fg = PleosTheme.colors[if (enabled) "informative/positive" else "text/dark/quaternary"]
    Box(
        actionModifier(modifier, interactionSource, enabled, 0.dp, onClick, blocked = loading)
            .semantics {
                if (loading) {
                    stateDescription = "처리 중"
                    progressBarRangeInfo = ProgressBarRangeInfo.Indeterminate
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        Box(Modifier.alpha(if (loading) 0f else 1f)) {
            ButtonContents(text, s, fg, leadingIcon, trailingIcon, pressed)
        }
        if (loading) PleosLoadingIndicator(Modifier.size(if (medium) 32.dp else 24.dp))
    }
}

/**
 * 02 §2~5 / A01~A04. 크기·계층은 전용 열거형을 사용합니다. loading은 중복 실행을 막고 enabled와 독립입니다. Floating은 선택 상태와
 * 독립입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은
 * 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosIconButton(
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: PleosIconButtonStyle = PleosIconButtonStyle.Basic,
    size: PleosButtonSize = PleosButtonSize.Medium,
    enabled: Boolean = true,
    metrics: IconButtonMetrics = IconButtonMetrics(),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    icon: @Composable () -> Unit,
) {
    require(contentDescription.isNotBlank())
    val m = PleosTheme.metrics
    val large = size == PleosButtonSize.Large
    val p = "buttons/icon/${size.name.lowercase()}/"
    val root =
        if (large) metrics.largeSize
        else
            (if (size == PleosButtonSize.Medium) metrics.mediumSize else metrics.smallSize)
                ?: m.dp(p + "width", if (size == PleosButtonSize.Medium) 80f else 64f)
    val glyph =
        if (large) metrics.largeIcon
        else
            (if (size == PleosButtonSize.Medium) metrics.mediumIcon else metrics.smallIcon)
                ?: m.dp(p + "content", if (size == PleosButtonSize.Medium) 56f else 44f)
    val radius =
        if (style == PleosIconButtonStyle.Circle) root / 2
        else if (large) metrics.largeRadius
        else m.dp(p + "rounded_radius_top_left", if (size == PleosButtonSize.Medium) 20f else 16f)
    val pressed by interactionSource.collectIsPressedAsState()
    val c = PleosTheme.colors
    val color =
        if (style == PleosIconButtonStyle.Plain && (!enabled || !pressed)) Color.Transparent
        else c["button/basic/${if(!enabled)"disabled" else if(pressed)"pressed" else "enabled"}"]
    PleosSurface(
        actionModifier(
            modifier.size(root).semantics { this.contentDescription = contentDescription },
            interactionSource,
            enabled,
            radius,
            onClick,
        ),
        color,
        radius,
    ) {
        CompositionLocalProvider(
            LocalPleosContentColor provides
                c[if (enabled) "icon/dark/primary" else "icon/dark/quaternary"]
        ) {
            Box(Modifier.size(glyph).align(Alignment.Center), contentAlignment = Alignment.Center) {
                icon()
            }
        }
    }
}
