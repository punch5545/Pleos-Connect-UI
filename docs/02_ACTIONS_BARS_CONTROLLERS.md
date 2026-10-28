# 02. Actions · Bar · Controllers · Indicator · Dropdown 구현 지시

이 문서는 상위 실행 프롬프트, 공통 토큰·폼팩터·접근성 규칙과 함께 적용한다. 외부 링크를 열 필요가 없도록 규격과 동작을 아래에 기재했다. `u`는 원본 디자인 좌표 단위이며 `dp`로 단정하지 않는다. 수치는 별도 표기가 없으면 첨부 **design_assets_215의 connect-s 값**이다. 다른 폼팩터에는 동봉된 변수 모드별 값을 사용한다. `#RRGGBB @ a`는 색과 최종 알파를 뜻하며 중복해서 알파를 적용하지 않는다.

근거 표시는 `[W]` 공식 웹 본문·도표, `[F]` 사용자 첨부 Figma, `[M]` 웹 SVG의 좌표 측정, `[I]` 이 라이브러리를 완성하기 위한 구현 결정이다. `[I]`를 Pleos 공식 규칙으로 설명하지 않는다. **문서 간 상충하면 웹이 최신이다. 최종 구현은 단일 `WebLatest20261028` 규격**을 사용한다. 웹에서 빠진 치수·변형만 첨부로 보완한다. 아래 비교표의 상충하는 첨부값은 변경 이력이며 실행 중 선택할 별도 사양으로 구현하지 않는다. 색상 표의 Figma 밝은 스냅샷과 01의 최신 웹 토큰이 다르면 01의 최종 토큰을 사용한다.

## 1. 구현 범위와 공통 계약

| 분류 | 반드시 제공할 공개 컴포넌트 | 필수 변형 |
|---|---|---|
| Basic button | `PleosBasicButton` | Primary/Secondary × Large/Medium/Small × Enabled/Pressed/Disabled/Loading |
| Toggle button | `PleosToggleButton` | Off/On × Large/Medium/Small × Enabled/Pressed/Disabled, Floating On/Off |
| Text button | `PleosTextButton` | Medium/Small × Enabled/Pressed/Disabled/Loading, prefix/suffix 옵션 |
| Icon button | `PleosIconButton` | Basic/Plain/Circle × Large/Medium/Small × Enabled/Pressed/Disabled |
| Keypad | `PleosNumericKey`, `PleosKeyboardKey`, `PleosNumericKeypad`, `PleosKeyboard` | Numeric Number/Delete/Clear, QWERTY Primary/Secondary/Special의 실제 키 종류, Normal/Static palette, Shift Off/On, Text/Voice mode |
| Bar | `PleosWindowControlBar`, `PleosAppControlBar`, `PleosScrollBar` | Light/Dark, Enabled/Pressed/Dragging/Disabled, scroll controllable/read-only, 첨부의 app bar 확장 |
| Controllers | `PleosContinuousSlider`, `PleosCenteredSlider`, `PleosStepper` | Basic/Floating, label/icon 옵션, centered Button/Basic/Number 및 OFF, 범위·스텝·양끝 상태 |
| Indicator | `PleosPageIndicator` | Wide/Narrow, Present true/false |
| Dropdown | `PleosDropdown`, `PleosDropdownMenu`, `PleosDropdownItem` | Medium/Small, Opened, Enabled/Pressed/Disabled/Selected, AppIcon/Icon prefix, Switch/Icon suffix, Footer |

`Pressed`는 실제 포인터·키·로터리 확인 입력의 interaction으로부터 산출한다. 선택 상태나 열림 상태를 Pressed로 대체하지 않는다. 미리보기/스크린샷에는 별도의 interaction 주입 수단을 제공한다. `enabled=false` 및 `loading=true`는 activation callback을 차단한다. Disabled 컨트롤은 TalkBack에 역할·라벨·비활성을 전달한다. 클릭/체크/선택 이벤트는 한 번만 발행한다. 모든 값은 caller가 소유하는 상태 끌어올리기 방식으로 제공하고 편의 상태 holder는 별도 계층으로 둔다. `[I]`

## 2. Basic button

### 공식 의미·상태

Root 안에 Label과 선택적인 앞·뒤 Icon이 들어가는 기본 실행 버튼이다. 웹은 Pressed, Disabled, Loading을 정의하며 Loading이면 loader를 표시하고 조작을 차단한다. 웹의 Properties 표는 States 표를 중복 수록했으므로 그 표를 타입 목록으로 해석하지 않는다. 실제 hierarchy 도표에는 **Primary, Secondary**, size 도표에는 **Large, Medium, Small**이 있다. `[W-A01]`

### 형태·치수

첨부 `ivi_basic_button`에는 2 hierarchy × 3 size × 3 state = **18개 variant**가 있다. Loading은 웹이 추가로 요구하므로 6개 hierarchy/size 조합 모두에서 구현한다. prefix와 suffix는 각각 독립적으로 생략할 수 있다. 숨겨진 icon이 차지하던 폭·gap은 제거한다. `[F]`

| 크기 | 높이 | 최소 폭 | 좌/우 padding | 위/아래 padding | 자식 간 gap | radius | icon box | Label 크기/행높이 |
|---|---:|---:|---:|---:|---:|---:|---:|---|
| Large | 100 | 140 | 40 | 16 | 16 | 32 | 52×52 | 32/40, Asta Sans Bold |
| Medium | 80 | 120 | 32 | 16 | 14 | 24 | 40×40 | 30/38, Asta Sans Bold |
| Small | 64 | 100 | 24 | 8 | 12 | 16 | 32×32 | 26/34, Asta Sans Bold |

폭은 `max(minWidth, 실제로 보이는 자식의 폭 합 + 실제 gap 합 + 양쪽 padding)`이다. 첨부의 160/139/113 폭은 문자열 `Label`만 보이는 샘플 결과이며 고정 폭이 아니다. Label은 가운데 정렬, 자간 0, 최대 2행, 넘침은 끝말줄임이다. 두 줄 Label과 font scale이 커지는 경우는 공통 접근성·자동 높이 정책으로 처리한다. `[F/I]`

| hierarchy/state | 배경 토큰 | Label 토큰 | 테두리 |
|---|---|---|---|
| Primary Enabled | `button/basic/enabled` | `text/dark/primary` | 없음 |
| Primary Pressed | `button/basic/pressed` | `text/dark/primary` | 없음 |
| Primary Disabled | `button/basic/disabled` | `text/dark/quaternary` | `divider/secondary`, 2u inside |
| Secondary Enabled | `button/filled/enabled` | `text/light/primary` | 없음 |
| Secondary Pressed | `button/filled/pressed` | `text/light/primary` | 없음 |
| Secondary Disabled | `button/filled/disabled` | `text/dark/quaternary` | `divider/secondary`, 2u inside |

