# Figma assets — 컴포넌트 및 하위 레이어 해석 부록

> **원본 부록:** 웹과 다른 옛 값은 이력이다. 최신 구현은 01·02·03·08번의 웹 최종값을 적용한다. 원본 snapshot 색을 새 웹 token 위에 다시 덮지 않는다.

원본 SYMBOL의 레이어 및 INSTANCE의 master 기본값, symbolOverrides, derivedSymbolData, componentPropAssignments를 병합한 오프라인 참조이다. 모든 치수는 원본 design unit이며 root xy는 디자인 보드상 위치이므로 런타임 위치로 복사하지 않는다. child xy는 부모 상대 좌표이다. r 순서는 TL/TR/BR/BL, padding 순서는 L/T/R/B이다.

fill/stroke의 HEX는 `#RRGGBBAA`이며 원본 color alpha×paint.opacity를 합성한 스냅샷 값이다. theme 동작에는 별도 전체 토큰 표와 웹 기준 충돌 해결 규칙을 적용한다. 노드 opacity는 별도로 표시한다. `hidden`은 예제에서 꺼진 옵션이며 구현에서 삭제하라는 뜻이 아니다. master의 드롭다운/토글/Label 등 공개 property도 구현 대상이다.

이 표는 바이너리 파싱 없이 geometry/style/variant를 참조하도록 만든다. Figma 렌더러 전체를 재구현한 것은 아니므로 boolean geometry·clip·특수 효과의 pixel 일치는 SVG 및 원본 guide와 검증한다. 외부 master 누락은 마지막 해석 결과에 별도로 남긴다.


## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Small, State=Enabled

- 원본 node: `67:27051`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled | 67:27051 | SYMBOL | size=700×80; xy=40,40; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=0,0,0,0; gap=12; bind=STACK_SPACING→fields/text/small/help_text_gap_vertical |
| Size=Small, State=Enabled/Text Fields | 67:27052 | FRAME | size=700×80; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=24,0,24,0; gap=12; fill=field/background=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/small/gap_horizontal,STACK_PADDING_LEFT→fields/text/small/padding_horizontal,STACK_PADDING_RIGHT→fields/text/small/padding_horizontal,HEIGHT→fields/text/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/small/border,BORDER_BOTTOM_WEIGHT→fields/text/small/border,BORDER_LEFT_WEIGHT→fields/text/small/border,BORDER_RIGHT_WEIGHT→fields/text/small/border |
| Size=Small, State=Enabled/Text Fields/Place holder | 67:27053 | TEXT | size=652×38; xy=24,21; fill=text/dark/tertiary=#131417A3; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Normal; maxLines=1; truncate=ENDING; text='Place holder' |
| Size=Small, State=Enabled/Text Fields/ic_close | 67:27054 → 67:22420 | INSTANCE | size=40×40; xy=580,20; hidden; bind=WIDTH→fields/text/small/suffix_icon_square,HEIGHT→fields/text/small/suffix_icon_square |
| Size=Small, State=Enabled/Text Fields/ic_close/Path | 67:22421 | BOOLEAN_OPERATION | size=33.334×33.334; xy=3.333,3.333; hidden; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Small, State=Enabled/Text Fields/ic_close/Path/Ellipse 8009 | 67:22422 | ELLIPSE | size=33.3333×33.3333; xy=0.0003,0.0003; fill=#D9D9D9FF |
| Size=Small, State=Enabled/Text Fields/ic_close/Path/Path | 67:22423 | BOOLEAN_OPERATION | size=15.1664×15.1664; xy=9.0841,9.0841; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Small, State=Enabled/Text Fields/ic_close/Path/Path/Vector 5947 | 67:22424 | VECTOR | size=11.6667×11.6667; xy=1.7495,1.7495; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Small, State=Enabled/Text Fields/ic_close/Path/Path/Vector 5948 | 67:22425 | VECTOR | size=11.6667×11.6667; xy=1.7495,1.7495; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Small, State=Enabled/Text Fields/ic_close/Path | 67:22426 | VECTOR | size=33.3333×33.3333; xy=3.3333,3.3333; fill=icon/dark/secondary=#1B1C1ECC |
| Size=Small, State=Enabled/Text Fields/ic_eye | 67:27055 → 67:26985 | INSTANCE | size=40×40; xy=636,20; hidden; bind=WIDTH→fields/text/small/suffix_icon_square,HEIGHT→fields/text/small/suffix_icon_square |
| Size=Small, State=Enabled/Text Fields/ic_eye/Path | 67:26986 | VECTOR | size=31.6288×23.3333; xy=4.1667,8.3333; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled/Text Fields/ic_eye/Icon | 67:26987 | VECTOR | size=31.6288×23.3333; xy=4.1667,8.3333; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Small, State=Enabled/Help Text | 67:27056 | FRAME | size=700×34; xy=0,92; hidden; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Small, State=Enabled/Help Text/Description | 67:27057 | TEXT | size=668×34; xy=16,0; fill=text/dark/secondary=#131417D6; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Help Text' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Medium, State=Enabled

