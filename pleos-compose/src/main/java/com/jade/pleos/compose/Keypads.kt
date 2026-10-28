package com.jade.pleos.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.jade.pleos.tokens.*
import java.text.BreakIterator
import java.util.Locale

sealed interface PleosKeyAction {
    data class Character(val text: String) : PleosKeyAction

    data object DeleteBackward : PleosKeyAction

    data object ClearAll : PleosKeyAction

    data class ShiftChanged(val shifted: Boolean) : PleosKeyAction

    data object LanguageRequested : PleosKeyAction

    data object SymbolsRequested : PleosKeyAction

    data object Space : PleosKeyAction

    data object Submit : PleosKeyAction

    data object VoiceRequested : PleosKeyAction
}

/** 한글 조합 및 음성 서비스는 호스트가 승인한 입력 경로로 처리합니다. */
fun interface PleosTextInputAdapter {
    fun onKey(action: PleosKeyAction)
}

enum class PleosKeyboardPalette {
    Normal,
    Static,
}

enum class PleosKeyboardLanguage {
    English,
    Korean,
}

enum class PleosKeyboardMode {
    Text,
    Voice,
}

enum class PleosVoiceState {
    Idle,
    Listening,
    Error,
    Complete,
}

enum class PleosKeyboardKeyKind {
    Primary,
    Delete,
    Shift,
    Secondary,
    Mic,
    Hyphen,
    Space,
    Enter,
}

sealed interface PleosNumericKeyKind {
    data class Number(val digit: Int) : PleosNumericKeyKind {
        init {
            require(digit in 0..9)
        }
    }

    data object Delete : PleosNumericKeyKind

    data class Function(
        val text: String = "지우기",
        val action: PleosKeyAction = PleosKeyAction.ClearAll,
    ) : PleosNumericKeyKind
}

data class NumericKeypadLayoutMetrics(
    val columnGap: Dp = 24.dp,
    val rowGap: Dp = 40.dp,
    val contentPadding: Dp = 48.dp,
    val fieldToKeysGap: Dp = 48.dp,
)

data class KeyboardLayoutMetrics(
    val columnGap: Dp = 10.dp,
    val rowGap: Dp = 10.dp,
    val sidePadding: Dp = 24.dp,
    val topWithHandle: Dp = 56.dp,
    val topWithoutHandle: Dp = 24.dp,
    val bottomPadding: Dp = 24.dp,
    val radius: Dp = 50.dp,
    val spaceMinWidth: Dp = 300.dp,
)

