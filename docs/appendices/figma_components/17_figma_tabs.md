# Figma assets — 컴포넌트 및 하위 레이어 해석 부록

> **원본 부록:** 웹과 다른 옛 값은 이력이다. 최신 구현은 01·02·03·08번의 웹 최종값을 적용한다. 원본 snapshot 색을 새 웹 token 위에 다시 덮지 않는다.

원본 SYMBOL의 레이어 및 INSTANCE의 master 기본값, symbolOverrides, derivedSymbolData, componentPropAssignments를 병합한 오프라인 참조이다. 모든 치수는 원본 design unit이며 root xy는 디자인 보드상 위치이므로 런타임 위치로 복사하지 않는다. child xy는 부모 상대 좌표이다. r 순서는 TL/TR/BR/BL, padding 순서는 L/T/R/B이다.

fill/stroke의 HEX는 `#RRGGBBAA`이며 원본 color alpha×paint.opacity를 합성한 스냅샷 값이다. theme 동작에는 별도 전체 토큰 표와 웹 기준 충돌 해결 규칙을 적용한다. 노드 opacity는 별도로 표시한다. `hidden`은 예제에서 꺼진 옵션이며 구현에서 삭제하라는 뜻이 아니다. master의 드롭다운/토글/Label 등 공개 property도 구현 대상이다.

이 표는 바이너리 파싱 없이 geometry/style/variant를 참조하도록 만든다. Figma 렌더러 전체를 재구현한 것은 아니므로 boolean geometry·clip·특수 효과의 pixel 일치는 SVG 및 원본 guide와 검증한다. 외부 master 누락은 마지막 해석 결과에 별도로 남긴다.


## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/solid/Size=Large, Segments=6

- 원본 node: `67:32706`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Segments","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, Segments=6 | 67:32706 | SYMBOL | size=1176×100; xy=20,20; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,8,8,8; gap=0; fill=controller/tab_background=#1314170D; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→tabs/solid/padding,STACK_PADDING_TOP→tabs/solid/padding,STACK_PADDING_RIGHT→tabs/solid/padding,STACK_PADDING_BOTTOM→tabs/solid/padding,HEIGHT→tabs/solid/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/large/radius_bottom_right |
| Size=Large, Segments=6/segmented_controls/goast_button | 67:32707 → 67:32784 | INSTANCE | size=191.6667×84; xy=8,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014 |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light | 67:32785 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/Label | 67:32786 | TEXT | size=80×40; xy=55.8333,22; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=6/divider | 67:32708 | ROUNDED_RECTANGLE | size=2×36; xy=199.6667,32; opacity=0; fill=divider/secondary=#1314171A |
| Size=Large, Segments=6/segmented_controls/goast_button | 67:32709 → 67:32775 | INSTANCE | size=191.6667×84; xy=201.6667,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=55.8333,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=6/divider | 67:32710 | ROUNDED_RECTANGLE | size=2×36; xy=395.3333,32; fill=divider/secondary=#1314171A |
| Size=Large, Segments=6/segmented_controls/goast_button | 67:32711 → 67:32775 | INSTANCE | size=191.6667×84; xy=395.3333,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=55.8333,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=6/divider | 67:32712 | ROUNDED_RECTANGLE | size=2×36; xy=589,32; fill=divider/secondary=#1314171A |
| Size=Large, Segments=6/segmented_controls/goast_button | 67:32713 → 67:32775 | INSTANCE | size=191.6667×84; xy=589,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=55.8333,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=6/divider | 67:32714 | ROUNDED_RECTANGLE | size=2×36; xy=780.6666,32; fill=divider/secondary=#1314171A |
| Size=Large, Segments=6/segmented_controls/goast_button | 67:32715 → 67:32775 | INSTANCE | size=191.6667×84; xy=782.6666,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=55.8333,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=6/divider | 67:32716 | ROUNDED_RECTANGLE | size=2×36; xy=974.3333,32; fill=divider/secondary=#1314171A |
| Size=Large, Segments=6/segmented_controls/goast_button | 67:32717 → 67:32775 | INSTANCE | size=191.6667×84; xy=976.3333,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=6/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=6/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=55.8333,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/solid/Size=Large, Segments=5

- 원본 node: `67:32718`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Segments","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, Segments=5 | 67:32718 | SYMBOL | size=1176×100; xy=20,140; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,8,8,8; gap=0; fill=controller/tab_background=#1314170D; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→tabs/solid/padding,STACK_PADDING_TOP→tabs/solid/padding,STACK_PADDING_RIGHT→tabs/solid/padding,STACK_PADDING_BOTTOM→tabs/solid/padding,HEIGHT→tabs/solid/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/large/radius_bottom_right |
| Size=Large, Segments=5/segmented_controls/goast_button | 67:32719 → 67:32784 | INSTANCE | size=230.4×84; xy=8,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014 |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light | 67:32785 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=5/segmented_controls/goast_button/Label | 67:32786 | TEXT | size=80×40; xy=75.2,22; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=5/divider | 67:32720 | ROUNDED_RECTANGLE | size=2×36; xy=238.4,32; opacity=0; fill=divider/secondary=#1314171A |
| Size=Large, Segments=5/segmented_controls/goast_button | 67:32721 → 67:32775 | INSTANCE | size=230.4×84; xy=240.4,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=5/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=75.2,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=5/divider | 67:32722 | ROUNDED_RECTANGLE | size=2×36; xy=472.8,32; fill=divider/secondary=#1314171A |
| Size=Large, Segments=5/segmented_controls/goast_button | 67:32723 → 67:32775 | INSTANCE | size=230.4×84; xy=472.8,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=5/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=75.2,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=5/divider | 67:32724 | ROUNDED_RECTANGLE | size=2×36; xy=705.2,32; fill=divider/secondary=#1314171A |
| Size=Large, Segments=5/segmented_controls/goast_button | 67:32725 → 67:32775 | INSTANCE | size=230.4×84; xy=705.2,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=5/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=75.2,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=5/divider | 67:32726 | ROUNDED_RECTANGLE | size=2×36; xy=935.6,32; fill=divider/secondary=#1314171A |
| Size=Large, Segments=5/segmented_controls/goast_button | 67:32727 → 67:32775 | INSTANCE | size=230.4×84; xy=937.6,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=5/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=5/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=75.2,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/solid/Size=Large, Segments=4

