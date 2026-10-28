package com.jade.pleos.compose

import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jade.pleos.tokens.*
import java.time.*
import java.util.Locale
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PleosVariantCoverageTest {
    @get:Rule val rule = createAndroidComposeRule<PleosTestActivity>()

    private data class Fixture(val name: String, val render: @Composable () -> Unit)

    @Composable
    private fun pressSource(pressed: Boolean): MutableInteractionSource {
        val source = remember { MutableInteractionSource() }
        LaunchedEffect(source, pressed) {
            if (pressed) source.emit(PressInteraction.Press(Offset.Zero))
        }
        return source
    }

    @Test
    fun requiredTypesSizesStatesAndSlotsRender() {
        var fixture by mutableStateOf<Fixture?>(null)
        rule.setContent {
            PleosTheme(
                capabilities = PleosCapabilities.Unrestricted,
                behavior = PleosBehaviorDefaults(reducedMotion = true),
            ) {
                Box(Modifier.fillMaxSize().testTag("fixture")) {
                    fixture?.let { key(it.name) { it.render() } }
                }
            }
        }
        val cases = mutableListOf<Fixture>()
        var events = 0
        fun add(name: String, render: @Composable () -> Unit) {
            cases.add(Fixture(name, render))
        }
        for (size in PleosButtonSize.entries) for (h in PleosButtonHierarchy.entries) for (state in
            0..3) add("A01-$size-$h-$state") {
            PleosBasicButton(
                "버튼",
                { events++ },
                size = size,
                hierarchy = h,
                enabled = state != 2,
                loading = state == 3,
                leadingIcon = { PleosIcon(PlusIcon, Modifier.fillMaxSize()) },
                trailingIcon = { PleosIcon(DownIcon, Modifier.fillMaxSize()) },
                interactionSource = pressSource(state == 1),
            )
        }
        for (size in PleosButtonSize.entries) for (on in listOf(false, true)) for (floating in
            listOf(false, true)) for (state in 0..2) add("A02-$size-$on-$floating-$state") {
            PleosToggleButton(
                "토글",
                on,
                { events++ },
                size = size,
                enabled = state != 2,
                floating = floating,
                interactionSource = pressSource(state == 1),
            )
        }
        for (size in PleosTextButtonSize.entries) for (state in 0..3) add("A03-$size-$state") {
            PleosTextButton(
                "더 보기",
                { events++ },
                size = size,
                enabled = state != 2,
                loading = state == 3,
                interactionSource = pressSource(state == 1),
                leadingIcon = { PleosIcon(PlusIcon, Modifier.fillMaxSize()) },
                trailingIcon = { PleosIcon(DownIcon, Modifier.fillMaxSize()) },
            )
        }
        for (size in PleosButtonSize.entries) for (style in
            PleosIconButtonStyle.entries) for (state in 0..2) add("A04-$size-$style-$state") {
            PleosIconButton(
                "닫기",
                { events++ },
                size = size,
                style = style,
                enabled = state != 2,
                interactionSource = pressSource(state == 1),
            ) {
                PleosIcon(CloseIcon, Modifier.fillMaxSize())
            }
        }
        val numeric =
            listOf(
                PleosNumericKeyKind.Number(1),
                PleosNumericKeyKind.Delete,
                PleosNumericKeyKind.Function(),
            )
        for (kind in numeric) for (state in 0..2) add("A05-numeric-$kind-$state") {
            PleosNumericKey(
                kind,
                { events++ },
                enabled = state != 2,
                interactionSource = pressSource(state == 1),
            )
        }
        for (palette in PleosKeyboardPalette.entries) for (kind in
            PleosKeyboardKeyKind.entries) for (shift in listOf(false, true)) for (pressed in
            listOf(false, true)) add("A05-key-$palette-$kind-$shift-$pressed") {
            PleosKeyboardKey(
                kind,
                { events++ },
                label = "A",
                palette = palette,
                shifted = shift,
                interactionSource = pressSource(pressed),
            )
        }
        for (palette in PleosKeyboardPalette.entries) for (language in
            PleosKeyboardLanguage.entries) for (mode in PleosKeyboardMode.entries) add(
            "A05-layout-$palette-$language-$mode"
        ) {
            PleosKeyboard({ events++ }, palette = palette, language = language, mode = mode)
        }
        for (enabled in listOf(false, true)) {
            add("B01-window-$enabled") { PleosWindowControlBar({ events++ }, enabled = enabled) }
            add("B01-app-$enabled") { PleosAppControlBar({ events++ }, enabled = enabled) }
            add("B01-scroll-$enabled") {
                PleosScrollBar(
                    100f,
                    1000f,
                    100f,
                    Modifier.height(400.dp),
                    if (enabled) ({ events++ }) else null,
                    enabled,
                )
            }
        }
        for (surface in PleosSliderSurface.entries) for (size in
            PleosSliderSize.entries) for (value in listOf(0f, .25f, .5f, .76f, 1f)) add(
            "C01-continuous-$surface-$size-$value"
        ) {
            PleosContinuousSlider(
                value,
                { events++ },
                surface = surface,
                size = size,
                label = "음량",
                step = .01f,
            )
        }
        for (type in PleosCenteredSliderType.entries) for (off in listOf(false, true)) add(
            "C01-centered-$type-$off"
        ) {
            PleosCenteredSlider(0f, { events++ }, type = type, off = off)
        }
        for (size in PleosIndicatorSize.entries) for (count in listOf(0, 1, 5)) for (interactive in
            listOf(false, true)) add("I01-$size-$count-$interactive") {
            PleosPageIndicator(
                count,
                count - 1,
                size = size,
                onPageSelected = if (interactive) ({ events++ }) else null,
            )
        }
        for (margin in listOf(false, true)) for (withIcon in listOf(false, true)) add(
            "P02-$margin-$withIcon"
        ) {
            val state = remember {
                PleosToastHostState().apply {
                    show(
                        "팝업 알림",
                        duration = PleosToastDuration.Custom(60_000),
                        icon =
                            if (withIcon) ({ PleosIcon(PlusIcon, Modifier.fillMaxSize()) })
                            else null,
                    )
                }
            }
            PleosToastPopup(state, margin = margin)
        }
        for (withIcon in listOf(false, true)) for (withClose in listOf(false, true)) add(
            "TO01-$withIcon-$withClose"
        ) {
            PleosToastSurface(
                "일반 알림",
                icon = if (withIcon) ({ PleosIcon(PlusIcon, Modifier.fillMaxSize()) }) else null,
                onClose = if (withClose) ({ events++ }) else null,
            )
        }
        for (size in PleosDropdownSize.entries) for (footer in listOf(false, true)) add(
            "D01-$size-$footer"
        ) {
            PleosDropdownMenu(
                listOf(
                    PleosDropdownEntry(
                        "a",
                        "선택 항목",
                        prefix = { PleosIcon(PlusIcon, Modifier.fillMaxSize()) },
                        isNew = true,
                    ),
                    PleosDropdownEntry(
                        "b",
                        "설정",
                        kind = PleosDropdownItemKind.Switch(true, { events++ }),
                    ),
                    PleosDropdownEntry(
                        "c",
                        "추가",
                        kind =
                            if (footer) PleosDropdownItemKind.Footer { events++ }
                            else PleosDropdownItemKind.Selection,
                    ),
                ),
                "a",
                { events++ },
                Modifier.width(600.dp),
                size,
            )
        }
        for (type in PleosFieldType.entries) for (size in PleosFieldSize.entries) for (state in
            0..6) add("F01-$type-$size-$state") {
            val focus = remember { FocusRequester() }
            LaunchedEffect(Unit) { if (state == 1 || state == 2) focus.requestFocus() }
            PleosTextField(
                TextFieldValue(if (state in listOf(2, 3, 4, 5)) "입력값" else "", TextRange.Zero),
                { events++ },
                Modifier.width(700.dp).focusRequester(focus),
                type,
                size,
                enabled = state != 6,
                readOnly = state == 4,
                invalid = if (state == 5) "입력값을 확인하십시오" else null,
                placeholder = "입력",
                supportingText = "도움말",
                passwordVisible = false,
                onPasswordVisibilityChange = { events++ },
            )
        }
        for (size in PleosNumberFieldSize.entries) for (state in 0..5) add("F02-$size-$state") {
            val focus = remember { FocusRequester() }
            LaunchedEffect(Unit) { if (state == 1) focus.requestFocus() }
            PleosNumberField(
                if (state == 2) "0012" else "",
                { events++ },
                4,
                modifier = Modifier.focusRequester(focus),
                size = size,
                enabled = state != 5,
                readOnly = state == 4,
                invalid = if (state == 3) "오류" else null,
            )
        }
        for (preset in PleosHeaderPreset.entries) add("N01-$preset") {
            PleosNavigationHeader(
                preset,
                "서비스",
                subtitle = "보조 설명",
                appIcon = { PleosIcon(PlusIcon, Modifier.fillMaxSize()) },
                tabs = {
                    PleosTabs(
                        listOf(PleosTabItem("a", "첫째"), PleosTabItem("b", "둘째")),
                        "a",
                        { events++ },
                        style = PleosTabsStyle.Line,
                    )
                },
            )
        }
        add("N01-Main-menus") {
            PleosPageNavigation(
                PleosNavigationType.Main,
                "서비스",
                Modifier.width(988.dp),
                primaryMenu = {
                    PleosNavigationDropdown(
                        false,
                        { events++ },
                        listOf(PleosDropdownEntry("a", "라디오")),
                        "a",
                        { events++ },
                    )
                },
                secondaryMenu = { PleosNavigationMenu("FM", { events++ }) },
            )
        }
        add("N01-Depth-subtitle") {
            PleosPageNavigation(
                PleosNavigationType.Depth,
                "페이지",
                Modifier.width(988.dp),
                subtitle = "설명",
                onBack = { events++ },
            )
        }
        add("N01-Search") {
            PleosSearchNavigation(
                TextFieldValue("검색어"),
                { events++ },
                { events++ },
                { events++ },
                Modifier.width(988.dp),
                onBack = { events++ },
            )
        }
        for (size in PleosPopupSize.entries) add("P01-$size-I-no-actions") {
            PleosPopupSurface("안내", null, size = size, description = "읽기 전용 내용")
        }
        for (size in PleosPopupSize.entries) for (preset in
            PleosPopupMetricsPreset.entries) for (layout in PleosActionLayout.entries) for (body in
            0..3) add("P01-$size-$preset-$layout-$body") {
            PleosPopupSurface(
                "팝업 제목",
                PleosPopupAction("ok", "확인", { events++ }),
                size = size,
                metricsPreset = preset,
                cancelAction = PleosPopupAction("cancel", "취소", { events++ }),
                buttonAlign = layout,
                subtitle = "부제목",
                description = "내용을 확인하십시오",
                icon = { PleosIcon(PlusIcon, Modifier.fillMaxSize()) },
                body =
                    when (body) {
                        0 -> null
                        1 -> ({ PleosDateSpinner(LocalDate.of(2024, 2, 29), { events++ }) })
                        2 -> ({ PleosTextField("", { events++ }, placeholder = "입력") })
                        else -> ({ Column { repeat(5) { PleosText("목록 항목 ${it+1}") } } })
                    },
            )
        }
        for (size in PleosTabsSize.entries) for (count in
            2..if (size == PleosTabsSize.Large) 6 else 5) for (fitted in listOf(false, true)) add(
            "T01-box-$size-$count-$fitted"
        ) {
            PleosTabs(
                (1..count).map { PleosTabItem("$it", "항목 $it", enabled = it != count) },
                "1",
                { events++ },
                size = size,
                fitted = fitted,
            )
        }
        for (margin in PleosLineTabMargin.entries) for (bottom in listOf(false, true)) add(
            "T01-line-$margin-$bottom"
        ) {
            PleosTabs(
                listOf(PleosTabItem("a", "첫째"), PleosTabItem("b", "둘째")),
                "a",
                { events++ },
                style = PleosTabsStyle.Line,
                lineMargin = margin,
                bottomLine = bottom,
            )
        }
        for (value in ToggleableState.entries) for (state in 0..2) add("S01-$value-$state") {
            PleosCheckbox(
                value,
                { events++ },
                enabled = state != 2,
                interactionSource = pressSource(state == 1),
            )
        }
        for (value in listOf(false, true)) for (state in 0..2) add("S02-$value-$state") {
            PleosRadioButton(
                value,
                { events++ },
                enabled = state != 2,
                interactionSource = pressSource(state == 1),
                invalid = "선택 오류",
            )
        }
        for (size in PleosSwitchSize.entries) for (value in listOf(false, true)) for (state in
            0..2) add("S03-$size-$value-$state") {
            PleosSwitch(
                value,
                { events++ },
                enabled = state != 2,
                size = size,
                interactionSource = pressSource(state == 1),
                invalid = "설정 오류",
            )
        }
        for (size in PleosSpinnerSize.entries) for (is24 in listOf(false, true)) add(
            "SP01-$size-$is24"
        ) {
            PleosDateTimeSpinner(
                LocalDateTime.of(2024, 2, 29, 12, 30),
                { events++ },
                size = size,
                is24Hour = is24,
                minuteStep = 5,
                locale = Locale.KOREA,
                dateHeading = "날짜",
                timeHeading = "시간",
            )
        }
        val images =
            listOf(
                PleosNotificationImagery.None,
                PleosNotificationImagery.App(null),
                PleosNotificationImagery.Profile(null, null),
                PleosNotificationImagery.Image(null),
            )
        for (image in images) for (layout in PleosActionLayout.entries) add("SN01-$image-$layout") {
            PleosSystemNotificationCard(
                "제목",
                "설명",
                listOf(PleosPopupAction("a", "확인", { events++ })) +
                    (if (layout == PleosActionLayout.Single) emptyList()
                    else listOf(PleosPopupAction("b", "취소", { events++ }))),
                imagery = image,
                actionLayout = layout,
            )
        }
        add("SN01-call") {
            PleosSystemNotificationCard(
                "전화",
                "수신 중",
                listOf(
                    PleosPopupAction("accept", "받기", { events++ }),
                    PleosPopupAction("end", "거절", { events++ }),
                ),
                kind = PleosNotificationKind.Call,
                imagery = PleosNotificationImagery.Profile(null, null),
            )
        }
        add("SN01-only-text") {
            PleosSystemNotificationCard(
                "제목",
                "설명",
                listOf(PleosPopupAction("ok", "확인", { events++ })),
                kind = PleosNotificationKind.OnlyText,
            )
        }
        for (visibility in PleosWidgetVisibility.entries) for (enabled in listOf(false, true)) add(
            "W01-$visibility-$enabled"
        ) {
            PleosWidgetHost(
                listOf(PleosWidgetItem("a", "주행 정보", information = { PleosText("120 km") })),
                "a",
                { events++ },
                visibility,
                { events++ },
                enabled = enabled,
            )
        }
        rule.waitUntil(timeoutMillis = 5000) {
            runCatching { rule.onAllNodesWithTag("fixture").fetchSemanticsNodes().isNotEmpty() }
                .getOrDefault(false)
        }
        for (item in cases) {
            rule.runOnIdle { fixture = item }
            rule.waitForIdle()
            rule.onNodeWithTag("fixture").assertIsDisplayed()
        }
        java.io
            .File(rule.activity.filesDir, "variant-coverage.txt")
            .writeText(cases.joinToString("\n") { it.name } + "\ncount=${cases.size}\n")
        rule.runOnIdle { check(events == 0) { "표시만으로 이벤트가 발생했습니다: $events" } }
    }
}
