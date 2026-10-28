# Figma assets — 컴포넌트 및 하위 레이어 해석 부록

> **원본 부록:** 웹과 다른 옛 값은 이력이다. 최신 구현은 01·02·03·08번의 웹 최종값을 적용한다. 원본 snapshot 색을 새 웹 token 위에 다시 덮지 않는다.

원본 SYMBOL의 레이어 및 INSTANCE의 master 기본값, symbolOverrides, derivedSymbolData, componentPropAssignments를 병합한 오프라인 참조이다. 모든 치수는 원본 design unit이며 root xy는 디자인 보드상 위치이므로 런타임 위치로 복사하지 않는다. child xy는 부모 상대 좌표이다. r 순서는 TL/TR/BR/BL, padding 순서는 L/T/R/B이다.

fill/stroke의 HEX는 `#RRGGBBAA`이며 원본 color alpha×paint.opacity를 합성한 스냅샷 값이다. theme 동작에는 별도 전체 토큰 표와 웹 기준 충돌 해결 규칙을 적용한다. 노드 opacity는 별도로 표시한다. `hidden`은 예제에서 꺼진 옵션이며 구현에서 삭제하라는 뜻이 아니다. master의 드롭다운/토글/Label 등 공개 property도 구현 대상이다.

이 표는 바이너리 파싱 없이 geometry/style/variant를 참조하도록 만든다. Figma 렌더러 전체를 재구현한 것은 아니므로 boolean geometry·clip·특수 효과의 pixel 일치는 SVG 및 원본 guide와 검증한다. 외부 master 누락은 마지막 해석 결과에 별도로 남긴다.


## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_checkbox/Active=False, State=Enabled

- 원본 node: `67:33571`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=False, State=Enabled | 67:33571 | SYMBOL | size=64×64; xy=20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=False, State=Enabled/Box | 67:33572 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stroke=divider/tertiary=#13141733; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/checkbox/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/checkbox/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/checkbox/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/checkbox/radius_bottom_right,BORDER_TOP_WEIGHT→selections/checkbox/normal_button_border,BORDER_BOTTOM_WEIGHT→selections/checkbox/normal_button_border,BORDER_LEFT_WEIGHT→selections/checkbox/normal_button_border,BORDER_RIGHT_WEIGHT→selections/checkbox/normal_button_border |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_checkbox/Active=False, State=Pressed

- 원본 node: `67:33573`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=False, State=Pressed | 67:33573 | SYMBOL | size=64×64; xy=104,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=False, State=Pressed/Box | 67:33574 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=dim/dark/secondary=#1314171A; stroke=divider/tertiary=#13141733; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/checkbox/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/checkbox/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/checkbox/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/checkbox/radius_bottom_right,BORDER_TOP_WEIGHT→selections/checkbox/normal_button_border,BORDER_BOTTOM_WEIGHT→selections/checkbox/normal_button_border,BORDER_LEFT_WEIGHT→selections/checkbox/normal_button_border,BORDER_RIGHT_WEIGHT→selections/checkbox/normal_button_border |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_checkbox/Active=False, State=Disabled

- 원본 node: `67:33575`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=False, State=Disabled | 67:33575 | SYMBOL | size=64×64; xy=188,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=False, State=Disabled/Box | 67:33576 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=dim/dark/primary=#1314170D; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/checkbox/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/checkbox/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/checkbox/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/checkbox/radius_bottom_right,BORDER_TOP_WEIGHT→selections/checkbox/normal_button_border,BORDER_BOTTOM_WEIGHT→selections/checkbox/normal_button_border,BORDER_LEFT_WEIGHT→selections/checkbox/normal_button_border,BORDER_RIGHT_WEIGHT→selections/checkbox/normal_button_border |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_checkbox/Active=True, State=Enabled

