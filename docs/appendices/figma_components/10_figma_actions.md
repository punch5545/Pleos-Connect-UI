# Figma assets — 컴포넌트 및 하위 레이어 해석 부록

> **원본 부록:** 웹과 다른 옛 값은 이력이다. 최신 구현은 01·02·03·08번의 웹 최종값을 적용한다. 원본 snapshot 색을 새 웹 token 위에 다시 덮지 않는다.

원본 SYMBOL의 레이어 및 INSTANCE의 master 기본값, symbolOverrides, derivedSymbolData, componentPropAssignments를 병합한 오프라인 참조이다. 모든 치수는 원본 design unit이며 root xy는 디자인 보드상 위치이므로 런타임 위치로 복사하지 않는다. child xy는 부모 상대 좌표이다. r 순서는 TL/TR/BR/BL, padding 순서는 L/T/R/B이다.

fill/stroke의 HEX는 `#RRGGBBAA`이며 원본 color alpha×paint.opacity를 합성한 스냅샷 값이다. theme 동작에는 별도 전체 토큰 표와 웹 기준 충돌 해결 규칙을 적용한다. 노드 opacity는 별도로 표시한다. `hidden`은 예제에서 꺼진 옵션이며 구현에서 삭제하라는 뜻이 아니다. master의 드롭다운/토글/Label 등 공개 property도 구현 대상이다.

이 표는 바이너리 파싱 없이 geometry/style/variant를 참조하도록 만든다. Figma 렌더러 전체를 재구현한 것은 아니므로 boolean geometry·clip·특수 효과의 pixel 일치는 SVG 및 원본 guide와 검증한다. 외부 master 누락은 마지막 해석 결과에 별도로 남긴다.


## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Primary, Size=Large, State=Enabled

- 원본 node: `67:22526`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, Size=Large, State=Enabled | 67:22526 | SYMBOL | size=160×100; xy=40,40; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/basic/enabled=#1314170D; bind=STACK_SPACING→buttons/basic/large/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/large/padding_horizontal,STACK_PADDING_TOP→buttons/basic/large/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/large/padding_vertical,HEIGHT→buttons/basic/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,MIN_WIDTH→buttons/basic/large/min_width |
| Type=Primary, Size=Large, State=Enabled/ic_beam | 67:22527 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Large, State=Enabled/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Large, State=Enabled/Label | 67:22528 | TEXT | size=80×40; xy=40,30; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Primary, Size=Large, State=Enabled/ic_arrow | 67:22529 → 67:22099 | INSTANCE | size=52×52; xy=204,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Primary, Size=Large, State=Enabled/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Primary, Size=Large, State=Enabled/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Primary, Size=Large, State=Pressed

- 원본 node: `67:22530`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, Size=Large, State=Pressed | 67:22530 | SYMBOL | size=160×100; xy=240,40; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/basic/pressed=#1314171A; bind=STACK_SPACING→buttons/basic/large/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/large/padding_horizontal,STACK_PADDING_TOP→buttons/basic/large/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/large/padding_vertical,HEIGHT→buttons/basic/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,MIN_WIDTH→buttons/basic/large/min_width |
| Type=Primary, Size=Large, State=Pressed/ic_beam | 67:22531 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Large, State=Pressed/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Large, State=Pressed/Label | 67:22532 | TEXT | size=80×40; xy=40,30; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Primary, Size=Large, State=Pressed/ic_arrow | 67:22533 → 67:22099 | INSTANCE | size=52×52; xy=204,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Primary, Size=Large, State=Pressed/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Primary, Size=Large, State=Pressed/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Primary, Size=Large, State=Disabled

- 원본 node: `67:22534`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, Size=Large, State=Disabled | 67:22534 | SYMBOL | size=160×100; xy=440,40; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/basic/disabled=#FFFFFF33; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/basic/large/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/large/padding_horizontal,STACK_PADDING_TOP→buttons/basic/large/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/large/padding_vertical,HEIGHT→buttons/basic/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,BORDER_TOP_WEIGHT→buttons/basic/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/basic/disabled_border,BORDER_LEFT_WEIGHT→buttons/basic/disabled_border,BORDER_RIGHT_WEIGHT→buttons/basic/disabled_border,MIN_WIDTH→buttons/basic/large/min_width |
| Type=Primary, Size=Large, State=Disabled/ic_beam | 67:22535 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/dark/tertiary=#1B1C1E4D |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Large, State=Disabled/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/dark/quaternary=#13141752 |
| Type=Primary, Size=Large, State=Disabled/Label | 67:22536 | TEXT | size=80×40; xy=40,30; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Primary, Size=Large, State=Disabled/ic_arrow | 67:22537 → 67:22099 | INSTANCE | size=52×52; xy=204,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Primary, Size=Large, State=Disabled/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Primary, Size=Large, State=Disabled/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Primary, Size=Medium, State=Enabled

- 원본 node: `67:22538`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, Size=Medium, State=Enabled | 67:22538 | SYMBOL | size=139×80; xy=640,40; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/basic/enabled=#1314170D; bind=STACK_SPACING→buttons/basic/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/medium/padding_horizontal,STACK_PADDING_TOP→buttons/basic/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/medium/padding_vertical,HEIGHT→buttons/basic/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,MIN_WIDTH→buttons/basic/medium/min_width |
| Type=Primary, Size=Medium, State=Enabled/ic_beam | 67:22539 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Medium, State=Enabled/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Medium, State=Enabled/Label | 67:22540 | TEXT | size=75×38; xy=32,21; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Primary, Size=Medium, State=Enabled/ic_arrow | 67:22541 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Primary, Size=Medium, State=Enabled/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Primary, Size=Medium, State=Enabled/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Primary, Size=Medium, State=Pressed

- 원본 node: `67:22542`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, Size=Medium, State=Pressed | 67:22542 | SYMBOL | size=139×80; xy=819,40; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/basic/pressed=#1314171A; bind=STACK_SPACING→buttons/basic/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/medium/padding_horizontal,STACK_PADDING_TOP→buttons/basic/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/medium/padding_vertical,HEIGHT→buttons/basic/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,MIN_WIDTH→buttons/basic/medium/min_width |
| Type=Primary, Size=Medium, State=Pressed/ic_beam | 67:22543 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Medium, State=Pressed/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Medium, State=Pressed/Label | 67:22544 | TEXT | size=75×38; xy=32,21; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Primary, Size=Medium, State=Pressed/ic_arrow | 67:22545 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Primary, Size=Medium, State=Pressed/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Primary, Size=Medium, State=Pressed/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Primary, Size=Medium, State=Disabled

- 원본 node: `67:22546`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, Size=Medium, State=Disabled | 67:22546 | SYMBOL | size=139×80; xy=998,40; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/basic/disabled=#FFFFFF33; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/basic/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/medium/padding_horizontal,STACK_PADDING_TOP→buttons/basic/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/medium/padding_vertical,HEIGHT→buttons/basic/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,BORDER_TOP_WEIGHT→buttons/basic/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/basic/disabled_border,BORDER_LEFT_WEIGHT→buttons/basic/disabled_border,BORDER_RIGHT_WEIGHT→buttons/basic/disabled_border,MIN_WIDTH→buttons/basic/medium/min_width |
| Type=Primary, Size=Medium, State=Disabled/ic_beam | 67:22547 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/dark/tertiary=#1B1C1E4D |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Medium, State=Disabled/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/quaternary=#13141752 |
| Type=Primary, Size=Medium, State=Disabled/Label | 67:22548 | TEXT | size=75×38; xy=32,21; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Primary, Size=Medium, State=Disabled/ic_arrow | 67:22549 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Primary, Size=Medium, State=Disabled/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Primary, Size=Medium, State=Disabled/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Primary, Size=Small, State=Enabled

- 원본 node: `67:22550`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, Size=Small, State=Enabled | 67:22550 | SYMBOL | size=113×64; xy=1177,40; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/basic/enabled=#1314170D; bind=STACK_SPACING→buttons/basic/small/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/small/padding_horizontal,STACK_PADDING_TOP→buttons/basic/small/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/small/padding_vertical,HEIGHT→buttons/basic/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,MIN_WIDTH→buttons/basic/small/min_width |
| Type=Primary, Size=Small, State=Enabled/ic_beam | 67:22551 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Small, State=Enabled/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Small, State=Enabled/Label | 67:22552 | TEXT | size=65×34; xy=24,15; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Primary, Size=Small, State=Enabled/ic_arrow | 67:22553 → 67:22099 | INSTANCE | size=32×32; xy=145,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Primary, Size=Small, State=Enabled/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Primary, Size=Small, State=Enabled/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Primary, Size=Small, State=Pressed

- 원본 node: `67:22554`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, Size=Small, State=Pressed | 67:22554 | SYMBOL | size=113×64; xy=1330,40; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/basic/pressed=#1314171A; bind=STACK_SPACING→buttons/basic/small/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/small/padding_horizontal,STACK_PADDING_TOP→buttons/basic/small/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/small/padding_vertical,HEIGHT→buttons/basic/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,MIN_WIDTH→buttons/basic/small/min_width |
| Type=Primary, Size=Small, State=Pressed/ic_beam | 67:22555 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Small, State=Pressed/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Small, State=Pressed/Label | 67:22556 | TEXT | size=65×34; xy=24,15; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Primary, Size=Small, State=Pressed/ic_arrow | 67:22557 → 67:22099 | INSTANCE | size=32×32; xy=145,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Primary, Size=Small, State=Pressed/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Primary, Size=Small, State=Pressed/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Primary, Size=Small, State=Disabled

- 원본 node: `67:22558`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, Size=Small, State=Disabled | 67:22558 | SYMBOL | size=113×64; xy=1483,40; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/basic/disabled=#FFFFFF33; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/basic/small/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/small/padding_horizontal,STACK_PADDING_TOP→buttons/basic/small/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/small/padding_vertical,HEIGHT→buttons/basic/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/basic/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/basic/disabled_border,BORDER_LEFT_WEIGHT→buttons/basic/disabled_border,BORDER_RIGHT_WEIGHT→buttons/basic/disabled_border,MIN_WIDTH→buttons/basic/small/min_width |
| Type=Primary, Size=Small, State=Disabled/ic_beam | 67:22559 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/dark/tertiary=#1B1C1E4D |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Primary, Size=Small, State=Disabled/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/dark/quaternary=#13141752 |
| Type=Primary, Size=Small, State=Disabled/Label | 67:22560 | TEXT | size=65×34; xy=24,15; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Primary, Size=Small, State=Disabled/ic_arrow | 67:22561 → 67:22099 | INSTANCE | size=32×32; xy=145,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Primary, Size=Small, State=Disabled/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Primary, Size=Small, State=Disabled/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Secondary, Size=Large, State=Enabled

- 원본 node: `67:22562`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, Size=Large, State=Enabled | 67:22562 | SYMBOL | size=160×100; xy=40,180; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/filled/enabled=#44464EFF; bind=STACK_SPACING→buttons/basic/large/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/large/padding_horizontal,STACK_PADDING_TOP→buttons/basic/large/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/large/padding_vertical,HEIGHT→buttons/basic/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,MIN_WIDTH→buttons/basic/large/min_width |
| Type=Secondary, Size=Large, State=Enabled/ic_beam | 67:22563 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=_Legacy/Scale/White/White=#FFFFFFFF |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Large, State=Enabled/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Large, State=Enabled/Label | 67:22564 | TEXT | size=80×40; xy=40,30; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Secondary, Size=Large, State=Enabled/ic_arrow | 67:22565 → 67:22099 | INSTANCE | size=52×52; xy=204,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Secondary, Size=Large, State=Enabled/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Secondary, Size=Large, State=Enabled/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/light/primary=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Secondary, Size=Large, State=Pressed

- 원본 node: `67:22566`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, Size=Large, State=Pressed | 67:22566 | SYMBOL | size=160×100; xy=240,180; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/filled/pressed=#313236FF; bind=STACK_SPACING→buttons/basic/large/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/large/padding_horizontal,STACK_PADDING_TOP→buttons/basic/large/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/large/padding_vertical,HEIGHT→buttons/basic/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,MIN_WIDTH→buttons/basic/large/min_width |
| Type=Secondary, Size=Large, State=Pressed/ic_beam | 67:22567 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Large, State=Pressed/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Large, State=Pressed/Label | 67:22568 | TEXT | size=80×40; xy=40,30; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Secondary, Size=Large, State=Pressed/ic_arrow | 67:22569 → 67:22099 | INSTANCE | size=52×52; xy=204,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Secondary, Size=Large, State=Pressed/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Secondary, Size=Large, State=Pressed/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/light/primary=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Secondary, Size=Large, State=Disabled

- 원본 node: `67:22570`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, Size=Large, State=Disabled | 67:22570 | SYMBOL | size=160×100; xy=440,180; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/filled/disabled=#1314170D; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/basic/large/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/large/padding_horizontal,STACK_PADDING_TOP→buttons/basic/large/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/large/padding_vertical,HEIGHT→buttons/basic/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/large/radius_top_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/large/radius_top_left,BORDER_TOP_WEIGHT→buttons/basic/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/basic/disabled_border,BORDER_LEFT_WEIGHT→buttons/basic/disabled_border,BORDER_RIGHT_WEIGHT→buttons/basic/disabled_border,MIN_WIDTH→buttons/basic/large/min_width |
| Type=Secondary, Size=Large, State=Disabled/ic_beam | 67:22571 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/dark/quaternary=#1B1C1E52 |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Large, State=Disabled/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/dark/quaternary=#13141752 |
| Type=Secondary, Size=Large, State=Disabled/Label | 67:22572 | TEXT | size=80×40; xy=40,30; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Secondary, Size=Large, State=Disabled/ic_arrow | 67:22573 → 67:22099 | INSTANCE | size=52×52; xy=204,24; hidden; bind=WIDTH→buttons/basic/large/icon_sqaure,HEIGHT→buttons/basic/large/icon_sqaure |
| Type=Secondary, Size=Large, State=Disabled/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Secondary, Size=Large, State=Disabled/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Secondary, Size=Medium, State=Enabled