/**
 * 02 §6 / A05. 입력은 typed key action으로 전달합니다. 크기는 Dp이며 숫자는 0~9입니다. 실제 한글 조합·음성은 호스트 입력 adapter가
 * 담당합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은
 * 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
fun reducePleosText(value: String, action: PleosKeyAction): String =
    when (action) {
        is PleosKeyAction.Character -> value + action.text
        PleosKeyAction.Space -> value + " "
        PleosKeyAction.ClearAll -> ""
        PleosKeyAction.DeleteBackward -> {
            if (value.isEmpty()) value
            else {
                val b = BreakIterator.getCharacterInstance(Locale.ROOT)
                b.setText(value)
                value.substring(0, b.preceding(value.length).coerceAtLeast(0))
            }
        }
        else -> value
    }

/**
 * 02 §6 / A05. 입력은 typed key action으로 전달합니다. 크기는 Dp이며 숫자는 0~9입니다. 실제 한글 조합·음성은 호스트 입력 adapter가
 * 담당합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은
 * 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosNumericKey(
    kind: PleosNumericKeyKind,
    onKey: (PleosKeyAction) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val pressed by interactionSource.collectIsPressedAsState()
    val active = enabled && LocalPleosCapabilities.current.textInput
    val action =
        when (kind) {
            is PleosNumericKeyKind.Number -> PleosKeyAction.Character(kind.digit.toString())
            PleosNumericKeyKind.Delete -> PleosKeyAction.DeleteBackward
            is PleosNumericKeyKind.Function -> kind.action
        }
    val radius = m.dp("buttons/keypad/radius_top_left", 32f)
    val fill =
        c[
            if (kind is PleosNumericKeyKind.Number)
                "keyboard/normal/primary_${if(pressed&&active)"pressed" else "normal"}"
            else "surface/accent"]
    PleosSurface(
        actionModifier(
            modifier.defaultMinSize(
                m.dp("buttons/keypad/min_width", 200f),
                m.dp("buttons/keypad/height", 108f),
            ),
            interactionSource,
            active,
            radius,
            { onKey(action) },
        ),
        fill,
        radius,
    ) {
        Box(Modifier.align(Alignment.Center), contentAlignment = Alignment.Center) {
            when (kind) {
                is PleosNumericKeyKind.Number ->
                    PleosText(
                        kind.digit.toString(),
                        style = pleosTextStyle(56, 72, FontWeight.Bold),
                        color = c[if (active) "text/dark/primary" else "text/dark/quaternary"],
                    )
                is PleosNumericKeyKind.Function ->
                    PleosText(
                        kind.text,
                        style = pleosTextStyle(40, 52),
                        color = c[if (active) "text/dark/primary" else "text/dark/quaternary"],
                    )
                PleosNumericKeyKind.Delete ->
                    PleosIcon(
                        R.drawable.pleos_ic_keyboard_type_delete__67_22445,
                        Modifier.size(m.dp("buttons/keypad/icon", 48f)),
                        "한 글자 지우기",
                        c[if (active) "icon/dark/primary" else "icon/dark/quaternary"],
                    )
            }
        }
        if (pressed && active && kind !is PleosNumericKeyKind.Number)
            Box(Modifier.matchParentSize().background(c["dim/dark/tertiary"]))
    }
}

/**
 * 02 §6 / A05. 입력은 typed key action으로 전달합니다. 크기는 Dp이며 숫자는 0~9입니다. 실제 한글 조합·음성은 호스트 입력 adapter가
 * 담당합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은
 * 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosNumericKeypad(
    onKey: (PleosKeyAction) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    canDelete: Boolean = true,
    function: PleosNumericKeyKind.Function = PleosNumericKeyKind.Function(),
    metrics: NumericKeypadLayoutMetrics = NumericKeypadLayoutMetrics(),
    field: (@Composable () -> Unit)? = null,
) {
    val m = PleosTheme.metrics
    val keyWidth = m.dp("buttons/keypad/min_width", 200f)
    val intrinsic = metrics.contentPadding * 2 + keyWidth * 3 + metrics.columnGap * 2
    BoxWithConstraints(modifier) {
        val w = if (maxWidth == Dp.Infinity) intrinsic else maxOf(intrinsic, maxWidth)
        Column(
            Modifier.horizontalScroll(rememberScrollState())
                .width(w)
                .padding(metrics.contentPadding),
            verticalArrangement = Arrangement.spacedBy(metrics.rowGap),
        ) {
            if (field != null) {
                field()
                Spacer(
                    Modifier.height((metrics.fieldToKeysGap - metrics.rowGap).coerceAtLeast(0.dp))
                )
            }
            repeat(4) { row ->
                Row(horizontalArrangement = Arrangement.spacedBy(metrics.columnGap)) {
                    repeat(3) { col ->
                        val n = row * 3 + col
                        val kind =
                            when (n) {
                                9 -> function
                                10 -> PleosNumericKeyKind.Number(0)
                                11 -> PleosNumericKeyKind.Delete
                                else -> PleosNumericKeyKind.Number(n + 1)
                            }
                        PleosNumericKey(
                            kind,
                            onKey,
                            Modifier.weight(1f),
                            enabled &&
                                (canDelete ||
                                    kind !is PleosNumericKeyKind.Delete &&
                                        (kind !is PleosNumericKeyKind.Function ||
                                            kind.action != PleosKeyAction.ClearAll)),
                        )
                    }
                }
            }
        }
    }
}

/**
 * 02 §6 / A05. 입력은 typed key action으로 전달합니다. 크기는 Dp이며 숫자는 0~9입니다. 실제 한글 조합·음성은 호스트 입력 adapter가
 * 담당합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은
 * 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosKeyboardKey(
    kind: PleosKeyboardKeyKind,
    onKey: (PleosKeyAction) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    shifted: Boolean = false,
    palette: PleosKeyboardPalette = PleosKeyboardPalette.Normal,
    enabled: Boolean = true,
    action: PleosKeyAction? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val m = PleosTheme.metrics
    val c = PleosTheme.colors
    val pressed by interactionSource.collectIsPressedAsState()
    val active = enabled && LocalPleosCapabilities.current.textInput
    val key = "keyboard/keyword/"
    val width =
        when (kind) {
            PleosKeyboardKeyKind.Primary -> m.dp(key + "normal_width", 100f)
            PleosKeyboardKeyKind.Shift -> m.dp(key + "shift_width", 165f)
            PleosKeyboardKeyKind.Space -> 300.dp
            PleosKeyboardKeyKind.Enter -> m.dp(key + "enter_width", 200f)
            else -> m.dp(key + "special_width", 120f)
        }
    val event =
        action
            ?: when (kind) {
                PleosKeyboardKeyKind.Primary -> PleosKeyAction.Character(label)
                PleosKeyboardKeyKind.Delete -> PleosKeyAction.DeleteBackward
                PleosKeyboardKeyKind.Shift -> PleosKeyAction.ShiftChanged(!shifted)
                PleosKeyboardKeyKind.Secondary -> PleosKeyAction.LanguageRequested
                PleosKeyboardKeyKind.Mic -> PleosKeyAction.VoiceRequested
                PleosKeyboardKeyKind.Hyphen -> PleosKeyAction.Character("-")
                PleosKeyboardKeyKind.Space -> PleosKeyAction.Space
                PleosKeyboardKeyKind.Enter -> PleosKeyAction.Submit
            }
    val role =
        when {
            kind == PleosKeyboardKeyKind.Enter -> "accents"
            kind == PleosKeyboardKeyKind.Shift && shifted -> "active"
            kind == PleosKeyboardKeyKind.Primary || kind == PleosKeyboardKeyKind.Space -> "primary"
            else -> "secondary"
        }
    val pal = palette.name.lowercase()
    val radius = m.dp(key + "radius_top_left", 20f)
    val icon =
        when (kind) {
            PleosKeyboardKeyKind.Delete -> R.drawable.pleos_ic_keyboard_type_delete__67_22445
            PleosKeyboardKeyKind.Shift ->
                if (shifted) R.drawable.pleos_ic_keyboard_type_shift_active__67_22457
                else R.drawable.pleos_ic_keyboard_type_shift__67_22452
            PleosKeyboardKeyKind.Mic -> R.drawable.pleos_ic_mic_on_on__67_22337
            PleosKeyboardKeyKind.Enter -> R.drawable.pleos_ic_keyboard_type_enter__67_22460
            else -> null
        }
    val desc =
        when (kind) {
            PleosKeyboardKeyKind.Delete -> "한 글자 지우기"
            PleosKeyboardKeyKind.Shift -> "대문자 전환"
            PleosKeyboardKeyKind.Mic -> "음성 입력"
            PleosKeyboardKeyKind.Enter -> "입력 완료"
            PleosKeyboardKeyKind.Space -> "공백"
            else -> label
        }
    PleosSurface(
        actionModifier(
            modifier.defaultMinSize(width, m.dp(key + "height", 80f)).semantics {
                contentDescription = desc
                if (kind == PleosKeyboardKeyKind.Shift)
                    stateDescription = if (shifted) "켜짐" else "꺼짐"
            },
            interactionSource,
            active,
            radius,
            { onKey(event) },
        ),
        c["keyboard/$pal/${role}_${if(pressed&&active)"pressed" else "normal"}"],
        radius,
    ) {
        val foreground =
            c[
                if (!active && icon != null && palette == PleosKeyboardPalette.Static)
                    "keyboard/static/icon_disabled"
                else if (!active) "text/dark/quaternary"
                else if (kind == PleosKeyboardKeyKind.Shift && shifted) "informative/active"
                else if (icon != null && palette == PleosKeyboardPalette.Static)
                    if (kind == PleosKeyboardKeyKind.Enter) "keyboard/static/icon_dark"
                    else "keyboard/static/icon_light"
                else if (palette == PleosKeyboardPalette.Static) "keyboard/static/text"
                else if (role == "active" || role == "accents") "text/light/primary"
                else "text/dark/primary"]
        if (icon != null)
            PleosIcon(
                icon,
                Modifier.size(m.dp(key + "icon_square", 44f))
                    .align(
                        if (kind == PleosKeyboardKeyKind.Shift) Alignment.CenterStart
                        else Alignment.Center
                    )
                    .then(
                        if (kind == PleosKeyboardKeyKind.Shift)
                            Modifier.offset(x = m.dp("Common/20", 20f))
                        else Modifier
                    ),
                tint = foreground,
            )
        else
            PleosText(
                if (kind == PleosKeyboardKeyKind.Space) label else label,
                Modifier.align(Alignment.Center).clearAndSetSemantics {},
                foreground,
                pleosTextStyle(
                    if (kind == PleosKeyboardKeyKind.Secondary) 36
                    else if (kind == PleosKeyboardKeyKind.Space) 32 else 40,
                    if (kind == PleosKeyboardKeyKind.Secondary) 44
                    else if (kind == PleosKeyboardKeyKind.Space) 40 else 52,
                ),
            )
    }
}

/**
 * 02 §6 / A05. 입력은 typed key action으로 전달합니다. 크기는 Dp이며 숫자는 0~9입니다. 실제 한글 조합·음성은 호스트 입력 adapter가
 * 담당합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 10_figma_actions.md 항목을 참조합니다. 기본값·유효 타입은
 * 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosKeyboard(
    onKey: (PleosKeyAction) -> Unit,
    modifier: Modifier = Modifier,
    language: PleosKeyboardLanguage = PleosKeyboardLanguage.English,
    shifted: Boolean = false,
    symbols: Boolean = false,
    palette: PleosKeyboardPalette = PleosKeyboardPalette.Normal,
    enabled: Boolean = true,
    mode: PleosKeyboardMode = PleosKeyboardMode.Text,
    voiceState: PleosVoiceState = PleosVoiceState.Idle,
    showHandle: Boolean = true,
    metrics: KeyboardLayoutMetrics = KeyboardLayoutMetrics(),
    voiceContent: (@Composable (PleosVoiceState) -> Unit)? = null,
) {
    val m = PleosTheme.metrics
    val inputEnabled = enabled && LocalPleosCapabilities.current.textInput
    val primary = m.dp("keyboard/keyword/normal_width", 100f)
    val special = m.dp("keyboard/keyword/special_width", 120f)
    val enter = m.dp("keyboard/keyword/enter_width", 200f)
    val intrinsic =
        maxOf(
            primary * 10 + special + metrics.columnGap * 10,
            special * 4 + enter + metrics.spaceMinWidth + metrics.columnGap * 5,
        ) + metrics.sidePadding * 2
    BoxWithConstraints(modifier) {
        val width = if (maxWidth == Dp.Infinity) intrinsic else maxOf(maxWidth, intrinsic)
        PleosSurface(
            Modifier.horizontalScroll(rememberScrollState()).width(width),
            PleosTheme.colors["keyboard/${palette.name.lowercase()}/background"],
            metrics.radius,
        ) {
            if (mode == PleosKeyboardMode.Voice) {
                Column(
                    Modifier.fillMaxWidth().padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    if (voiceContent != null) voiceContent(voiceState)
                    else
                        PleosText(
                            when (voiceState) {
                                PleosVoiceState.Idle -> "음성 입력 대기"
                                PleosVoiceState.Listening -> "듣고 있습니다"
                                PleosVoiceState.Error -> "음성 입력을 다시 시도하십시오"
                                PleosVoiceState.Complete -> "음성 입력 완료"
                            }
                        )
                    PleosBasicButton(
                        "음성 입력 요청",
                        { onKey(PleosKeyAction.VoiceRequested) },
                        enabled = inputEnabled,
                    )
                    PleosTextButton(
                        "문자 입력",
                        { onKey(PleosKeyAction.LanguageRequested) },
                        enabled = inputEnabled,
                    )
                }
            } else {
                if (showHandle)
                    Box(
                        Modifier.padding(top = 16.dp)
                            .size(140.dp, 8.dp)
                            .align(Alignment.TopCenter)
                            .background(
                                PleosTheme.colors["basic_alpha_dark_200"],
                                androidx.compose.foundation.shape.RoundedCornerShape(4.dp),
                            )
                    )
                val korean = language == PleosKeyboardLanguage.Korean
                val rows =
                    if (symbols)
                        listOf("! @ # $ % ^ & * ( )", "[ ] { } < > = + _", "\\ | / : ; , . ? ~")
                    else if (korean)
                        listOf("ㅂ ㅈ ㄷ ㄱ ㅅ ㅛ ㅕ ㅑ ㅐ ㅔ", "ㅁ ㄴ ㅇ ㄹ ㅎ ㅗ ㅓ ㅏ ㅣ", "ㅋ ㅌ ㅊ ㅍ ㅠ ㅜ ㅡ , .")
                    else listOf("Q W E R T Y U I O P", "A S D F G H J K L", "Z X C V B N M , .")
                Column(
                    Modifier.padding(
                        start = metrics.sidePadding,
                        end = metrics.sidePadding,
                        top = if (showHandle) metrics.topWithHandle else metrics.topWithoutHandle,
                        bottom = metrics.bottomPadding,
                    ),
                    verticalArrangement = Arrangement.spacedBy(metrics.rowGap),
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement =
                            Arrangement.spacedBy(metrics.columnGap, Alignment.CenterHorizontally),
                    ) {
                        "1234567890"
                            .forEach {
                                PleosKeyboardKey(
                                    PleosKeyboardKeyKind.Primary,
                                    onKey,
                                    label = it.toString(),
                                    palette = palette,
                                    enabled = enabled,
                                )
                            }
                        PleosKeyboardKey(
                            PleosKeyboardKeyKind.Delete,
                            onKey,
                            palette = palette,
                            enabled = enabled,
                        )
                    }
                    rows.forEachIndexed { index, row ->
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement =
                                Arrangement.spacedBy(
                                    metrics.columnGap,
                                    if (index == 2) Alignment.Start
                                    else Alignment.CenterHorizontally,
                                ),
                        ) {
                            if (index == 2)
                                PleosKeyboardKey(
                                    PleosKeyboardKeyKind.Shift,
                                    onKey,
                                    shifted = shifted,
                                    palette = palette,
                                    enabled = enabled,
                                )
                            row.split(' ').forEach { raw ->
                                val text =
                                    if (korean && shifted)
                                        mapOf(
                                            "ㅂ" to "ㅃ",
                                            "ㅈ" to "ㅉ",
                                            "ㄷ" to "ㄸ",
                                            "ㄱ" to "ㄲ",
                                            "ㅅ" to "ㅆ",
                                            "ㅐ" to "ㅒ",
                                            "ㅔ" to "ㅖ",
                                        )[raw] ?: raw
                                    else if (!korean && !shifted) raw.lowercase() else raw
                                PleosKeyboardKey(
                                    PleosKeyboardKeyKind.Primary,
                                    onKey,
                                    label = text,
                                    palette = palette,
                                    enabled = enabled,
                                )
                            }
                        }
                    }
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(metrics.columnGap),
                    ) {
                        PleosKeyboardKey(
                            PleosKeyboardKeyKind.Secondary,
                            onKey,
                            label = if (korean) "A" else "한",
                            palette = palette,
                            enabled = enabled,
                        )
                        PleosKeyboardKey(
                            PleosKeyboardKeyKind.Secondary,
                            onKey,
                            label = if (symbols) "ABC" else "!#",
                            action = PleosKeyAction.SymbolsRequested,
                            palette = palette,
                            enabled = enabled,
                        )
                        PleosKeyboardKey(
                            PleosKeyboardKeyKind.Space,
                            onKey,
                            Modifier.weight(1f),
                            palette = palette,
                            enabled = enabled,
                        )
                        PleosKeyboardKey(
                            PleosKeyboardKeyKind.Mic,
                            onKey,
                            palette = palette,
                            enabled = enabled,
                        )
                        PleosKeyboardKey(
                            PleosKeyboardKeyKind.Hyphen,
                            onKey,
                            label = "-",
                            palette = palette,
                            enabled = enabled,
                        )
                        PleosKeyboardKey(
                            PleosKeyboardKeyKind.Enter,
                            onKey,
                            palette = palette,
                            enabled = enabled,
                        )
                    }
                }
            }
        }
    }
}
