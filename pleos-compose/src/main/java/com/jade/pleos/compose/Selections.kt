package com.jade.pleos.compose

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.*
import androidx.compose.foundation.shape.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.semantics.*
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.*
import com.jade.pleos.tokens.*

enum class PleosSwitchSize {
    Medium,
    Small,
}

/**
 * 03 §7~9 / S01~S03. 선택 상태는 외부 값을 따릅니다. Mixed의 다음 값은 호스트가 정합니다. RadioGroup의 key는 유일해야 하며 disabled는
 * 모든 입력을 차단합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 18_figma_selections.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosCheckbox(
    state: ToggleableState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val pressed by interactionSource.collectIsPressedAsState()
    val root = m.dp("selections/container_large", 64f)
    val visual = m.dp("selections/container_medium", 48f)
    val r = m.dp("selections/checkbox/radius_top_left", 12f)
    val on = state != ToggleableState.Off
    val fill =
        if (on) c[if (enabled) "switch/on" else "switch/disabled"]
        else if (!enabled) c["dim/dark/primary"]
        else if (pressed) c["dim/dark/secondary"] else Color.Transparent
    Box(
        modifier
            .size(root)
            .focusIndication(interactionSource, r)
            .triStateToggleable(state, interactionSource, null, enabled, Role.Checkbox, onClick),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            Modifier.size(visual)
                .clip(RoundedCornerShape(r))
                .background(fill)
                .then(
                    if (!on)
                        Modifier.border(
                            m.dp("selections/checkbox/normal_button_border", 4f),
                            c[if (enabled) "divider/tertiary" else "divider/secondary"],
                            RoundedCornerShape(r),
                        )
                    else Modifier
                ),
            contentAlignment = Alignment.Center,
        ) {
            if (on && pressed && enabled)
                Box(Modifier.matchParentSize().background(c["dim/dark/secondary"]))
            if (on)
                PleosIcon(
                    if (state == ToggleableState.Indeterminate) MinusIcon else CheckIcon,
                    Modifier.size(m.dp("selections/checkbox/mark_square", 44f)),
                    tint = Color.White.copy(alpha = if (enabled) 1f else .64f),
                )
        }
    }
}

/**
 * 03 §7~9 / S01~S03. 선택 상태는 외부 값을 따릅니다. Mixed의 다음 값은 호스트가 정합니다. RadioGroup의 key는 유일해야 하며 disabled는
 * 모든 입력을 차단합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 18_figma_selections.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) =
    PleosCheckbox(
        if (checked) ToggleableState.On else ToggleableState.Off,
        { onCheckedChange(!checked) },
        modifier,
        enabled,
    )

/**
 * 03 §7~9 / S01~S03. 선택 상태는 외부 값을 따릅니다. Mixed의 다음 값은 호스트가 정합니다. RadioGroup의 key는 유일해야 하며 disabled는
 * 모든 입력을 차단합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 18_figma_selections.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    invalid: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val pressed by interactionSource.collectIsPressedAsState()
    Box(
        modifier
            .size(PleosTheme.metrics.dp("selections/container_large", 64f))
            .focusIndication(interactionSource, 32.dp)
            .selectable(selected, interactionSource, null, enabled, Role.RadioButton, onClick)
            .semantics { invalid?.let { error(it) } },
        contentAlignment = Alignment.Center,
    ) {
        RadioVisual(selected, enabled, pressed)
    }
}

@Composable
private fun RadioVisual(selected: Boolean, enabled: Boolean, pressed: Boolean = false) {
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val fill =
        if (selected) c[if (enabled) "switch/knob_on" else "switch/knob_disabled"]
        else if (!enabled) c["dim/dark/primary"]
        else if (pressed) c["dim/dark/secondary"] else Color.Transparent
    val border =
        if (selected) c[if (enabled) "informative/active" else "switch/disabled"]
        else c[if (enabled) "divider/tertiary" else "divider/primary"]
    Box(
        Modifier.size(m.dp("selections/container_medium", 48f))
            .clip(CircleShape)
            .background(fill)
            .border(
                if (selected) m.dp("selections/border_large", 12f)
                else m.dp("selections/border_small", 4f),
                if (selected && pressed && enabled) c["dim/dark/secondary"].compositeOver(border)
                else border,
                CircleShape,
            )
    ) {}
}

data class PleosRadioOption<T>(val key: T, val label: String, val enabled: Boolean = true)

/**
 * 03 §7~9 / S01~S03. 선택 상태는 외부 값을 따릅니다. Mixed의 다음 값은 호스트가 정합니다. RadioGroup의 key는 유일해야 하며 disabled는
 * 모든 입력을 차단합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 18_figma_selections.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun <T> PleosRadioGroup(
    options: List<PleosRadioOption<T>>,
    selectedKey: T?,
    onSelected: (T) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    invalid: String? = null,
) {
    require(options.map { it.key }.distinct().size == options.size)
    Column(modifier.selectableGroup().semantics { invalid?.let { error(it) } }) {
        options.forEach { item ->
            key(item.key) {
                val source = remember { MutableInteractionSource() }
                val pressed by source.collectIsPressedAsState()
                Row(
                    Modifier.fillMaxWidth().focusIndication(source, 12.dp).selectable(
                        item.key == selectedKey,
                        source,
                        null,
                        enabled && item.enabled,
                        Role.RadioButton,
                    ) {
                        onSelected(item.key)
                    },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    // 자식의 독립 action을 제거하여 행당 단 하나의 선택 노드만 제공합니다.
                    Box(
                        Modifier.size(PleosTheme.metrics.dp("selections/container_large", 64f)),
                        contentAlignment = Alignment.Center,
                    ) {
                        RadioVisual(item.key == selectedKey, enabled && item.enabled, pressed)
                    }
                    PleosText(
                        item.label,
                        color =
                            PleosTheme.colors[
                                    if (enabled && item.enabled) "text/dark/primary"
                                    else "text/dark/quaternary"],
                    )
                }
            }
        }
    }
}

/**
 * 03 §7~9 / S01~S03. 선택 상태는 외부 값을 따릅니다. Mixed의 다음 값은 호스트가 정합니다. RadioGroup의 key는 유일해야 하며 disabled는
 * 모든 입력을 차단합니다. 원본 노드·binding 식별자는 tools/spec_inventory.json의 18_figma_selections.md 항목을 참조합니다.
 * 기본값·유효 타입은 선언의 인자를 따르며, 값 변경 콜백은 호스트에 대한 요청입니다.
 */