Light 첨부 snapshot에서 basic 배경은 순서대로 `#131417 @ .05`, `#131417 @ .10`, `#FFFFFF @ .20`; filled 배경은 `#44464E`, `#313236`, `#131417 @ .05`이다. Disabled Label은 `#131417 @ .32`, disabled border는 `#131417 @ .10`이다. Dark는 동일 HEX를 뒤집는 것이 아니라 공통 토큰 표의 해당 모드를 사용한다. `[F]`

Loading 시 회전 loader를 중앙에 배치하고 접근성 상태를 “처리 중”으로 알린다. 원래 콘텐츠의 측정 폭을 유지해 레이아웃 이동을 막는다. busy가 시작되기 전 기존 focus를 유지하되 재클릭은 차단한다. 날짜/시간 선택기인 `PleosDateSpinner`·`PleosTimeSpinner`를 버튼 로딩 표시에 재사용하지 않는다. 별도의 `PleosLoadingIndicator`와 `LoadingIndicatorSpec`을 제공한다. `[I]`

Loader의 원형·색·모션은 **01 공통 Foundation의 공식 Loading 애니메이션**을 그대로 사용한다. 원본 viewport64×64, center(32,32), radius24, stroke8을 함께 균등 축소한다. 버튼 안의 표시 viewport box는 공식 치수 미정의이므로 Large/Medium/Small **40×40/32×32/24×24u**를 교체 가능한 `[I]` 기본값으로 둔다. 이 비율의 stroke는 각각 **5/4/3u**다. 공식 30fps·frame0→60의 회전0→1080도와 op61, Linear/Tension trim 동작은 01을 따르고 임의의1000ms 회전으로 대체하지 않는다. 같은 모션에서 Light/Dark 색상·알파를 적용한다. 호스트가 reduced motion을 요청하면 정지형 busy glyph와 semantics로 표현하는 `[I]` 정책을 제공한다. `[W/F/I]`

필수 API 정보: `text`, `onClick`, `hierarchy`, `size`, `enabled`, `loading`, `leadingIcon`, `trailingIcon`, `modifier`, `interactionSource`. 클릭 결과·네트워크 호출은 외부 책임이다.

## 3. Toggle button

### 공식 의미·옵션

토글 버튼은 상태가 지속되는 On/Off 실행 요소다. Toggled의 초기값은 false. Disabled와 Pressed를 별도로 갖고 크기 Large/Medium/Small, Floating true/false를 제공한다. 웹의 Pressed 설명에 다른 컴포넌트의 drag-window 문구가 섞여 있지만 버튼에 window 이동 동작을 넣지 않는다. Floating 도표는 배경 위에서 shadow로 분리되는 On과 평면 배경의 Off를 보여준다. `[W-A02]`

### Figma 변형과 상태

첨부 `ivi_toggle_button`은 3 size × 3 state × `On active=false/true` = **18개 variant**다. 전체 치수는 Basic button 표와 같다. Label은 2행 제한, Bold이며 Off Enabled/Pressed에는 `text/dark/secondary`, On Enabled/Pressed에는 `text/dark/primary`, Disabled에는 `text/dark/quaternary`를 사용한다. Off 배경은 Basic button의 `button/basic/*`; On 배경은 `button/switch/*`. `[F]`

| 상태 | On 배경 Light snapshot | 그림자 |
|---|---|---|
| Enabled | `button/switch/enabled` = `#FFFFFF @ 1` | 아래 두 레이어 |
| Pressed | `button/switch/pressed` = `#FFFFFF @ .5` | 아래 두 레이어 |
| Disabled | `button/switch/disabled` = `#FFFFFF @ .3` | 없음, `divider/secondary` inside 2u |

첨부의 Enabled/Pressed On shadow는 `(x0,y8,blur32,spread0,black .16)`와 `(x0,y2,blur2,spread0,black .08)` 두 레이어다. size마다 같은 shadow token을 바인딩한다. Small+On+Disabled 노드 `67:22675`만 `button/basic/disabled`(.2)를 참조하는 원본 예외가 있다. 이 예외는 이력으로만 남기고 **최종 구현은 Small도 최신 웹의 토글 공통 `button/switch/disabled` 토큰**을 사용한다. `[F/W]`

Floating과 checked는 서로 다른 축으로 모델링한다. 웹은 Floating 옵션을 정의하지만 첨부는 독립 Floating variant를 주지 않으므로 `[I]`로 `floating=true`일 때 shadow를 허용하고 false일 때 제거하는 surface policy를 둔다. On의 흰색/반투명 surface는 checked 상태를 표현한다. Off/On마다 3 상태를 모두 유지한다.

필수 API 정보: `checked: Boolean`, `onCheckedChange(Boolean)`, `enabled`, `size`, `floating`, `text`, 양쪽 icon. Role은 toggle button/checkbox에 준하는 선택 semantics로 전달하고 클릭 시 `!checked` 한 번만 요청한다. Toggle group의 단일선택·다중선택 정책은 별도 상위 구성요소에서 처리한다. `[I]`

## 4. Text button

추가 정보로 이동하는 텍스트형 실행 요소로 prefix/suffix icon을 제공한다. 웹은 Medium/Small, Pressed/Disabled/Loading을 정의한다. 예시의 Pressed는 Label에 밑줄이 생기며 Disabled는 흐린 Label·icon으로 표시한다. `[W-A03]`

| 크기 | Label 크기/행높이 | icon box | gap | 자체 배경·padding |
|---|---|---:|---:|---|
| Medium | 30/38 Asta Sans Bold | 32×32 | 8 | 없음 |
| Small | 26/34 Asta Sans Bold | 28×28 | 4 | 없음 |

첨부 `ivi_text_button` 6 variants의 Enabled/Pressed Label 색은 `informative/positive`(Light `#0064FF`), Disabled는 `text/dark/quaternary`다. Pressed 밑줄은 `textData.styleOverrideTable.textDecoration=UNDERLINE`에도 기록되어 있다. maxLines=2, 끝말줄임을 적용한다. `[F]`

