# 공개 Kotlin API

패키지는 `com.jade.pleos.tokens`, `com.jade.pleos.compose`, `com.jade.pleos.aaos`입니다. 현재 소스의 공개 최상위 선언과 인자를 연결합니다. 멤버 함수·열거 값은 소스 링크에서 확인하십시오. 생성 원본 목록은 `PleosSourceTokens`, 아이콘 목록은 `PleosIcons`에서 제공합니다.

크기는 별도 표기가 없으면 Dp, 글자 크기·줄높이는 sp, 시간은 ms입니다. 실제 기본 인자·타입·유효 조합은 아래 선언과 KDoc을 따릅니다. 상태를 받는 컴포넌트의 콜백은 변경 요청이며 다음 외부 상태가 표시의 기준입니다. 규격 수치·범위 처리·호스트 경계는 README.md, SPEC_DECISIONS.md, AAOS_INTEGRATION.md에 연결합니다.

## pleos-tokens

[PleosTokens.kt:15](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L15)

```kotlin
object PleosSpecVersion
```

[PleosTokens.kt:19](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L19)

```kotlin
enum class SourceFile
```

[PleosTokens.kt:24](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L24)

```kotlin
sealed interface TokenValue
```

[PleosTokens.kt:35](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L35)

```kotlin
data class SourceToken(
    val file: SourceFile,
    val id: String,
    val key: String,
    val collectionId: String,
    val collectionKey: String,
    val name: String,
    val modes: Map<String, TokenValue>,
)
```

[PleosTokens.kt:46](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L46)

```kotlin
object PleosSourceTokens
```

[PleosTokens.kt:54](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L54)

```kotlin
enum class PleosFormFactor(
    val metricMode: String,
    val displayMode: String,
    val landscape: DpSize,
    val portrait: DpSize,
)
```

[PleosTokens.kt:74](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L74)

```kotlin
enum class PleosInputMode
```

[PleosTokens.kt:81](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L81)

```kotlin
data class PleosCapabilities(
    val textInput: Boolean = false,
    val complexInteraction: Boolean = false,
    val animations: Boolean = false,
    val video: Boolean = false,
    val systemNotifications: Boolean = false,
    val restrictionReason: String = "호스트의 사용 제한 정보를 기다리고 있습니다.",
)
```

[PleosTokens.kt:96](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L96)

```kotlin
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
)
```

[PleosTokens.kt:121](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L121)

```kotlin
class PleosColors(val dark: Boolean, private val overrides: Map<String, Color> = emptyMap())
```

[PleosTokens.kt:168](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L168)

```kotlin
class PleosMetrics(
    val formFactor: PleosFormFactor,
    private val overrides: Map<String, Float> = emptyMap(),
)
```

[PleosTokens.kt:252](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L252)

```kotlin
val AstaSans =
```

[PleosTokens.kt:262](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L262)

```kotlin
val LocalPleosColors = staticCompositionLocalOf { PleosColors(false)
```

[PleosTokens.kt:263](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L263)

```kotlin
val LocalPleosMetrics = staticCompositionLocalOf { PleosMetrics(PleosFormFactor.Standard17)
```

[PleosTokens.kt:264](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L264)

```kotlin
val LocalPleosBehavior = staticCompositionLocalOf { PleosBehaviorDefaults()
```

[PleosTokens.kt:265](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L265)

```kotlin
val LocalPleosCapabilities = staticCompositionLocalOf { PleosCapabilities()
```

[PleosTokens.kt:266](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L266)

```kotlin
val LocalPleosInputMode
```

[PleosTokens.kt:267](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L267)

```kotlin
val LocalPleosFontFamily
```

[PleosTokens.kt:274](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L274)

```kotlin
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
)
```

[PleosTokens.kt:298](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L298)

```kotlin
object PleosTheme
```

