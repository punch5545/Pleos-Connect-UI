package com.jade.pleos.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.*
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.*
import androidx.compose.ui.semantics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.*
import com.jade.pleos.tokens.*

enum class PleosDropdownSize {
    Medium,
    Small,
}

sealed interface PleosDropdownItemKind {
    data object Selection : PleosDropdownItemKind

    data class Action(val onClick: () -> Unit) : PleosDropdownItemKind

    data class Switch(val checked: Boolean, val onCheckedChange: (Boolean) -> Unit) :
        PleosDropdownItemKind

    data class Footer(val onClick: () -> Unit) : PleosDropdownItemKind
}

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

private fun windowOriginOnScreen(view: android.view.View): androidx.compose.ui.geometry.Offset {
    val screen = IntArray(2)
    val window = IntArray(2)
    view.getLocationOnScreen(screen)
    view.getLocationInWindow(window)
    return androidx.compose.ui.geometry.Offset(
        (screen[0] - window[0]).toFloat(),
        (screen[1] - window[1]).toFloat(),
    )
}

internal class PleosDropdownPositionProvider(
    private val gap: Int,
    private val margin: Int,
    private val safeLeft: Int = 0,
    private val safeTop: Int = 0,
    private val safeRight: Int = 0,
    private val safeBottom: Int = 0,
) : PopupPositionProvider {
    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize,
    ): IntOffset {
        val left = margin + safeLeft
        val top = margin + safeTop
        val maxX =
            (windowSize.width - popupContentSize.width - margin - safeRight).coerceAtLeast(left)
        val x =
            (if (layoutDirection == LayoutDirection.Ltr) anchorBounds.left
                else anchorBounds.right - popupContentSize.width)
                .coerceIn(left, maxX)
        val below = anchorBounds.bottom + gap
        val y =
            if (below + popupContentSize.height <= windowSize.height - margin - safeBottom) below
            else (anchorBounds.top - gap - popupContentSize.height).coerceAtLeast(top)
        return IntOffset(
            x,
            y.coerceAtMost(
                (windowSize.height - popupContentSize.height - margin - safeBottom).coerceAtLeast(
                    top
                )
            ),
        )
    }
}