- 원본 node: `67:33577`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=True, State=Enabled | 67:33577 | SYMBOL | size=64×64; xy=20,104; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=True, State=Enabled/Box | 67:33578 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=switch/on=#02C265FF; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/checkbox/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/checkbox/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/checkbox/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/checkbox/radius_bottom_right |
| Active=True, State=Enabled/Box/ic_check | 67:33579 → 67:25618 | INSTANCE | size=44×44; xy=2,2 |
| Active=True, State=Enabled/Box/ic_check/Path | 67:25619 | VECTOR | size=27.0417×17.4167; xy=9.1667,13.75; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Active=True, State=Enabled/Box/ic_check/Icon | 67:25620 | VECTOR | size=30.3417×20.7167; xy=7.5167,12.1; fill=static/light/100=#FFFFFFFF |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_checkbox/Active=True, State=Pressed

- 원본 node: `67:33580`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=True, State=Pressed | 67:33580 | SYMBOL | size=64×64; xy=104,104; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=True, State=Pressed/Box | 67:33581 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=switch/on=#02C265FF,dim/dark/secondary=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/checkbox/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/checkbox/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/checkbox/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/checkbox/radius_bottom_right |
| Active=True, State=Pressed/Box/ic_check | 67:33582 → 67:25618 | INSTANCE | size=44×44; xy=2,2 |
| Active=True, State=Pressed/Box/ic_check/Path | 67:25619 | VECTOR | size=27.0417×17.4167; xy=9.1667,13.75; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Active=True, State=Pressed/Box/ic_check/Icon | 67:25620 | VECTOR | size=30.3417×20.7167; xy=7.5167,12.1; fill=static/light/100=#FFFFFFFF |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_checkbox/Active=True, State=Disabled

- 원본 node: `67:33583`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=True, State=Disabled | 67:33583 | SYMBOL | size=64×64; xy=188,104; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=True, State=Disabled/Box | 67:33584 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=switch/disabled=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/checkbox/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/checkbox/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/checkbox/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/checkbox/radius_bottom_right |
| Active=True, State=Disabled/Box/ic_check | 67:33585 → 67:25618 | INSTANCE | size=44×44; xy=2,2 |
| Active=True, State=Disabled/Box/ic_check/Path | 67:25619 | VECTOR | size=27.0417×17.4167; xy=9.1667,13.75; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Active=True, State=Disabled/Box/ic_check/Icon | 67:25620 | VECTOR | size=30.3417×20.7167; xy=7.5167,12.1; fill=static/light/300=#FFFFFFA3 |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_checkbox/Active=Indeterminate, State=Enabled

- 원본 node: `67:33586`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=Indeterminate, State=Enabled | 67:33586 | SYMBOL | size=64×64; xy=20,188; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=Indeterminate, State=Enabled/Box | 67:33587 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=switch/on=#02C265FF; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/checkbox/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/checkbox/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/checkbox/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/checkbox/radius_bottom_right |
| Active=Indeterminate, State=Enabled/Box/ic_minus | 67:33588 → 67:25150 | INSTANCE | size=44×44; xy=2,2 |
| Active=Indeterminate, State=Enabled/Box/ic_minus/Path | 67:25151 | VECTOR | size=27.5×0; xy=8.25,22; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Active=Indeterminate, State=Enabled/Box/ic_minus/Icon | 67:25152 | VECTOR | size=30.8×3.3; xy=6.6,20.35; fill=static/light/100=#FFFFFFFF |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_checkbox/Active=Indeterminate, State=Pressed

- 원본 node: `67:33589`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=Indeterminate, State=Pressed | 67:33589 | SYMBOL | size=64×64; xy=104,188; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=Indeterminate, State=Pressed/Box | 67:33590 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=switch/on=#02C265FF,dim/dark/secondary=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/checkbox/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/checkbox/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/checkbox/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/checkbox/radius_bottom_right |
| Active=Indeterminate, State=Pressed/Box/ic_minus | 67:33591 → 67:25150 | INSTANCE | size=44×44; xy=2,2 |
| Active=Indeterminate, State=Pressed/Box/ic_minus/Path | 67:25151 | VECTOR | size=27.5×0; xy=8.25,22; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Active=Indeterminate, State=Pressed/Box/ic_minus/Icon | 67:25152 | VECTOR | size=30.8×3.3; xy=6.6,20.35; fill=static/light/100=#FFFFFFFF |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_checkbox/Active=Indeterminate, State=Disabled

