# Figma assets — 컴포넌트 및 하위 레이어 해석 부록

> **원본 부록:** 웹과 다른 옛 값은 이력이다. 최신 구현은 01·02·03·08번의 웹 최종값을 적용한다. 원본 snapshot 색을 새 웹 token 위에 다시 덮지 않는다.

원본 SYMBOL의 레이어 및 INSTANCE의 master 기본값, symbolOverrides, derivedSymbolData, componentPropAssignments를 병합한 오프라인 참조이다. 모든 치수는 원본 design unit이며 root xy는 디자인 보드상 위치이므로 런타임 위치로 복사하지 않는다. child xy는 부모 상대 좌표이다. r 순서는 TL/TR/BR/BL, padding 순서는 L/T/R/B이다.

fill/stroke의 HEX는 `#RRGGBBAA`이며 원본 color alpha×paint.opacity를 합성한 스냅샷 값이다. theme 동작에는 별도 전체 토큰 표와 웹 기준 충돌 해결 규칙을 적용한다. 노드 opacity는 별도로 표시한다. `hidden`은 예제에서 꺼진 옵션이며 구현에서 삭제하라는 뜻이 아니다. master의 드롭다운/토글/Label 등 공개 property도 구현 대상이다.

이 표는 바이너리 파싱 없이 geometry/style/variant를 참조하도록 만든다. Figma 렌더러 전체를 재구현한 것은 아니므로 boolean geometry·clip·특수 효과의 pixel 일치는 SVG 및 원본 guide와 검증한다. 외부 master 누락은 마지막 해석 결과에 별도로 남긴다.


## Internal Only Canvas/ivi_app_bar/State=Enabled

- 원본 node: `67:27411`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Enabled | 67:27411 | SYMBOL | size=320×60; xy=20,20; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,16,0,0; gap=0; stackPrimarySizing=FIXED; bind=STACK_PADDING_TOP→bars/app_control/padding_top,WIDTH→bars/app_control/container_width,HEIGHT→bars/app_control/container_height |
| State=Enabled/bar | 67:27412 | ROUNDED_RECTANGLE | size=140×8; xy=90,16; r(TL,TR,BR,BL)=999,999,999,999; fill=alpha/dark/200=#13141733; bind=WIDTH→bars/app_control/handle_width_normal,HEIGHT→bars/app_control/handle_height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/radius_bottom_right |

## Internal Only Canvas/ivi_app_bar/State=Disabled

- 원본 node: `67:27413`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Disabled | 67:27413 | SYMBOL | size=320×60; xy=20,120; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,16,0,0; gap=0; stackPrimarySizing=FIXED; bind=STACK_PADDING_TOP→bars/app_control/padding_top,WIDTH→bars/app_control/container_width,HEIGHT→bars/app_control/container_height |
| State=Disabled/bar | 67:27414 | ROUNDED_RECTANGLE | size=140×8; xy=90,16; opacity=0; r(TL,TR,BR,BL)=999,999,999,999; fill=alpha/dark/200=#13141733; bind=WIDTH→bars/app_control/handle_width_normal,HEIGHT→bars/app_control/handle_height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/radius_bottom_right |

## Internal Only Canvas/ivi_app_bar/State=Pressed

- 원본 node: `67:27415`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Pressed | 67:27415 | SYMBOL | size=320×60; xy=20,220; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,16,0,0; gap=0; stackPrimarySizing=FIXED; bind=STACK_PADDING_TOP→bars/app_control/padding_top,WIDTH→bars/app_control/container_width,HEIGHT→bars/app_control/container_height |
| State=Pressed/bar | 67:27416 | ROUNDED_RECTANGLE | size=140×8; xy=90,16; r(TL,TR,BR,BL)=999,999,999,999; fill=alpha/dark/500=#13141780; bind=WIDTH→bars/app_control/handle_width_normal,HEIGHT→bars/app_control/handle_height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/radius_bottom_right |

## Internal Only Canvas/ivi_scroll_bar/State=Enabled, Controllable=No

- 원본 node: `67:28979`

- 공개 properties: `[{"name":"Controllable","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Enabled, Controllable=No | 67:28979 | SYMBOL | size=6×150; xy=40,168.5; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; min={'x': 0, 'y': 48}; fill=alpha/dark/200=#13141733; bind=WIDTH→bars/page_scroll/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/radius_bottom_right,MIN_HEIGHT→bars/page_scroll/min_height |

## Internal Only Canvas/ivi_scroll_bar/State=Pressed, Controllable=No

- 원본 node: `67:28980`

- 공개 properties: `[{"name":"Controllable","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Pressed, Controllable=No | 67:28980 | SYMBOL | size=6×150; xy=253.5,168.5; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; min={'x': 0, 'y': 48}; fill=alpha/dark/500=#13141780; bind=WIDTH→bars/page_scroll/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/radius_bottom_right,MIN_HEIGHT→bars/page_scroll/min_height |

## Internal Only Canvas/ivi_scroll_bar/State=scroll, Controllable=Yes

- 원본 node: `67:28981`

- 공개 properties: `[{"name":"Controllable","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=scroll, Controllable=Yes | 67:28981 | SYMBOL | size=96×407; xy=467,40; layout=VERTICAL/SPACE_EVENLY/CENTER; padding(L,T,R,B)=12,16,20,16; gap=45; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_PADDING_LEFT→scroll/padding_left,STACK_PADDING_TOP→scroll/padding_vertical,STACK_PADDING_RIGHT→scroll/padding_right,STACK_PADDING_BOTTOM→scroll/padding_vertical |
| State=scroll, Controllable=Yes/Group | 67:28982 | FRAME | size=64×207; xy=12,16; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=16; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→scroll/gap |
| State=scroll, Controllable=Yes/Group/ivi_icon_button | 67:28983 → 67:24356 | INSTANCE | size=64×64; xy=0,0; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| State=scroll, Controllable=Yes/Group/ivi_icon_button/ic_plus | 67:24357 → 67:28972 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| State=scroll, Controllable=Yes/Group/ivi_icon_button/ic_plus/Path | 67:28973 | VECTOR | size=25.6667×12.8333; xy=9.1667,15.5833; hidden; stroke=#000000FF; strokeWidth=4/CENTER |
| State=scroll, Controllable=Yes/Group/ivi_icon_button/ic_plus/Icon | 67:28974 | VECTOR | size=29.3333×16.5; xy=7.3333,13.75; fill=icon/dark/primary=#131417FF |
| State=scroll, Controllable=Yes/Group/Bar | 67:28984 | ROUNDED_RECTANGLE | size=8×127; xy=28,80; r=99; r(TL,TR,BR,BL)=99,99,99,99; fill=alpha/dark/500=#13141780 |
| State=scroll, Controllable=Yes/ivi_icon_button | 67:28985 → 67:24356 | INSTANCE | size=64×64; xy=12,327; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| State=scroll, Controllable=Yes/ivi_icon_button/ic_plus | 67:24357 → 67:22105 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| State=scroll, Controllable=Yes/ivi_icon_button/ic_plus/Path | 67:22106 | VECTOR | size=25.6667×12.8333; xy=9.1667,15.5833; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| State=scroll, Controllable=Yes/ivi_icon_button/ic_plus/Icon | 67:22107 | VECTOR | size=29.3333×16.5; xy=7.3333,13.75; fill=icon/dark/quaternary=#13141752 |

