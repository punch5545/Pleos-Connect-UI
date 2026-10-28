@file:OptIn(androidx.compose.ui.test.ExperimentalTestApi::class)

package com.jade.pleos.compose

import android.graphics.Bitmap
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.*
import androidx.compose.ui.semantics.*
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jade.pleos.tokens.*
import java.io.File
import java.math.BigDecimal
import java.time.*
import org.junit.*
import org.junit.Assert.*
import org.junit.runner.RunWith

class PleosTestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }
}

@RunWith(AndroidJUnit4::class)
class PleosLibraryUiTest {
    @get:Rule val rule = createAndroidComposeRule<PleosTestActivity>()

    private fun content(block: @Composable () -> Unit) {
        rule.setContent {
            val input = LocalInputModeManager.current
            LaunchedEffect(Unit) {
                input.requestInputMode(androidx.compose.ui.input.InputMode.Keyboard)
            }
            PleosTheme(
                capabilities = PleosCapabilities.Unrestricted,
                behavior = PleosBehaviorDefaults(reducedMotion = true),
            ) {
                block()
            }
        }
    }

    @Test
    fun buttonsBlockDisabledAndLoadingAndCancel() {
        var enabled by mutableStateOf(true)
        var loading by mutableStateOf(false)
        var clicks = 0
        content {
            PleosBasicButton(
                "실행",
                { clicks++ },
                Modifier.testTag("button"),
                enabled = enabled,
                loading = loading,
            )
        }
        rule.onNodeWithTag("button").performClick()
        rule.runOnIdle {
            assertEquals(1, clicks)
            loading = true
        }
        rule.onNodeWithTag("button").assertIsNotEnabled().performClick()
        rule.runOnIdle {
            assertEquals(1, clicks)
            loading = false
            enabled = false
        }
        rule.onNodeWithTag("button").assertIsNotEnabled().performClick()
        rule.runOnIdle {
            assertEquals(1, clicks)
            enabled = true
        }
        rule.onNodeWithTag("button").performTouchInput {
            down(center)
            cancel()
        }
        rule.runOnIdle { assertEquals(1, clicks) }
    }

    @Test
    fun selectionStateIsOwnedByCaller() {
        var value by mutableStateOf(false)
        var requests = 0
        content {
            PleosSwitch(
                value,
                {
                    requests++
                    value = it
                },
                Modifier.testTag("switch"),
            )
        }
        rule.onNodeWithTag("switch").assertIsOff().performClick().assertIsOn()
        rule.runOnIdle {
            assertEquals(1, requests)
            value = false
        }
        rule.onNodeWithTag("switch").assertIsOff()
    }

    @Test
    fun numberFieldPreservesLeadingZerosAndCompletesOnce() {
        var value by mutableStateOf("")
        var complete = 0
        content {
            PleosNumberField(
                value,
                { value = it },
                4,
                Modifier.testTag("pin"),
                onComplete = { complete++ },
            )
        }
        rule.onNode(hasSetTextAction()).performTextInput("0012")
        rule.runOnIdle {
            assertEquals("0012", value)
            assertEquals(1, complete)
        }
        rule.onNode(hasSetTextAction()).performTextInput("3")
        rule.runOnIdle {
            assertEquals("0012", value)
            assertEquals(1, complete)
        }
    }

    @Test
    fun textFieldMaintainsCompositionAndReadOnly() {
        var editing by mutableStateOf(TextFieldValue("가", TextRange(1), TextRange(0, 1)))
        var readOnly by mutableStateOf(false)
        content {
            PleosTextField(
                editing,
                { editing = it },
                Modifier.testTag("field"),
                readOnly = readOnly,
            )
        }
        rule.runOnIdle { assertEquals(TextRange(0, 1), editing.composition) }
        rule.onNode(hasSetTextAction()).performTextReplacement("대한민국")
        rule.runOnIdle {
            assertEquals("대한민국", editing.text)
            readOnly = true
        }
        rule.onAllNodes(hasSetTextAction()).assertCountEquals(0)
        rule.runOnIdle { assertEquals("대한민국", editing.text) }
    }