- 원본 node: `67:33592`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=Indeterminate, State=Disabled | 67:33592 | SYMBOL | size=64×64; xy=188,188; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=Indeterminate, State=Disabled/Box | 67:33593 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=switch/disabled=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/checkbox/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/checkbox/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/checkbox/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/checkbox/radius_bottom_right |
| Active=Indeterminate, State=Disabled/Box/ic_minus | 67:33594 → 67:25150 | INSTANCE | size=44×44; xy=2,2 |
| Active=Indeterminate, State=Disabled/Box/ic_minus/Path | 67:25151 | VECTOR | size=27.5×0; xy=8.25,22; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Active=Indeterminate, State=Disabled/Box/ic_minus/Icon | 67:25152 | VECTOR | size=30.8×3.3; xy=6.6,20.35; fill=static/light/300=#FFFFFFA3 |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_radio_button/Active=true, State=Enabled

- 원본 node: `67:33598`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=true, State=Enabled | 67:33598 | SYMBOL | size=64×64; xy=20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=true, State=Enabled/radio | 67:33599 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=switch/knob_on=#FFFFFFFF; stroke=informative/active=#02C265FF; strokeWidth=12/INSIDE; edgeStroke(T,R,B,L)=12,12,12,12; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/circle,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/circle,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/circle,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/circle,BORDER_TOP_WEIGHT→selections/border_large,BORDER_BOTTOM_WEIGHT→selections/border_large,BORDER_LEFT_WEIGHT→selections/border_large,BORDER_RIGHT_WEIGHT→selections/border_large |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_radio_button/Active=true, State=Pressed

- 원본 node: `67:33600`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=true, State=Pressed | 67:33600 | SYMBOL | size=64×64; xy=104,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=true, State=Pressed/radio | 67:33601 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=switch/knob_on=#FFFFFFFF; stroke=informative/active=#02C265FF,dim/dark/secondary=#1314171A; strokeWidth=12/INSIDE; edgeStroke(T,R,B,L)=12,12,12,12; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/circle,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/circle,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/circle,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/circle,BORDER_TOP_WEIGHT→selections/border_large,BORDER_BOTTOM_WEIGHT→selections/border_large,BORDER_LEFT_WEIGHT→selections/border_large,BORDER_RIGHT_WEIGHT→selections/border_large |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_radio_button/Active=true, State=Disabled

- 원본 node: `67:33602`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=true, State=Disabled | 67:33602 | SYMBOL | size=64×64; xy=188,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=true, State=Disabled/radio | 67:33603 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=switch/knob_disabled=#FFFFFFFF; stroke=switch/disabled=#1314171A; strokeWidth=12/INSIDE; edgeStroke(T,R,B,L)=12,12,12,12; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,BORDER_TOP_WEIGHT→selections/border_large,BORDER_BOTTOM_WEIGHT→selections/border_large,BORDER_LEFT_WEIGHT→selections/border_large,BORDER_RIGHT_WEIGHT→selections/border_large |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_radio_button/Active=false, State=Enabled

- 원본 node: `67:33604`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=false, State=Enabled | 67:33604 | SYMBOL | size=64×64; xy=20,104; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=false, State=Enabled/radio | 67:33605 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stroke=divider/tertiary=#13141733; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/circle,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/circle,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/circle,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/circle,BORDER_TOP_WEIGHT→selections/border_small,BORDER_BOTTOM_WEIGHT→selections/border_small,BORDER_LEFT_WEIGHT→selections/border_small,BORDER_RIGHT_WEIGHT→selections/border_small |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_radio_button/Active=false, State=Pressed

- 원본 node: `67:33606`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=false, State=Pressed | 67:33606 | SYMBOL | size=64×64; xy=104,104; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=false, State=Pressed/radio | 67:33607 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=dim/dark/secondary=#1314171A; stroke=divider/tertiary=#13141733; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/circle,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/circle,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/circle,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/circle,BORDER_TOP_WEIGHT→selections/border_small,BORDER_BOTTOM_WEIGHT→selections/border_small,BORDER_LEFT_WEIGHT→selections/border_small,BORDER_RIGHT_WEIGHT→selections/border_small |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_radio_button/Active=false, State=Disabled

- 원본 node: `67:33608`

