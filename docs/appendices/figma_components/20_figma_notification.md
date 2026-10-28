# Figma assets — 컴포넌트 및 하위 레이어 해석 부록

> **원본 부록:** 웹과 다른 옛 값은 이력이다. 최신 구현은 01·02·03·08번의 웹 최종값을 적용한다. 원본 snapshot 색을 새 웹 token 위에 다시 덮지 않는다.

원본 SYMBOL의 레이어 및 INSTANCE의 master 기본값, symbolOverrides, derivedSymbolData, componentPropAssignments를 병합한 오프라인 참조이다. 모든 치수는 원본 design unit이며 root xy는 디자인 보드상 위치이므로 런타임 위치로 복사하지 않는다. child xy는 부모 상대 좌표이다. r 순서는 TL/TR/BR/BL, padding 순서는 L/T/R/B이다.

fill/stroke의 HEX는 `#RRGGBBAA`이며 원본 color alpha×paint.opacity를 합성한 스냅샷 값이다. theme 동작에는 별도 전체 토큰 표와 웹 기준 충돌 해결 규칙을 적용한다. 노드 opacity는 별도로 표시한다. `hidden`은 예제에서 꺼진 옵션이며 구현에서 삭제하라는 뜻이 아니다. master의 드롭다운/토글/Label 등 공개 property도 구현 대상이다.

이 표는 바이너리 파싱 없이 geometry/style/variant를 참조하도록 만든다. Figma 렌더러 전체를 재구현한 것은 아니므로 boolean geometry·clip·특수 효과의 pixel 일치는 SVG 및 원본 guide와 검증한다. 외부 master 누락은 마지막 해석 결과에 별도로 남긴다.


## ❖ Components/System Notification/Frame 1/Col/ivi_notification_system/Type=Image+Text

- 원본 node: `67:34044`