    @Test
    fun dropdownSwitchKeepsMenuAndSelectionCloses() {
        var expanded by mutableStateOf(true)
        var selected: String? by mutableStateOf(null)
        var checked by mutableStateOf(false)
        content {
            PleosDropdown(
                expanded,
                { expanded = it },
                listOf(
                    PleosDropdownEntry("a", "첫 항목"),
                    PleosDropdownEntry(
                        "b",
                        "설정",
                        kind = PleosDropdownItemKind.Switch(checked, { checked = it }),
                    ),
                ),
                selected,
                { selected = it },
                Modifier.width(600.dp),
            )
        }
        rule.onNodeWithText("설정").performClick()
        rule.runOnIdle {
            assertTrue(checked)
            assertTrue(expanded)
        }
        rule.onNodeWithText("첫 항목").performClick()
        rule.runOnIdle {
            assertEquals("a", selected)
            assertFalse(expanded)
        }
    }

    @Test
    fun latestWebGeometryIsUsed() {
        var component by mutableIntStateOf(0)
        content {
            Box(Modifier.width(1300.dp).height(900.dp)) {
                when (component) {
                    0 ->
                        PleosStepper(
                            BigDecimal.ONE,
                            {},
                            BigDecimal.ZERO,
                            BigDecimal.TEN,
                            BigDecimal.ONE,
                            Modifier.testTag("subject"),
                        )
                    1 ->
                        PleosDateSpinner(LocalDate.of(2024, 2, 29), {}, Modifier.testTag("subject"))
                    2 -> PleosTimeSpinner(LocalTime.NOON, {}, Modifier.testTag("subject"))
                    else ->
                        PleosPopupSurface(
                            "제목",
                            PleosPopupAction("ok", "확인", {}),
                            Modifier.testTag("subject"),
                            description = "설명",
                        )
                }
            }
        }
        rule.onNodeWithTag("subject").assertWidthIsEqualTo(400.dp)
        rule.runOnIdle { component = 1 }
        rule.onNodeWithTag("subject").assertWidthIsEqualTo(600.dp)
        rule.runOnIdle { component = 2 }
        rule.onNodeWithTag("subject").assertWidthIsEqualTo(500.dp)
        rule.runOnIdle { component = 3 }
        rule.onNodeWithTag("subject").assertWidthIsEqualTo(760.dp)
    }

