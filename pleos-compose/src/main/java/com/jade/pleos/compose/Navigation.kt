package com.jade.pleos.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.*
import androidx.compose.foundation.selection.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.jade.pleos.tokens.*

enum class PleosIndicatorSize {
    Wide,
    Narrow,
}

/**
 * 02 §9 / I01. pageCount≥0을 요구하고 currentPage는 표시 범위에 clamp합니다. onPageSelected가 없으면 비대화형입니다. 원본
 * 노드·binding 식별자는 tools/spec_inventory.json의 22_figma_display_support.md 항목을 참조합니다. 기본값·유효 타입은 선언의
 * 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosPageIndicator(
    pageCount: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    size: PleosIndicatorSize = PleosIndicatorSize.Wide,
    onPageSelected: ((Int) -> Unit)? = null,
    dotGap: Dp? = null,
) {
    require(pageCount >= 0)
    if (pageCount == 0) {
        Box(modifier)
        return
    }
    val current = currentPage.coerceIn(0, pageCount - 1)
    val c = PleosTheme.colors
    Row(
        modifier.semantics(mergeDescendants = true) {
            stateDescription = "총 ${pageCount}페이지 중 ${current+1}페이지"
        },
        horizontalArrangement =
            Arrangement.spacedBy(
                if (onPageSelected != null) 0.dp
                else dotGap ?: if (size == PleosIndicatorSize.Wide) 16.dp else 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(pageCount) { i ->
            val dot: @Composable () -> Unit = {
                Box(
                    Modifier.size(8.dp)
                        .background(
                            c["text/dark/primary"].copy(alpha = if (i == current) 1f else .32f),
                            androidx.compose.foundation.shape.CircleShape,
                        )
                )
            }
            if (onPageSelected == null) dot()
            else
                Box(
                    Modifier.size(48.dp)
                        .selectable(i == current, role = Role.Tab) { onPageSelected(i) }
                        .semantics { contentDescription = "${i+1}페이지" },
                    contentAlignment = Alignment.Center,
                ) {
                    dot()
                }
        }
    }
}

enum class PleosTabsStyle {
    Box,
    Line,
}

enum class PleosTabsSize {
    Large,
    Medium,
}

enum class PleosLineTabMargin {
    Medium,
    PageNavigationLarge,
}

data class PleosTabItem(
    val key: String,
    val label: String,
    val enabled: Boolean = true,
    val icon: (@Composable () -> Unit)? = null,
)

/**
 * 03 §6 / T01. 유일한 key와 최소 2개 항목이 필요합니다. Box Large 2~6·Medium 2~5 조합을 검증합니다. Line은 fitted 여부와
 * margin을 별도로 선택합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 17_figma_tabs.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
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
) {
    require(items.size >= 2 && items.map { it.key }.distinct().size == items.size)
    if (style == PleosTabsStyle.Box) {
        require(items.size <= if (size == PleosTabsSize.Large) 6 else 5)
    }
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val box = style == PleosTabsStyle.Box
    val large = size == PleosTabsSize.Large
    val bp = "tabs/solid/${if(large)"large" else "medium"}/"
    val radius = m.dp(bp + "radius_top_left", if (large) 32f else 24f)
    val outer =
        if (box) m.dp("tabs/solid/padding", 8f)
        else if (bottomLine) m.dp("tabs/line/padding_horizontal", 28f) else 0.dp
    val base =
        modifier.then(
            if (box)
                Modifier.background(
                    c["controller/tab_background"],
                    androidx.compose.foundation.shape.RoundedCornerShape(radius),
                )
            else Modifier
        )
    Box(base.selectableGroup().semantics { collectionInfo = CollectionInfo(1, items.size) }) {
        val row =
            Modifier.padding(
                    horizontal = outer,
                    vertical = if (box) m.dp("tabs/solid/padding", 8f) else 0.dp,
                )
                .then(
                    if (!fitted) Modifier.horizontalScroll(rememberScrollState())
                    else Modifier.fillMaxWidth()
                )
        Row(
            row,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement =
                Arrangement.spacedBy(if (box) 0.dp else m.dp("tabs/line/gap_horizontal", 24f)),
        ) {
            items.forEachIndexed { index, item ->
                key(item.key) {
                    val selected = item.key == selectedKey
                    val source = remember { MutableInteractionSource() }
                    val pressed by source.collectIsPressedAsState()
                    val bringIntoView = remember { BringIntoViewRequester() }
                    LaunchedEffect(selected, fitted) {
                        if (selected && !fitted) {
                            withFrameNanos {}
                            bringIntoView.bringIntoView()
                        }
                    }
                    val itemRadius =
                        if (box) m.dp(bp + "button/radius_top_left", if (large) 24f else 16f)
                        else m.dp("tabs/line/button/pressed_radius_top_left", 12f)
                    val bg =
                        if (box && selected) c["button/switch/enabled"]
                        else if (pressed && item.enabled)
                            c[if (box) "button/basic/pressed" else "dim/dark/primary"]
                        else androidx.compose.ui.graphics.Color.Transparent
                    val color =
                        if (!item.enabled) c["text/dark/quaternary"]
                        else if (selected) c["text/dark/primary"]
                        else c.scoped(.84f, "text/dark/secondary")
                    val itemModifier = if (fitted) Modifier.weight(1f) else Modifier
                    Box(
                        itemModifier
                            .bringIntoViewRequester(bringIntoView)
                            .focusIndication(source, itemRadius)
                            .selectable(selected, source, null, item.enabled, Role.Tab) {
                                onSelected(item.key)
                            }
                            .semantics { collectionItemInfo = CollectionItemInfo(0, 1, index, 1) },
                        contentAlignment = Alignment.Center,
                    ) {
                        PleosSurface(
                            Modifier.then(if (fitted) Modifier.fillMaxWidth() else Modifier)
                                .padding(
                                    vertical =
                                        if (box) 0.dp
                                        else if (lineMargin == PleosLineTabMargin.Medium)
                                            m.dp("tabs/line/button/wrap_padding_vertical", 12f)
                                        else
                                            m.dp(
                                                "tabs/line/button/wrap_padding_vertical_large",
                                                26f,
                                            )
                                )
                                .heightIn(
                                    min =
                                        if (box) m.dp(bp + "button/height", if (large) 84f else 64f)
                                        else m.dp("tabs/line/button/height", 76f)
                                ),
                            bg,
                            itemRadius,
                            shadowLevel = if (box && selected) if (large) 2 else 1 else 0,
                        ) {
                            CompositionLocalProvider(LocalPleosContentColor provides color) {
                                Row(
                                    Modifier.padding(
                                        horizontal =
                                            if (box)
                                                m.dp(
                                                    bp + "button/padding_horizontal",
                                                    if (large) 28f else 18f,
                                                )
                                            else m.dp("tabs/line/button/padding_horizontal", 14f),
                                        vertical =
                                            if (box)
                                                m.dp(
                                                    bp + "button/padding_vertical",
                                                    if (large) 16f else 12f,
                                                )
                                            else m.dp("tabs/line/button/padding_vertical", 18f),
                                    ),
                                    horizontalArrangement =
                                        Arrangement.spacedBy(
                                            if (box)
                                                m.dp(
                                                    bp + "button/gap_horizontal",
                                                    if (large) 14f else 8f,
                                                )
                                            else m.dp("tabs/line/button/gap_horizontal", 8f),
                                            Alignment.CenterHorizontally,
                                        ),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    item.icon?.let {
                                        Box(
                                            Modifier.size(
                                                if (!box)
                                                    m.dp("tabs/line/button/prefix_square", 40f)
                                                else
                                                    m.dp(
                                                        bp +
                                                            if (large) "button/prefix_icon_square"
                                                            else "button/prefix_square",
                                                        if (large) 52f else 40f,
                                                    )
                                            ),
                                            contentAlignment = Alignment.Center,
                                        ) {
                                            it()
                                        }
                                    }
                                    PleosText(
                                        item.label,
                                        Modifier.weight(1f, false),
                                        style =
                                            pleosTextStyle(
                                                if (box && !large) 30 else 32,
                                                if (box && !large) 38 else 40,
                                                FontWeight.Bold,
                                            ),
                                        maxLines = 1,
                                        textAlign = TextAlign.Center,
                                    )
                                }
                            }
                        }
                        if (!box)
                            Box(
                                Modifier.align(Alignment.BottomCenter)
                                    .fillMaxWidth()
                                    .height(m.dp("tabs/line/selected_border_bottom", 4f))
                                    .background(
                                        if (selected) c["text/dark/primary"]
                                        else androidx.compose.ui.graphics.Color.Transparent
                                    )
                            )
                    }
                    if (box && index < items.lastIndex)
                        Box(
                            Modifier.width(2.dp)
                                .height(36.dp)
                                .background(
                                    if (selected || items[index + 1].key == selectedKey)
                                        androidx.compose.ui.graphics.Color.Transparent
                                    else c["divider/secondary"]
                                )
                        )
                }
            }
        }
        if (!box && bottomLine)
            Box(
                Modifier.align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(c["divider/secondary"])
            )
    }
}

enum class PleosNavigationType {
    Main,
    Depth,
    Search,
}

enum class PleosHeaderPreset {
    Radio,
    Phone,
    RadioSegmented,
    PhoneSegmented,
    Music,
    MusicBackground,
}

/**
 * 03 §3 / N01. Main/Depth와 header preset을 사용합니다. back·search·title·action은 호스트 콜백과 slot으로 연결하며 긴
 * 제목은 가용 폭 안에서 표시합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 15_figma_navigation.md 항목을
 * 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
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
) {
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val main = type == PleosNavigationType.Main
    val search = type == PleosNavigationType.Search
    require(!search || searchField != null) { "Search에는 편집 상태를 가진 searchField가 필요합니다." }
    Column(modifier) {
        Row(
            Modifier.fillMaxWidth()
                .padding(
                    start = m.dp("page_navigation/padding_extralarge", 40f),
                    end = m.dp("page_navigation/padding_large", 24f),
                )
                .heightIn(
                    min =
                        m.dp(
                            if (search) "fields/text/medium/height"
                            else "page_navigation/container_height",
                            if (search) 100f else 80f,
                        )
                ),
            horizontalArrangement = Arrangement.spacedBy(m.dp("page_navigation/gap_large", 24f)),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement =
                    Arrangement.spacedBy(
                        m.dp(
                            if (main) "page_navigation/gap_medium"
                            else "page_navigation/title/depth_gap_horizontal",
                            if (main) 16f else 24f,
                        )
                    ),
            ) {
                if (!main && onBack != null) {
                    val glyph = m.dp("page_navigation/title/depth_icon_square", 56f)
                    PleosIconButton(
                        "뒤로",
                        onBack,
                        Modifier.size(glyph),
                        style = PleosIconButtonStyle.Plain,
                    ) {
                        PleosIcon(BackIcon, Modifier.fillMaxSize())
                    }
                }
                if (main && appIcon != null)
                    PleosSurface(
                        Modifier.size(m.dp("page_navigation/title/app_icon/container_square", 80f)),
                        radius = m.dp("page_navigation/title/app_icon/radius_top_left", 20f),
                    ) {
                        appIcon()
                    }
                Column(Modifier.weight(1f, false)) {
                    if (search) searchField?.invoke()
                    else if (main && primaryMenu != null) primaryMenu()
                    else
                        PleosText(
                            title,
                            style = pleosTextStyle(40, 52, FontWeight.Bold),
                            maxLines = 1,
                        )
                    subtitle?.let {
                        Spacer(Modifier.height(m.dp("page_navigation/sub_title_gap_vertical", 4f)))
                        PleosText(
                            it,
                            color = c.scoped(.64f, "text/dark/tertiary"),
                            style = pleosTextStyle(if (main) 24 else 26, if (main) 28 else 34),
                            maxLines = 1,
                        )
                    }
                }
                if (main && secondaryMenu != null) {
                    Box(
                        Modifier.width(m.dp("page_navigation/divider_width", 2f))
                            .height(m.dp("page_navigation/divider_height", 32f))
                            .background(c["divider/tertiary"])
                    )
                    secondaryMenu()
                }
            }
            if (actions != null)
                Row(
                    horizontalArrangement =
                        Arrangement.spacedBy(m.dp("page_navigation/gap_samll", 12f)),
                    verticalAlignment = Alignment.CenterVertically,
                    content = actions,
                )
        }
        if (tabs != null) {
            Spacer(Modifier.height(m.dp("page_navigation/gap_samll", 12f)))
            tabs()
        }
        if (divider)
            Box(
                Modifier.fillMaxWidth()
                    .height(m.dp("page_navigation/border_bottom", 1f))
                    .background(c["divider/tertiary"])
            )
    }
}

/**
 * 03 §3 / N01. Main/Depth와 header preset을 사용합니다. back·search·title·action은 호스트 콜백과 slot으로 연결하며 긴
 * 제목은 가용 폭 안에서 표시합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 15_figma_navigation.md 항목을
 * 참조합니다. 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
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
) {
    val segmented =
        preset == PleosHeaderPreset.RadioSegmented || preset == PleosHeaderPreset.PhoneSegmented
    val m = PleosTheme.metrics
    Box(
        modifier.then(
            if (preset != PleosHeaderPreset.Music)
                Modifier.background(PleosTheme.colors["surface/basic"])
            else Modifier
        )
    ) {
        PleosPageNavigation(
            PleosNavigationType.Main,
            title,
            Modifier.padding(
                top = m.dp("page_navigation/padding_extralarge", 40f),
                bottom = if (segmented) 0.dp else m.dp("page_navigation/padding_large", 24f),
            ),
            subtitle,
            appIcon,
            primaryMenu,
            secondaryMenu,
            actions,
            tabs = if (segmented) tabs else null,
        )
        Box(
            Modifier.align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(m.dp("page_navigation/border_bottom", 1f))
                .background(PleosTheme.colors["divider/tertiary"])
        )
    }
}

/** 03 §3·원본 67:27623의 메뉴 버튼입니다. 선택/열림 상태는 호스트가 소유하며 title의 40/52 서체와 28 아이콘을 사용합니다. */
@Composable
fun PleosNavigationMenu(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    enabled: Boolean = true,
    showArrow: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val m = PleosTheme.metrics
    val c = PleosTheme.colors
    val focus = remember { FocusRequester() }
    var wasExpanded by remember { mutableStateOf(expanded) }
    LaunchedEffect(expanded) {
        if (wasExpanded && !expanded) {
            withFrameNanos {}
            runCatching { focus.requestFocus() }
        }
        wasExpanded = expanded
    }
    val pressed by interactionSource.collectIsPressedAsState()
    val radius = m.dp("page_navigation/title/dropdown_menu_pressed/radius_top_left", 16f)
    PleosSurface(
        actionModifier(
            modifier.focusRequester(focus).semantics {
                stateDescription = if (expanded) "펼쳐짐" else "접힘"
            },
            interactionSource,
            enabled,
            radius,
            onClick,
        ),
        if (pressed && enabled) c["button/basic/pressed"]
        else androidx.compose.ui.graphics.Color.Transparent,
        radius,
    ) {
        Row(
            Modifier.padding(
                horizontal = m.dp("page_navigation/padding_medium", 16f),
                vertical = m.dp("page_navigation/padding_small", 8f),
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(m.dp("page_navigation/gap_extrasmall", 8f)),
        ) {
            val foreground = c[if (enabled) "text/dark/primary" else "text/dark/quaternary"]
            PleosText(
                text,
                Modifier.weight(1f, false),
                foreground,
                pleosTextStyle(40, 52, FontWeight.Bold),
                maxLines = 1,
            )
            if (showArrow)
                PleosIcon(
                    if (expanded) R.drawable.pleos_ic_arrow_direction_up__67_22102 else DownIcon,
                    Modifier.size(m.dp("page_navigation/title/dropdown_icon_square", 28f)),
                    tint = foreground,
                )
        }
    }
}

/** 03 §3·원본 Search 67:27652. 편집 값과 IME 검색·뒤로·닫기 요청을 호스트가 소유합니다. */
@Composable
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
) {
    PleosPageNavigation(
        PleosNavigationType.Search,
        "",
        modifier,
        onBack = onBack,
        searchField = {
            PleosTextField(
                value,
                onValueChange,
                fieldModifier.fillMaxWidth(),
                enabled = enabled,
                placeholder = placeholder,
                imeAction = ImeAction.Search,
                keyboardActions = KeyboardActions(onSearch = { if (enabled) onSearch() }),
            )
        },
        actions = {
            PleosIconButton(
                "검색 닫기",
                onClose,
                enabled = enabled,
                style = PleosIconButtonStyle.Plain,
            ) {
                PleosIcon(CloseIcon, Modifier.fillMaxSize())
            }
        },
    )
}

/** N01 메뉴의 40/52 서체와 Dropdown의 선택·Switch·dismiss·focus 복구를 함께 제공합니다. */
@Composable
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
) {
    PleosDropdown(
        expanded,
        onExpandedChange,
        items,
        selectedId,
        onItemSelected,
        modifier,
        enabled = enabled,
        placeholder = placeholder,
        onDismissRequest = onDismissRequest,
        preferredWidth = null,
        triggerContent = { triggerModifier, opened, toggle ->
            PleosNavigationMenu(
                items.firstOrNull { it.key == selectedId }?.text ?: placeholder,
                toggle,
                triggerModifier,
                expanded = opened,
                enabled = enabled,
            )
        },
    )
}