@Composable
fun PleosSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: PleosSwitchSize = PleosSwitchSize.Medium,
    invalid: String? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val pressed by interactionSource.collectIsPressedAsState()
    Box(
        modifier
            .sizeIn(
                minWidth = PleosTheme.behavior.minimumTouchTarget,
                minHeight = PleosTheme.behavior.minimumTouchTarget,
            )
            .focusIndication(interactionSource, 16.dp)
            .toggleable(checked, interactionSource, null, enabled, Role.Switch, onCheckedChange)
            .semantics { invalid?.let { error(it) } },
        contentAlignment = Alignment.Center,
    ) {
        SwitchVisual(checked, enabled, pressed, size)
    }
}

@Composable
internal fun SwitchVisual(
    checked: Boolean,
    enabled: Boolean,
    pressed: Boolean,
    size: PleosSwitchSize,
) {
    val small = size == PleosSwitchSize.Small
    val c = PleosTheme.colors
    val m = PleosTheme.metrics
    val p = "selections/switch/${size.name.lowercase()}/"
    val w = m.dp(p + "width", if (small) 64f else 80f)
    val h =
        m.dp(p + "knob_square", if (small) 28f else 32f) +
            m.dp(p + "padding", if (small) 6f else 8f) * 2
    val pad = m.dp(p + "padding", if (small) 6f else 8f)
    val knob = m.dp(p + "knob_square", if (small) 28f else 32f)
    val radius = m.dp(p + "radius_top_left", if (small) 12f else 16f)
    Box(
        Modifier.size(w, h)
            .clip(RoundedCornerShape(radius))
            .background(
                c[if (!enabled) "switch/disabled" else if (checked) "switch/on" else "switch/off"]
            )
    ) {
        if (pressed && enabled) Box(Modifier.matchParentSize().background(c["dim/dark/secondary"]))
        Box(
            Modifier.align(if (checked) Alignment.CenterEnd else Alignment.CenterStart)
                .padding(horizontal = pad)
                .size(knob)
                .clip(RoundedCornerShape(m.dp(p + "knob_radius_top_left", 8f)))
                .background(
                    c[
                        if (!enabled) "switch/knob_disabled"
                        else if (checked) "switch/knob_on" else "switch/knob_off"]
                )
        )
    }
}
