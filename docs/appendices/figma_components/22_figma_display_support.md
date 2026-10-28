# Figma guide — 컴포넌트 및 하위 레이어 해석 부록

> **원본 부록:** 웹과 다른 옛 값은 이력이다. 최신 구현은 01·02·03·08번의 웹 최종값을 적용한다. 원본 snapshot 색을 새 웹 token 위에 다시 덮지 않는다.

원본 SYMBOL의 레이어 및 INSTANCE의 master 기본값, symbolOverrides, derivedSymbolData, componentPropAssignments를 병합한 오프라인 참조이다. 모든 치수는 원본 design unit이며 root xy는 디자인 보드상 위치이므로 런타임 위치로 복사하지 않는다. child xy는 부모 상대 좌표이다. r 순서는 TL/TR/BR/BL, padding 순서는 L/T/R/B이다.

fill/stroke의 HEX는 `#RRGGBBAA`이며 원본 color alpha×paint.opacity를 합성한 스냅샷 값이다. theme 동작에는 별도 전체 토큰 표와 웹 기준 충돌 해결 규칙을 적용한다. 노드 opacity는 별도로 표시한다. `hidden`은 예제에서 꺼진 옵션이며 구현에서 삭제하라는 뜻이 아니다. master의 드롭다운/토글/Label 등 공개 property도 구현 대상이다.

이 표는 바이너리 파싱 없이 geometry/style/variant를 참조하도록 만든다. Figma 렌더러 전체를 재구현한 것은 아니므로 boolean geometry·clip·특수 효과의 pixel 일치는 SVG 및 원본 guide와 검증한다. 외부 master 누락은 마지막 해석 결과에 별도로 남긴다.

## Internal Only Canvas/utility/indicator/type=normal

- 원본 node: `2003:7072`