- 공개 properties: `[{"name":"Title","type":"TEXT","initialValue":{"textValue":{"characters":"Title","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Description","type":"TEXT","initialValue":{"textValue":{"characters":"Description","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"has Image","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Image+Text | 67:34044 | SYMBOL | size=700×276; xy=374.5,200; r(TL,TR,BR,BL)=48,48,48,48; layout=VERTICAL/MIN/MIN; padding(L,T,R,B)=0,0,0,0; gap=0; fill=gleo/Olf/surface_primary=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=1/INSIDE; edgeStroke(T,R,B,L)=1,1,1,1; effect=DROP_SHADOW,offset={'x': 0, 'y': 20},blur=40,spread=0,color=#0000003D; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=4,spread=0,color=#00000033; bind=WIDTH→notification/system/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/radius_bottom_right,BORDER_TOP_WEIGHT→notification/border,BORDER_BOTTOM_WEIGHT→notification/border,BORDER_LEFT_WEIGHT→notification/border,BORDER_RIGHT_WEIGHT→notification/border |
| Type=Image+Text/Header | 67:34045 | FRAME | size=700×148; xy=0,0; layout=HORIZONTAL/MIN/MIN; padding(L,T,R,B)=32,32,32,16; gap=24; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→notification/gap_large,STACK_PADDING_LEFT→notification/padding_large,STACK_PADDING_TOP→notification/padding_large,STACK_PADDING_RIGHT→notification/padding_large,STACK_PADDING_BOTTOM→notification/padding_small,WIDTH→os_notification/container/width |
| Type=Image+Text/Header/system_notification/images | 67:34046 → 67:34085 | INSTANCE | size=100×100; xy=32,32; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→notification/system/imagary_square,HEIGHT→notification/system/imagary_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/images/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/images/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/images/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/images/radius_bottom_right |
| Type=Image+Text/Header/system_notification/images/imagery_image | 67:34086 → 67:33986 | INSTANCE | size=100×100; xy=100,0; r(TL,TR,BR,BL)=16,16,16,16; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Type=Image+Text/Header/system_notification/images/imagery_image/ic_image | 67:33987 → 67:33977 | INSTANCE | size=48×48; xy=20,20 |
| Type=Image+Text/Header/system_notification/images/imagery_image/ic_image/Path | 67:33978 | BOOLEAN_OPERATION | size=50.293×42.1875; xy=5.0197,6.5625; hidden; fill=icon/dark/primary=#131417FF |
| Type=Image+Text/Header/system_notification/images/imagery_image/ic_image/Path/Vector | 67:33979 | VECTOR | size=13.125×13.125; xy=37.1678,0; fill=Common/Empty/Content=#EEEEEEFF |
| Type=Image+Text/Header/system_notification/images/imagery_image/ic_image/Path/Vector | 67:33980 | VECTOR | size=26.25×24.375; xy=24.9803,17.8125; r=2; fill=Common/Empty/Content=#EEEEEEFF |
| Type=Image+Text/Header/system_notification/images/imagery_image/ic_image/Path/Vector | 67:33981 | VECTOR | size=38.4375×37.5; xy=-1.2697,4.6875; r=2; fill=Common/Empty/Content=#EEEEEEFF |
| Type=Image+Text/Header/system_notification/images/imagery_image/ic_image/Icon | 67:33982 | VECTOR | size=49.9754×42.1875; xy=5.3371,6.5625; fill=icon/dark/quaternary=#13141752 |
| Type=Image+Text/Header/text_group | 67:34047 | FRAME | size=512×94; xy=156,32; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=0,4,0,0; gap=12; stackChildPrimaryGrow=1; bind=STACK_SPACING→notification/system/text_gap_vertical,STACK_PADDING_TOP→notification/system/text_padding_top |
| Type=Image+Text/Header/text_group/Title | 67:34048 | TEXT | size=512×44; xy=0,4; fill=text/dark/primary=#131417FF; stackChildAlignSelf=STRETCH; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/ExtraBold/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Extra_Strong; maxLines=2; truncate=ENDING; text='Title' |
| Type=Image+Text/Header/text_group/Description | 67:34049 | TEXT | size=512×34; xy=0,60; fill=text/dark/tertiary=#131417A3; stackChildAlignSelf=STRETCH; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; maxLines=3; truncate=ENDING; text='Description' |
| Type=Image+Text/system_notification/button | 67:34050 → 67:34073 | INSTANCE | size=700×128; xy=0,148; layout=HORIZONTAL/CENTER/MIN; padding(L,T,R,B)=24,24,24,24; gap=16; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→notification/gap_medium |
| Type=Image+Text/system_notification/button/ivi_basic_button | 67:34074 → 67:28849 | INSTANCE | size=670.25×80; xy=24,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=button/filled/enabled=#44464EFF; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam | 67:28850 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6817; hidden; fill=icon/dark/primary=#131417FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/light/primary=#FFFFFFFF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,11.8174; fill=#000000FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,0; fill=#000000FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,0; fill=#000000FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9546; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9546; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3175; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2725; fill=#FFFFFFFF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2274; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2274; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/light/primary=#FFFFFFFF |
| Type=Image+Text/system_notification/button/ivi_basic_button/Label | 67:28851 | TEXT | size=56×38; xy=131,21; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='CTA' |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_arrow | 67:28852 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/light/primary=#FFFFFFFF |
| Type=Image+Text/system_notification/button/ivi_basic_button | 67:34075 → 67:28813 | INSTANCE | size=670.25×80; xy=358,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam | 67:28814 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6816; hidden; fill=icon/dark/primary=#131417FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8175; fill=#000000FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3177; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2726; fill=#FFFFFFFF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Image+Text/system_notification/button/ivi_basic_button/Label | 67:28815 | TEXT | size=149×38; xy=84.5,21; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Sub action' |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_arrow | 67:28816 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Image+Text/system_notification/button/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/System Notification/Frame 1/Col/ivi_notification_system/Type=Only Text

- 원본 node: `67:34051`

- 공개 properties: `[{"name":"Title","type":"TEXT","initialValue":{"textValue":{"characters":"Title","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Description","type":"TEXT","initialValue":{"textValue":{"characters":"Description","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"has Image","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Only Text | 67:34051 | SYMBOL | size=700×270; xy=1114.5,203; r(TL,TR,BR,BL)=48,48,48,48; layout=VERTICAL/MIN/MIN; padding(L,T,R,B)=0,0,0,0; gap=0; fill=gleo/Olf/surface_primary=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=1/INSIDE; edgeStroke(T,R,B,L)=1,1,1,1; effect=DROP_SHADOW,offset={'x': 0, 'y': 20},blur=40,spread=0,color=#0000003D; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=4,spread=0,color=#00000033; bind=WIDTH→notification/system/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/radius_bottom_right,BORDER_TOP_WEIGHT→notification/border,BORDER_BOTTOM_WEIGHT→notification/border,BORDER_LEFT_WEIGHT→notification/border,BORDER_RIGHT_WEIGHT→notification/border |
| Type=Only Text/Header | 67:34052 | FRAME | size=700×142; xy=0,0; layout=HORIZONTAL/MIN/MIN; padding(L,T,R,B)=32,32,32,16; gap=24; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→notification/gap_large,STACK_PADDING_LEFT→notification/padding_large,STACK_PADDING_TOP→notification/padding_large,STACK_PADDING_RIGHT→notification/padding_large,STACK_PADDING_BOTTOM→notification/padding_small,WIDTH→os_notification/container/width |
| Type=Only Text/Header/system_notification/images | 67:34053 → 67:34085 | INSTANCE | size=100×100; xy=32,32; hidden; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→notification/system/imagary_square,HEIGHT→notification/system/imagary_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/images/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/images/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/images/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/images/radius_bottom_right |
| Type=Only Text/Header/system_notification/images/imagery_image | 67:34086 → 67:33986 | INSTANCE | size=100×100; xy=100,0; r(TL,TR,BR,BL)=16,16,16,16; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Type=Only Text/Header/system_notification/images/imagery_image/ic_image | 67:33987 → 67:33977 | INSTANCE | size=48×48; xy=20,20 |
| Type=Only Text/Header/system_notification/images/imagery_image/ic_image/Path | 67:33978 | BOOLEAN_OPERATION | size=50.293×42.1875; xy=5.0197,6.5625; hidden; fill=icon/dark/primary=#131417FF |
| Type=Only Text/Header/system_notification/images/imagery_image/ic_image/Path/Vector | 67:33979 | VECTOR | size=13.125×13.125; xy=37.1678,0; fill=Common/Empty/Content=#EEEEEEFF |
| Type=Only Text/Header/system_notification/images/imagery_image/ic_image/Path/Vector | 67:33980 | VECTOR | size=26.25×24.375; xy=24.9803,17.8125; r=2; fill=Common/Empty/Content=#EEEEEEFF |
| Type=Only Text/Header/system_notification/images/imagery_image/ic_image/Path/Vector | 67:33981 | VECTOR | size=38.4375×37.5; xy=-1.2697,4.6875; r=2; fill=Common/Empty/Content=#EEEEEEFF |
| Type=Only Text/Header/system_notification/images/imagery_image/ic_image/Icon | 67:33982 | VECTOR | size=49.9754×42.1875; xy=5.3371,6.5625; fill=icon/dark/quaternary=#13141752 |
| Type=Only Text/Header/text_group | 67:34054 | FRAME | size=636×94; xy=32,32; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=8,4,8,0; gap=12; stackChildPrimaryGrow=1; bind=STACK_SPACING→notification/system/text_gap_vertical,STACK_PADDING_LEFT→notification/system/text_padding_horizontal,STACK_PADDING_TOP→notification/system/text_padding_top,STACK_PADDING_RIGHT→notification/system/text_padding_horizontal |
| Type=Only Text/Header/text_group/Title | 67:34055 | TEXT | size=620×44; xy=8,4; fill=text/dark/primary=#131417FF; stackChildAlignSelf=STRETCH; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/ExtraBold/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Extra_Strong; maxLines=2; truncate=ENDING; text='Title' |
| Type=Only Text/Header/text_group/Description | 67:34056 | TEXT | size=620×34; xy=8,60; fill=text/dark/tertiary=#131417A3; stackChildAlignSelf=STRETCH; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; maxLines=3; truncate=ENDING; text='Description' |
| Type=Only Text/system_notification/button | 67:34057 → 67:34073 | INSTANCE | size=700×128; xy=0,142; layout=HORIZONTAL/CENTER/MIN; padding(L,T,R,B)=24,24,24,24; gap=16; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→notification/gap_medium |
| Type=Only Text/system_notification/button/ivi_basic_button | 67:34074 → 67:28849 | INSTANCE | size=670.25×80; xy=24,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=button/filled/enabled=#44464EFF; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam | 67:28850 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6817; hidden; fill=icon/dark/primary=#131417FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/light/primary=#FFFFFFFF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,11.8174; fill=#000000FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,0; fill=#000000FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,0; fill=#000000FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9546; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9546; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3175; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2725; fill=#FFFFFFFF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2274; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2274; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/light/primary=#FFFFFFFF |
| Type=Only Text/system_notification/button/ivi_basic_button/Label | 67:28851 | TEXT | size=56×38; xy=131,21; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='CTA' |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_arrow | 67:28852 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/light/primary=#FFFFFFFF |
| Type=Only Text/system_notification/button/ivi_basic_button | 67:34075 → 67:28813 | INSTANCE | size=670.25×80; xy=358,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam | 67:28814 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6816; hidden; fill=icon/dark/primary=#131417FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8175; fill=#000000FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3177; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2726; fill=#FFFFFFFF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Only Text/system_notification/button/ivi_basic_button/Label | 67:28815 | TEXT | size=149×38; xy=84.5,21; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Sub action' |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_arrow | 67:28816 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Only Text/system_notification/button/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/System Notification/Frame 1/Col/ivi_notification_system/Type=Call

- 원본 node: `67:34058`

- 공개 properties: `[{"name":"Title","type":"TEXT","initialValue":{"textValue":{"characters":"Title","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"Description","type":"TEXT","initialValue":{"textValue":{"characters":"Description","lines":[{"lineType":"PLAIN","styleId":0,"indentationLevel":0,"sourceDirectionality":"AUTO","listStartOffset":0,"isFirstLineOfList":false}]}}},{"name":"has Image","type":"BOOL","initialValue":{"boolValue":true}},{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Call | 67:34058 | SYMBOL | size=700×276; xy=1854.5,200; r(TL,TR,BR,BL)=48,48,48,48; layout=VERTICAL/MIN/MIN; padding(L,T,R,B)=0,0,0,0; gap=0; fill=gleo/Olf/surface_primary=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=1/INSIDE; edgeStroke(T,R,B,L)=1,1,1,1; effect=DROP_SHADOW,offset={'x': 0, 'y': 20},blur=40,spread=0,color=#0000003D; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=4,spread=0,color=#00000033; bind=WIDTH→notification/system/width,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/radius_bottom_right,BORDER_TOP_WEIGHT→notification/border,BORDER_BOTTOM_WEIGHT→notification/border,BORDER_LEFT_WEIGHT→notification/border,BORDER_RIGHT_WEIGHT→notification/border |
| Type=Call/Header | 67:34059 | FRAME | size=700×148; xy=0,0; layout=HORIZONTAL/MIN/MIN; padding(L,T,R,B)=32,32,32,16; gap=24; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→notification/gap_large,STACK_PADDING_LEFT→notification/padding_large,STACK_PADDING_TOP→notification/padding_large,STACK_PADDING_RIGHT→notification/padding_large,STACK_PADDING_BOTTOM→notification/padding_small |
| Type=Call/Header/system_notification/images | 67:34060 → 67:34082 | INSTANCE | size=100×100; xy=32,32; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→notification/system/imagary_square,HEIGHT→notification/system/imagary_square |
| Type=Call/Header/system_notification/images/imagery_profile | 67:34083 → 67:28901 | INSTANCE | size=100×100; xy=0,0; r=0; r(TL,TR,BR,BL)=999,999,999,999; fill=IMAGE; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=WIDTH→os_notification/contents/image_square,HEIGHT→os_notification/contents/image_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/profile/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/profile/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/profile/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/profile/radius_bottom_right |
| Type=Call/Header/system_notification/images/ic_app | 67:34084 → 67:25561 | INSTANCE | size=48×48; xy=60,60; r(TL,TR,BR,BL)=16,16,16,16; stroke=divider/secondary=#1314171A; strokeWidth=1/INSIDE; edgeStroke(T,R,B,L)=1,1,1,1; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014; bind=WIDTH→notification/system/profile/app_square,HEIGHT→notification/system/profile/app_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/profile/app_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/profile/app_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/profile/app_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/profile/app_radius_bottom_right |
| Type=Call/Header/system_notification/images/ic_app/App Market | 67:25562 → 67:25538 | INSTANCE | size=60×60; xy=0,0; r=0; r(TL,TR,BR,BL)=0,0,0,0; fill=IMAGE |
| Type=Call/Header/system_notification/images/ic_app/Preload | 67:25563 → 67:25363 | INSTANCE | size=48×48; xy=0,0; r=0; r(TL,TR,BR,BL)=0,0,0,0; fill=GRADIENT_LINEAR |
| Type=Call/Header/system_notification/images/ic_app/Preload/Group 1707486104 | 67:25364 | FRAME | size=30.75×30.0002; xy=9,8.25 |
| Type=Call/Header/system_notification/images/ic_app/Preload/Group 1707486104/Vector 5679 | 67:25365 | VECTOR | size=18.75×9; xy=0,21; opacity=0.95; r=2.2222; fill=GRADIENT_LINEAR; effect=DROP_SHADOW,offset={'x': 0, 'y': 1.8095300197601318},blur=1.8095,spread=0,color=#0000001A; effect=INNER_SHADOW,offset={'x': 0, 'y': 1.0555591583251953},blur=0,spread=0,color=#FFFFFF1A |
| Type=Call/Header/system_notification/images/ic_app/Preload/Group 1707486104/Ellipse 7729 | 67:25366 | ELLIPSE | size=30×30.0002; xy=0.75,0; fill=GRADIENT_LINEAR; effect=DROP_SHADOW,offset={'x': 0, 'y': 1.302049160003662},blur=1.302,spread=0,color=#0000001A; effect=INNER_SHADOW,offset={'x': 0, 'y': 0.759528636932373},blur=0,spread=0,color=#FFFFFF1A |
| Type=Call/Header/system_notification/images/ic_app/Preload/Group 1707486104/Vector | 67:25367 | VECTOR | size=18×18; xy=6.75,6; fill=#30CF72FF |
| Type=Call/Header/text_group | 67:34061 | FRAME | size=512×94; xy=156,32; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=0,4,0,0; gap=12; stackChildPrimaryGrow=1; bind=STACK_SPACING→notification/system/text_gap_vertical,STACK_PADDING_TOP→notification/system/text_padding_top |
| Type=Call/Header/text_group/010-1234-5678 | 67:34062 | TEXT | size=512×44; xy=0,4; fill=text/dark/primary=#131417FF; stackChildAlignSelf=STRETCH; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/ExtraBold/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Extra_Strong; maxLines=2; truncate=ENDING; text='010-1234-5678' |
| Type=Call/Header/text_group/전화 수신 중 | 67:34063 | TEXT | size=512×34; xy=0,60; fill=text/dark/tertiary=#131417A3; stackChildAlignSelf=STRETCH; textAutoResize=HEIGHT; textAlignVertical=TOP; font=Asta Sans/Regular/26; line=34/PIXELS; letter=0/PERCENT; textStyle=Body/Small/Normal; maxLines=3; truncate=ENDING; text='전화 수신 중' |
| Type=Call/system_notification/button | 67:34064 → 67:34076 | INSTANCE | size=700×128; xy=0,148; layout=HORIZONTAL/CENTER/MIN; padding(L,T,R,B)=24,24,24,24; gap=16; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→notification/gap_medium |
| Type=Call/system_notification/button/ivi_basic_button | 67:34077 → 67:28813 | INSTANCE | size=670.25×80; xy=24,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=phone/accept_normal=#1314170D; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam | 67:28814 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6816; hidden; fill=icon/dark/primary=#131417FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8175; fill=#000000FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3177; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2726; fill=#FFFFFFFF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Call/system_notification/button/ivi_basic_button/Label | 67:28815 | TEXT | size=52×38; xy=133,21; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='받기' |
| Type=Call/system_notification/button/ivi_basic_button/ic_arrow | 67:28816 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Call/system_notification/button/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |
| Type=Call/system_notification/button/ivi_basic_button | 67:34078 → 67:28813 | INSTANCE | size=670.25×80; xy=358,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=phone/end_normal=#1314170D; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam | 67:28814 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6816; hidden; fill=icon/dark/primary=#131417FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8175; fill=#000000FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3177; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2726; fill=#FFFFFFFF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Call/system_notification/button/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Call/system_notification/button/ivi_basic_button/Label | 67:28815 | TEXT | size=52×38; xy=133,21; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='거절' |
| Type=Call/system_notification/button/ivi_basic_button/ic_arrow | 67:28816 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Call/system_notification/button/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Call/system_notification/button/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/System Notification/Frame 1/Col/Frame 1707486522/system_notification/button/Type=Single

- 원본 node: `67:34068`

- 공개 properties: `[{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Single | 67:34068 | SYMBOL | size=1404.5×128; xy=20,20; layout=HORIZONTAL/CENTER/MIN; padding(L,T,R,B)=24,24,24,24; gap=0; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_PADDING_LEFT→notification/padding_medium,STACK_PADDING_TOP→notification/padding_medium,STACK_PADDING_RIGHT→notification/padding_medium,STACK_PADDING_BOTTOM→notification/padding_medium |
| Type=Single/ivi_basic_button | 67:34069 → 67:28813 | INSTANCE | size=1356.5×80; xy=24,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Single/ivi_basic_button/ic_beam | 67:28814 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Single/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6816; hidden; fill=icon/dark/primary=#131417FF |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8175; fill=#000000FF |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3177; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2726; fill=#FFFFFFFF |
| Type=Single/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Single/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Single/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Single/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Single/ivi_basic_button/Label | 67:28815 | TEXT | size=56×38; xy=650.25,21; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='CTA' |
| Type=Single/ivi_basic_button/ic_arrow | 67:28816 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Single/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Single/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/System Notification/Frame 1/Col/Frame 1707486522/system_notification/button/Type=Vertical

- 원본 node: `67:34070`

- 공개 properties: `[{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Vertical | 67:34070 | SYMBOL | size=1404.5×224; xy=20,158; layout=VERTICAL/CENTER/MIN; padding(L,T,R,B)=24,24,24,24; gap=16; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→notification/gap_medium,STACK_PADDING_LEFT→notification/padding_medium,STACK_PADDING_TOP→notification/padding_medium,STACK_PADDING_RIGHT→notification/padding_medium,STACK_PADDING_BOTTOM→notification/padding_medium |
| Type=Vertical/ivi_basic_button | 67:34071 → 67:28849 | INSTANCE | size=1356.5×80; xy=24,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=button/filled/enabled=#44464EFF; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Vertical/ivi_basic_button/ic_beam | 67:28850 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Vertical/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6817; hidden; fill=icon/dark/primary=#131417FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/light/primary=#FFFFFFFF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,11.8174; fill=#000000FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,0; fill=#000000FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,0; fill=#000000FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9546; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9546; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3175; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2725; fill=#FFFFFFFF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2274; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2274; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Vertical/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/light/primary=#FFFFFFFF |
| Type=Vertical/ivi_basic_button/Label | 67:28851 | TEXT | size=56×38; xy=650.25,21; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='CTA' |
| Type=Vertical/ivi_basic_button/ic_arrow | 67:28852 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Vertical/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Vertical/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/light/primary=#FFFFFFFF |
| Type=Vertical/ivi_basic_button | 67:34072 → 67:28813 | INSTANCE | size=1356.5×80; xy=24,120; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; stackChildAlignSelf=STRETCH; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Vertical/ivi_basic_button/ic_beam | 67:28814 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Vertical/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6816; hidden; fill=icon/dark/primary=#131417FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8175; fill=#000000FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3177; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2726; fill=#FFFFFFFF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Vertical/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Vertical/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Vertical/ivi_basic_button/Label | 67:28815 | TEXT | size=149×38; xy=603.75,21; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Sub action' |
| Type=Vertical/ivi_basic_button/ic_arrow | 67:28816 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Vertical/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Vertical/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/System Notification/Frame 1/Col/Frame 1707486522/system_notification/button/Type=Horizontal

- 원본 node: `67:34073`

- 공개 properties: `[{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Horizontal | 67:34073 | SYMBOL | size=1404.5×128; xy=20,392; layout=HORIZONTAL/CENTER/MIN; padding(L,T,R,B)=24,24,24,24; gap=16; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→notification/gap_medium,STACK_PADDING_LEFT→notification/padding_medium,STACK_PADDING_TOP→notification/padding_medium,STACK_PADDING_RIGHT→notification/padding_medium,STACK_PADDING_BOTTOM→notification/padding_medium |
| Type=Horizontal/ivi_basic_button | 67:34074 → 67:28849 | INSTANCE | size=670.25×80; xy=24,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=button/filled/enabled=#44464EFF; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Horizontal/ivi_basic_button/ic_beam | 67:28850 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Horizontal/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6817; hidden; fill=icon/dark/primary=#131417FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/light/primary=#FFFFFFFF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,11.8174; fill=#000000FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,0; fill=#000000FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.0009; xy=0,0; fill=#000000FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9546; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5001; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9546; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3175; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2725; fill=#FFFFFFFF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2274; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2274; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Horizontal/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/light/primary=#FFFFFFFF |
| Type=Horizontal/ivi_basic_button/Label | 67:28851 | TEXT | size=56×38; xy=307.125,21; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='CTA' |
| Type=Horizontal/ivi_basic_button/ic_arrow | 67:28852 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Horizontal/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Horizontal/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/light/primary=#FFFFFFFF |
| Type=Horizontal/ivi_basic_button | 67:34075 → 67:28813 | INSTANCE | size=670.25×80; xy=710.25,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Horizontal/ivi_basic_button/ic_beam | 67:28814 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Horizontal/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6816; hidden; fill=icon/dark/primary=#131417FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8175; fill=#000000FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3177; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2726; fill=#FFFFFFFF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Horizontal/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Horizontal/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Horizontal/ivi_basic_button/Label | 67:28815 | TEXT | size=149×38; xy=260.625,21; fill=text/dark/primary=#131417FF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='Sub action' |
| Type=Horizontal/ivi_basic_button/ic_arrow | 67:28816 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Horizontal/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Horizontal/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/System Notification/Frame 1/Col/Frame 1707486522/system_notification/button/Type=Call

- 원본 node: `67:34076`

- 공개 properties: `[{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Call | 67:34076 | SYMBOL | size=1404.5×128; xy=20,530; layout=HORIZONTAL/CENTER/MIN; padding(L,T,R,B)=24,24,24,24; gap=16; stackPrimarySizing=FIXED; stackCounterSizing=RESIZE_TO_FIT_WITH_IMPLICIT_SIZE; stackChildAlignSelf=STRETCH; bind=STACK_SPACING→notification/gap_medium,STACK_PADDING_LEFT→notification/padding_medium,STACK_PADDING_TOP→notification/padding_medium,STACK_PADDING_RIGHT→notification/padding_medium,STACK_PADDING_BOTTOM→notification/padding_medium |
| Type=Call/ivi_basic_button | 67:34077 → 67:28813 | INSTANCE | size=670.25×80; xy=24,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=phone/accept_normal=#1314170D; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Call/ivi_basic_button/ic_beam | 67:28814 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Call/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6816; hidden; fill=icon/dark/primary=#131417FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8175; fill=#000000FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3177; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2726; fill=#FFFFFFFF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Call/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Call/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Call/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Call/ivi_basic_button/Label | 67:28815 | TEXT | size=52×38; xy=309.125,21; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='받기' |
| Type=Call/ivi_basic_button/ic_arrow | 67:28816 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Call/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Call/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |
| Type=Call/ivi_basic_button | 67:34078 → 67:28813 | INSTANCE | size=670.25×80; xy=710.25,24; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=32,16,32,16; gap=14; min={'x': 120, 'y': 80}; fill=phone/end_normal=#1314170D; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; bind=RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_top_right_medium,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_left_medium,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/basic/medium/radius_bottom_right_medium |
| Type=Call/ivi_basic_button/ic_beam | 67:28814 → 67:22065 | INSTANCE | size=40×40; xy=32,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Call/ivi_basic_button/ic_beam/Path | 67:22066 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=1.2273,6.6816; hidden; fill=icon/dark/primary=#131417FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract | 67:22067 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=#000000FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union | 67:22068 | BOOLEAN_OPERATION | size=37.5449×26.6367; xy=0,0; fill=icon/dark/primary=#131417FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Union | 67:22069 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,11.8175; fill=#000000FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract | 67:22070 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union | 67:22071 | BOOLEAN_OPERATION | size=18.4541×3.001; xy=0,0; fill=#000000FF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Union/Subtract/Union/Vector | 67:22072 | VECTOR | size=15.4545×0; xy=1.5,1.5009; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22073 | VECTOR | size=13.6364×8.1818; xy=3.3182,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22074 | VECTOR | size=13.6364×8.1818; xy=20.5909,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22075 | VECTOR | size=13.6364×8.1818; xy=20.5909,1.5002; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22076 | VECTOR | size=13.6364×8.1818; xy=3.3182,16.9548; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Union/Vector | 67:22077 | VECTOR | size=15.4545×0; xy=20.5909,13.3177; stroke=#000000FF; strokeWidth=3/CENTER |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Subtract | 67:22078 | BOOLEAN_OPERATION | size=24.4727×22.0909; xy=6.5284,2.2726; fill=#FFFFFFFF |
| Type=Call/ivi_basic_button/ic_beam/Path/Subtract/Subtract/Vector | 67:22079 | VECTOR | size=24.4727×22.0909; xy=0,0; fill=#FFFFFFFF |
| Type=Call/ivi_basic_button/ic_beam/Path/Vector | 67:22080 | VECTOR | size=9.0909×18.1818; xy=8.7727,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Call/ivi_basic_button/ic_beam/Path/Vector | 67:22081 | VECTOR | size=9.0909×18.1818; xy=19.6818,4.2275; r=1.5; stroke=#000000FF; strokeWidth=3/INSIDE |
| Type=Call/ivi_basic_button/ic_beam/Icon | 67:22082 | VECTOR | size=37.0455×26.1367; xy=1.4773,6.9317; fill=icon/dark/primary=#131417FF |
| Type=Call/ivi_basic_button/Label | 67:28815 | TEXT | size=52×38; xy=309.125,21; fill=text/light/primary=#FFFFFFFF; textAutoResize=WIDTH_AND_HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=CENTER; font=Asta Sans/Bold/30; line=38/PIXELS; letter=0/PERCENT; textStyle=Body/Large/Strong; maxLines=2; truncate=ENDING; text='거절' |
| Type=Call/ivi_basic_button/ic_arrow | 67:28816 → 67:22099 | INSTANCE | size=40×40; xy=175,20; hidden; bind=WIDTH→buttons/basic/medium/icon_sqaure,HEIGHT→buttons/basic/medium/icon_sqaure |
| Type=Call/ivi_basic_button/ic_arrow/Path | 67:22100 | VECTOR | size=11.6667×23.3333; xy=14.1667,8.3333; hidden; stroke=_Legacy/Scale/Black/Black=#000000FF; strokeWidth=4/CENTER |
| Type=Call/ivi_basic_button/ic_arrow/Icon | 67:22101 | VECTOR | size=15×26.6667; xy=12.5,6.6667; fill=icon/dark/primary=#131417FF |

## ❖ Components/System Notification/Frame 1/Col/Frame 1707486522/system_notification/images/Type=App

- 원본 node: `67:34080`

- 공개 properties: `[{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=App | 67:34080 | SYMBOL | size=100×100; xy=80,80; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→notification/system/imagary_square,HEIGHT→notification/system/imagary_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/images/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/images/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/images/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/images/radius_bottom_right |
| Type=App/img_app | 67:34081 → 67:25561 | INSTANCE | size=100×100; xy=0,0; r=0; r(TL,TR,BR,BL)=23.04,23.04,23.04,23.04; edgeStroke(T,R,B,L)=1,1,1,1; bind=WIDTH→os_notification/contents/image_square,HEIGHT→os_notification/contents/image_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→os_notification/contents/image_thumb_radius,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→os_notification/contents/image_thumb_radius,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→os_notification/contents/image_thumb_radius,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→os_notification/contents/image_thumb_radius |
| Type=App/img_app/App Market | 67:25562 → 67:25538 | INSTANCE | size=60×60; xy=0,0; r=0; r(TL,TR,BR,BL)=0,0,0,0; fill=IMAGE |
| Type=App/img_app/Preload | 67:25563 → 67:25393 | INSTANCE | size=100×100; xy=0,0; r=0; r(TL,TR,BR,BL)=0,0,0,0; fill=GRADIENT_LINEAR |
| Type=App/img_app/Preload/ic_vehicle/l | 67:25394 → 67:15063 | INSTANCE | size=100×100; xy=15.2778,15.2778 |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid | 67:15064 → 67:15030 | INSTANCE | size=69.4444×69.4444; xy=0,0; hidden; fill=#FFFFFFFF |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132 | 67:15031 | FRAME | size=69.4444×69.4444; xy=0,0 |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Rectangle 346244143 | 67:15032 | ROUNDED_RECTANGLE | size=47.7431×47.7431; xy=10.8507,10.8507; r=2; r(TL,TR,BR,BL)=2,2,2,2; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Rectangle 346244142 | 67:15033 | ROUNDED_RECTANGLE | size=54.2535×39.0625; xy=54.2535,7.5955; r=2; r(TL,TR,BR,BL)=2,2,2,2; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Rectangle 346244141 | 67:15034 | ROUNDED_RECTANGLE | size=54.2535×39.0625; xy=7.5955,15.191; r=2; r(TL,TR,BR,BL)=2,2,2,2; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15035 | VECTOR | size=60.7639×60.7639; xy=4.3403,4.3403; r=6; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15036 | VECTOR | size=69.4444×69.4444; xy=0,0 |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15037 | VECTOR | size=30.3819×30.3819; xy=19.5312,19.5312; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15038 | VECTOR | size=69.4444×0; xy=0,34.7222; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15039 | VECTOR | size=69.4444×0; xy=0,23.8715; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15040 | VECTOR | size=0×69.4444; xy=23.8715,0; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15041 | VECTOR | size=69.4444×69.4444; xy=0,0; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15042 | VECTOR | size=0×69.4444; xy=34.7222,0; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15043 | VECTOR | size=0×69.4444; xy=45.5729,0; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15044 | VECTOR | size=69.4444×0; xy=0,45.5729; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/ic_grid/Group 1707486132/Vector | 67:15045 | VECTOR | size=69.4444×69.4444; xy=0,0; stroke=_System/Brand/Primary/Normal=#5A46FAFF; strokeWidth=0.1/CENTER |
| Type=App/img_app/Preload/ic_vehicle/l/Union | 67:15065 | BOOLEAN_OPERATION | size=60.7639×47.743; xy=4.3403,10.8507; r=0; fill=GRADIENT_LINEAR; effect=DROP_SHADOW,offset={'x': 0, 'y': 1.7142857313156128},blur=1.7143,spread=0,color=#0000001A; effect=INNER_SHADOW,offset={'x': 0, 'y': 1},blur=0,spread=0,color=#FFFFFF1A |
| Type=App/img_app/Preload/ic_vehicle/l/Union/Vector | 67:15066 | VECTOR | size=50.7558×20.4445; xy=4.8674,0; stroke=#000000FF; strokeWidth=4/INSIDE |
| Type=App/img_app/Preload/ic_vehicle/l/Union/Subtract | 67:15067 | VECTOR | size=57.7932×30.4536; xy=1.3119,17.2893; fill=#000000FF |
| Type=App/img_app/Preload/ic_vehicle/l/Union/Vector | 67:15068 | VECTOR | size=7.5955×4.3403; xy=53.1684,13.0208; fill=#000000FF |
| Type=App/img_app/Preload/ic_vehicle/l/Union/Vector | 67:15069 | VECTOR | size=8.6806×4.3403; xy=8.6806,17.3611; fill=#000000FF |

## ❖ Components/System Notification/Frame 1/Col/Frame 1707486522/system_notification/images/Type=Profile

- 원본 node: `67:34082`

- 공개 properties: `[{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Profile | 67:34082 | SYMBOL | size=100×100; xy=260,80; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→notification/system/imagary_square,HEIGHT→notification/system/imagary_square |
| Type=Profile/imagery_profile | 67:34083 → 67:28901 | INSTANCE | size=100×100; xy=0,0; r=0; r(TL,TR,BR,BL)=999,999,999,999; fill=IMAGE; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH; bind=WIDTH→os_notification/contents/image_square,HEIGHT→os_notification/contents/image_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/profile/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/profile/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/profile/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/profile/radius_bottom_right |
| Type=Profile/ic_app | 67:34084 → 67:25561 | INSTANCE | size=48×48; xy=60,60; r(TL,TR,BR,BL)=16,16,16,16; stroke=divider/secondary=#1314171A; strokeWidth=1/INSIDE; edgeStroke(T,R,B,L)=1,1,1,1; effect=DROP_SHADOW,offset={'x': 0, 'y': 8},blur=32,spread=0,color=#00000029; effect=DROP_SHADOW,offset={'x': 0, 'y': 2},blur=2,spread=0,color=#00000014; bind=WIDTH→notification/system/profile/app_square,HEIGHT→notification/system/profile/app_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/profile/app_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/profile/app_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/profile/app_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/profile/app_radius_bottom_right |
| Type=Profile/ic_app/App Market | 67:25562 → 67:25538 | INSTANCE | size=60×60; xy=0,0; r=0; r(TL,TR,BR,BL)=0,0,0,0; fill=IMAGE |
| Type=Profile/ic_app/Preload | 67:25563 → 67:25363 | INSTANCE | size=48×48; xy=0,0; r=0; r(TL,TR,BR,BL)=0,0,0,0; fill=GRADIENT_LINEAR |
| Type=Profile/ic_app/Preload/Group 1707486104 | 67:25364 | FRAME | size=30.75×30.0002; xy=9,8.25 |
| Type=Profile/ic_app/Preload/Group 1707486104/Vector 5679 | 67:25365 | VECTOR | size=18.75×9; xy=0,21; opacity=0.95; r=2.2222; fill=GRADIENT_LINEAR; effect=DROP_SHADOW,offset={'x': 0, 'y': 1.8095300197601318},blur=1.8095,spread=0,color=#0000001A; effect=INNER_SHADOW,offset={'x': 0, 'y': 1.0555591583251953},blur=0,spread=0,color=#FFFFFF1A |
| Type=Profile/ic_app/Preload/Group 1707486104/Ellipse 7729 | 67:25366 | ELLIPSE | size=30×30.0002; xy=0.75,0; fill=GRADIENT_LINEAR; effect=DROP_SHADOW,offset={'x': 0, 'y': 1.302049160003662},blur=1.302,spread=0,color=#0000001A; effect=INNER_SHADOW,offset={'x': 0, 'y': 0.759528636932373},blur=0,spread=0,color=#FFFFFF1A |
| Type=Profile/ic_app/Preload/Group 1707486104/Vector | 67:25367 | VECTOR | size=18×18; xy=6.75,6; fill=#30CF72FF |

## ❖ Components/System Notification/Frame 1/Col/Frame 1707486522/system_notification/images/Type=Image

- 원본 node: `67:34085`

- 공개 properties: `[{"name":"Type","type":"VARIANT","initialValue":{}}]`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| Type=Image | 67:34085 | SYMBOL | size=100×100; xy=440,80; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→notification/system/imagary_square,HEIGHT→notification/system/imagary_square,RECTANGLE_TOP_LEFT_CORNER_RADIUS→notification/system/images/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→notification/system/images/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→notification/system/images/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→notification/system/images/radius_bottom_right |
| Type=Image/imagery_image | 67:34086 → 67:33986 | INSTANCE | size=100×100; xy=100,0; r(TL,TR,BR,BL)=16,16,16,16; fill=button/basic/enabled=#1314170D; stackPrimarySizing=FIXED; stackChildPrimaryGrow=1; stackChildAlignSelf=STRETCH |
| Type=Image/imagery_image/ic_image | 67:33987 → 67:33977 | INSTANCE | size=48×48; xy=20,20 |
| Type=Image/imagery_image/ic_image/Path | 67:33978 | BOOLEAN_OPERATION | size=50.293×42.1875; xy=5.0197,6.5625; hidden; fill=icon/dark/primary=#131417FF |
| Type=Image/imagery_image/ic_image/Path/Vector | 67:33979 | VECTOR | size=13.125×13.125; xy=37.1678,0; fill=Common/Empty/Content=#EEEEEEFF |
| Type=Image/imagery_image/ic_image/Path/Vector | 67:33980 | VECTOR | size=26.25×24.375; xy=24.9803,17.8125; r=2; fill=Common/Empty/Content=#EEEEEEFF |
| Type=Image/imagery_image/ic_image/Path/Vector | 67:33981 | VECTOR | size=38.4375×37.5; xy=-1.2697,4.6875; r=2; fill=Common/Empty/Content=#EEEEEEFF |
| Type=Image/imagery_image/ic_image/Icon | 67:33982 | VECTOR | size=49.9754×42.1875; xy=5.3371,6.5625; fill=icon/dark/quaternary=#13141752 |

