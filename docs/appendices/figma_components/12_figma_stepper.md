# Figma assets — 컴포넌트 및 하위 레이어 해석 부록

> **원본 부록:** 웹과 다른 옛 값은 이력이다. 최신 구현은 01·02·03·08번의 웹 최종값을 적용한다. 원본 snapshot 색을 새 웹 token 위에 다시 덮지 않는다.

원본 SYMBOL의 레이어 및 INSTANCE의 master 기본값, symbolOverrides, derivedSymbolData, componentPropAssignments를 병합한 오프라인 참조이다. 모든 치수는 원본 design unit이며 root xy는 디자인 보드상 위치이므로 런타임 위치로 복사하지 않는다. child xy는 부모 상대 좌표이다. r 순서는 TL/TR/BR/BL, padding 순서는 L/T/R/B이다.

fill/stroke의 HEX는 `#RRGGBBAA`이며 원본 color alpha×paint.opacity를 합성한 스냅샷 값이다. theme 동작에는 별도 전체 토큰 표와 웹 기준 충돌 해결 규칙을 적용한다. 노드 opacity는 별도로 표시한다. `hidden`은 예제에서 꺼진 옵션이며 구현에서 삭제하라는 뜻이 아니다. master의 드롭다운/토글/Label 등 공개 property도 구현 대상이다.

이 표는 바이너리 파싱 없이 geometry/style/variant를 참조하도록 만든다. Figma 렌더러 전체를 재구현한 것은 아니므로 boolean geometry·clip·특수 효과의 pixel 일치는 SVG 및 원본 guide와 검증한다. 외부 master 누락은 마지막 해석 결과에 별도로 남긴다.


## Internal Only Canvas/ivi_stepper

- 원본 node: `67:25189`

| Relative layer | Source ID / master | Type | Dimensions / Style / Behavior bindings |
| --- | --- | --- | --- |
| ivi_stepper | 67:25189 | SYMBOL | size=420×100; xy=0,144; r(TL,TR,BR,BL)=24,24,24,24; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=24,18,24,18; gap=24; fill=controller/stepper_background=#FFFFFFFF; stroke=divider/secondary=#1314171A; strokeWidth=2/INSIDE; edgeStroke(T,R,B,L)=2,2,2,2; stackPrimarySizing=FIXED; effect=DROP_SHADOW,offset={'x': 0, 'y': 6},blur=24,spread=0,color=#00000014; bind=STACK_SPACING→controller/stepper/gap_horizontal,STACK_PADDING_LEFT→controller/stepper/padding_horizontal,STACK_PADDING_TOP→controller/stepper/padding_vertical,STACK_PADDING_RIGHT→controller/stepper/padding_horizontal,STACK_PADDING_BOTTOM→controller/stepper/padding_vertical,WIDTH→controller/stepper/width,HEIGHT→controller/stepper/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→controller/stepper/radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→controller/stepper/radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→controller/stepper/radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→controller/stepper/radius_bottom_right,BORDER_TOP_WEIGHT→controller/stepper/border,BORDER_BOTTOM_WEIGHT→controller/stepper/border,BORDER_LEFT_WEIGHT→controller/stepper/border,BORDER_RIGHT_WEIGHT→controller/stepper/border |
| ivi_stepper/ivi_icon_button | 67:25190 → 67:24352 | INSTANCE | size=64×64; xy=24,18; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| ivi_stepper/ivi_icon_button/ic_plus | 67:24353 → 67:25150 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| ivi_stepper/ivi_icon_button/ic_plus/Path | 67:25151 | VECTOR | size=27.5×0; xy=8.25,22; hidden; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| ivi_stepper/ivi_icon_button/ic_plus/Icon | 67:25152 | VECTOR | size=30.8×3.3; xy=6.6,20.35; fill=icon/dark/primary=#131417FF |
| ivi_stepper/divider | 67:25191 | VECTOR | size=0×64; xy=112,18; stroke=divider/tertiary=#13141733; strokeWidth=2/CENTER; stackChildAlignSelf=STRETCH; bind=STROKE_WEIGHT→controller/stepper/divider |
| ivi_stepper/48A | 67:25192 | TEXT | size=148×44; xy=136,28; fill=text/dark/primary=#131417FF; stackChildPrimaryGrow=1; textAutoResize=HEIGHT; textAlignHorizontal=CENTER; textAlignVertical=TOP; font=Asta Sans/Bold/36; line=44/PIXELS; letter=0/PERCENT; textStyle=Title/Medium/Strong; text='48A' |
| ivi_stepper/divider | 67:25193 | VECTOR | size=0×64; xy=308,18; stroke=divider/tertiary=#13141733; strokeWidth=2/CENTER; stackChildAlignSelf=STRETCH; bind=STROKE_WEIGHT→controller/stepper/divider |
| ivi_stepper/ivi_icon_button | 67:25194 → 67:24352 | INSTANCE | size=64×64; xy=332,18; r(TL,TR,BR,BL)=16,16,16,16; layout=HORIZONTAL/CENTER/CENTER; padding(L,T,R,B)=0,0,0,0; gap=0; stackPrimarySizing=FIXED; bind=WIDTH→buttons/icon/small/width,HEIGHT→buttons/icon/small/height,RECTANGLE_TOP_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_left,RECTANGLE_TOP_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_top_right,RECTANGLE_BOTTOM_LEFT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_left,RECTANGLE_BOTTOM_RIGHT_CORNER_RADIUS→buttons/icon/small/rounded_radius_bottom_right |
| ivi_stepper/ivi_icon_button/ic_plus | 67:24353 → 67:22174 | INSTANCE | size=44×44; xy=10,10; bind=WIDTH→buttons/icon/small/content,HEIGHT→buttons/icon/small/content |
| ivi_stepper/ivi_icon_button/ic_plus/Path | 67:22175 | BOOLEAN_OPERATION | size=31.1×31.1; xy=6.45,6.45; hidden; fill=icon/dark/primary=#131417FF |
| ivi_stepper/ivi_icon_button/ic_plus/Path/Vector 5983 | 67:22176 | VECTOR | size=27.5×0; xy=1.8,15.55; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| ivi_stepper/ivi_icon_button/ic_plus/Path/Vector 5984 | 67:22177 | VECTOR | size=0×27.5; xy=15.55,1.8; stroke=icon/dark/primary=#131417FF; strokeWidth=3.6/CENTER |
| ivi_stepper/ivi_icon_button/ic_plus/Icon | 67:22178 | VECTOR | size=30.8×30.8; xy=6.6,6.6; fill=icon/dark/primary=#131417FF |

