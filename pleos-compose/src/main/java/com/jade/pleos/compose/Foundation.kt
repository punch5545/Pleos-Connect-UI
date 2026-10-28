package com.jade.pleos.compose

import android.graphics.Bitmap
import android.graphics.Canvas as AndroidCanvas
import android.graphics.Paint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.focus.*
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.InputMode
import androidx.compose.ui.input.key.*
import androidx.compose.ui.platform.LocalInputModeManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import com.jade.pleos.tokens.*
import kotlin.math.roundToInt
import kotlinx.coroutines.launch

val LocalPleosContentColor = compositionLocalOf { Color.Unspecified }

/**
 * 01 공통 규칙. 글자는 sp·shape와 shadow는 Dp입니다. decorative icon은 null 설명을 사용하고 대화형 이름은 상위 action이 제공합니다. 큰
 * shadow mask는 제한된 캐시에서 샘플링합니다. 공통 근거는 docs/01_FOUNDATIONS_AND_DISPLAY.md이며 원본 식별자는
 * tools/spec_inventory.json에 보존합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = LocalPleosContentColor.current,
    style: TextStyle = pleosTextStyle(30, 38),
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    textAlign: TextAlign? = null,
) {
    val resolved = if (color == Color.Unspecified) PleosTheme.colors["text/dark/primary"] else color
    BasicText(
        text,
        modifier,
        style.copy(color = resolved, textAlign = textAlign ?: style.textAlign),
        maxLines = maxLines,
        overflow = overflow,
    )
}

/**
 * 01 공통 규칙. 글자는 sp·shape와 shadow는 Dp입니다. decorative icon은 null 설명을 사용하고 대화형 이름은 상위 action이 제공합니다. 큰
 * shadow mask는 제한된 캐시에서 샘플링합니다. 공통 근거는 docs/01_FOUNDATIONS_AND_DISPLAY.md이며 원본 식별자는
 * tools/spec_inventory.json에 보존합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosIcon(
    resource: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color? =
        LocalPleosContentColor.current.takeIf { it != Color.Unspecified }
            ?: PleosTheme.colors["icon/dark/primary"],
) {
    Image(
        painterResource(resource),
        contentDescription,
        modifier,
        colorFilter = tint?.let { ColorFilter.tint(it) },
    )
}

data class PleosShadowLayer(val offsetY: Dp, val blur: Dp, val alpha: Float)

/**
 * 01 공통 규칙. 글자는 sp·shape와 shadow는 Dp입니다. decorative icon은 null 설명을 사용하고 대화형 이름은 상위 action이 제공합니다. 큰
 * shadow mask는 제한된 캐시에서 샘플링합니다. 공통 근거는 docs/01_FOUNDATIONS_AND_DISPLAY.md이며 원본 식별자는
 * tools/spec_inventory.json에 보존합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun Modifier.pleosShadow(radius: Dp, layers: List<PleosShadowLayer>): Modifier =
    if (layers.isEmpty()) this
    else
        then(
            remember(radius, layers) {
                Modifier.drawWithCache {
                    val pad =
                        layers
                            .maxOf { it.blur.toPx() * 2 + it.offsetY.toPx() }
                            .toInt()
                            .coerceAtLeast(1)
                    val w = size.width.toInt() + pad * 2
                    val h = size.height.toInt() + pad * 2
                    val scale =
                        if (w > 0 && h > 0)
                            kotlin.math
                                .min(1.0, kotlin.math.sqrt(1_500_000.0 / (w.toDouble() * h)))
                                .toFloat()
                        else 1f
                    val bitmap =
                        if (w > 0 && h > 0)
                            Bitmap.createBitmap(
                                (w * scale).toInt().coerceAtLeast(1),
                                (h * scale).toInt().coerceAtLeast(1),
                                Bitmap.Config.ARGB_8888,
                            )
                        else null
                    bitmap?.let {
                        val canvas = AndroidCanvas(it)
                        canvas.scale(scale, scale)
                        val p = Paint(Paint.ANTI_ALIAS_FLAG)
                        layers.forEach { layer ->
                            p.color = android.graphics.Color.BLACK
                            p.setShadowLayer(
                                layer.blur.toPx() / 2,
                                0f,
                                layer.offsetY.toPx(),
                                android.graphics.Color.argb(
                                    (layer.alpha * 255).roundToInt(),
                                    0,
                                    0,
                                    0,
                                ),
                            )
                            canvas.drawRoundRect(
                                pad.toFloat(),
                                pad.toFloat(),
                                pad + size.width,
                                pad + size.height,
                                radius.toPx(),
                                radius.toPx(),
                                p,
                            )
                        }
                        p.clearShadowLayer()
                        p.xfermode =
                            android.graphics.PorterDuffXfermode(
                                android.graphics.PorterDuff.Mode.CLEAR
                            )
                        canvas.drawRoundRect(
                            pad.toFloat(),
                            pad.toFloat(),
                            pad + size.width,
                            pad + size.height,
                            radius.toPx(),
                            radius.toPx(),
                            p,
                        )
                    }
                    val img = bitmap?.asImageBitmap()
                    onDrawBehind {
                        if (img != null)
                            drawImage(
                                img,
                                dstOffset = IntOffset(-pad, -pad),
                                dstSize = IntSize(w, h),
                                filterQuality = FilterQuality.High,
                            )
                    }
                }
            }
        )

@Composable
internal fun shadows(level: Int): List<PleosShadowLayer> {
    val m = PleosTheme.metrics
    return when (level) {
        1 ->
            listOf(
                PleosShadowLayer(m.dp("shadow/level1/y", 6f), m.dp("shadow/level1/blur", 24f), .08f)
            )
        2 ->
            listOf(
                PleosShadowLayer(
                    m.dp("shadow/level2/y1", 8f),
                    m.dp("shadow/level2/blur1", 32f),
                    .16f,
                ),
                PleosShadowLayer(
                    m.dp("shadow/level2/y2", 2f),
                    m.dp("shadow/level2/blur2", 2f),
                    .08f,
                ),
            )
        3 ->
            listOf(
                PleosShadowLayer(
                    m.dp("shadow/level3/y1", 20f),
                    m.dp("shadow/level3/blur1", 40f),
                    .24f,
                ),
                PleosShadowLayer(
                    m.dp("shadow/level3/y2", 2f),
                    m.dp("shadow/level3/blur2", 4f),
                    .20f,
                ),
            )
        else -> emptyList()
    }
}

/**
 * 01 공통 규칙. 글자는 sp·shape와 shadow는 Dp입니다. decorative icon은 null 설명을 사용하고 대화형 이름은 상위 action이 제공합니다. 큰
 * shadow mask는 제한된 캐시에서 샘플링합니다. 공통 근거는 docs/01_FOUNDATIONS_AND_DISPLAY.md이며 원본 식별자는
 * tools/spec_inventory.json에 보존합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosSurface(
    modifier: Modifier = Modifier,
    color: Color = PleosTheme.colors["surface/basic"],
    radius: Dp = 24.dp,
    borderColor: Color = Color.Transparent,
    borderWidth: Dp = 0.dp,
    shadowLevel: Int = 0,
    content: @Composable BoxScope.() -> Unit,
) {
    val shape = RoundedCornerShape(radius)
    val duration =
        if (PleosTheme.behavior.reducedMotion || !LocalPleosCapabilities.current.animations) 0
        else PleosTheme.behavior.pressedMillis
    val renderedColor by animateColorAsState(color, tween(duration), label = "pleosSurface")
    Box(
        modifier
            .pleosShadow(radius, shadows(shadowLevel))
            .clip(shape)
            .background(renderedColor)
            .then(
                if (borderWidth > 0.dp) Modifier.border(borderWidth, borderColor, shape)
                else Modifier
            ),
        content = content,
    )
}

@Composable
internal fun Modifier.focusIndication(source: MutableInteractionSource, radius: Dp): Modifier {
    val focused by source.collectIsFocusedAsState()
    val keyboard =
        LocalInputModeManager.current.inputMode == InputMode.Keyboard ||
            LocalPleosInputMode.current != PleosInputMode.Touch
    val b = PleosTheme.behavior
    val color = PleosTheme.colors["informative/positive"]
    return drawWithContent {
        drawContent()
        if (focused && keyboard) {
            val inset = b.focusOffset.toPx() + b.focusWidth.toPx() / 2
            drawRoundRect(
                color,
                Offset(-inset, -inset),
                Size(size.width + inset * 2, size.height + inset * 2),
                CornerRadius(radius.toPx() + inset),
                style = Stroke(b.focusWidth.toPx()),
            )
        }
    }
}

@Composable
internal fun actionModifier(
    modifier: Modifier,
    source: MutableInteractionSource,
    enabled: Boolean,
    radius: Dp,
    onClick: () -> Unit,
    role: Role = Role.Button,
    blocked: Boolean = false,
): Modifier {
    val scope = rememberCoroutineScope()
    var keyboardPress by remember { mutableStateOf<PressInteraction.Press?>(null) }
    var armed by remember { mutableStateOf(false) }
    fun cancelKeyboard() {
        armed = false
        keyboardPress?.let { press -> scope.launch { source.emit(PressInteraction.Cancel(press)) } }
        keyboardPress = null
    }
    LaunchedEffect(enabled, blocked) { if (!enabled || blocked) cancelKeyboard() }
    return modifier
        .sizeIn(
            minWidth = PleosTheme.behavior.minimumTouchTarget,
            minHeight = PleosTheme.behavior.minimumTouchTarget,
        )
        .focusIndication(source, radius)
        .onFocusChanged { if (!it.isFocused) cancelKeyboard() }
        .onKeyEvent { event ->
            if (event.key !in listOf(Key.Enter, Key.NumPadEnter, Key.DirectionCenter, Key.Spacebar))
                false
            else if (event.type == KeyEventType.KeyDown) {
                if (enabled && !blocked && !armed) {
                    armed = true
                    val press = PressInteraction.Press(Offset.Zero)
                    keyboardPress = press
                    scope.launch { source.emit(press) }
                }
                enabled
            } else if (event.type == KeyEventType.KeyUp) {
                val activate = armed && enabled && !blocked
                armed = false
                keyboardPress?.let { press ->
                    scope.launch {
                        source.emit(
                            if (activate) PressInteraction.Release(press)
                            else PressInteraction.Cancel(press)
                        )
                    }
                }
                keyboardPress = null
                if (activate) onClick()
                enabled
            } else false
        }
        // 클릭 처리의 비활성화가 기존 focus까지 제거하지 않도록 입력 focus를 독립시킵니다.
        .focusable(enabled, source)
        .focusProperties { canFocus = false }
        .clickable(source, null, enabled && !blocked, role = role, onClick = onClick)
}

internal val CheckIcon
    get() = R.drawable.pleos_ic_check_type_basic__67_25618
internal val MinusIcon
    get() = R.drawable.pleos_ic_minus__67_25150
internal val PlusIcon
    get() = R.drawable.pleos_ic_plus__67_22174
internal val DownIcon
    get() = R.drawable.pleos_ic_arrow_direction_down__67_22105
internal val BackIcon
    get() = R.drawable.pleos_ic_arrow_direction_left__67_22096
internal val RightIcon
    get() = R.drawable.pleos_ic_arrow_direction_right__67_22099
internal val CloseIcon
    get() = R.drawable.pleos_ic_close_type_basic__67_22415