측정상 텍스트 높이와 사용자 입력을 받는 터치 영역을 분리한다. 숨겨진 padding을 임의로 시각 디자인에 추가하지 말고 외부 hit target 확장으로 접근성을 확보한다. Loading은 웹 요구사항이나 첨부 variant에는 없으므로 `PleosLoadingIndicator`를 동일한 가시 폭에 표시하고 입력을 차단한다. `[I]`

필수 API는 Basic button의 공통 입력을 재사용하되 hierarchy를 받지 않는다. label 문자열 자체에 `_`를 붙여 밑줄을 흉내 내지 않는다. `[I]`

## 5. Icon button

### 종류와 크기

텍스트 없이 의미를 알아볼 수 있는 아이콘 행동 요소다. Basic/Plain/Circle의 세 스타일을 모두 구현하며 Pressed와 Disabled를 지원한다. 웹은 Large/Medium/Small을 명시한다. `[W-A04]`

첨부 `ivi_icon_button`에는 Medium/Small만 있어 3 style × 3 state × 2 size = **18개 variant**다. 원본의 `Diabled` 철자는 공개 API에서 `Disabled`로 정규화한다. `[F]`

| 크기 | Root | Icon | Basic/Plain radius | Circle |
|---|---:|---:|---:|---|
| Medium | 80×80 | 56×56 | 20 | 원형(원본 radius 999) |
| Small | 64×64 | 44×44 | 16 | 원형(원본 radius 999) |
| Large | 웹에 이름만 있고 첨부 치수 없음 | 미정의 | 미정의 | 원형 |

Basic/Circle의 Enabled/Pressed/Disabled는 `button/basic/enabled/pressed/disabled` 배경을 사용한다. Plain은 Enabled/Disabled 투명, Pressed만 `button/basic/pressed`. Disabled icon은 비활성 토큰을 적용한다. 첨부는 disabled Basic/Circle에 Basic text button과 같은 테두리를 지정하지 않으므로 일괄 border를 추가하지 않는다. `[F]`

**Large를 누락하지 않는다.** `IconButtonMetrics` 주입점과 `Large` enum을 제공한다. 기본값은 `[I-PROVISIONAL]`로 100×100 Root, 64×64 icon, radius 24를 사용하고 공식 치수처럼 표시하지 않는다. 이 provisional 값은 `SPEC_DECISIONS.md`와 카탈로그의 “미확정 규격”에 기록하고 향후 확인된 값으로 단일 토큰 교체가 가능하게 한다. 원본에 없는 크기를 Medium에 조용히 매핑하지 않는다. `[I]`

`contentDescription`은 필수다. tooltip이나 접근성 라벨 없이 장식용 icon을 클릭 영역으로 쓰지 않는다. 크기 변화·Disabled·Pressed·3 style·두 theme·양방향 레이아웃을 카탈로그에서 조작할 수 있게 한다. `[I]`

## 6. Keypad

### 공식 범위

웹은 Numeric keypad(Number/Function), QWERTY keypad(Primary/Secondary/Special), Text/Voice 입력 경로를 제시한다. Shift 예시에 Enabled/Pressed/Selected/Disabled가 있다. 웹 state 표의 Pressed 중복을 서로 다른 상태로 만들지 않는다. 웹의 숫자판 사진 하단 `Qwerty Keyboard` 캡션은 그림의 실제 종류와 맞지 않는 표기 오류다. `[W-A05]`

### Numeric 키

첨부 `ivi_numeric_keypad`는 다음 **8개 variant**를 가진다: Number Enabled/Pressed, Delete Enabled/Pressed/Disabled, Clear Enabled/Pressed/Disabled. 전체 키 Root는 **200×108, radius32**. Number는 **56/72 Asta Sans Bold**, Clear는 **40/52 Asta Sans Regular**, Delete icon은 **48×48**. `[F]`

| 역할 | Enabled | Pressed | Disabled |
|---|---|---|---|
| Number | `keyboard/normal/primary_normal` | `keyboard/normal/primary_pressed` | 첨부 미제공; 공통 disable policy `[I]` |
| Delete/Clear | `surface/accent` | `surface/accent` 위 `dim/dark/tertiary` | surface 유지, 내용 비활성 토큰 |

숫자는 `1,2,3 / 4,5,6 / 7,8,9 / Function,0,Delete` 3열을 기본 배열로 제공한다. Function 자리는 Clear/Save/Done 등 caller 지정 행동 슬롯이다. 웹의 Save는 별도 action의 한 예시이지 항상 저장이 가능한 의미가 아니다. 빈 입력에서는 Delete/Clear 비활성 상태를 표현할 수 있어야 한다. 숫자 키의 Disabled 지원은 global enabled 계약을 지키기 위한 구현 확장으로 표시한다. `[W/I]`

### QWERTY 실제 키 종류

첨부 `ivi_keypad_normal`과 `ivi_keypad_static` 각각 **18개 variant**를 모두 구현한다. Primary, Delete, Shift, Secondary, Mic, Hyphen, Space, Enter의 8 kind가 있고 기본 Enabled/Pressed 두 상태; Shift만 On=false/true 조합을 갖는다. Special 하나로 모양·폭이 다른 기능키를 합치지 않는다. `[F]`

| Kind | 기준 Root | radius | 내용 |
|---|---:|---:|---|
| Primary | 100×80 | 20 | 40/52 Regular 문자 |
| Delete | 120×80 | 20 | 44×44 삭제 icon |
| Shift | 165×80 | 20 | 44×44 shift icon, Off/On |
| Secondary | 120×80 | 20 | 36/44 Regular, 예: 한/A |
| Mic | 120×80 | 20 | 44×44 mic icon |
| Hyphen | 120×80 | 20 | 40/52 Regular `-` |
| Space | 300×80 | 20 | 기본 Label 숨김; 보이는 경우 32/40 Regular |
| Enter | 200×80 | 20 | 44×44 enter icon |

키보드 전체는 아래의 명시적 간격·배치 규칙으로 키 primitive를 조합한다. 글자 폭마다 Root 크기를 바꾸지 않으며 각 키에 stable semantic id를 부여한다. Space의 300은 독립 키 master의 예시 폭이고, 전체 키보드에서는 남는 폭을 채우도록 확장한다. `[F/I]`