    @Test
    fun allComponentFamiliesRenderAcrossThemesProfilesAndLargeText() {
        var fixture by mutableStateOf<@Composable () -> Unit>({})
        var dark by mutableStateOf(false)
        var profile by mutableStateOf(PleosFormFactor.Standard17)
        var scale by mutableFloatStateOf(1f)
        rule.setContent {
            val original = LocalDensity.current
            CompositionLocalProvider(
                LocalDensity provides Density(original.density, scale),
                LocalLayoutDirection provides LayoutDirection.Rtl,
            ) {
                PleosTheme(
                    darkTheme = dark,
                    formFactor = profile,
                    capabilities = PleosCapabilities.Unrestricted,
                    behavior = PleosBehaviorDefaults(reducedMotion = true),
                ) {
                    Box(
                        Modifier.fillMaxSize()
                            .background(PleosTheme.colors["background/primary"])
                            .testTag("capture")
                    ) {
                        fixture()
                    }
                }
            }
        }
        val fixtures: List<Pair<String, @Composable () -> Unit>> =
            listOf(
                "A01" to { PleosBasicButton("기본 버튼", {}) },
                "A02" to { PleosToggleButton("선택", true, {}) },
                "A03" to { PleosTextButton("더 보기", {}) },
                "A04" to
                    {
                        PleosIconButton("닫기", {}) { PleosIcon(CloseIcon, Modifier.fillMaxSize()) }
                    },
                "A05" to { PleosNumericKeypad({}) },
                "B01" to { PleosScrollBar(100f, 1000f, 200f, Modifier.height(400.dp), {}) },
                "C01" to { PleosCenteredSlider(0f, {}) },
                "I01" to { PleosPageIndicator(5, 2) },
                "D01" to
                    {
                        PleosDropdownMenu(
                            listOf(PleosDropdownEntry("1", "항목")),
                            "1",
                            {},
                            Modifier.width(600.dp),
                        )
                    },
                "F01" to { PleosTextField("입력값", {}, Modifier.width(700.dp)) },
                "F02" to { PleosNumberField("0012", {}, 4) },
                "N01" to
                    {
                        PleosPageNavigation(
                            PleosNavigationType.Depth,
                            "페이지",
                            subtitle = "보조 설명",
                            onBack = {},
                        )
                    },
                "P01" to
                    {
                        PleosPopupSurface(
                            "제목",
                            PleosPopupAction("ok", "확인", {}),
                            description = "긴 한국어 설명을 표시합니다.",
                        )
                    },
                "P02" to { PleosToastSurface("팝업 알림") },
                "T01" to
                    {
                        PleosTabs(listOf(PleosTabItem("a", "첫째"), PleosTabItem("b", "둘째")), "a", {})
                    },
                "S01" to { PleosCheckbox(ToggleableState.Indeterminate, {}) },
                "S02" to { PleosRadioButton(true, {}) },
                "S03" to { PleosSwitch(true, {}) },
                "SP01" to { PleosDateSpinner(LocalDate.of(2024, 2, 29), {}) },
                "SN01" to
                    {
                        PleosSystemNotificationCard(
                            "알림",
                            "설명",
                            listOf(PleosPopupAction("ok", "확인", {})),
                        )
                    },
                "TO01" to { PleosToastSurface("일반 알림") },
                "W01" to { PleosWidgetCard("주행 정보", information = { PleosText("120 km") }) },
            )
        val evidence = File(rule.activity.filesDir, "pleos-evidence").apply { mkdirs() }
        for (mode in 0..2) {
            rule.runOnIdle {
                dark = mode == 1
                profile = if (mode == 2) PleosFormFactor.Waterfall else PleosFormFactor.Standard17
                scale = if (mode == 2) 1.5f else 1f
            }
            for ((name, render) in fixtures) {
                rule.runOnIdle { fixture = render }
                rule.waitForIdle()
                rule.onNodeWithTag("capture").assertExists()
                if (mode < 2) {
                    val image = rule.onNodeWithTag("capture").captureToImage().asAndroidBitmap()
                    File(evidence, "${name}_${if(dark)"dark" else "light"}.png")
                        .outputStream()
                        .use { image.compress(Bitmap.CompressFormat.PNG, 100, it) }
                }
            }
        }
    }

    @Test
    fun dateWheelActionsClampLeapYearAndMonth() {
        var date by mutableStateOf(LocalDate.of(2024, 1, 31))
        content { PleosDateSpinner(date, { date = it }) }
        rule.onNodeWithContentDescription("월").performSemanticsAction(SemanticsActions.ScrollBy) {
            it(0f, 1f)
        }
        rule.runOnIdle { assertEquals(LocalDate.of(2024, 2, 29), date) }
        rule.onNodeWithContentDescription("연도").performSemanticsAction(SemanticsActions.ScrollBy) {
            it(0f, 1f)
        }
        rule.runOnIdle { assertEquals(LocalDate.of(2025, 2, 28), date) }
    }

    @Test
    fun passwordUsesProtectedSemantics() {
        content { PleosTextField("7319", {}, type = PleosFieldType.Password) }
        rule
            .onNode(hasSetTextAction())
            .assert(SemanticsMatcher.keyIsDefined(SemanticsProperties.Password))
        rule.onAllNodesWithText("7319").assertCountEquals(0)
    }