- 원본 node: `67:27058`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled | 67:27058 | SYMBOL | size=700×100; xy=840,40; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=0,0,0,0; gap=16; bind=STACK_SPACING→fields/text/medium/help_text_gap_vertical |
| Size=Medium, State=Enabled/Text Fields | 67:27059 | FRAME | size=700×100; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=32,0,32,0; gap=16; fill=field/background=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/medium/gap_horizontal,STACK_PADDING_LEFT→fields/text/medium/padding_horizontal,STACK_PADDING_RIGHT→fields/text/medium/padding_horizontal,HEIGHT→fields/text/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/small/border,BORDER_BOTTOM_WEIGHT→fields/text/small/border,BORDER_LEFT_WEIGHT→fields/text/small/border,BORDER_RIGHT_WEIGHT→fields/text/small/border |
| Size=Medium, State=Enabled/Text Fields/Place holder | 67:27060 | TEXT | size=636×44; xy=32,28; fill=text/dark/tertiary=#131417A3; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Normal; maxLines=1; truncate=ENDING; text='Place holder' |
| Size=Medium, State=Enabled/Text Fields/ic_close | 67:27061 → 67:22420 | INSTANCE | size=48×48; xy=556,26; hidden; bind=WIDTH→fields/text/medium/suffix_icon_square,HEIGHT→fields/text/medium/suffix_icon_square |
| Size=Medium, State=Enabled/Text Fields/ic_close/Path | 67:22421 | BOOLEAN_OPERATION | size=40×40; xy=4,4; hidden; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Enabled/Text Fields/ic_close/Path/Ellipse 8009 | 67:22422 | ELLIPSE | size=40×40; xy=0,0; fill=#D9D9D9FF |
| Size=Medium, State=Enabled/Text Fields/ic_close/Path/Path | 67:22423 | BOOLEAN_OPERATION | size=17.4997×17.4997; xy=11.25,11.25; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Enabled/Text Fields/ic_close/Path/Path/Vector 5947 | 67:22424 | VECTOR | size=14×14; xy=1.75,1.75; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Medium, State=Enabled/Text Fields/ic_close/Path/Path/Vector 5948 | 67:22425 | VECTOR | size=14×14; xy=1.75,1.75; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Medium, State=Enabled/Text Fields/ic_close/Path | 67:22426 | VECTOR | size=40×40; xy=4,4; fill=icon/dark/secondary=#1B1C1ECC |
| Size=Medium, State=Enabled/Text Fields/ic_eye | 67:27062 → 67:26985 | INSTANCE | size=48×48; xy=620,26; hidden; bind=WIDTH→fields/text/medium/suffix_icon_square,HEIGHT→fields/text/medium/suffix_icon_square |
| Size=Medium, State=Enabled/Text Fields/ic_eye/Path | 67:26986 | VECTOR | size=37.9545×28; xy=5,10; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled/Text Fields/ic_eye/Icon | 67:26987 | VECTOR | size=37.9545×28; xy=5,10; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Medium, State=Enabled/Help Text | 67:27063 | FRAME | size=700×34; xy=0,116; hidden; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Medium, State=Enabled/Help Text/Description | 67:27064 | TEXT | size=668×34; xy=16,0; fill=text/dark/secondary=#131417D6; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Help Text' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Small, State=Focused

- 원본 node: `67:27065`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Focused | 67:27065 | SYMBOL | size=700×80; xy=40,180; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=12; bind=STACK_SPACING→fields/text/small/help_text_gap_vertical |
| Size=Small, State=Focused/Text Fields | 67:27066 | FRAME | size=700×80; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=24,0,24,0; gap=12; fill=field/background=#FFFFFFFF; stroke=field/focused=#313236FF; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/small/gap_horizontal,STACK_PADDING_LEFT→fields/text/small/padding_horizontal,STACK_PADDING_RIGHT→fields/text/small/padding_horizontal,HEIGHT→fields/text/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/medium/border,BORDER_BOTTOM_WEIGHT→fields/text/medium/border,BORDER_LEFT_WEIGHT→fields/text/medium/border,BORDER_RIGHT_WEIGHT→fields/text/medium/border |
| Size=Small, State=Focused/Text Fields/Text area | 67:27067 | FRAME | size=652×38; xy=24,21; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildPrimaryGrow=1 |
| Size=Small, State=Focused/Text Fields/Text area/Place holder | 67:27068 | TEXT | size=652×38; xy=0,0; fill=text/dark/tertiary=#131417A3; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Normal; maxLines=1; truncate=ENDING; text='Place holder' |
| Size=Small, State=Focused/Text Fields/Text area/cursor | 67:27069 | ROUNDED_RECTANGLE | size=3×32; xy=0,3; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Focused/Text Fields/ic_eye | 67:27070 → 67:26985 | INSTANCE | size=40×40; xy=636,20; hidden; bind=WIDTH→fields/text/small/suffix_icon_square,HEIGHT→fields/text/small/suffix_icon_square |
| Size=Small, State=Focused/Text Fields/ic_eye/Path | 67:26986 | VECTOR | size=31.6288×23.3333; xy=4.1667,8.3333; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Focused/Text Fields/ic_eye/Icon | 67:26987 | VECTOR | size=31.6288×23.3333; xy=4.1667,8.3333; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Small, State=Focused/Help Text | 67:27071 | FRAME | size=700×34; xy=0,92; hidden; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Small, State=Focused/Help Text/Description | 67:27072 | TEXT | size=668×34; xy=16,0; fill=text/dark/secondary=#131417D6; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Help Text' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Medium, State=Focused