/**
 * 02 §10 / D01. item key는 유일해야 합니다. selectedId가 없거나 무효이면 선택 표시가 없습니다. 일반 선택·Action·Footer는 기본 닫힘,
 * Switch는 유지합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 13_figma_dropdown.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosDropdownItem(
    entry: PleosDropdownEntry,
    onSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    size: PleosDropdownSize = PleosDropdownSize.Medium,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val small = size == PleosDropdownSize.Small
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val source = interactionSource
    val pressed by source.collectIsPressedAsState()
    val footer = entry.kind is PleosDropdownItemKind.Footer
    val radius = m.dp("dropdown/${size.name.lowercase()}/radius_top_left", if (small) 28f else 32f)
    val inset =
        m.dp(
            if (small) "dropdown/padding_medium" else "dropdown/padding_large",
            if (small) 16f else 20f,
        )
    val prefixSize = m.dp("dropdown/prefix/container_square", 56f)
    val suffixSize = m.dp("dropdown/suffix/icon_square", 48f)
    fun activate() {
        when (val kind = entry.kind) {
            PleosDropdownItemKind.Selection -> onSelected(entry.key)
            is PleosDropdownItemKind.Action -> kind.onClick()
            is PleosDropdownItemKind.Switch -> kind.onCheckedChange(!kind.checked)
            is PleosDropdownItemKind.Footer -> kind.onClick()
        }
    }
    Column(modifier) {
        if (footer) {
            Box(
                Modifier.fillMaxWidth()
                    .padding(horizontal = inset)
                    .height(1.dp)
                    .background(c["divider/tertiary"])
            )
            Spacer(Modifier.height(m.dp("dropdown/gap_vertical_medium", 16f)))
        }
        val base =
            Modifier.fillMaxWidth()
                .heightIn(
                    min =
                        if (footer)
                            m.dp(
                                if (small) "buttons/icon/small/height"
                                else "buttons/icon/medium/height",
                                if (small) 64f else 80f,
                            )
                        else
                            m.dp(
                                "dropdown/${size.name.lowercase()}/height",
                                if (small) 80f else 100f,
                            )
                )
                .semantics {
                    if (entry.kind == PleosDropdownItemKind.Selection) this.selected = selected
                    if (entry.kind is PleosDropdownItemKind.Switch)
                        stateDescription = if (entry.kind.checked) "켜짐" else "꺼짐"
                }
        val switchKind = entry.kind as? PleosDropdownItemKind.Switch
        val input =
            if (switchKind != null)
                base
                    .focusIndication(source, radius)
                    .toggleable(
                        switchKind.checked,
                        source,
                        null,
                        entry.enabled,
                        Role.Switch,
                        switchKind.onCheckedChange,
                    )
            else actionModifier(base, source, entry.enabled, radius, ::activate)
        PleosSurface(
            input,
            if (selected && !footer) c["dim/dark/primary"]
            else androidx.compose.ui.graphics.Color.Transparent,
            radius,
        ) {
            CompositionLocalProvider(
                LocalPleosContentColor provides
                    c[if (entry.enabled) "text/dark/primary" else "text/dark/quaternary"]
            ) {
                Row(
                    Modifier.padding(horizontal = inset, vertical = if (footer) 0.dp else 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    when {
                        footer -> {
                            PleosSurface(
                                Modifier.size(
                                    m.dp(
                                        if (small) "buttons/icon/small/width"
                                        else "buttons/icon/medium/width",
                                        if (small) 64f else 80f,
                                    )
                                ),
                                c["button/basic/enabled"],
                                999.dp,
                            ) {
                                PleosIcon(
                                    PlusIcon,
                                    Modifier.size(if (small) 32.dp else 40.dp)
                                        .align(Alignment.Center),
                                )
                            }
                            Spacer(Modifier.width(m.dp("dropdown/padding_large", 20f)))
                        }
                        entry.prefix != null -> {
                            Box(Modifier.size(prefixSize), contentAlignment = Alignment.Center) {
                                if (entry.appIcon)
                                    PleosSurface(
                                        Modifier.fillMaxSize(),
                                        Color.Transparent,
                                        m.dp("dropdown/prefix/app_radius_top_left", 16f),
                                        c["divider/secondary"],
                                        m.dp("dropdown/container/prefix_app_icon_border", 1f),
                                    ) {
                                        Box(
                                            Modifier.padding(
                                                    m.dp(
                                                        "dropdown/medium/prefix/padding_horizontal",
                                                        4f,
                                                    )
                                                )
                                                .fillMaxSize()
                                                .clip(
                                                    RoundedCornerShape(
                                                        m.dp(
                                                            "dropdown/prefix/medium/app_icon_radius_top_left",
                                                            12f,
                                                        )
                                                    )
                                                )
                                        ) {
                                            entry.prefix.invoke()
                                        }
                                    }
                                else
                                    Box(
                                        Modifier.size(
                                            m.dp("dropdown/medium/prefix/icon_square", 40f)
                                        ),
                                        contentAlignment = Alignment.Center,
                                    ) {
                                        entry.prefix.invoke()
                                    }
                            }
                        }
                    }
                    PleosText(
                        entry.text,
                        Modifier.weight(1f)
                            .padding(
                                horizontal =
                                    if (footer) 0.dp else m.dp("dropdown/padding_small", 12f)
                            ),
                        style = pleosTextStyle(30, 38, FontWeight.Bold),
                        maxLines = 2,
                    )
                    if (entry.isNew) {
                        Box(
                            Modifier.size(m.dp("dropdown/suffix/dot_icon_square", 16f))
                                .background(
                                    c["informative/active"],
                                    androidx.compose.foundation.shape.CircleShape,
                                )
                        )
                        Spacer(Modifier.width(m.dp("dropdown/padding_small", 12f)))
                    }
                    val switch = entry.kind as? PleosDropdownItemKind.Switch
                    when {
                        switch != null ->
                            SwitchVisual(
                                switch.checked,
                                entry.enabled,
                                pressed && entry.enabled,
                                PleosSwitchSize.Small,
                            )
                        entry.suffix != null ->
                            Box(Modifier.size(suffixSize), contentAlignment = Alignment.Center) {
                                entry.suffix.invoke()
                            }
                        selected -> PleosIcon(CheckIcon, Modifier.size(suffixSize))
                    }
                }
            }
        }
    }
}

/**
 * 02 §10 / D01. item key는 유일해야 합니다. selectedId가 없거나 무효이면 선택 표시가 없습니다. 일반 선택·Action·Footer는 기본 닫힘,
 * Switch는 유지합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 13_figma_dropdown.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosDropdownMenu(
    items: List<PleosDropdownEntry>,
    selectedId: String?,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    size: PleosDropdownSize = PleosDropdownSize.Medium,
    initialFocusRequester: FocusRequester? = null,
) {
    require(items.map { it.key }.distinct().size == items.size)
    val firstKey = items.firstOrNull { it.enabled }?.key
    LaunchedEffect(initialFocusRequester, firstKey) {
        if (firstKey != null && initialFocusRequester != null) {
            withFrameNanos {}
            runCatching { initialFocusRequester.requestFocus() }
        }
    }
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    PleosSurface(
        modifier,
        c["surface/basic"],
        m.dp(
            "dropdown/${size.name.lowercase()}/radius_top_left",
            if (size == PleosDropdownSize.Small) 28f else 32f,
        ),
        c["divider/secondary"],
        m.dp("dropdown/border", 2f),
        1,
    ) {
        Column(
            Modifier.verticalScroll(rememberScrollState())
                .padding(m.dp("dropdown/padding_medium", 16f)),
            verticalArrangement = Arrangement.spacedBy(m.dp("dropdown/gap_vertical_medium", 16f)),
        ) {
            items.forEach { item ->
                key(item.key) {
                    PleosDropdownItem(
                        item,
                        onItemSelected,
                        modifier =
                            if (item.key == firstKey && initialFocusRequester != null)
                                Modifier.focusRequester(initialFocusRequester)
                            else Modifier,
                        selected = item.key == selectedId,
                        size = size,
                    )
                }
            }
        }
    }
}

/**
 * 02 §10 / D01. item key는 유일해야 합니다. selectedId가 없거나 무효이면 선택 표시가 없습니다. 일반 선택·Action·Footer는 기본 닫힘,
 * Switch는 유지합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 13_figma_dropdown.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
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
) {
    require(preferredWidth == null || preferredWidth.value.isFinite() && preferredWidth > 0.dp)
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val small = size == PleosDropdownSize.Small
    val anchor = remember { FocusRequester() }
    val source = remember { MutableInteractionSource() }
    val pressed by source.collectIsPressedAsState()
    val hostView = LocalView.current
    val density = LocalDensity.current
    val window = LocalWindowInfo.current.containerSize
    val w = with(density) { window.width.toDp() }
    val h = with(density) { window.height.toDp() }
    val menuFocus = remember { FocusRequester() }
    var anchorBounds by remember { mutableStateOf(Rect.Zero) }
    var menuBounds by remember { mutableStateOf(Rect.Zero) }
    var menuSize by remember { mutableStateOf(IntSize.Zero) }
    var dialogSize by remember { mutableStateOf(window) }
    var dialogOrigin by remember { mutableStateOf(androidx.compose.ui.geometry.Offset.Zero) }
    var wasOpen by remember { mutableStateOf(false) }
    LaunchedEffect(expanded, enabled) {
        if (!expanded && wasOpen) runCatching { anchor.requestFocus() }
        wasOpen = expanded && enabled
    }
    fun dismiss(reason: PleosDismissReason) {
        onExpandedChange(false)
        onDismissRequest?.invoke(reason)
    }
    LaunchedEffect(enabled, expanded) {
        if (!enabled && expanded) dismiss(PleosDismissReason.Replaced)
    }
    Box(
        modifier
            .then(if (preferredWidth != null) Modifier.width(preferredWidth) else Modifier)
            .onGloballyPositioned {
                anchorBounds = it.boundsInWindow().translate(windowOriginOnScreen(hostView))
            }
    ) {
        if (triggerContent != null)
            triggerContent(Modifier.focusRequester(anchor), expanded && enabled) {
                if (enabled) onExpandedChange(!expanded)
            }
        else
            PleosSurface(
                actionModifier(
                    Modifier.fillMaxWidth()
                        .defaultMinSize(
                            minHeight =
                                m.dp(
                                    "dropdown/${size.name.lowercase()}/height",
                                    if (small) 80f else 100f,
                                )
                        )
                        .focusRequester(anchor)
                        .semantics {
                            stateDescription = if (expanded && enabled) "펼쳐짐" else "접힘"
                            if (enabled) {
                                expand {
                                    onExpandedChange(true)
                                    true
                                }
                                collapse {
                                    onExpandedChange(false)
                                    true
                                }
                            }
                        },
                    source,
                    enabled,
                    m.dp(
                        "dropdown/${size.name.lowercase()}/radius_top_left",
                        if (small) 28f else 32f,
                    ),
                    { onExpandedChange(!expanded) },
                ),
                c[if (pressed) "dropdown/pressed" else "dropdown/normal"],
                m.dp("dropdown/${size.name.lowercase()}/radius_top_left", if (small) 28f else 32f),
                c["divider/secondary"],
                m.dp("dropdown/border", 2f),
                1,
            ) {
                CompositionLocalProvider(
                    LocalPleosContentColor provides
                        c[if (enabled) "text/dark/primary" else "text/dark/quaternary"]
                ) {
                    Row(
                        Modifier.padding(
                            horizontal =
                                m.dp(
                                    if (small) "dropdown/padding_medium"
                                    else "dropdown/padding_large",
                                    if (small) 16f else 20f,
                                ),
                            vertical = 16.dp,
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        prefix?.let {
                            Box(
                                Modifier.size(m.dp("dropdown/prefix/container_square", 56f)),
                                contentAlignment = Alignment.Center,
                            ) {
                                it()
                            }
                        }
                        PleosText(
                            items.firstOrNull { it.key == selectedId }?.text ?: placeholder,
                            Modifier.weight(1f)
                                .padding(
                                    horizontal =
                                        m.dp(
                                            if (small) "dropdown/padding_small"
                                            else "dropdown/padding_medium",
                                            if (small) 12f else 16f,
                                        )
                                ),
                            style = pleosTextStyle(30, 38, FontWeight.Bold),
                            maxLines = 2,
                        )
                        Box(
                            Modifier.size(m.dp("dropdown/suffix/icon_square", 48f)),
                            contentAlignment = Alignment.Center,
                        ) {
                            if (suffix != null) suffix()
                            else
                                PleosIcon(
                                    if (expanded) R.drawable.pleos_ic_arrow_direction_up__67_22102
                                    else DownIcon,
                                    Modifier.fillMaxSize(),
                                )
                        }
                    }
                }
            }
        if (expanded && enabled && anchorBounds.width > 0 && anchorBounds.height > 0)
            Dialog(
                onDismissRequest = { dismiss(PleosDismissReason.Back) },
                properties =
                    DialogProperties(
                        dismissOnBackPress = true,
                        dismissOnClickOutside = false,
                        usePlatformDefaultWidth = false,
                        decorFitsSystemWindows = false,
                    ),
            ) {
                val dialogView = LocalView.current
                SideEffect {
                    (dialogView.parent as? DialogWindowProvider)?.window?.setDimAmount(0f)
                }
                val direction = LocalLayoutDirection.current
                val safe = WindowInsets.safeDrawing.union(WindowInsets.ime)
                val safeLeft = safe.getLeft(density, direction)
                val safeRight = safe.getRight(density, direction)
                val safeTop = safe.getTop(density)
                val safeBottom = safe.getBottom(density)
                val localAnchor = anchorBounds.translate(-dialogOrigin)
                val dialogWidth = with(density) { dialogSize.width.toDp() }
                val dialogHeight = with(density) { dialogSize.height.toDp() }
                val position =
                    PleosDropdownPositionProvider(
                            with(density) { m.dp("dropdown/gap_vertical_small", 8f).roundToPx() },
                            with(density) { 24.dp.roundToPx() },
                            safeLeft,
                            safeTop,
                            safeRight,
                            safeBottom,
                        )
                        .calculatePosition(
                            IntRect(
                                localAnchor.left.toInt(),
                                localAnchor.top.toInt(),
                                localAnchor.right.toInt(),
                                localAnchor.bottom.toInt(),
                            ),
                            dialogSize,
                            direction,
                            menuSize,
                        )
                Box(
                    Modifier.fillMaxSize()
                        .onGloballyPositioned {
                            dialogSize = it.size
                            dialogOrigin = windowOriginOnScreen(dialogView) + it.positionInWindow()
                        }
                        .pointerInput(Unit) {
                            detectTapGestures {
                                if (!menuBounds.contains(it)) dismiss(PleosDismissReason.Outside)
                            }
                        },
                    contentAlignment = AbsoluteAlignment.TopLeft,
                ) {
                    val visibleItems =
                        items.map { entry ->
                            when (val kind = entry.kind) {
                                is PleosDropdownItemKind.Action ->
                                    entry.copy(
                                        kind =
                                            PleosDropdownItemKind.Action {
                                                kind.onClick()
                                                if (dismissAfterSelection)
                                                    dismiss(PleosDismissReason.Action(entry.key))
                                            }
                                    )
                                is PleosDropdownItemKind.Footer ->
                                    entry.copy(
                                        kind =
                                            PleosDropdownItemKind.Footer {
                                                kind.onClick()
                                                if (dismissAfterSelection)
                                                    dismiss(PleosDismissReason.Action(entry.key))
                                            }
                                    )
                                else -> entry
                            }
                        }
                    PleosDropdownMenu(
                        visibleItems,
                        selectedId,
                        { key ->
                            onItemSelected(key)
                            if (dismissAfterSelection) dismiss(PleosDismissReason.Action(key))
                        },
                        Modifier.absoluteOffset { position }
                            .width(
                                minOf(
                                    with(density) { anchorBounds.width.toDp() },
                                    (dialogWidth -
                                            48.dp -
                                            with(density) { (safeLeft + safeRight).toDp() })
                                        .coerceAtLeast(0.dp),
                                )
                            )
                            .onSizeChanged { menuSize = it }
                            .onGloballyPositioned { menuBounds = it.boundsInParent() }
                            .heightIn(
                                max =
                                    (dialogHeight -
                                            48.dp -
                                            with(density) { (safeTop + safeBottom).toDp() })
                                        .coerceAtLeast(48.dp)
                            )
                            .onPreviewKeyEvent { event ->
                                if (event.key == Key.Back || event.key == Key.Escape) {
                                    if (event.type == KeyEventType.KeyUp)
                                        dismiss(PleosDismissReason.Back)
                                    true
                                } else false
                            },
                        size,
                        initialFocusRequester = menuFocus,
                    )
                }
            }
    }
}