    @Test
    fun rejectedWheelValueRestoresPositionAndDoesNotSettle() {
        var value by mutableStateOf(1)
        var accept = false
        var requests = 0
        val settled = mutableListOf<Int>()
        content {
            PleosWheelColumn(
                (0..5).toList(),
                value,
                {
                    requests++
                    if (accept) value = it
                },
                Modifier.width(200.dp).testTag("wheel"),
                "값",
                onSettled = { settled.add(it) },
            )
        }
        val before = rule.onNodeWithTag("wheel").captureToImage().asAndroidBitmap()
        rule.onNodeWithTag("wheel").performSemanticsAction(SemanticsActions.ScrollBy) { it(0f, 1f) }
        rule.waitForIdle()
        val after = rule.onNodeWithTag("wheel").captureToImage().asAndroidBitmap()
        rule.runOnIdle {
            assertEquals(1, requests)
            assertTrue(settled.isEmpty())
            assertTrue(before.sameAs(after))
            accept = true
        }
        rule.onNodeWithTag("wheel").performSemanticsAction(SemanticsActions.ScrollBy) { it(0f, 1f) }
        rule.waitForIdle()
        rule.runOnIdle {
            assertEquals(2, value)
            assertEquals(listOf(2), settled)
        }
    }

    @Test
    fun dropdownBackHasDistinctReasonAndRestoresFocus() {
        var expanded by mutableStateOf(true)
        var reason: PleosDismissReason? = null
        content {
            PleosDropdown(
                expanded,
                { expanded = it },
                listOf(PleosDropdownEntry("a", "선택 항목")),
                null,
                {},
                Modifier.width(600.dp),
                onDismissRequest = { reason = it },
            )
        }
        rule.onNodeWithText("선택 항목").performKeyInput { pressKey(Key.Back) }
        rule.runOnIdle {
            assertFalse(expanded)
            assertEquals(PleosDismissReason.Back, reason)
        }
        rule
            .onNode(SemanticsMatcher.expectValue(SemanticsProperties.StateDescription, "접힘"))
            .assertIsFocused()
    }

    @Test
    fun loadingRetainsNameAndReadOnlyRetainsSelection() {
        var value by mutableStateOf(TextFieldValue("선택 가능한 문장"))
        content {
            Column {
                PleosBasicButton("저장", {}, loading = true)
                PleosTextButton("전송", {}, loading = true)
                PleosTextField(value, { value = it }, readOnly = true, label = "이름")
            }
        }
        rule.onNodeWithText("저장").assertExists()
        rule.onNodeWithText("전송").assertExists()
        rule.onNode(hasContentDescription("이름")).performSemanticsAction(
            SemanticsActions.SetSelection
        ) {
            it(0, 2, false)
        }
        rule.runOnIdle { assertEquals(TextRange(0, 2), value.selection) }
    }

    @Test
    fun wheelNavigationAllowsDpadFocusToLeave() {
        val wheel = FocusRequester()
        content {
            Column {
                PleosWheelColumn(
                    (0..2).toList(),
                    1,
                    {},
                    Modifier.width(200.dp).focusRequester(wheel).testTag("wheel"),
                    "값",
                )
                PleosBasicButton("다음", {}, Modifier.testTag("next"))
            }
        }
        rule.runOnIdle { wheel.requestFocus() }
        rule.onNodeWithTag("wheel").performKeyInput { pressKey(Key.DirectionDown) }
        rule.onNodeWithTag("next").assertIsFocused()
    }