| Palette/역할 | Enabled | Pressed |
|---|---|---|
| Normal Primary/Space | `keyboard/normal/primary_normal` (`#FFFFFF`) | `keyboard/normal/primary_pressed` (`#EDEEF2`) |
| Normal Secondary/Delete/Mic/Hyphen/Shift Off | `keyboard/normal/secondary_normal` (`#C7C9CE`) | `keyboard/normal/secondary_pressed` (`#A4A8AE`) |
| Normal Shift On | `keyboard/normal/active_normal` (`#44464E`) | `keyboard/normal/active_pressed` (`#313236`) |
| Normal Enter | `keyboard/normal/accents_normal` (`#44464E`) | `keyboard/normal/accents_pressed` (`#313236`) |
| Static Primary/Space | `keyboard/static/primary_normal` (`#686A72`) | `keyboard/static/primary_pressed` (`#44464E`) |
| Static Secondary/Delete/Mic/Hyphen/Shift Off | `keyboard/static/secondary_normal` (`#44464E`) | `keyboard/static/secondary_pressed` (`#686A72`) |
| Static Shift On | `keyboard/static/active_normal` (`#686A72`) | `keyboard/static/active_pressed` (`#313236`) |
| Static Enter | `keyboard/static/accents_normal` (`#C7C9CE`) | `keyboard/static/accents_pressed` (`#A4A8AE`) |

위 HEX는 Light 또는 Static 첨부 snapshot 설명이며 mode를 무시한 하드코딩 근거가 아니다. Normal 문자에는 `text/dark/primary`; Static 문자에는 `keyboard/static/text`를 쓴다. Space의 숨겨진 Label은 일부 노드에 다른 토큰이 남아 있지만 기본 렌더에 등장하지 않는다. Shift On icon은 활성 의미 토큰을 사용한다. `[F]`

키보드 예시에는 숫자행, 한글 두벌식 자모행, Shift, 삭제, 한/영 변경, 기호 전환, Space, Mic, `-`, Enter가 있다. 기본 `KeyboardLayout`에 다음 배열을 제공한다. 영문 배열은 구현 제공값 `[I]`; 한글 배열은 웹 그림을 텍스트화한 값 `[W]`이다.

```text
digit row: 1 2 3 4 5 6 7 8 9 0 Delete
English:   Q W E R T Y U I O P
           A S D F G H J K L
           Shift Z X C V B N M , .
Korean:    ㅂ ㅈ ㄷ ㄱ ㅅ ㅛ ㅕ ㅑ ㅐ ㅔ
           ㅁ ㄴ ㅇ ㄹ ㅎ ㅗ ㅓ ㅏ ㅣ
           Shift ㅋ ㅌ ㅊ ㅍ ㅠ ㅜ ㅡ , .
function:  Language Symbols Space Mic Hyphen Enter
```

### 전체 레이아웃과 간격

웹 Keyboard SVG의 QWERTY 예시는 Primary가 80×64 SVG 좌표로 그려져 있고, 첨부 기준 키100×80에 대해 축척은 .8이다. 이 축척으로 환산한 **key gap10u, row gap10u, 좌우·하단 padding24u, 상단56u, 전체1268×520u**를 기본 배치로 사용한다. 상단56에는 드래그 핸들 공간이 포함된다. 이는 문장에 기재된 숫자 사양이 아니라 SVG 좌표를 측정한 값이다. `[M-W-A05]`

아래 이름은 라이브러리의 `KeyboardLayoutMetrics`·`NumericKeypadLayoutMetrics` 필드다. 첨부에는 이 간격의 전용 변수 ID가 없으므로 공식 Figma 토큰인 것처럼 이름이나 ID를 만들어 붙이지 않는다. 값은 `connect-s` 기준 디자인 단위 `u`이며, **전용 모드값이 없는 이 표의 간격·padding은 다른 design-assets 모드에도 같은 u값을 적용**한다. 이는 구현 정책 `[I]`이다. 키 자체의 width/height/radius/icon은 실제 모드별 `keyboard/keyword/*`·`buttons/keypad/*` 변수를 적용하고, 최종 dp 계산 전에 모든 u를 01의 변환 규칙으로 한 번 변환한다.

| 레이아웃 필드 | 적용값 | 근거와 적용 범위 |
|---|---:|---|
| Numeric `columnGap` | 24u | 예시 좌표의15.12를 키 높이 축척.63으로 환산 `[M]` |
| Numeric `rowGap` | 40u | 행간 숫자 규정이 없다. 예시의 빈 간격24 SVG 좌표는 같은 축척으로 약38.1u이며, 재사용 기본값은40u로 정한다 `[I]` |
| Numeric `contentPadding` | 상하좌우48u | 예시 좌우·하단30.24 SVG 좌표→48u `[M]`; 독립 숫자판의 위 padding48은 대칭 배치를 위한 `[I]` |
| Numeric `fieldToKeysGap` | 48u | 선택적 Number Field 하단과 첫 키 행 사이30.24 SVG 좌표→48u `[M]` |
| QWERTY `columnGap` | 10u | 가로 빈 간격8 SVG 좌표÷.8 `[M]` |
| QWERTY `rowGap` | 10u | 세로 빈 간격8 SVG 좌표÷.8 `[M]` |
| QWERTY `paddingStart/End/Bottom` | 각각24u | 외곽에서 첫·마지막 키까지19.2 SVG 좌표÷.8 `[M]` |
| QWERTY `paddingTop` | 핸들 있음56u, 없음24u | 핸들 있음은44.8 SVG 좌표÷.8 `[M]`; 없는 경우24u는 `[I]` |
| QWERTY `handleSize/handleTop` | 140×8u / 16u | 상단 중앙 핸들의112×6.4 및 상단 여백12.8 SVG 좌표÷.8 `[M]` |
| QWERTY `containerRadius` | 50u | 예시 외곽 radius40 SVG 좌표÷.8 `[M]` |
| QWERTY `spaceMinWidth` | 300u | 첨부 독립 Space 폭300 `[F]`; 모든 모드의 최소값으로 유지하는 정책은 `[I]` |

Numeric은 키 높이를 해당 모드 토큰으로 유지하고 열 너비를 동일하게 배분한다. `minWidth=2×padding+3×keyMinWidth+2×columnGap`; 원하는 폭이 없으면 이 최소폭을 사용하고, 더 넓은 유효 폭을 받으면 `keyWidth=(width−2×padding−2×columnGap)/3`으로 확장한다. 독립 숫자판의 높이는 `2×padding+4×keyHeight+3×rowGap`이다. `connect-s` 기본값은 **744×648u**이며 키는200×108u이다. 폭808u를 지정하면 키 폭은221⅓u로 늘어난다. 이808은 웹 키보드 예시 폭을 설명하는 값이며 System Popup의 크기 토큰을 대체하지 않는다. Number Field를 같이 제공할 때는 그 높이와 `fieldToKeysGap`을 추가하고, 외부 Popup이 padding을 이미 제공하면 내측 숫자판의 padding을0으로 명시하여 중복을 피한다. `[M/I]`