- 원본 node: `67:32728`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Segments","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, Segments=4 | 67:32728 | SYMBOL | size=1176×100; xy=20,260; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,8,8,8; gap=0; fill=controller/tab_background=#1314170D; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→tabs/solid/padding,STACK_PADDING_TOP→tabs/solid/padding,STACK_PADDING_RIGHT→tabs/solid/padding,STACK_PADDING_BOTTOM→tabs/solid/padding,HEIGHT→tabs/solid/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/large/radius_bottom_right |
| Size=Large, Segments=4/segmented_controls/goast_button | 67:32729 → 67:32784 | INSTANCE | size=288.5×84; xy=8,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014 |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light | 67:32785 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=4/segmented_controls/goast_button/Label | 67:32786 | TEXT | size=80×40; xy=104.25,22; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=4/divider | 67:32730 | ROUNDED_RECTANGLE | size=2×36; xy=296.5,32; opacity=0; fill=divider/secondary=#1314171A |
| Size=Large, Segments=4/segmented_controls/goast_button | 67:32731 → 67:32775 | INSTANCE | size=288.5×84; xy=298.5,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=4/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=104.25,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=4/divider | 67:32732 | ROUNDED_RECTANGLE | size=2×36; xy=589,32; fill=divider/secondary=#1314171A |
| Size=Large, Segments=4/segmented_controls/goast_button | 67:32733 → 67:32775 | INSTANCE | size=288.5×84; xy=589,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=4/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=104.25,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=4/divider | 67:32734 | ROUNDED_RECTANGLE | size=2×36; xy=879.5,32; fill=divider/secondary=#1314171A |
| Size=Large, Segments=4/segmented_controls/goast_button | 67:32735 → 67:32775 | INSTANCE | size=288.5×84; xy=879.5,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=4/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=4/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=104.25,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/solid/Size=Large, Segments=3

- 원본 node: `67:32736`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Segments","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, Segments=3 | 67:32736 | SYMBOL | size=880×100; xy=20,380; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,8,8,8; gap=0; fill=controller/tab_background=#1314170D; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→tabs/solid/padding,STACK_PADDING_TOP→tabs/solid/padding,STACK_PADDING_RIGHT→tabs/solid/padding,STACK_PADDING_BOTTOM→tabs/solid/padding,WIDTH→tabs/solid/large/three_segments_width,HEIGHT→tabs/solid/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/large/radius_bottom_right |
| Size=Large, Segments=3/segmented_controls/goast_button | 67:32737 → 67:32784 | INSTANCE | size=286.6667×84; xy=8,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014 |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light | 67:32785 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=3/segmented_controls/goast_button/Label | 67:32786 | TEXT | size=80×40; xy=103.3333,22; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=3/divider | 67:32738 | ROUNDED_RECTANGLE | size=2×36; xy=294.6667,32; opacity=0; fill=divider/secondary=#1314171A |
| Size=Large, Segments=3/segmented_controls/goast_button | 67:32739 → 67:32775 | INSTANCE | size=286.6667×84; xy=296.6667,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=3/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=103.3333,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=3/divider | 67:32740 | ROUNDED_RECTANGLE | size=2×36; xy=585.3333,32; fill=divider/secondary=#1314171A |
| Size=Large, Segments=3/segmented_controls/goast_button | 67:32741 → 67:32775 | INSTANCE | size=286.6667×84; xy=585.3333,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=3/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=3/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=103.3333,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/solid/Size=Large, Segments=2

- 원본 node: `67:32742`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Segments","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, Segments=2 | 67:32742 | SYMBOL | size=880×100; xy=20,500; r(TL,TR,BR,BL)=32,32,32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,8,8,8; gap=0; fill=controller/tab_background=#1314170D; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→tabs/solid/padding,STACK_PADDING_TOP→tabs/solid/padding,STACK_PADDING_RIGHT→tabs/solid/padding,STACK_PADDING_BOTTOM→tabs/solid/padding,WIDTH→tabs/solid/large/two_segments_width,HEIGHT→tabs/solid/large/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/large/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/large/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/large/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/large/radius_bottom_right |
| Size=Large, Segments=2/segmented_controls/goast_button | 67:32743 → 67:32784 | INSTANCE | size=431×84; xy=8,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014 |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light | 67:32785 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=2/segmented_controls/goast_button/Label | 67:32786 | TEXT | size=80×40; xy=175.5,22; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Large, Segments=2/divider | 67:32744 | ROUNDED_RECTANGLE | size=2×36; xy=439,32; opacity=0; fill=divider/secondary=#1314171A |
| Size=Large, Segments=2/segmented_controls/goast_button | 67:32745 → 67:32775 | INSTANCE | size=431×84; xy=441,8; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; stackCounterSizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/l,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/l |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, Segments=2/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, Segments=2/segmented_controls/goast_button/Label | 67:32777 | TEXT | size=80×40; xy=175.5,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/solid/Size=Medium, Segments=5

