package com.jade.pleos.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.jade.pleos.tokens.*

enum class PleosFieldSize {
    Small,
    Medium,
}

enum class PleosFieldType {
    Text,
    Tel,
    Url,
    Email,
    Password,
}

enum class PleosNumberFieldSize {
    Medium,
    Large,
}

/**
 * 03 §1 / F01. TextFieldValue는 선택·IME composition을 유지합니다. String 편의 API는 내부 편집 선택을 보완합니다. readOnly는
 * 선택을 허용하며 값 변경·clear는 차단합니다. 비밀번호 의미론도 마스킹합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의
 * 14_figma_fields.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    type: PleosFieldType = PleosFieldType.Text,
    size: PleosFieldSize = PleosFieldSize.Medium,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    invalid: String? = null,
    label: String? = null,
    placeholder: String = "",
    supportingText: String? = null,
    suffix: (@Composable () -> Unit)? = null,
    passwordVisible: Boolean = false,
    onPasswordVisibilityChange: ((Boolean) -> Unit)? = null,
    clearable: Boolean = true,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    imeAction: ImeAction = ImeAction.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val cursorWidthPixels =
        with(LocalDensity.current) { m.dp("fields/text/cursor_width", 3f).toPx() }
    val small = size == PleosFieldSize.Small
    val caps = LocalPleosCapabilities.current
    val active = enabled && caps.textInput
    val editable = active && !readOnly
    var focused by remember { mutableStateOf(false) }
    val editorScroll = rememberScrollState()
    var textLayout by remember { mutableStateOf<TextLayoutResult?>(null) }
    var viewportPixels by remember { mutableIntStateOf(0) }
    var innerOffset by remember { mutableStateOf(Offset.Zero) }
    val p = "fields/text/${size.name.lowercase()}/"
    val h = m.dp(p + "height", if (small) 80f else 100f)
    val pad = m.dp(p + "padding_horizontal", if (small) 24f else 32f)
    val gap = m.dp(p + "gap_horizontal", if (small) 12f else 16f)
    val glyph = m.dp(p + "suffix_icon_square", if (small) 40f else 48f)
    val actionSize = maxOf(glyph, PleosTheme.behavior.minimumTouchTarget)
    val textStyle =
        pleosTextStyle(if (small) 30 else 36, if (small) 38 else 44)
            .copy(color = c[if (active) "text/dark/primary" else "text/dark/quaternary"])
    val transformation =
        if (type == PleosFieldType.Password && !passwordVisible) PasswordVisualTransformation()
        else VisualTransformation.None
    val kt =
        when (type) {
            PleosFieldType.Text -> KeyboardType.Text
            PleosFieldType.Tel -> KeyboardType.Phone
            PleosFieldType.Url -> KeyboardType.Uri
            PleosFieldType.Email -> KeyboardType.Email
            PleosFieldType.Password -> KeyboardType.Password
        }
    LaunchedEffect(
        value.selection,
        textLayout,
        viewportPixels,
        focused,
        innerOffset,
        cursorWidthPixels,
    ) {
        val layout = textLayout
        if (focused && layout != null && viewportPixels > 0) {
            val cursor =
                layout.getCursorRect(
                    value.selection.end.coerceIn(0, layout.layoutInput.text.length)
                )
            val left = (cursor.left + innerOffset.x).toInt()
            val right = kotlin.math.ceil(cursor.left + innerOffset.x + cursorWidthPixels).toInt()
            if (left < editorScroll.value) editorScroll.scrollTo(left.coerceAtLeast(0))
            else if (right > editorScroll.value + viewportPixels)
                editorScroll.scrollTo((right - viewportPixels).coerceAtLeast(0))
        }
    }
    Column(modifier) {
        label?.let {
            PleosText(it, Modifier.clearAndSetSemantics {}, style = pleosTextStyle(26, 34))
            Spacer(Modifier.height(8.dp))
        }
        PleosSurface(
            Modifier.fillMaxWidth(),
            c[if (readOnly || !active) "surface/high" else "field/background"],
            m.dp("fields/text/medium/radius_top_left", 24f),
            c[
                if (invalid != null) "regulation/red"
                else if (focused && editable) "field/focused" else "divider/secondary"],
            if (invalid != null || focused && editable) m.dp("fields/text/medium/border", 3f)
            else m.dp("fields/text/small/border", 2f),
        ) {
            BasicTextField(
                value,
                { if (editable || active && readOnly && it.text == value.text) onValueChange(it) },
                Modifier.fillMaxWidth()
                    .defaultMinSize(minHeight = h)
                    .onFocusChanged { focused = it.isFocused }
                    .focusIndication(
                        interactionSource,
                        m.dp("fields/text/medium/radius_top_left", 24f),
                    )
                    .semantics {
                        if (!label.isNullOrBlank() || placeholder.isNotBlank())
                            contentDescription = label ?: placeholder
                        if (type == PleosFieldType.Password) {
                            password()
                            val protected = AnnotatedString("•".repeat(value.text.length))
                            this[SemanticsProperties.InputText] = protected
                            this[SemanticsProperties.EditableText] = protected
                        }
                        invalid?.let { error(it) }
                        if (!enabled || !caps.textInput) disabled()
                        if (!caps.textInput) stateDescription = caps.restrictionReason
                    },
                enabled = active,
                readOnly = readOnly,
                textStyle = textStyle,
                singleLine = true,
                interactionSource = interactionSource,
                visualTransformation = transformation,
                keyboardOptions = KeyboardOptions(keyboardType = kt, imeAction = imeAction),
                keyboardActions = keyboardActions,
                cursorBrush = SolidColor(Color.Transparent),
                onTextLayout = { textLayout = it },
                decorationBox = { inner ->
                    Row(
                        Modifier.padding(horizontal = pad, vertical = 16.dp)
                            .heightIn(min = h - 32.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
                            if (value.text.isEmpty())
                                PleosText(
                                    placeholder,
                                    color = c.scoped(.64f, "text/dark/tertiary"),
                                    style = textStyle,
                                    maxLines = 1,
                                    modifier = Modifier.clearAndSetSemantics {},
                                )
                            BoxWithConstraints(
                                Modifier.alpha(if (!focused && value.text.isNotEmpty()) 0f else 1f)
                            ) {
                                val viewport = maxWidth
                                val density = LocalDensity.current
                                SideEffect {
                                    viewportPixels = with(density) { viewport.roundToPx() }
                                }
                                Box(
                                    Modifier.horizontalScroll(
                                        editorScroll,
                                        enabled = focused || readOnly,
                                    )
                                ) {
                                    Box(
                                        Modifier.widthIn(min = viewport)
                                            .drawWithContent {
                                                drawContent()
                                                val layout = textLayout
                                                if (
                                                    focused &&
                                                        editable &&
                                                        value.selection.collapsed &&
                                                        layout != null
                                                ) {
                                                    val transformed =
                                                        transformation.filter(
                                                            AnnotatedString(value.text)
                                                        )
                                                    val index =
                                                        transformed.offsetMapping
                                                            .originalToTransformed(
                                                                value.selection.end
                                                            )
                                                            .coerceIn(
                                                                0,
                                                                layout.layoutInput.text.length,
                                                            )
                                                    val rect = layout.getCursorRect(index)
                                                    val cursorWidth =
                                                        m.dp("fields/text/cursor_width", 3f).toPx()
                                                    val cursorHeight =
                                                        m.dp("fields/text/cursor_height", 32f)
                                                            .toPx()
                                                    drawRect(
                                                        c["field/focused"],
                                                        Offset(
                                                            rect.left + innerOffset.x,
                                                            (this.size.height - cursorHeight) / 2,
                                                        ),
                                                        Size(cursorWidth, cursorHeight),
                                                    )
                                                }
                                            }
                                            .absolutePadding(
                                                right = m.dp("fields/text/cursor_width", 3f)
                                            )
                                    ) {
                                        Box(
                                            Modifier.onGloballyPositioned {
                                                innerOffset = it.positionInParent()
                                            }
                                        ) {
                                            inner()
                                        }
                                    }
                                }
                            }
                            if (!focused && value.text.isNotEmpty())
                                PleosText(
                                    transformation.filter(AnnotatedString(value.text)).text.text,
                                    style = textStyle,
                                    maxLines = 1,
                                    modifier = Modifier.clearAndSetSemantics {},
                                )
                        }
                        val eye =
                            type == PleosFieldType.Password && onPasswordVisibilityChange != null
                        if (
                            suffix != null ||
                                eye ||
                                focused && value.text.isNotEmpty() && clearable && !readOnly
                        ) {
                            Spacer(Modifier.width(gap))
                            when {
                                suffix != null ->
                                    Box(
                                        Modifier.sizeIn(minWidth = 48.dp, minHeight = 48.dp),
                                        contentAlignment = Alignment.Center,
                                    ) {
                                        suffix()
                                    }
                                eye ->
                                    PleosIconButton(
                                        if (passwordVisible) "비밀번호 숨기기" else "비밀번호 표시",
                                        { onPasswordVisibilityChange?.invoke(!passwordVisible) },
                                        Modifier.size(actionSize),
                                        style = PleosIconButtonStyle.Plain,
                                        size = PleosButtonSize.Small,
                                        enabled = active,
                                        metrics =
                                            IconButtonMetrics(
                                                smallSize = actionSize,
                                                smallIcon = glyph,
                                            ),
                                    ) {
                                        PleosIcon(
                                            if (passwordVisible)
                                                R.drawable.pleos_ic_eye_on_false__67_26985
                                            else R.drawable.pleos_ic_eye_on_true__67_26988,
                                            Modifier.fillMaxSize(),
                                        )
                                    }
                                else ->
                                    PleosIconButton(
                                        "입력 지우기",
                                        { onValueChange(TextFieldValue()) },
                                        Modifier.size(actionSize),
                                        style = PleosIconButtonStyle.Plain,
                                        size = PleosButtonSize.Small,
                                        enabled = editable,
                                        metrics =
                                            IconButtonMetrics(
                                                smallSize = actionSize,
                                                smallIcon = glyph,
                                            ),
                                    ) {
                                        PleosIcon(CloseIcon, Modifier.fillMaxSize())
                                    }
                            }
                        }
                    }
                },
            )
        }
        (invalid ?: supportingText)?.let {
            Spacer(Modifier.height(m.dp(p + "help_text_gap_vertical", if (small) 12f else 16f)))
            PleosText(
                it,
                Modifier.padding(horizontal = 16.dp),
                color = c[if (invalid != null) "regulation/red" else "text/dark/secondary"],
                style = pleosTextStyle(26, 34),
            )
        }
    }
}

/**
 * 03 §1 / F01. TextFieldValue는 선택·IME composition을 유지합니다. String 편의 API는 내부 편집 선택을 보완합니다. readOnly는
 * 선택을 허용하며 값 변경·clear는 차단합니다. 비밀번호 의미론도 마스킹합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의
 * 14_figma_fields.md 항목을 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    type: PleosFieldType = PleosFieldType.Text,
    size: PleosFieldSize = PleosFieldSize.Medium,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    invalid: String? = null,
    placeholder: String = "",
    supportingText: String? = null,
    passwordVisible: Boolean = false,
    onPasswordVisibilityChange: ((Boolean) -> Unit)? = null,
    suffix: (@Composable () -> Unit)? = null,
    label: String? = null,
    clearable: Boolean = true,
    imeAction: ImeAction = ImeAction.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    var editing by remember { mutableStateOf(TextFieldValue(value)) }
    val current =
        if (editing.text == value) editing
        else editing.copy(text = value, selection = TextRange(value.length), composition = null)
    PleosTextField(
        current,
        {
            editing = it
            if (it.text != value) onValueChange(it.text)
        },
        modifier,
        type,
        size,
        enabled,
        readOnly,
        invalid,
        label = label,
        clearable = clearable,
        imeAction = imeAction,
        keyboardActions = keyboardActions,
        placeholder = placeholder,
        supportingText = supportingText,
        passwordVisible = passwordVisible,
        onPasswordVisibilityChange = onPasswordVisibilityChange,
        suffix = suffix,
    )
}

/**
 * 03 §2 / F02. digitCount>0·외부 ASCII 숫자·길이 이내를 요구합니다. 붙여넣기는 ASCII로 필터링하고 길이를 자릅니다. 선행 0을 유지하며 기존 칸
 * 탭은 해당 자리 덮어쓰기입니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 14_figma_fields.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosNumberField(
    value: String,
    onValueChange: (String) -> Unit,
    digitCount: Int,
    modifier: Modifier = Modifier,
    size: PleosNumberFieldSize = PleosNumberFieldSize.Medium,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    invalid: String? = null,
    obscured: Boolean = false,
    onComplete: ((String) -> Unit)? = null,
) {
    require(digitCount > 0 && value.length <= digitCount && value.all { it in '0'..'9' })
    val c = PleosTheme.colors
    val caps = LocalPleosCapabilities.current
    val active = enabled && caps.textInput
    var focused by remember { mutableStateOf(false) }
    val m = PleosTheme.metrics
    val large = size == PleosNumberFieldSize.Large
    val width =
        m.dp(
            if (large) "fields/number/large_width" else "fields/number/medium_square",
            if (large) 140f else 128f,
        )
    val height =
        m.dp(
            if (large) "fields/number/large_height" else "fields/number/medium_square",
            if (large) 180f else 128f,
        )
    val numberStyle = pleosTextStyle(60, 80, FontWeight.ExtraBold)
    val contentHeight = with(LocalDensity.current) { numberStyle.lineHeight.toDp() }
    val cellHeight = maxOf(height, contentHeight)
    val keyboard = LocalSoftwareKeyboardController.current
    val requester = remember { FocusRequester() }
    var editing by remember { mutableStateOf(TextFieldValue(value, TextRange(value.length))) }
    val current =
        if (editing.text == value) editing
        else editing.copy(text = value, selection = TextRange(value.length), composition = null)
    Box(modifier.horizontalScroll(rememberScrollState()).semantics(mergeDescendants = true) {}) {
        BasicTextField(
            current,
            { next ->
                if (active && readOnly && next.text == value) editing = next
                else if (active && !readOnly) {
                    val accepted = next.text.filter { it in '0'..'9' }.take(digitCount)
                    fun mapped(offset: Int) =
                        next.text
                            .take(offset)
                            .count { it in '0'..'9' }
                            .coerceAtMost(accepted.length)
                    editing =
                        TextFieldValue(
                            accepted,
                            TextRange(mapped(next.selection.start), mapped(next.selection.end)),
                        )
                    if (accepted != value) {
                        onValueChange(accepted)
                        if (accepted.length == digitCount) onComplete?.invoke(accepted)
                    }
                }
            },
            Modifier.focusRequester(requester)
                .onFocusChanged { focused = it.isFocused }
                .semantics {
                    if (obscured)
                        this[SemanticsProperties.InputText] =
                            AnnotatedString("•".repeat(value.length))
                    invalid?.let { error(it) }
                    if (!caps.textInput) stateDescription = caps.restrictionReason
                },
            enabled = active,
            readOnly = readOnly,
            singleLine = true,
            keyboardOptions =
                KeyboardOptions(
                    keyboardType =
                        if (obscured) KeyboardType.NumberPassword else KeyboardType.Number
                ),
            visualTransformation =
                if (obscured) PasswordVisualTransformation() else VisualTransformation.None,
            textStyle = numberStyle,
            decorationBox = { inner ->
                Box {
                    Box(Modifier.size(1.dp).alpha(0f)) { inner() }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        modifier = Modifier.clearAndSetSemantics {},
                    ) {
                        repeat(digitCount) { i ->
                            val focus =
                                focused &&
                                    active &&
                                    i == current.selection.start.coerceAtMost(digitCount - 1)
                            PleosSurface(
                                Modifier.width(width).heightIn(min = cellHeight).clickable(
                                    enabled = active && !readOnly
                                ) {
                                    editing =
                                        current.copy(
                                            selection =
                                                if (i < value.length) TextRange(i, i + 1)
                                                else TextRange(value.length)
                                        )
                                    requester.requestFocus()
                                    keyboard?.show()
                                },
                                if (focus) c["dim/dark/secondary"]
                                else if (!active || readOnly) c["surface/high"]
                                else androidx.compose.ui.graphics.Color.Transparent,
                                m.dp("fields/number/input_radius_top_left", 32f),
                                c[
                                    if (invalid != null) "regulation/red"
                                    else if (focus) "field/focused" else "divider/secondary"],
                                m.dp("fields/number/border", 4f),
                            ) {
                                if (i < value.length)
                                    PleosText(
                                        if (obscured) "•" else value[i].toString(),
                                        Modifier.align(Alignment.Center),
                                        style = numberStyle,
                                        color =
                                            c[
                                                if (active) "text/dark/primary"
                                                else "text/dark/quaternary"],
                                        textAlign = TextAlign.Center,
                                    )
                                else if (focus)
                                    Box(
                                        Modifier.align(Alignment.Center)
                                            .width(m.dp("fields/number/cursor_width", 4f))
                                            .height(m.dp("fields/number/cursor_height", 48f))
                                            .background(c["field/focused"])
                                    )
                            }
                        }
                    }
                }
            },
        )
    }
}