- 공개 properties: `[{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=false, State=Disabled | 67:33608 | SYMBOL | size=64×64; xy=188,104; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_large,HEIGHT→selections/container_large |
| Active=false, State=Disabled/radio | 67:33609 | FRAME | size=48×48; xy=8,8; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=dim/dark/primary=#1314170D; stroke=divider/primary=#1314170D; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→selections/container_medium,HEIGHT→selections/container_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/circle,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/circle,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/circle,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/circle,BORDER_TOP_WEIGHT→selections/border_small,BORDER_BOTTOM_WEIGHT→selections/border_small,BORDER_LEFT_WEIGHT→selections/border_small,BORDER_RIGHT_WEIGHT→selections/border_small |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=true, Size=Medium, State=Enabled

- 원본 node: `67:33613`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=true, Size=Medium, State=Enabled | 67:33613 | SYMBOL | size=80×48; xy=20,20; r(TL,TR,BR,BL)=16,16,16,16; layout=VERTICAL/CENTER/MAX; padding(L,T,R,B)=8,8,8,8; gap=0; fill=switch/on=#02C265FF; bind=STACK_PADDING_LEFT→selections/switch/medium/padding,STACK_PADDING_TOP→selections/switch/medium/padding,STACK_PADDING_RIGHT→selections/switch/medium/padding,STACK_PADDING_BOTTOM→selections/switch/medium/padding,WIDTH→selections/switch/medium/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_bottom_right |
| Active=true, Size=Medium, State=Enabled/Rectangle 346243665 | 67:33614 | ROUNDED_RECTANGLE | size=32×32; xy=40,8; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_on=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/medium/knob_square,HEIGHT→selections/switch/medium/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=true, Size=Medium, State=Pressed

- 원본 node: `67:33615`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=true, Size=Medium, State=Pressed | 67:33615 | SYMBOL | size=80×48; xy=120,20; r(TL,TR,BR,BL)=16,16,16,16; layout=VERTICAL/CENTER/MAX; padding(L,T,R,B)=8,8,8,8; gap=0; fill=switch/on=#02C265FF,dim/dark/secondary=#1314171A; bind=STACK_PADDING_LEFT→selections/switch/medium/padding,STACK_PADDING_TOP→selections/switch/medium/padding,STACK_PADDING_RIGHT→selections/switch/medium/padding,STACK_PADDING_BOTTOM→selections/switch/medium/padding,WIDTH→selections/switch/medium/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_bottom_right |
| Active=true, Size=Medium, State=Pressed/Rectangle 346243665 | 67:33616 | ROUNDED_RECTANGLE | size=32×32; xy=40,8; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_on=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/medium/knob_square,HEIGHT→selections/switch/medium/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=true, Size=Medium, State=Disabled

- 원본 node: `67:33617`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=true, Size=Medium, State=Disabled | 67:33617 | SYMBOL | size=80×48; xy=220,20; r(TL,TR,BR,BL)=16,16,16,16; layout=VERTICAL/CENTER/MAX; padding(L,T,R,B)=8,8,8,8; gap=0; fill=switch/disabled=#1314171A; bind=STACK_PADDING_LEFT→selections/switch/medium/padding,STACK_PADDING_TOP→selections/switch/medium/padding,STACK_PADDING_RIGHT→selections/switch/medium/padding,STACK_PADDING_BOTTOM→selections/switch/medium/padding,WIDTH→selections/switch/medium/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_bottom_right |
| Active=true, Size=Medium, State=Disabled/Rectangle 346243665 | 67:33618 | ROUNDED_RECTANGLE | size=32×32; xy=40,8; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_on=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/medium/knob_square,HEIGHT→selections/switch/medium/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=false, Size=Medium, State=Enabled

- 원본 node: `67:33619`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=false, Size=Medium, State=Enabled | 67:33619 | SYMBOL | size=80×48; xy=20,88; r(TL,TR,BR,BL)=16,16,16,16; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=8,8,8,8; gap=0; fill=switch/off=#1314174D; bind=STACK_PADDING_LEFT→selections/switch/medium/padding,STACK_PADDING_TOP→selections/switch/medium/padding,STACK_PADDING_RIGHT→selections/switch/medium/padding,STACK_PADDING_BOTTOM→selections/switch/medium/padding,WIDTH→selections/switch/medium/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_bottom_right |
| Active=false, Size=Medium, State=Enabled/Rectangle 346243665 | 67:33620 | ROUNDED_RECTANGLE | size=32×32; xy=8,8; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_off=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/medium/knob_square,HEIGHT→selections/switch/medium/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=false, Size=Medium, State=Pressed

- 원본 node: `67:33621`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=false, Size=Medium, State=Pressed | 67:33621 | SYMBOL | size=80×48; xy=120,88; r(TL,TR,BR,BL)=16,16,16,16; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=8,8,8,8; gap=0; fill=switch/off=#1314174D,dim/dark/secondary=#1314171A; bind=STACK_PADDING_LEFT→selections/switch/medium/padding,STACK_PADDING_TOP→selections/switch/medium/padding,STACK_PADDING_RIGHT→selections/switch/medium/padding,STACK_PADDING_BOTTOM→selections/switch/medium/padding,WIDTH→selections/switch/medium/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_bottom_right |
| Active=false, Size=Medium, State=Pressed/Rectangle 346243665 | 67:33622 | ROUNDED_RECTANGLE | size=32×32; xy=8,8; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_off=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/medium/knob_square,HEIGHT→selections/switch/medium/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=false, Size=Medium, State=Disabled

- 원본 node: `67:33623`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=false, Size=Medium, State=Disabled | 67:33623 | SYMBOL | size=80×48; xy=220,88; r(TL,TR,BR,BL)=16,16,16,16; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=8,8,8,8; gap=0; fill=switch/disabled=#1314171A; bind=STACK_PADDING_LEFT→selections/switch/medium/padding,STACK_PADDING_TOP→selections/switch/medium/padding,STACK_PADDING_RIGHT→selections/switch/medium/padding,STACK_PADDING_BOTTOM→selections/switch/medium/padding,WIDTH→selections/switch/medium/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/radius_bottom_right |
| Active=false, Size=Medium, State=Disabled/Rectangle 346243665 | 67:33624 | ROUNDED_RECTANGLE | size=32×32; xy=8,8; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_disabled=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/medium/knob_square,HEIGHT→selections/switch/medium/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/medium/knob_radius_bottom_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=true, Size=Small, State=Enabled

- 원본 node: `67:33625`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=true, Size=Small, State=Enabled | 67:33625 | SYMBOL | size=64×40; xy=20,156; r(TL,TR,BR,BL)=12,12,12,12; layout=VERTICAL/MIN/MAX; padding(L,T,R,B)=6,6,6,6; gap=0; fill=switch/on=#02C265FF; bind=STACK_PADDING_LEFT→selections/switch/small/padding,STACK_PADDING_TOP→selections/switch/small/padding,STACK_PADDING_RIGHT→selections/switch/small/padding,STACK_PADDING_BOTTOM→selections/switch/small/padding,WIDTH→selections/switch/small/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/radius_bottom_right |
| Active=true, Size=Small, State=Enabled/Rectangle 346243665 | 67:33626 | ROUNDED_RECTANGLE | size=28×28; xy=30,6; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_on=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/small/knob_square,HEIGHT→selections/switch/small/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_top_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=true, Size=Small, State=Pressed

- 원본 node: `67:33627`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=true, Size=Small, State=Pressed | 67:33627 | SYMBOL | size=64×40; xy=104,156; r(TL,TR,BR,BL)=12,12,12,12; layout=VERTICAL/MIN/MAX; padding(L,T,R,B)=6,6,6,6; gap=0; fill=switch/on=#02C265FF,dim/dark/secondary=#1314171A; bind=STACK_PADDING_LEFT→selections/switch/small/padding,STACK_PADDING_TOP→selections/switch/small/padding,STACK_PADDING_RIGHT→selections/switch/small/padding,STACK_PADDING_BOTTOM→selections/switch/small/padding,WIDTH→selections/switch/small/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/radius_bottom_right |
| Active=true, Size=Small, State=Pressed/Rectangle 346243665 | 67:33628 | ROUNDED_RECTANGLE | size=28×28; xy=30,6; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_on=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/small/knob_square,HEIGHT→selections/switch/small/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_top_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=true, Size=Small, State=Disabled

- 원본 node: `67:33629`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=true, Size=Small, State=Disabled | 67:33629 | SYMBOL | size=64×40; xy=188,156; r(TL,TR,BR,BL)=12,12,12,12; layout=VERTICAL/MIN/MAX; padding(L,T,R,B)=6,6,6,6; gap=0; fill=switch/disabled=#1314171A; bind=STACK_PADDING_LEFT→selections/switch/small/padding,STACK_PADDING_TOP→selections/switch/small/padding,STACK_PADDING_RIGHT→selections/switch/small/padding,STACK_PADDING_BOTTOM→selections/switch/small/padding,WIDTH→selections/switch/small/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/radius_bottom_right |
| Active=true, Size=Small, State=Disabled/Rectangle 346243665 | 67:33630 | ROUNDED_RECTANGLE | size=28×28; xy=30,6; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_on=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/small/knob_square,HEIGHT→selections/switch/small/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_top_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=false, Size=Small, State=Enabled

- 원본 node: `67:33631`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=false, Size=Small, State=Enabled | 67:33631 | SYMBOL | size=64×40; xy=20,216; r(TL,TR,BR,BL)=12,12,12,12; layout=VERTICAL/MIN/MIN; padding(L,T,R,B)=6,6,6,6; gap=0; fill=switch/off=#1314174D; bind=STACK_PADDING_LEFT→selections/switch/small/padding,STACK_PADDING_TOP→selections/switch/small/padding,STACK_PADDING_RIGHT→selections/switch/small/padding,STACK_PADDING_BOTTOM→selections/switch/small/padding,WIDTH→selections/switch/small/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/radius_bottom_right |
| Active=false, Size=Small, State=Enabled/Rectangle 346243665 | 67:33632 | ROUNDED_RECTANGLE | size=28×28; xy=6,6; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_off=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/small/knob_square,HEIGHT→selections/switch/small/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_top_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=false, Size=Small, State=Pressed

- 원본 node: `67:33633`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=false, Size=Small, State=Pressed | 67:33633 | SYMBOL | size=64×40; xy=104,216; r(TL,TR,BR,BL)=12,12,12,12; layout=VERTICAL/MIN/MIN; padding(L,T,R,B)=6,6,6,6; gap=0; fill=switch/off=#1314174D,dim/dark/secondary=#1314171A; bind=STACK_PADDING_LEFT→selections/switch/small/padding,STACK_PADDING_TOP→selections/switch/small/padding,STACK_PADDING_RIGHT→selections/switch/small/padding,STACK_PADDING_BOTTOM→selections/switch/small/padding,WIDTH→selections/switch/small/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/radius_bottom_right |
| Active=false, Size=Small, State=Pressed/Rectangle 346243665 | 67:33634 | ROUNDED_RECTANGLE | size=28×28; xy=6,6; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_off=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/small/knob_square,HEIGHT→selections/switch/small/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_top_right |

## ❖ Components/Selections/Frame 1/Frame 5/Col/ivi_switch/Active=false, Size=Small, State=Disabled

- 원본 node: `67:33635`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Active=false, Size=Small, State=Disabled | 67:33635 | SYMBOL | size=64×40; xy=188,216; r(TL,TR,BR,BL)=12,12,12,12; layout=VERTICAL/MIN/MIN; padding(L,T,R,B)=6,6,6,6; gap=0; fill=switch/disabled=#1314171A; bind=STACK_PADDING_LEFT→selections/switch/small/padding,STACK_PADDING_TOP→selections/switch/small/padding,STACK_PADDING_RIGHT→selections/switch/small/padding,STACK_PADDING_BOTTOM→selections/switch/small/padding,WIDTH→selections/switch/small/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/radius_bottom_right |
| Active=false, Size=Small, State=Disabled/Rectangle 346243665 | 67:33636 | ROUNDED_RECTANGLE | size=28×28; xy=6,6; r(TL,TR,BR,BL)=8,8,8,8; fill=switch/knob_disabled=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=WIDTH→selections/switch/small/knob_square,HEIGHT→selections/switch/small/knob_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→selections/switch/small/knob_radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→selections/switch/small/knob_radius_top_right |