QWERTY는 숫자행, 문자3행, 기능행의 총5행이다. 기본 콘텐츠 폭은 각 행이 요구하는 최소폭의 최댓값으로 구한다. `connect-s`에서는 숫자행이 `10×100+120+10×10=1220u`, 외곽 폭이 `1220+2×24=1268u`다. 행 높이는80u, 키행 블록 높이는 `5×80+4×10=440u`; 핸들 포함 외곽 높이는 `56+440+24=520u`다. 기본 행 배치는 다음과 같다. `[M/I]`

| 행 | 콘텐츠 안의 정렬 | connect-s 기준 폭 / 시작 x(외곽 기준) |
|---|---|---|
| 숫자10개 + Delete | 가운데 | 1220u / 24u |
| 문자10개 | 가운데 | 1090u / 89u |
| 문자9개 | 가운데 | 980u / 144u |
| Shift + 문자·구두점9개 | 왼쪽 정렬 | 1155u / 24u |
| Language·Symbols·Space·Mic·Hyphen·Enter | 전체 콘텐츠 폭 | 1220u / 24u |

기능행은 `spaceWidth=contentWidth−(4×specialWidth+enterWidth)−5×columnGap`으로 계산한다. 기준값에서 Space는 **490u**가 되어 웹 예시를 재현한다. 다른 모드에서도 동일 식을 쓰며 `spaceMinWidth` 미만이 되지 않도록 전체 최소폭을 먼저 계산한다. 상단 핸들은 외곽의 수평 중앙에 둔다. 배경은 Normal=`keyboard/normal/background`, Static=`keyboard/static/background`이다. `[F/M/I]`

이 레이아웃의 기본 metric은 공개 설정값으로 제공하고, 부모가 더 넓은 폭을 명시하면 숫자·문자 행은 중앙 정렬, Shift 행은 시작 정렬, 기능행 Space만 잔여 폭 확장을 적용한다. 좁은 viewport에서는 기본 키를 비율 축소해 글자·터치 크기를 깨뜨리지 않고 내재 최소폭을 유지한 가로 스크롤 viewport를 사용하며, 초점 키를 자동으로 보이게 한다. Host는 별도 compact layout이나 시스템 IME adapter로 대체할 수 있다. 이러한 폭 부족 처리와 핸들 생략 옵션은 공식 그림에 없는 구현 정책 `[I]`이다.

API는 `KeyEvent`에 Character, DeleteBackward, ClearAll, ShiftChanged, LanguageRequested, SymbolsRequested, Space, Submit, VoiceRequested를 구분한다. `text` 문자열을 UI가 몰래 수정하지 않는다. 편의 input reducer를 별도로 제공하고 문자열 삭제는 Unicode code point/grapheme 경계를 고려한다. 한글 조합과 Android IME는 교체 가능한 `TextInputAdapter` 계약으로 둔다. 한글 키를 단순 연결한 문자열을 완성된 한국어 IME라고 주장하지 않는다. Voice 모드는 시작/수신중/오류/완료를 외부 상태로 표시하는 슬롯과 action을 제공하며 실제 음성 인식 서비스를 라이브러리 안에서 임의로 호출하지 않는다. `[I]`

## 7. Bar

웹은 window 크기 조정용 Window bar와 content 탐색용 Scroll bar를 구분한다. 공통 축은 theme Light/Dark, Dragging, Pressed, Disabled다. Disabled이면 handle을 숨기고 drag 요청을 발행하지 않는다. Window bar는 Root/Control/Handle, Scroll bar는 content scroll axis와 Handle을 갖는다. `[W-A06]`

### Window bar

| 항목 | 최종 적용값: 최신 웹 우선 | 첨부 대표 노드값: 충돌분은 이력 |
|---|---|---|
| Enabled handle opacity | .2 | .2 |
| Pressed handle opacity | .5 | .5 |
| Disabled handle opacity | 0 | 0 |
| Enabled→Pressed 길이 | 140→100 (웹 주석은 width라 표기) | 160→80 |
| 두께 | 웹 숫자 미명시, 첨부 보완 4 | 4 |
| 원본 Control | 웹 숫자 미명시, 첨부 보완 20×200 | 20×200 |
| 전환 | 300ms, cubic-bezier(.16,1,.3,1) | 별도 모션 값 미제공; 웹값 보완 |

웹 도표의 긴 세로축이 짧아지는 모습에 따라 `handleLength`로 모델링한다. 웹의 width 표기를 Android width 축으로 그대로 옮겨 가로 두께를 140에서100으로 만들지 않는다. `[W/I]`

첨부 display guide의 `2003:15501` 세트가 위 Figma 대표다. `2203:12683` 세트는 Enabled opacity .4로 다른 참조본이 같이 들어 있다. 차이는 SPEC_DECISIONS의 원본혼재 이력에 남긴다. **최종 enabled opacity는 웹의 .2, pressed는 .5, 길이는140→100**이다. 양 theme의 handle color는 최신 모드별 alpha token을 사용한다. `[F/W]`

실제 차량의 전역 window resize를 일반 앱에서 직접 수행한다고 가정하지 않는다. `onDragStart/onDragDelta/onDragEnd/onDragCancel`과 `enabled`를 제공하고 host window-management adapter가 크기 변경을 담당한다. 라이브러리 sample에서는 앱 내부 분할 패널로 동작을 입증한다. 드래그 취소·포커스 상실 시 Pressed/Dragging을 정리한다. `[I]`

### Scroll bar

**최종 색상은 웹의 Enabled=`gray-alpha-200`, Pressed=`gray-900`**를 사용한다. 첨부 `ivi_scroll_bar`의 기본 handle **6×150**, minLength **48**, radius999는 웹 공백을 보완한다. 첨부 Pressed=`alpha/dark/500`은 최신 웹과 다른 과거값이므로 적용하지 않는다. `Controllable=Yes` 예시 Root는 **96×407**이고 기본 noncontrollable variant와 구분된다. `[W/F]`

thumb 길이는 콘텐츠와 viewport 비율에 맞춰 결정하고 150은 샘플 길이로 취급한다. `contentExtent<=viewportExtent`이면 스크롤 범위를 0으로 처리하며 불필요한 drag를 제공하지 않는다. `(offset/maxOffset)`로 위치를 결정하고 길이·좌표를 유효 범위로 clamp한다. read-only indicator와 직접 조절 가능한 scrollbar를 공개 API에서 구별한다. 자식 목록 스크롤과 thumb drag가 동시에 같은 delta를 두 번 소비하지 않도록 한다. `[I]`