- 원본 node: `67:22574`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, Size=Medium, State=Enabled | 67:22574 | SYMBOL | size=139×80; xy=640,180; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/filled/enabled=#44464EFF; bind=STACK_SPACING→buttons/basic/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/medium/padding_horizontal,STACK_PADDING_TOP→buttons/basic/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/medium/padding_vertical,HEIGHT→buttons/basic/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,MIN_WIDTH→buttons/basic/medium/min_width |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam | 67:22575 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Medium, State=Enabled/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Medium, State=Enabled/Label | 67:22576 | TEXT | size=75×38; xy=32,21; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Secondary, Size=Medium, State=Enabled/ic_arrow | 67:22577 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Secondary, Size=Medium, State=Enabled/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Secondary, Size=Medium, State=Enabled/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/light/primary=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Secondary, Size=Medium, State=Pressed

- 원본 node: `67:22578`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, Size=Medium, State=Pressed | 67:22578 | SYMBOL | size=139×80; xy=819,180; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/filled/pressed=#313236FF; bind=STACK_SPACING→buttons/basic/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/medium/padding_horizontal,STACK_PADDING_TOP→buttons/basic/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/medium/padding_vertical,HEIGHT→buttons/basic/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,MIN_WIDTH→buttons/basic/medium/min_width |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam | 67:22579 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Medium, State=Pressed/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Medium, State=Pressed/Label | 67:22580 | TEXT | size=75×38; xy=32,21; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Secondary, Size=Medium, State=Pressed/ic_arrow | 67:22581 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Secondary, Size=Medium, State=Pressed/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Secondary, Size=Medium, State=Pressed/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/light/primary=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Secondary, Size=Medium, State=Disabled

- 원본 node: `67:22582`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, Size=Medium, State=Disabled | 67:22582 | SYMBOL | size=139×80; xy=998,180; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/filled/disabled=#1314170D; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/basic/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/medium/padding_horizontal,STACK_PADDING_TOP→buttons/basic/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/medium/padding_vertical,HEIGHT→buttons/basic/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_left_medium,BORDER_TOP_WEIGHT→buttons/basic/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/basic/disabled_border,BORDER_LEFT_WEIGHT→buttons/basic/disabled_border,BORDER_RIGHT_WEIGHT→buttons/basic/disabled_border,MIN_WIDTH→buttons/basic/medium/min_width |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam | 67:22583 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/dark/quaternary=#1B1C1E52 |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Medium, State=Disabled/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/quaternary=#13141752 |
| Type=Secondary, Size=Medium, State=Disabled/Label | 67:22584 | TEXT | size=75×38; xy=32,21; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Secondary, Size=Medium, State=Disabled/ic_arrow | 67:22585 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Secondary, Size=Medium, State=Disabled/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Secondary, Size=Medium, State=Disabled/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Secondary, Size=Small, State=Enabled

- 원본 node: `67:22586`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, Size=Small, State=Enabled | 67:22586 | SYMBOL | size=113×64; xy=1177,180; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/filled/enabled=#44464EFF; bind=STACK_SPACING→buttons/basic/small/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/small/padding_horizontal,STACK_PADDING_TOP→buttons/basic/small/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/small/padding_vertical,HEIGHT→buttons/basic/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,MIN_WIDTH→buttons/basic/small/min_width |
| Type=Secondary, Size=Small, State=Enabled/ic_beam | 67:22587 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Small, State=Enabled/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Small, State=Enabled/Label | 67:22588 | TEXT | size=65×34; xy=24,15; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Secondary, Size=Small, State=Enabled/ic_arrow | 67:22589 → 67:22099 | INSTANCE | size=32×32; xy=145,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Secondary, Size=Small, State=Enabled/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Secondary, Size=Small, State=Enabled/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/light/primary=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Secondary, Size=Small, State=Pressed

- 원본 node: `67:22590`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, Size=Small, State=Pressed | 67:22590 | SYMBOL | size=113×64; xy=1330,180; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/filled/pressed=#313236FF; bind=STACK_SPACING→buttons/basic/small/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/small/padding_horizontal,STACK_PADDING_TOP→buttons/basic/small/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/small/padding_vertical,HEIGHT→buttons/basic/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,MIN_WIDTH→buttons/basic/small/min_width |
| Type=Secondary, Size=Small, State=Pressed/ic_beam | 67:22591 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Small, State=Pressed/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/light/primary=#FFFFFFFF |
| Type=Secondary, Size=Small, State=Pressed/Label | 67:22592 | TEXT | size=65×34; xy=24,15; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Secondary, Size=Small, State=Pressed/ic_arrow | 67:22593 → 67:22099 | INSTANCE | size=32×32; xy=145,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Secondary, Size=Small, State=Pressed/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Secondary, Size=Small, State=Pressed/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/light/primary=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486149/ivi_basic_button/Type=Secondary, Size=Small, State=Disabled

- 원본 node: `67:22594`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, Size=Small, State=Disabled | 67:22594 | SYMBOL | size=113×64; xy=1483,180; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/filled/disabled=#1314170D; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/basic/small/gap_horizontal,STACK_PADDING_LEFT→buttons/basic/small/padding_horizontal,STACK_PADDING_TOP→buttons/basic/small/padding_vertical,STACK_PADDING_RIGHT→buttons/basic/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/basic/small/padding_vertical,HEIGHT→buttons/basic/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/small/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/basic/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/basic/disabled_border,BORDER_LEFT_WEIGHT→buttons/basic/disabled_border,BORDER_RIGHT_WEIGHT→buttons/basic/disabled_border,MIN_WIDTH→buttons/basic/small/min_width |
| Type=Secondary, Size=Small, State=Disabled/ic_beam | 67:22595 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/dark/quaternary=#1B1C1E52 |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Secondary, Size=Small, State=Disabled/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/dark/quaternary=#13141752 |
| Type=Secondary, Size=Small, State=Disabled/Label | 67:22596 | TEXT | size=65×34; xy=24,15; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Type=Secondary, Size=Small, State=Disabled/ic_arrow | 67:22597 → 67:22099 | INSTANCE | size=32×32; xy=145,16; hidden; bind=WIDTH→buttons/basic/small/icon_sqaure,HEIGHT→buttons/basic/small/icon_sqaure |
| Type=Secondary, Size=Small, State=Disabled/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Secondary, Size=Small, State=Disabled/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Large, State=Enabled, On active=false

- 원본 node: `67:22601`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Enabled, On active=false | 67:22601 | SYMBOL | size=160×100; xy=40,40; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/basic/enabled=#1314170D; bind=STACK_SPACING→buttons/toggle/large/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/large/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/large/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/large/padding_vertical,HEIGHT→buttons/toggle/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_right,MIN_WIDTH→buttons/toggle/large/min_width |
| Size=Large, State=Enabled, On active=false/ic_beam | 67:22602 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Enabled, On active=false/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Enabled, On active=false/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Enabled, On active=false/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Enabled, On active=false/Label | 67:22603 | TEXT | size=80×40; xy=40,30; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Large, State=Enabled, On active=false/ic_arrow | 67:22604 → 67:22099 | INSTANCE | size=52×52; xy=136,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Enabled, On active=false/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Large, State=Enabled, On active=false/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/dark/secondary=#1B1C1ECC |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Large, State=Pressed, On active=false

- 원본 node: `67:22605`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Pressed, On active=false | 67:22605 | SYMBOL | size=160×100; xy=240,40; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/basic/pressed=#1314171A; bind=STACK_SPACING→buttons/toggle/large/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/large/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/large/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/large/padding_vertical,HEIGHT→buttons/toggle/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_right,MIN_WIDTH→buttons/toggle/large/min_width |
| Size=Large, State=Pressed, On active=false/ic_beam | 67:22606 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Pressed, On active=false/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Pressed, On active=false/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Pressed, On active=false/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Pressed, On active=false/Label | 67:22607 | TEXT | size=80×40; xy=40,30; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Large, State=Pressed, On active=false/ic_arrow | 67:22608 → 67:22099 | INSTANCE | size=52×52; xy=136,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Pressed, On active=false/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Large, State=Pressed, On active=false/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/dark/secondary=#1B1C1ECC |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Large, State=Disabled, On active=false

- 원본 node: `67:22609`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Disabled, On active=false | 67:22609 | SYMBOL | size=160×100; xy=440,40; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/basic/disabled=#FFFFFF33; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/toggle/large/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/large/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/large/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/large/padding_vertical,HEIGHT→buttons/toggle/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/toggle/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/toggle/disabled_border,BORDER_LEFT_WEIGHT→buttons/toggle/disabled_border,BORDER_RIGHT_WEIGHT→buttons/toggle/disabled_border,MIN_WIDTH→buttons/toggle/large/min_width |
| Size=Large, State=Disabled, On active=false/ic_beam | 67:22610 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Disabled, On active=false/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/dark/tertiary=#1B1C1E4D |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Disabled, On active=false/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Disabled, On active=false/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/dark/quaternary=#13141752 |
| Size=Large, State=Disabled, On active=false/Label | 67:22611 | TEXT | size=80×40; xy=40,30; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Large, State=Disabled, On active=false/ic_arrow | 67:22612 → 67:22099 | INSTANCE | size=52×52; xy=136,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Disabled, On active=false/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Large, State=Disabled, On active=false/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Medium, State=Enabled, On active=false

- 원본 node: `67:22613`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, On active=false | 67:22613 | SYMBOL | size=139×80; xy=640,40; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/basic/enabled=#1314170D; bind=STACK_SPACING→buttons/toggle/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/medium/padding_vertical,HEIGHT→buttons/toggle/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_right,MIN_WIDTH→buttons/toggle/medium/min_width |
| Size=Medium, State=Enabled, On active=false/ic_beam | 67:22614 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Enabled, On active=false/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Enabled, On active=false/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, On active=false/Label | 67:22615 | TEXT | size=75×38; xy=32,21; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Medium, State=Enabled, On active=false/ic_arrow | 67:22616 → 67:22099 | INSTANCE | size=40×40; xy=121,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Enabled, On active=false/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Enabled, On active=false/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/secondary=#1B1C1ECC |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Medium, State=Pressed, On active=false

- 원본 node: `67:22617`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed, On active=false | 67:22617 | SYMBOL | size=139×80; xy=819,40; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/basic/pressed=#1314171A; bind=STACK_SPACING→buttons/toggle/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/medium/padding_vertical,HEIGHT→buttons/toggle/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_right,MIN_WIDTH→buttons/toggle/medium/min_width |
| Size=Medium, State=Pressed, On active=false/ic_beam | 67:22618 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Pressed, On active=false/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Pressed, On active=false/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, On active=false/Label | 67:22619 | TEXT | size=75×38; xy=32,21; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Medium, State=Pressed, On active=false/ic_arrow | 67:22620 → 67:22099 | INSTANCE | size=40×40; xy=121,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Pressed, On active=false/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Pressed, On active=false/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/secondary=#1B1C1ECC |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Medium, State=Disabled, On active=false

- 원본 node: `67:22621`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Disabled, On active=false | 67:22621 | SYMBOL | size=139×80; xy=998,40; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/basic/disabled=#FFFFFF33; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/toggle/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/medium/padding_vertical,HEIGHT→buttons/toggle/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/toggle/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/toggle/disabled_border,BORDER_LEFT_WEIGHT→buttons/toggle/disabled_border,BORDER_RIGHT_WEIGHT→buttons/toggle/disabled_border,MIN_WIDTH→buttons/toggle/medium/min_width |
| Size=Medium, State=Disabled, On active=false/ic_beam | 67:22622 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/dark/tertiary=#1B1C1E4D |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Disabled, On active=false/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Disabled, On active=false/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, State=Disabled, On active=false/Label | 67:22623 | TEXT | size=75×38; xy=32,21; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Medium, State=Disabled, On active=false/ic_arrow | 67:22624 → 67:22099 | INSTANCE | size=40×40; xy=121,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Disabled, On active=false/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Disabled, On active=false/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Small, State=Enabled, On active=false

- 원본 node: `67:22625`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled, On active=false | 67:22625 | SYMBOL | size=113×64; xy=1177,40; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/basic/enabled=#1314170D; bind=STACK_SPACING→buttons/toggle/small/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/small/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/small/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/small/padding_vertical,HEIGHT→buttons/toggle/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_right,MIN_WIDTH→buttons/toggle/small/min_width |
| Size=Small, State=Enabled, On active=false/ic_beam | 67:22626 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Enabled, On active=false/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Enabled, On active=false/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Enabled, On active=false/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, On active=false/Label | 67:22627 | TEXT | size=65×34; xy=24,15; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Small, State=Enabled, On active=false/ic_arrow | 67:22628 → 67:22099 | INSTANCE | size=32×32; xy=101,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Enabled, On active=false/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Enabled, On active=false/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/secondary=#1B1C1ECC |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Small, State=Pressed, On active=false

- 원본 node: `67:22629`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Pressed, On active=false | 67:22629 | SYMBOL | size=113×64; xy=1330,40; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/basic/pressed=#1314171A; bind=STACK_SPACING→buttons/toggle/small/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/small/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/small/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/small/padding_vertical,HEIGHT→buttons/toggle/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_right,MIN_WIDTH→buttons/toggle/small/min_width |
| Size=Small, State=Pressed, On active=false/ic_beam | 67:22630 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Pressed, On active=false/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Pressed, On active=false/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Pressed, On active=false/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, On active=false/Label | 67:22631 | TEXT | size=65×34; xy=24,15; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Small, State=Pressed, On active=false/ic_arrow | 67:22632 → 67:22099 | INSTANCE | size=32×32; xy=101,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Pressed, On active=false/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Pressed, On active=false/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/secondary=#1B1C1ECC |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Small, State=Disabled, On active=false