    @Test
    fun popupOutsideDismissUsesExplicitReason() {
        var shown by mutableStateOf(true)
        var reason: PleosDismissReason? = null
        content {
            if (shown)
                PleosSystemPopup(
                    "확인창",
                    PleosPopupAction("ok", "확인", {}),
                    {
                        reason = it
                        shown = false
                    },
                    Modifier.testTag("popup"),
                )
        }
        rule.onNodeWithTag("popup").performTouchInput {
            click(androidx.compose.ui.geometry.Offset(-10f, 10f))
        }
        rule.runOnIdle {
            assertEquals(PleosDismissReason.Outside, reason)
            assertFalse(shown)
        }
    }

    @Test
    fun popupReflowsWithResizeLargeTextAndLazyBody() {
        var width by mutableStateOf(760.dp)
        var scale by mutableFloatStateOf(1f)
        rule.setContent {
            val original = LocalDensity.current
            CompositionLocalProvider(LocalDensity provides Density(original.density, scale)) {
                PleosTheme(capabilities = PleosCapabilities.Unrestricted) {
                    Box(Modifier.width(width).height(700.dp)) {
                        PleosPopupSurface(
                            "긴 제목을 포함하는 확인창",
                            PleosPopupAction("ok", "확인", {}),
                            cancelAction = PleosPopupAction("cancel", "취소", {}),
                            bodyScroll = false,
                            body = {
                                androidx.compose.foundation.lazy.LazyColumn {
                                    items(40) { PleosText("목록 항목 $it") }
                                }
                            },
                        )
                    }
                }
            }
        }
        rule.waitUntilAtLeastOneExists(hasText("확인"), timeoutMillis = 5000)
        rule.onNodeWithText("확인").assertIsDisplayed()
        rule.runOnIdle {
            width = 400.dp
            scale = 2f
        }
        rule.waitUntilAtLeastOneExists(hasText("확인"), timeoutMillis = 5000)
        rule.onNodeWithText("확인").assertIsDisplayed()
        rule.onNodeWithText("취소").assertIsDisplayed()
    }

    @Test
    fun widgetKeepsPageWhenHiddenAndRestored() {
        var current by mutableStateOf("a")
        var visibility by mutableStateOf(PleosWidgetVisibility.Show)
        content {
            PleosWidgetHost(
                listOf(
                    PleosWidgetItem("a", "첫째", information = { PleosText("첫째 정보") }),
                    PleosWidgetItem("b", "둘째", information = { PleosText("둘째 정보") }),
                ),
                current,
                { current = it },
                visibility,
                { visibility = it },
                Modifier.testTag("widget"),
            )
        }
        val next =
            rule
                .onNodeWithTag("widget")
                .fetchSemanticsNode()
                .config[SemanticsActions.CustomActions]
                .first { it.label == "다음 위젯" }
                .action
        rule.runOnIdle { next() }
        rule.runOnIdle {
            assertEquals("b", current)
            visibility = PleosWidgetVisibility.Hidden
        }
        rule.onNodeWithContentDescription("위젯 펼치기").performClick()
        rule.runOnIdle {
            assertEquals("b", current)
            assertEquals(PleosWidgetVisibility.Show, visibility)
        }
        rule.onNodeWithText("둘째 정보").assertExists()
    }

    @Test
    fun loadingKeepsExistingFocusAndKeyboardActivatesOnce() {
        var loading by mutableStateOf(false)
        var clicks = 0
        content {
            PleosBasicButton("저장", { clicks++ }, Modifier.testTag("button"), loading = loading)
        }
        rule.onNodeWithTag("button").performSemanticsAction(SemanticsActions.RequestFocus) { it() }
        rule.onNodeWithTag("button").assertIsFocused()
        rule.runOnIdle { loading = true }
        rule.onNodeWithTag("button").assertIsFocused().assertIsNotEnabled().performKeyInput {
            pressKey(Key.Enter)
        }
        rule.runOnIdle {
            assertEquals(0, clicks)
            loading = false
        }
        rule.onNodeWithTag("button").assertIsFocused().performKeyInput { pressKey(Key.Enter) }
        rule.runOnIdle { assertEquals(1, clicks) }
    }