### App control bar — 첨부 확장

웹의 Bar 목차는 Window/Scroll 두 종류지만 첨부의 `ivi_app_bar`(`67:27410`)에는 Enabled/Disabled/Pressed 세 가지 추가 원형이 있다. `PleosAppControlBar`로 이 변형도 제공하되 웹의 독립적인 세 번째 종류라고 설명하지 않는다. Root는 **320×60u**, 가운데의 가로 handle은 **140×8u**, 둥근 pill 형태다. Enabled handle은 `alpha/dark/200`, Pressed는 `alpha/dark/500`, Disabled는 handle opacity0이다. Pressed라도 handle 폭140은 유지된다. Window bar의 길이 변화 규칙을 이 bar에 자동 적용하지 않는다. `[F]`

용도별 시스템 action은 첨부가 규정하지 않으므로 tap/drag callback을 제공하는 순수 UI로 구현하고 실제 app/window 조작은 host가 연결한다. 연결되지 않은 action은 활성화하지 않으며 드래그 취소·접근성 대체 action 정책은 Window control과 공유한다. `[I]`

## 8. Controllers 공통 수치 계약

웹 공통 입력은 MinValue, MaxValue, Step과 Pressed/Dragging이다. 범위 내 값 변경은 slider drag 또는 양쪽 버튼으로 제공한다. 끝값에서 Disabled라는 설명은 방향별 조작 차단으로 구현해 반대 방향으로 돌아갈 수 있게 한다. 전체 비활성화는 별도 enabled로 제공한다. `[W-A07/I]`

`min<=max`, `step>0`, finite 값만 허용한다. 기본 API는 Float 또는 Double 중 하나를 일관되게 택하며 Stepper의 정확한 소수 처리가 필요한 경우 정수 step index를 내부 기준으로 사용한다. `q=round((requested-min)/step)`, `value=clamp(min+q*step,min,max)`로 정규화하되 max가 step 격자에 맞지 않을 때 endpoint 도달 정책을 명시한다. `min==max`는 유효한 고정값으로 취급하고 모든 변경을 차단한다. `[I]`

`onValueChange`는 조작 중 값을 요청하며 `onValueChangeFinished`는 drag/연속키 입력 종료 시 한 번 발행한다. pointer cancel을 정상 commit으로 오인하지 않는다. `decrementEnabled=enabled && value>min`, `incrementEnabled=enabled && value<max`를 독립 계산한다. slider에는 범위 semantics, 현재값·단위 설명, 접근성 증감 action을 제공한다. `[I]`

### 8.1 Continuous Slider

웹 구조는 Root, Control, 가변폭 Handle, Track, 선택적 prefix/suffix icon, 양쪽 stepper button이다. Basic/Floating을 제공하고 Label/아이콘 표시 여부를 선택할 수 있다. 막대 전체의 touch/drag와 좌우 버튼이 조절 영역이다. Volume 구간은 **Min=0%, Low=1–25%, Mid=26–75%, High=76–100%, Max=100%**이므로 정확한 100%는 Max 표현을 우선한다. `[W-A07]`

| Root 변형 | 기준 Root | radius | 좌/우 padding | 상/하 padding | gap | 자식 버튼 | 배치된 track |
|---|---:|---:|---:|---:|---:|---:|---:|
| Large Basic/Floating | 808×100 | 32 | 20 | 10 | 16 | 80×80 | 576×80 |
| Medium Basic/Floating | 560×80 | 24 | 10 | 8 | 12 | 64×64 | 388×64 |

Root의 Basic surface=`dim/dark/primary`; Floating=`background/popup`, `divider/secondary` border와 공통 floating shadow. Large optional Label은 32/40 Bold, Medium은 30/38 Bold이다. label의 원본 폭180은 샘플 제약이며 label을 켰을 때 남는 Track 가용 폭을 다시 측정한다. `[F/I]`

내부 track master의 `Size=Medium`은 **580×80, radius24**, `Size=Small`은 **320×72, radius20**이다. 이는 Root의 Large/Medium 이름과 일치하지 않으므로 같은 enum으로 묶지 않는다. 실제 Root 안의 instance가 위 표처럼 가용폭/높이로 조정된다. padding4, handle height=trackHeight−8, handle radius20/16; normal=`controller/slider/normal`, pressed=`controller/slider/pressed`, fill=`controller/slider/knop`(원본 철자 보존). 아이콘은 master Medium48, Small40이다. `[F]`

Figma master의 예시 fill 폭은 Medium Max572/High516/Mid290/Low90, Small Max312/High276/Mid160/Low70이고 Min은 fill이 없다. 이 값들은 상태 예시이며 실제 수치 변화에는 normalized fraction으로 연속 계산한다. 내부 track는 2 size × 2 state × 5 level =20 variants; stepper arrow는 2 size × 3 state × 2 direction =12 variants다. `[F/I]`

Volume이 아닌 temperature 등에도 재사용할 수 있게 fraction을 사용한다. slider 값이1일 때 min구간으로 잘못 분류하지 않고 25/26/75/76/100 경계를 검증한다. fraction이0/1일 때 반대 방향 button은 계속 작동해야 한다. `[I]`

### 8.2 Centered Slider

web은 좌우 버튼이 있는 형태와 버튼 없이 넓은 좌우 margin을 둔 형태를 제시하며 knob/track 모두 touch·drag가 가능하다. Track의 Min/Mid/Max 위치, Enabled/Pressed knob를 구현한다. `[W-A07]`

| Figma 변형 | Root | Padding 가로/세로 | gap | 구성 |
|---|---:|---:|---:|---|
| Button | 532×100 | 10/10 | 16 | 80 버튼 + 320 track + 80 버튼 |
| Basic | 400×100 | 40/12 | 16 | 320 track |
| Number | 529×100 | 40/12 | 16 | 113 값 영역 + 320 track |

각 Type에 `OFF=false/true` 2개 상태가 있어 **6 variants**다. 공통 radius32, border3 `climate/button_border_enabled`, background=`climate/slider_background`. Track는 **320×8**, pill radius999, 양끝 blue→red gradient(`#0064FF`→`#F62E24`, opacity .9)의 원본값이 있다. OFF track는 `basic/200` 단색. color 의미는 gradient 토큰으로 바인딩한다. `[F]`