- 공개 properties: `[{"name":"type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| type=normal | 2003:7072 | SYMBOL | size=26×8; xy=20,20; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=10; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→utility/page_indicator_gap_horizontal |
| type=normal/1 | 2003:7073 | ELLIPSE | size=8×8; xy=0,0; fill=system/icon/gray_primary=#131417FF; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |
| type=normal/2 | 2003:7074 | ELLIPSE | size=8×8; xy=18,0; fill=system/icon/gray_quaternary=#13141752; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |
| type=normal/3 | 2003:7075 | ELLIPSE | size=8×8; xy=36,0; hidden; fill=system/icon/gray_quaternary=#13141752; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |
| type=normal/4 | 2003:7076 | ELLIPSE | size=8×8; xy=54,0; hidden; fill=system/icon/gray_quaternary=#13141752; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |
| type=normal/5 | 2003:7077 | ELLIPSE | size=8×8; xy=72,0; hidden; fill=system/icon/gray_quaternary=#13141752; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |
| type=normal/6 | 2003:7078 | ELLIPSE | size=8×8; xy=90,0; hidden; fill=system/icon/gray_quaternary=#13141752; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |

## Internal Only Canvas/utility/indicator/type=none

- 원본 node: `2003:7079`

- 공개 properties: `[{"name":"type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| type=none | 2003:7079 | SYMBOL | size=26×8; xy=95,20; opacity=0; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=10; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→utility/page_indicator_gap_horizontal |
| type=none/1 | 2003:7080 | ELLIPSE | size=8×8; xy=0,0; fill=system/icon/gray_primary=#131417FF; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |
| type=none/2 | 2003:7081 | ELLIPSE | size=8×8; xy=18,0; fill=system/icon/gray_quaternary=#13141752; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |
| type=none/3 | 2003:7082 | ELLIPSE | size=8×8; xy=36,0; hidden; fill=system/icon/gray_quaternary=#13141752; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |
| type=none/4 | 2003:7083 | ELLIPSE | size=8×8; xy=54,0; hidden; fill=system/icon/gray_quaternary=#13141752; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |
| type=none/5 | 2003:7084 | ELLIPSE | size=8×8; xy=72,0; hidden; fill=system/icon/gray_quaternary=#13141752; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |
| type=none/6 | 2003:7085 | ELLIPSE | size=8×8; xy=90,0; hidden; fill=system/icon/gray_quaternary=#13141752; bind=WIDTH→utility/page_indicator_dot_square,HEIGHT→utility/page_indicator_dot_square |

## Internal Only Canvas/ivi_fullscreen_button/state=fold

- 원본 node: `2003:14317`

- 공개 properties: `[{"name":"Secondary","type":"BOOL","initialValue":{"boolValue":false}},{"name":"state","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| state=fold | 2003:14317 | SYMBOL | size=325.5×108; xy=40,40; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildPrimaryGrow=1 |
| state=fold/Frame 1707486411 | 2003:14318 | FRAME | size=132×108; xy=0,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,24,24,0; gap=16; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_LEFT→bars/fullscreen_control/padding_horizontal,STACK_PADDING_TOP→bars/fullscreen_control/padding_top,STACK_PADDING_RIGHT→bars/fullscreen_control/padding_horizontal |
| state=fold/Frame 1707486411/Frame 1707486737 | 2003:14319 | FRAME | size=84×84; xy=24,24; r(TL,TR,BR,BL)=28,28,28,28; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,14,14,14; gap=16; fill=static/dark/200=#131417D6; stroke=system/divider/divider_tertiary-added=#FFFFFF33; strokeWidth=1/INSIDE; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_LEFT→bars/fullscreen_control/icon_padding_horizontal,STACK_PADDING_TOP→bars/fullscreen_control/icon_padding_top,STACK_PADDING_RIGHT→bars/fullscreen_control/icon_padding_horizontal,STACK_PADDING_BOTTOM→bars/fullscreen_control/icon_padding_bottom,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/fullscreen_control/icon_button_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/fullscreen_control/icon_button_radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/fullscreen_control/icon_button_radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/fullscreen_control/icon_button_radius_top_left |
| state=fold/Frame 1707486411/Frame 1707486737/Full Screen | 2003:14320 → 2003:14306 | INSTANCE | size=56×56; xy=70,14; stackPrimarySizing=FIXED; bind=WIDTH→bars/fullscreen_control/magnify_icon_square,HEIGHT→bars/fullscreen_control/magnify_icon_square |
| state=fold/Frame 1707486411/Frame 1707486737/Full Screen/Path | 2003:14307 | BOOLEAN_OPERATION | size=43.665×43.6641; xy=6.166,6.167; hidden; fill=#000000FF |
| state=fold/Frame 1707486411/Frame 1707486737/Full Screen/Path/Vector 5909 | 2003:14308 | VECTOR | size=19.3914×19.3915; xy=22.2735,1.9997; stroke=#000000FF; strokeWidth=4/CENTER |
| state=fold/Frame 1707486411/Frame 1707486737/Full Screen/Path/Vector 5909 | 2003:14309 | VECTOR | size=19.3914×19.3915; xy=21.392,41.6639; stroke=#000000FF; strokeWidth=4/CENTER |
| state=fold/Frame 1707486411/Frame 1707486737/Full Screen/Path | 2003:14310 | VECTOR | size=37.998×37.9979; xy=9,9; fill=icon/light/primary=#FFFFFFFF |
| state=fold/Frame 1707486411/Frame 1707486737/Vector 6046 | 2003:14321 | VECTOR | size=0×36; xy=64,10; hidden; opacity=0.3; stroke=#FFFFFFFF; strokeWidth=1/CENTER |
| state=fold/Frame 1707486411/Frame 1707486737/Full Screen | 2003:14322 → 2003:14306 | INSTANCE | size=56×56; xy=120,8; hidden; stackPrimarySizing=FIXED; bind=WIDTH→bars/fullscreen_control/magnify_icon_square,HEIGHT→bars/fullscreen_control/magnify_icon_square |
| state=fold/Frame 1707486411/Frame 1707486737/Full Screen/Path | 2003:14307 | BOOLEAN_OPERATION | size=43.665×43.6641; xy=6.166,6.167; hidden; fill=#000000FF |
| state=fold/Frame 1707486411/Frame 1707486737/Full Screen/Path/Vector 5909 | 2003:14308 | VECTOR | size=19.3914×19.3915; xy=22.2735,1.9997; stroke=#000000FF; strokeWidth=4/CENTER |
| state=fold/Frame 1707486411/Frame 1707486737/Full Screen/Path/Vector 5909 | 2003:14309 | VECTOR | size=19.3914×19.3915; xy=21.392,41.6639; stroke=#000000FF; strokeWidth=4/CENTER |
| state=fold/Frame 1707486411/Frame 1707486737/Full Screen/Path | 2003:14310 | VECTOR | size=37.998×37.9979; xy=9,9; fill=icon/dark/primary=#131417FF |

## Internal Only Canvas/ivi_fullscreen_button/state=full

- 원본 node: `2003:14323`

- 공개 properties: `[{"name":"Secondary","type":"BOOL","initialValue":{"boolValue":false}},{"name":"state","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| state=full | 2003:14323 | SYMBOL | size=325.5×108; xy=405.5,40; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildPrimaryGrow=1 |
| state=full/Frame 1707486409 | 2003:14324 | FRAME | size=132×108; xy=0,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,24,24,0; gap=10; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_LEFT→bars/fullscreen_control/padding_horizontal,STACK_PADDING_TOP→bars/fullscreen_control/padding_top,STACK_PADDING_RIGHT→bars/fullscreen_control/padding_horizontal |
| state=full/Frame 1707486409/Frame 1707486737 | 2003:14325 | FRAME | size=84×84; xy=24,24; r(TL,TR,BR,BL)=28,28,28,28; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,14,14,14; gap=0; fill=static/dark/200=#131417D6; stroke=system/divider/divider_tertiary-added=#FFFFFF33; strokeWidth=1/INSIDE; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_LEFT→bars/fullscreen_control/icon_padding_horizontal,STACK_PADDING_TOP→bars/fullscreen_control/icon_padding_top,STACK_PADDING_RIGHT→bars/fullscreen_control/icon_padding_horizontal,STACK_PADDING_BOTTOM→bars/fullscreen_control/icon_padding_bottom,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/fullscreen_control/icon_button_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/fullscreen_control/icon_button_radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/fullscreen_control/icon_button_radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/fullscreen_control/icon_button_radius_top_left |
| state=full/Frame 1707486409/Frame 1707486737/Full Screen | 2003:14326 → 2003:14311 | INSTANCE | size=56×56; xy=70,14; bind=WIDTH→bars/fullscreen_control/magnify_icon_square,HEIGHT→bars/fullscreen_control/magnify_icon_square |
| state=full/Frame 1707486409/Frame 1707486737/Full Screen/Path | 2003:14312 | BOOLEAN_OPERATION | size=48.334×48.334; xy=3.833,3.833; fill=icon/light/primary=#FFFFFFFF |
| state=full/Frame 1707486409/Frame 1707486737/Full Screen/Path/Vector 5909 | 2003:14313 | VECTOR | size=18.6667×18.6667; xy=46.3337,20.667; stroke=#000000FF; strokeWidth=4/CENTER |
| state=full/Frame 1707486409/Frame 1707486737/Full Screen/Path/Vector 5909 | 2003:14314 | VECTOR | size=18.6667×18.6667; xy=2.0003,27.667; stroke=#000000FF; strokeWidth=4/CENTER |

## Internal Only Canvas/ivi_window_bar/State=Enabled

- 원본 node: `2003:15502`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Enabled | 2003:15502 | SYMBOL | size=20×200; xy=20,60.5; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,0,8,0; gap=0; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→bars/window_control/padding_horizontal,STACK_PADDING_RIGHT→bars/window_control/padding_horizontal,WIDTH→bars/window_control/container_width,HEIGHT→bars/window_control/container_height |
| State=Enabled/bar | 2003:15503 | ROUNDED_RECTANGLE | size=4×160; xy=8,20; r(TL,TR,BR,BL)=999,999,999,999; fill=alpha/dark/200=#13141733; bind=WIDTH→bars/window_control/handle_width,HEIGHT→bars/window_control/handle_height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/radius_bottom_right |

## Internal Only Canvas/ivi_window_bar/State=Disabled

- 원본 node: `2003:15504`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Disabled | 2003:15504 | SYMBOL | size=20×200; xy=110,60.5; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,0,8,0; gap=0; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→bars/window_control/padding_horizontal,STACK_PADDING_RIGHT→bars/window_control/padding_horizontal,WIDTH→bars/window_control/container_width,HEIGHT→bars/window_control/container_height |
| State=Disabled/bar | 2003:15505 | ROUNDED_RECTANGLE | size=4×160; xy=8,20; opacity=0; r=100; r(TL,TR,BR,BL)=100,100,100,100; fill=icon/dark/primary=#131417FF; bind=WIDTH→bars/window_control/handle_width,HEIGHT→bars/window_control/handle_height |

## Internal Only Canvas/ivi_window_bar/State=Pressed

- 원본 node: `2003:15506`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Pressed | 2003:15506 | SYMBOL | size=20×200; xy=200,60.5; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,0,8,0; gap=0; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→bars/window_control/padding_horizontal,STACK_PADDING_RIGHT→bars/window_control/padding_horizontal,WIDTH→bars/window_control/container_width,HEIGHT→bars/window_control/container_height |
| State=Pressed/bar | 2003:15507 | ROUNDED_RECTANGLE | size=4×80; xy=8,60; r(TL,TR,BR,BL)=999,999,999,999; fill=alpha/dark/500=#13141780; bind=WIDTH→bars/window_control/handle_width,HEIGHT→bars/window_control/handle_height_pressed,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/radius_bottom_right |

## Internal Only Canvas/ivi_window_bar/State=Enabled

- 원본 node: `2203:12684`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Enabled | 2203:12684 | SYMBOL | size=20×200; xy=20,60.5; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,0,8,0; gap=0; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→bars/window_control/padding_horizontal,STACK_PADDING_RIGHT→bars/window_control/padding_horizontal,WIDTH→bars/window_control/container_width,HEIGHT→bars/window_control/container_height |
| State=Enabled/bar | 2203:12685 | ROUNDED_RECTANGLE | size=4×160; xy=8,20; r(TL,TR,BR,BL)=999,999,999,999; fill=color/alpha/dark/400=#13141766; bind=WIDTH→bars/window_control/handle_width,HEIGHT→bars/window_control/handle_height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/radius_bottom_right |

## Internal Only Canvas/ivi_window_bar/State=Disabled

- 원본 node: `2203:12686`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Disabled | 2203:12686 | SYMBOL | size=20×200; xy=110,60.5; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,0,8,0; gap=0; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→bars/window_control/padding_horizontal,STACK_PADDING_RIGHT→bars/window_control/padding_horizontal,WIDTH→bars/window_control/container_width,HEIGHT→bars/window_control/container_height |
| State=Disabled/bar | 2203:12687 | ROUNDED_RECTANGLE | size=4×160; xy=8,20; opacity=0; r=100; r(TL,TR,BR,BL)=100,100,100,100; fill=color/icon/dark/primary=#131417FF; bind=WIDTH→bars/window_control/handle_width,HEIGHT→bars/window_control/handle_height |

## Internal Only Canvas/ivi_window_bar/State=Pressed

- 원본 node: `2203:12688`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Pressed | 2203:12688 | SYMBOL | size=20×200; xy=200,60.5; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,0,8,0; gap=0; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→bars/window_control/padding_horizontal,STACK_PADDING_RIGHT→bars/window_control/padding_horizontal,WIDTH→bars/window_control/container_width,HEIGHT→bars/window_control/container_height |
| State=Pressed/bar | 2203:12689 | ROUNDED_RECTANGLE | size=4×80; xy=8,60; r(TL,TR,BR,BL)=999,999,999,999; fill=color/alpha/dark/500=#13141780; bind=WIDTH→bars/window_control/handle_width,HEIGHT→bars/window_control/handle_height_pressed,RECTANGLE_TOP_LEFT_CORNER_RADIUS→bars/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→bars/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→bars/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→bars/radius_bottom_right |

## 해석 결과

- 대상 master 10개; 전개 레이어 47개; master 누락 0개.