[PleosTokens.kt:310](pleos-tokens/src/main/java/com/jade/pleos/tokens/PleosTokens.kt#L310)

```kotlin
fun pleosTextStyle(size: Int, lineHeight: Int, weight: FontWeight = FontWeight.Normal)
```

## pleos-compose

[Actions.kt:20](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L20)

```kotlin
enum class PleosButtonSize
```

[Actions.kt:26](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L26)

```kotlin
enum class PleosButtonHierarchy
```

[Actions.kt:31](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L31)

```kotlin
enum class PleosTextButtonSize
```

[Actions.kt:36](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L36)

```kotlin
enum class PleosIconButtonStyle
```

[Actions.kt:42](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L42)

```kotlin
enum class PleosLoadingKind
```

[Actions.kt:47](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L47)

```kotlin
data class IconButtonMetrics(
    val largeSize: Dp = 100.dp,
    val largeIcon: Dp = 64.dp,
    val largeRadius: Dp = 24.dp,
    val smallSize: Dp? = null,
    val smallIcon: Dp? = null,
    val mediumSize: Dp? = null,
    val mediumIcon: Dp? = null,
)
```

[Actions.kt:57](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L57)

```kotlin
data class LoadingIndicatorSpec(
    val kind: PleosLoadingKind = PleosLoadingKind.Linear,
    val animate: Boolean = true,
)
```

[Actions.kt:68](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L68)

```kotlin
fun PleosLoadingIndicator(
    modifier: Modifier = Modifier,
    spec: LoadingIndicatorSpec = LoadingIndicatorSpec(),
)
```

[Actions.kt:128](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L128)

```kotlin
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
```

[Actions.kt:146](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L146)

```kotlin
fun pleosButtonMetrics(size: PleosButtonSize, toggle: Boolean = false)
```

[Actions.kt:218](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L218)

```kotlin
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
)
```

[Actions.kt:287](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L287)

```kotlin
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
)
```

[Actions.kt:332](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L332)

```kotlin
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
)
```

[Actions.kt:383](pleos-compose/src/main/java/com/jade/pleos/compose/Actions.kt#L383)

```kotlin
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
)
```

[Bars.kt:20](pleos-compose/src/main/java/com/jade/pleos/compose/Bars.kt#L20)

```kotlin
data class PleosScrollGeometry(
    val thumbLength: Float,
    val thumbOffset: Float,
    val maxOffset: Float,
)
```

[Bars.kt:32](pleos-compose/src/main/java/com/jade/pleos/compose/Bars.kt#L32)

```kotlin
fun pleosScrollGeometry(
    viewport: Float,
    content: Float,
    offset: Float,
    track: Float,
    minThumb: Float = 48f,
)
```

[Bars.kt:83](pleos-compose/src/main/java/com/jade/pleos/compose/Bars.kt#L83)

```kotlin
fun PleosWindowControlBar(
    onDragDelta: (Offset) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onDragStart: (() -> Unit)? = null,
    onDragEnd: (() -> Unit)? = null,
    onDragCancel: (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
)
```

[Bars.kt:235](pleos-compose/src/main/java/com/jade/pleos/compose/Bars.kt#L235)

```kotlin
fun PleosAppControlBar(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onDragDelta: ((Offset) -> Unit)? = null,
    onDragEnd: (() -> Unit)? = null,
    onDragCancel: (() -> Unit)? = null,
)
```

[Bars.kt:301](pleos-compose/src/main/java/com/jade/pleos/compose/Bars.kt#L301)

```kotlin
fun PleosScrollBar(
    viewportExtent: Float,
    contentExtent: Float,
    scrollOffset: Float,
    modifier: Modifier = Modifier,
    onScrollTo: ((Float) -> Unit)? = null,
    enabled: Boolean = true,
)
```

[Controllers.kt:24](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L24)

```kotlin
enum class PleosSliderSize
```

[Controllers.kt:29](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L29)

```kotlin
enum class PleosSliderSurface
```

[Controllers.kt:34](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L34)

```kotlin
enum class PleosCenteredSliderType
```

[Controllers.kt:40](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L40)

```kotlin
enum class PleosSliderVariant
```

[Controllers.kt:50](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L50)

```kotlin
fun normalizePleosValue(
    request: Float,
    range: ClosedFloatingPointRange<Float>,
    step: Float? = null,
)
```

[Controllers.kt:75](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L75)

```kotlin
fun stepPleosDecimal(
    value: BigDecimal,
    min: BigDecimal,
    max: BigDecimal,
    step: BigDecimal,
    direction: Int,
)
```

[Controllers.kt:86](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L86)

```kotlin
enum class PleosVolumeLevel
```

[Controllers.kt:95](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L95)

```kotlin
fun pleosVolumeLevel(fraction: Float)
```

[Controllers.kt:408](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L408)

```kotlin
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
)
```

[Controllers.kt:594](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L594)

```kotlin
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
)
```

[Controllers.kt:729](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L729)

```kotlin
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
)
```

[Controllers.kt:770](pleos-compose/src/main/java/com/jade/pleos/compose/Controllers.kt#L770)

```kotlin
fun PleosStepper(
    value: BigDecimal,
    onValueChange: (BigDecimal) -> Unit,
    min: BigDecimal,
    max: BigDecimal,
    step: BigDecimal,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueFormatter: (BigDecimal) -> String = { it.stripTrailingZeros().toPlainString() },
)
```

[Dropdown.kt:25](pleos-compose/src/main/java/com/jade/pleos/compose/Dropdown.kt#L25)

```kotlin
enum class PleosDropdownSize
```

[Dropdown.kt:30](pleos-compose/src/main/java/com/jade/pleos/compose/Dropdown.kt#L30)

```kotlin
sealed interface PleosDropdownItemKind
```

[Dropdown.kt:41](pleos-compose/src/main/java/com/jade/pleos/compose/Dropdown.kt#L41)

```kotlin
data class PleosDropdownEntry(
    val key: String,
    val text: String,
    val enabled: Boolean = true,
    val kind: PleosDropdownItemKind = PleosDropdownItemKind.Selection,
    val prefix: (@Composable () -> Unit)? = null,
    val appIcon: Boolean = false,
    val suffix: (@Composable () -> Unit)? = null,
    val isNew: Boolean = false,
)
```

[Dropdown.kt:106](pleos-compose/src/main/java/com/jade/pleos/compose/Dropdown.kt#L106)

```kotlin
fun PleosDropdownItem(
    entry: PleosDropdownEntry,
    onSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    size: PleosDropdownSize = PleosDropdownSize.Medium,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

[Dropdown.kt:305](pleos-compose/src/main/java/com/jade/pleos/compose/Dropdown.kt#L305)

```kotlin
fun PleosDropdownMenu(
    items: List<PleosDropdownEntry>,
    selectedId: String?,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    size: PleosDropdownSize = PleosDropdownSize.Medium,
    initialFocusRequester: FocusRequester? = null,
)
```

[Dropdown.kt:363](pleos-compose/src/main/java/com/jade/pleos/compose/Dropdown.kt#L363)

```kotlin
fun PleosDropdown(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    items: List<PleosDropdownEntry>,
    selectedId: String?,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    size: PleosDropdownSize = PleosDropdownSize.Medium,
    enabled: Boolean = true,
    placeholder: String = "선택",
    prefix: (@Composable () -> Unit)? = null,
    suffix: (@Composable () -> Unit)? = null,
    dismissAfterSelection: Boolean = true,
    onDismissRequest: ((PleosDismissReason) -> Unit)? = null,
    triggerContent: (@Composable (Modifier, Boolean, () -> Unit) -> Unit)? = null,
    preferredWidth: Dp? = 600.dp,
)
```

[Fields.kt:30](pleos-compose/src/main/java/com/jade/pleos/compose/Fields.kt#L30)

```kotlin
enum class PleosFieldSize
```

[Fields.kt:35](pleos-compose/src/main/java/com/jade/pleos/compose/Fields.kt#L35)

```kotlin
enum class PleosFieldType
```

[Fields.kt:43](pleos-compose/src/main/java/com/jade/pleos/compose/Fields.kt#L43)

```kotlin
enum class PleosNumberFieldSize
```

[Fields.kt:54](pleos-compose/src/main/java/com/jade/pleos/compose/Fields.kt#L54)

```kotlin
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
)
```

[Fields.kt:344](pleos-compose/src/main/java/com/jade/pleos/compose/Fields.kt#L344)

```kotlin
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
)
```

[Fields.kt:397](pleos-compose/src/main/java/com/jade/pleos/compose/Fields.kt#L397)

```kotlin
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
)
```

[Foundation.kt:32](pleos-compose/src/main/java/com/jade/pleos/compose/Foundation.kt#L32)

```kotlin
val LocalPleosContentColor
```

[Foundation.kt:40](pleos-compose/src/main/java/com/jade/pleos/compose/Foundation.kt#L40)

```kotlin
fun PleosText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = LocalPleosContentColor.current,
    style: TextStyle = pleosTextStyle(30, 38),
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    textAlign: TextAlign? = null,
)
```

[Foundation.kt:65](pleos-compose/src/main/java/com/jade/pleos/compose/Foundation.kt#L65)

```kotlin
fun PleosIcon(
    resource: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color? =
        LocalPleosContentColor.current.takeIf { it != Color.Unspecified }
            ?: PleosTheme.colors["icon/dark/primary"],
)
```

[Foundation.kt:81](pleos-compose/src/main/java/com/jade/pleos/compose/Foundation.kt#L81)

```kotlin
data class PleosShadowLayer(val offsetY: Dp, val blur: Dp, val alpha: Float)
```

[Foundation.kt:89](pleos-compose/src/main/java/com/jade/pleos/compose/Foundation.kt#L89)

```kotlin
fun Modifier.pleosShadow(radius: Dp, layers: List<PleosShadowLayer>)
```

[Foundation.kt:216](pleos-compose/src/main/java/com/jade/pleos/compose/Foundation.kt#L216)

```kotlin
fun PleosSurface(
    modifier: Modifier = Modifier,
    color: Color = PleosTheme.colors["surface/basic"],
    radius: Dp = 24.dp,
    borderColor: Color = Color.Transparent,
    borderWidth: Dp = 0.dp,
    shadowLevel: Int = 0,
    content: @Composable BoxScope.() -> Unit,
)
```

[Keypads.kt:15](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L15)

```kotlin
sealed interface PleosKeyAction
```

[Keypads.kt:36](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L36)

```kotlin
fun interface PleosTextInputAdapter
```

[Keypads.kt:40](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L40)

```kotlin
enum class PleosKeyboardPalette
```

[Keypads.kt:45](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L45)

```kotlin
enum class PleosKeyboardLanguage
```

[Keypads.kt:50](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L50)

```kotlin
enum class PleosKeyboardMode
```

[Keypads.kt:55](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L55)

```kotlin
enum class PleosVoiceState
```

[Keypads.kt:62](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L62)

```kotlin
enum class PleosKeyboardKeyKind
```

[Keypads.kt:73](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L73)

```kotlin
sealed interface PleosNumericKeyKind
```

[Keypads.kt:88](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L88)

```kotlin
data class NumericKeypadLayoutMetrics(
    val columnGap: Dp = 24.dp,
    val rowGap: Dp = 40.dp,
    val contentPadding: Dp = 48.dp,
    val fieldToKeysGap: Dp = 48.dp,
)
```

[Keypads.kt:95](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L95)

```kotlin
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
```

[Keypads.kt:111](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L111)

```kotlin
fun reducePleosText(value: String, action: PleosKeyAction)
```

[Keypads.kt:133](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L133)

```kotlin
fun PleosNumericKey(
    kind: PleosNumericKeyKind,
    onKey: (PleosKeyAction) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

[Keypads.kt:204](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L204)

```kotlin
fun PleosNumericKeypad(
    onKey: (PleosKeyAction) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    canDelete: Boolean = true,
    function: PleosNumericKeyKind.Function = PleosNumericKeyKind.Function(),
    metrics: NumericKeypadLayoutMetrics = NumericKeypadLayoutMetrics(),
    field: (@Composable () -> Unit)? = null,
)
```

[Keypads.kt:264](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L264)

```kotlin
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
)
```

[Keypads.kt:391](pleos-compose/src/main/java/com/jade/pleos/compose/Keypads.kt#L391)

```kotlin
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
)
```

[Navigation.kt:20](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L20)

```kotlin
enum class PleosIndicatorSize
```

[Navigation.kt:31](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L31)

```kotlin
fun PleosPageIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    size: PleosIndicatorSize = PleosIndicatorSize.Wide,
    onPageSelected: ((Int) -> Unit)? = null,
    dotGap: Dp? = null,
)
```

[Navigation.kt:81](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L81)

```kotlin
enum class PleosTabsStyle
```

[Navigation.kt:86](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L86)

```kotlin
enum class PleosTabsSize
```

[Navigation.kt:91](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L91)

```kotlin
enum class PleosLineTabMargin
```

[Navigation.kt:96](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L96)

```kotlin
data class PleosTabItem(
    val key: String,
    val label: String,
    val enabled: Boolean = true,
    val icon: (@Composable () -> Unit)? = null,
)
```

[Navigation.kt:109](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L109)

```kotlin
fun PleosTabs(
    items: List<PleosTabItem>,
    selectedKey: String?,
    onSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    style: PleosTabsStyle = PleosTabsStyle.Box,
    size: PleosTabsSize = PleosTabsSize.Large,
    fitted: Boolean = true,
    lineMargin: PleosLineTabMargin = PleosLineTabMargin.Medium,
    bottomLine: Boolean = true,
)
```

[Navigation.kt:312](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L312)

```kotlin
enum class PleosNavigationType
```

[Navigation.kt:318](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L318)

```kotlin
enum class PleosHeaderPreset
```

[Navigation.kt:333](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L333)

```kotlin
fun PleosPageNavigation(
    type: PleosNavigationType,
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    appIcon: (@Composable () -> Unit)? = null,
    primaryMenu: (@Composable () -> Unit)? = null,
    secondaryMenu: (@Composable () -> Unit)? = null,
    actions: (@Composable RowScope.() -> Unit)? = null,
    onBack: (() -> Unit)? = null,
    tabs: (@Composable () -> Unit)? = null,
    divider: Boolean = false,
    searchField: (@Composable () -> Unit)? = null,
)
```

[Navigation.kt:455](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L455)

```kotlin
fun PleosNavigationHeader(
    preset: PleosHeaderPreset,
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    appIcon: (@Composable () -> Unit)? = null,
    primaryMenu: (@Composable () -> Unit)? = null,
    secondaryMenu: (@Composable () -> Unit)? = null,
    actions: (@Composable RowScope.() -> Unit)? = null,
    tabs: (@Composable () -> Unit)? = null,
)
```

[Navigation.kt:501](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L501)

```kotlin
fun PleosNavigationMenu(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    enabled: Boolean = true,
    showArrow: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

[Navigation.kt:565](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L565)

```kotlin
fun PleosSearchNavigation(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onSearch: () -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    onBack: (() -> Unit)? = null,
    placeholder: String = "검색",
    enabled: Boolean = true,
    fieldModifier: Modifier = Modifier,
)
```

[Navigation.kt:607](pleos-compose/src/main/java/com/jade/pleos/compose/Navigation.kt#L607)

```kotlin
fun PleosNavigationDropdown(
    expanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    items: List<PleosDropdownEntry>,
    selectedId: String?,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "선택",
    enabled: Boolean = true,
    onDismissRequest: ((PleosDismissReason) -> Unit)? = null,
)
```

[NotificationsWidgets.kt:28](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L28)

```kotlin
sealed interface PleosNotificationImagery
```

[NotificationsWidgets.kt:44](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L44)

```kotlin
enum class PleosNotificationKind
```

[NotificationsWidgets.kt:103](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L103)

```kotlin
fun PleosSystemNotificationCard(
    title: String,
    description: String?,
    actions: List<PleosPopupAction>,
    modifier: Modifier = Modifier,
    imagery: PleosNotificationImagery = PleosNotificationImagery.None,
    actionLayout: PleosActionLayout = PleosActionLayout.Horizontal,
    kind: PleosNotificationKind = PleosNotificationKind.ImageText,
    onDismiss: (() -> Unit)? = null,
)
```

[NotificationsWidgets.kt:265](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L265)

```kotlin
class PleosNotificationHostState
```

[NotificationsWidgets.kt:280](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L280)

```kotlin
data class PleosInAppNotification(
    val id: String,
    val title: String,
    val description: String?,
    val actions: List<PleosPopupAction>,
    val imagery: PleosNotificationImagery = PleosNotificationImagery.None,
    val layout: PleosActionLayout = PleosActionLayout.Horizontal,
    val kind: PleosNotificationKind = PleosNotificationKind.ImageText,
)
```

[NotificationsWidgets.kt:296](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L296)

```kotlin
fun PleosSystemNotificationHost(state: PleosNotificationHostState, modifier: Modifier = Modifier)
```

[NotificationsWidgets.kt:320](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L320)

```kotlin
enum class PleosWidgetVisibility
```

[NotificationsWidgets.kt:325](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L325)

```kotlin
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
```

[NotificationsWidgets.kt:339](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L339)

```kotlin
data class WidgetTitleTypography(
    val fontSize: TextUnit = 24.sp,
    val lineHeight: TextUnit = 32.sp,
    val weight: FontWeight = FontWeight.Bold,
)
```

[NotificationsWidgets.kt:345](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L345)

```kotlin
data class PleosWidgetItem(
    val key: String,
    val title: String,
    val action: (@Composable () -> Unit)? = null,
    val information: @Composable () -> Unit,
)
```

[NotificationsWidgets.kt:358](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L358)

```kotlin
fun PleosWidgetCard(
    title: String,
    modifier: Modifier = Modifier,
    action: (@Composable () -> Unit)? = null,
    information: @Composable () -> Unit,
    pagination: (@Composable () -> Unit)? = null,
    handle: (@Composable () -> Unit)? = null,
    metrics: PleosWidgetMetrics = PleosWidgetMetrics(),
    titleTypography: WidgetTitleTypography = WidgetTitleTypography(),
)
```

[NotificationsWidgets.kt:429](pleos-compose/src/main/java/com/jade/pleos/compose/NotificationsWidgets.kt#L429)

```kotlin
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
)
```

[Overlays.kt:28](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L28)

```kotlin
sealed interface PleosDismissReason
```

[Overlays.kt:42](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L42)

```kotlin
enum class PleosPopupSize
```

[Overlays.kt:47](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L47)

```kotlin
enum class PleosPopupMetricsPreset
```

[Overlays.kt:52](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L52)

```kotlin
enum class PleosActionLayout
```

[Overlays.kt:58](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L58)

```kotlin
data class PleosDismissPolicy(
    val back: Boolean = true,
    val outside: Boolean = true,
    val close: Boolean = false,
)
```

[Overlays.kt:64](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L64)

```kotlin
data class PleosPopupAction(
    val id: String,
    val label: String,
    val onClick: () -> Unit,
    val enabled: Boolean = true,
    val loading: Boolean = false,
)
```

[Overlays.kt:79](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L79)

```kotlin
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
)
```

[Overlays.kt:354](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L354)

```kotlin
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
)
```

[Overlays.kt:429](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L429)

```kotlin
sealed interface PleosToastDuration
```

[Overlays.kt:441](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L441)

```kotlin
data class PleosToastMessage(
    val id: String,
    val message: String,
    val duration: PleosToastDuration = PleosToastDuration.Short,
    val icon: (@Composable () -> Unit)? = null,
    val onDismiss: ((PleosDismissReason) -> Unit)? = null,
    val generation: Long = 0,
)
```

[Overlays.kt:452](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L452)

```kotlin
class PleosToastHostState(val maxQueued: Int = 3)
```

[Overlays.kt:521](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L521)

```kotlin
fun rememberPleosToastHostState(maxQueued: Int = PleosTheme.behavior.maxQueuedToasts)
```

[Overlays.kt:530](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L530)

```kotlin
fun PleosToastSurface(
    message: String,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    onClose: (() -> Unit)? = null,
)
```

[Overlays.kt:631](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L631)

```kotlin
fun PleosToastHost(
    state: PleosToastHostState,
    modifier: Modifier = Modifier,
    margin: Boolean = true,
)
```

[Overlays.kt:663](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L663)

```kotlin
fun PleosToast(state: PleosToastHostState, modifier: Modifier = Modifier)
```

[Overlays.kt:672](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L672)

```kotlin
fun PleosToastPopup(
    state: PleosToastHostState,
    modifier: Modifier = Modifier,
    margin: Boolean = true,
)
```

[Overlays.kt:678](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L678)

```kotlin
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
```

[Overlays.kt:692](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L692)

```kotlin
class PleosOverlayHostState(
    val toasts: PleosToastHostState = PleosToastHostState(),
    val notifications: PleosNotificationHostState = PleosNotificationHostState(),
)
```

[Overlays.kt:721](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L721)

```kotlin
fun PleosOverlayHost(
    state: PleosOverlayHostState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
)
```

[Overlays.kt:755](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L755)

```kotlin
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
)
```

[Overlays.kt:780](pleos-compose/src/main/java/com/jade/pleos/compose/Overlays.kt#L780)

```kotlin
fun PleosToast(
    message: String,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    onClose: (() -> Unit)? = null,
)
```

[PleosIcons.kt:3](pleos-compose/src/main/java/com/jade/pleos/compose/PleosIcons.kt#L3)

```kotlin
object PleosIcons
```

[Selections.kt:18](pleos-compose/src/main/java/com/jade/pleos/compose/Selections.kt#L18)

```kotlin
enum class PleosSwitchSize
```

[Selections.kt:29](pleos-compose/src/main/java/com/jade/pleos/compose/Selections.kt#L29)

```kotlin
fun PleosCheckbox(
    state: ToggleableState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

[Selections.kt:87](pleos-compose/src/main/java/com/jade/pleos/compose/Selections.kt#L87)

```kotlin
fun PleosCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
)
```

[Selections.kt:106](pleos-compose/src/main/java/com/jade/pleos/compose/Selections.kt#L106)

```kotlin
fun PleosRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    invalid: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

[Selections.kt:152](pleos-compose/src/main/java/com/jade/pleos/compose/Selections.kt#L152)

```kotlin
data class PleosRadioOption<T>(val key: T, val label: String, val enabled: Boolean = true)
```

[Selections.kt:160](pleos-compose/src/main/java/com/jade/pleos/compose/Selections.kt#L160)

```kotlin
fun <T> PleosRadioGroup(
    options: List<PleosRadioOption<T>>,
    selectedKey: T?,
    onSelected: (T) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    invalid: String? = null,
)
```

[Selections.kt:212](pleos-compose/src/main/java/com/jade/pleos/compose/Selections.kt#L212)

```kotlin
fun PleosSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: PleosSwitchSize = PleosSwitchSize.Medium,
    invalid: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
)
```

[Spinners.kt:36](pleos-compose/src/main/java/com/jade/pleos/compose/Spinners.kt#L36)

```kotlin
enum class PleosSpinnerSize
```

[Spinners.kt:41](pleos-compose/src/main/java/com/jade/pleos/compose/Spinners.kt#L41)

```kotlin
enum class PleosDatePart
```

[Spinners.kt:52](pleos-compose/src/main/java/com/jade/pleos/compose/Spinners.kt#L52)

```kotlin
fun adjustPleosDate(
    value: LocalDate,
    year: Int = value.year,
    month: Int = value.monthValue,
    day: Int = value.dayOfMonth,
    min: LocalDate = LocalDate.of(1900, 1, 1),
    max: LocalDate = LocalDate.of(2100, 12, 31),
)
```

[Spinners.kt:70](pleos-compose/src/main/java/com/jade/pleos/compose/Spinners.kt#L70)

```kotlin
fun pleosHour24(hour12: Int, pm: Boolean)
```

[Spinners.kt:96](pleos-compose/src/main/java/com/jade/pleos/compose/Spinners.kt#L96)

```kotlin
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
)
```

[Spinners.kt:372](pleos-compose/src/main/java/com/jade/pleos/compose/Spinners.kt#L372)

```kotlin
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
)
```

[Spinners.kt:501](pleos-compose/src/main/java/com/jade/pleos/compose/Spinners.kt#L501)

```kotlin
fun localizedDateOrder(locale: Locale)
```

[Spinners.kt:527](pleos-compose/src/main/java/com/jade/pleos/compose/Spinners.kt#L527)

```kotlin
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
)
```

[Spinners.kt:610](pleos-compose/src/main/java/com/jade/pleos/compose/Spinners.kt#L610)

```kotlin
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
)
```

## pleos-aaos

[PleosAaosAdapters.kt:12](pleos-aaos/src/main/java/com/jade/pleos/aaos/PleosAaosAdapters.kt#L12)

```kotlin
sealed interface PleosUxConnectionState
```

[PleosAaosAdapters.kt:24](pleos-aaos/src/main/java/com/jade/pleos/aaos/PleosAaosAdapters.kt#L24)

```kotlin
class PleosUxRestrictionsAdapter(
    private val managerProvider: () -> CarUxRestrictionsManager,
    private val mapRestrictions: (CarUxRestrictions) -> PleosCapabilities,
)
```

[PleosAaosAdapters.kt:96](pleos-aaos/src/main/java/com/jade/pleos/aaos/PleosAaosAdapters.kt#L96)

```kotlin
sealed interface PleosRotaryEvent
```

[PleosAaosAdapters.kt:112](pleos-aaos/src/main/java/com/jade/pleos/aaos/PleosAaosAdapters.kt#L112)

```kotlin
class PleosRotaryEditSession(
    private val onAdjust: (Float) -> Unit,
    private val onFinished: (Boolean) -> Unit,
)
```

[PleosAaosAdapters.kt:160](pleos-aaos/src/main/java/com/jade/pleos/aaos/PleosAaosAdapters.kt#L160)

```kotlin
interface PleosWindowManagementAdapter
```

[PleosAaosAdapters.kt:171](pleos-aaos/src/main/java/com/jade/pleos/aaos/PleosAaosAdapters.kt#L171)

```kotlin
sealed interface PleosNotificationResult
```

[PleosAaosAdapters.kt:177](pleos-aaos/src/main/java/com/jade/pleos/aaos/PleosAaosAdapters.kt#L177)

```kotlin
fun interface PleosSystemNotificationAdapter
```

[PleosAaosAdapters.kt:182](pleos-aaos/src/main/java/com/jade/pleos/aaos/PleosAaosAdapters.kt#L182)

```kotlin
class AndroidPleosNotificationAdapter(
    private val manager: NotificationManager,
    private val capabilities: () -> PleosCapabilities,
)
```