- 원본 node: `67:27073`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Focused | 67:27073 | SYMBOL | size=700×100; xy=840,180; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=16; bind=STACK_SPACING→fields/text/medium/help_text_gap_vertical |
| Size=Medium, State=Focused/Text Fields | 67:27074 | FRAME | size=700×100; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=32,0,32,0; gap=16; fill=field/background=#FFFFFFFF; stroke=field/focused=#313236FF; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/medium/gap_horizontal,STACK_PADDING_LEFT→fields/text/medium/padding_horizontal,STACK_PADDING_RIGHT→fields/text/medium/padding_horizontal,HEIGHT→fields/text/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/medium/border,BORDER_BOTTOM_WEIGHT→fields/text/medium/border,BORDER_LEFT_WEIGHT→fields/text/medium/border,BORDER_RIGHT_WEIGHT→fields/text/medium/border |
| Size=Medium, State=Focused/Text Fields/Text area | 67:27075 | FRAME | size=636×44; xy=32,28; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildPrimaryGrow=1 |
| Size=Medium, State=Focused/Text Fields/Text area/Place holder | 67:27076 | TEXT | size=636×44; xy=0,0; fill=text/dark/tertiary=#131417A3; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Normal; maxLines=1; truncate=ENDING; text='Place holder' |
| Size=Medium, State=Focused/Text Fields/Text area/cursor | 67:27077 | ROUNDED_RECTANGLE | size=3×32; xy=0,6; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Focused/Text Fields/ic_eye | 67:27078 → 67:26985 | INSTANCE | size=48×48; xy=620,26; hidden; bind=WIDTH→fields/text/medium/suffix_icon_square,HEIGHT→fields/text/medium/suffix_icon_square |
| Size=Medium, State=Focused/Text Fields/ic_eye/Path | 67:26986 | VECTOR | size=37.9545×28; xy=5,10; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Focused/Text Fields/ic_eye/Icon | 67:26987 | VECTOR | size=37.9545×28; xy=5,10; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Medium, State=Focused/Help Text | 67:27079 | FRAME | size=700×34; xy=0,116; hidden; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Medium, State=Focused/Help Text/Description | 67:27080 | TEXT | size=668×34; xy=16,0; fill=text/dark/secondary=#131417D6; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Help Text' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Small, State=Typing

- 원본 node: `67:27081`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Typing | 67:27081 | SYMBOL | size=700×80; xy=40,320; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=0,0,0,0; gap=12; bind=STACK_SPACING→fields/text/small/help_text_gap_vertical |
| Size=Small, State=Typing/Text Fields | 67:27082 | FRAME | size=700×80; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=24,0,24,0; gap=12; fill=field/background=#FFFFFFFF; stroke=field/focused=#313236FF; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/small/gap_horizontal,STACK_PADDING_LEFT→fields/text/small/padding_horizontal,STACK_PADDING_RIGHT→fields/text/small/padding_horizontal,HEIGHT→fields/text/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/medium/border,BORDER_BOTTOM_WEIGHT→fields/text/medium/border,BORDER_LEFT_WEIGHT→fields/text/medium/border,BORDER_RIGHT_WEIGHT→fields/text/medium/border |
| Size=Small, State=Typing/Text Fields/Text area | 67:27083 | FRAME | size=600×38; xy=24,21; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=4; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildPrimaryGrow=1 |
| Size=Small, State=Typing/Text Fields/Text area/Typing | 67:27084 | TEXT | size=91×38; xy=0,0; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Normal; maxLines=1; truncate=ENDING; text='Typing' |
| Size=Small, State=Typing/Text Fields/Text area/cursor | 67:27085 | ROUNDED_RECTANGLE | size=3×32; xy=95,3; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Typing/Text Fields/ic_close | 67:27086 → 67:22420 | INSTANCE | size=40×40; xy=636,20; bind=WIDTH→fields/text/small/suffix_icon_square,HEIGHT→fields/text/small/suffix_icon_square |
| Size=Small, State=Typing/Text Fields/ic_close/Path | 67:22421 | BOOLEAN_OPERATION | size=33.334×33.334; xy=3.333,3.333; hidden; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Small, State=Typing/Text Fields/ic_close/Path/Ellipse 8009 | 67:22422 | ELLIPSE | size=33.3333×33.3333; xy=0.0003,0.0003; fill=#D9D9D9FF |
| Size=Small, State=Typing/Text Fields/ic_close/Path/Path | 67:22423 | BOOLEAN_OPERATION | size=15.1664×15.1664; xy=9.0841,9.0841; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Small, State=Typing/Text Fields/ic_close/Path/Path/Vector 5947 | 67:22424 | VECTOR | size=11.6667×11.6667; xy=1.7495,1.7495; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Small, State=Typing/Text Fields/ic_close/Path/Path/Vector 5948 | 67:22425 | VECTOR | size=11.6667×11.6667; xy=1.7495,1.7495; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Small, State=Typing/Text Fields/ic_close/Path | 67:22426 | VECTOR | size=33.3333×33.3333; xy=3.3333,3.3333; fill=icon/dark/secondary=#1B1C1ECC |
| Size=Small, State=Typing/Text Fields/ic_eye | 67:27087 → 67:26985 | INSTANCE | size=40×40; xy=636,20; hidden; bind=WIDTH→fields/text/small/suffix_icon_square,HEIGHT→fields/text/small/suffix_icon_square |
| Size=Small, State=Typing/Text Fields/ic_eye/Path | 67:26986 | VECTOR | size=31.6288×23.3333; xy=4.1667,8.3333; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Typing/Text Fields/ic_eye/Icon | 67:26987 | VECTOR | size=31.6288×23.3333; xy=4.1667,8.3333; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Small, State=Typing/Help Text | 67:27088 | FRAME | size=700×34; xy=0,92; hidden; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Small, State=Typing/Help Text/Description | 67:27089 | TEXT | size=668×34; xy=16,0; fill=text/dark/secondary=#131417D6; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Help Text' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Medium, State=Typing

