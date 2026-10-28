# Figma assets — 컴포넌트 및 하위 레이어 해석 부록

> **원본 부록:** 웹과 다른 옛 값은 이력이다. 최신 구현은 01·02·03·08번의 웹 최종값을 적용한다. 원본 snapshot 색을 새 웹 token 위에 다시 덮지 않는다.

원본 SYMBOL의 레이어 및 INSTANCE의 master 기본값, symbolOverrides, derivedSymbolData, componentPropAssignments를 병합한 오프라인 참조이다. 모든 치수는 원본 design unit이며 root xy는 디자인 보드상 위치이므로 런타임 위치로 복사하지 않는다. child xy는 부모 상대 좌표이다. r 순서는 TL/TR/BR/BL, padding 순서는 L/T/R/B이다.

fill/stroke의 HEX는 `#RRGGBBAA`이며 원본 color alpha×paint.opacity를 합성한 스냅샷 값이다. theme 동작에는 별도 전체 토큰 표와 웹 기준 충돌 해결 규칙을 적용한다. 노드 opacity는 별도로 표시한다. `hidden`은 예제에서 꺼진 옵션이며 구현에서 삭제하라는 뜻이 아니다. master의 드롭다운/토글/Label 등 공개 property도 구현 대상이다.

이 표는 바이너리 파싱 없이 geometry/style/variant를 참조하도록 만든다. Figma 렌더러 전체를 재구현한 것은 아니므로 boolean geometry·clip·특수 효과의 pixel 일치는 SVG 및 원본 guide와 검증한다. 외부 master 누락은 마지막 해석 결과에 별도로 남긴다.


## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/ivi_slider_centered/Type=Button, OFF=False

- 원본 node: `67:24493`