Knob는 Enabled **48×48**, Pressed **56×56**, fill=`basic/700`, 6u stroke=`climate/slider_background`다. Number 예시 `20.0`은 정수 영역과 소수 영역을 구분하는 113×76 container이며 최종값의 문자열·단위는 formatter에 위임한다. `OFF`는 기능의 꺼짐 표현이고 공통 `enabled=false`와 개념을 분리한다. OFF 상태에서도 다시 켜는 제어 정책은 caller가 결정한다. `[F/I]`

centered란 무조건 값0으로 고정하는 의미가 아니다. `centerValue`를 입력값으로 받고 지정되지 않으면 범위 중간값을 사용한다. min/max/center와 정수·소수 step 변경, drag 취소, button 없는 형태의 큰 margin을 검증한다. `[I]`

### 8.3 Stepper

current value 사이에 감소/증가 버튼을 배치한다. Min에서는 감소만, Max에서는 증가만 비활성이다. 웹 예시의 30A/48A/56A는 특정 값 예시로 라이브러리 고정값이 아니다. anatomy 그림의 `i++`/`i--` 화살표가 실제 −/+와 뒤바뀌어 있으므로 **−는 감소, +는 증가**로 구현한다. `[W-A07/I]`

| 메트릭 | 최종 적용값: 최신 웹 도표 | 첨부값: 충돌분은 이력 |
|---|---:|---:|
| Root | 400×100 | 420×100 |
| 중앙 값 영역 | 112(도표 표시) | 실제 Label 148×44 |
| radius | 첨부 보완24 | 24 |
| padding 가로/세로 | 충돌 없는 항목은 첨부 보완, 가로 가용폭 재배치 | 24/18 |
| 좌/우 action 영역 | SVG 측정 약112×100 | 내부 icon button 64×64, 외곽 padding 포함 |
| 중앙값과 action 사이 공간 | SVG 측정 약32씩 | 자식 간 gap24 |

첨부 Root `67:25189`의 `controller/stepper_background`, border2 `divider/secondary`, shadow `(0,6,24,0,black .08)`, divider2·길이64·색=`divider/tertiary`, Value36/44 Bold를 웹에서 미명시한 세부값의 보완으로 사용한다. **최종 폭은400, 중앙 Label 폭112**이며 첨부420/148은 적용하지 않는다. 최종 기준 배치는 `왼쪽 action112 + 간격32 + Label112 + 간격32 + 오른쪽 action112 = 400`으로 SVG의 강조된 입력 영역을 재현한다. 위 action112·간격32는 도표 좌표 측정값이며 400/100/112는 도표의 숫자 라벨이다. `[F/M/I]`

필수 API: `value`, `range`, `step`, `onValueChange`, `valueFormatter`, `enabled`, `modifier`. 길게 누르기 자동 반복은 공식 규정이 없으므로 선택 기능으로 분리한다. 시범 앱에서 활성화하면 반복 delay·rate를 `RepeatPolicy`로 주입하고 pointer-up/cancel/focus-loss 즉시 중지한다. `[I]`

## 9. Indicator

Indicator는 현재 page/value인 Present와 다음·이전 선택 가능 위치를 점으로 보여준다. size Wide/Narrow, present boolean을 지원한다. 웹 anatomy의 Root 설명에 `App bar`라고 적혀 있으나 Indicator 컨테이너를 뜻하는 문구 오류다. `[W-A08]`

첨부에는 같은 이름의 source symbol이 확인되지 않았다. 웹 SVG 자체를 측정해 얻은 수치는 다음과 같다. 이는 문서에 숫자로 명시된 규격과 구분하여 `[M]`으로 기록한다.

| 메트릭 | Wide | Narrow |
|---|---:|---:|
| dot diameter | 8 | 8 |
| center-to-center | 24 | 16 |
| dot 사이 빈 gap | 16 | 8 |
| 5-dot 예시 전체 폭 | 104 | 72 |
| Present alpha | 1 | 1 |
| 나머지 alpha | .32 | .32 |

Light example은 `#131417`, 어두운/보라 배경 anatomy는 흰색이다. public token은 현재 theme의 text/icon 기본색과 비활성 알파를 사용한다. count5는 예시이며 API에 `pageCount`, `currentPage`, `size`, `onPageSelected?`를 제공한다. 기본은 정보 표시형이므로 작은 점을 자동으로 클릭 가능한 버튼으로 만들지 않는다. 클릭을 켜는 경우 충분한 hit target을 별도로 제공한다. `[W/M/I]`

`pageCount=0`이면 빈 영역, 1이면 정책에 따라 숨김 또는 한 점을 명시적으로 선택; 기본값은 한 점 표시다. currentPage는 유효 범위로 clamp하거나 개발 모드의 명확한 오류로 처리하는 정책을 전체 라이브러리에서 통일한다. semantics는 “총 N페이지 중 k페이지”. 점 이동 animation duration·overflow windowing은 공식 미정의로 token/policy를 분리한다. `[I]`

## 10. Dropdown

### 공식 의미·구조

메뉴 이동 또는 속성 변경을 위한 요소다. Root, Label, Prefix, Suffix, Container를 갖는다. Opened/Pressed/Disabled 상태와 Medium/Small 크기를 제공한다. Prefix는 App Icon 또는 Icon, Suffix는 Switch 또는 Icon을 지원한다. 메뉴가 단일 선택기인 경우뿐 아니라 일반 action과 설정 switch 목록인 경우도 구현한다. `[W-A09]`

### 형태·치수

| 항목 | Medium | Small |
|---|---:|---:|
| Trigger 기준 폭×높이 | 600×100 | 600×80 |
| Trigger radius | 32 | 28 |
| Trigger 좌/우 padding | 20 | 16 |
| Trigger Label wrapper 좌/우 padding | 16 | 12 |
| Trigger와 Menu gap | 8 | 8 |
| Menu 기준 폭 | 600 | 600 |
| Menu padding | 16 전방향 | 16 전방향 |
| Menu item gap | 16 | 16 |
| Menu radius | 32 | 28 |
| 3개 item 예시 menu 높이 | 364 | 304 |
| 일반 Item 기준 폭×높이 | 568×100 | 568×80 |
| Item 좌/우 padding | 20 | 16 |
| Item Label wrapper 좌/우 padding | 12 | 12 |
| Label 크기/행높이 | 30/38 Bold | 30/38 Bold |
| AppIcon 및 Prefix container | 56×56 | 56×56 |
| Prefix 실제 icon | 40×40 | 40×40 |
| Suffix/check icon | 48×48 | 48×48 |
| Switch | 64×40 | 64×40 |
| New indicator | 16×16 | 16×16 |