- 원본 node: `67:27090`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Typing | 67:27090 | SYMBOL | size=700×100; xy=840,320; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=0,0,0,0; gap=16; bind=STACK_SPACING→fields/text/medium/help_text_gap_vertical |
| Size=Medium, State=Typing/Text Fields | 67:27091 | FRAME | size=700×100; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=32,0,32,0; gap=16; fill=field/background=#FFFFFFFF; stroke=field/focused=#313236FF; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/medium/gap_horizontal,STACK_PADDING_LEFT→fields/text/medium/padding_horizontal,STACK_PADDING_RIGHT→fields/text/medium/padding_horizontal,HEIGHT→fields/text/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/medium/border,BORDER_BOTTOM_WEIGHT→fields/text/medium/border,BORDER_LEFT_WEIGHT→fields/text/medium/border,BORDER_RIGHT_WEIGHT→fields/text/medium/border |
| Size=Medium, State=Typing/Text Fields/Text area | 67:27092 | FRAME | size=572×44; xy=32,28; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildPrimaryGrow=1 |
| Size=Medium, State=Typing/Text Fields/Text area/Typing | 67:27093 | TEXT | size=109×44; xy=0,0; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Normal; maxLines=1; truncate=ENDING; text='Typing' |
| Size=Medium, State=Typing/Text Fields/Text area/cursor | 67:27094 | ROUNDED_RECTANGLE | size=3×32; xy=109,6; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Typing/Text Fields/ic_close | 67:27095 → 67:22420 | INSTANCE | size=48×48; xy=620,26; bind=WIDTH→fields/text/medium/suffix_icon_square,HEIGHT→fields/text/medium/suffix_icon_square |
| Size=Medium, State=Typing/Text Fields/ic_close/Path | 67:22421 | BOOLEAN_OPERATION | size=40×40; xy=4,4; hidden; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Typing/Text Fields/ic_close/Path/Ellipse 8009 | 67:22422 | ELLIPSE | size=40×40; xy=0,0; fill=#D9D9D9FF |
| Size=Medium, State=Typing/Text Fields/ic_close/Path/Path | 67:22423 | BOOLEAN_OPERATION | size=17.4997×17.4997; xy=11.25,11.25; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Typing/Text Fields/ic_close/Path/Path/Vector 5947 | 67:22424 | VECTOR | size=14×14; xy=1.75,1.75; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Medium, State=Typing/Text Fields/ic_close/Path/Path/Vector 5948 | 67:22425 | VECTOR | size=14×14; xy=1.75,1.75; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Medium, State=Typing/Text Fields/ic_close/Path | 67:22426 | VECTOR | size=40×40; xy=4,4; fill=icon/dark/secondary=#1B1C1ECC |
| Size=Medium, State=Typing/Text Fields/ic_eye | 67:27096 → 67:26985 | INSTANCE | size=48×48; xy=620,26; hidden; bind=WIDTH→fields/text/medium/suffix_icon_square,HEIGHT→fields/text/medium/suffix_icon_square |
| Size=Medium, State=Typing/Text Fields/ic_eye/Path | 67:26986 | VECTOR | size=37.9545×28; xy=5,10; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Typing/Text Fields/ic_eye/Icon | 67:26987 | VECTOR | size=37.9545×28; xy=5,10; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Medium, State=Typing/Help Text | 67:27097 | FRAME | size=700×34; xy=0,116; hidden; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Medium, State=Typing/Help Text/Description | 67:27098 | TEXT | size=668×34; xy=16,0; fill=text/dark/secondary=#131417D6; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Help Text' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Small, State=Entered