- 원본 node: `67:22633`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Disabled, On active=false | 67:22633 | SYMBOL | size=113×64; xy=1483,40; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/basic/disabled=#FFFFFF33; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/toggle/small/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/small/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/small/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/small/padding_vertical,HEIGHT→buttons/toggle/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/toggle/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/toggle/disabled_border,BORDER_LEFT_WEIGHT→buttons/toggle/disabled_border,BORDER_RIGHT_WEIGHT→buttons/toggle/disabled_border,MIN_WIDTH→buttons/toggle/small/min_width |
| Size=Small, State=Disabled, On active=false/ic_beam | 67:22634 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Disabled, On active=false/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/dark/tertiary=#1B1C1E4D |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Disabled, On active=false/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Disabled, On active=false/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/dark/quaternary=#13141752 |
| Size=Small, State=Disabled, On active=false/Label | 67:22635 | TEXT | size=65×34; xy=24,15; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Small, State=Disabled, On active=false/ic_arrow | 67:22636 → 67:22099 | INSTANCE | size=32×32; xy=101,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Disabled, On active=false/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Disabled, On active=false/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Large, State=Enabled, On active=true

- 원본 node: `67:22637`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Enabled, On active=true | 67:22637 | SYMBOL | size=160×100; xy=40,180; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/switch/enabled=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014; bind=STACK_SPACING→buttons/toggle/large/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/large/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/large/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/large/padding_vertical,HEIGHT→buttons/toggle/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_right,MIN_WIDTH→buttons/toggle/large/min_width |
| Size=Large, State=Enabled, On active=true/ic_beam | 67:22638 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Enabled, On active=true/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Enabled, On active=true/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Enabled, On active=true/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Enabled, On active=true/Label | 67:22639 | TEXT | size=80×40; xy=40,30; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Large, State=Enabled, On active=true/ic_arrow | 67:22640 → 67:22099 | INSTANCE | size=52×52; xy=136,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Enabled, On active=true/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Large, State=Enabled, On active=true/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Large, State=Pressed, On active=true

- 원본 node: `67:22641`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Pressed, On active=true | 67:22641 | SYMBOL | size=160×100; xy=240,180; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/switch/pressed=#FFFFFF80; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014; bind=STACK_SPACING→buttons/toggle/large/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/large/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/large/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/large/padding_vertical,HEIGHT→buttons/toggle/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_right,MIN_WIDTH→buttons/toggle/large/min_width |
| Size=Large, State=Pressed, On active=true/ic_beam | 67:22642 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Pressed, On active=true/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Pressed, On active=true/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Pressed, On active=true/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Pressed, On active=true/Label | 67:22643 | TEXT | size=80×40; xy=40,30; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Large, State=Pressed, On active=true/ic_arrow | 67:22644 → 67:22099 | INSTANCE | size=52×52; xy=136,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Pressed, On active=true/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Large, State=Pressed, On active=true/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Large, State=Disabled, On active=true

- 원본 node: `67:22645`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Disabled, On active=true | 67:22645 | SYMBOL | size=160×100; xy=440,180; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,16,40,16; gap=16; min={'x': 140, 'y': 0}; fill=button/switch/disabled=#FFFFFF4D; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/toggle/large/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/large/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/large/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/large/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/large/padding_vertical,HEIGHT→buttons/toggle/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/large/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/toggle/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/toggle/disabled_border,BORDER_LEFT_WEIGHT→buttons/toggle/disabled_border,BORDER_RIGHT_WEIGHT→buttons/toggle/disabled_border,MIN_WIDTH→buttons/toggle/large/min_width |
| Size=Large, State=Disabled, On active=true/ic_beam | 67:22646 → 67:22065 | INSTANCE | size=52×52; xy=40,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Disabled, On active=true/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=2.0452,9.1363; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=47.9092×33.7276; xy=0,0; fill=#000000FF |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=47.9092×33.7277; xy=0,0; fill=icon/dark/tertiary=#1B1C1E4D |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,15.3627; fill=#000000FF |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=23.0908×3.001; xy=0,0; fill=#000000FF |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=20.0909×0; xy=1.5003,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=17.7273×10.6364; xy=3.8639,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=17.7273×10.6364; xy=26.3184,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=17.7273×10.6364; xy=26.3184,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=17.7273×10.6364; xy=3.8639,21.591; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=20.0909×0; xy=26.3184,16.8628; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=31.8145×28.7178; xy=8.037,2.5043; fill=#FFFFFFFF |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=31.8145×28.7182; xy=0.0002,-0.0001; fill=#FFFFFFFF |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Vector | 67:22080 | VECTOR | size=11.8182×23.6364; xy=10.9548,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Disabled, On active=true/ic_beam/Path/Vector | 67:22081 | VECTOR | size=11.8182×23.6364; xy=25.1366,5.0456; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Large, State=Disabled, On active=true/ic_beam/Icon | 67:22082 | VECTOR | size=48.1591×33.9778; xy=1.9204,9.0112; fill=icon/dark/quaternary=#13141752 |
| Size=Large, State=Disabled, On active=true/Label | 67:22647 | TEXT | size=80×40; xy=40,30; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Large, State=Disabled, On active=true/ic_arrow | 67:22648 → 67:22099 | INSTANCE | size=52×52; xy=136,24; hidden; bind=WIDTH→buttons/toggle/large/icon_sqaure,HEIGHT→buttons/toggle/large/icon_sqaure |
| Size=Large, State=Disabled, On active=true/ic_arrow/Path | 67:22100 | VECTOR | size=15.1667×30.3333; xy=18.4167,10.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Large, State=Disabled, On active=true/ic_arrow/Icon | 67:22101 | VECTOR | size=19.5×34.6667; xy=16.25,8.6667; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Medium, State=Enabled, On active=true

- 원본 node: `67:22649`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, On active=true | 67:22649 | SYMBOL | size=139×80; xy=640,180; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/switch/enabled=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014; bind=STACK_SPACING→buttons/toggle/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/medium/padding_vertical,HEIGHT→buttons/toggle/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_right,MIN_WIDTH→buttons/toggle/medium/min_width |
| Size=Medium, State=Enabled, On active=true/common/add/l | 67:22650 → 67:22167 | INSTANCE | size=64×64; xy=200,8; hidden |
| Size=Medium, State=Enabled, On active=true/common/add/l/Icon (Stroke) | 67:22168 | VECTOR | size=33.2843×33.2843; xy=32,8; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Enabled, On active=true/ic_beam | 67:22651 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Enabled, On active=true/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Enabled, On active=true/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, On active=true/Label | 67:22652 | TEXT | size=75×38; xy=32,21; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Medium, State=Enabled, On active=true/common/add/l | 67:22653 → 67:22167 | INSTANCE | size=64×64; xy=416,8; hidden |
| Size=Medium, State=Enabled, On active=true/common/add/l/Icon (Stroke) | 67:22168 | VECTOR | size=33.2843×33.2843; xy=32,8; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Enabled, On active=true/ic_arrow | 67:22654 → 67:22099 | INSTANCE | size=40×40; xy=121,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Enabled, On active=true/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Enabled, On active=true/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Medium, State=Pressed, On active=true

- 원본 node: `67:22655`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed, On active=true | 67:22655 | SYMBOL | size=139×80; xy=819,180; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/switch/pressed=#FFFFFF80; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014; bind=STACK_SPACING→buttons/toggle/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/medium/padding_vertical,HEIGHT→buttons/toggle/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_right,MIN_WIDTH→buttons/toggle/medium/min_width |
| Size=Medium, State=Pressed, On active=true/common/add/l | 67:22656 → 67:22167 | INSTANCE | size=64×64; xy=200,8; hidden |
| Size=Medium, State=Pressed, On active=true/common/add/l/Icon (Stroke) | 67:22168 | VECTOR | size=33.2843×33.2843; xy=32,8; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Pressed, On active=true/ic_beam | 67:22657 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Pressed, On active=true/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Pressed, On active=true/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, On active=true/Label | 67:22658 | TEXT | size=75×38; xy=32,21; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Medium, State=Pressed, On active=true/common/add/l | 67:22659 → 67:22167 | INSTANCE | size=64×64; xy=416,8; hidden |
| Size=Medium, State=Pressed, On active=true/common/add/l/Icon (Stroke) | 67:22168 | VECTOR | size=33.2843×33.2843; xy=32,8; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Pressed, On active=true/ic_arrow | 67:22660 → 67:22099 | INSTANCE | size=40×40; xy=121,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Pressed, On active=true/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Pressed, On active=true/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Medium, State=Disabled, On active=true

- 원본 node: `67:22661`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Disabled, On active=true | 67:22661 | SYMBOL | size=139×80; xy=998,180; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 0}; fill=button/switch/disabled=#FFFFFF4D; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/toggle/medium/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/medium/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/medium/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/medium/padding_vertical,HEIGHT→buttons/toggle/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/medium/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/toggle/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/toggle/disabled_border,BORDER_LEFT_WEIGHT→buttons/toggle/disabled_border,BORDER_RIGHT_WEIGHT→buttons/toggle/disabled_border,MIN_WIDTH→buttons/toggle/medium/min_width |
| Size=Medium, State=Disabled, On active=true/common/add/l | 67:22662 → 67:22167 | INSTANCE | size=64×64; xy=200,8; hidden |
| Size=Medium, State=Disabled, On active=true/common/add/l/Icon (Stroke) | 67:22168 | VECTOR | size=33.2843×33.2843; xy=32,8; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Disabled, On active=true/ic_beam | 67:22663 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=1.2268,6.6822; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=#000000FF |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5459×26.6357; xy=0,0; fill=icon/dark/tertiary=#1B1C1E4D |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8167; fill=#000000FF |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5004,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3186,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5914,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5914,1.4996; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3186,16.9542; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5914,13.3171; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0908; xy=6.5292,2.2718; fill=#FFFFFFFF |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=-0.0004,0.0002; fill=#FFFFFFFF |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7732,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Disabled, On active=true/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6823,4.2269; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Medium, State=Disabled, On active=true/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, State=Disabled, On active=true/Label | 67:22664 | TEXT | size=75×38; xy=32,21; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Medium, State=Disabled, On active=true/common/add/l | 67:22665 → 67:22167 | INSTANCE | size=64×64; xy=416,8; hidden |
| Size=Medium, State=Disabled, On active=true/common/add/l/Icon (Stroke) | 67:22168 | VECTOR | size=33.2843×33.2843; xy=32,8; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Disabled, On active=true/ic_arrow | 67:22666 → 67:22099 | INSTANCE | size=40×40; xy=121,20; hidden; bind=WIDTH→buttons/toggle/medium/icon_square,HEIGHT→buttons/toggle/medium/icon_square |
| Size=Medium, State=Disabled, On active=true/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Disabled, On active=true/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Small, State=Enabled, On active=true

- 원본 node: `67:22667`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled, On active=true | 67:22667 | SYMBOL | size=113×64; xy=1177,180; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/switch/enabled=#FFFFFFFF; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014; bind=STACK_SPACING→buttons/toggle/small/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/small/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/small/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/small/padding_vertical,HEIGHT→buttons/toggle/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_right,MIN_WIDTH→buttons/toggle/small/min_width |
| Size=Small, State=Enabled, On active=true/ic_beam | 67:22668 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Enabled, On active=true/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Enabled, On active=true/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Enabled, On active=true/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, On active=true/Label | 67:22669 | TEXT | size=65×34; xy=24,15; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Small, State=Enabled, On active=true/ic_arrow | 67:22670 → 67:22099 | INSTANCE | size=32×32; xy=101,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Enabled, On active=true/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Enabled, On active=true/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Small, State=Pressed, On active=true

- 원본 node: `67:22671`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Pressed, On active=true | 67:22671 | SYMBOL | size=113×64; xy=1330,180; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/switch/pressed=#FFFFFF80; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014; bind=STACK_SPACING→buttons/toggle/small/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/small/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/small/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/small/padding_vertical,HEIGHT→buttons/toggle/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_right,MIN_WIDTH→buttons/toggle/small/min_width |
| Size=Small, State=Pressed, On active=true/ic_beam | 67:22672 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Pressed, On active=true/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Pressed, On active=true/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Pressed, On active=true/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, On active=true/Label | 67:22673 | TEXT | size=65×34; xy=24,15; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Small, State=Pressed, On active=true/ic_arrow | 67:22674 → 67:22099 | INSTANCE | size=32×32; xy=101,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Pressed, On active=true/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Pressed, On active=true/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486150/ivi_toggle_button/Size=Small, State=Disabled, On active=true

