@file:OptIn(androidx.compose.ui.test.ExperimentalTestApi::class)

package com.jade.pleos.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.input.InputMode
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.*
import androidx.compose.ui.semantics.*
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.*
import androidx.lifecycle.*
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jade.pleos.tokens.*
import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PleosSpecRegressionTest {
    @get:Rule val rule = createAndroidComposeRule<PleosTestActivity>()

    private fun content(
        profile: PleosFormFactor = PleosFormFactor.Standard17,
        scale: Float = 1f,
        capabilities: PleosCapabilities = PleosCapabilities.Unrestricted,
        behavior: PleosBehaviorDefaults = PleosBehaviorDefaults(reducedMotion = true),
        block: @Composable () -> Unit,
    ) {
        rule.setContent {
            val density = LocalDensity.current
            val input = LocalInputModeManager.current
            LaunchedEffect(Unit) { input.requestInputMode(InputMode.Keyboard) }
            CompositionLocalProvider(LocalDensity provides Density(density.density, scale)) {
                PleosTheme(formFactor = profile, capabilities = capabilities, behavior = behavior) {
                    Box(Modifier.fillMaxSize().background(Color.White)) { block() }
                }
            }
        }
    }

    private fun pixelNear(actual: Int, expected: Int) {
        for (shift in listOf(0, 8, 16)) assertTrue(
            "실제 색 $actual / 기대 색 $expected",
            kotlin.math.abs(((actual shr shift) and 255) - ((expected shr shift) and 255)) <= 2,
        )
    }

    private fun countColor(tag: String, color: Color): Int {
        val b = rule.onNodeWithTag(tag).captureToImage().asAndroidBitmap()
        val expected = color.toArgb()
        return (0 until b.height).sumOf { y ->
            (0 until b.width).count { x -> b.getPixel(x, y) == expected }
        }
    }

    @Test
    fun shortPopupKeepsEveryVerticalActionReachable() {
        content {
            PleosPopupSurface(
                "제목",
                PleosPopupAction("ok", "확인", {}),
                Modifier.width(760.dp).height(220.dp).testTag("short-actions"),
                cancelAction = PleosPopupAction("cancel", "취소", {}),
                buttonAlign = PleosActionLayout.Vertical,
                body = { PleosText("본문") },
            )
        }
        rule.onNodeWithText("확인").assertHeightIsEqualTo(100.dp).assertIsDisplayed()
        rule
            .onNodeWithText("취소")
            .performScrollTo()
            .assertHeightIsEqualTo(100.dp)
            .assertIsDisplayed()
        val root = rule.onNodeWithTag("short-actions").getUnclippedBoundsInRoot()
        val cancel = rule.onNodeWithText("취소").getUnclippedBoundsInRoot()
        assertTrue(cancel.top >= root.top + 48.dp)
        assertTrue(cancel.bottom <= root.bottom - 48.dp)
    }

    @Test
    fun shortPopupDropsEmptySpacingBeforeItsActions() {
        content {
            PleosPopupSurface(
                "제목",
                PleosPopupAction("ok", "확인", {}),
                Modifier.width(760.dp).height(220.dp).testTag("short-popup"),
                body = { PleosText("본문") },
            )
        }
        rule.onNodeWithText("확인").assertHeightIsEqualTo(100.dp).assertIsDisplayed()
        val root = rule.onNodeWithTag("short-popup").getUnclippedBoundsInRoot()
        assertTrue(
            rule.onNodeWithText("확인").getUnclippedBoundsInRoot().bottom <= root.bottom - 48.dp
        )
    }

    @Test
    fun hiddenWidgetPreservesItsPageAndAllowsFocusToLeave() {
        var changes = 0
        content {
            Row {
                PleosBasicButton("왼쪽 영역", {})
                PleosWidgetHost(
                    (0..2).map { PleosWidgetItem("$it", "제목", information = { PleosText("정보") }) },
                    "1",
                    { changes++ },
                    PleosWidgetVisibility.Hidden,
                    {},
                    Modifier.testTag("hidden"),
                )
            }
        }
        val actions =
            rule.onNodeWithTag("hidden").fetchSemanticsNode().config[SemanticsActions.CustomActions]
        assertEquals(listOf("펼치기"), actions.map { it.label })
        rule.onNodeWithTag("hidden").performSemanticsAction(SemanticsActions.RequestFocus) { it() }
        rule.onNodeWithTag("hidden").performKeyInput { pressKey(Key.DirectionLeft) }
        rule.onNodeWithText("왼쪽 영역").assertIsFocused()
        rule.runOnIdle { assertEquals(0, changes) }
    }

    @Test
    fun verticalParentScrollCanStartOverWidgetContent() {
        lateinit var scrollState: androidx.compose.foundation.ScrollState
        content {
            val scroll = rememberScrollState()
            SideEffect { scrollState = scroll }
            Column(Modifier.height(400.dp).verticalScroll(scroll)) {
                PleosWidgetHost(
                    listOf(PleosWidgetItem("a", "제목", information = { PleosText("정보") })),
                    "a",
                    {},
                    PleosWidgetVisibility.Show,
                    {},
                    Modifier.testTag("scroll-widget"),
                )
                repeat(40) { PleosText("목록 $it") }
            }
        }
        rule.onNodeWithTag("scroll-widget").performTouchInput {
            swipe(Offset(width * .8f, 140f), Offset(width * .8f, 20f), 400)
        }
        rule.runOnIdle { assertTrue("위젯 본문 위에서 부모 스크롤이 시작되어야 합니다.", scrollState.value > 0) }
    }

    @Test
    fun windowBarKeyboardUsesHostDragCallbacksOnce() {
        var started = 0
        var finished = 0
        val changes = mutableListOf<Offset>()
        content {
            PleosWindowControlBar(
                { changes.add(it) },
                Modifier.testTag("window"),
                onDragStart = { started++ },
                onDragEnd = { finished++ },
            )
        }
        rule.onNodeWithTag("window").performSemanticsAction(SemanticsActions.RequestFocus) { it() }
        rule.onNodeWithTag("window").performKeyInput {
            pressKey(Key.Enter)
            pressKey(Key.DirectionRight)
            pressKey(Key.Escape)
        }
        rule.runOnIdle {
            assertEquals(1, started)
            assertEquals(1, finished)
            assertEquals(listOf(Offset(48f, 0f)), changes)
        }
    }

    @Test
    fun controllableScrollbarSupportsKeyboardEditingAndBoundedActions() {
        var offset by mutableFloatStateOf(0f)
        var events = 0
        content {
            PleosScrollBar(
                100f,
                1000f,
                offset,
                Modifier.height(407.dp).testTag("scroll"),
                onScrollTo = {
                    offset = it
                    events++
                },
            )
        }
        val control =
            rule.onNode(
                hasAnyAncestor(hasTestTag("scroll")) and
                    SemanticsMatcher.keyIsDefined(SemanticsActions.RequestFocus)
            )
        control.performSemanticsAction(SemanticsActions.RequestFocus) { it() }
        control.performKeyInput {
            pressKey(Key.Enter)
            pressKey(Key.DirectionDown)
            pressKey(Key.Escape)
        }
        rule.runOnIdle {
            assertEquals(10f, offset)
            assertEquals(1, events)
            offset = 900f
        }
        val down =
            control
                .fetchSemanticsNode()
                .config[SemanticsActions.CustomActions]
                .first { it.label == "아래로 스크롤" }
                .action
        rule.runOnIdle { assertFalse(down()) }
        rule.runOnIdle { assertEquals(1, events) }
    }

    @Test
    fun keypadFunctionSubmitIsIndependentOfEmptyDeleteState() {
        var submitted = 0
        content {
            PleosNumericKeypad(
                { if (it == PleosKeyAction.Submit) submitted++ },
                Modifier.width(744.dp),
                canDelete = false,
                function = PleosNumericKeyKind.Function("완료", PleosKeyAction.Submit),
            )
        }
        rule.onNodeWithText("완료").assertIsEnabled().performClick()
        rule.onNodeWithContentDescription("한 글자 지우기").assertIsNotEnabled()
        rule.runOnIdle { assertEquals(1, submitted) }
    }

    @Test
    fun voiceKeyboardHonorsHostInputRestriction() {
        var calls = 0
        content(capabilities = PleosCapabilities()) {
            PleosKeyboard({ calls++ }, mode = PleosKeyboardMode.Voice)
        }
        rule.onNodeWithText("음성 입력 요청").assertIsNotEnabled().performClick()
        rule.onNodeWithText("문자 입력").assertIsNotEnabled()
        rule.runOnIdle { assertEquals(0, calls) }
    }

    @Test
    fun staticKeyboardAndShiftUseTheirIconTokens() {
        var green = Color.Unspecified
        content {
            green = PleosTheme.colors["informative/active"]
            Column {
                PleosKeyboardKey(
                    PleosKeyboardKeyKind.Delete,
                    {},
                    Modifier.testTag("delete"),
                    palette = PleosKeyboardPalette.Static,
                )
                PleosKeyboardKey(
                    PleosKeyboardKeyKind.Shift,
                    {},
                    Modifier.testTag("shift"),
                    shifted = true,
                )
            }
        }
        assertTrue(countColor("delete", Color.White) > 10)
        assertTrue(countColor("shift", green) > 10)
    }

    @Test
    fun selectionPressedOverlayPreservesMarkAndRadioCenter() {
        content {
            val source = remember { MutableInteractionSource() }
            LaunchedEffect(Unit) { source.emit(PressInteraction.Press(Offset.Zero)) }
            Column {
                PleosCheckbox(
                    ToggleableState.Indeterminate,
                    {},
                    Modifier.testTag("check"),
                    interactionSource = source,
                )
                PleosRadioButton(true, {}, Modifier.testTag("radio"), interactionSource = source)
            }
        }
        rule.waitForIdle()
        for (tag in listOf("check", "radio")) {
            val image = rule.onNodeWithTag(tag).captureToImage().asAndroidBitmap()
            pixelNear(image.getPixel(image.width / 2, image.height / 2), Color.White.toArgb())
        }
    }

    @Test
    fun dropdownFooterUsesItsOwnExactGeometryAndModes() {
        var legacy by mutableStateOf(false)
        rule.setContent {
            PleosTheme(
                formFactor = if (legacy) PleosFormFactor.Legacy12_9 else PleosFormFactor.Standard17,
                capabilities = PleosCapabilities.Unrestricted,
                behavior = PleosBehaviorDefaults(reducedMotion = true),
            ) {
                Column {
                    PleosDropdownItem(
                        PleosDropdownEntry("a", "추가", kind = PleosDropdownItemKind.Footer {}),
                        {},
                        Modifier.width(600.dp).testTag("medium"),
                    )
                    PleosDropdownItem(
                        PleosDropdownEntry("b", "추가", kind = PleosDropdownItemKind.Footer {}),
                        {},
                        Modifier.width(600.dp).testTag("small"),
                        size = PleosDropdownSize.Small,
                    )
                }
            }
        }
        rule.onNodeWithTag("medium").assertHeightIsEqualTo(97.dp)
        rule.onNodeWithTag("small").assertHeightIsEqualTo(81.dp)
        rule.runOnIdle { legacy = true }
        rule.onNodeWithTag("medium").assertHeightIsEqualTo(85.dp)
        rule.onNodeWithTag("small").assertHeightIsEqualTo(71.dp)
    }

    @Test
    fun dropdownMenuUsesActualAnchorWidth() {
        var wide by mutableStateOf(false)
        content {
            PleosDropdown(
                true,
                {},
                listOf(PleosDropdownEntry("a", "항목")),
                null,
                {},
                preferredWidth = if (wide) 800.dp else 320.dp,
            )
        }
        rule.waitUntilAtLeastOneExists(hasText("항목"), 5000)
        rule.onNode(hasText("항목") and hasClickAction()).assertWidthIsEqualTo(288.dp)
        rule.runOnIdle { wide = true }
        rule.onNode(hasText("항목") and hasClickAction()).assertWidthIsEqualTo(768.dp)
    }

    @Test
    fun searchNavigationOwnsNoSearchOrNavigationState() {
        var value by mutableStateOf(TextFieldValue("검색어"))
        var search = 0
        var back = 0
        var close = 0
        content {
            PleosSearchNavigation(
                value,
                { value = it },
                { search++ },
                { close++ },
                Modifier.width(988.dp),
                onBack = { back++ },
            )
        }
        rule.onNode(hasSetTextAction()).performImeAction()
        rule.onNodeWithContentDescription("검색 닫기").performClick()
        rule.onNodeWithContentDescription("뒤로").assertWidthIsEqualTo(56.dp).performClick()
        rule.runOnIdle {
            assertEquals(1, search)
            assertEquals(1, back)
            assertEquals(1, close)
            assertEquals("검색어", value.text)
        }
    }

    @Test
    fun headerPresetKeepsBackgroundDividerAndHeight() {
        content {
            Box(Modifier.background(Color.Red)) {
                PleosNavigationHeader(
                    PleosHeaderPreset.Radio,
                    "서비스",
                    Modifier.width(988.dp).testTag("header"),
                )
            }
        }
        rule.onNodeWithTag("header").assertHeightIsEqualTo(144.dp)
        val b = rule.onNodeWithTag("header").captureToImage().asAndroidBitmap()
        pixelNear(b.getPixel(1, 1), Color.White.toArgb())
        pixelNear(
            b.getPixel(b.width / 2, b.height - 1),
            Color(0xFF131417).copy(alpha = .2f).compositeOver(Color.White).toArgb(),
        )
    }

    @Test
    fun externalTabSelectionScrollsIntoView() {
        var selected by mutableStateOf("0")
        content {
            PleosTabs(
                (0..5).map { PleosTabItem("$it", "긴 항목 이름 $it") },
                selected,
                { selected = it },
                Modifier.width(320.dp),
                fitted = false,
            )
        }
        rule.runOnIdle { selected = "5" }
        rule.onNodeWithText("긴 항목 이름 5").assertIsDisplayed()
    }

    @Test
    fun popupSeparatesHeaderBodyGapAndBodyScrollFromActions() {
        content {
            PleosPopupSurface(
                "고정 제목",
                PleosPopupAction("ok", "확인", {}),
                Modifier.width(760.dp).height(500.dp),
                body = {
                    Column {
                        repeat(50) {
                            PleosText(
                                "본문 $it",
                                Modifier.then(if (it == 0) Modifier.testTag("first") else Modifier),
                            )
                        }
                    }
                },
            )
        }
        val titleTop = rule.onNodeWithText("고정 제목").getUnclippedBoundsInRoot().top
        val titleBottom = rule.onNodeWithText("고정 제목").getUnclippedBoundsInRoot().bottom
        assertEquals(
            56f,
            (rule.onNodeWithTag("first").getUnclippedBoundsInRoot().top - titleBottom).value,
            1f,
        )
        rule.onNodeWithText("본문 49").performScrollTo().assertIsDisplayed()
        assertEquals(titleTop, rule.onNodeWithText("고정 제목").getUnclippedBoundsInRoot().top)
        rule.onNodeWithText("확인").assertIsDisplayed()
    }

    @Test
    fun popupRadiusAndPaddingAreIndependentAndActionsCanBeHidden() {
        content(profile = PleosFormFactor.Legacy12_9) {
            Box(Modifier.background(Color.Black)) {
                PleosPopupSurface(
                    "",
                    null,
                    Modifier.width(760.dp).testTag("popup"),
                    description = "읽기 전용 안내",
                )
            }
        }
        rule.onAllNodes(hasClickAction()).assertCountEquals(0)
        val b = rule.onNodeWithTag("popup").captureToImage().asAndroidBitmap()
        pixelNear(b.getPixel(5, 18), Color.Black.toArgb())
    }

    @Test
    fun readOnlyAndPasswordSemanticsRemainProtectedWithVisiblePassword() {
        var expected = Color.Unspecified
        content {
            expected =
                PleosTheme.colors["divider/secondary"].compositeOver(
                    PleosTheme.colors["surface/high"]
                )
            Column {
                PleosTextField(
                    TextFieldValue("읽기"),
                    {},
                    Modifier.width(400.dp).testTag("readonly"),
                    readOnly = true,
                )
                PleosTextField(
                    TextFieldValue("비밀문자"),
                    {},
                    Modifier.width(400.dp).testTag("password"),
                    type = PleosFieldType.Password,
                    passwordVisible = true,
                )
            }
        }
        rule
            .onNode(
                hasAnyAncestor(hasTestTag("readonly")) and
                    SemanticsMatcher.keyIsDefined(SemanticsActions.RequestFocus)
            )
            .performSemanticsAction(SemanticsActions.RequestFocus) { it() }
        val b = rule.onNodeWithTag("readonly").captureToImage().asAndroidBitmap()
        pixelNear(b.getPixel(1, b.height / 2), expected.toArgb())
        val protected =
            rule
                .onNode(
                    hasSetTextAction() and
                        SemanticsMatcher.expectValue(SemanticsProperties.Password, Unit)
                )
                .fetchSemanticsNode()
                .config
        assertEquals("••••", protected[SemanticsProperties.InputText].text)
        assertEquals("••••", protected[SemanticsProperties.EditableText].text)
    }

    @Test
    fun smallFieldActionAndLargeNumberTextHaveEnoughSpace() {
        var value by mutableStateOf(TextFieldValue("입력"))
        var required = 0.dp
        content(scale = 3f) {
            val scaledLine = with(LocalDensity.current) { 80.sp.toDp() }
            SideEffect { required = scaledLine }
            Column {
                PleosTextField(
                    value,
                    { value = it },
                    Modifier.width(600.dp).testTag("field"),
                    size = PleosFieldSize.Small,
                )
                PleosNumberField("0012", {}, 4, Modifier.testTag("number"))
            }
        }
        rule
            .onNode(hasSetTextAction() and hasAnyAncestor(hasTestTag("field")))
            .performSemanticsAction(SemanticsActions.RequestFocus) { it() }
        rule
            .onNodeWithContentDescription("입력 지우기")
            .assertWidthIsAtLeast(48.dp)
            .assertHeightIsAtLeast(48.dp)
        rule.onNodeWithTag("number").assertHeightIsAtLeast(required)
    }

    @Test
    fun toastIconRecompositionDoesNotRestartLifetime() {
        val state = PleosToastHostState()
        var counter by mutableIntStateOf(0)
        content {
            PleosToastPopup(
                true,
                "안내",
                {},
                state = state,
                id = "a",
                duration = PleosToastDuration.Custom(60000),
                icon = { PleosText("$counter") },
            )
        }
        var generation = 0L
        rule.runOnIdle {
            generation = state.current!!.generation
            counter++
        }
        rule.runOnIdle { assertEquals(generation, state.current!!.generation) }
        rule.onNodeWithText("1").assertIsDisplayed()
    }

    @Test
    fun toastTimerPausesWithHostLifecycle() {
        val owner =
            object : LifecycleOwner {
                val registry by lazy { LifecycleRegistry(this) }
                override val lifecycle: Lifecycle
                    get() = registry
            }
        val state = PleosToastHostState()
        state.show("시간 안내", duration = PleosToastDuration.Custom(350))
        content {
            CompositionLocalProvider(
                LocalLifecycleOwner provides owner,
                LocalAccessibilityManager provides null,
            ) {
                PleosToastHost(state)
            }
        }
        rule.runOnIdle { owner.registry.currentState = Lifecycle.State.STARTED }
        rule.waitForIdle()
        rule.runOnIdle { owner.registry.currentState = Lifecycle.State.CREATED }
        android.os.SystemClock.sleep(450)
        rule.runOnIdle {
            assertNotNull(state.current)
            owner.registry.currentState = Lifecycle.State.STARTED
        }
        rule.waitUntil(3000) { state.current == null }
    }

    @Test
    fun widgetOnlyHidesOnHandleDragAndUsesItsOwnPagination() {
        var visibility by mutableStateOf(PleosWidgetVisibility.Show)
        var hide = 0
        content {
            PleosWidgetHost(
                (0..2).map { PleosWidgetItem("$it", "위젯 제목", information = { PleosText("정보") }) },
                "0",
                {},
                visibility,
                {
                    hide++
                    visibility = it
                },
                Modifier.testTag("widget"),
            )
        }
        rule
            .onNode(
                SemanticsMatcher.expectValue(SemanticsProperties.StateDescription, "총 3페이지 중 1페이지")
            )
            .assertWidthIsEqualTo(44.dp)
        rule.onNodeWithTag("widget").performTouchInput { click(Offset(width / 2f, 30f)) }
        rule.runOnIdle { assertEquals(0, hide) }
        rule.onNodeWithTag("widget").performTouchInput {
            swipe(Offset(width * .75f, 100f), Offset(width * .75f, 300f), 300)
        }
        rule.runOnIdle { assertEquals(PleosWidgetVisibility.Show, visibility) }
        rule.onNodeWithTag("widget").performTouchInput {
            swipe(Offset(width / 2f, 20f), Offset(width / 2f, 200f), 300)
        }
        rule.runOnIdle { assertEquals(PleosWidgetVisibility.Hidden, visibility) }
    }

    @Test
    fun widgetChildrenRetainDpadAndTitleUsesSeparateScale() {
        var hidden = 0
        content(profile = PleosFormFactor.Wide) {
            Column {
                PleosWidgetHost(
                    listOf(
                        PleosWidgetItem(
                            "a",
                            "위젯 제목",
                            action = { PleosBasicButton("위젯 동작", {}) },
                            information = { PleosText("정보") },
                        )
                    ),
                    "a",
                    {},
                    PleosWidgetVisibility.Show,
                    { hidden++ },
                )
                PleosBasicButton("아래 영역", {})
            }
        }
        val layouts = mutableListOf<TextLayoutResult>()
        rule.onNodeWithText("위젯 제목").performSemanticsAction(SemanticsActions.GetTextLayoutResult) {
            it(layouts)
        }
        assertEquals(24.sp, layouts.single().layoutInput.style.fontSize)
        rule.onNodeWithText("위젯 동작").performSemanticsAction(SemanticsActions.RequestFocus) { it() }
        rule.onNodeWithText("위젯 동작").performKeyInput { pressKey(Key.DirectionDown) }
        rule.runOnIdle { assertEquals(0, hidden) }
        rule.onNodeWithText("아래 영역").assertIsFocused()
    }

    @Test
    fun controllerShapesAndStepperFullActionRemainOperable() {
        var value by mutableStateOf(java.math.BigDecimal.ONE)
        content {
            Column {
                PleosCenteredSlider(2e38f, {}, valueRange = 1e38f..3e38f)
                PleosStepper(
                    value,
                    { value = it },
                    java.math.BigDecimal.ZERO,
                    java.math.BigDecimal.TEN,
                    java.math.BigDecimal.ONE,
                    Modifier.testTag("stepper"),
                )
            }
        }
        rule.onNodeWithTag("stepper").performTouchInput { click(Offset(5f, height / 2f)) }
        rule.runOnIdle { assertEquals(java.math.BigDecimal.ZERO, value) }
    }
}