- 원본 node: `67:27099`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Entered | 67:27099 | SYMBOL | size=700×80; xy=40,460; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=12; bind=STACK_SPACING→fields/text/small/help_text_gap_vertical |
| Size=Small, State=Entered/Text Fields | 67:27100 | FRAME | size=700×80; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=24,0,24,0; gap=12; fill=field/background=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/small/gap_horizontal,STACK_PADDING_LEFT→fields/text/small/padding_horizontal,STACK_PADDING_RIGHT→fields/text/small/padding_horizontal,HEIGHT→fields/text/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/small/border,BORDER_BOTTOM_WEIGHT→fields/text/small/border,BORDER_LEFT_WEIGHT→fields/text/small/border,BORDER_RIGHT_WEIGHT→fields/text/small/border |
| Size=Small, State=Entered/Text Fields/Place holder | 67:27101 | TEXT | size=652×38; xy=24,21; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Normal; maxLines=1; truncate=ENDING; text='Place holder' |
| Size=Small, State=Entered/Text Fields/ic_eye | 67:27102 → 67:26985 | INSTANCE | size=40×40; xy=636,20; hidden; bind=WIDTH→fields/text/small/suffix_icon_square,HEIGHT→fields/text/small/suffix_icon_square |
| Size=Small, State=Entered/Text Fields/ic_eye/Path | 67:26986 | VECTOR | size=31.6288×23.3333; xy=4.1667,8.3333; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Entered/Text Fields/ic_eye/Icon | 67:26987 | VECTOR | size=31.6288×23.3333; xy=4.1667,8.3333; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Small, State=Entered/Help Text | 67:27103 | FRAME | size=700×34; xy=0,92; hidden; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Small, State=Entered/Help Text/Description | 67:27104 | TEXT | size=668×34; xy=16,0; fill=text/dark/secondary=#131417D6; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Help Text' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Medium, State=Entered

- 원본 node: `67:27105`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Entered | 67:27105 | SYMBOL | size=700×100; xy=840,460; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=16; bind=STACK_SPACING→fields/text/medium/help_text_gap_vertical |
| Size=Medium, State=Entered/Text Fields | 67:27106 | FRAME | size=700×100; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=32,0,32,0; gap=16; fill=field/background=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/medium/gap_horizontal,STACK_PADDING_LEFT→fields/text/medium/padding_horizontal,STACK_PADDING_RIGHT→fields/text/medium/padding_horizontal,HEIGHT→fields/text/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/small/border,BORDER_BOTTOM_WEIGHT→fields/text/small/border,BORDER_LEFT_WEIGHT→fields/text/small/border,BORDER_RIGHT_WEIGHT→fields/text/small/border |
| Size=Medium, State=Entered/Text Fields/Place holder | 67:27107 | TEXT | size=636×44; xy=32,28; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Normal; maxLines=1; truncate=ENDING; text='Place holder' |
| Size=Medium, State=Entered/Text Fields/ic_eye | 67:27108 → 67:26985 | INSTANCE | size=48×48; xy=620,26; hidden; bind=WIDTH→fields/text/medium/suffix_icon_square,HEIGHT→fields/text/medium/suffix_icon_square |
| Size=Medium, State=Entered/Text Fields/ic_eye/Path | 67:26986 | VECTOR | size=37.9545×28; xy=5,10; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Entered/Text Fields/ic_eye/Icon | 67:26987 | VECTOR | size=37.9545×28; xy=5,10; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Medium, State=Entered/Help Text | 67:27109 | FRAME | size=700×34; xy=0,116; hidden; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Medium, State=Entered/Help Text/Description | 67:27110 | TEXT | size=668×34; xy=16,0; fill=text/dark/secondary=#131417D6; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Help Text' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Small, State=Read Only

- 원본 node: `67:27111`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Read Only | 67:27111 | SYMBOL | size=700×80; xy=40,600; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=0,0,0,0; gap=12; bind=STACK_SPACING→fields/text/small/help_text_gap_vertical |
| Size=Small, State=Read Only/Text Fields | 67:27112 | FRAME | size=700×80; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=24,0,24,0; gap=12; fill=surface/high=#EDEEF2FF; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/small/gap_horizontal,STACK_PADDING_LEFT→fields/text/small/padding_horizontal,STACK_PADDING_RIGHT→fields/text/small/padding_horizontal,HEIGHT→fields/text/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/small/border,BORDER_BOTTOM_WEIGHT→fields/text/small/border,BORDER_LEFT_WEIGHT→fields/text/small/border,BORDER_RIGHT_WEIGHT→fields/text/small/border |
| Size=Small, State=Read Only/Text Fields/Place holder | 67:27113 | TEXT | size=652×38; xy=24,21; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Normal; maxLines=1; truncate=ENDING; text='Place holder' |
| Size=Small, State=Read Only/Help Text | 67:27114 | FRAME | size=700×34; xy=0,92; hidden; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Small, State=Read Only/Help Text/Description | 67:27115 | TEXT | size=668×34; xy=16,0; fill=text/dark/secondary=#131417D6; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Help Text' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Medium, State=Read Only