- 원본 node: `67:32746`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Segments","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, Segments=5 | 67:32746 | SYMBOL | size=1176×80; xy=20,620; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,8,8,8; gap=0; fill=controller/tab_background=#1314170D; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→tabs/solid/padding,STACK_PADDING_TOP→tabs/solid/padding,STACK_PADDING_RIGHT→tabs/solid/padding,STACK_PADDING_BOTTOM→tabs/solid/padding,HEIGHT→tabs/solid/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/medium/radius_bottom_right |
| Size=Medium, Segments=5/segmented_controls/goast_button | 67:32747 → 67:32799 | INSTANCE | size=230.4×64; xy=8,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014 |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light | 67:32800 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/Label | 67:32801 | TEXT | size=75×38; xy=77.7,13; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Medium, Segments=5/divider | 67:32748 | ROUNDED_RECTANGLE | size=2×36; xy=238.4,22; opacity=0; fill=divider/secondary=#1314171A |
| Size=Medium, Segments=5/segmented_controls/goast_button | 67:32749 → 67:32790 | INSTANCE | size=230.4×64; xy=240.4,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/Label | 67:32792 | TEXT | size=75×38; xy=77.7,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Medium, Segments=5/divider | 67:32750 | ROUNDED_RECTANGLE | size=2×36; xy=472.8,22; fill=divider/secondary=#1314171A |
| Size=Medium, Segments=5/segmented_controls/goast_button | 67:32751 → 67:32790 | INSTANCE | size=230.4×64; xy=472.8,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/Label | 67:32792 | TEXT | size=75×38; xy=77.7,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Medium, Segments=5/divider | 67:32752 | ROUNDED_RECTANGLE | size=2×36; xy=705.2,22; fill=divider/secondary=#1314171A |
| Size=Medium, Segments=5/segmented_controls/goast_button | 67:32753 → 67:32790 | INSTANCE | size=230.4×64; xy=705.2,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/Label | 67:32792 | TEXT | size=75×38; xy=77.7,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Medium, Segments=5/divider | 67:32754 | ROUNDED_RECTANGLE | size=2×36; xy=935.6,22; fill=divider/secondary=#1314171A |
| Size=Medium, Segments=5/segmented_controls/goast_button | 67:32755 → 67:32790 | INSTANCE | size=230.4×64; xy=937.6,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=5/segmented_controls/goast_button/Label | 67:32792 | TEXT | size=75×38; xy=77.7,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/solid/Size=Medium, Segments=4

- 원본 node: `67:32756`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Segments","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, Segments=4 | 67:32756 | SYMBOL | size=960×80; xy=20,720; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,8,8,8; gap=0; fill=controller/tab_background=#1314170D; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→tabs/solid/padding,STACK_PADDING_TOP→tabs/solid/padding,STACK_PADDING_RIGHT→tabs/solid/padding,STACK_PADDING_BOTTOM→tabs/solid/padding,WIDTH→tabs/solid/medium/four_segments_width,HEIGHT→tabs/solid/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/medium/radius_bottom_right |
| Size=Medium, Segments=4/segmented_controls/goast_button | 67:32757 → 67:32799 | INSTANCE | size=234.5×64; xy=8,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014 |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light | 67:32800 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/Label | 67:32801 | TEXT | size=75×38; xy=79.75,13; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Medium, Segments=4/divider | 67:32758 | ROUNDED_RECTANGLE | size=2×36; xy=242.5,22; opacity=0; fill=divider/secondary=#1314171A |
| Size=Medium, Segments=4/segmented_controls/goast_button | 67:32759 → 67:32790 | INSTANCE | size=234.5×64; xy=244.5,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/Label | 67:32792 | TEXT | size=75×38; xy=79.75,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Medium, Segments=4/divider | 67:32760 | ROUNDED_RECTANGLE | size=2×36; xy=481,22; fill=divider/secondary=#1314171A |
| Size=Medium, Segments=4/segmented_controls/goast_button | 67:32761 → 67:32790 | INSTANCE | size=234.5×64; xy=481,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/Label | 67:32792 | TEXT | size=75×38; xy=79.75,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Medium, Segments=4/divider | 67:32762 | ROUNDED_RECTANGLE | size=2×36; xy=717.5,22; fill=divider/secondary=#1314171A |
| Size=Medium, Segments=4/segmented_controls/goast_button | 67:32763 → 67:32790 | INSTANCE | size=234.5×64; xy=717.5,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=4/segmented_controls/goast_button/Label | 67:32792 | TEXT | size=75×38; xy=79.75,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/solid/Size=Medium, Segments=3

- 원본 node: `67:32764`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Segments","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, Segments=3 | 67:32764 | SYMBOL | size=780×80; xy=20,820; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,8,8,8; gap=0; fill=controller/tab_background=#1314170D; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→tabs/solid/padding,STACK_PADDING_TOP→tabs/solid/padding,STACK_PADDING_RIGHT→tabs/solid/padding,STACK_PADDING_BOTTOM→tabs/solid/padding,WIDTH→tabs/solid/medium/three_segments_width,HEIGHT→tabs/solid/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/medium/radius_bottom_right |
| Size=Medium, Segments=3/segmented_controls/goast_button | 67:32765 → 67:32799 | INSTANCE | size=253.3333×64; xy=8,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014 |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light | 67:32800 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=3/segmented_controls/goast_button/Label | 67:32801 | TEXT | size=75×38; xy=89.1667,13; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Medium, Segments=3/divider | 67:32766 | ROUNDED_RECTANGLE | size=2×36; xy=261.3333,22; opacity=0; fill=divider/secondary=#1314171A |
| Size=Medium, Segments=3/segmented_controls/goast_button | 67:32767 → 67:32790 | INSTANCE | size=253.3333×64; xy=263.3333,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=3/segmented_controls/goast_button/Label | 67:32792 | TEXT | size=75×38; xy=89.1667,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Medium, Segments=3/divider | 67:32768 | ROUNDED_RECTANGLE | size=2×36; xy=518.6666,22; fill=divider/secondary=#1314171A |
| Size=Medium, Segments=3/segmented_controls/goast_button | 67:32769 → 67:32790 | INSTANCE | size=253.3333×64; xy=518.6666,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=3/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=3/segmented_controls/goast_button/Label | 67:32792 | TEXT | size=75×38; xy=89.1667,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/solid/Size=Medium, Segments=2

- 원본 node: `67:32770`