600/568은 첨부 예시 폭이며 responsive width 정책을 제공한다. Menu의 높이는 `paddingTop+paddingBottom+보이는 item높이 합+보이는 item간 gap`으로 계산한다. master 안에는6개 item 슬롯이 있으나 기본으로3개만 보이고 나머지는 hidden이다. 아이템 개수6으로 고정하지 않는다. `[F/I]`

### 상태·내용

Trigger Enabled=`dropdown/normal`, Pressed=`dropdown/pressed`; Disabled는 동일 surface에 내용 비활성 token. border2=`divider/secondary`; shadow는 `(0,6,24,0,black .08)`이다. Menu surface=`surface/basic`, 동일 border/shadow. Item Selected=`dim/dark/primary`와 trailing check; Enabled/Disabled는 투명 배경. Label Enabled/Selected=`text/dark/primary`, Disabled=`text/dark/quaternary`. New dot=`informative/active`. `[F]`

`dropdown_item`은 2 size × Selected/Enabled/Disabled/Footer = **8 variants**다. Footer는 선택 상태가 아니라 별도 row kind로 모델링한다. Medium Footer 높이97=divider1+gap16+body80, Small81=1+16+64. Footer leading circle은80/64, 실제 plus icon40/32, circle 뒤 gap20, Label30/38 Bold. Divider는 `divider/tertiary`. 원본의 `State=Footer` 이름 때문에 selected/disabled 상태 enum에 Footer를 넣지 않는다. `[F/I]`

`DropdownItem` 데이터는 stable id, text, enabled, selected, prefix type, suffix type, action 또는 checked callback을 구분한다. row action과 안쪽 Switch가 같은 클릭을 두 번 처리하지 않도록 event ownership을 정한다. 기본 policy는 일반 선택 row를 누르면 selected event 후 dismiss, switch row는 checked event만 발행하고 menu 유지; 이는 `[I]`로 외부 policy override를 허용한다.

popup은 trigger 기준으로 정렬하고 viewport·safe area·IME inset을 고려해 아래 공간이 부족하면 위로 연다. 긴 목록은 최대 높이 안에서 스크롤한다. Back/Escape/outside-dismiss 후 trigger로 focus를 복원하며 열린 menu 안에서 rotary/D-pad 이동을 지원한다. Disabled 상태에서 외부 expanded가 true로 들어오면 상위 state를 몰래 변경하지 말고 표시·dismiss policy를 적용한다. Modal 시스템 권한에 기대지 않고 앱 window 내부 popup으로 구현한다. `[I]`

필수 API: `expanded`, `onExpandedChange`, `selectedId`, `items`, `size`, `enabled`, `onItemSelected`, `onDismissRequest`, prefix/suffix slot, anchor modifier. Preview만 정적으로 그린 menu는 완료로 인정하지 않는다.

## 11. 이 파일에 대한 완료 기준

1. 표에 있는 component/kind/size/state를 모두 public API와 카탈로그에 연결한다. 원본 이름의 오탈자를 공개 API로 퍼뜨리지 않는다.
2. Light/Dark 및 첨부 design-assets의4개 토큰 모드(`connect-s`, `connect-l`, `connect-w`, `connect-waterfall`)에서 최신 웹 우선의 단일 규격이 동작한다. 이4개는 전체 차량 폼팩터 목록이 아니며 차량별 매핑은01을 따른다. 상충하는 Figma 구버전으로 되돌리는 실행 옵션을 만들지 않는다. 원본 디자인 예시의 폭과 minWidth를 구분한다.
3. 필수 회귀 검증: button loading 재입력 차단, toggle 상태 한 번 변경, pressed 취소 정리, Numeric clear/delete, QWERTY shift/mode 전환, Voice adapter 이벤트, scrollbar 분모0, slider 경계/범위/step, Stepper 단방향 Disabled, Indicator 0/1/N, Dropdown focus 복원·목록 스크롤·Switch event 한 번.
4. 측정/스크린샷 비교는 각 대표 size·state에서 padding/radius/letter metrics/alpha/shadow를 검증한다. 충돌 항목에는 최신 웹값이 적용되는지 검증한다. 숨겨진 Figma child가 간격을 차지하지 않는지도 확인한다.
5. Icon Large, Floating 독립 정책, input composition adapter, 모션 미정의값, window resize integration은 `SPEC_DECISIONS.md`와 샘플 설명에 실제 상태를 명시한다. 미정의 부분을 조용히 생략하거나 공식 규격으로 꾸미지 않는다.

## 12. 추적 가능한 출처

| 코드 | 공식 페이지 | 확인한 그림·세부 정보 |
|---|---|---|
| W-A01 | https://document.pleos.ai/docs/connect/guide/docs-design/components/actions/basic-button | Anatomy, State, Hierarchy, Size |
| W-A02 | https://document.pleos.ai/docs/connect/guide/docs-design/components/actions/toggle-button | Anatomy, State, Floating |
| W-A03 | https://document.pleos.ai/docs/connect/guide/docs-design/components/actions/text-button | Anatomy, State, Size |
| W-A04 | https://document.pleos.ai/docs/connect/guide/docs-design/components/actions/icon-button | Anatomy(인라인 SVG 포함), Basic/Plain/Circle |
| W-A05 | https://document.pleos.ai/docs/connect/guide/docs-design/components/actions/keypad | Anatomy(인라인), State, Numeric, Qwerty, Keyboard |
| W-A06 | https://document.pleos.ai/docs/connect/guide/docs-design/components/bar | Window/Scroll anatomy(인라인), Light/Dark 동작 |
| W-A07 | https://document.pleos.ai/docs/connect/guide/docs-design/components/controllers | 21개 이미지: anatomy, Basic/Floating, volume5단계, label/icon옵션, controls, centered, stepper |
| W-A08 | https://document.pleos.ai/docs/connect/guide/docs-design/components/indicator | Anatomy, Wide/Narrow 인라인 SVG |
| W-A09 | https://document.pleos.ai/docs/connect/guide/docs-design/components/dropdown | Anatomy, Open/Close, State, Size, Properties |

첨부 근거: `Pleos_Connect_design_assets_215(1).fig`의 `❖ Components` 및 내부 참조 symbol, `Pleos_Connect_display_guide_215.fig`의 window-bar 참조 symbol. 정확한 노드ID·모드별 토큰·variant 전체 목록은 동봉 Figma 부록을 사용한다. 이 링크들은 provenance이며 구현 시 웹 검색을 요청하는 지시가 아니다.