- 원본 node: `67:22675`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"On active","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Disabled, On active=true | 67:22675 | SYMBOL | size=113×64; xy=1483,180; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,8,24,8; gap=12; min={'x': 100, 'y': 0}; fill=button/basic/disabled=#FFFFFF33; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; bind=STACK_SPACING→buttons/toggle/small/gap_horizontal,STACK_PADDING_LEFT→buttons/toggle/small/padding_horizontal,STACK_PADDING_TOP→buttons/toggle/small/padding_vertical,STACK_PADDING_RIGHT→buttons/toggle/small/padding_horizontal,STACK_PADDING_BOTTOM→buttons/toggle/small/padding_vertical,HEIGHT→buttons/toggle/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/toggle/small/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/toggle/disabled_border,BORDER_BOTTOM_WEIGHT→buttons/toggle/disabled_border,BORDER_LEFT_WEIGHT→buttons/toggle/disabled_border,BORDER_RIGHT_WEIGHT→buttons/toggle/disabled_border,MIN_WIDTH→buttons/toggle/small/min_width |
| Size=Small, State=Disabled, On active=true/ic_beam | 67:22676 → 67:22065 | INSTANCE | size=32×32; xy=24,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Disabled, On active=true/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0.6819,5.0455; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=#000000FF |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=30.6357×21.909; xy=0,0; fill=icon/dark/tertiary=#1B1C1E4D |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,9.4534; fill=#000000FF |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=15.3633×3.001; xy=0,0; fill=#000000FF |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=12.3636×0; xy=1.4999,1.5011; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=10.9091×6.5455; xy=2.9545,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=10.9091×6.5455; xy=16.7726,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=10.9091×6.5455; xy=16.7726,1.4999; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=10.9091×6.5455; xy=2.9545,13.8636; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=12.3636×0; xy=16.7726,10.9539; stroke=#000000FF; strokeWidth=3/CENTER |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=19.5781×17.6729; xy=5.5224,2.1175; fill=#FFFFFFFF |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=19.5782×17.6727; xy=0.0003,0.0004; fill=#FFFFFFFF |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Vector | 67:22080 | VECTOR | size=7.2727×14.5455; xy=7.3181,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Disabled, On active=true/ic_beam/Path/Vector | 67:22081 | VECTOR | size=7.2727×14.5455; xy=16.0454,3.6817; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Size=Small, State=Disabled, On active=true/ic_beam/Icon | 67:22082 | VECTOR | size=29.6364×20.9094; xy=1.1818,5.5453; fill=icon/dark/quaternary=#13141752 |
| Size=Small, State=Disabled, On active=true/Label | 67:22677 | TEXT | size=65×34; xy=24,15; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Small, State=Disabled, On active=true/ic_arrow | 67:22678 → 67:22099 | INSTANCE | size=32×32; xy=101,16; hidden; bind=WIDTH→buttons/toggle/small/icon_sqaure,HEIGHT→buttons/toggle/small/icon_sqaure |
| Size=Small, State=Disabled, On active=true/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Disabled, On active=true/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486151/ivi_text_button/Size=Medium, State=Enabled

- 원본 node: `67:22682`