- 공개 properties: `[{"name":"OFF","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Button, OFF=False | 67:24493 | SYMBOL | size=532×100; xy=20,20; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=10,10,10,10; gap=16; fill=climate/slider_background=#FFFFFFFF; stroke=climate/button_border_enabled=#13141733; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; bind=STACK_SPACING→controller/slider/gap_horizontal_large,STACK_PADDING_LEFT→controller/slider/padding_horizontal_small,STACK_PADDING_TOP→controller/slider/padding_vertical_medium,STACK_PADDING_RIGHT→controller/slider/padding_horizontal_small,STACK_PADDING_BOTTOM→controller/slider/padding_vertical_medium,HEIGHT→controller/slider/height_large,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_medium,BORDER_BOTTOM_WEIGHT→controller/slider/border_medium,BORDER_LEFT_WEIGHT→controller/slider/border_medium,BORDER_RIGHT_WEIGHT→controller/slider/border_medium |
| Type=Button, OFF=False/ivi_icon_button | 67:24494 → 67:24346 | INSTANCE | size=80×80; xy=10,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Type=Button, OFF=False/ivi_icon_button/ic_plus | 67:24347 → 67:22096 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Button, OFF=False/ivi_icon_button/ic_plus/Path | 67:22097 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Button, OFF=False/ivi_icon_button/ic_plus/Icon | 67:22098 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/primary=#131417FF |
| Type=Button, OFF=False/slider_track | 67:24495 → 67:24518 | INSTANCE | size=320×8; xy=106,46; r(TL,TR,BR,BL)=999,999,999,999; fill=GRADIENT_LINEAR; stackPrimarySizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| Type=Button, OFF=False/slider_track/slider_knob | 67:24519 → 67:24529 | INSTANCE | size=48×48; xy=136,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; stackChildPrimaryGrow=0; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| Type=Button, OFF=False/slider_track/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| Type=Button, OFF=False/ivi_icon_button | 67:24496 → 67:24346 | INSTANCE | size=80×80; xy=442,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Type=Button, OFF=False/ivi_icon_button/ic_plus | 67:24347 → 67:22099 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Button, OFF=False/ivi_icon_button/ic_plus/Path | 67:22100 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Button, OFF=False/ivi_icon_button/ic_plus/Icon | 67:22101 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/ivi_slider_centered/Type=Basic, OFF=False

- 원본 node: `67:24497`

- 공개 properties: `[{"name":"OFF","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Basic, OFF=False | 67:24497 | SYMBOL | size=400×100; xy=20,140; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,12,40,12; gap=16; fill=climate/slider_background=#FFFFFFFF; stroke=climate/button_border_enabled=#13141733; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=STACK_SPACING→controller/slider/gap_horizontal_large,STACK_PADDING_LEFT→controller/slider/padding_horizontal_large,STACK_PADDING_TOP→controller/slider/padding_vertical_large,STACK_PADDING_RIGHT→controller/slider/padding_horizontal_large,STACK_PADDING_BOTTOM→controller/slider/padding_vertical_large,HEIGHT→controller/slider/height_large,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_medium,BORDER_BOTTOM_WEIGHT→controller/slider/border_medium,BORDER_LEFT_WEIGHT→controller/slider/border_medium,BORDER_RIGHT_WEIGHT→controller/slider/border_medium |
| Type=Basic, OFF=False/slider_track | 67:24498 → 67:24518 | INSTANCE | size=320×8; xy=40,46; r(TL,TR,BR,BL)=999,999,999,999; fill=GRADIENT_LINEAR; stackPrimarySizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| Type=Basic, OFF=False/slider_track/slider_knob | 67:24519 → 67:24529 | INSTANCE | size=48×48; xy=136,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; stackChildPrimaryGrow=0; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| Type=Basic, OFF=False/slider_track/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/ivi_slider_centered/Type=Number, OFF=False

- 원본 node: `67:24499`

- 공개 properties: `[{"name":"OFF","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Number, OFF=False | 67:24499 | SYMBOL | size=529×100; xy=20,260; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,12,40,12; gap=16; fill=climate/slider_background=#FFFFFFFF; stroke=climate/button_border_enabled=#13141733; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=STACK_SPACING→controller/slider/gap_horizontal_large,STACK_PADDING_LEFT→controller/slider/padding_horizontal_large,STACK_PADDING_TOP→controller/slider/padding_vertical_large,STACK_PADDING_RIGHT→controller/slider/padding_horizontal_large,STACK_PADDING_BOTTOM→controller/slider/padding_vertical_large,HEIGHT→controller/slider/height_large,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_medium,BORDER_BOTTOM_WEIGHT→controller/slider/border_medium,BORDER_LEFT_WEIGHT→controller/slider/border_medium,BORDER_RIGHT_WEIGHT→controller/slider/border_medium |
| Type=Number, OFF=False/temp | 67:24500 | FRAME | size=113×76; xy=40,12; layout=HORIZONTAL/CENTER/BASELINE; padding(L,T,R,B)=0,0,0,0; gap=0; stackChildAlignSelf=STRETCH |
| Type=Number, OFF=False/temp/20 | 67:24501 | TEXT | size=75×76; xy=0,0; fill=text/dark/primary=#131417FF; stackChildAlignSelf=STRETCH; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/60; line=68/PIXELS; letter=0/PERCENT; text='20'; bind=WIDTH→gnb/temperature/number_width,FONT_SIZE→size_sp/level18,LINE_HEIGHT→line_height_sp/level16 |
| Type=Number, OFF=False/temp/.0 | 67:24502 | TEXT | size=38×62; xy=75,14; fill=text/dark/primary=#131417FF; textAlignVertical=CENTER; font=Asta Sans/ExtraBold/40; line=64/PIXELS; letter=0/PERCENT; text='.0'; bind=WIDTH→gnb/temperature/decimal_places_witdh,HEIGHT→controller/slider/centered/temporature/text_height,FONT_SIZE→size_sp/level13,LINE_HEIGHT→line_height_sp/level15 |
| Type=Number, OFF=False/slider_track | 67:24503 → 67:24518 | INSTANCE | size=320×8; xy=169,46; r(TL,TR,BR,BL)=999,999,999,999; fill=GRADIENT_LINEAR; stackPrimarySizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| Type=Number, OFF=False/slider_track/slider_knob | 67:24519 → 67:24529 | INSTANCE | size=48×48; xy=136,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; stackChildPrimaryGrow=0; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| Type=Number, OFF=False/slider_track/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/ivi_slider_centered/Type=Button, OFF=True

- 원본 node: `67:24504`

- 공개 properties: `[{"name":"OFF","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Button, OFF=True | 67:24504 | SYMBOL | size=532×100; xy=20,380; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=10,10,10,10; gap=16; fill=climate/slider_background=#FFFFFFFF; stroke=climate/button_border_enabled=#13141733; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; bind=STACK_SPACING→controller/slider/gap_horizontal_large,STACK_PADDING_LEFT→controller/slider/padding_horizontal_small,STACK_PADDING_TOP→controller/slider/padding_vertical_medium,STACK_PADDING_RIGHT→controller/slider/padding_horizontal_small,STACK_PADDING_BOTTOM→controller/slider/padding_vertical_medium,HEIGHT→controller/slider/height_large,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_medium,BORDER_BOTTOM_WEIGHT→controller/slider/border_medium,BORDER_LEFT_WEIGHT→controller/slider/border_medium,BORDER_RIGHT_WEIGHT→controller/slider/border_medium |
| Type=Button, OFF=True/ivi_icon_button | 67:24505 → 67:24346 | INSTANCE | size=80×80; xy=10,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Type=Button, OFF=True/ivi_icon_button/ic_plus | 67:24347 → 67:22096 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Button, OFF=True/ivi_icon_button/ic_plus/Path | 67:22097 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Button, OFF=True/ivi_icon_button/ic_plus/Icon | 67:22098 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/primary=#131417FF |
| Type=Button, OFF=True/slider_track | 67:24506 → 67:24524 | INSTANCE | size=320×8; xy=106,46; r(TL,TR,BR,BL)=999,999,999,999; fill=basic/200=#E0E1E6FF; stackPrimarySizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| Type=Button, OFF=True/slider_track/slider_knob | 67:24525 → 67:24529 | INSTANCE | size=48×48; xy=136,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| Type=Button, OFF=True/slider_track/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| Type=Button, OFF=True/ivi_icon_button | 67:24507 → 67:24346 | INSTANCE | size=80×80; xy=442,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Type=Button, OFF=True/ivi_icon_button/ic_plus | 67:24347 → 67:22099 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Type=Button, OFF=True/ivi_icon_button/ic_plus/Path | 67:22100 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Button, OFF=True/ivi_icon_button/ic_plus/Icon | 67:22101 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/ivi_slider_centered/Type=Basic, OFF=True

- 원본 node: `67:24508`

- 공개 properties: `[{"name":"OFF","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Basic, OFF=True | 67:24508 | SYMBOL | size=400×100; xy=20,500; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,12,40,12; gap=16; fill=climate/slider_background=#FFFFFFFF; stroke=climate/button_border_enabled=#13141733; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=STACK_SPACING→controller/slider/gap_horizontal_large,STACK_PADDING_LEFT→controller/slider/padding_horizontal_large,STACK_PADDING_TOP→controller/slider/padding_vertical_large,STACK_PADDING_RIGHT→controller/slider/padding_horizontal_large,STACK_PADDING_BOTTOM→controller/slider/padding_vertical_large,HEIGHT→controller/slider/height_large,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_medium,BORDER_BOTTOM_WEIGHT→controller/slider/border_medium,BORDER_LEFT_WEIGHT→controller/slider/border_medium,BORDER_RIGHT_WEIGHT→controller/slider/border_medium |
| Type=Basic, OFF=True/slider_track | 67:24509 → 67:24524 | INSTANCE | size=320×8; xy=40,46; r(TL,TR,BR,BL)=999,999,999,999; fill=basic/200=#E0E1E6FF; stackPrimarySizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| Type=Basic, OFF=True/slider_track/slider_knob | 67:24525 → 67:24529 | INSTANCE | size=48×48; xy=136,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| Type=Basic, OFF=True/slider_track/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/ivi_slider_centered/Type=Number, OFF=True

- 원본 node: `67:24510`

- 공개 properties: `[{"name":"OFF","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Number, OFF=True | 67:24510 | SYMBOL | size=529×100; xy=20,620; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=40,12,40,12; gap=16; fill=climate/slider_background=#FFFFFFFF; stroke=climate/button_border_enabled=#13141733; strokeWidth=3/INSIDE; edgeStroke(T,R,B,L)=3,3,3,3; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=STACK_SPACING→controller/slider/gap_horizontal_large,STACK_PADDING_LEFT→controller/slider/padding_horizontal_large,STACK_PADDING_TOP→controller/slider/padding_vertical_large,STACK_PADDING_RIGHT→controller/slider/padding_horizontal_large,STACK_PADDING_BOTTOM→controller/slider/padding_vertical_large,HEIGHT→controller/slider/height_large,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_medium,BORDER_BOTTOM_WEIGHT→controller/slider/border_medium,BORDER_LEFT_WEIGHT→controller/slider/border_medium,BORDER_RIGHT_WEIGHT→controller/slider/border_medium |
| Type=Number, OFF=True/temp | 67:24511 | FRAME | size=113×76; xy=40,12; layout=HORIZONTAL/CENTER/BASELINE; padding(L,T,R,B)=0,0,0,0; gap=0; stackChildAlignSelf=STRETCH |
| Type=Number, OFF=True/temp/20 | 67:24512 | TEXT | size=75×76; xy=0,0; fill=text/dark/primary=#131417FF; stackChildAlignSelf=STRETCH; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/60; line=68/PIXELS; letter=0/PERCENT; text='20'; bind=WIDTH→gnb/temperature/number_width,FONT_SIZE→size_sp/level18,LINE_HEIGHT→line_height_sp/level16 |
| Type=Number, OFF=True/temp/.0 | 67:24513 | TEXT | size=38×62; xy=75,14; fill=text/dark/primary=#131417FF; textAlignVertical=CENTER; font=Asta Sans/ExtraBold/40; line=64/PIXELS; letter=0/PERCENT; text='.0'; bind=WIDTH→gnb/temperature/decimal_places_witdh,HEIGHT→controller/slider/centered/temporature/text_height,FONT_SIZE→size_sp/level13,LINE_HEIGHT→line_height_sp/level15 |
| Type=Number, OFF=True/slider_track | 67:24514 → 67:24524 | INSTANCE | size=320×8; xy=169,46; r(TL,TR,BR,BL)=999,999,999,999; fill=basic/200=#E0E1E6FF; stackPrimarySizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| Type=Number, OFF=True/slider_track/slider_knob | 67:24525 → 67:24529 | INSTANCE | size=48×48; xy=136,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| Type=Number, OFF=True/slider_track/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/State=Min, OFF=False

- 원본 node: `67:24516`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}},{"name":"OFF","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Min, OFF=False | 67:24516 | SYMBOL | size=320×8; xy=20,50; r(TL,TR,BR,BL)=999,999,999,999; fill=GRADIENT_LINEAR; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| State=Min, OFF=False/slider_knob | 67:24517 → 67:24529 | INSTANCE | size=48×48; xy=0,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| State=Min, OFF=False/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/State=Mid, OFF=False

- 원본 node: `67:24518`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}},{"name":"OFF","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Mid, OFF=False | 67:24518 | SYMBOL | size=320×8; xy=20,128; r(TL,TR,BR,BL)=999,999,999,999; fill=GRADIENT_LINEAR; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| State=Mid, OFF=False/slider_knob | 67:24519 → 67:24529 | INSTANCE | size=48×48; xy=136,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| State=Mid, OFF=False/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/State=Max, OFF=False

- 원본 node: `67:24520`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}},{"name":"OFF","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Max, OFF=False | 67:24520 | SYMBOL | size=320×8; xy=20,206; r(TL,TR,BR,BL)=999,999,999,999; fill=GRADIENT_LINEAR; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| State=Max, OFF=False/slider_knob | 67:24521 → 67:24529 | INSTANCE | size=48×48; xy=272,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| State=Max, OFF=False/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/State=Min, OFF=True

- 원본 node: `67:24522`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}},{"name":"OFF","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Min, OFF=True | 67:24522 | SYMBOL | size=320×8; xy=20,284; r(TL,TR,BR,BL)=999,999,999,999; fill=basic/200=#E0E1E6FF; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| State=Min, OFF=True/slider_knob | 67:24523 → 67:24529 | INSTANCE | size=48×48; xy=0,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| State=Min, OFF=True/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/State=Mid, OFF=True

- 원본 node: `67:24524`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}},{"name":"OFF","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Mid, OFF=True | 67:24524 | SYMBOL | size=320×8; xy=20,362; r(TL,TR,BR,BL)=999,999,999,999; fill=basic/200=#E0E1E6FF; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| State=Mid, OFF=True/slider_knob | 67:24525 → 67:24529 | INSTANCE | size=48×48; xy=136,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| State=Mid, OFF=True/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/State=Max, OFF=True

- 원본 node: `67:24526`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}},{"name":"OFF","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Max, OFF=True | 67:24526 | SYMBOL | size=320×8; xy=20,440; r(TL,TR,BR,BL)=999,999,999,999; fill=basic/200=#E0E1E6FF; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=WIDTH→controller/slider/centered/track/min_width,HEIGHT→controller/slider/centered/track/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/centered/track/radius_bottom_right |
| State=Max, OFF=True/slider_knob | 67:24527 → 67:24529 | INSTANCE | size=48×48; xy=272,-20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| State=Max, OFF=True/slider_knob/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_knob/State=Enabled

- 원본 node: `67:24529`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Enabled | 67:24529 | SYMBOL | size=48×48; xy=20,20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |
| State=Enabled/Ellipse 7731 | 67:24530 | ELLIPSE | size=48×48; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/enabled_circle,HEIGHT→controller/slider/centered/knob/enabled_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_knob/State=Pressed

- 원본 node: `67:24531`

- 공개 properties: `[{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Pressed | 67:24531 | SYMBOL | size=56×56; xy=88,20; r=1000; r(TL,TR,BR,BL)=1000,1000,1000,1000; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE |
| State=Pressed/Ellipse 7731 | 67:24532 | ELLIPSE | size=56×56; xy=0,0; r=1000; fill=basic/700=#313236FF; stroke=climate/slider_background=#FFFFFFFF; strokeWidth=4/INSIDE; bind=STROKE_WEIGHT→controller/slider/border_large,WIDTH→controller/slider/centered/knob/pressed_circle,HEIGHT→controller/slider/centered/knob/pressed_circle |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/ivi_slider_continuous/Size=Large, Type=Basic

- 원본 node: `67:24537`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, Type=Basic | 67:24537 | SYMBOL | size=808×100; xy=40,40; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=20,10,20,10; gap=16; fill=dim/dark/primary=#1314170D; stackPrimarySizing=FIXED; bind=STACK_SPACING→controller/slider/gap_horizontal_large,STACK_PADDING_LEFT→controller/slider/padding_horizontal_medium,STACK_PADDING_TOP→controller/slider/padding_vertical_medium,STACK_PADDING_RIGHT→controller/slider/padding_horizontal_medium,STACK_PADDING_BOTTOM→controller/slider/padding_vertical_medium,HEIGHT→controller/slider/height_large,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/medium/radius_bottom_right |
| Size=Large, Type=Basic/Label | 67:24538 | TEXT | size=180×40; xy=20,30; hidden; fill=text/dark/secondary=#131417D6; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Sound'; bind=WIDTH→controller/slider/continuous/medium/label_width |
| Size=Large, Type=Basic/ivi_icon_button | 67:24539 → 67:24346 | INSTANCE | size=80×80; xy=20,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Size=Large, Type=Basic/ivi_icon_button/ic_plus | 67:24347 → 67:22096 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Size=Large, Type=Basic/ivi_icon_button/ic_plus/Path | 67:22097 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Large, Type=Basic/ivi_icon_button/ic_plus/Icon | 67:22098 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/primary=#131417FF |
| Size=Large, Type=Basic/slider_track | 67:24540 → 67:24569 | INSTANCE | size=576×80; xy=116,10; r(TL,TR,BR,BL)=24,24,24,24; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Large, Type=Basic/slider_track/Knob | 67:24570 | FRAME | size=290×72; xy=4,4; r(TL,TR,BR,BL)=20,0,0,20; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_left |
| Size=Large, Type=Basic/slider_track/ic_sound | 67:24571 → 67:24424 | INSTANCE | size=48×48; xy=20,16; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Large, Type=Basic/slider_track/ic_sound/Path | 67:24425 | FRAME | size=36.9652×29.4542; xy=6,9.2727; hidden |
| Size=Large, Type=Basic/slider_track/ic_sound/Path/Path | 67:24426 | VECTOR | size=8.4652×28.7837; xy=28.5,0.33; fill=icon/dark/quaternary=#13141752 |
| Size=Large, Type=Basic/slider_track/ic_sound/Path/Path | 67:24427 | BOOLEAN_OPERATION | size=29.9253×29.4542; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Large, Type=Basic/slider_track/ic_sound/Path/Path/Vector | 67:24428 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Large, Type=Basic/slider_track/ic_sound/Path/Path/Vector (Stroke) | 67:24429 | VECTOR | size=6.4253×18.7373; xy=23.5,5.3583; fill=#252525FF |
| Size=Large, Type=Basic/slider_track/ic_sound/Icon | 67:24430 | VECTOR | size=36.9652×29.4545; xy=6,9.2727; fill=icon/dark/primary=#131417FF |
| Size=Large, Type=Basic/ivi_icon_button | 67:24541 → 67:24346 | INSTANCE | size=80×80; xy=708,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Size=Large, Type=Basic/ivi_icon_button/ic_plus | 67:24347 → 67:22099 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Size=Large, Type=Basic/ivi_icon_button/ic_plus/Path | 67:22100 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Large, Type=Basic/ivi_icon_button/ic_plus/Icon | 67:22101 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/ivi_slider_continuous/Size=Large, Type=Floating

- 원본 node: `67:24542`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, Type=Floating | 67:24542 | SYMBOL | size=808×100; xy=40,180; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=20,10,20,10; gap=16; fill=background/popup=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; stackPrimarySizing=FIXED; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=STACK_SPACING→controller/slider/gap_horizontal_large,STACK_PADDING_LEFT→controller/slider/padding_horizontal_medium,STACK_PADDING_TOP→controller/slider/padding_vertical_medium,STACK_PADDING_RIGHT→controller/slider/padding_horizontal_medium,STACK_PADDING_BOTTOM→controller/slider/padding_vertical_medium,HEIGHT→controller/slider/height_large,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/medium/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_small,BORDER_BOTTOM_WEIGHT→controller/slider/border_small,BORDER_LEFT_WEIGHT→controller/slider/border_small,BORDER_RIGHT_WEIGHT→controller/slider/border_small |
| Size=Large, Type=Floating/Label | 67:24543 | TEXT | size=180×40; xy=20,30; hidden; fill=text/dark/secondary=#131417D6; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Sound'; bind=WIDTH→controller/slider/continuous/medium/label_width |
| Size=Large, Type=Floating/ivi_icon_button | 67:24544 → 67:24346 | INSTANCE | size=80×80; xy=20,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Size=Large, Type=Floating/ivi_icon_button/ic_plus | 67:24347 → 67:22096 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Size=Large, Type=Floating/ivi_icon_button/ic_plus/Path | 67:22097 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Large, Type=Floating/ivi_icon_button/ic_plus/Icon | 67:22098 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/primary=#131417FF |
| Size=Large, Type=Floating/slider_track | 67:24545 → 67:24569 | INSTANCE | size=576×80; xy=116,10; r(TL,TR,BR,BL)=24,24,24,24; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Large, Type=Floating/slider_track/Knob | 67:24570 | FRAME | size=290×72; xy=4,4; r(TL,TR,BR,BL)=20,0,0,20; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_left |
| Size=Large, Type=Floating/slider_track/ic_sound | 67:24571 → 67:24424 | INSTANCE | size=48×48; xy=20,16; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Large, Type=Floating/slider_track/ic_sound/Path | 67:24425 | FRAME | size=36.9652×29.4542; xy=6,9.2727; hidden |
| Size=Large, Type=Floating/slider_track/ic_sound/Path/Path | 67:24426 | VECTOR | size=8.4652×28.7837; xy=28.5,0.33; fill=icon/dark/quaternary=#13141752 |
| Size=Large, Type=Floating/slider_track/ic_sound/Path/Path | 67:24427 | BOOLEAN_OPERATION | size=29.9253×29.4542; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Large, Type=Floating/slider_track/ic_sound/Path/Path/Vector | 67:24428 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Large, Type=Floating/slider_track/ic_sound/Path/Path/Vector (Stroke) | 67:24429 | VECTOR | size=6.4253×18.7373; xy=23.5,5.3583; fill=#252525FF |
| Size=Large, Type=Floating/slider_track/ic_sound/Icon | 67:24430 | VECTOR | size=36.9652×29.4545; xy=6,9.2727; fill=icon/dark/primary=#131417FF |
| Size=Large, Type=Floating/ivi_icon_button | 67:24546 → 67:24346 | INSTANCE | size=80×80; xy=708,10; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/medium/width,HEIGHT→buttons/icon/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/medium/rounded_radius_bottom_right |
| Size=Large, Type=Floating/ivi_icon_button/ic_plus | 67:24347 → 67:22099 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→buttons/icon/medium/content,HEIGHT→buttons/icon/medium/content |
| Size=Large, Type=Floating/ivi_icon_button/ic_plus/Path | 67:22100 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Large, Type=Floating/ivi_icon_button/ic_plus/Icon | 67:22101 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/ivi_slider_continuous/Size=Medium, Type=Basic

- 원본 node: `67:24547`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, Type=Basic | 67:24547 | SYMBOL | size=560×80; xy=40,320; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=10,8,10,8; gap=12; fill=dim/dark/primary=#1314170D; stackPrimarySizing=FIXED; bind=STACK_SPACING→controller/slider/gap_horizontal_small,STACK_PADDING_LEFT→controller/slider/padding_horizontal_small,STACK_PADDING_TOP→controller/slider/padding_vertical_small,STACK_PADDING_RIGHT→controller/slider/padding_horizontal_small,STACK_PADDING_BOTTOM→controller/slider/padding_vertical_small,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/small/radius_bottom_right |
| Size=Medium, Type=Basic/ivi_icon_button | 67:24548 → 67:24352 | INSTANCE | size=64×64; xy=10,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| Size=Medium, Type=Basic/ivi_icon_button/ic_plus | 67:24353 → 67:22096 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Size=Medium, Type=Basic/ivi_icon_button/ic_plus/Path | 67:22097 | VECTOR | size=12.8333×25.6667; xy=15.5833,9.1667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, Type=Basic/ivi_icon_button/ic_plus/Icon | 67:22098 | VECTOR | size=16.5×29.3333; xy=13.75,7.3333; fill=icon/dark/primary=#131417FF |
| Size=Medium, Type=Basic/slider_track | 67:24549 → 67:24572 | INSTANCE | size=388×64; xy=86,8; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Type=Basic/slider_track/Knob | 67:24573 | FRAME | size=160×56; xy=4,4; r(TL,TR,BR,BL)=16,0,0,16; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_left |
| Size=Medium, Type=Basic/slider_track/ic_sound | 67:24574 → 67:24424 | INSTANCE | size=40×40; xy=20,12; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Medium, Type=Basic/slider_track/ic_sound/Path | 67:24425 | FRAME | size=30.8043×24.5455; xy=5,7.7272; hidden |
| Size=Medium, Type=Basic/slider_track/ic_sound/Path/Path | 67:24426 | VECTOR | size=7.0543×23.9864; xy=23.75,0.275; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, Type=Basic/slider_track/ic_sound/Path/Path | 67:24427 | BOOLEAN_OPERATION | size=24.9376×24.5454; xy=0,0.0002; fill=icon/dark/primary=#131417FF |
| Size=Medium, Type=Basic/slider_track/ic_sound/Path/Path/Vector | 67:24428 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Medium, Type=Basic/slider_track/ic_sound/Path/Path/Vector (Stroke) | 67:24429 | VECTOR | size=5.3544×15.6144; xy=19.5833,4.4651; fill=#252525FF |
| Size=Medium, Type=Basic/slider_track/ic_sound/Icon | 67:24430 | VECTOR | size=30.8043×24.5455; xy=5,7.7273; fill=icon/dark/primary=#131417FF |
| Size=Medium, Type=Basic/ivi_icon_button | 67:24550 → 67:24352 | INSTANCE | size=64×64; xy=486,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| Size=Medium, Type=Basic/ivi_icon_button/ic_plus | 67:24353 → 67:22099 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Size=Medium, Type=Basic/ivi_icon_button/ic_plus/Path | 67:22100 | VECTOR | size=12.8333×25.6667; xy=15.5833,9.1667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, Type=Basic/ivi_icon_button/ic_plus/Icon | 67:22101 | VECTOR | size=16.5×29.3333; xy=13.75,7.3333; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/ivi_slider_continuous/Size=Medium, Type=Floating

- 원본 node: `67:24551`

- 공개 properties: `[{"name":"Label","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, Type=Floating | 67:24551 | SYMBOL | size=560×80; xy=40,440; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=10,8,10,8; gap=12; fill=background/popup=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; stackPrimarySizing=FIXED; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=STACK_SPACING→controller/slider/gap_horizontal_small,STACK_PADDING_LEFT→controller/slider/padding_horizontal_small,STACK_PADDING_TOP→controller/slider/padding_vertical_small,STACK_PADDING_RIGHT→controller/slider/padding_horizontal_small,STACK_PADDING_BOTTOM→controller/slider/padding_vertical_small,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/small/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_small,BORDER_BOTTOM_WEIGHT→controller/slider/border_small,BORDER_LEFT_WEIGHT→controller/slider/border_small,BORDER_RIGHT_WEIGHT→controller/slider/border_small |
| Size=Medium, Type=Floating/Label | 67:24552 | TEXT | size=180×38; xy=10,21; hidden; fill=text/dark/secondary=#131417D6; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Sound'; bind=WIDTH→controller/slider/continuous/medium/label_width |
| Size=Medium, Type=Floating/ivi_icon_button | 67:24553 → 67:24352 | INSTANCE | size=64×64; xy=10,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| Size=Medium, Type=Floating/ivi_icon_button/ic_plus | 67:24353 → 67:22096 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Size=Medium, Type=Floating/ivi_icon_button/ic_plus/Path | 67:22097 | VECTOR | size=12.8333×25.6667; xy=15.5833,9.1667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, Type=Floating/ivi_icon_button/ic_plus/Icon | 67:22098 | VECTOR | size=16.5×29.3333; xy=13.75,7.3333; fill=icon/dark/primary=#131417FF |
| Size=Medium, Type=Floating/slider_track | 67:24554 → 67:24572 | INSTANCE | size=388×64; xy=86,8; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Type=Floating/slider_track/Knob | 67:24573 | FRAME | size=160×56; xy=4,4; r(TL,TR,BR,BL)=16,0,0,16; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_left |
| Size=Medium, Type=Floating/slider_track/ic_sound | 67:24574 → 67:24424 | INSTANCE | size=40×40; xy=20,12; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Medium, Type=Floating/slider_track/ic_sound/Path | 67:24425 | FRAME | size=30.8043×24.5455; xy=5,7.7272; hidden |
| Size=Medium, Type=Floating/slider_track/ic_sound/Path/Path | 67:24426 | VECTOR | size=7.0543×23.9864; xy=23.75,0.275; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, Type=Floating/slider_track/ic_sound/Path/Path | 67:24427 | BOOLEAN_OPERATION | size=24.9376×24.5454; xy=0,0.0002; fill=icon/dark/primary=#131417FF |
| Size=Medium, Type=Floating/slider_track/ic_sound/Path/Path/Vector | 67:24428 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Medium, Type=Floating/slider_track/ic_sound/Path/Path/Vector (Stroke) | 67:24429 | VECTOR | size=5.3544×15.6144; xy=19.5833,4.4651; fill=#252525FF |
| Size=Medium, Type=Floating/slider_track/ic_sound/Icon | 67:24430 | VECTOR | size=30.8043×24.5455; xy=5,7.7273; fill=icon/dark/primary=#131417FF |
| Size=Medium, Type=Floating/ivi_icon_button | 67:24555 → 67:24352 | INSTANCE | size=64×64; xy=486,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| Size=Medium, Type=Floating/ivi_icon_button/ic_plus | 67:24353 → 67:22099 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| Size=Medium, Type=Floating/ivi_icon_button/ic_plus/Path | 67:22100 | VECTOR | size=12.8333×25.6667; xy=15.5833,9.1667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, Type=Floating/ivi_icon_button/ic_plus/Icon | 67:22101 | VECTOR | size=16.5×29.3333; xy=13.75,7.3333; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Medium, State=Enabled, Level=Max

- 원본 node: `67:24557`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, Level=Max | 67:24557 | SYMBOL | size=580×80; xy=40,40; r(TL,TR,BR,BL)=24,24,24,24; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/medium/item_padding,HEIGHT→controller/slider/height_medium,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Medium, State=Enabled, Level=Max/Knob | 67:24558 | FRAME | size=572×72; xy=4,4; r(TL,TR,BR,BL)=20,20,20,20; fill=controller/slider/knop=#FFFFFFFF; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_right |
| Size=Medium, State=Enabled, Level=Max/ic_sound | 67:24559 → 67:24418 | INSTANCE | size=48×48; xy=20,16; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Medium, State=Enabled, Level=Max/ic_sound/Path | 67:24419 | BOOLEAN_OPERATION | size=36.965×29.4542; xy=6,9.2727; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Level=Max/ic_sound/Path/Vector | 67:24420 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Medium, State=Enabled, Level=Max/ic_sound/Path/Vector (Stroke) | 67:24421 | VECTOR | size=8.4652×28.7837; xy=28.5,0.33; fill=#252525FF |
| Size=Medium, State=Enabled, Level=Max/ic_sound/Path/Vector (Stroke) | 67:24422 | VECTOR | size=6.4253×18.7373; xy=23.5,5.3583; fill=#252525FF |
| Size=Medium, State=Enabled, Level=Max/ic_sound/Icon | 67:24423 | VECTOR | size=36.9652×29.4545; xy=6,9.2727; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Small, State=Enabled, Level=Max

- 원본 node: `67:24560`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled, Level=Max | 67:24560 | SYMBOL | size=320×72; xy=640,40; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/small/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/small/item_padding,HEIGHT→controller/slider/height_small,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Small, State=Enabled, Level=Max/Knob | 67:24561 | FRAME | size=312×64; xy=4,4; r(TL,TR,BR,BL)=16,16,16,16; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_right |
| Size=Small, State=Enabled, Level=Max/ic_sound | 67:24562 → 67:24418 | INSTANCE | size=40×40; xy=20,16; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Small, State=Enabled, Level=Max/ic_sound/Path | 67:24419 | BOOLEAN_OPERATION | size=30.8043×24.5454; xy=5,7.7274; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, Level=Max/ic_sound/Path/Vector | 67:24420 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Small, State=Enabled, Level=Max/ic_sound/Path/Vector (Stroke) | 67:24421 | VECTOR | size=7.0543×23.9864; xy=23.75,0.2748; fill=#252525FF |
| Size=Small, State=Enabled, Level=Max/ic_sound/Path/Vector (Stroke) | 67:24422 | VECTOR | size=5.3544×15.6144; xy=19.5833,4.4651; fill=#252525FF |
| Size=Small, State=Enabled, Level=Max/ic_sound/Icon | 67:24423 | VECTOR | size=30.8043×24.5455; xy=5,7.7273; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Medium, State=Enabled, Level=High

- 원본 node: `67:24563`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, Level=High | 67:24563 | SYMBOL | size=580×80; xy=40,140; r(TL,TR,BR,BL)=24,24,24,24; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/medium/item_padding,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Medium, State=Enabled, Level=High/Knob | 67:24564 | FRAME | size=516×72; xy=4,4; r(TL,TR,BR,BL)=20,0,0,20; fill=controller/slider/knop=#FFFFFFFF; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_left |
| Size=Medium, State=Enabled, Level=High/ic_sound | 67:24565 → 67:24418 | INSTANCE | size=48×48; xy=20,16; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Medium, State=Enabled, Level=High/ic_sound/Path | 67:24419 | BOOLEAN_OPERATION | size=36.965×29.4542; xy=6,9.2727; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Level=High/ic_sound/Path/Vector | 67:24420 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Medium, State=Enabled, Level=High/ic_sound/Path/Vector (Stroke) | 67:24421 | VECTOR | size=8.4652×28.7837; xy=28.5,0.33; fill=#252525FF |
| Size=Medium, State=Enabled, Level=High/ic_sound/Path/Vector (Stroke) | 67:24422 | VECTOR | size=6.4253×18.7373; xy=23.5,5.3583; fill=#252525FF |
| Size=Medium, State=Enabled, Level=High/ic_sound/Icon | 67:24423 | VECTOR | size=36.9652×29.4545; xy=6,9.2727; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Small, State=Enabled, Level=High

- 원본 node: `67:24566`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled, Level=High | 67:24566 | SYMBOL | size=320×72; xy=640,140; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/small/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/small/item_padding,HEIGHT→controller/slider/height_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Small, State=Enabled, Level=High/Knob | 67:24567 | FRAME | size=276×64; xy=4,4; r(TL,TR,BR,BL)=16,0,0,16; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_left |
| Size=Small, State=Enabled, Level=High/ic_sound | 67:24568 → 67:24418 | INSTANCE | size=40×40; xy=20,16; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Small, State=Enabled, Level=High/ic_sound/Path | 67:24419 | BOOLEAN_OPERATION | size=30.8043×24.5454; xy=5,7.7274; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, Level=High/ic_sound/Path/Vector | 67:24420 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Small, State=Enabled, Level=High/ic_sound/Path/Vector (Stroke) | 67:24421 | VECTOR | size=7.0543×23.9864; xy=23.75,0.2748; fill=#252525FF |
| Size=Small, State=Enabled, Level=High/ic_sound/Path/Vector (Stroke) | 67:24422 | VECTOR | size=5.3544×15.6144; xy=19.5833,4.4651; fill=#252525FF |
| Size=Small, State=Enabled, Level=High/ic_sound/Icon | 67:24423 | VECTOR | size=30.8043×24.5455; xy=5,7.7273; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Medium, State=Enabled, Level=Mid

- 원본 node: `67:24569`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, Level=Mid | 67:24569 | SYMBOL | size=580×80; xy=40,240; r(TL,TR,BR,BL)=24,24,24,24; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/medium/item_padding,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Medium, State=Enabled, Level=Mid/Knob | 67:24570 | FRAME | size=290×72; xy=4,4; r(TL,TR,BR,BL)=20,0,0,20; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_left |
| Size=Medium, State=Enabled, Level=Mid/ic_sound | 67:24571 → 67:24424 | INSTANCE | size=48×48; xy=20,16; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Medium, State=Enabled, Level=Mid/ic_sound/Path | 67:24425 | FRAME | size=36.9652×29.4542; xy=6,9.2727; hidden |
| Size=Medium, State=Enabled, Level=Mid/ic_sound/Path/Path | 67:24426 | VECTOR | size=8.4652×28.7837; xy=28.5,0.33; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, State=Enabled, Level=Mid/ic_sound/Path/Path | 67:24427 | BOOLEAN_OPERATION | size=29.9253×29.4542; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Level=Mid/ic_sound/Path/Path/Vector | 67:24428 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Medium, State=Enabled, Level=Mid/ic_sound/Path/Path/Vector (Stroke) | 67:24429 | VECTOR | size=6.4253×18.7373; xy=23.5,5.3583; fill=#252525FF |
| Size=Medium, State=Enabled, Level=Mid/ic_sound/Icon | 67:24430 | VECTOR | size=36.9652×29.4545; xy=6,9.2727; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Small, State=Enabled, Level=Mid

- 원본 node: `67:24572`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled, Level=Mid | 67:24572 | SYMBOL | size=320×72; xy=640,240; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/small/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/small/item_padding,HEIGHT→controller/slider/height_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Small, State=Enabled, Level=Mid/Knob | 67:24573 | FRAME | size=160×64; xy=4,4; r(TL,TR,BR,BL)=16,0,0,16; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_left |
| Size=Small, State=Enabled, Level=Mid/ic_sound | 67:24574 → 67:24424 | INSTANCE | size=40×40; xy=20,16; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Small, State=Enabled, Level=Mid/ic_sound/Path | 67:24425 | FRAME | size=30.8043×24.5455; xy=5,7.7272; hidden |
| Size=Small, State=Enabled, Level=Mid/ic_sound/Path/Path | 67:24426 | VECTOR | size=7.0543×23.9864; xy=23.75,0.275; fill=icon/dark/quaternary=#13141752 |
| Size=Small, State=Enabled, Level=Mid/ic_sound/Path/Path | 67:24427 | BOOLEAN_OPERATION | size=24.9376×24.5454; xy=0,0.0002; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, Level=Mid/ic_sound/Path/Path/Vector | 67:24428 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Small, State=Enabled, Level=Mid/ic_sound/Path/Path/Vector (Stroke) | 67:24429 | VECTOR | size=5.3544×15.6144; xy=19.5833,4.4651; fill=#252525FF |
| Size=Small, State=Enabled, Level=Mid/ic_sound/Icon | 67:24430 | VECTOR | size=30.8043×24.5455; xy=5,7.7273; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Medium, State=Enabled, Level=Low

- 원본 node: `67:24575`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, Level=Low | 67:24575 | SYMBOL | size=580×80; xy=40,340; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/medium/item_padding,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Medium, State=Enabled, Level=Low/Knob | 67:24576 | FRAME | size=90×72; xy=4,4; r(TL,TR,BR,BL)=20,0,0,20; fill=controller/slider/knop=#FFFFFFFF; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_left |
| Size=Medium, State=Enabled, Level=Low/ic_sound | 67:24577 → 67:24431 | INSTANCE | size=48×48; xy=20,16; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Medium, State=Enabled, Level=Low/ic_sound/Path | 67:24432 | FRAME | size=36.9652×29.4542; xy=6,9.2727; hidden |
| Size=Medium, State=Enabled, Level=Low/ic_sound/Path/Path | 67:24433 | VECTOR | size=13.4652×28.7837; xy=23.5,0.33; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, State=Enabled, Level=Low/ic_sound/Path/Path | 67:24434 | BOOLEAN_OPERATION | size=19.6367×29.4542; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Level=Low/ic_sound/Path/Path/Vector | 67:24435 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Medium, State=Enabled, Level=Low/ic_sound/Icon | 67:24436 | VECTOR | size=36.9652×29.4545; xy=6,9.2727; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Small, State=Enabled, Level=Low

- 원본 node: `67:24578`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled, Level=Low | 67:24578 | SYMBOL | size=320×72; xy=640,340; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/small/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/small/item_padding,HEIGHT→controller/slider/height_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Small, State=Enabled, Level=Low/Knob | 67:24579 | FRAME | size=70×64; xy=4,4; r(TL,TR,BR,BL)=16,0,0,16; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_left |
| Size=Small, State=Enabled, Level=Low/ic_sound | 67:24580 → 67:24431 | INSTANCE | size=40×40; xy=20,16; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Small, State=Enabled, Level=Low/ic_sound/Path | 67:24432 | FRAME | size=30.8042×24.5455; xy=5,7.7272; hidden |
| Size=Small, State=Enabled, Level=Low/ic_sound/Path/Path | 67:24433 | VECTOR | size=11.221×23.9864; xy=19.5833,0.275; fill=icon/dark/quaternary=#13141752 |
| Size=Small, State=Enabled, Level=Low/ic_sound/Path/Path | 67:24434 | BOOLEAN_OPERATION | size=16.3633×24.5454; xy=0,0.0002; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, Level=Low/ic_sound/Path/Path/Vector | 67:24435 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Small, State=Enabled, Level=Low/ic_sound/Icon | 67:24436 | VECTOR | size=30.8043×24.5455; xy=5,7.7273; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Medium, State=Enabled, Level=Min

- 원본 node: `67:24581`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, Level=Min | 67:24581 | SYMBOL | size=580×80; xy=40,440; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/medium/item_padding,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Medium, State=Enabled, Level=Min/ic_sound | 67:24582 → 67:24437 | INSTANCE | size=48×48; xy=20,18; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Medium, State=Enabled, Level=Min/ic_sound/Path | 67:24438 | FRAME | size=36.9652×31.5992; xy=6,8.7; hidden |
| Size=Medium, State=Enabled, Level=Min/ic_sound/Path/Subtract | 67:24439 | VECTOR | size=13.4652×28.7837; xy=23.5,0.9026; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, State=Enabled, Level=Min/ic_sound/Path/Union | 67:24440 | BOOLEAN_OPERATION | size=33.7997×31.5992; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Level=Min/ic_sound/Path/Union/Subtract | 67:24441 | BOOLEAN_OPERATION | size=19.6367×29.4542; xy=0,0.5727; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Level=Min/ic_sound/Path/Union/Subtract/Path | 67:24442 | BOOLEAN_OPERATION | size=19.6367×29.4542; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Level=Min/ic_sound/Path/Union/Subtract/Path/Vector | 67:24443 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Medium, State=Enabled, Level=Min/ic_sound/Path/Union/Subtract/Vector 5958 | 67:24444 | VECTOR | size=28×28; xy=4.0001,-3.7727; r=10; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Size=Medium, State=Enabled, Level=Min/ic_sound/Path/Union/Vector 5959 | 67:24445 | VECTOR | size=28×28; xy=4.0001,1.8; r=10; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Size=Medium, State=Enabled, Level=Min/ic_sound/Icon | 67:24446 | VECTOR | size=36.9652×31.6; xy=6,8.7001; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Small, State=Enabled, Level=Min

- 원본 node: `67:24583`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled, Level=Min | 67:24583 | SYMBOL | size=320×72; xy=640,440; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/normal=#13141733; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/small/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/small/item_padding,HEIGHT→controller/slider/height_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Small, State=Enabled, Level=Min/ic_sound | 67:24584 → 67:24437 | INSTANCE | size=40×40; xy=20,16; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Small, State=Enabled, Level=Min/ic_sound/Path | 67:24438 | FRAME | size=30.8042×26.933; xy=5,6.9506; hidden |
| Size=Small, State=Enabled, Level=Min/ic_sound/Path/Subtract | 67:24439 | VECTOR | size=11.221×23.9864; xy=19.5833,1.0517; fill=icon/dark/quaternary=#13141752 |
| Size=Small, State=Enabled, Level=Min/ic_sound/Path/Union | 67:24440 | BOOLEAN_OPERATION | size=28.4666×26.933; xy=0,-0.0002; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, Level=Min/ic_sound/Path/Union/Subtract | 67:24441 | BOOLEAN_OPERATION | size=16.3633×24.5453; xy=0,0.7772; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, Level=Min/ic_sound/Path/Union/Subtract/Path | 67:24442 | BOOLEAN_OPERATION | size=16.3633×24.5454; xy=0,-0.0001; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Enabled, Level=Min/ic_sound/Path/Union/Subtract/Path/Vector | 67:24443 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Small, State=Enabled, Level=Min/ic_sound/Path/Union/Subtract/Vector 5958 | 67:24444 | VECTOR | size=23.3333×23.3333; xy=3.3334,-3.1442; r=10; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Size=Small, State=Enabled, Level=Min/ic_sound/Path/Union/Vector 5959 | 67:24445 | VECTOR | size=23.3333×23.3333; xy=3.3334,1.7997; r=10; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Size=Small, State=Enabled, Level=Min/ic_sound/Icon | 67:24446 | VECTOR | size=30.8043×26.3333; xy=5,7.2501; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Medium, State=Pressed, Level=Max

- 원본 node: `67:24585`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed, Level=Max | 67:24585 | SYMBOL | size=580×80; xy=40,540; r(TL,TR,BR,BL)=24,24,24,24; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/pressed=#1314174D; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/medium/item_padding,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Medium, State=Pressed, Level=Max/Knob | 67:24586 | FRAME | size=572×72; xy=4,4; r(TL,TR,BR,BL)=20,20,20,20; fill=controller/slider/knop=#FFFFFFFF; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_right,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_right |
| Size=Medium, State=Pressed, Level=Max/ic_sound | 67:24587 → 67:24418 | INSTANCE | size=48×48; xy=20,16; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Medium, State=Pressed, Level=Max/ic_sound/Path | 67:24419 | BOOLEAN_OPERATION | size=36.965×29.4542; xy=6,9.2727; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, Level=Max/ic_sound/Path/Vector | 67:24420 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Medium, State=Pressed, Level=Max/ic_sound/Path/Vector (Stroke) | 67:24421 | VECTOR | size=8.4652×28.7837; xy=28.5,0.33; fill=#252525FF |
| Size=Medium, State=Pressed, Level=Max/ic_sound/Path/Vector (Stroke) | 67:24422 | VECTOR | size=6.4253×18.7373; xy=23.5,5.3583; fill=#252525FF |
| Size=Medium, State=Pressed, Level=Max/ic_sound/Icon | 67:24423 | VECTOR | size=36.9652×29.4545; xy=6,9.2727; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Small, State=Pressed, Level=Max

- 원본 node: `67:24588`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Pressed, Level=Max | 67:24588 | SYMBOL | size=320×72; xy=640,540; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/pressed=#1314174D; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/small/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/small/item_padding,HEIGHT→controller/slider/height_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Small, State=Pressed, Level=Max/Knob | 67:24589 | FRAME | size=312×64; xy=4,4; r(TL,TR,BR,BL)=16,16,16,16; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_right |
| Size=Small, State=Pressed, Level=Max/ic_sound | 67:24590 → 67:24418 | INSTANCE | size=40×40; xy=20,16; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Small, State=Pressed, Level=Max/ic_sound/Path | 67:24419 | BOOLEAN_OPERATION | size=30.8043×24.5454; xy=5,7.7274; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, Level=Max/ic_sound/Path/Vector | 67:24420 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Small, State=Pressed, Level=Max/ic_sound/Path/Vector (Stroke) | 67:24421 | VECTOR | size=7.0543×23.9864; xy=23.75,0.2748; fill=#252525FF |
| Size=Small, State=Pressed, Level=Max/ic_sound/Path/Vector (Stroke) | 67:24422 | VECTOR | size=5.3544×15.6144; xy=19.5833,4.4651; fill=#252525FF |
| Size=Small, State=Pressed, Level=Max/ic_sound/Icon | 67:24423 | VECTOR | size=30.8043×24.5455; xy=5,7.7273; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Medium, State=Pressed, Level=High

- 원본 node: `67:24591`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed, Level=High | 67:24591 | SYMBOL | size=580×80; xy=40,640; r(TL,TR,BR,BL)=24,24,24,24; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/pressed=#1314174D; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/medium/item_padding,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Medium, State=Pressed, Level=High/Knob | 67:24592 | FRAME | size=516×72; xy=4,4; r(TL,TR,BR,BL)=20,0,0,20; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_left |
| Size=Medium, State=Pressed, Level=High/ic_sound | 67:24593 → 67:24418 | INSTANCE | size=48×48; xy=20,16; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Medium, State=Pressed, Level=High/ic_sound/Path | 67:24419 | BOOLEAN_OPERATION | size=36.965×29.4542; xy=6,9.2727; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, Level=High/ic_sound/Path/Vector | 67:24420 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Medium, State=Pressed, Level=High/ic_sound/Path/Vector (Stroke) | 67:24421 | VECTOR | size=8.4652×28.7837; xy=28.5,0.33; fill=#252525FF |
| Size=Medium, State=Pressed, Level=High/ic_sound/Path/Vector (Stroke) | 67:24422 | VECTOR | size=6.4253×18.7373; xy=23.5,5.3583; fill=#252525FF |
| Size=Medium, State=Pressed, Level=High/ic_sound/Icon | 67:24423 | VECTOR | size=36.9652×29.4545; xy=6,9.2727; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Small, State=Pressed, Level=High

- 원본 node: `67:24594`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Pressed, Level=High | 67:24594 | SYMBOL | size=320×72; xy=640,640; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/pressed=#1314174D; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/small/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/small/item_padding,HEIGHT→controller/slider/height_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Small, State=Pressed, Level=High/Knob | 67:24595 | FRAME | size=276×64; xy=4,4; r(TL,TR,BR,BL)=16,0,0,16; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_left |
| Size=Small, State=Pressed, Level=High/ic_sound | 67:24596 → 67:24418 | INSTANCE | size=40×40; xy=20,16; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Small, State=Pressed, Level=High/ic_sound/Path | 67:24419 | BOOLEAN_OPERATION | size=30.8043×24.5454; xy=5,7.7274; hidden; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, Level=High/ic_sound/Path/Vector | 67:24420 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Small, State=Pressed, Level=High/ic_sound/Path/Vector (Stroke) | 67:24421 | VECTOR | size=7.0543×23.9864; xy=23.75,0.2748; fill=#252525FF |
| Size=Small, State=Pressed, Level=High/ic_sound/Path/Vector (Stroke) | 67:24422 | VECTOR | size=5.3544×15.6144; xy=19.5833,4.4651; fill=#252525FF |
| Size=Small, State=Pressed, Level=High/ic_sound/Icon | 67:24423 | VECTOR | size=30.8043×24.5455; xy=5,7.7273; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Medium, State=Pressed, Level=Mid

- 원본 node: `67:24597`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed, Level=Mid | 67:24597 | SYMBOL | size=580×80; xy=40,740; r(TL,TR,BR,BL)=24,24,24,24; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/pressed=#1314174D; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/medium/item_padding,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Medium, State=Pressed, Level=Mid/Knob | 67:24598 | FRAME | size=290×72; xy=4,4; r(TL,TR,BR,BL)=20,0,0,20; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_left |
| Size=Medium, State=Pressed, Level=Mid/ic_sound | 67:24599 → 67:24424 | INSTANCE | size=48×48; xy=20,16; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Medium, State=Pressed, Level=Mid/ic_sound/Path | 67:24425 | FRAME | size=36.9652×29.4542; xy=6,9.2727; hidden |
| Size=Medium, State=Pressed, Level=Mid/ic_sound/Path/Path | 67:24426 | VECTOR | size=8.4652×28.7837; xy=28.5,0.33; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, State=Pressed, Level=Mid/ic_sound/Path/Path | 67:24427 | BOOLEAN_OPERATION | size=29.9253×29.4542; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, Level=Mid/ic_sound/Path/Path/Vector | 67:24428 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Medium, State=Pressed, Level=Mid/ic_sound/Path/Path/Vector (Stroke) | 67:24429 | VECTOR | size=6.4253×18.7373; xy=23.5,5.3583; fill=#252525FF |
| Size=Medium, State=Pressed, Level=Mid/ic_sound/Icon | 67:24430 | VECTOR | size=36.9652×29.4545; xy=6,9.2727; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Small, State=Pressed, Level=Mid

- 원본 node: `67:24600`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Pressed, Level=Mid | 67:24600 | SYMBOL | size=320×72; xy=640,740; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/pressed=#1314174D; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/small/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/small/item_padding,HEIGHT→controller/slider/height_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Small, State=Pressed, Level=Mid/Knob | 67:24601 | FRAME | size=160×64; xy=4,4; r(TL,TR,BR,BL)=16,0,0,16; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_left |
| Size=Small, State=Pressed, Level=Mid/ic_sound | 67:24602 → 67:24424 | INSTANCE | size=40×40; xy=20,16; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Small, State=Pressed, Level=Mid/ic_sound/Path | 67:24425 | FRAME | size=30.8043×24.5455; xy=5,7.7272; hidden |
| Size=Small, State=Pressed, Level=Mid/ic_sound/Path/Path | 67:24426 | VECTOR | size=7.0543×23.9864; xy=23.75,0.275; fill=icon/dark/quaternary=#13141752 |
| Size=Small, State=Pressed, Level=Mid/ic_sound/Path/Path | 67:24427 | BOOLEAN_OPERATION | size=24.9376×24.5454; xy=0,0.0002; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, Level=Mid/ic_sound/Path/Path/Vector | 67:24428 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Small, State=Pressed, Level=Mid/ic_sound/Path/Path/Vector (Stroke) | 67:24429 | VECTOR | size=5.3544×15.6144; xy=19.5833,4.4651; fill=#252525FF |
| Size=Small, State=Pressed, Level=Mid/ic_sound/Icon | 67:24430 | VECTOR | size=30.8043×24.5455; xy=5,7.7273; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Medium, State=Pressed, Level=Low

- 원본 node: `67:24603`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed, Level=Low | 67:24603 | SYMBOL | size=580×80; xy=40,840; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/pressed=#1314174D; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/medium/item_padding,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Medium, State=Pressed, Level=Low/Knob | 67:24604 | FRAME | size=90×72; xy=4,4; r(TL,TR,BR,BL)=20,0,0,20; fill=controller/slider/knop=#FFFFFFFF; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/medium/knob/radius_bottom_left |
| Size=Medium, State=Pressed, Level=Low/ic_sound | 67:24605 → 67:24431 | INSTANCE | size=48×48; xy=20,16; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Medium, State=Pressed, Level=Low/ic_sound/Path | 67:24432 | FRAME | size=36.9652×29.4542; xy=6,9.2727; hidden |
| Size=Medium, State=Pressed, Level=Low/ic_sound/Path/Path | 67:24433 | VECTOR | size=13.4652×28.7837; xy=23.5,0.33; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, State=Pressed, Level=Low/ic_sound/Path/Path | 67:24434 | BOOLEAN_OPERATION | size=19.6367×29.4542; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, Level=Low/ic_sound/Path/Path/Vector | 67:24435 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Medium, State=Pressed, Level=Low/ic_sound/Icon | 67:24436 | VECTOR | size=36.9652×29.4545; xy=6,9.2727; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Small, State=Pressed, Level=Low

- 원본 node: `67:24606`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Pressed, Level=Low | 67:24606 | SYMBOL | size=320×72; xy=640,840; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/pressed=#1314174D; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/small/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/small/item_padding,HEIGHT→controller/slider/height_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Small, State=Pressed, Level=Low/Knob | 67:24607 | FRAME | size=70×64; xy=4,4; r(TL,TR,BR,BL)=16,0,0,16; fill=controller/slider/knop=#FFFFFFFF; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_top_left,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/small/knob/radius_bottom_left |
| Size=Small, State=Pressed, Level=Low/ic_sound | 67:24608 → 67:24431 | INSTANCE | size=40×40; xy=20,16; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Small, State=Pressed, Level=Low/ic_sound/Path | 67:24432 | FRAME | size=30.8042×24.5455; xy=5,7.7272; hidden |
| Size=Small, State=Pressed, Level=Low/ic_sound/Path/Path | 67:24433 | VECTOR | size=11.221×23.9864; xy=19.5833,0.275; fill=icon/dark/quaternary=#13141752 |
| Size=Small, State=Pressed, Level=Low/ic_sound/Path/Path | 67:24434 | BOOLEAN_OPERATION | size=16.3633×24.5454; xy=0,0.0002; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, Level=Low/ic_sound/Path/Path/Vector | 67:24435 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Small, State=Pressed, Level=Low/ic_sound/Icon | 67:24436 | VECTOR | size=30.8043×24.5455; xy=5,7.7273; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Medium, State=Pressed, Level=Min

- 원본 node: `67:24609`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed, Level=Min | 67:24609 | SYMBOL | size=580×80; xy=40,940; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/pressed=#1314174D; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/medium/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/medium/item_padding,HEIGHT→controller/slider/height_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Medium, State=Pressed, Level=Min/ic_sound | 67:24610 → 67:24437 | INSTANCE | size=48×48; xy=20,18; bind=WIDTH→controller/slider/continuous/track/medium/icon,HEIGHT→controller/slider/continuous/track/medium/icon |
| Size=Medium, State=Pressed, Level=Min/ic_sound/Path | 67:24438 | FRAME | size=36.9652×31.5992; xy=6,8.7; hidden |
| Size=Medium, State=Pressed, Level=Min/ic_sound/Path/Subtract | 67:24439 | VECTOR | size=13.4652×28.7837; xy=23.5,0.9026; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, State=Pressed, Level=Min/ic_sound/Path/Union | 67:24440 | BOOLEAN_OPERATION | size=33.7997×31.5992; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, Level=Min/ic_sound/Path/Union/Subtract | 67:24441 | BOOLEAN_OPERATION | size=19.6367×29.4542; xy=0,0.5727; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, Level=Min/ic_sound/Path/Union/Subtract/Path | 67:24442 | BOOLEAN_OPERATION | size=19.6367×29.4542; xy=0,0; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, Level=Min/ic_sound/Path/Union/Subtract/Path/Vector | 67:24443 | VECTOR | size=19.6364×29.4545; xy=0,0; fill=#252525FF |
| Size=Medium, State=Pressed, Level=Min/ic_sound/Path/Union/Subtract/Vector 5958 | 67:24444 | VECTOR | size=28×28; xy=4.0001,-3.7727; r=10; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Size=Medium, State=Pressed, Level=Min/ic_sound/Path/Union/Vector 5959 | 67:24445 | VECTOR | size=28×28; xy=4.0001,1.8; r=10; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Size=Medium, State=Pressed, Level=Min/ic_sound/Icon | 67:24446 | VECTOR | size=36.9652×31.6; xy=6,8.7001; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_track/Size=Small, State=Pressed, Level=Min

- 원본 node: `67:24611`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Level","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Pressed, Level=Min | 67:24611 | SYMBOL | size=320×72; xy=640,940; r(TL,TR,BR,BL)=20,20,20,20; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=4,4,4,4; gap=0; fill=controller/slider/pressed=#1314174D; edgeStroke(T,R,B,L)=4,4,4,4; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_TOP→controller/slider/continuous/track/small/item_padding,STACK_PADDING_RIGHT→controller/slider/continuous/track/small/item_padding,STACK_PADDING_BOTTOM→controller/slider/continuous/track/small/item_padding,HEIGHT→controller/slider/height_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right,BORDER_TOP_WEIGHT→controller/slider/border_large,BORDER_BOTTOM_WEIGHT→controller/slider/border_large,BORDER_LEFT_WEIGHT→controller/slider/border_large,BORDER_RIGHT_WEIGHT→controller/slider/border_large |
| Size=Small, State=Pressed, Level=Min/ic_sound | 67:24612 → 67:24437 | INSTANCE | size=40×40; xy=20,16; bind=WIDTH→controller/slider/continuous/track/small/icon,HEIGHT→controller/slider/continuous/track/small/icon |
| Size=Small, State=Pressed, Level=Min/ic_sound/Path | 67:24438 | FRAME | size=30.8042×26.933; xy=5,6.9506; hidden |
| Size=Small, State=Pressed, Level=Min/ic_sound/Path/Subtract | 67:24439 | VECTOR | size=11.221×23.9864; xy=19.5833,1.0517; fill=icon/dark/quaternary=#13141752 |
| Size=Small, State=Pressed, Level=Min/ic_sound/Path/Union | 67:24440 | BOOLEAN_OPERATION | size=28.4666×26.933; xy=0,-0.0002; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, Level=Min/ic_sound/Path/Union/Subtract | 67:24441 | BOOLEAN_OPERATION | size=16.3633×24.5453; xy=0,0.7772; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, Level=Min/ic_sound/Path/Union/Subtract/Path | 67:24442 | BOOLEAN_OPERATION | size=16.3633×24.5454; xy=0,-0.0001; fill=icon/dark/primary=#131417FF |
| Size=Small, State=Pressed, Level=Min/ic_sound/Path/Union/Subtract/Path/Vector | 67:24443 | VECTOR | size=16.3636×24.5455; xy=0,-0.0002; fill=#252525FF |
| Size=Small, State=Pressed, Level=Min/ic_sound/Path/Union/Subtract/Vector 5958 | 67:24444 | VECTOR | size=23.3333×23.3333; xy=3.3334,-3.1442; r=10; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Size=Small, State=Pressed, Level=Min/ic_sound/Path/Union/Vector 5959 | 67:24445 | VECTOR | size=23.3333×23.3333; xy=3.3334,1.7997; r=10; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Size=Small, State=Pressed, Level=Min/ic_sound/Icon | 67:24446 | VECTOR | size=30.8043×26.3333; xy=5,7.2501; fill=icon/dark/primary=#131417FF |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Medium, State=Enabled, Direction=down

- 원본 node: `67:24614`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, Direction=down | 67:24614 | SYMBOL | size=80×80; xy=20,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/medium/button_medium,HEIGHT→controller/slider/continuous/medium/button_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right |
| Size=Medium, State=Enabled, Direction=down/ic_arrow | 67:24615 → 67:22096 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→controller/slider/continuous/medium/icon_medium,HEIGHT→controller/slider/continuous/medium/icon_medium |
| Size=Medium, State=Enabled, Direction=down/ic_arrow/Path | 67:22097 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Enabled, Direction=down/ic_arrow/Icon | 67:22098 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/secondary=#1B1C1E80 |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Medium, State=Enabled, Direction=up

- 원본 node: `67:24616`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, Direction=up | 67:24616 | SYMBOL | size=80×80; xy=120,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/medium/button_medium,HEIGHT→controller/slider/continuous/medium/button_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right |
| Size=Medium, State=Enabled, Direction=up/ic_arrow | 67:24617 → 67:22099 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→controller/slider/continuous/medium/icon_medium,HEIGHT→controller/slider/continuous/medium/icon_medium |
| Size=Medium, State=Enabled, Direction=up/ic_arrow/Path | 67:22100 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Enabled, Direction=up/ic_arrow/Icon | 67:22101 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/secondary=#1B1C1E80 |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Medium, State=Disabled, Direction=down

- 원본 node: `67:24618`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Disabled, Direction=down | 67:24618 | SYMBOL | size=80×80; xy=220,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/medium/button_medium,HEIGHT→controller/slider/continuous/medium/button_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right |
| Size=Medium, State=Disabled, Direction=down/ic_arrow | 67:24619 → 67:22096 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→controller/slider/continuous/medium/icon_medium,HEIGHT→controller/slider/continuous/medium/icon_medium |
| Size=Medium, State=Disabled, Direction=down/ic_arrow/Path | 67:22097 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Disabled, Direction=down/ic_arrow/Icon | 67:22098 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/quaternary=#1B1C1E33 |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Medium, State=Disabled, Direction=up

- 원본 node: `67:24620`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Disabled, Direction=up | 67:24620 | SYMBOL | size=80×80; xy=320,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/medium/button_medium,HEIGHT→controller/slider/continuous/medium/button_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right |
| Size=Medium, State=Disabled, Direction=up/ic_arrow | 67:24621 → 67:22099 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→controller/slider/continuous/medium/icon_medium,HEIGHT→controller/slider/continuous/medium/icon_medium |
| Size=Medium, State=Disabled, Direction=up/ic_arrow/Path | 67:22100 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Disabled, Direction=up/ic_arrow/Icon | 67:22101 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/quaternary=#1B1C1E1A |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Medium, State=Pressed, Direction=down

- 원본 node: `67:24622`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed, Direction=down | 67:24622 | SYMBOL | size=80×80; xy=420,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=dim/dark/secondary=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/medium/button_medium,HEIGHT→controller/slider/continuous/medium/button_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right |
| Size=Medium, State=Pressed, Direction=down/ic_arrow | 67:24623 → 67:22096 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→controller/slider/continuous/medium/icon_medium,HEIGHT→controller/slider/continuous/medium/icon_medium |
| Size=Medium, State=Pressed, Direction=down/ic_arrow/Path | 67:22097 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Pressed, Direction=down/ic_arrow/Icon | 67:22098 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/secondary=#1B1C1E80 |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Medium, State=Pressed, Direction=up

- 원본 node: `67:24624`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed, Direction=up | 67:24624 | SYMBOL | size=80×80; xy=520,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=dim/dark/secondary=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/medium/button_medium,HEIGHT→controller/slider/continuous/medium/button_medium,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/medium/radius_bottom_right |
| Size=Medium, State=Pressed, Direction=up/ic_arrow | 67:24625 → 67:22099 | INSTANCE | size=56×56; xy=12,12; bind=WIDTH→controller/slider/continuous/medium/icon_medium,HEIGHT→controller/slider/continuous/medium/icon_medium |
| Size=Medium, State=Pressed, Direction=up/ic_arrow/Path | 67:22100 | VECTOR | size=16.3333×32.6667; xy=19.8333,11.6667; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Medium, State=Pressed, Direction=up/ic_arrow/Icon | 67:22101 | VECTOR | size=21×37.3333; xy=17.5,9.3333; fill=icon/dark/secondary=#1B1C1E80 |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Small, State=Enabled, Direction=down

- 원본 node: `67:24626`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled, Direction=down | 67:24626 | SYMBOL | size=72×72; xy=20,120; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/small/button_small,HEIGHT→controller/slider/continuous/small/button_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right |
| Size=Small, State=Enabled, Direction=down/ic_arrow | 67:24627 → 67:22096 | INSTANCE | size=48×48; xy=12,12; bind=WIDTH→controller/slider/continuous/small/icon_small,HEIGHT→controller/slider/continuous/small/icon_small |
| Size=Small, State=Enabled, Direction=down/ic_arrow/Path | 67:22097 | VECTOR | size=14×28; xy=17,10; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Enabled, Direction=down/ic_arrow/Icon | 67:22098 | VECTOR | size=18×32; xy=15,8; fill=icon/dark/secondary=#1B1C1E80 |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Small, State=Enabled, Direction=up

- 원본 node: `67:24628`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Enabled, Direction=up | 67:24628 | SYMBOL | size=72×72; xy=112,120; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/small/button_small,HEIGHT→controller/slider/continuous/small/button_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right |
| Size=Small, State=Enabled, Direction=up/ic_arrow | 67:24629 → 67:22099 | INSTANCE | size=48×48; xy=12,12; bind=WIDTH→controller/slider/continuous/small/icon_small,HEIGHT→controller/slider/continuous/small/icon_small |
| Size=Small, State=Enabled, Direction=up/ic_arrow/Path | 67:22100 | VECTOR | size=14×28; xy=17,10; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Enabled, Direction=up/ic_arrow/Icon | 67:22101 | VECTOR | size=18×32; xy=15,8; fill=icon/dark/secondary=#1B1C1E80 |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Small, State=Disabled, Direction=down

- 원본 node: `67:24630`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Disabled, Direction=down | 67:24630 | SYMBOL | size=72×72; xy=204,120; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/small/button_small,HEIGHT→controller/slider/continuous/small/button_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right |
| Size=Small, State=Disabled, Direction=down/ic_arrow | 67:24631 → 67:22096 | INSTANCE | size=48×48; xy=12,12; bind=WIDTH→controller/slider/continuous/small/icon_small,HEIGHT→controller/slider/continuous/small/icon_small |
| Size=Small, State=Disabled, Direction=down/ic_arrow/Path | 67:22097 | VECTOR | size=14×28; xy=17,10; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Disabled, Direction=down/ic_arrow/Icon | 67:22098 | VECTOR | size=18×32; xy=15,8; fill=icon/dark/quaternary=#1B1C1E33 |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Small, State=Disabled, Direction=up

- 원본 node: `67:24632`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Disabled, Direction=up | 67:24632 | SYMBOL | size=72×72; xy=296,120; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/small/button_small,HEIGHT→controller/slider/continuous/small/button_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right |
| Size=Small, State=Disabled, Direction=up/ic_arrow | 67:24633 → 67:22099 | INSTANCE | size=48×48; xy=12,12; bind=WIDTH→controller/slider/continuous/small/icon_small,HEIGHT→controller/slider/continuous/small/icon_small |
| Size=Small, State=Disabled, Direction=up/ic_arrow/Path | 67:22100 | VECTOR | size=14×28; xy=17,10; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Disabled, Direction=up/ic_arrow/Icon | 67:22101 | VECTOR | size=18×32; xy=15,8; fill=icon/dark/quaternary=#1B1C1E1A |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Small, State=Pressed, Direction=down

- 원본 node: `67:24634`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Pressed, Direction=down | 67:24634 | SYMBOL | size=72×72; xy=388,120; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=dim/dark/secondary=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/small/button_small,HEIGHT→controller/slider/continuous/small/button_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right |
| Size=Small, State=Pressed, Direction=down/ic_arrow | 67:24635 → 67:22096 | INSTANCE | size=48×48; xy=12,12; bind=WIDTH→controller/slider/continuous/small/icon_small,HEIGHT→controller/slider/continuous/small/icon_small |
| Size=Small, State=Pressed, Direction=down/ic_arrow/Path | 67:22097 | VECTOR | size=14×28; xy=17,10; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Pressed, Direction=down/ic_arrow/Icon | 67:22098 | VECTOR | size=18×32; xy=15,8; fill=icon/dark/secondary=#1B1C1E80 |

## ❖ Components/Sliders/Frame 1/Frame 1707486412/Frame 1707487724/Col/Frame 1707486409/slider_button/Size=Small, State=Pressed, Direction=up

- 원본 node: `67:24636`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Direction","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Small, State=Pressed, Direction=up | 67:24636 | SYMBOL | size=72×72; xy=480,120; r(TL,TR,BR,BL)=20,20,20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; fill=dim/dark/secondary=#1314171A; stackPrimarySizing=FIXED; bind=WIDTH→controller/slider/continuous/small/button_small,HEIGHT→controller/slider/continuous/small/button_small,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/slider/continuous/track/small/radius_bottom_right |
| Size=Small, State=Pressed, Direction=up/ic_arrow | 67:24637 → 67:22099 | INSTANCE | size=48×48; xy=12,12; bind=WIDTH→controller/slider/continuous/small/icon_small,HEIGHT→controller/slider/continuous/small/icon_small |
| Size=Small, State=Pressed, Direction=up/ic_arrow/Path | 67:22100 | VECTOR | size=14×28; xy=17,10; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Size=Small, State=Pressed, Direction=up/ic_arrow/Icon | 67:22101 | VECTOR | size=18×32; xy=15,8; fill=icon/dark/secondary=#1B1C1E80 |