    @Test
    fun longEditorScrollAndNumberSelectionKeepCaret() {
        var text by mutableStateOf(TextFieldValue("가나다라마바사아자차카타파하".repeat(15)))
        var number by mutableStateOf("0012")
        var mode by mutableIntStateOf(0)
        content {
            if (mode == 0) PleosTextField(text, { text = it }, Modifier.width(400.dp))
            else PleosNumberField(number, { number = it }, 4)
        }
        rule.onNode(hasSetTextAction()).performSemanticsAction(SemanticsActions.SetSelection) {
            it(0, 0, false)
        }
        rule.onNode(hasSetTextAction()).performTextInput("앞")
        rule.runOnIdle {
            assertTrue(text.text.startsWith("앞"))
            mode = 1
        }
        rule.onNode(hasSetTextAction()).performSemanticsAction(SemanticsActions.SetSelection) {
            it(1, 2, false)
        }
        rule.onNode(hasSetTextAction()).performTextInput("9")
        rule.runOnIdle { assertEquals("0912", number) }
    }

    @Test
    fun longEditorKeepsTrailingCursorInsideViewport() {
        val initial = "W".repeat(80) + " "
        var value by mutableStateOf(TextFieldValue(initial, TextRange(initial.length)))
        var expected = 0
        var densityMultiplier by mutableFloatStateOf(1f)
        var sampleInset = 0f
        content {
            val original = LocalDensity.current
            CompositionLocalProvider(
                LocalDensity provides
                    Density(original.density * densityMultiplier, original.fontScale)
            ) {
                val cursorColor = PleosTheme.colors["field/focused"].toArgb()
                val metrics = PleosTheme.metrics
                val inset =
                    metrics.dp("fields/text/medium/padding_horizontal", 32f).value +
                        metrics.dp("fields/text/cursor_width", 3f).value / 2
                SideEffect {
                    expected = cursorColor
                    sampleInset = inset
                }
                PleosTextField(
                    value,
                    { value = it },
                    Modifier.width(400.dp).testTag("editor"),
                    clearable = false,
                )
            }
        }
        for (multiplier in listOf(1f, 3f)) {
            rule.runOnIdle { densityMultiplier = multiplier }
            rule.onNode(hasSetTextAction()).performSemanticsAction(SemanticsActions.RequestFocus) {
                it()
            }
            rule.waitForIdle()
            val bitmap = rule.onNodeWithTag("editor").captureToImage().asAndroidBitmap()
            val scale = bitmap.width / 400f
            val pixel =
                bitmap.getPixel((bitmap.width - sampleInset * scale).toInt(), bitmap.height / 2)
            for (shift in listOf(0, 8, 16)) assertTrue(
                kotlin.math.abs(((pixel shr shift) and 255) - ((expected shr shift) and 255)) <= 2
            )
        }
    }

    @Test
    fun numberCellRequestsKeyboardAgainAndOverwritesSelectedDigit() {
        var shown = 0
        val keyboard =
            object : SoftwareKeyboardController {
                override fun show() {
                    shown++
                }

                override fun hide() {}
            }
        var value by mutableStateOf("0012")
        content {
            CompositionLocalProvider(LocalSoftwareKeyboardController provides keyboard) {
                PleosNumberField(value, { value = it }, 4, Modifier.testTag("number"))
            }
        }
        rule.onNodeWithTag("number").performTouchInput {
            click(androidx.compose.ui.geometry.Offset(width / 8f, height / 2f))
        }
        val before = shown
        keyboard.hide()
        rule.onNodeWithTag("number").performTouchInput {
            click(androidx.compose.ui.geometry.Offset(width / 8f, height / 2f))
        }
        rule.runOnIdle { assertTrue(shown > before) }
        rule.onNode(hasSetTextAction()).performTextInput("9")
        rule.runOnIdle { assertEquals("9012", value) }
    }
}
