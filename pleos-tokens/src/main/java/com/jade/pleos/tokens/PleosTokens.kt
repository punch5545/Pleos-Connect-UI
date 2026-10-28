@file:OptIn(androidx.compose.ui.text.ExperimentalTextApi::class)

package com.jade.pleos.tokens

import android.content.res.Configuration
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.unit.*

/** 조사 스냅샷 메타데이터이며 런타임 규격 전환 옵션이 아닙니다. */
object PleosSpecVersion {
    const val snapshot = "WebLatest20261028"
}

enum class SourceFile {
    Assets,
    Display,
}

sealed interface TokenValue {
    data class Number(val value: Float) : TokenValue

    data class Text(val value: String) : TokenValue

    data class Rgba(val red: Float, val green: Float, val blue: Float, val alpha: Float) :
        TokenValue {
        fun toColor() = Color(red, green, blue, alpha)
    }
}

data class SourceToken(
    val file: SourceFile,
    val id: String,
    val key: String,
    val collectionId: String,
    val collectionKey: String,
    val name: String,
    val modes: Map<String, TokenValue>,
)

/** 원본 감사를 위한 저장소. UI의 최신 색은 [PleosColors]를 사용합니다. */
object PleosSourceTokens {
    val all: List<SourceToken>
        get() = generatedSourceTokens

    fun find(file: SourceFile, id: String): SourceToken =
        all.single { it.file == file && it.id == id }
}

enum class PleosFormFactor(
    val metricMode: String,
    val displayMode: String,
    val landscape: DpSize,
    val portrait: DpSize,
) {
    Standard17("connect-s", "connect-s", DpSize(1700.dp, 1184.dp), DpSize(840.dp, 1184.dp)),
    Standard14_6("connect-s", "connect-s-14", DpSize(1360.dp, 948.dp), DpSize(672.dp, 948.dp)),
    Legacy12_9("connect-l", "connect-l", DpSize(1274.dp, 855.dp), DpSize(628.dp, 855.dp)),
    Wide("connect-w", "connect-w", DpSize(1640.dp, 810.dp), DpSize(800.dp, 810.dp)),
    WideExtended("connect-w", "connect-w", DpSize(1640.dp, 1400.dp), DpSize(800.dp, 1400.dp)),
    Waterfall(
        "connect-waterfall",
        "connect-waterfall",
        DpSize(1256.dp, 800.dp),
        DpSize(648.dp, 800.dp),
    ),
    Standard15_6("connect-s", "mode:92233:0", DpSize(1408.dp, 1018.dp), DpSize(692.dp, 1018.dp)),
}

enum class PleosInputMode {
    Touch,
    Keyboard,
    Rotary,
}

@Immutable
data class PleosCapabilities(
    val textInput: Boolean = false,
    val complexInteraction: Boolean = false,
    val animations: Boolean = false,
    val video: Boolean = false,
    val systemNotifications: Boolean = false,
    val restrictionReason: String = "호스트의 사용 제한 정보를 기다리고 있습니다.",
) {
    companion object {
        val Unrestricted = PleosCapabilities(true, true, true, true, true, "")
    }
}

/** 공식 수치가 없는 보완 정책입니다. 01 §7 및 08 §4. */
@Immutable
data class PleosBehaviorDefaults(
    val pressedMillis: Int = 120,
    val expandMillis: Int = 200,
    val focusWidth: Dp = 4.dp,
    val focusOffset: Dp = 4.dp,
    val minimumTouchTarget: Dp = 48.dp,
    val shortToastMillis: Long = 3000,
    val longToastMillis: Long = 5000,
    val maxQueuedToasts: Int = 3,
    val widgetHideFraction: Float = .35f,
    val reducedMotion: Boolean = false,
) {
    init {
        require(
            pressedMillis >= 0 &&
                expandMillis >= 0 &&
                shortToastMillis > 0 &&
                longToastMillis > 0 &&
                maxQueuedToasts >= 0
        )
        require(widgetHideFraction in 0f..1f)
    }
}