- 공개 properties: `[{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled | 67:22682 | SYMBOL | size=75×38; xy=20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→buttons/text/medium/gap |
| Size=Medium, State=Enabled/ic_arrow | 67:22683 → 67:22096 | INSTANCE | size=32×32; xy=0,3; hidden; bind=WIDTH→buttons/text/medium/icon,HEIGHT→buttons/text/medium/icon |
| Size=Medium, State=Enabled/ic_arrow/Path | 67:22097 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Enabled/ic_arrow/Icon | 67:22098 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=regulation/blue=#2E5CFFFF |
| Size=Medium, State=Enabled/Label | 67:22684 | TEXT | size=75×38; xy=0,0; fill=informative/positive=#0064FFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=RIGHT; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Medium, State=Enabled/ic_arrow | 67:22685 → 67:22099 | INSTANCE | size=32×32; xy=78,3; hidden; bind=WIDTH→buttons/text/medium/icon,HEIGHT→buttons/text/medium/icon |
| Size=Medium, State=Enabled/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Enabled/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=regulation/blue=#2E5CFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486151/ivi_text_button/Size=Medium, State=Pressed

- 원본 node: `67:22686`

- 공개 properties: `[{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed | 67:22686 | SYMBOL | size=75×38; xy=135,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→buttons/text/medium/gap |
| Size=Medium, State=Pressed/ic_arrow | 67:22687 → 67:22096 | INSTANCE | size=32×32; xy=0,3; hidden; bind=WIDTH→buttons/text/medium/icon,HEIGHT→buttons/text/medium/icon |
| Size=Medium, State=Pressed/ic_arrow/Path | 67:22097 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Pressed/ic_arrow/Icon | 67:22098 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=regulation/blue=#2E5CFFFF |
| Size=Medium, State=Pressed/Label | 67:22688 | TEXT | size=75×38; xy=0,0; fill=informative/positive=#0064FFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=RIGHT; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Medium, State=Pressed/ic_arrow | 67:22689 → 67:22099 | INSTANCE | size=32×32; xy=78,3; hidden; bind=WIDTH→buttons/text/medium/icon,HEIGHT→buttons/text/medium/icon |
| Size=Medium, State=Pressed/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Pressed/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=regulation/blue=#2E5CFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486151/ivi_text_button/Size=Medium, State=Disabled

- 원본 node: `67:22690`

- 공개 properties: `[{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Disabled | 67:22690 | SYMBOL | size=75×38; xy=250,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→buttons/text/medium/gap |
| Size=Medium, State=Disabled/ic_arrow | 67:22691 → 67:22096 | INSTANCE | size=32×32; xy=0,3; hidden; bind=WIDTH→buttons/text/medium/icon,HEIGHT→buttons/text/medium/icon |
| Size=Medium, State=Disabled/ic_arrow/Path | 67:22097 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Disabled/ic_arrow/Icon | 67:22098 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Medium, State=Disabled/Label | 67:22692 | TEXT | size=75×38; xy=0,0; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=RIGHT; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Medium, State=Disabled/ic_arrow | 67:22693 → 67:22099 | INSTANCE | size=32×32; xy=78,3; hidden; bind=WIDTH→buttons/text/medium/icon,HEIGHT→buttons/text/medium/icon |
| Size=Medium, State=Disabled/ic_arrow/Path | 67:22100 | VECTOR | size=9.3333×18.6667; xy=11.3333,6.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Disabled/ic_arrow/Icon | 67:22101 | VECTOR | size=12×21.3333; xy=10,5.3333; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486151/ivi_text_button/Size=Small, State=Enabled

- 원본 node: `67:22694`

- 공개 properties: `[{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled | 67:22694 | SYMBOL | size=65×34; xy=365,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=4; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→buttons/text/small/gap |
| Size=Small, State=Enabled/ic_arrow | 67:22695 → 67:22096 | INSTANCE | size=28×28; xy=0,2; hidden; bind=WIDTH→buttons/text/small/icon,HEIGHT→buttons/text/small/icon |
| Size=Small, State=Enabled/ic_arrow/Path | 67:22097 | VECTOR | size=8.1667×16.3333; xy=9.9167,5.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Enabled/ic_arrow/Icon | 67:22098 | VECTOR | size=10.5×18.6667; xy=8.75,4.6667; fill=regulation/blue=#2E5CFFFF |
| Size=Small, State=Enabled/Label | 67:22696 | TEXT | size=65×34; xy=0,0; fill=informative/positive=#0064FFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=RIGHT; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Small, State=Enabled/ic_arrow | 67:22697 → 67:22099 | INSTANCE | size=28×28; xy=64,2; hidden; bind=WIDTH→buttons/text/small/icon,HEIGHT→buttons/text/small/icon |
| Size=Small, State=Enabled/ic_arrow/Path | 67:22100 | VECTOR | size=8.1667×16.3333; xy=9.9167,5.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Enabled/ic_arrow/Icon | 67:22101 | VECTOR | size=10.5×18.6667; xy=8.75,4.6667; fill=regulation/blue=#2E5CFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486151/ivi_text_button/Size=Small, State=Pressed

- 원본 node: `67:22698`

- 공개 properties: `[{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Pressed | 67:22698 | SYMBOL | size=65×34; xy=470,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=4; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→buttons/text/small/gap |
| Size=Small, State=Pressed/ic_arrow | 67:22699 → 67:22096 | INSTANCE | size=28×28; xy=0,2; hidden; bind=WIDTH→buttons/text/small/icon,HEIGHT→buttons/text/small/icon |
| Size=Small, State=Pressed/ic_arrow/Path | 67:22097 | VECTOR | size=8.1667×16.3333; xy=9.9167,5.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Pressed/ic_arrow/Icon | 67:22098 | VECTOR | size=10.5×18.6667; xy=8.75,4.6667; fill=regulation/blue=#2E5CFFFF |
| Size=Small, State=Pressed/Label | 67:22700 | TEXT | size=65×34; xy=0,0; fill=informative/positive=#0064FFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=RIGHT; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Small, State=Pressed/ic_arrow | 67:22701 → 67:22099 | INSTANCE | size=28×28; xy=64,2; hidden; bind=WIDTH→buttons/text/small/icon,HEIGHT→buttons/text/small/icon |
| Size=Small, State=Pressed/ic_arrow/Path | 67:22100 | VECTOR | size=8.1667×16.3333; xy=9.9167,5.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Pressed/ic_arrow/Icon | 67:22101 | VECTOR | size=10.5×18.6667; xy=8.75,4.6667; fill=regulation/blue=#2E5CFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486151/ivi_text_button/Size=Small, State=Disabled

- 원본 node: `67:22702`

- 공개 properties: `[{"name":"Prefix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Suffix","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Disabled | 67:22702 | SYMBOL | size=65×34; xy=575,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=4; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→buttons/text/small/gap |
| Size=Small, State=Disabled/ic_arrow | 67:22703 → 67:22096 | INSTANCE | size=28×28; xy=0,2; hidden; bind=WIDTH→buttons/text/small/icon,HEIGHT→buttons/text/small/icon |
| Size=Small, State=Disabled/ic_arrow/Path | 67:22097 | VECTOR | size=8.1667×16.3333; xy=9.9167,5.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Disabled/ic_arrow/Icon | 67:22098 | VECTOR | size=10.5×18.6667; xy=8.75,4.6667; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Small, State=Disabled/Label | 67:22704 | TEXT | size=65×34; xy=0,0; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=RIGHT; textAlignVertical=CENTER; font=Asta Sans/Bold/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Strong; maxLines=2; truncate=ENDING; text='Label' |
| Size=Small, State=Disabled/ic_arrow | 67:22705 → 67:22099 | INSTANCE | size=28×28; xy=64,2; hidden; bind=WIDTH→buttons/text/small/icon,HEIGHT→buttons/text/small/icon |
| Size=Small, State=Disabled/ic_arrow/Path | 67:22100 | VECTOR | size=8.1667×16.3333; xy=9.9167,5.8333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Disabled/ic_arrow/Icon | 67:22101 | VECTOR | size=10.5×18.6667; xy=8.75,4.6667; fill=icon/dark/quaternary=#1B1C1E52 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Basic, State=Enabled, Size=Medium

- 원본 node: `67:22709`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Basic, State=Enabled, Size=Medium | 67:22709 | SYMBOL | size=80×80; xy=20,20; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Type=Basic, State=Enabled, Size=Medium/ic_plus | 67:22710 → 67:22174 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Basic, State=Enabled, Size=Medium/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=38.5996×38.5996; xy=8.7,8.7; hidden; fill=icon/dark/primary=#131417FF |
| Type=Basic, State=Enabled, Size=Medium/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=35×0; xy=1.8,19.3; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Enabled, Size=Medium/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×35; xy=19.3,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Enabled, Size=Medium/ic_plus/Icon | 67:22178 | VECTOR | size=39.2×39.2; xy=8.3999,8.4; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Basic, State=Pressed, Size=Medium

- 원본 node: `67:22711`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Basic, State=Pressed, Size=Medium | 67:22711 | SYMBOL | size=80×80; xy=120,20; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/pressed=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Type=Basic, State=Pressed, Size=Medium/ic_plus | 67:22712 → 67:22174 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Basic, State=Pressed, Size=Medium/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=38.5996×38.5996; xy=8.7,8.7; hidden; fill=icon/dark/primary=#131417FF |
| Type=Basic, State=Pressed, Size=Medium/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=35×0; xy=1.8,19.3; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Pressed, Size=Medium/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×35; xy=19.3,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Pressed, Size=Medium/ic_plus/Icon | 67:22178 | VECTOR | size=39.2×39.2; xy=8.3999,8.4; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Basic, State=Diabled, Size=Medium

- 원본 node: `67:22713`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Basic, State=Diabled, Size=Medium | 67:22713 | SYMBOL | size=80×80; xy=220,20; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/disabled=#FFFFFF33; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Type=Basic, State=Diabled, Size=Medium/ic_plus | 67:22714 → 67:22174 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Basic, State=Diabled, Size=Medium/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=38.5996×38.5996; xy=8.7,8.7; hidden; fill=icon/dark/primary=#131417FF |
| Type=Basic, State=Diabled, Size=Medium/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=35×0; xy=1.8,19.3; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Diabled, Size=Medium/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×35; xy=19.3,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Diabled, Size=Medium/ic_plus/Icon | 67:22178 | VECTOR | size=39.2×39.2; xy=8.3999,8.4; fill=icon/dark/quaternary=#13141752 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Basic, State=Enabled, Size=Small

- 원본 node: `67:22715`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Basic, State=Enabled, Size=Small | 67:22715 | SYMBOL | size=64×64; xy=320,20; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| Type=Basic, State=Enabled, Size=Small/ic_plus | 67:22716 → 67:22174 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Type=Basic, State=Enabled, Size=Small/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=31.0996×31.0996; xy=6.45,6.45; hidden; fill=icon/dark/primary=#131417FF |
| Type=Basic, State=Enabled, Size=Small/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=27.5×0; xy=1.8,15.55; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Enabled, Size=Small/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×27.5; xy=15.55,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Enabled, Size=Small/ic_plus/Icon | 67:22178 | VECTOR | size=30.8×30.8; xy=6.6,6.6; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Basic, State=Pressed, Size=Small

- 원본 node: `67:22717`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Basic, State=Pressed, Size=Small | 67:22717 | SYMBOL | size=64×64; xy=404,20; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/pressed=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| Type=Basic, State=Pressed, Size=Small/ic_plus | 67:22718 → 67:22174 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Type=Basic, State=Pressed, Size=Small/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=31.0996×31.0996; xy=6.45,6.45; hidden; fill=icon/dark/primary=#131417FF |
| Type=Basic, State=Pressed, Size=Small/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=27.5×0; xy=1.8,15.55; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Pressed, Size=Small/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×27.5; xy=15.55,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Pressed, Size=Small/ic_plus/Icon | 67:22178 | VECTOR | size=30.8×30.8; xy=6.6,6.6; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Basic, State=Diabled, Size=Small

- 원본 node: `67:22719`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Basic, State=Diabled, Size=Small | 67:22719 | SYMBOL | size=64×64; xy=488,20; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/disabled=#FFFFFF33; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| Type=Basic, State=Diabled, Size=Small/ic_plus | 67:22720 → 67:22174 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Type=Basic, State=Diabled, Size=Small/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=31.0996×31.0996; xy=6.45,6.45; hidden; fill=icon/dark/primary=#131417FF |
| Type=Basic, State=Diabled, Size=Small/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=27.5×0; xy=1.8,15.55; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Diabled, Size=Small/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×27.5; xy=15.55,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Basic, State=Diabled, Size=Small/ic_plus/Icon | 67:22178 | VECTOR | size=30.8×30.8; xy=6.6,6.6; fill=icon/dark/quaternary=#13141752 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Plain, State=Enabled, Size=Medium

- 원본 node: `67:22721`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Plain, State=Enabled, Size=Medium | 67:22721 | SYMBOL | size=80×80; xy=20,120; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Type=Plain, State=Enabled, Size=Medium/ic_plus | 67:22722 → 67:22174 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Plain, State=Enabled, Size=Medium/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=38.5996×38.5996; xy=8.7,8.7; hidden; fill=icon/dark/primary=#131417FF |
| Type=Plain, State=Enabled, Size=Medium/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=35×0; xy=1.8,19.3; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Enabled, Size=Medium/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×35; xy=19.3,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Enabled, Size=Medium/ic_plus/Icon | 67:22178 | VECTOR | size=39.2×39.2; xy=8.3999,8.4; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Plain, State=Pressed, Size=Medium

- 원본 node: `67:22723`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Plain, State=Pressed, Size=Medium | 67:22723 | SYMBOL | size=80×80; xy=120,120; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/pressed=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Type=Plain, State=Pressed, Size=Medium/ic_plus | 67:22724 → 67:22174 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Plain, State=Pressed, Size=Medium/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=38.5996×38.5996; xy=8.7,8.7; hidden; fill=icon/dark/primary=#131417FF |
| Type=Plain, State=Pressed, Size=Medium/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=35×0; xy=1.8,19.3; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Pressed, Size=Medium/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×35; xy=19.3,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Pressed, Size=Medium/ic_plus/Icon | 67:22178 | VECTOR | size=39.2×39.2; xy=8.3999,8.4; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Plain, State=Diabled, Size=Medium

- 원본 node: `67:22725`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Plain, State=Diabled, Size=Medium | 67:22725 | SYMBOL | size=80×80; xy=220,120; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Type=Plain, State=Diabled, Size=Medium/ic_plus | 67:22726 → 67:22174 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Plain, State=Diabled, Size=Medium/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=38.5996×38.5996; xy=8.7,8.7; hidden; fill=icon/dark/primary=#131417FF |
| Type=Plain, State=Diabled, Size=Medium/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=35×0; xy=1.8,19.3; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Diabled, Size=Medium/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×35; xy=19.3,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Diabled, Size=Medium/ic_plus/Icon | 67:22178 | VECTOR | size=39.2×39.2; xy=8.3999,8.4; fill=icon/dark/quaternary=#13141752 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Plain, State=Enabled, Size=Small

- 원본 node: `67:22727`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Plain, State=Enabled, Size=Small | 67:22727 | SYMBOL | size=64×64; xy=320,120; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| Type=Plain, State=Enabled, Size=Small/ic_plus | 67:22728 → 67:22174 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Type=Plain, State=Enabled, Size=Small/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=31.0996×31.0996; xy=6.45,6.45; hidden; fill=icon/dark/primary=#131417FF |
| Type=Plain, State=Enabled, Size=Small/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=27.5×0; xy=1.8,15.55; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Enabled, Size=Small/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×27.5; xy=15.55,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Enabled, Size=Small/ic_plus/Icon | 67:22178 | VECTOR | size=30.8×30.8; xy=6.6,6.6; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Plain, State=Pressed, Size=Small

- 원본 node: `67:22729`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Plain, State=Pressed, Size=Small | 67:22729 | SYMBOL | size=64×64; xy=404,120; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/pressed=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| Type=Plain, State=Pressed, Size=Small/ic_plus | 67:22730 → 67:22174 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Type=Plain, State=Pressed, Size=Small/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=31.0996×31.0996; xy=6.45,6.45; hidden; fill=icon/dark/primary=#131417FF |
| Type=Plain, State=Pressed, Size=Small/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=27.5×0; xy=1.8,15.55; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Pressed, Size=Small/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×27.5; xy=15.55,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Pressed, Size=Small/ic_plus/Icon | 67:22178 | VECTOR | size=30.8×30.8; xy=6.6,6.6; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Plain, State=Diabled, Size=Small

- 원본 node: `67:22731`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Plain, State=Diabled, Size=Small | 67:22731 | SYMBOL | size=64×64; xy=488,120; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| Type=Plain, State=Diabled, Size=Small/ic_plus | 67:22732 → 67:22174 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Type=Plain, State=Diabled, Size=Small/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=31.0996×31.0996; xy=6.45,6.45; hidden; fill=icon/dark/primary=#131417FF |
| Type=Plain, State=Diabled, Size=Small/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=27.5×0; xy=1.8,15.55; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Diabled, Size=Small/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×27.5; xy=15.55,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Plain, State=Diabled, Size=Small/ic_plus/Icon | 67:22178 | VECTOR | size=30.8×30.8; xy=6.6,6.6; fill=icon/dark/quaternary=#13141752 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Circle, State=Enabled, Size=Medium

- 원본 node: `67:22733`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Circle, State=Enabled, Size=Medium | 67:22733 | SYMBOL | size=80×80; xy=20,220; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_right |
| Type=Circle, State=Enabled, Size=Medium/ic_plus | 67:22734 → 67:22174 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Circle, State=Enabled, Size=Medium/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=38.5996×38.5996; xy=8.7,8.7; hidden; fill=icon/dark/primary=#131417FF |
| Type=Circle, State=Enabled, Size=Medium/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=35×0; xy=1.8,19.3; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Enabled, Size=Medium/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×35; xy=19.3,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Enabled, Size=Medium/ic_plus/Icon | 67:22178 | VECTOR | size=39.2×39.2; xy=8.3999,8.4; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Circle, State=Pressed, Size=Medium

- 원본 node: `67:22735`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Circle, State=Pressed, Size=Medium | 67:22735 | SYMBOL | size=80×80; xy=120,220; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/pressed=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_right |
| Type=Circle, State=Pressed, Size=Medium/ic_plus | 67:22736 → 67:22174 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Circle, State=Pressed, Size=Medium/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=38.5996×38.5996; xy=8.7,8.7; hidden; fill=icon/dark/primary=#131417FF |
| Type=Circle, State=Pressed, Size=Medium/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=35×0; xy=1.8,19.3; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Pressed, Size=Medium/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×35; xy=19.3,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Pressed, Size=Medium/ic_plus/Icon | 67:22178 | VECTOR | size=39.2×39.2; xy=8.3999,8.4; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Circle, State=Diabled, Size=Medium

- 원본 node: `67:22737`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Circle, State=Diabled, Size=Medium | 67:22737 | SYMBOL | size=80×80; xy=220,220; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/disabled=#FFFFFF33; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_right |
| Type=Circle, State=Diabled, Size=Medium/ic_plus | 67:22738 → 67:22174 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Circle, State=Diabled, Size=Medium/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=38.5996×38.5996; xy=8.7,8.7; hidden; fill=icon/dark/primary=#131417FF |
| Type=Circle, State=Diabled, Size=Medium/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=35×0; xy=1.8,19.3; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Diabled, Size=Medium/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×35; xy=19.3,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Diabled, Size=Medium/ic_plus/Icon | 67:22178 | VECTOR | size=39.2×39.2; xy=8.3999,8.4; fill=icon/dark/quaternary=#13141752 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Circle, State=Enabled, Size=Small

- 원본 node: `67:22739`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Circle, State=Enabled, Size=Small | 67:22739 | SYMBOL | size=64×64; xy=320,220; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_right |
| Type=Circle, State=Enabled, Size=Small/ic_plus | 67:22740 → 67:22174 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Type=Circle, State=Enabled, Size=Small/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=31.0996×31.0996; xy=6.45,6.45; hidden; fill=icon/dark/primary=#131417FF |
| Type=Circle, State=Enabled, Size=Small/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=27.5×0; xy=1.8,15.55; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Enabled, Size=Small/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×27.5; xy=15.55,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Enabled, Size=Small/ic_plus/Icon | 67:22178 | VECTOR | size=30.8×30.8; xy=6.6,6.6; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Circle, State=Pressed, Size=Small

- 원본 node: `67:22741`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Circle, State=Pressed, Size=Small | 67:22741 | SYMBOL | size=64×64; xy=404,220; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/pressed=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_right |
| Type=Circle, State=Pressed, Size=Small/ic_plus | 67:22742 → 67:22174 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Type=Circle, State=Pressed, Size=Small/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=31.0996×31.0996; xy=6.45,6.45; hidden; fill=icon/dark/primary=#131417FF |
| Type=Circle, State=Pressed, Size=Small/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=27.5×0; xy=1.8,15.55; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Pressed, Size=Small/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×27.5; xy=15.55,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Pressed, Size=Small/ic_plus/Icon | 67:22178 | VECTOR | size=30.8×30.8; xy=6.6,6.6; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486152/ivi_icon_button/Type=Circle, State=Diabled, Size=Small

- 원본 node: `67:22743`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Circle, State=Diabled, Size=Small | 67:22743 | SYMBOL | size=64×64; xy=488,220; r(TL,TR,BR,BL)=999,999,999,999; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=button/basic/disabled=#FFFFFF33; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/circle_radius_bottom_right |
| Type=Circle, State=Diabled, Size=Small/ic_plus | 67:22744 → 67:22174 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Type=Circle, State=Diabled, Size=Small/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=31.0996×31.0996; xy=6.45,6.45; hidden; fill=icon/dark/primary=#131417FF |
| Type=Circle, State=Diabled, Size=Small/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=27.5×0; xy=1.8,15.55; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Diabled, Size=Small/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×27.5; xy=15.55,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Circle, State=Diabled, Size=Small/ic_plus/Icon | 67:22178 | VECTOR | size=30.8×30.8; xy=6.6,6.6; fill=icon/dark/quaternary=#13141752 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486155/ivi_numeric_keypad/Type=Number, State=Enabled

- 원본 node: `67:22918`

- 공개 properties: `[{"name":"Number","type":"TEXT","initialValue":{"textValue":{"characters":"1","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Number, State=Enabled | 67:22918 | SYMBOL | size=200×108; xy=58,41; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; min={'x': 200, 'y': 0}; fill=keyboard/normal/primary_normal=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; bind=HEIGHT→buttons/keypad/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/keypad/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/keypad/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/keypad/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/keypad/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/keypad/border,BORDER_BOTTOM_WEIGHT→buttons/keypad/border,BORDER_LEFT_WEIGHT→buttons/keypad/border,BORDER_RIGHT_WEIGHT→buttons/keypad/border,MIN_WIDTH→buttons/keypad/min_width |
| Type=Number, State=Enabled/1 | 67:22919 | TEXT | size=200×72; xy=0,18; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/ExtraBold/56; line=72/PIXELS; letter=0/PERCENT; textStyle=Headline/Medium/Extra_Strong; maxLines=1; truncate=ENDING; text='1' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486155/ivi_numeric_keypad/Type=Delete, State=Enabled

- 원본 node: `67:22920`

- 공개 properties: `[{"name":"Number","type":"TEXT","initialValue":{"textValue":{"characters":"1","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Delete, State=Enabled | 67:22920 | SYMBOL | size=200×108; xy=298,41; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; min={'x': 200, 'y': 0}; fill=surface/accent=#E0E1E6FF; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; bind=HEIGHT→buttons/keypad/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/keypad/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/keypad/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/keypad/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/keypad/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/keypad/border,BORDER_BOTTOM_WEIGHT→buttons/keypad/border,BORDER_LEFT_WEIGHT→buttons/keypad/border,BORDER_RIGHT_WEIGHT→buttons/keypad/border,MIN_WIDTH→buttons/keypad/min_width |
| Type=Delete, State=Enabled/ic_close | 67:22921 → 67:22427 | INSTANCE | size=48×48; xy=76,30; bind=WIDTH→buttons/keypad/icon,HEIGHT→buttons/keypad/icon |
| Type=Delete, State=Enabled/ic_close/Path | 67:22428 | BOOLEAN_OPERATION | size=44.8878×32; xy=1.1122,8; hidden; fill=icon/dark/primary=#131417FF |
| Type=Delete, State=Enabled/ic_close/Path/Rectangle 346244404 | 67:22429 | VECTOR | size=46×32; xy=-1.1122,0; r=3; fill=icon/dark/primary=#131417FF |
| Type=Delete, State=Enabled/ic_close/Path/Path | 67:22430 | BOOLEAN_OPERATION | size=14.9998×14.9998; xy=20.3879,8.5001; fill=icon/light/primary=#FFFFFFFF |
| Type=Delete, State=Enabled/ic_close/Path/Path/Vector 5947 | 67:22431 | VECTOR | size=12×12; xy=1.4999,1.4999; stroke=icon/light/primary=#FFFFFFFF; strokeWidth=3/CENTER |
| Type=Delete, State=Enabled/ic_close/Path/Path/Vector 5948 | 67:22432 | VECTOR | size=12×12; xy=1.4999,1.4999; stroke=icon/light/primary=#FFFFFFFF; strokeWidth=3/CENTER |
| Type=Delete, State=Enabled/ic_close/Icon | 67:22433 | VECTOR | size=44.8878×32; xy=1.1122,8; fill=icon/dark/secondary=#1B1C1ED6 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486155/ivi_numeric_keypad/Type=Clear, State=Enabled

- 원본 node: `67:22922`

- 공개 properties: `[{"name":"Number","type":"TEXT","initialValue":{"textValue":{"characters":"1","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Clear, State=Enabled | 67:22922 | SYMBOL | size=200×108; xy=538,41; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; min={'x': 200, 'y': 0}; fill=surface/accent=#E0E1E6FF; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; bind=HEIGHT→buttons/keypad/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/keypad/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/keypad/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/keypad/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/keypad/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/keypad/border,BORDER_BOTTOM_WEIGHT→buttons/keypad/border,BORDER_LEFT_WEIGHT→buttons/keypad/border,BORDER_RIGHT_WEIGHT→buttons/keypad/border,MIN_WIDTH→buttons/keypad/min_width |
| Type=Clear, State=Enabled/Clear | 67:22923 | TEXT | size=200×52; xy=0,28; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Strong; maxLines=1; truncate=ENDING; text='Clear' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486155/ivi_numeric_keypad/Type=Number, State=Pressed

- 원본 node: `67:22924`

- 공개 properties: `[{"name":"Number","type":"TEXT","initialValue":{"textValue":{"characters":"1","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Number, State=Pressed | 67:22924 | SYMBOL | size=200×108; xy=58,189; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; min={'x': 200, 'y': 0}; fill=keyboard/normal/primary_pressed=#EDEEF2FF; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; bind=HEIGHT→buttons/keypad/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/keypad/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/keypad/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/keypad/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/keypad/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/keypad/border,BORDER_BOTTOM_WEIGHT→buttons/keypad/border,BORDER_LEFT_WEIGHT→buttons/keypad/border,BORDER_RIGHT_WEIGHT→buttons/keypad/border,MIN_WIDTH→buttons/keypad/min_width |
| Type=Number, State=Pressed/1 | 67:22925 | TEXT | size=200×72; xy=0,18; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/ExtraBold/56; line=72/PIXELS; letter=0/PERCENT; textStyle=Headline/Medium/Extra_Strong; maxLines=1; truncate=ENDING; text='1' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486155/ivi_numeric_keypad/Type=Delete, State=Pressed

- 원본 node: `67:22926`

- 공개 properties: `[{"name":"Number","type":"TEXT","initialValue":{"textValue":{"characters":"1","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Delete, State=Pressed | 67:22926 | SYMBOL | size=200×108; xy=298,189; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; min={'x': 200, 'y': 0}; fill=surface/accent=#E0E1E6FF,dim/dark/tertiary=#13141733; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; bind=HEIGHT→buttons/keypad/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/keypad/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/keypad/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/keypad/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/keypad/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/keypad/border,BORDER_BOTTOM_WEIGHT→buttons/keypad/border,BORDER_LEFT_WEIGHT→buttons/keypad/border,BORDER_RIGHT_WEIGHT→buttons/keypad/border,MIN_WIDTH→buttons/keypad/min_width |
| Type=Delete, State=Pressed/ic_close | 67:22927 → 67:22427 | INSTANCE | size=48×48; xy=76,30; bind=WIDTH→buttons/keypad/icon,HEIGHT→buttons/keypad/icon |
| Type=Delete, State=Pressed/ic_close/Path | 67:22428 | BOOLEAN_OPERATION | size=44.8878×32; xy=1.1122,8; hidden; fill=icon/dark/primary=#131417FF |
| Type=Delete, State=Pressed/ic_close/Path/Rectangle 346244404 | 67:22429 | VECTOR | size=46×32; xy=-1.1122,0; r=3; fill=icon/dark/primary=#131417FF |
| Type=Delete, State=Pressed/ic_close/Path/Path | 67:22430 | BOOLEAN_OPERATION | size=14.9998×14.9998; xy=20.3879,8.5001; fill=icon/light/primary=#FFFFFFFF |
| Type=Delete, State=Pressed/ic_close/Path/Path/Vector 5947 | 67:22431 | VECTOR | size=12×12; xy=1.4999,1.4999; stroke=icon/light/primary=#FFFFFFFF; strokeWidth=3/CENTER |
| Type=Delete, State=Pressed/ic_close/Path/Path/Vector 5948 | 67:22432 | VECTOR | size=12×12; xy=1.4999,1.4999; stroke=icon/light/primary=#FFFFFFFF; strokeWidth=3/CENTER |
| Type=Delete, State=Pressed/ic_close/Icon | 67:22433 | VECTOR | size=44.8878×32; xy=1.1122,8; fill=icon/dark/secondary=#1B1C1ED6 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486155/ivi_numeric_keypad/Type=Clear, State=Pressed

- 원본 node: `67:22928`

- 공개 properties: `[{"name":"Number","type":"TEXT","initialValue":{"textValue":{"characters":"1","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Clear, State=Pressed | 67:22928 | SYMBOL | size=200×108; xy=538,189; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; min={'x': 200, 'y': 0}; fill=surface/accent=#E0E1E6FF,dim/dark/tertiary=#13141733; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; bind=HEIGHT→buttons/keypad/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/keypad/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/keypad/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/keypad/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/keypad/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/keypad/border,BORDER_BOTTOM_WEIGHT→buttons/keypad/border,BORDER_LEFT_WEIGHT→buttons/keypad/border,BORDER_RIGHT_WEIGHT→buttons/keypad/border,MIN_WIDTH→buttons/keypad/min_width |
| Type=Clear, State=Pressed/Clear | 67:22929 | TEXT | size=200×52; xy=0,28; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Strong; maxLines=1; truncate=ENDING; text='Clear' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486155/ivi_numeric_keypad/Type=Delete, State=Disabled

- 원본 node: `67:22930`

- 공개 properties: `[{"name":"Number","type":"TEXT","initialValue":{"textValue":{"characters":"1","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Delete, State=Disabled | 67:22930 | SYMBOL | size=200×108; xy=298,337; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; min={'x': 200, 'y': 0}; fill=surface/accent=#E0E1E6FF; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; bind=HEIGHT→buttons/keypad/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/keypad/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/keypad/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/keypad/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/keypad/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/keypad/border,BORDER_BOTTOM_WEIGHT→buttons/keypad/border,BORDER_LEFT_WEIGHT→buttons/keypad/border,BORDER_RIGHT_WEIGHT→buttons/keypad/border,MIN_WIDTH→buttons/keypad/min_width |
| Type=Delete, State=Disabled/ic_close | 67:22931 → 67:22427 | INSTANCE | size=48×48; xy=76,30; bind=WIDTH→buttons/keypad/icon,HEIGHT→buttons/keypad/icon |
| Type=Delete, State=Disabled/ic_close/Path | 67:22428 | BOOLEAN_OPERATION | size=44.8878×32; xy=1.1122,8; hidden; fill=icon/dark/primary=#131417FF |
| Type=Delete, State=Disabled/ic_close/Path/Rectangle 346244404 | 67:22429 | VECTOR | size=46×32; xy=-1.1122,0; r=3; fill=icon/dark/primary=#131417FF |
| Type=Delete, State=Disabled/ic_close/Path/Path | 67:22430 | BOOLEAN_OPERATION | size=14.9998×14.9998; xy=20.3879,8.5001; fill=icon/light/primary=#FFFFFFFF |
| Type=Delete, State=Disabled/ic_close/Path/Path/Vector 5947 | 67:22431 | VECTOR | size=12×12; xy=1.4999,1.4999; stroke=icon/light/primary=#FFFFFFFF; strokeWidth=3/CENTER |
| Type=Delete, State=Disabled/ic_close/Path/Path/Vector 5948 | 67:22432 | VECTOR | size=12×12; xy=1.4999,1.4999; stroke=icon/light/primary=#FFFFFFFF; strokeWidth=3/CENTER |
| Type=Delete, State=Disabled/ic_close/Icon | 67:22433 | VECTOR | size=44.8878×32; xy=1.1122,8; fill=icon/dark/quaternary=#13141752 |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486155/ivi_numeric_keypad/Type=Clear, State=Disabled

- 원본 node: `67:22932`

- 공개 properties: `[{"name":"Number","type":"TEXT","initialValue":{"textValue":{"characters":"1","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Clear, State=Disabled | 67:22932 | SYMBOL | size=200×108; xy=538,337; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; min={'x': 200, 'y': 0}; fill=surface/accent=#E0E1E6FF; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; bind=HEIGHT→buttons/keypad/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/keypad/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/keypad/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/keypad/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/keypad/radius_bottom_right,BORDER_TOP_WEIGHT→buttons/keypad/border,BORDER_BOTTOM_WEIGHT→buttons/keypad/border,BORDER_LEFT_WEIGHT→buttons/keypad/border,BORDER_RIGHT_WEIGHT→buttons/keypad/border,MIN_WIDTH→buttons/keypad/min_width |
| Type=Clear, State=Disabled/Clear | 67:22933 | TEXT | size=200×52; xy=0,28; fill=text/dark/quaternary=#13141752; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Strong; maxLines=1; truncate=ENDING; text='Clear' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Primary, State=Enabled, On=False

- 원본 node: `67:22937`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, State=Enabled, On=False | 67:22937 | SYMBOL | size=100×80; xy=10,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/normal/primary_normal=#FFFFFFFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/normal_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Primary, State=Enabled, On=False/A | 67:22938 | TEXT | size=100×52; xy=0,14; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Normal; maxLines=1; truncate=ENDING; text='A' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Primary, State=Pressed, On=False

- 원본 node: `67:22939`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, State=Pressed, On=False | 67:22939 | SYMBOL | size=100×80; xy=130,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/normal/primary_pressed=#EDEEF2FF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/normal_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Primary, State=Pressed, On=False/A | 67:22940 | TEXT | size=100×52; xy=0,14; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Normal; maxLines=1; truncate=ENDING; text='A' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Delete, State=Enabled, On=False

- 원본 node: `67:22941`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Delete, State=Enabled, On=False | 67:22941 | SYMBOL | size=120×80; xy=250,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MAX/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/normal/secondary_normal=#C7C9CEFF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Delete, State=Enabled, On=False/ic_keyboard | 67:22942 → 67:22445 | INSTANCE | size=44×44; xy=56,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Path | 67:22446 | BOOLEAN_OPERATION | size=37.1303×26.5166; xy=3.1698,8.742; hidden; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Path/Vector 5949 | 67:22447 | VECTOR | size=33.9167×22.9167; xy=1.4135,1.7997; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Path/Union | 67:22448 | BOOLEAN_OPERATION | size=11.8491×11.8491; xy=16.5726,7.3336; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Path/Union/Vector 5950 | 67:22449 | VECTOR | size=8.25×8.25; xy=1.7992,1.7995; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Path/Union/Vector 5951 | 67:22450 | VECTOR | size=8.25×8.25; xy=1.7992,1.7995; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Icon | 67:22451 | VECTOR | size=36.8624×26.2167; xy=3.2876,8.8916; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Delete, State=Pressed, On=False

- 원본 node: `67:22943`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Delete, State=Pressed, On=False | 67:22943 | SYMBOL | size=120×80; xy=390,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MAX/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/normal/secondary_pressed=#A4A8AEFF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Delete, State=Pressed, On=False/ic_keyboard | 67:22944 → 67:22445 | INSTANCE | size=44×44; xy=56,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Path | 67:22446 | BOOLEAN_OPERATION | size=37.1303×26.5166; xy=3.1698,8.742; hidden; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Path/Vector 5949 | 67:22447 | VECTOR | size=33.9167×22.9167; xy=1.4135,1.7997; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Path/Union | 67:22448 | BOOLEAN_OPERATION | size=11.8491×11.8491; xy=16.5726,7.3336; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Path/Union/Vector 5950 | 67:22449 | VECTOR | size=8.25×8.25; xy=1.7992,1.7995; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Path/Union/Vector 5951 | 67:22450 | VECTOR | size=8.25×8.25; xy=1.7992,1.7995; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Icon | 67:22451 | VECTOR | size=36.8624×26.2167; xy=3.2876,8.8916; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Shift, State=Enabled, On=False

- 원본 node: `67:22945`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Shift, State=Enabled, On=False | 67:22945 | SYMBOL | size=165×80; xy=530,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/normal/secondary_normal=#C7C9CEFF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/shift_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Shift, State=Enabled, On=False/ic_keyboard | 67:22946 → 67:22452 | INSTANCE | size=44×44; xy=20,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Shift, State=Enabled, On=False/ic_keyboard/Path | 67:22453 | BOOLEAN_OPERATION | size=33.8496×32.9336; xy=5.075,5.534; hidden; fill=icon/dark/primary=#131417FF |
| Type=Shift, State=Enabled, On=False/ic_keyboard/Path/Vector 5962 | 67:22454 | VECTOR | size=12.8333×12.8333; xy=10.5083,18.2993; stroke=basic/900=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, State=Enabled, On=False/ic_keyboard/Path/Path | 67:22455 | VECTOR | size=30.25×16.5; xy=1.8,1.7993; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, State=Enabled, On=False/ic_keyboard/Icon | 67:22456 | VECTOR | size=33.5501×32.6333; xy=5.225,5.6833; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Shift, On=False, State=Pressed

- 원본 node: `67:22947`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Shift, On=False, State=Pressed | 67:22947 | SYMBOL | size=165×80; xy=715,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/normal/secondary_pressed=#A4A8AEFF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/shift_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Shift, On=False, State=Pressed/ic_keyboard | 67:22948 → 67:22452 | INSTANCE | size=44×44; xy=20,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Shift, On=False, State=Pressed/ic_keyboard/Path | 67:22453 | BOOLEAN_OPERATION | size=33.8496×32.9336; xy=5.075,5.534; hidden; fill=icon/dark/primary=#131417FF |
| Type=Shift, On=False, State=Pressed/ic_keyboard/Path/Vector 5962 | 67:22454 | VECTOR | size=12.8333×12.8333; xy=10.5083,18.2993; stroke=basic/900=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, On=False, State=Pressed/ic_keyboard/Path/Path | 67:22455 | VECTOR | size=30.25×16.5; xy=1.8,1.7993; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, On=False, State=Pressed/ic_keyboard/Icon | 67:22456 | VECTOR | size=33.5501×32.6333; xy=5.225,5.6833; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Shift, State=Enabled, On=True

- 원본 node: `67:22949`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Shift, State=Enabled, On=True | 67:22949 | SYMBOL | size=165×80; xy=10,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/normal/active_normal=#44464EFF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/shift_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Shift, State=Enabled, On=True/ic_keyboard | 67:22950 → 67:22457 | INSTANCE | size=44×44; xy=20,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Shift, State=Enabled, On=True/ic_keyboard/Path | 67:22458 | VECTOR | size=30.25×29.3333; xy=6.875,7.3333; hidden; fill=icon/dark/primary=#131417FF; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, State=Enabled, On=True/ic_keyboard/Icon | 67:22459 | VECTOR | size=33.5501×32.6333; xy=5.225,5.6833; fill=informative/active=#22E77DFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Shift, On=True, State=Pressed

- 원본 node: `67:22951`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Shift, On=True, State=Pressed | 67:22951 | SYMBOL | size=165×80; xy=195,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/normal/active_pressed=#313236FF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/shift_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Shift, On=True, State=Pressed/ic_keyboard | 67:22952 → 67:22457 | INSTANCE | size=44×44; xy=20,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Shift, On=True, State=Pressed/ic_keyboard/Path | 67:22458 | VECTOR | size=30.25×29.3333; xy=6.875,7.3333; hidden; fill=icon/dark/primary=#131417FF; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, On=True, State=Pressed/ic_keyboard/Icon | 67:22459 | VECTOR | size=33.5501×32.6333; xy=5.225,5.6833; fill=informative/active=#22E77DFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Secondary, State=Enabled, On=False

- 원본 node: `67:22953`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, State=Enabled, On=False | 67:22953 | SYMBOL | size=120×80; xy=380,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/normal/secondary_normal=#C7C9CEFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Secondary, State=Enabled, On=False/한/A | 67:22954 | TEXT | size=67×44; xy=26.5,18; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Normal; maxLines=1; truncate=ENDING; text='한/A' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Secondary, State=Pressed, On=False

- 원본 node: `67:22955`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, State=Pressed, On=False | 67:22955 | SYMBOL | size=120×80; xy=520,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/normal/secondary_pressed=#A4A8AEFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Secondary, State=Pressed, On=False/한/A | 67:22956 | TEXT | size=67×44; xy=26.5,18; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Normal; maxLines=1; truncate=ENDING; text='한/A' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Mic, State=Enabled, On=False

- 원본 node: `67:22957`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Mic, State=Enabled, On=False | 67:22957 | SYMBOL | size=120×80; xy=660,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/normal/secondary_normal=#C7C9CEFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Mic, State=Enabled, On=False/ic_mic | 67:22958 → 67:22337 | INSTANCE | size=44×44; xy=38,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Mic, State=Enabled, On=False/ic_mic/Path | 67:22338 | BOOLEAN_OPERATION | size=25.5996×33.4248; xy=9.2,5.4999; hidden; fill=icon/dark/primary=#131417FF |
| Type=Mic, State=Enabled, On=False/ic_mic/Path/Vector 5954 | 67:22339 | VECTOR | size=11×0; xy=7.3,31.625; r=10; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Enabled, On=False/ic_mic/Path/Vector 5953 | 67:22340 | VECTOR | size=0×6.4167; xy=12.8,25.2083; r=10; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Enabled, On=False/ic_mic/Path/Vector 5952 | 67:22341 | VECTOR | size=22×11.9167; xy=1.8,13.2917; r=12; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Enabled, On=False/ic_mic/Path/Rectangle 346244388 | 67:22342 | ROUNDED_RECTANGLE | size=12.8333×20.1667; xy=6.3833,0; opacity=0.34; r=10; r(TL,TR,BR,BL)=10,10,10,10; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Mic, State=Enabled, On=False/ic_mic/Icon | 67:22343 | VECTOR | size=25.3×33.275; xy=9.3501,5.5; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Mic, State=Pressed, On=False

- 원본 node: `67:22959`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Mic, State=Pressed, On=False | 67:22959 | SYMBOL | size=120×80; xy=800,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/normal/secondary_pressed=#A4A8AEFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Mic, State=Pressed, On=False/ic_mic | 67:22960 → 67:22337 | INSTANCE | size=44×44; xy=38,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Mic, State=Pressed, On=False/ic_mic/Path | 67:22338 | BOOLEAN_OPERATION | size=25.5996×33.4248; xy=9.2,5.4999; hidden; fill=icon/dark/primary=#131417FF |
| Type=Mic, State=Pressed, On=False/ic_mic/Path/Vector 5954 | 67:22339 | VECTOR | size=11×0; xy=7.3,31.625; r=10; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Pressed, On=False/ic_mic/Path/Vector 5953 | 67:22340 | VECTOR | size=0×6.4167; xy=12.8,25.2083; r=10; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Pressed, On=False/ic_mic/Path/Vector 5952 | 67:22341 | VECTOR | size=22×11.9167; xy=1.8,13.2917; r=12; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Pressed, On=False/ic_mic/Path/Rectangle 346244388 | 67:22342 | ROUNDED_RECTANGLE | size=12.8333×20.1667; xy=6.3833,0; opacity=0.34; r=10; r(TL,TR,BR,BL)=10,10,10,10; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Mic, State=Pressed, On=False/ic_mic/Icon | 67:22343 | VECTOR | size=25.3×33.275; xy=9.3501,5.5; fill=icon/dark/primary=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Hyphen, State=Enabled, On=False

- 원본 node: `67:22961`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Hyphen, State=Enabled, On=False | 67:22961 | SYMBOL | size=120×80; xy=10,210; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/normal/secondary_normal=#C7C9CEFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Hyphen, State=Enabled, On=False/- | 67:22962 | TEXT | size=17×52; xy=51.5,14; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Normal; maxLines=1; truncate=ENDING; text='-' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Hyphen, State=Pressed, On=False

- 원본 node: `67:22963`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Hyphen, State=Pressed, On=False | 67:22963 | SYMBOL | size=120×80; xy=150,210; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/normal/secondary_pressed=#A4A8AEFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Hyphen, State=Pressed, On=False/- | 67:22964 | TEXT | size=17×52; xy=51.5,14; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Normal; maxLines=1; truncate=ENDING; text='-' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Space, State=Enabled, On=False

- 원본 node: `67:22965`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Space, State=Enabled, On=False | 67:22965 | SYMBOL | size=300×80; xy=290,210; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/normal/primary_normal=#FFFFFFFF; stackPrimarySizing=FIXED; bind=HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Space, State=Enabled, On=False/스페이스 | 67:22966 | TEXT | size=300×40; xy=0,20; hidden; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/32; line=40/PIXELS; letter=0/PERCENT; maxLines=1; truncate=ENDING; text='스페이스' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Space, State=Pressed, On=False

- 원본 node: `67:22967`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Space, State=Pressed, On=False | 67:22967 | SYMBOL | size=300×80; xy=610,210; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/normal/primary_pressed=#EDEEF2FF; stackPrimarySizing=FIXED; bind=HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Space, State=Pressed, On=False/스페이스 | 67:22968 | TEXT | size=300×40; xy=0,20; hidden; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/32; line=40/PIXELS; letter=0/PERCENT; maxLines=1; truncate=ENDING; text='스페이스' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Enter, State=Enabled, On=False

- 원본 node: `67:22969`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Enter, State=Enabled, On=False | 67:22969 | SYMBOL | size=200×80; xy=10,310; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MAX/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/normal/accents_normal=#44464EFF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/enter_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Enter, State=Enabled, On=False/ic_keyboard | 67:22970 → 67:22460 | INSTANCE | size=44×44; xy=136,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Enter, State=Enabled, On=False/ic_keyboard/Path | 67:22461 | BOOLEAN_OPERATION | size=32.9325×26.9743; xy=4.6173,8.2838; hidden; fill=icon/dark/primary=#131417FF |
| Type=Enter, State=Enabled, On=False/ic_keyboard/Path/Vector 6001 | 67:22462 | VECTOR | size=27.5×16.5; xy=3.6326,1.7994; stroke=#000000FF; strokeWidth=3.6/CENTER |
| Type=Enter, State=Enabled, On=False/ic_keyboard/Path/Vector 6003 | 67:22463 | VECTOR | size=6.875×13.75; xy=1.7993,11.4246; stroke=#000000FF; strokeWidth=3.6/CENTER |
| Type=Enter, State=Enabled, On=False/ic_keyboard/Icon | 67:22464 | VECTOR | size=32.6334×26.6752; xy=4.7666,8.4331; fill=icon/light/primary=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486156/ivi_keypad_normal/Type=Enter, State=Pressed, On=False

- 원본 node: `67:22971`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Enter, State=Pressed, On=False | 67:22971 | SYMBOL | size=200×80; xy=230,310; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MAX/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/normal/accents_pressed=#313236FF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/enter_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Enter, State=Pressed, On=False/ic_keyboard | 67:22972 → 67:22460 | INSTANCE | size=44×44; xy=136,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Enter, State=Pressed, On=False/ic_keyboard/Path | 67:22461 | BOOLEAN_OPERATION | size=32.9325×26.9743; xy=4.6173,8.2838; hidden; fill=icon/dark/primary=#131417FF |
| Type=Enter, State=Pressed, On=False/ic_keyboard/Path/Vector 6001 | 67:22462 | VECTOR | size=27.5×16.5; xy=3.6326,1.7994; stroke=#000000FF; strokeWidth=3.6/CENTER |
| Type=Enter, State=Pressed, On=False/ic_keyboard/Path/Vector 6003 | 67:22463 | VECTOR | size=6.875×13.75; xy=1.7993,11.4246; stroke=#000000FF; strokeWidth=3.6/CENTER |
| Type=Enter, State=Pressed, On=False/ic_keyboard/Icon | 67:22464 | VECTOR | size=32.6334×26.6752; xy=4.7666,8.4331; fill=icon/light/primary=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Primary, State=Enabled, On=False

- 원본 node: `67:22976`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, State=Enabled, On=False | 67:22976 | SYMBOL | size=100×80; xy=10,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/static/primary_normal=#686A72FF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/normal_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Primary, State=Enabled, On=False/A | 67:22977 | TEXT | size=100×52; xy=0,14; fill=keyboard/static/text=#FFFFFFFF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Normal; maxLines=1; truncate=ENDING; text='A' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Primary, State=Pressed, On=False

- 원본 node: `67:22978`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Primary, State=Pressed, On=False | 67:22978 | SYMBOL | size=100×80; xy=130,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/static/primary_pressed=#44464EFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/normal_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Primary, State=Pressed, On=False/A | 67:22979 | TEXT | size=100×52; xy=0,14; fill=keyboard/static/text=#FFFFFFFF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Normal; maxLines=1; truncate=ENDING; text='A' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Delete, State=Enabled, On=False

- 원본 node: `67:22980`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Delete, State=Enabled, On=False | 67:22980 | SYMBOL | size=120×80; xy=250,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MAX/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/static/secondary_normal=#44464EFF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Delete, State=Enabled, On=False/ic_keyboard | 67:22981 → 67:22445 | INSTANCE | size=44×44; xy=56,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Path | 67:22446 | BOOLEAN_OPERATION | size=37.1303×26.5166; xy=3.1698,8.742; hidden; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Path/Vector 5949 | 67:22447 | VECTOR | size=33.9167×22.9167; xy=1.4135,1.7997; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Path/Union | 67:22448 | BOOLEAN_OPERATION | size=11.8491×11.8491; xy=16.5726,7.3336; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Path/Union/Vector 5950 | 67:22449 | VECTOR | size=8.25×8.25; xy=1.7992,1.7995; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Path/Union/Vector 5951 | 67:22450 | VECTOR | size=8.25×8.25; xy=1.7992,1.7995; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Enabled, On=False/ic_keyboard/Icon | 67:22451 | VECTOR | size=36.8624×26.2167; xy=3.2876,8.8916; fill=keyboard/static/icon_light=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Delete, State=Pressed, On=False

- 원본 node: `67:22982`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Delete, State=Pressed, On=False | 67:22982 | SYMBOL | size=120×80; xy=390,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MAX/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/static/secondary_pressed=#686A72FF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Delete, State=Pressed, On=False/ic_keyboard | 67:22983 → 67:22445 | INSTANCE | size=44×44; xy=56,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Path | 67:22446 | BOOLEAN_OPERATION | size=37.1303×26.5166; xy=3.1698,8.742; hidden; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Path/Vector 5949 | 67:22447 | VECTOR | size=33.9167×22.9167; xy=1.4135,1.7997; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Path/Union | 67:22448 | BOOLEAN_OPERATION | size=11.8491×11.8491; xy=16.5726,7.3336; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Path/Union/Vector 5950 | 67:22449 | VECTOR | size=8.25×8.25; xy=1.7992,1.7995; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Path/Union/Vector 5951 | 67:22450 | VECTOR | size=8.25×8.25; xy=1.7992,1.7995; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Delete, State=Pressed, On=False/ic_keyboard/Icon | 67:22451 | VECTOR | size=36.8624×26.2167; xy=3.2876,8.8916; fill=keyboard/static/icon_light=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Shift, State=Enabled, On=False

- 원본 node: `67:22984`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Shift, State=Enabled, On=False | 67:22984 | SYMBOL | size=165×80; xy=530,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/static/secondary_normal=#44464EFF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/shift_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Shift, State=Enabled, On=False/ic_keyboard | 67:22985 → 67:22452 | INSTANCE | size=44×44; xy=20,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Shift, State=Enabled, On=False/ic_keyboard/Path | 67:22453 | BOOLEAN_OPERATION | size=33.8496×32.9336; xy=5.075,5.534; hidden; fill=icon/dark/primary=#131417FF |
| Type=Shift, State=Enabled, On=False/ic_keyboard/Path/Vector 5962 | 67:22454 | VECTOR | size=12.8333×12.8333; xy=10.5083,18.2993; stroke=basic/900=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, State=Enabled, On=False/ic_keyboard/Path/Path | 67:22455 | VECTOR | size=30.25×16.5; xy=1.8,1.7993; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, State=Enabled, On=False/ic_keyboard/Icon | 67:22456 | VECTOR | size=33.5501×32.6333; xy=5.225,5.6833; fill=keyboard/static/icon_light=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Shift, On=False, State=Pressed

- 원본 node: `67:22986`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Shift, On=False, State=Pressed | 67:22986 | SYMBOL | size=165×80; xy=715,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/static/secondary_pressed=#686A72FF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/shift_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Shift, On=False, State=Pressed/ic_keyboard | 67:22987 → 67:22452 | INSTANCE | size=44×44; xy=20,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Shift, On=False, State=Pressed/ic_keyboard/Path | 67:22453 | BOOLEAN_OPERATION | size=33.8496×32.9336; xy=5.075,5.534; hidden; fill=icon/dark/primary=#131417FF |
| Type=Shift, On=False, State=Pressed/ic_keyboard/Path/Vector 5962 | 67:22454 | VECTOR | size=12.8333×12.8333; xy=10.5083,18.2993; stroke=basic/900=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, On=False, State=Pressed/ic_keyboard/Path/Path | 67:22455 | VECTOR | size=30.25×16.5; xy=1.8,1.7993; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, On=False, State=Pressed/ic_keyboard/Icon | 67:22456 | VECTOR | size=33.5501×32.6333; xy=5.225,5.6833; fill=keyboard/static/icon_light=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Shift, State=Enabled, On=True

- 원본 node: `67:22988`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Shift, State=Enabled, On=True | 67:22988 | SYMBOL | size=165×80; xy=10,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/static/active_normal=#686A72FF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/shift_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Shift, State=Enabled, On=True/ic_keyboard | 67:22989 → 67:22457 | INSTANCE | size=44×44; xy=20,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Shift, State=Enabled, On=True/ic_keyboard/Path | 67:22458 | VECTOR | size=30.25×29.3333; xy=6.875,7.3333; hidden; fill=icon/dark/primary=#131417FF; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, State=Enabled, On=True/ic_keyboard/Icon | 67:22459 | VECTOR | size=33.5501×32.6333; xy=5.225,5.6833; fill=informative/active=#22E77DFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Shift, On=True, State=Pressed

- 원본 node: `67:22990`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Shift, On=True, State=Pressed | 67:22990 | SYMBOL | size=165×80; xy=195,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/static/active_pressed=#313236FF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/shift_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Shift, On=True, State=Pressed/ic_keyboard | 67:22991 → 67:22457 | INSTANCE | size=44×44; xy=20,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Shift, On=True, State=Pressed/ic_keyboard/Path | 67:22458 | VECTOR | size=30.25×29.3333; xy=6.875,7.3333; hidden; fill=icon/dark/primary=#131417FF; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Type=Shift, On=True, State=Pressed/ic_keyboard/Icon | 67:22459 | VECTOR | size=33.5501×32.6333; xy=5.225,5.6833; fill=informative/active=#22E77DFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Secondary, State=Enabled, On=False

- 원본 node: `67:22992`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, State=Enabled, On=False | 67:22992 | SYMBOL | size=120×80; xy=380,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/static/secondary_normal=#44464EFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Secondary, State=Enabled, On=False/한/A | 67:22993 | TEXT | size=67×44; xy=26.5,18; fill=keyboard/static/text=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Normal; maxLines=1; truncate=ENDING; text='한/A' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Secondary, State=Pressed, On=False

- 원본 node: `67:22994`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Secondary, State=Pressed, On=False | 67:22994 | SYMBOL | size=120×80; xy=520,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/static/secondary_pressed=#686A72FF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Secondary, State=Pressed, On=False/한/A | 67:22995 | TEXT | size=67×44; xy=26.5,18; fill=keyboard/static/text=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Normal; maxLines=1; truncate=ENDING; text='한/A' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Mic, State=Enabled, On=False

- 원본 node: `67:22996`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Mic, State=Enabled, On=False | 67:22996 | SYMBOL | size=120×80; xy=660,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/static/secondary_normal=#44464EFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Mic, State=Enabled, On=False/ic_mic | 67:22997 → 67:22337 | INSTANCE | size=44×44; xy=38,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Mic, State=Enabled, On=False/ic_mic/Path | 67:22338 | BOOLEAN_OPERATION | size=25.5996×33.4248; xy=9.2,5.4999; hidden; fill=icon/dark/primary=#131417FF |
| Type=Mic, State=Enabled, On=False/ic_mic/Path/Vector 5954 | 67:22339 | VECTOR | size=11×0; xy=7.3,31.625; r=10; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Enabled, On=False/ic_mic/Path/Vector 5953 | 67:22340 | VECTOR | size=0×6.4167; xy=12.8,25.2083; r=10; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Enabled, On=False/ic_mic/Path/Vector 5952 | 67:22341 | VECTOR | size=22×11.9167; xy=1.8,13.2917; r=12; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Enabled, On=False/ic_mic/Path/Rectangle 346244388 | 67:22342 | ROUNDED_RECTANGLE | size=12.8333×20.1667; xy=6.3833,0; opacity=0.34; r=10; r(TL,TR,BR,BL)=10,10,10,10; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Mic, State=Enabled, On=False/ic_mic/Icon | 67:22343 | VECTOR | size=25.3×33.275; xy=9.3501,5.5; fill=keyboard/static/icon_light=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Mic, State=Pressed, On=False

- 원본 node: `67:22998`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Mic, State=Pressed, On=False | 67:22998 | SYMBOL | size=120×80; xy=800,110; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/static/secondary_pressed=#686A72FF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Mic, State=Pressed, On=False/ic_mic | 67:22999 → 67:22337 | INSTANCE | size=44×44; xy=38,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Mic, State=Pressed, On=False/ic_mic/Path | 67:22338 | BOOLEAN_OPERATION | size=25.5996×33.4248; xy=9.2,5.4999; hidden; fill=icon/dark/primary=#131417FF |
| Type=Mic, State=Pressed, On=False/ic_mic/Path/Vector 5954 | 67:22339 | VECTOR | size=11×0; xy=7.3,31.625; r=10; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Pressed, On=False/ic_mic/Path/Vector 5953 | 67:22340 | VECTOR | size=0×6.4167; xy=12.8,25.2083; r=10; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Pressed, On=False/ic_mic/Path/Vector 5952 | 67:22341 | VECTOR | size=22×11.9167; xy=1.8,13.2917; r=12; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.6/CENTER |
| Type=Mic, State=Pressed, On=False/ic_mic/Path/Rectangle 346244388 | 67:22342 | ROUNDED_RECTANGLE | size=12.8333×20.1667; xy=6.3833,0; opacity=0.34; r=10; r(TL,TR,BR,BL)=10,10,10,10; fill=_Legacy/Scale/Black/Black=#000000FF |
| Type=Mic, State=Pressed, On=False/ic_mic/Icon | 67:22343 | VECTOR | size=25.3×33.275; xy=9.3501,5.5; fill=keyboard/static/icon_light=#FFFFFFFF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Hyphen, State=Enabled, On=False

- 원본 node: `67:23000`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Hyphen, State=Enabled, On=False | 67:23000 | SYMBOL | size=120×80; xy=10,210; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/static/secondary_normal=#44464EFF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Hyphen, State=Enabled, On=False/- | 67:23001 | TEXT | size=17×52; xy=51.5,14; fill=keyboard/static/text=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Normal; maxLines=1; truncate=ENDING; text='-' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Hyphen, State=Pressed, On=False

- 원본 node: `67:23002`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Hyphen, State=Pressed, On=False | 67:23002 | SYMBOL | size=120×80; xy=150,210; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/static/secondary_pressed=#686A72FF; stackPrimarySizing=FIXED; bind=WIDTH→keyboard/keyword/special_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Hyphen, State=Pressed, On=False/- | 67:23003 | TEXT | size=17×52; xy=51.5,14; fill=keyboard/static/text=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/40; line=52/PIXELS; letter=0/PERCENT; textStyle=Title/Large/Normal; maxLines=1; truncate=ENDING; text='-' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Space, State=Enabled, On=False

- 원본 node: `67:23004`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Space, State=Enabled, On=False | 67:23004 | SYMBOL | size=300×80; xy=290,210; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/static/primary_normal=#686A72FF; stackPrimarySizing=FIXED; bind=HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Space, State=Enabled, On=False/스페이스 | 67:23005 | TEXT | size=300×40; xy=0,20; hidden; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/32; line=40/PIXELS; letter=0/PERCENT; maxLines=1; truncate=ENDING; text='스페이스' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Space, State=Pressed, On=False

- 원본 node: `67:23006`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Space, State=Pressed, On=False | 67:23006 | SYMBOL | size=300×80; xy=610,210; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=keyboard/static/primary_pressed=#44464EFF; stackPrimarySizing=FIXED; bind=HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Space, State=Pressed, On=False/스페이스 | 67:23007 | TEXT | size=300×40; xy=0,20; hidden; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Regular/32; line=40/PIXELS; letter=0/PERCENT; maxLines=1; truncate=ENDING; text='스페이스' |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Enter, State=Enabled, On=False

- 원본 node: `67:23008`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Enter, State=Enabled, On=False | 67:23008 | SYMBOL | size=200×80; xy=10,310; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MAX/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/static/accents_normal=#C7C9CEFF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/enter_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Enter, State=Enabled, On=False/ic_keyboard | 67:23009 → 67:22460 | INSTANCE | size=44×44; xy=136,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Enter, State=Enabled, On=False/ic_keyboard/Path | 67:22461 | BOOLEAN_OPERATION | size=32.9325×26.9743; xy=4.6173,8.2838; hidden; fill=icon/dark/primary=#131417FF |
| Type=Enter, State=Enabled, On=False/ic_keyboard/Path/Vector 6001 | 67:22462 | VECTOR | size=27.5×16.5; xy=3.6326,1.7994; stroke=#000000FF; strokeWidth=3.6/CENTER |
| Type=Enter, State=Enabled, On=False/ic_keyboard/Path/Vector 6003 | 67:22463 | VECTOR | size=6.875×13.75; xy=1.7993,11.4246; stroke=#000000FF; strokeWidth=3.6/CENTER |
| Type=Enter, State=Enabled, On=False/ic_keyboard/Icon | 67:22464 | VECTOR | size=32.6334×26.6752; xy=4.7666,8.4331; fill=keyboard/static/icon_dark=#131417FF |

## ❖ Components/Buttons/Frame 1/Col/Frame 1707486157/ivi_keypad_static/Type=Enter, State=Pressed, On=False

- 원본 node: `67:23010`

- 공개 properties: `[{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Label2","type":"TEXT","initialValue":{"textValue":{"characters":"한/A","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}},{"name":"On","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Enter, State=Pressed, On=False | 67:23010 | SYMBOL | size=200×80; xy=230,310; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/MAX/CENTER; padding(L,T,R,B)=20,0,20,0; gap=0; fill=keyboard/static/accents_pressed=#A4A8AEFF; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→Common/20,STACK_PADDING_RIGHT→Common/20,WIDTH→keyboard/keyword/enter_width,HEIGHT→keyboard/keyword/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→keyboard/keyword/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→keyboard/keyword/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→keyboard/keyword/radius_bottom_right |
| Type=Enter, State=Pressed, On=False/ic_keyboard | 67:23011 → 67:22460 | INSTANCE | size=44×44; xy=136,18; bind=WIDTH→keyboard/keyword/icon_square,HEIGHT→keyboard/keyword/icon_square |
| Type=Enter, State=Pressed, On=False/ic_keyboard/Path | 67:22461 | BOOLEAN_OPERATION | size=32.9325×26.9743; xy=4.6173,8.2838; hidden; fill=icon/dark/primary=#131417FF |
| Type=Enter, State=Pressed, On=False/ic_keyboard/Path/Vector 6001 | 67:22462 | VECTOR | size=27.5×16.5; xy=3.6326,1.7994; stroke=#000000FF; strokeWidth=3.6/CENTER |
| Type=Enter, State=Pressed, On=False/ic_keyboard/Path/Vector 6003 | 67:22463 | VECTOR | size=6.875×13.75; xy=1.7993,11.4246; stroke=#000000FF; strokeWidth=3.6/CENTER |
| Type=Enter, State=Pressed, On=False/ic_keyboard/Icon | 67:22464 | VECTOR | size=32.6334×26.6752; xy=4.7666,8.4331; fill=keyboard/static/icon_dark=#131417FF |