- 원본 node: `67:27116`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Read Only | 67:27116 | SYMBOL | size=700×100; xy=840,600; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=16; bind=STACK_SPACING→fields/text/medium/help_text_gap_vertical |
| Size=Medium, State=Read Only/Text Fields | 67:27117 | FRAME | size=700×100; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=32,0,32,0; gap=16; fill=surface/high=#EDEEF2FF; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/medium/gap_horizontal,STACK_PADDING_LEFT→fields/text/medium/padding_horizontal,STACK_PADDING_RIGHT→fields/text/medium/padding_horizontal,HEIGHT→fields/text/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/small/border,BORDER_BOTTOM_WEIGHT→fields/text/small/border,BORDER_LEFT_WEIGHT→fields/text/small/border,BORDER_RIGHT_WEIGHT→fields/text/small/border |
| Size=Medium, State=Read Only/Text Fields/Place holder | 67:27118 | TEXT | size=636×44; xy=32,28; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Normal; maxLines=1; truncate=ENDING; text='Place holder' |
| Size=Medium, State=Read Only/Help Text | 67:27119 | FRAME | size=700×34; xy=0,116; hidden; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Medium, State=Read Only/Help Text/Description | 67:27120 | TEXT | size=668×34; xy=16,0; fill=text/dark/secondary=#131417D6; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Help Text' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Small, State=Error

- 원본 node: `67:27121`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Error | 67:27121 | SYMBOL | size=700×126; xy=40,740; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=12; bind=STACK_SPACING→fields/text/small/help_text_gap_vertical |
| Size=Small, State=Error/Text Fields | 67:27122 | FRAME | size=700×80; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=24,0,24,0; gap=12; fill=field/background=#FFFFFFFF; stroke=regulation/red=#F62E24FF; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/small/gap_horizontal,STACK_PADDING_LEFT→fields/text/small/padding_horizontal,STACK_PADDING_RIGHT→fields/text/small/padding_horizontal,HEIGHT→fields/text/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/medium/border,BORDER_BOTTOM_WEIGHT→fields/text/medium/border,BORDER_LEFT_WEIGHT→fields/text/medium/border,BORDER_RIGHT_WEIGHT→fields/text/medium/border |
| Size=Small, State=Error/Text Fields/Place holder | 67:27123 | TEXT | size=652×38; xy=24,21; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Normal; maxLines=1; truncate=ENDING; text='Place holder' |
| Size=Small, State=Error/Text Fields/ic_close | 67:27124 → 67:22420 | INSTANCE | size=40×40; xy=580,20; hidden; bind=WIDTH→fields/text/small/suffix_icon_square,HEIGHT→fields/text/small/suffix_icon_square |
| Size=Small, State=Error/Text Fields/ic_close/Path | 67:22421 | BOOLEAN_OPERATION | size=33.334×33.334; xy=3.333,3.333; hidden; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Small, State=Error/Text Fields/ic_close/Path/Ellipse 8009 | 67:22422 | ELLIPSE | size=33.3333×33.3333; xy=0.0003,0.0003; fill=#D9D9D9FF |
| Size=Small, State=Error/Text Fields/ic_close/Path/Path | 67:22423 | BOOLEAN_OPERATION | size=15.1664×15.1664; xy=9.0841,9.0841; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Small, State=Error/Text Fields/ic_close/Path/Path/Vector 5947 | 67:22424 | VECTOR | size=11.6667×11.6667; xy=1.7495,1.7495; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Small, State=Error/Text Fields/ic_close/Path/Path/Vector 5948 | 67:22425 | VECTOR | size=11.6667×11.6667; xy=1.7495,1.7495; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Small, State=Error/Text Fields/ic_close/Path | 67:22426 | VECTOR | size=33.3333×33.3333; xy=3.3333,3.3333; fill=icon/dark/secondary=#1B1C1ECC |
| Size=Small, State=Error/Text Fields/ic_eye | 67:27125 → 67:26985 | INSTANCE | size=40×40; xy=636,20; hidden; bind=WIDTH→fields/text/small/suffix_icon_square,HEIGHT→fields/text/small/suffix_icon_square |
| Size=Small, State=Error/Text Fields/ic_eye/Path | 67:26986 | VECTOR | size=31.6288×23.3333; xy=4.1667,8.3333; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Error/Text Fields/ic_eye/Icon | 67:26987 | VECTOR | size=31.6288×23.3333; xy=4.1667,8.3333; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Small, State=Error/Help Text | 67:27126 | FRAME | size=700×34; xy=0,92; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Small, State=Error/Help Text/Description | 67:27127 | TEXT | size=668×34; xy=16,0; fill=regulation/red=#F62E24FF; stackChildPrimaryGrow=1; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Please enter a valid email format' |

## ❖ Components/Fields/Frame 1707486467/Frame 1/Col/ivi_text_field/Size=Medium, State=Error

- 원본 node: `67:27128`