@Stable
class PleosColors(val dark: Boolean, private val overrides: Map<String, Color> = emptyMap()) {
    operator fun get(name: String): Color {
        overrides[name]?.let {
            return it
        }
        val canonical = sourceColorAliases[name] ?: name
        overrides[canonical]?.let {
            return it
        }
        webColors[canonical]?.let {
            return if (dark) it.second else it.first
        }
        // 웹 도해의 blue/red 의미를 모드별 semantic 색으로 연결한 구현 파생 토큰입니다.
        if (name == "controller/slider/gradient_start")
            return get("informative/positive").copy(alpha = .9f)
        if (name == "controller/slider/gradient_end") return get("regulation/red").copy(alpha = .9f)
        return supplementalColors[name]?.let { if (dark) it.second else it.first }
            ?: error("정의되지 않은 색상 토큰: $name")
    }

    /** 웹 도해에만 지정된 Light RGB이며 Dark는 semantic 보완값을 사용합니다. */
    fun scoped(alpha: Float, darkFallback: String): Color =
        if (dark) get(darkFallback) else Color(0xFF1B1C1E).copy(alpha = alpha)

    val canonicalNames: Set<String>
        get() = webColors.keys

    companion object {
        private val supplementalColors by lazy {
            generatedSourceTokens
                .filter {
                    it.file == SourceFile.Assets &&
                        it.collectionId == "2:15157" &&
                        it.name !in sourceColorAliases
                }
                .mapNotNull { token ->
                    val light = token.modes["Light"] as? TokenValue.Rgba
                    val dark = token.modes["Dark"] as? TokenValue.Rgba
                    if (light == null || dark == null) null
                    else token.name to (light.toColor() to dark.toColor())
                }
                .toMap()
        }
    }
}

@Stable
class PleosMetrics(
    val formFactor: PleosFormFactor,
    private val overrides: Map<String, Float> = emptyMap(),
) {
    private val layout by lazy {
        generatedSourceTokens
            .filter { it.file == SourceFile.Assets && it.collectionId == "67:4998" }
            .associateBy { it.name }
    }
    private val typo by lazy {
        generatedSourceTokens
            .filter { it.file == SourceFile.Assets && it.collectionId == "67:7555" }
            .associateBy { it.name }
    }

    /** fallback은 모드 바인딩이 없는 명세값입니다. 전체 배율 보정은 하지 않습니다. */
    fun value(path: String, fallback: Float): Float =
        overrides[path]
            ?: webOverrides[path]
            ?: ((layout[path]?.modes?.get(formFactor.metricMode)
                    ?: typo[path]?.modes?.get(formFactor.metricMode))
                    as? TokenValue.Number)
                ?.value
            ?: fallback

    fun dp(path: String, fallback: Float) = value(path, fallback).dp

    /** Display의 collection을 명시하며 같은 이름의 과거 collection을 자동 병합하지 않습니다. */
    fun displayValue(collectionId: String, path: String, fallback: Float): Float {
        val token =
            generatedSourceTokens.singleOrNull {
                it.file == SourceFile.Display && it.collectionId == collectionId && it.name == path
            }
        return (token?.modes?.get(formFactor.displayMode) as? TokenValue.Number)?.value ?: fallback
    }

    fun typographyValue(value: Int, line: Boolean = false): Float {
        val entry =
            typo.values.firstOrNull {
                it.name.startsWith(if (line) "line_height_sp/" else "size_sp/") &&
                    (it.modes["connect-s"] as? TokenValue.Number)?.value == value.toFloat()
            }
        val resolved =
            entry
                ?: typo.values.firstOrNull {
                    it.name.startsWith("size_sp/") &&
                        (it.modes["connect-s"] as? TokenValue.Number)?.value == value.toFloat()
                }
        return (resolved?.modes?.get(formFactor.metricMode) as? TokenValue.Number)?.value
            ?: value.toFloat()
    }

    companion object {
        val webOverrides =
            mapOf(
                "controller/stepper/width" to 400f,
                "controller/stepper/value_width" to 112f,
                "controller/stepper/height" to 100f,
                "popup/system/medium_width" to 760f,
                "popup/medium/width" to 760f,
                "popup/large/width" to 1200f,
                "spinner/wheel/date_min_width" to 600f,
                "spinner/wheel/time_min_width" to 500f,
                "spinner/gap_medium" to 24f,
                "spinner/number_width_small" to 120f,
                "spinner/date/width" to 600f,
                "spinner/time/width" to 500f,
                "spinner/column_gap" to 24f,
                "spinner/panel/large_height" to 384f,
                "spinner/list_height" to 88f,
                "spinner/number_width_large" to 200f,
                "spinner/number_width_medium" to 140f,
                "spinner/wheel/padding_horizontal" to 16f,
                "spinner/wheel/radius_top_left" to 32f,
                "spinner/focus_radius_top_left" to 24f,
                "spinner/web/fade_height" to 60f,
                "popup/toast/max_width" to 792f,
                "popup/toast/text_max_width" to 712f,
                "window/handle/enabled_length" to 140f,
                "window/handle/pressed_length" to 100f,
            )
    }
}