- 공개 properties: `[{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Segments","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, Segments=2 | 67:32770 | SYMBOL | size=780×80; xy=20,920; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=8,8,8,8; gap=0; fill=controller/tab_background=#1314170D; stackPrimarySizing=FIXED; bind=STACK_PADDING_LEFT→tabs/solid/padding,STACK_PADDING_TOP→tabs/solid/padding,STACK_PADDING_RIGHT→tabs/solid/padding,STACK_PADDING_BOTTOM→tabs/solid/padding,WIDTH→tabs/solid/medium/two_segments_width,HEIGHT→tabs/solid/medium/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/medium/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/medium/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/medium/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/medium/radius_bottom_right |
| Size=Medium, Segments=2/segmented_controls/goast_button | 67:32771 → 67:32799 | INSTANCE | size=381×64; xy=8,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014 |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light | 67:32800 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=2/segmented_controls/goast_button/Label | 67:32801 | TEXT | size=75×38; xy=153,13; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |
| Size=Medium, Segments=2/divider | 67:32772 | ROUNDED_RECTANGLE | size=2×36; xy=389,22; opacity=0; fill=divider/secondary=#1314171A |
| Size=Medium, Segments=2/segmented_controls/goast_button | 67:32773 → 67:32790 | INSTANCE | size=381×64; xy=391,8; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, Segments=2/segmented_controls/goast_button/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, Segments=2/segmented_controls/goast_button/Label | 67:32792 | TEXT | size=75×38; xy=153,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/goast_button/Size=Large, State=Enabled, Focused=false

- 원본 node: `67:32775`

- 공개 properties: `[{"name":"Icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Focused","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Enabled, Focused=false | 67:32775 | SYMBOL | size=200×84; xy=20,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; bind=STACK_SPACING→tabs/solid/large/button/gap_horizontal,STACK_PADDING_LEFT→tabs/solid/large/button/padding_horizontal,STACK_PADDING_TOP→tabs/solid/large/button/padding_vertical,STACK_PADDING_RIGHT→tabs/solid/large/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/solid/large/button/padding_vertical,WIDTH→tabs/solid/large/button/width,HEIGHT→tabs/solid/large/button/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/large/button/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/large/button/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/large/button/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/large/button/radius_bottom_right |
| Size=Large, State=Enabled, Focused=false/ic_light | 67:32776 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, State=Enabled, Focused=false/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, State=Enabled, Focused=false/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Enabled, Focused=false/Label | 67:32777 | TEXT | size=80×40; xy=60,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/goast_button/Size=Large, State=Pressed, Focused=false

- 원본 node: `67:32778`

- 공개 properties: `[{"name":"Icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Focused","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Pressed, Focused=false | 67:32778 | SYMBOL | size=200×84; xy=240,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; fill=button/basic/pressed=#1314171A; stackPrimarySizing=FIXED; bind=STACK_SPACING→tabs/solid/large/button/gap_horizontal,STACK_PADDING_LEFT→tabs/solid/large/button/padding_horizontal,STACK_PADDING_TOP→tabs/solid/large/button/padding_vertical,STACK_PADDING_RIGHT→tabs/solid/large/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/solid/large/button/padding_vertical,WIDTH→tabs/solid/large/button/width,HEIGHT→tabs/solid/large/button/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/large/button/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/large/button/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/large/button/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/large/button/radius_bottom_right |
| Size=Large, State=Pressed, Focused=false/ic_light | 67:32779 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, State=Pressed, Focused=false/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, State=Pressed, Focused=false/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Pressed, Focused=false/Label | 67:32780 | TEXT | size=80×40; xy=60,22; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/goast_button/Size=Large, State=Disabled, Focused=false

- 원본 node: `67:32781`

- 공개 properties: `[{"name":"Icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Focused","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Disabled, Focused=false | 67:32781 | SYMBOL | size=200×84; xy=460,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; stackPrimarySizing=FIXED; bind=STACK_SPACING→tabs/solid/large/button/gap_horizontal,STACK_PADDING_LEFT→tabs/solid/large/button/padding_horizontal,STACK_PADDING_TOP→tabs/solid/large/button/padding_vertical,STACK_PADDING_RIGHT→tabs/solid/large/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/solid/large/button/padding_vertical,WIDTH→tabs/solid/large/button/width,HEIGHT→tabs/solid/large/button/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/large/button/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/large/button/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/large/button/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/large/button/radius_bottom_right |
| Size=Large, State=Disabled, Focused=false/ic_light | 67:32782 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, State=Disabled, Focused=false/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, State=Disabled, Focused=false/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/quaternary=#13141752 |
| Size=Large, State=Disabled, Focused=false/Label | 67:32783 | TEXT | size=80×40; xy=60,22; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/goast_button/Size=Large, State=Enabled, Focused=true

- 원본 node: `67:32784`

- 공개 properties: `[{"name":"Icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Focused","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Enabled, Focused=true | 67:32784 | SYMBOL | size=200×84; xy=680,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014; bind=STACK_SPACING→tabs/solid/large/button/gap_horizontal,STACK_PADDING_LEFT→tabs/solid/large/button/padding_horizontal,STACK_PADDING_TOP→tabs/solid/large/button/padding_vertical,STACK_PADDING_RIGHT→tabs/solid/large/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/solid/large/button/padding_vertical,WIDTH→tabs/solid/large/button/width,HEIGHT→tabs/solid/large/button/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/large/button/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/large/button/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/large/button/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/large/button/radius_bottom_right |
| Size=Large, State=Enabled, Focused=true/ic_light | 67:32785 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, State=Enabled, Focused=true/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, State=Enabled, Focused=true/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Enabled, Focused=true/Label | 67:32786 | TEXT | size=80×40; xy=60,22; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/goast_button/Size=Large, State=Disabled, Focused=true

- 원본 node: `67:32787`

- 공개 properties: `[{"name":"Icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Focused","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Large, State=Disabled, Focused=true | 67:32787 | SYMBOL | size=200×84; xy=900,20; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=28,16,28,16; gap=14; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014; bind=STACK_SPACING→tabs/solid/large/button/gap_horizontal,STACK_PADDING_LEFT→tabs/solid/large/button/padding_horizontal,STACK_PADDING_TOP→tabs/solid/large/button/padding_vertical,STACK_PADDING_RIGHT→tabs/solid/large/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/solid/large/button/padding_vertical,WIDTH→tabs/solid/large/button/width,HEIGHT→tabs/solid/large/button/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/large/button/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/large/button/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/large/button/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/large/button/radius_bottom_right |
| Size=Large, State=Disabled, Focused=true/ic_light | 67:32788 → 67:32636 | INSTANCE | size=52×52; xy=27,16; hidden; bind=WIDTH→tabs/solid/large/button/prefix_icon_square,HEIGHT→tabs/solid/large/button/prefix_icon_square |
| Size=Large, State=Disabled, Focused=true/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=45.252×44.9355; xy=3.3695,3.4698; hidden; fill=icon/dark/primary=#131417FF |
| Size=Large, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32638 | VECTOR | size=25.8323×25.8323; xy=9.7095,9.3939; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32639 | VECTOR | size=2.3484×0; xy=41.4127,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32640 | VECTOR | size=2.3484×0; xy=1.4901,22.3101; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32641 | VECTOR | size=2.3484×0; xy=35.9087,9.0256; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32642 | VECTOR | size=2.3484×0; xy=7.6822,37.2551; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32643 | VECTOR | size=2.3484×0; xy=35.9087,35.5945; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32644 | VECTOR | size=2.3484×0; xy=7.6822,7.365; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×2.3484; xy=22.6256,41.0971; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Large, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32646 | VECTOR | size=14.0903×10.5677; xy=15.5805,0.0004; fill=#252525FF |
| Size=Large, State=Disabled, Focused=true/ic_light/Icon | 67:32647 | VECTOR | size=45.5×45.0597; xy=3.2451,3.4701; fill=icon/dark/quaternary=#13141752 |
| Size=Large, State=Disabled, Focused=true/Label | 67:32789 | TEXT | size=80×40; xy=60,22; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/goast_button/Size=Medium, State=Enabled, Focused=false

- 원본 node: `67:32790`

- 공개 properties: `[{"name":"Icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Focused","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, Focused=false | 67:32790 | SYMBOL | size=160×64; xy=20,124; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; bind=STACK_SPACING→tabs/solid/medium/button/gap_horizontal,STACK_PADDING_LEFT→tabs/solid/medium/button/padding_horizontal,STACK_PADDING_TOP→tabs/solid/medium/button/padding_vertical,STACK_PADDING_RIGHT→tabs/solid/medium/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/solid/medium/button/padding_vertical,WIDTH→tabs/solid/medium/button/width,HEIGHT→tabs/solid/medium/button/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/medium/button/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/medium/button/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/medium/button/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/medium/button/radius_bottom_right |
| Size=Medium, State=Enabled, Focused=false/ic_light | 67:32791 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, State=Enabled, Focused=false/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=false/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, State=Enabled, Focused=false/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Focused=false/Label | 67:32792 | TEXT | size=75×38; xy=42.5,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/goast_button/Size=Medium, State=Pressed, Focused=false

- 원본 node: `67:32793`

- 공개 properties: `[{"name":"Icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Focused","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Pressed, Focused=false | 67:32793 | SYMBOL | size=160×64; xy=200,124; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; fill=button/basic/pressed=#1314171A; stackPrimarySizing=FIXED; bind=STACK_SPACING→tabs/solid/medium/button/gap_horizontal,STACK_PADDING_LEFT→tabs/solid/medium/button/padding_horizontal,STACK_PADDING_TOP→tabs/solid/medium/button/padding_vertical,STACK_PADDING_RIGHT→tabs/solid/medium/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/solid/medium/button/padding_vertical,WIDTH→tabs/solid/medium/button/width,HEIGHT→tabs/solid/medium/button/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/medium/button/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/medium/button/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/medium/button/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/medium/button/radius_bottom_right |
| Size=Medium, State=Pressed, Focused=false/ic_light | 67:32794 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, State=Pressed, Focused=false/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Pressed, Focused=false/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, State=Pressed, Focused=false/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Pressed, Focused=false/Label | 67:32795 | TEXT | size=75×38; xy=42.5,13; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/goast_button/Size=Medium, State=Disabled, Focused=false

- 원본 node: `67:32796`

- 공개 properties: `[{"name":"Icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Focused","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Disabled, Focused=false | 67:32796 | SYMBOL | size=160×64; xy=380,124; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; stackPrimarySizing=FIXED; bind=STACK_SPACING→tabs/solid/medium/button/gap_horizontal,STACK_PADDING_LEFT→tabs/solid/medium/button/padding_horizontal,STACK_PADDING_TOP→tabs/solid/medium/button/padding_vertical,STACK_PADDING_RIGHT→tabs/solid/medium/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/solid/medium/button/padding_vertical,WIDTH→tabs/solid/medium/button/width,HEIGHT→tabs/solid/medium/button/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/medium/button/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/medium/button/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/medium/button/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/medium/button/radius_bottom_right |
| Size=Medium, State=Disabled, Focused=false/ic_light | 67:32797 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, State=Disabled, Focused=false/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=false/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, State=Disabled, Focused=false/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, State=Disabled, Focused=false/Label | 67:32798 | TEXT | size=75×38; xy=42.5,13; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/goast_button/Size=Medium, State=Enabled, Focused=true

- 원본 node: `67:32799`

- 공개 properties: `[{"name":"Icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Focused","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Enabled, Focused=true | 67:32799 | SYMBOL | size=160×64; xy=560,124; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=STACK_SPACING→tabs/solid/medium/button/gap_horizontal,STACK_PADDING_LEFT→tabs/solid/medium/button/padding_horizontal,STACK_PADDING_TOP→tabs/solid/medium/button/padding_vertical,STACK_PADDING_RIGHT→tabs/solid/medium/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/solid/medium/button/padding_vertical,WIDTH→tabs/solid/medium/button/width,HEIGHT→tabs/solid/medium/button/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/medium/button/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/medium/button/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/medium/button/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/medium/button/radius_bottom_right |
| Size=Medium, State=Enabled, Focused=true/ic_light | 67:32800 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, State=Enabled, Focused=true/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Enabled, Focused=true/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, State=Enabled, Focused=true/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Enabled, Focused=true/Label | 67:32801 | TEXT | size=75×38; xy=42.5,13; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/goast_button/Size=Medium, State=Disabled, Focused=true

- 원본 node: `67:32802`

- 공개 properties: `[{"name":"Icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"Label","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Text","type":"TEXT","initialValue":{"textValue":{"characters":"Label","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Size","type":"VARIANT","initialValue":{}},{"name":"Focused","type":"VARIANT","initialValue":{}},{"name":"State","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Size=Medium, State=Disabled, Focused=true | 67:32802 | SYMBOL | size=160×64; xy=740,124; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=18,12,18,12; gap=8; fill=button/switch/enabled=#FFFFFFFF; stackPrimarySizing=FIXED; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=STACK_SPACING→tabs/solid/medium/button/gap_horizontal,STACK_PADDING_LEFT→tabs/solid/medium/button/padding_horizontal,STACK_PADDING_TOP→tabs/solid/medium/button/padding_vertical,STACK_PADDING_RIGHT→tabs/solid/medium/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/solid/medium/button/padding_vertical,WIDTH→tabs/solid/medium/button/width,HEIGHT→tabs/solid/medium/button/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/solid/medium/button/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/solid/medium/button/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/solid/medium/button/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/solid/medium/button/radius_bottom_right |
| Size=Medium, State=Disabled, Focused=true/ic_light | 67:32803 → 67:32636 | INSTANCE | size=40×40; xy=18.5,12; hidden; bind=WIDTH→tabs/solid/medium/button/prefix_square,HEIGHT→tabs/solid/medium/button/prefix_square |
| Size=Medium, State=Disabled, Focused=true/ic_light/Path | 67:32637 | BOOLEAN_OPERATION | size=35.4961×34.9102; xy=2.2484,2.669; hidden; fill=icon/dark/primary=#131417FF |
| Size=Medium, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32638 | VECTOR | size=19.871×19.871; xy=7.8123,7.2261; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32639 | VECTOR | size=1.8064×0; xy=32.1994,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32640 | VECTOR | size=1.8065×0; xy=1.4898,17.1616; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32641 | VECTOR | size=1.8065×0; xy=27.9656,6.9428; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32642 | VECTOR | size=1.8065×0; xy=6.2529,28.6578; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32643 | VECTOR | size=1.8065×0; xy=27.9656,27.3805; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32644 | VECTOR | size=1.8065×0; xy=6.2529,5.6655; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32645 | VECTOR | size=0×1.8064; xy=17.7478,31.6132; stroke=#252525FF; strokeWidth=2.9806/CENTER |
| Size=Medium, State=Disabled, Focused=true/ic_light/Path/Vector | 67:32646 | VECTOR | size=10.8387×8.129; xy=12.3285,0.0003; fill=#252525FF |
| Size=Medium, State=Disabled, Focused=true/ic_light/Icon | 67:32647 | VECTOR | size=35×34.6613; xy=2.4962,2.6693; fill=icon/dark/quaternary=#13141752 |
| Size=Medium, State=Disabled, Focused=true/Label | 67:32804 | TEXT | size=75×38; xy=42.5,13; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=1; truncate=ENDING; text='Label' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/line/Bottom line=True

- 원본 node: `67:32808`

- 공개 properties: `[{"name":"Bottom line","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Bottom line=True | 67:32808 | SYMBOL | size=1107×100; xy=20,20; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=28,0,28,0; gap=24; stroke=divider/secondary=#1314171A; strokeWidth=1/INSIDE; edgeStroke(T,R,B,L)=1,1,1,1; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→tabs/line/gap_horizontal,STACK_PADDING_LEFT→tabs/line/padding_horizontal,STACK_PADDING_RIGHT→tabs/line/padding_horizontal,BORDER_BOTTOM_WEIGHT→tabs/line/border_bottom |
| Bottom line=True/segmented_controls/line_button | 67:32809 → 67:32829 | INSTANCE | size=191×100; xy=28,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,12,0,12; gap=0; stroke=text/dark/primary=#131417FF; strokeWidth=1/INSIDE; edgeStroke(T,R,B,L)=1,1,4,1; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=BORDER_BOTTOM_WEIGHT→tabs/line/selected_border_bottom |
| Bottom line=True/segmented_controls/line_button/Button | 67:32830 | FRAME | size=191×76; xy=0,12; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| Bottom line=True/segmented_controls/line_button/Button/ic_check | 67:32831 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| Bottom line=True/segmented_controls/line_button/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Bottom line=True/segmented_controls/line_button/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/primary=#131417FF |
| Bottom line=True/segmented_controls/line_button/Button/Button text | 67:32832 | TEXT | size=163×40; xy=14,18; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |
| Bottom line=True/segmented_controls/line_button | 67:32810 → 67:32821 | INSTANCE | size=191×100; xy=243,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,12,0,12; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical |
| Bottom line=True/segmented_controls/line_button/Button | 67:32822 | FRAME | size=191×76; xy=0,12; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| Bottom line=True/segmented_controls/line_button/Button/ic_check | 67:32823 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| Bottom line=True/segmented_controls/line_button/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Bottom line=True/segmented_controls/line_button/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/secondary=#131417D6 |
| Bottom line=True/segmented_controls/line_button/Button/Button text | 67:32824 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |
| Bottom line=True/segmented_controls/line_button | 67:32811 → 67:32821 | INSTANCE | size=191×100; xy=458,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,12,0,12; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical |
| Bottom line=True/segmented_controls/line_button/Button | 67:32822 | FRAME | size=191×76; xy=0,12; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| Bottom line=True/segmented_controls/line_button/Button/ic_check | 67:32823 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| Bottom line=True/segmented_controls/line_button/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Bottom line=True/segmented_controls/line_button/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/secondary=#131417D6 |
| Bottom line=True/segmented_controls/line_button/Button/Button text | 67:32824 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |
| Bottom line=True/segmented_controls/line_button | 67:32812 → 67:32821 | INSTANCE | size=191×100; xy=673,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,12,0,12; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical |
| Bottom line=True/segmented_controls/line_button/Button | 67:32822 | FRAME | size=191×76; xy=0,12; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| Bottom line=True/segmented_controls/line_button/Button/ic_check | 67:32823 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| Bottom line=True/segmented_controls/line_button/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Bottom line=True/segmented_controls/line_button/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/secondary=#131417D6 |
| Bottom line=True/segmented_controls/line_button/Button/Button text | 67:32824 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |
| Bottom line=True/segmented_controls/line_button | 67:32813 → 67:32821 | INSTANCE | size=191×100; xy=888,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,12,0,12; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical |
| Bottom line=True/segmented_controls/line_button/Button | 67:32822 | FRAME | size=191×76; xy=0,12; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| Bottom line=True/segmented_controls/line_button/Button/ic_check | 67:32823 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| Bottom line=True/segmented_controls/line_button/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Bottom line=True/segmented_controls/line_button/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/secondary=#131417D6 |
| Bottom line=True/segmented_controls/line_button/Button/Button text | 67:32824 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/ivi_segmented_control/line/Bottom line=False

- 원본 node: `67:32814`

- 공개 properties: `[{"name":"Bottom line","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Bottom line=False | 67:32814 | SYMBOL | size=1107×128; xy=20,140; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=0,0,0,0; gap=24; edgeStroke(T,R,B,L)=1,1,1,1; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→tabs/line/gap_horizontal,BORDER_BOTTOM_WEIGHT→tabs/line/border_bottom |
| Bottom line=False/segmented_controls/line_button | 67:32815 → 67:32845 | INSTANCE | size=191×128; xy=0,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,26,0,26; gap=0; stroke=text/dark/primary=#131417FF; strokeWidth=1/INSIDE; edgeStroke(T,R,B,L)=1,1,4,1; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=BORDER_BOTTOM_WEIGHT→tabs/line/selected_border_bottom |
| Bottom line=False/segmented_controls/line_button/Button | 67:32846 | FRAME | size=191×76; xy=0,26; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| Bottom line=False/segmented_controls/line_button/Button/ic_check | 67:32847 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| Bottom line=False/segmented_controls/line_button/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Bottom line=False/segmented_controls/line_button/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/primary=#131417FF |
| Bottom line=False/segmented_controls/line_button/Button/Button text | 67:32848 | TEXT | size=163×40; xy=14,18; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |
| Bottom line=False/segmented_controls/line_button | 67:32816 → 67:32837 | INSTANCE | size=191×128; xy=215,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,26,0,26; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical_large,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical_large |
| Bottom line=False/segmented_controls/line_button/Button | 67:32838 | FRAME | size=191×76; xy=0,26; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| Bottom line=False/segmented_controls/line_button/Button/ic_check | 67:32839 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| Bottom line=False/segmented_controls/line_button/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Bottom line=False/segmented_controls/line_button/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/secondary=#131417D6 |
| Bottom line=False/segmented_controls/line_button/Button/Button text | 67:32840 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |
| Bottom line=False/segmented_controls/line_button | 67:32817 → 67:32837 | INSTANCE | size=191×128; xy=430,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,26,0,26; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical_large,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical_large |
| Bottom line=False/segmented_controls/line_button/Button | 67:32838 | FRAME | size=191×76; xy=0,26; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| Bottom line=False/segmented_controls/line_button/Button/ic_check | 67:32839 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| Bottom line=False/segmented_controls/line_button/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Bottom line=False/segmented_controls/line_button/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/secondary=#131417D6 |
| Bottom line=False/segmented_controls/line_button/Button/Button text | 67:32840 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |
| Bottom line=False/segmented_controls/line_button | 67:32818 → 67:32837 | INSTANCE | size=191×128; xy=645,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,26,0,26; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical_large,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical_large |
| Bottom line=False/segmented_controls/line_button/Button | 67:32838 | FRAME | size=191×76; xy=0,26; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| Bottom line=False/segmented_controls/line_button/Button/ic_check | 67:32839 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| Bottom line=False/segmented_controls/line_button/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Bottom line=False/segmented_controls/line_button/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/secondary=#131417D6 |
| Bottom line=False/segmented_controls/line_button/Button/Button text | 67:32840 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |
| Bottom line=False/segmented_controls/line_button | 67:32819 → 67:32837 | INSTANCE | size=191×128; xy=860,0; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,26,0,26; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical_large,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical_large |
| Bottom line=False/segmented_controls/line_button/Button | 67:32838 | FRAME | size=191×76; xy=0,26; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| Bottom line=False/segmented_controls/line_button/Button/ic_check | 67:32839 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| Bottom line=False/segmented_controls/line_button/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| Bottom line=False/segmented_controls/line_button/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/secondary=#131417D6 |
| Bottom line=False/segmented_controls/line_button/Button/Button text | 67:32840 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/line_button/State=Enabled, Margin=Medium

- 원본 node: `67:32821`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Margin","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Enabled, Margin=Medium | 67:32821 | SYMBOL | size=191×100; xy=20,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,12,0,12; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical |
| State=Enabled, Margin=Medium/Button | 67:32822 | FRAME | size=191×76; xy=0,12; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| State=Enabled, Margin=Medium/Button/ic_check | 67:32823 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| State=Enabled, Margin=Medium/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| State=Enabled, Margin=Medium/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/secondary=#131417D6 |
| State=Enabled, Margin=Medium/Button/Button text | 67:32824 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/line_button/State=Pressed, Margin=Medium

- 원본 node: `67:32825`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Margin","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Pressed, Margin=Medium | 67:32825 | SYMBOL | size=191×100; xy=231,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,12,0,12; gap=0; edgeStroke(T,R,B,L)=1,1,4,1; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/xs,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/xs,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/xs,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/xs |
| State=Pressed, Margin=Medium/Button | 67:32826 | FRAME | size=191×76; xy=0,12; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; fill=dim/dark/primary=#1314170D; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| State=Pressed, Margin=Medium/Button/ic_check | 67:32827 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| State=Pressed, Margin=Medium/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| State=Pressed, Margin=Medium/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/primary=#131417FF |
| State=Pressed, Margin=Medium/Button/Button text | 67:32828 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/line_button/State=Selected, Margin=Medium

- 원본 node: `67:32829`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Margin","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Selected, Margin=Medium | 67:32829 | SYMBOL | size=191×100; xy=442,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,12,0,12; gap=0; stroke=text/dark/primary=#131417FF; strokeWidth=1/INSIDE; edgeStroke(T,R,B,L)=1,1,4,1; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical,BORDER_BOTTOM_WEIGHT→tabs/line/selected_border_bottom |
| State=Selected, Margin=Medium/Button | 67:32830 | FRAME | size=191×76; xy=0,12; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| State=Selected, Margin=Medium/Button/ic_check | 67:32831 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| State=Selected, Margin=Medium/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| State=Selected, Margin=Medium/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/primary=#131417FF |
| State=Selected, Margin=Medium/Button/Button text | 67:32832 | TEXT | size=163×40; xy=14,18; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/line_button/State=Disabled, Margin=Medium

- 원본 node: `67:32833`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Margin","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Disabled, Margin=Medium | 67:32833 | SYMBOL | size=191×100; xy=653,20; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,12,0,12; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical |
| State=Disabled, Margin=Medium/Button | 67:32834 | FRAME | size=191×76; xy=0,12; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| State=Disabled, Margin=Medium/Button/ic_check | 67:32835 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| State=Disabled, Margin=Medium/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| State=Disabled, Margin=Medium/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/quaternary=#13141752 |
| State=Disabled, Margin=Medium/Button/Button text | 67:32836 | TEXT | size=163×40; xy=14,18; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/line_button/State=Enabled, Margin=Large(Page Nav Only))

- 원본 node: `67:32837`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Margin","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Enabled, Margin=Large(Page Nav Only)) | 67:32837 | SYMBOL | size=191×128; xy=20,140; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,26,0,26; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical_large,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical_large |
| State=Enabled, Margin=Large(Page Nav Only))/Button | 67:32838 | FRAME | size=191×76; xy=0,26; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| State=Enabled, Margin=Large(Page Nav Only))/Button/ic_check | 67:32839 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| State=Enabled, Margin=Large(Page Nav Only))/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| State=Enabled, Margin=Large(Page Nav Only))/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/secondary=#131417D6 |
| State=Enabled, Margin=Large(Page Nav Only))/Button/Button text | 67:32840 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/line_button/State=Pressed, Margin=Large(Page Nav Only))

- 원본 node: `67:32841`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Margin","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Pressed, Margin=Large(Page Nav Only)) | 67:32841 | SYMBOL | size=191×128; xy=231,140; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,26,0,26; gap=0; edgeStroke(T,R,B,L)=1,1,4,1; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical_large,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical_large,RECTANGLE_TOP_LEFT_CORNER_RADIUS→Radius/xs,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→Radius/xs,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→Radius/xs,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→Radius/xs |
| State=Pressed, Margin=Large(Page Nav Only))/Button | 67:32842 | FRAME | size=191×76; xy=0,26; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; fill=dim/dark/primary=#1314170D; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| State=Pressed, Margin=Large(Page Nav Only))/Button/ic_check | 67:32843 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| State=Pressed, Margin=Large(Page Nav Only))/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| State=Pressed, Margin=Large(Page Nav Only))/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/primary=#131417FF |
| State=Pressed, Margin=Large(Page Nav Only))/Button/Button text | 67:32844 | TEXT | size=163×40; xy=14,18; fill=text/dark/secondary=#131417D6; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/line_button/State=Selected, Margin=Large(Page Nav Only))

- 원본 node: `67:32845`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Margin","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Selected, Margin=Large(Page Nav Only)) | 67:32845 | SYMBOL | size=191×128; xy=442,140; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,26,0,26; gap=0; stroke=text/dark/primary=#131417FF; strokeWidth=1/INSIDE; edgeStroke(T,R,B,L)=1,1,4,1; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical_large,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical_large,BORDER_BOTTOM_WEIGHT→tabs/line/selected_border_bottom |
| State=Selected, Margin=Large(Page Nav Only))/Button | 67:32846 | FRAME | size=191×76; xy=0,26; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| State=Selected, Margin=Large(Page Nav Only))/Button/ic_check | 67:32847 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| State=Selected, Margin=Large(Page Nav Only))/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| State=Selected, Margin=Large(Page Nav Only))/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/primary=#131417FF |
| State=Selected, Margin=Large(Page Nav Only))/Button/Button text | 67:32848 | TEXT | size=163×40; xy=14,18; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |

## ❖ Components/Tabs/Frame 1/Frame 1/Col/segmented_controls/line_button/State=Disabled, Margin=Large(Page Nav Only))

- 원본 node: `67:32849`

- 공개 properties: `[{"name":"Prefix icon","type":"BOOL","initialValue":{"boolValue":false}},{"name":"State","type":"VARIANT","initialValue":{}},{"name":"Margin","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| State=Disabled, Margin=Large(Page Nav Only)) | 67:32849 | SYMBOL | size=191×128; xy=653,140; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,26,0,26; gap=0; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_PADDING_TOP→tabs/line/button/wrap_padding_vertical_large,STACK_PADDING_BOTTOM→tabs/line/button/wrap_padding_vertical_large |
| State=Disabled, Margin=Large(Page Nav Only))/Button | 67:32850 | FRAME | size=191×76; xy=0,26; r(TL,TR,BR,BL)=12,12,12,12; layout=HORIZONTAL/MIN/CENTER; padding(L,T,R,B)=14,18,14,18; gap=8; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; bind=STACK_SPACING→tabs/line/button/gap_horizontal,STACK_PADDING_LEFT→tabs/line/button/padding_horizontal,STACK_PADDING_TOP→tabs/line/button/padding_vertical,STACK_PADDING_RIGHT→tabs/line/button/padding_horizontal,STACK_PADDING_BOTTOM→tabs/line/button/padding_vertical,RECTANGLE_TOP_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→tabs/line/button/pressed_radius_bottom_right |
| State=Disabled, Margin=Large(Page Nav Only))/Button/ic_check | 67:32851 → 67:25618 | INSTANCE | size=40×40; xy=12,19; hidden; bind=WIDTH→tabs/line/button/prefix_square,HEIGHT→tabs/line/button/prefix_square |
| State=Disabled, Margin=Large(Page Nav Only))/Button/ic_check/Path | 67:25619 | VECTOR | size=24.5833×15.8333; xy=8.3333,12.5; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| State=Disabled, Margin=Large(Page Nav Only))/Button/ic_check/Icon | 67:25620 | VECTOR | size=27.5833×18.8333; xy=6.8333,11; fill=icon/dark/quaternary=#13141752 |
| State=Disabled, Margin=Large(Page Nav Only))/Button/Button text | 67:32852 | TEXT | size=163×40; xy=14,18; fill=text/dark/quaternary=#13141752; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/32; line=40/PIXELS; letter=0/PERCENT; textStyle=Title/Small/Strong; maxLines=1; truncate=ENDING; text='Button text' |