- 공개 properties: `[{"name":"Cursor","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Help text","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Suffix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Place holder","type":"TEXT","initialValue":{"textValue":{"characters":"Place holder","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Error | 67:27128 | SYMBOL | size=700×150; xy=840,740; layout=VERTICAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=16; bind=STACK_SPACING→fields/text/medium/help_text_gap_vertical |
| Size=Medium, State=Error/Text Fields | 67:27129 | FRAME | size=700×100; xy=0,0; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=32,0,32,0; gap=16; fill=field/background=#FFFFFFFF; stroke=regulation/red=#F62E24FF; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→fields/text/medium/gap_horizontal,STACK_PADDING_LEFT→fields/text/medium/padding_horizontal,STACK_PADDING_RIGHT→fields/text/medium/padding_horizontal,HEIGHT→fields/text/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/text/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/text/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/text/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/text/medium/radius_bottom_right,BORDER_TOP_WEIGHT→fields/text/medium/border,BORDER_BOTTOM_WEIGHT→fields/text/medium/border,BORDER_LEFT_WEIGHT→fields/text/medium/border,BORDER_RIGHT_WEIGHT→fields/text/medium/border |
| Size=Medium, State=Error/Text Fields/Place holder | 67:27130 | TEXT | size=636×44; xy=32,28; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignVertical=CENTER; font=Asta Sans/Regular/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Normal; maxLines=1; truncate=ENDING; text='Place holder' |
| Size=Medium, State=Error/Text Fields/ic_close | 67:27131 → 67:22420 | INSTANCE | size=48×48; xy=556,26; hidden; bind=WIDTH→fields/text/medium/suffix_icon_square,HEIGHT→fields/text/medium/suffix_icon_square |
| Size=Medium, State=Error/Text Fields/ic_close/Path | 67:22421 | BOOLEAN_OPERATION | size=40×40; xy=4,4; hidden; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Error/Text Fields/ic_close/Path/Ellipse 8009 | 67:22422 | ELLIPSE | size=40×40; xy=0,0; fill=#D9D9D9FF |
| Size=Medium, State=Error/Text Fields/ic_close/Path/Path | 67:22423 | BOOLEAN_OPERATION | size=17.4997×17.4997; xy=11.25,11.25; fill=_Legacy/Scale/Black/Black=#000000FF |
| Size=Medium, State=Error/Text Fields/ic_close/Path/Path/Vector 5947 | 67:22424 | VECTOR | size=14×14; xy=1.75,1.75; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Medium, State=Error/Text Fields/ic_close/Path/Path/Vector 5948 | 67:22425 | VECTOR | size=14×14; xy=1.75,1.75; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=3.5/CENTER |
| Size=Medium, State=Error/Text Fields/ic_close/Path | 67:22426 | VECTOR | size=40×40; xy=4,4; fill=icon/dark/secondary=#1B1C1ECC |
| Size=Medium, State=Error/Text Fields/ic_eye | 67:27132 → 67:26985 | INSTANCE | size=48×48; xy=620,26; hidden; bind=WIDTH→fields/text/medium/suffix_icon_square,HEIGHT→fields/text/medium/suffix_icon_square |
| Size=Medium, State=Error/Text Fields/ic_eye/Path | 67:26986 | VECTOR | size=37.9545×28; xy=5,10; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Error/Text Fields/ic_eye/Icon | 67:26987 | VECTOR | size=37.9545×28; xy=5,10; fill=icon/dark/quaternary=#1B1C1E52 |
| Size=Medium, State=Error/Help Text | 67:27133 | FRAME | size=700×34; xy=0,116; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=16,0,16,0; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH |
| Size=Medium, State=Error/Help Text/Description | 67:27134 | TEXT | size=668×34; xy=16,0; fill=regulation/red=#F62E24FF; stackChildPrimaryGrow=1; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; text='Please enter a valid email format' |

## ❖ Components/Fields/Frame 1707486467/Frame 2/Col/ivi_number_field/Size=Medium, State=Enabled

- 원본 node: `67:27185`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled | 67:27185 | SYMBOL | size=128×128; xy=70,60; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→fields/number/medium_square,HEIGHT→fields/number/medium_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/number/input_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/number/input_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/number/input_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/number/input_radius_bottom_right,BORDER_TOP_WEIGHT→fields/number/border,BORDER_BOTTOM_WEIGHT→fields/number/border,BORDER_LEFT_WEIGHT→fields/number/border,BORDER_RIGHT_WEIGHT→fields/number/border |

## ❖ Components/Fields/Frame 1707486467/Frame 2/Col/ivi_number_field/Size=Medium, State=Focused

- 원본 node: `67:27186`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Focused | 67:27186 | SYMBOL | size=128×128; xy=280,60; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=dim/dark/secondary=#1314171A; stroke=field/focused=#313236FF; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→fields/number/medium_square,HEIGHT→fields/number/medium_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/number/input_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/number/input_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/number/input_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/number/input_radius_bottom_right,BORDER_TOP_WEIGHT→fields/number/border,BORDER_BOTTOM_WEIGHT→fields/number/border,BORDER_LEFT_WEIGHT→fields/number/border,BORDER_RIGHT_WEIGHT→fields/number/border |
| Size=Medium, State=Focused/cursor | 67:27187 | ROUNDED_RECTANGLE | size=4×48; xy=62,40; fill=icon/dark/primary=#131417FF; bind=WIDTH→fields/number/cursor_width,HEIGHT→fields/number/cursor_height |

## ❖ Components/Fields/Frame 1707486467/Frame 2/Col/ivi_number_field/Size=Medium, State=Error

- 원본 node: `67:27188`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Error | 67:27188 | SYMBOL | size=128×128; xy=700,60; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stroke=regulation/red=#F62E24FF; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→fields/number/medium_square,HEIGHT→fields/number/medium_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/number/input_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/number/input_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/number/input_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/number/input_radius_bottom_right,BORDER_TOP_WEIGHT→fields/number/border,BORDER_BOTTOM_WEIGHT→fields/number/border,BORDER_LEFT_WEIGHT→fields/number/border,BORDER_RIGHT_WEIGHT→fields/number/border |
| Size=Medium, State=Error/3 | 67:27189 | TEXT | size=128×128; xy=0,0; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/ExtraBold/60; line=80/PIXELS; letter=0/PERCENT; textStyle=Headline/Large/Extra_Strong; text='3' |

## ❖ Components/Fields/Frame 1707486467/Frame 2/Col/ivi_number_field/Size=Medium, State=Entered

- 원본 node: `67:27190`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Entered | 67:27190 | SYMBOL | size=128×128; xy=490,60; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→fields/number/medium_square,HEIGHT→fields/number/medium_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/number/input_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/number/input_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/number/input_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/number/input_radius_bottom_right,BORDER_TOP_WEIGHT→fields/number/border,BORDER_BOTTOM_WEIGHT→fields/number/border,BORDER_LEFT_WEIGHT→fields/number/border,BORDER_RIGHT_WEIGHT→fields/number/border |
| Size=Medium, State=Entered/3 | 67:27191 | TEXT | size=128×128; xy=0,0; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/ExtraBold/60; line=80/PIXELS; letter=0/PERCENT; textStyle=Headline/Large/Extra_Strong; text='3' |

## ❖ Components/Fields/Frame 1707486467/Frame 2/Col/ivi_number_field/Size=Large, State=Enabled

- 원본 node: `67:27192`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Enabled | 67:27192 | SYMBOL | size=140×180; xy=60,270; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→fields/number/large_width,HEIGHT→fields/number/large_height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/number/input_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/number/input_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/number/input_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/number/input_radius_bottom_right,BORDER_TOP_WEIGHT→fields/number/border,BORDER_BOTTOM_WEIGHT→fields/number/border,BORDER_LEFT_WEIGHT→fields/number/border,BORDER_RIGHT_WEIGHT→fields/number/border |
| Size=Large, State=Enabled/l | 67:27193 | TEXT | size=128×192; xy=16,16; hidden; fill=#252525FF; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/56; line=74/PIXELS; letter=0/PERCENT; text='l' |

## ❖ Components/Fields/Frame 1707486467/Frame 2/Col/ivi_number_field/Size=Large, State=Focused

- 원본 node: `67:27194`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Focused | 67:27194 | SYMBOL | size=140×180; xy=270,270; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=dim/dark/secondary=#1314171A; stroke=field/focused=#313236FF; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→fields/number/large_width,HEIGHT→fields/number/large_height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/number/input_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/number/input_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/number/input_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/number/input_radius_bottom_right,BORDER_TOP_WEIGHT→fields/number/border,BORDER_BOTTOM_WEIGHT→fields/number/border,BORDER_LEFT_WEIGHT→fields/number/border,BORDER_RIGHT_WEIGHT→fields/number/border |
| Size=Large, State=Focused/cursor | 67:27195 | ROUNDED_RECTANGLE | size=4×48; xy=68,66; fill=icon/dark/primary=#131417FF; bind=WIDTH→fields/number/cursor_width,HEIGHT→fields/number/cursor_height |

## ❖ Components/Fields/Frame 1707486467/Frame 2/Col/ivi_number_field/Size=Large, State=Error

- 원본 node: `67:27196`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Error | 67:27196 | SYMBOL | size=140×180; xy=690,270; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stroke=regulation/red=#F62E24FF; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_SPACING→Spacing/0,STACK_PADDING_LEFT→Spacing/0,STACK_PADDING_TOP→Spacing/0,STACK_PADDING_RIGHT→Spacing/0,STACK_PADDING_BOTTOM→Spacing/0,WIDTH→fields/number/large_width,HEIGHT→fields/number/large_height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/number/input_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/number/input_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/number/input_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/number/input_radius_bottom_right,BORDER_TOP_WEIGHT→fields/number/border,BORDER_BOTTOM_WEIGHT→fields/number/border,BORDER_LEFT_WEIGHT→fields/number/border,BORDER_RIGHT_WEIGHT→fields/number/border |
| Size=Large, State=Error/3 | 67:27197 | TEXT | size=140×180; xy=0,0; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/ExtraBold/60; line=80/PIXELS; letter=0/PERCENT; textStyle=Headline/Large/Extra_Strong; text='3' |

## ❖ Components/Fields/Frame 1707486467/Frame 2/Col/ivi_number_field/Size=Large, State=Entered

- 원본 node: `67:27198`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Entered | 67:27198 | SYMBOL | size=140×180; xy=480,270; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stroke=divider/secondary=#1314171A; strokeWidth=4/INSIDE; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=WIDTH→fields/number/large_width,HEIGHT→fields/number/large_height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→fields/number/input_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→fields/number/input_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→fields/number/input_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→fields/number/input_radius_bottom_right,BORDER_TOP_WEIGHT→fields/number/border,BORDER_BOTTOM_WEIGHT→fields/number/border,BORDER_LEFT_WEIGHT→fields/number/border,BORDER_RIGHT_WEIGHT→fields/number/border |
| Size=Large, State=Entered/3 | 67:27199 | TEXT | size=140×180; xy=0,0; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/ExtraBold/60; line=80/PIXELS; letter=0/PERCENT; textStyle=Headline/Large/Extra_Strong; text='3' |