val AstaSans =
    FontFamily(
        listOf(300, 400, 500, 600, 700, 800).map { weight ->
            Font(
                R.font.asta_sans_variable,
                FontWeight(weight),
                variationSettings = FontVariation.Settings(FontVariation.weight(weight)),
            )
        }
    )
val LocalPleosColors = staticCompositionLocalOf { PleosColors(false) }
val LocalPleosMetrics = staticCompositionLocalOf { PleosMetrics(PleosFormFactor.Standard17) }
val LocalPleosBehavior = staticCompositionLocalOf { PleosBehaviorDefaults() }
val LocalPleosCapabilities = staticCompositionLocalOf { PleosCapabilities() }
val LocalPleosInputMode = compositionLocalOf { PleosInputMode.Touch }
val LocalPleosFontFamily = staticCompositionLocalOf { AstaSans }

/**
 * 호스트의 프로필과 실제 창 constraints는 독립적입니다. 기본 capability는 보수적으로 입력을 차단합니다. 일반 Android 호스트와 테스트에서는 명시적으로
 * PleosCapabilities.Unrestricted를 전달할 수 있습니다.
 */
@Composable
fun PleosTheme(
    darkTheme: Boolean =
        LocalConfiguration.current.uiMode and Configuration.UI_MODE_NIGHT_MASK ==
            Configuration.UI_MODE_NIGHT_YES,
    formFactor: PleosFormFactor = PleosFormFactor.Standard17,
    capabilities: PleosCapabilities = PleosCapabilities(),
    behavior: PleosBehaviorDefaults = PleosBehaviorDefaults(),
    inputMode: PleosInputMode = PleosInputMode.Touch,
    colors: PleosColors = remember(darkTheme) { PleosColors(darkTheme) },
    metrics: PleosMetrics = remember(formFactor) { PleosMetrics(formFactor) },
    fontFamily: FontFamily = AstaSans,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalPleosColors provides colors,
        LocalPleosMetrics provides metrics,
        LocalPleosBehavior provides behavior,
        LocalPleosCapabilities provides capabilities,
        LocalPleosInputMode provides inputMode,
        LocalPleosFontFamily provides fontFamily,
        content = content,
    )
}

object PleosTheme {
    val colors: PleosColors
        @Composable @ReadOnlyComposable get() = LocalPleosColors.current

    val metrics: PleosMetrics
        @Composable @ReadOnlyComposable get() = LocalPleosMetrics.current

    val behavior: PleosBehaviorDefaults
        @Composable @ReadOnlyComposable get() = LocalPleosBehavior.current
}

@Composable
fun pleosTextStyle(size: Int, lineHeight: Int, weight: FontWeight = FontWeight.Normal): TextStyle {
    val m = LocalPleosMetrics.current
    return TextStyle(
        fontFamily = LocalPleosFontFamily.current,
        fontWeight = weight,
        fontSize = m.typographyValue(size).sp,
        lineHeight = m.typographyValue(lineHeight, true).sp,
        letterSpacing = 0.sp,
        textDirection = androidx.compose.ui.text.style.TextDirection.Content,
        platformStyle = PlatformTextStyle(includeFontPadding = false),
    )
}
