# Fields · Navigation · Popups · Selections · Feedback · Widgets 구현 지시

이 문서는 웹을 열 수 없는 구현 LLM을 위한 규격이다. 링크는 출처 식별자이며 추가 열람 요구가 아니다. 아래에 적힌 변형과 상태를 모두 구현하고, 공식 자료에 없는 보완 동작은 `implementationDecision`으로 기록하라.

## 읽는 규칙

- **[W]**: 2026-10-28에 확인한 공식 웹 본문 또는 도해에서 직접 읽은 규격.
- **[F]**: 사용자가 제공한 `Pleos_Connect_design_assets_215(1).fig`의 실제 노드 속성. 각 노드 ID를 함께 기록한다. `Pleos_Connect_display_guide_215.fig`는 화면 배치 근거이며 아래 개별 컴포넌트 SYMBOL 규격의 출처는 assets 파일이다.
- **[I]**: 실행 가능한 라이브러리를 만들기 위한 이 지시서의 설계 결정. 공식 Pleos 동작으로 소개하지 말라.
- 숫자에 `dp`가 명시되지 않으면 디자인 좌표 `u`다. 공통 단위 변환 규칙으로 Android `Dp`/`Sp`에 옮겨라. SVG의 이미지 전체 크기는 컴포넌트 크기가 아니다.
- `token → 색상 @ paint-opacity` 형식으로 읽어라. 웹 도해의 명시 색상은 아래에 별도로 적었으며 해당 밝은 테마에서 최우선이다. 나머지 색상 표는 첨부의 밝은 테마 보완값이다. 웹이 Dark 값을 제공하지 않은 경우 공통 Figma semantic mode를 [첨부 보완] 출처로 적용하고, 웹의 밝은 색을 임의 반전하거나 모든 테마에 강제하지 말라.
- **사용자 결정: 문서가 상충하면 웹을 최신 버전으로 간주한다.** 2026-10-28 웹 명시값을 단일 구현 기준으로 사용하고, 웹이 지정하지 않은 세부값만 [F]로 보완한다. 아래의 충돌하는 Figma 숫자는 감사·추적용 과거 자료이며 런타임 선택값이 아니다. 첨부 구버전 구현 프로필이나 옛 사양 전환 기능을 만들지 말라. 첨부에만 있는 추가 크기/변형은 [첨부 보완]으로 구현하되, 웹이 이미 지정한 폭·색상 등 해당 축은 웹 값을 승계한다. 이때 만들어지는 조합은 웹 자체에 실린 원형이라고 주장하지 말고, 웹 우선 정책으로 도출한 구현값이라고 표시한다.
- 숨겨진 Figma 레이어의 크기, 프레젠테이션용 상위 FRAME, 예시 텍스트 폭을 필수 런타임 크기로 오인하지 말라. 노드 이름의 `Focused`가 선택 상태를 뜻하는 경우와 Android 입력 포커스를 구별하라.

## 1. Text Field

### 1.1 공식 의미와 변형 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/fields/text-field>

텍스트 입력 컨테이너, 입력 영역, 커서, placeholder, 선택적 suffix로 구성한다. suffix에는 텍스트 또는 아이콘을 넣는다. 입력 종류는 `Text`, `Tel`, `Url`, `Email`, `Password`; 크기는 `Medium`, `Small`이다. 웹의 `Samll`은 `Small`로 정규화한다.

상태는 `Value: String`, `Focused`, `Disabled`, `ReadOnly`, `Invalid`다. Disabled는 조작·수정·입력 포커스를 차단하고 ReadOnly는 값에 접근할 수 있으나 수정할 수 없다. 도해는 `Enabled`, `Focused`, `Typing`, `Entered`, `Error`, `Read only`를 보여준다. 긴 문자열 편집 시 커서를 보이도록 수평 스크롤하고, 커서가 앞쪽으로 이동하면 반대 방향으로 스크롤한다. 입력 종료 시 보이는 폭을 넘는 문자열은 말줄임 표시한다. Error는 붉은 테두리와 보조 설명을 표시한다.

### 1.2 Figma 치수와 색 [F]

노드 집합 `ivi_text_field`(67:27050), 상태 SYMBOL 67:27051–27134. 크기 2종 × 시각 상태 6종 = 12개 원본 조합을 재현하라.

| 항목 | Small | Medium |
| --- | ---: | ---: |
| 입력 상자 높이 | 80 | 100 |
| 코너 반경 | 24 | 24 |
| 좌우 내부 여백 | 24 | 32 |
| 텍스트와 suffix 간격 | 12 | 16 |
| 입력 글자 크기 / 줄높이 | 30 / 38, Regular | 36 / 44, Regular |
| clear / password 아이콘 영역 | 40 × 40 | 48 × 48 |
| 입력 상자와 Help Text 간격 | 12 | 16 |
| Help Text 좌우 여백 | 16 | 16 |
| Help Text 글자 / 줄높이 | 26 / 34, Regular | 26 / 34, Regular |
| 한 줄 Error 전체 예시 높이 | 126 = 80 + 12 + 34 | 150 = 100 + 16 + 34 |
| 편집 커서 | 3 × 32 | 3 × 32 |

원본 예시 폭은 700이다. 폭을 상수 700으로만 고정하지 말고 주어진 너비에 맞춰 입력 영역이 늘어나게 하라. suffix가 없으면 해당 간격도 제거한다. Error/Help Text가 여러 줄이면 전체 높이가 자연스럽게 늘어나야 한다.

| 시각 상태 | 배경 | 테두리 | 텍스트·부가 요소 |
| --- | --- | --- | --- |
| Enabled, 비어 있음 | `field/background` = #FFFFFF | `divider/secondary` = #131417 @ 0.10, 두께 2 inside | placeholder `text/dark/tertiary` = #131417 @ 0.64 |
| Focused, 비어 있음 | 동일 | `field/focused` = #313236, 두께 3 inside | placeholder + 커서 |
| Typing | 동일 | 동일 focused 테두리 3 | 입력값 `text/dark/primary` = #131417, 커서, clear 아이콘 |
| Entered | 동일 | 기본 테두리 2 | 입력값 primary, 커서 없음 |
| ReadOnly | `surface/high` = #EDEEF2 | 기본 테두리 2 | 입력값 primary, 수정 불가 |
| Error | field/background | `regulation/red` = #F62E24, 두께 3 | 값 primary, 오류 설명 regulation/red |

일반 Help Text는 `text/dark/secondary`(#131417 @ 0.84)다. **웹 색상 차이 [W]:** text_status/text_anatomy SVG의 placeholder는 #1B1C1E @ 0.64다. 최종 구현에는 웹 #1B1C1E @ 0.64를 사용한다. 위 표의 #131417 @ 0.64는 첨부 원본 추적값이다. 폰트는 Asta Sans. clear와 eye 레이어는 선택적이며, 존재하지만 숨김 상태인 레이어를 항상 그리지 말라.

### 1.3 구현 계약 [I]

`PleosTextField(value, onValueChange, type, size, enabled, readOnly, invalid, placeholder, supportingText, suffix, passwordVisible, onPasswordVisibilityChange, modifier)`를 제공하라. 선택·커서·IME composition을 보존할 수 있는 `TextFieldValue` 또는 동등한 편집 상태 API를 함께 제공하라. 내부 `remember` 값으로 외부 `value`를 가리지 말라.

- Typing/Entered는 편집 포커스와 빈 값 여부에서 파생하고 `invalid`는 독립 축으로 유지한다. 오류 상태에서 포커스를 받아도 붉은 오류 테두리를 유지한다.
- `Text/Tel/Url/Email/Password`를 적절한 입력·IME 옵션으로 연결한다. 키보드 종류만으로 값을 유효하다고 가정하지 말라. validator는 호출자가 공급한다.
- clear는 현재 값을 빈 문자열로 전달한다. password visibility는 표시만 바꾸며 값·커서·selection을 변경하지 않는다.
- Password 원문을 접근성 설명, 로그, snapshot 파일명 또는 saved UI diagnostic에 노출하지 말라.
- 수정 중에는 실제 텍스트를 말줄임으로 교체하지 말고 스크롤 가능한 편집기를 사용한다. 비편집 표시는 말줄임하되 원문은 보존한다.
- ReadOnly는 접근성·선택/복사 접근을 유지하고 소프트 키보드·clear·수정은 차단한다.
- Disabled라도 화면읽기에는 label·값·disabled 의미론을 제공한다. 조작 차단을 접근성 트리 제거로 구현하지 말라.
- Disabled의 시각 variant는 원본에 없다. 보완 기본값은 ReadOnly 배경, 기본 테두리, quaternary 텍스트이며 `enabled=false`의 의미론을 적용한다. 이것은 [I]로 표시하고 테마에서 교체 가능하게 하라.

검증: 5종 입력, 2크기, 6원본 시각 상태, Disabled, 한글 조합 중 recomposition, 붙여넣기, cursor 이동, 긴 문자열, clear, password 토글, ReadOnly와 Disabled의 차이를 검증하라.

## 2. Number Field

### 2.1 공식 의미와 변형 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/fields/number-field>

숫자를 자리별 상자에 입력하는 필드다. 컨테이너·숫자 label·커서·입력 영역으로 구성되며 `Large`, `Medium` 크기가 있다. 값은 문자열이고 `Focused`, `Disabled`, `ReadOnly`, `Invalid`를 구분한다. 도해에 `Enabled`, `Focused`, `Entered`, `Error`가 있으며 focus는 강조 테두리·배경·커서, error는 붉은 테두리다. 예시의 4칸을 모든 사용처에 강제하지 말라.

### 2.2 Figma 수치 [F]

`ivi_number_field`(67:27184), 67:27185–27199: 크기 2 × 상태 4 = 8개 원본 조합.

| 항목 | Medium | Large |
| --- | ---: | ---: |
| 한 자리 상자 W × H | 128 × 128 | 140 × 180 |
| 코너 반경 | 32 | 32 |
| inside 테두리 | 4 | 4 |
| 숫자 글자 / 줄높이 | 60 / 80, ExtraBold | 60 / 80, ExtraBold |
| 커서 W × H | 4 × 48 | 4 × 48 |

일반·입력완료 테두리는 `divider/secondary`(#131417 @ 0.10), focus 테두리는 `field/focused`(#313236), focus 내부는 `dim/dark/secondary`(#131417 @ 0.10), error 테두리는 `regulation/red`(#F62E24), 숫자는 primary다. 숫자는 양축 가운데 정렬한다. 기본/완료/오류에는 focus 배경을 적용하지 않는다. 웹 anatomy의 Medium 상자 사이 간격은 24로 관찰되므로 기본 slot gap은 24를 사용한다. Figma는 자리별 SYMBOL이고 그룹 gap을 지정하지 않는다. Large에서도 gap24를 쓰는 것은 [I] 보완으로 표시한다.

### 2.3 구현 계약 [I]

`PleosNumberField(value: String, onValueChange, digitCount, size, enabled, readOnly, invalid, obscured, onComplete, modifier)`를 제공하라. 여기서 `obscured`와 completion 콜백은 라이브러리 보완 기능이다.

- PIN/OTP와 선행 0을 보존하므로 `Int`로 변환하여 보관하지 말라. 허용 숫자·locale 정규화 정책을 명시한다. 기본은 ASCII 0–9이며 paste도 같은 정책을 따른다.
- 단일 논리 편집기와 자리별 시각 표현을 권장한다. 여러 실제 입력기로 구현한다면 focus 이동·backspace·paste가 같은 계약을 만족해야 한다.
- 입력 시 다음 빈 자리, 삭제 시 이전 자리로 이동하고 전체 문자열 붙여넣기·선택 교체를 지원한다. 자리 수 초과 입력은 잘라내는 정책을 문서화한다.
- completion은 같은 값에 recomposition될 때 반복 호출하지 않는다. 값 변경 후 완성되는 전이에만 한 번 발생시킨다.
- 모든 칸을 독립 접근성 텍스트 필드로 중복 읽지 말고 하나의 논리 입력으로 노출한다. 필요한 경우 현재 자리 이동 action을 추가한다.
- Disabled/ReadOnly 시각은 원본 미정의다. Text Field의 [I] 보완 원칙을 쓰되 외형 치수는 유지한다.

## 3. Page Navigation

### 3.1 공식 구조 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/page-navigation>

주요 서비스 경로를 제공하는 상단 영역이다. `Main`은 앱 아이콘과 primary 메뉴, 선택적 secondary 메뉴, suffix action으로 구성한다. primary/secondary는 dropdown으로 열 수 있다. `Depth`에서는 뒤로가기와 페이지 제목을 표시한다. Main과 Depth 모두 subtitle을 지원한다. Main 도해에는 primary만, secondary 추가, subtitle 추가가 있고 Depth에는 기본·subtitle 형태가 있다. primary와 secondary 사이에는 세로 구분선을 둔다.

웹 Properties 표의 Primary 설명에 Depth 문장, Secondary 설명에 Pressed 문장이 섞여 있다. 이를 불리언 메뉴 선택 동작으로 해석하지 말고 anatomy·도해의 의미를 우선하라.

### 3.2 Figma 구성 [F]

`ivi_title`(67:27622): Main 67:27623, Depth 67:27641. 기본 title row 예시 988 × 80.

| 요소 | 값 |
| --- | --- |
| title row 시작/끝 여백 | 40 / 24 |
| title group와 suffix 간격 | 24 |
| 앱 아이콘 | 80 × 80, 반경 20 |
| Main menu_group 내부 간격 | 16 |
| primary/secondary 버튼 | 좌우16, 상하8, 반경16 |
| 제목 글자 / 줄높이 | Asta Sans Bold 40 / 52 |
| dropdown 화살표 | 28 × 28, label과 간격8 |
| primary subtitle | Regular 24 / 28, tertiary, 제목과 간격4 |
| primary·secondary 구분선 | 2 × 32, divider/tertiary(#131417 @ 0.20) |
| Depth back 아이콘 | 56 × 56, 다음 title group과 간격24 |
| Depth subtitle | Regular 26 / 34, tertiary, 제목과 간격4 |
| suffix action | 예시 80 × 80 아이콘 버튼 최대3개, 서로 간격12 |

**웹 색상 차이 [W]:** nav_main/nav_depth의 subtitle은 #1B1C1E @ 0.64, 첨부는 #131417 @ 0.64다. 최종 subtitle은 웹 #1B1C1E @ 0.64를 사용한다.

숫자 988은 예시 너비이고 suffix 3개가 항상 필수는 아니다. 사용하지 않는 앱 아이콘·subtitle·메뉴·suffix를 숨기면 해당 공간을 회수한다. 제목/메뉴는 빈 공간을 차지하고 suffix는 우측에 유지한다.

`ivi_header`(67:27600)의 첨부 확장 preset도 구현한다.

| preset | 원본 W × H | 구조 |
| --- | --- | --- |
| Radio, Phone | 1355 × 144 | top40 + title80 + bottom24 |
| Radio_Segmented_control, Phone_Segmented_control | 1355 × 232 | top40 + title80 + gap12 + Line Tabs100 |
| Music | 1355 × 144 | 배경 없는 기본 header |
| Music_background | 1355 × 144 | surface/basic 배경 header |

이 preset들은 앱 아이콘/메뉴/배경/탭 조합의 데모로 제공하고 서비스 이름을 고정된 동작으로 연결하지 말라. 하단 divider는 1이며 token은 divider/tertiary다. 숨김 상태의 `ivi_app_bar` 레이어 높이60을 위 header 높이에 무조건 더하지 말라.

### 3.3 구현 계약 [I]

`PleosPageNavigation(type, title, appIcon, primaryMenu, secondaryMenu, subtitle, actions, onBack, tabs, modifier)`를 제공한다. 메뉴 expanded 상태와 선택값은 외부 제어다. Main→Depth 전환은 화면 상태를 반영하고 library가 앱 navigation stack을 임의 생성하지 않는다.

- 메뉴 닫기 시 호출 버튼으로 focus를 복구한다. 뒤로가기는 한 번만 전달한다.
- title row와 header wrapper를 분리해 80 높이 primitive와 144/232 preset을 모두 쓸 수 있게 하라.
- 좁은 폭에서는 먼저 가변 title/subtitle 폭을 줄이고 말줄임한다. 액션 클릭 영역을 축소하여 서로 겹치게 하지 말라.
- subtitle 활성 시 한 줄 제목의 높이를 강제해 자르지 말고 글꼴 크기/접근성 배율에 따라 높이를 확장한다.

## 4. System Popup

### 4.1 공식 구조와 변형 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/popups/system-popup>

팝업은 Root, Title, 선택적 Description, Confirm, 선택적 Cancel로 구성한다. Header에는 icon·subtitle·description을 조합할 수 있고 Body에는 임의 콘텐츠를 넣는다. 크기는 `Large`, `Medium`; 버튼 정렬은 `Single`, `Vertical`, `Horizontal`이다. 도해에서는 가로형 confirm이 왼쪽, cancel이 오른쪽이고 세로형 confirm이 위쪽이다. Body 예시는 일반 콘텐츠와 색상 선택기다. 웹 `pop_size.svg`의 치수 라벨은 Large 1200, Medium 760이다.

### 4.2 Figma 원본 규격과 웹 충돌 [F]

`ivi_system_popup`(67:29509), header(67:29529), buttons(67:29546), content(67:29553).

| 항목 | 최종 Medium | 과거 Figma Medium(추적용) | 최종 Large | 첨부 Extended Medium 원본 | 첨부 Extended Large 원본 |
| --- | ---: | ---: | ---: | ---: | ---: |
| 기본 폭 | 760 [W] | 808 | 1200 | 720 | 1000 |
| 바깥 내부 여백 | 48 [F 보완] | 48 | 48 | 40 | 40 |
| 코너 반경 | 48 [F 보완] | 48 | 48 | 40 | 40 |
| 주 영역 간격 | 40 [F 보완] | 40 | 40 | 33 | 33 |
| 기본 버튼 높이 | 100 [F 보완] | 100 | 100 | 84 | 84 |
| Header 하단 내부 여백 | 16 [F 보완] | 16 | 16 | 12 | 12 |
| Body 없는 예시 전체 높이 | 내용에 따라 측정 | 366 | 366 | 308 | 308 |

원본 ID: Medium 기본67:29510, Large 기본67:29514, Medium Extended67:29518, Large Extended67:29522. `Extended=True`의 이름만 보고 더 넓다는 뜻으로 재해석하지 말라. 실제 원본은 720/1000 폭의 다른 metrics preset이다. **최종 Extended의 폭은 웹의 Medium760/Large1200을 승계하고, 첨부의 여백40·반경40·간격33·버튼84·Header 하단12만 추가 metrics preset으로 보완한다.** 720/1000과 기본 Medium808은 구현 폭이 아니다. Body 표시 여부와 Extended는 독립 축이다. Extended 원본 안의 숨김 body 노드에 옛 폭712/904가 남아 있으므로 실제 runtime body는 현재 popup content width에 맞춰야 한다.

| Header 요소 | Figma 규격 |
| --- | --- |
| 정보/경고 아이콘 | 80 × 80 |
| Title | ExtraBold40 / line52, primary, 가운데 |
| Subtitle | Bold36 / line44, secondary, 가운데 |
| Description | Regular30 / line38, secondary, 가운데 |
| Header 요소 사이 | 24 |
| 선택적 close 아이콘 | 48 × 48 |
| Large header의 title 내부 좌우 여백 | 32; instance override가 있으면 override 우선 |

**웹 색상 차이 [W]:** pop_anatomy/pop_size Description은 #1B1C1E @ 0.84다. 첨부 secondary #131417 @ 0.84는 추적값이며 최종 Description은 웹 값을 사용한다.

Root는 `background/popup`(#FFFFFF), inside border2 `divider/primary`(#131417 @ 0.05)다. 가로 버튼은 두 버튼이 같은 폭, 사이24이며 confirm은 Filled, cancel은 Basic이다. 세로 버튼도 gap24, 각 full content width다. Single은 confirm 하나를 full width로 놓는다. Figma의 buttons 그룹 시연 폭760과 그 부모 popup 폭을 혼동하지 말라. 표준 popup 버튼은 높이100·반경32이고 Extended는 높이84 preset을 사용한다.

Body slot은 1개 합성 슬롯으로 열어 둔다. 첨부의 body 예시는 목록, `spinner_wheels`, `ivi_text_field`이며 임의 Compose 콘텐츠도 지원한다. 목록 내부 예시 배경은 dim/dark/primary, radius32, 좌우20·상하24이고 body item 간격24다. Body 콘텐츠 전체 높이496/520은 예시 값으로 취급한다.

### 4.3 구현 계약 [I]

`PleosSystemPopup(onDismissRequest, size, metricsPreset, title, subtitle, description, icon, body, confirmAction, cancelAction, buttonAlign, dismissPolicy, modifier)`를 구현하라.

- 플랫폼 window hosting과 시각 `PleosPopupSurface`를 분리한다. 앱 dialog로 표시할 수 있어야 하고 시스템 전역 권한을 요구하지 않는다.
- 밖 터치·Back·confirm·cancel·close를 명시적 `DismissReason`으로 구별한다. confirm 클릭이 자동 dismiss인지 결과 완료 후 dismiss인지는 호출자가 정한다.
- 데이터 저장·결제·설정 반영 등 business effect를 UI에서 직접 수행하지 않는다. loading 버튼 상태를 지원해 중복 confirm을 방지한다.
- title/description/body/action 각각 숨김 가능한 조합을 카탈로그에 만든다. popup 전체가 화면을 넘으면 body를 우선 스크롤하고 confirm/cancel을 접근 가능하게 유지한다.
- modal focus 범위를 제한하고 닫힌 후 진입 전 focus로 복귀한다. outside dismiss 또는 back dismiss가 금지되었으면 예외 없이 같은 정책을 적용한다.
- Body 예시의 ambient light 색 선택기는 임의의 차량 제어 API를 호출하지 않는 slot demo로 구현한다.

## 5. Toast Popup

### 5.1 공식 의미 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/popups/toast-popup>

일시적 앱 알림이며 Root와 메시지로 이루어진다. 앱 패널 가장자리와 24dp 간격을 유지한다. 본 페이지의 Toast1/2/3 도해는 아래 독립 `Toast` 페이지와 동일한 asset다. 제목에 Popup이 있다고 modal confirm dialog로 바꾸지 말라. 화면 하단 중앙의 가벼운 알림으로 구현한다.

### 5.2 Figma 규격 [F]

`ivi_toast_popup`(67:32581)의 `Margin(Default)=off`67:32582와 `on`67:32586을 구현한다.

| 항목 | 값 |
| --- | --- |
| Toast container | 반경16. **Light 최종 배경은 웹 #131417@0.84**; Dark는 웹 미정의로 첨부 `basic/600`=#E0E1E6 보완 |
| 내부 여백 | 좌우40, 상하24 |
| 텍스트 | Asta Sans Bold26 / line34, 가운데. Light #FFFFFF; Dark는 첨부 `basic/00`=#131417 보완 |
| 텍스트·선택적 아이콘 간격 | 16 |
| 선택적 app/Bluetooth 아이콘 slot | 48 × 48 |
| 단일 줄·아이콘 없는 예시 | 261 × 82; 폭261은 예시 문자열에 의존 |
| Margin on wrapper | 최종 좌우24dp, 아래24dp, 위0; 바닥·가운데 정렬. 내부40/24u와 단위를 구별 |

아이콘은 Figma의 확장 옵션이며 웹 anatomy의 필수 부분은 아니다. 기본은 text only다. on/off는 알림 표시 여부가 아니라 외부 margin wrapper 유무다. 웹은 Light 도해의 Toast 색만 확인되므로 같은 배경이 Dark에서도 불변이라는 공식 규칙을 만들지 말라. Dark 배경·문자색은 위 첨부 semantic mode로 보완한다.

### 5.3 구현 계약 [I]

공유 `PleosToastSurface`와 `PleosToastHostState`를 사용하고 `PleosToastPopup`은 margin 포함 앱 overlay API로 제공한다. 독립 Toast와 렌더러·큐 구현을 중복하지 말라. 공통 수명·접근성·큐 동작은 아래 Toast 절을 따른다. toast에 focus를 강제 이동시키지 않는다.

## 6. Tabs

### 6.1 공식 구조와 상태 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/segmented-menu>

둘 이상의 콘텐츠/기능 중 하나를 선택하는 컨트롤이다. Root·Tab Item·Label·Selected indicator·Tab Container를 구현한다. 스타일은 `Box`와 `Line`, 상태는 Enabled·Pressed·Selected다. `fitted=true`는 전체 너비를 균등하게 나누며 false는 시작 쪽으로 정렬한다. 일부 아이템에 prefix icon을 둘 수 있다. Box는 선택 셀을 밝은 채움으로, Line은 선택 셀 아래 선으로 표시한다.

### 6.2 Box의 Figma 규격 [F]

`ivi_segmented_control/box`의 SYMBOL 67:32706–32773, `segmented_controls/goast_button`67:32775–32804. 원본 철자 `goast_button`은 provenance에 유지하되 공개 API는 `BoxTabItem`으로 정리한다.

| 항목 | Large | Medium |
| --- | ---: | ---: |
| Root 높이 / radius | 100 / 32 | 80 / 24 |
| Root 내부 여백 | 8 | 8 |
| Item 높이 / radius | 84 / 24 | 64 / 16 |
| Item 좌우/상하 padding | 28 / 16 | 18 / 12 |
| label font / line | Bold32 / 40 | Bold30 / 38 |
| prefix icon | 52 | 40 |
| icon-label 간격 | 14 | 8 |
| divider | 2 × 36 | 2 × 36 |

**웹 색상 차이 [W]:** Segmented2/4/7의 미선택 label은 #1B1C1E @ 0.84다. 첨부 #131417 @ 0.84는 추적값이며 최종 미선택 label은 웹 #1B1C1E @ 0.84를 사용한다.

Root는 `controller/tab_background`(#131417 @ 0.05). 미선택 label은 secondary(@0.84), 선택 label은 primary, disabled label은 quaternary(@0.32)다. 미선택 pressed는 `button/basic/pressed`(@0.10) 채움. 선택 item은 `button/switch/enabled`(#FFFFFF)다. 원본 예시는 첫 item 선택 시 바로 오른쪽 divider를 opacity0으로 만든다. [I] 중간 item에도 같은 표현을 일반화해 선택 item 양옆 divider를 투명하게 한다. divider 기본은 `divider/secondary`(@0.10)다.

Large 선택 셀 그림자: black@0.16, offset(0,8), blur32 + black@0.08, offset(0,2), blur2. Medium: black@0.08, offset(0,6), blur24. Disabled 선택 상태도 선택 채움을 유지하되 label은 quaternary다.

원본 예시 조합 전체:

| 크기 | 2개 | 3개 | 4개 | 5개 | 6개 |
| --- | ---: | ---: | ---: | ---: | ---: |
| Large 예시 폭 | 880 | 880 | 1176 | 1176 | 1176 |
| Medium 예시 폭 | 780 | 780 | 960 | 1176 | 원본 없음 |

폭은 예시이며 API는 parent constraints를 사용한다. 각 크기에서 `(Enabled, unselected)`, `(Pressed, unselected)`, `(Disabled, unselected)`, `(Enabled, selected)`, `(Disabled, selected)` 5개의 원본 item state를 카탈로그에 포함한다. Figma의 `Focused=true`는 이 Box 컨텍스트에서 선택 표현에 사용된다. Android input focus와 동일한 하나의 bool로 만들지 말라.

### 6.3 Line의 Figma 규격 [F]

컨테이너 `Bottom line=True`67:32808, `False`67:32814. 아이템 상태67:32821–32852: Enabled·Pressed·Selected·Disabled × `Margin=Medium` / `Large(Page Nav Only)`.

| 항목 | 일반 Medium margin | Page Navigation Large margin |
| --- | ---: | ---: |
| 전체 item 높이 | 100 | 128 |
| item 상하 바깥 여백 | 12 | 26 |
| 실제 내부 Button 높이 | 76 | 76 |
| Button 좌우/상하 padding | 14 / 18 | 14 / 18 |
| Button radius | 12 | 12 |
| 글자 / 줄높이 | Bold32 / 40 | Bold32 / 40 |
| 선택 밑줄 | 4 | 4 |
| 선택적 icon / 간격 | 40 / 8 | 40 / 8 |

컨테이너 item 간격24. Bottom line True 예시는 좌우 padding28, 바닥선1 divider/secondary. False 예시는 바닥선 없고 container padding0이다. 바닥선 유무와 margin 크기는 원본에서 결합된 예시지만 공개 API는 명시적으로 설정할 수 있게 하라. label primary/secondary/quaternary 규칙은 Box와 같다. Pressed 내부 Button은 dim/dark/primary(@0.05), selected 밑줄은 primary다.

### 6.4 구현 계약 [I]

`PleosTabs(items, selectedKey, onSelected, style, size, fitted, lineMargin, bottomLine, modifier)`를 구현한다. 안정적인 key를 받으며 items 재정렬이 선택값을 index로 잘못 바꾸지 않아야 한다. 각 item에는 label, optional icon, enabled를 둔다.

- 클릭은 pointer-up의 유효한 click에만 발생한다. press-cancel로 선택이 바뀌지 않는다.
- `selected`와 input focus·pressed·enabled는 독립 값이다. keyboard/rotary focus 이동이 즉시 화면 전환인지 activation 이후 전환인지는 공통 입력 정책을 사용한다.
- 선택 item이 사라지면 호출자가 fallback selection을 결정하게 한다. 내부에서 첫 item을 조용히 고르지 말라.
- non-fitted overflow에서는 수평 스크롤을 제공하고 선택·focus item을 보이게 한다. fitted에서는 장문 label을 명시된 한 줄 말줄임 규칙으로 처리한다.
- Medium 6개는 원본 조합은 아니지만 generic items API에서 지원할 수 있다. 시각 검증 목록에서 원본 fixture와 확장 fixture를 구별한다.

## 7. Checkbox

### 7.1 공식 의미 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/selections/checkbox>

서로 독립된 여러 옵션을 선택한다. Root·Control·Icon으로 구성하며 checked·pressed·disabled를 표현한다. anatomy에는 미선택, 체크, 대시 표시가 있다. 따라서 웹 상태표의 Boolean만 복사해 대시 상태를 누락하지 말라.

### 7.2 Figma 규격 [F]

`ivi_checkbox`67:33570: `False`, `True`, `Indeterminate` × `Enabled`, `Pressed`, `Disabled` = 9개.

Root 64 × 64, 중앙 시각 box48 × 48, 반경12. 체크/마이너스 icon instance44 × 44. Root의 빈 공간도 터치·focus 대상으로 포함한다. 체크·대시 아이콘의 path와 내부 inset은 공급된 vector 자료를 사용한다.

| 상태 | Box 채움 | Box 테두리 | Mark |
| --- | --- | --- | --- |
| Off Enabled | 없음 | divider/tertiary #131417@0.20, inside4 | 없음 |
| Off Pressed | dim/dark/secondary #131417@0.10 | 동일 | 없음 |
| Off Disabled | dim/dark/primary #131417@0.05 | divider/secondary @0.10, inside4 | 없음 |
| On/Mixed Enabled | switch/on #02C265 | 별도 visible stroke 없음 | 흰색 체크/대시 |
| On/Mixed Pressed | switch/on + dim/dark/secondary @0.10 overlay | 없음 | 동일 |
| On/Mixed Disabled | switch/disabled #131417@0.10 | 없음 | 흰색 체크/대시 @0.64 |

채움 있는 box에 남아 있는 `strokeWeight=3.025` 속성은 visible stroke paint가 없으므로 테두리를 그리라는 의미가 아니다.

### 7.3 구현 계약 [I]

`PleosCheckbox(state: ToggleableState, onClick, enabled, modifier)`와 Boolean 편의 overload를 제공한다. Mixed를 자동 toggle cycle의 세 번째 값으로 고정하지 말고 parent aggregate 상태로도 사용할 수 있게 하라. 기본 click 요청은 Off→On, On→Off, Mixed→On이며 실제 state 업데이트는 외부가 수행한다. Row label을 포함하는 helper는 하나의 논리 Checkbox semantics만 제공한다.

## 8. Radio button

### 8.1 공식 의미 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/selections/radio>

여러 후보 중 한 항목을 선택한다. 값은 선택된 항목의 순서 또는 null이며 pressed·disabled·invalid를 구분한다. checked true/false 각각 Enabled·Pressed·Disabled 도해가 있다. 본문 anatomy의 `Checkbox` 명칭은 복사 오류이며 Radio로 구현한다.

### 8.2 Figma 규격 [F]

`ivi_radio_button`67:33597, 67:33598–33609: 선택 여부2 × 상태3 = 6개. Root64 × 64, 중앙 control48 × 48, 원형.

| 상태 | 내부 채움 | 원형 border |
| --- | --- | --- |
| Unselected Enabled | 없음 | divider/tertiary #131417@0.20, inside4 |
| Unselected Pressed | dim/dark/secondary @0.10 | 동일4 |
| Unselected Disabled | dim/dark/primary @0.05 | divider/primary @0.05, inside4 |
| Selected Enabled | switch/knob_on #FFFFFF | informative/active #02C265, inside12 |
| Selected Pressed | 동일 | active + dark secondary@0.10, inside12 |
| Selected Disabled | switch/knob_disabled #FFFFFF | switch/disabled #131417@0.10, inside12 |

선택 Radio는 보통의 가운데 색 점과 달리, 두꺼운 색 테두리와 흰색 중앙으로 보인다. 동일 디자인을 유지하라.

### 8.3 구현 계약 [I]

`PleosRadioButton(selected, onClick, enabled, invalid, modifier)`와 `PleosRadioGroup<T>(options, selectedKey: T?, onSelected)`를 제공한다. stable key 사용으로 index 기반 값의 삭제·재정렬 문제를 피하되 문서의 null 상태는 지원한다. 선택된 Radio를 다시 눌러 자동 해제하지 않는다. 그룹 선택은 상호 배타적이다.

Invalid는 웹 상태표에만 있고 별도 색/도해/Figma variant가 없다. 의미론 `error` 및 호출자가 지정한 오류 설명을 기본 제공하며, 기본 외형은 선택/disabled 상태를 보존한다. 임의의 붉은 Radio를 공식 디자인으로 추가하지 말라. 시각 error decoration은 명시적 [I] 옵션으로 분리한다.

## 9. Switch

### 9.1 공식 의미 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/selections/switches>

기능을 On/Off로 바꾼다. Root·Handle·Track을 구분한다. checked·pressed·disabled·invalid를 제공하며 On/Off 각각 Enabled·Pressed·Disabled를 표시한다. 손잡이는 원형이 아닌 모서리가 둥근 사각형이다.

### 9.2 Figma 규격 [F]

`ivi_switch`67:33612, 67:33613–33636: 크기2 × On/Off2 × 상태3 = 12개.

| 항목 | Medium | Small |
| --- | ---: | ---: |
| Track W × H | 80 × 48 | 64 × 40 |
| Track radius | 16 | 12 |
| 내부 여백 | 8 | 6 |
| Handle W × H | 32 × 32 | 28 × 28 |
| Handle radius | 8 | 8 |
| Handle off x / on x | 8 / 40 | 6 / 30 |
| Handle y | 8 | 6 |

On track=`switch/on`#02C265; Off=`switch/off`#131417@0.30; Disabled On/Off=`switch/disabled`#131417@0.10. Pressed는 현재 track 위에 `dim/dark/secondary`#131417@0.10을 합성한다. 손잡이는 `switch/knob_on`, `knob_off`, `knob_disabled`이며 밝은 스냅샷은 모두 #FFFFFF다. disabled여도 현재 On/Off 손잡이 위치를 보존한다.

### 9.3 구현 계약 [I]

`PleosSwitch(checked, onCheckedChange, enabled, invalid, size, modifier)`를 구현한다. 시각 track과 접근 가능한 hit 영역을 분리하여 Small의 작은 외형이 클릭 영역까지 축소하지 않게 하라. 클릭과 keyboard activation은 한 번만 toggle 요청을 전달한다. drag로 전환하는 기능을 더한다면 click과 중복 dispatch를 방지한다. Invalid 기본 정책은 Radio와 같다. 애니메이션 시간·easing은 원본 미정의이며 공통 모션 토큰을 [I]로 명시한다.

## 10. Spinner

### 10.1 공식 의미와 웹 치수 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/spinner>

이 Spinner는 로딩 회전 아이콘이 아니라 날짜/시간 wheel picker다. 여러 값 목록을 터치·상하 drag해서 하나를 고른다. 가운데 선택값과 위아래 후보를 구분한다. Date와 Time을 제공한다. 예시는 Date의 월·일·년, Time의 시·분·AM/PM 순서다.

웹 SVG geometry: Date Root600 × 384, Time Root500 × 384. 중앙 강조띠는 각각568 × 88, 468 × 88이며 양옆 inset16, radius24. root radius32. Date 열 폭120/120/200, Time120/120/140, 열 간격24; 열 그룹은 중앙 정렬한다. 위아래 fade mask 높이는60이다. 도해 아래568/468 수치를 root 전체 폭으로 잘못 사용하지 말라.

### 10.2 첨부 확장과 최종 치수 [F]

`ivi_spinner`67:33663, `spinner_wheels`67:33741.

| 출처 / 크기 | Date Root | Time Root | 강조띠 폭 Date/Time | 행·마스크 |
| --- | --- | --- | --- | --- |
| **최종 Large [W]** | 600 × 384 | 500 × 384 | 568 / 468 | 상단60 + 이전88 + 선택88 + 다음88 + 하단60 |
| **최종 Medium [첨부 보완 + 웹 축 승계]** | **600 × 288** | **500 × 288** | **568 / 468** | 이전96 + 선택96 + 다음96; 강조띠96, fade60 |
| 과거 Figma Large(추적용) | 540 × 384 | 480 × 384 | 508 / 448 | 동일 |
| 첨부 Medium 원본(추적용) | 540 × 288 | 480 × 288 | 508 / 448 | 이전96 + 선택96 + 다음96; 위아래 fade60 |

과거 Figma Date 열110/110/200, Time110/110/140, 열 간격20은 추적용이다. **최종 Large/Medium 모두 웹의 Date 열120/120/200, Time 열120/120/140, 간격24를 사용하며 중앙 정렬한다.** Root 좌우 padding16. Medium은 웹에 없는 [첨부 보완] 크기다. Medium 최종 root는 Date600 × 288, Time500 × 288, 강조띠 폭568/468·높이96, 96높이 행3개, 위아래 fade60이다. 웹과 충돌하지 않는 Medium 높이/행96만 첨부에서 보완한다.

선택값: Asta Sans Bold60/80 primary. 나머지 값: Bold48/64 quaternary(#131417@0.32). **웹 색상 차이 [W]:** Picker4 비선택 숫자는 #1B1C1E@0.32이므로 최종 구현에서 이를 사용한다. 원본 값 label box는 높이88이고 Medium row는96이므로 가운데 맞춘다. 배경 `background/primary`#F7F8FA, 강조띠 `dim/dark/primary`#131417@0.05, Root radius32, 강조띠 radius24.

Date/Time × Large/Medium = 4개 wheel variant를 위 최종 치수로 모두 구현한다. 조합 wrapper는 `Date`(67:33742), `Time`(67:33746), `Date+Time`(67:33750)이다. 첨부 Date+Time 예시 총1104 × 384는 두 panel540 + gap24 + 540의 과거 값이다. **최종 조합의 기본폭은 [I: 웹 우선 조합] Date600 + gap24 + Time500 = 1124**로 계산하고 가변폭 확장을 지원한다. 양 panel을 같은 폭으로 늘리는 것은 [I] 레이아웃 옵션으로 분리하라. 선택적 heading은 Bold36/44 secondary, heading top padding16, heading과 wheel gap16이다. 숨겨진 heading을 기본 필수 높이로 포함하지 말라.

### 10.3 구현 계약 [I]

`PleosDateSpinner`, `PleosTimeSpinner`, `PleosDateTimeSpinner`, 재사용 가능한 `PleosWheelColumn<T>`를 구현하라. 날짜 값·범위·locale, 시간 값·12/24h 형식·minuteStep·enabled를 외부에서 받는다.

- 날짜의 실제 달별 일수, 윤년, 최소/최대값을 검증한다. 월/년 변경 후 불가능해진 일자는 범위 안의 마지막 유효 일자로 clamp하며 변경 결과를 한 번 전달한다.
- 시간의 12AM=00시, 12PM=12시 변환을 명시한다. 24h 형식은 [I] 확장으로 AM/PM 열을 숨긴다. 예시의 2024년 또는 12/25를 기본값으로 하드코딩하지 말라.
- drag/fling 종료 시 한 행 중심에 snap한다. 회전 입력·키보드·접근성 increment/decrement로도 한 단계 변경 가능해야 한다. 각 열의 독립 scroll state와 전체 날짜/시간 consistency를 동시에 보장한다.
- 유한 범위 끝에서 wrap 여부를 옵션으로 명시하라. 원본은 무한 스크롤·자동 연/월 이월 정책을 규정하지 않는다. 기본은 연도 유한/clamp, 월·일/시간의 wrap은 off로 두고 UI 규칙과 일치시킨다.
- 후보값을 스크린리더에 다 중복 읽지 말고 현재 선택값과 조정 action을 제공한다. 로딩 spinner API와 이름/semantics를 분리한다.

## 11. System Notification

### 11.1 공식 구조 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/notification/system-notification>

OS 알림 디자인의 Root·Imagery·Header·Action을 재현한다. 이미지는 App icon, Profile, Image 세 종류이고 전화·메시지 Profile에는 서비스 app badge를 겹친다. 버튼 정렬은 Single·Vertical·Horizontal이다. 별도 Call 예시는 받기·거절 두 액션이다. 웹 도해의 일반 CTA는 밝은 Basic 스타일이며 Call은 녹색 수락·주황빛 빨강 거절이다. 시스템 notification과 앱 내 preview card를 별도 책임으로 나눈다.

### 11.2 Figma 원본과 확장 [F]

`ivi_notification_system`67:34043의 `Image+Text`67:34044, `Only Text`67:34051, `Call`67:34058. Only Text는 첨부 확장이다. `system_notification/images`67:34079의 App·Profile·Image, button67:34067의 Single·Vertical·Horizontal·Call을 모두 구현한다.

| 항목 | Figma 규격 |
| --- | --- |
| Root 기본폭 | 700; 가변 constraints 허용 |
| Image+Text / Call 기본높이 | 276 |
| OnlyText 기본높이 | 270 |
| Root radius / border | 48 / inside1 divider/secondary@0.10 |
| Root 밝은 배경 | #FFFFFF (`gleo/Olf/surface_primary` 원본 참조) |
| Header padding | start/end32, top32, bottom16 |
| Imagery | 100 × 100 |
| imagery-text 간격 | 24 |
| 제목 | ExtraBold36/44, primary |
| 설명 | Regular26/34, tertiary |
| title-description gap | 12; text group top4 |
| action container padding | 네 방향24 |
| 두 action 간격 | 16 |
| action 높이 / radius | 80 / 24 |
| Single/Horizontal action 영역 높이 | 128 |
| Vertical action 영역 높이 | 224 |

Image+Text/Call의 header148 + action128 = 276. Vertical이면 기본 전체높이372가 된다. OnlyText header142 + action128 = 270. 텍스트가 여러 줄이면 실제 측정으로 더 늘어난다. button 원본 컴포넌트 시연폭1404.5는 실제 card700의 상수 너비가 아니다. Horizontal 700폭에서 버튼폭은 `(700−48−16)/2 = 318`이며 Single/Vertical은652다.

Profile은100 원형 사진, app badge48 × 48을 local(60,60)에 두어 가장자리에서8만큼 돌출한다. badge radius16. Image의 도해 crop은 radius24, 실제 이미지 resource의 clipping은 shape slot으로 일관되게 적용한다. 임의 사람 사진을 필수 asset으로 고정하지 말라.

**웹 색상 차이 [W]:** system_noti/system_properties의 Description은 #1B1C1E @0.64이며 첨부 원본은 #131417 @0.64다. 최종 Description은 웹 값을 사용한다.

Root shadow는 black@0.24 offset(0,20) blur40 + black@0.20 offset(0,2) blur4. Profile badge shadow는 black@0.16 offset(0,8) blur32 + black@0.08 offset(0,2) blur2다.

**CTA 스타일 충돌:** 첨부 Horizontal/Vertical 주버튼은 Filled(#44464E), 보조는 Basic(#131417@0.05), Single은 Basic이다. 웹 일반 도해는 두 버튼 모두 Basic이다. **최종 일반 CTA는 Single/Vertical/Horizontal 모두 웹 Basic을 사용한다.** 첨부의 Filled는 추적용이며 이전 사양 전환 기능을 구현하지 않는다. 호출자가 다른 action style을 넘기는 일반 확장 API는 허용하되 공식 기본값과 구별한다. Call 색은 `phone/accept_normal`#32B957, `phone/end_normal`#FE3D16, 흰색 label이다.

### 11.3 구현 계약 [I]

`PleosSystemNotificationCard(title, description, imagery, actions, actionLayout, kind, modifier)`를 순수 UI로 제공한다. 플랫폼 알림 제출은 별도 adapter가 담당한다.

- 앱이 OS의 모든 알림 외형·위치·우선순위를 자유롭게 덮어쓸 수 있다고 가정하지 말라. OEM/system 권한에 의존하는 integration은 별도 모듈·capability로 분리한다.
- card의 Call appearance만으로 실제 전화를 수신/거절하지 않는다. accept/reject 콜백을 호스트에 전달한다.
- imagery는 app image, profile+badge, generic image, none을 sealed model로 표현한다. 미제공/로드 실패 이미지의 fallback도 주어진 크기를 유지한다.
- 일반 액션과 dismiss의 이벤트를 구별한다. 알림 수신 때 focus를 강제로 빼앗지 말고 호출자가 정의한 우선순위/접근성 announce 정책을 적용한다.

## 12. Toast

### 12.1 공식 규격 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/toast>

Root와 메시지로 구성한다. App panel 기준 양옆과 아래24dp를 띄우고 하단 중앙에 놓는다. 전체 최대너비792, 텍스트 최대너비712다. 메시지 내부 좌우40·상하24로 전체폭과 텍스트폭의 차이가80이다. 긴 메시지는 여러 줄로 감싸되 해당 최대폭을 지킨다. Toast Popup과 같은 도해이므로 시각 구현을 공유한다.

### 12.2 Figma 보완 [F]

첨부의 반경·폰트는 5절 `ivi_toast_popup`과 같다: radius16, Bold26/34, 기본 한 줄 높이82. **Light 최종 Toast와 ToastPopup은 웹 배경 #131417@0.84, 문자 #FFFFFF**를 사용한다. alpha를 미리 흰 배경에 합성한 색상으로 바꾸지 말라. 첨부 Light 배경 #44464E 불투명은 과거 추적값이다. **Dark는 웹에 시각값이 없어 [첨부 보완]으로 `basic/600` 배경 #E0E1E6 불투명 + `basic/00` 문자 #131417**을 사용한다. 웹 Light 도해가 모든 테마의 static overlay를 규정한다고 주장하지 말라. 최대너비는 Figma의 예시 문자열폭261이 아니라 웹792를 적용한다.

### 12.3 Host·수명 계약 [I]

`PleosToast(message, leadingIcon?, modifier)`는 surface, `PleosToastHost(state, placement)`는 overlay 배치, `PleosToastPopup`은 동일 host에 margin을 적용하는 공개 편의 API로 구성한다.

- 모든 폭을 같은 `Dp`로 환산한 후 계산한다. text-only 기준 `containerWidthDp ≤ min(toDp(792u), panelWidthDp − 2×24.dp)`, `textWidthDp ≤ min(toDp(712u), containerWidthDp − 2×toDp(40u))`이다. icon이 있으면 `toDp(48u + 16u)`를 추가로 제외한다. **외부24dp에는 u→dp 배율을 다시 적용하지 않는다.** 내부 padding24u와 외부24dp를 혼동하지 말라.
- message를 빈 문자열로 보내면 표시하지 않는다. 숫자·Unicode·여러 줄·긴 URL·띄어쓰기 없는 문자열의 측정을 검증한다.
- duration·큐 길이·중복 합치기·새 알림 replace 정책은 공식 자료에 없다. 라이브러리 기본 정책을 문서화하고 override 가능하게 하라. 권장 기본은 FIFO, 안정적 ID 기준 동일 메시지 중복 합치기, `Short/Long/Custom` duration 모델이다. 실제 시간은 공통 모션/알림 정책의 [I] 값으로 관리한다.
- coroutine scope를 composition/lifecycle에 연결하고 화면 종료 뒤 timer가 유출되지 않게 하라. 재구성만으로 duration을 처음부터 다시 시작하지 않는다.
- noninteractive toast는 focus 대상이 아니며, 접근성 announcement를 중복 발행하지 않는다. 접근성 권장 timeout이 제공되면 반영한다.
- 실제 Android `Toast` 시스템 API와 이름·host 정책을 혼동하지 말라. 이 디자인을 정확히 재현하는 기본 구현은 앱 panel 내부 host다.

## 13. Widgets

### 13.1 공식 구조·동작 [W]

출처: <https://document.pleos.ai/docs/connect/guide/docs-design/components/widgets>

Root, 상단 Handle, Pagination, 왼쪽 Title/Action, 오른쪽 Information 영역을 구현한다. `Show`와 `Hidden` 상태가 있고 각각 pressed 표현을 가진다. Driving view 하단에 배치한다. 내용 영역의 수평 drag는 다른 위젯으로 전환한다. 상단 Handle을 아래로 끌면 숨기고, Hidden 상태의 위쪽 화살표 Handle을 터치하면 다시 펼친다. 예시 콘텐츠는 타이어 공기압과 주행 정보이며 사용자 앱의 실제 차량 데이터 연동 규약은 제공하지 않는다.

공식 Widget1 SVG geometry: Root792 × 176, radius32, white fill, inside1 #131417@0.10. 정보 영역496 × 112가 local(272,40)에 있고 bottom/end 여백24다. 왼쪽 button 영역은 local(24,88), 폭224·높이64; 양 영역 간격24. pagination 점 지름8, pitch18, selected#131417, others 동일색@0.32다. 상단 중앙 handle은 폭86·두께6, #131417@0.20의 둥근 선으로 표시된다.

### 13.2 자료 범위와 구현 결정 [I]

두 첨부에서 독립적인 Widgets SYMBOL 집합은 확인되지 않았다. 위 exact geometry는 공식 웹 SVG에서 추출한 shell 기준이다. raster 예시에만 있는 Hidden handle의 최종 수치·gesture threshold·animation duration은 공식 수치로 단정하지 말라. 다음 값을 **보완 기본값**으로 명시하고 public metrics에서 바꿀 수 있게 하라.

| 보완 항목 | 기본 정책 |
| --- | --- |
| title/action typography | 별도 `WidgetTitleTypography` 24/32 Bold의 [I] 보완 토큰; 원본 font 수치 미확정이며 공통 typography scale의 기존 항목이 아님 |
| Show handle hit 영역 | 폭240 × 높이60, shell 상단 중앙; 시각 선은86 × 6 |
| Hidden handle surface | 폭160 × 높이64, 위쪽 모서리32, 위 방향 chevron |
| Hidden handle hit 영역 | 폭240 × 높이80 |
| Show/Hidden 전환 | 기본은 drag 종료 시 아래 이동≥0.35 × shell height면 숨김; velocity 기반 숨김은 기본 off이고 별도 threshold 옵션을 준 경우만 적용 |
| container 최소 padding | 앱/시스템 호스트의 safe-area 및 하단 시스템영역 inset 적용; 웹이 제공하지 않은 고정 전역 좌표를 만들지 않음 |
| 컬러/그림자 | Show shell은 위 [W] 값; pressed handle은 더 진한 neutral token; shadow는 공통 overlay token |

`PleosWidgetHost(items, currentKey, onCurrentChanged, visibility, onVisibilityChange, modifier)`와 `PleosWidgetCard(title, action, information, pagination, handle)`를 구현한다.

- 일반 앱에서 Driving view system surface에 무조건 삽입할 수 있다고 가정하지 말라. 기본은 지정된 앱 부모 내 compose host이고 시스템 통합은 capability adapter다.
- widget은 이 문서에서 차량 HMI card를 뜻한다. Android 홈 화면 `AppWidgetProvider/RemoteViews`와 자동으로 동일시하지 말라.
- 타이어 압력·주행거리·전비는 UI 데이터 모델로 받는다. 숫자 단위·locale formatting은 호스트에서 공급하고 CarPropertyManager 호출을 core UI에 결합하지 않는다.
- 수평 페이지 drag와 수직 숨김 drag를 gesture 방향 잠금으로 구별한다. 내부 button click과 drag가 동시에 실행되지 않게 한다.
- Show/Hidden은 호스트 상태다. recomposition 또는 items 업데이트로 임의로 펼쳐지지 않는다. Hidden에서 currentKey를 보존한다.
- pagination은 현재 페이지와 전체 개수를 읽을 수 있게 한다. dot을 클릭 가능한 UI로 확장할 경우 별도 semantics/action을 주되 작은 점 자체만 hit target으로 삼지 않는다.
- drag 대체 입력으로 이전/다음·숨기기·펼치기 접근성 action과 keyboard/rotary action을 제공한다.

## 14. 빠짐 방지 검증 목록

아래 항목을 component catalog와 테스트 매트릭스에 그대로 반영하라. 자동 screenshot은 실제로 정의된 원본 조합과 보완 조합을 구분해 이름을 붙인다.

| Family | 반드시 보여줄 원본 조합 / 확장 |
| --- | --- |
| Text Field | Text/Tel/Url/Email/Password × Small/Medium; Enabled/Focused/Typing/Entered/ReadOnly/Error; suffix 없음/clear/eye/text; Disabled 보완 |
| Number Field | Medium/Large × Enabled/Focused/Entered/Error; 가변 자리 수; ReadOnly/Disabled 보완 |
| Page Navigation | Main primary/secondary/subtitle/suffix; Depth back/subtitle; header Radio/Phone/Music 및 tab/background preset |
| System Popup | Medium/Large × Single/Vertical/Horizontal; header icon/subtitle/description; body 없음/List/Spinner/TextField/custom; Figma Extended 양 크기 |
| Toast Popup | margin on/off, 아이콘 없음/app/Bluetooth, 짧은/최대폭/다중줄 |
| Tabs | Box Large 2–6, Medium2–5 원본; selected/unselected/pressed/disabled; Line 2 margin × 4 states, bottom line on/off; fitted on/off |
| Checkbox | Off/On/Indeterminate × Enabled/Pressed/Disabled |
| Radio | Selected/Unselected × Enabled/Pressed/Disabled; null group selection; Invalid semantics |
| Switch | Small/Medium × On/Off × Enabled/Pressed/Disabled; Invalid semantics |
| Spinner | Date/Time × Large/Medium; Date+Time; 웹 최종 폭·열간격 및 첨부 Medium 높이; locale·윤년·경계값 |
| System Notification | Image+Text/OnlyText/Call; App/Profile+badge/Image/None; Single/Vertical/Horizontal/Call action |
| Toast | 동일 surface를 shared host에서 사용; 24dp outer, max792u/712u, queue/lifecycle/timeout |
| Widgets | Show/Hidden × Enabled/Pressed; 1개/여러 페이지; 수평 전환·아래 숨김·탭 복귀·대체 입력 |

원본에 없는 시각 상태는 누락을 숨기지 말고 보완 정책과 snapshot 이름에 `[I]` 표시를 남겨라. 자료에서 지정하지 않은 동작값은 위에 명시된 보완 기본값을 우선하고, 그마저 없는 값은 공통 `PleosBehaviorDefaults`의 [I] 결정으로 확정하여 별도 가정 목록에 기록하라. 공식 수치인 것처럼 표시하지 말라.

## 15. 출처 인덱스와 정합성 메모

| 항목 | 공식 페이지 | 확인한 도해 |
| --- | --- | --- |
| Text Field | `/components/fields/text-field` | text_anatomy, text_status, typing_interaction, text_type |
| Number Field | `/components/fields/number-field` | num_anatomy, num_states, num_size(본문 embedded SVG) |
| Page Navigation | `/components/page-navigation` | nav_anatomy, nav_types, nav_main, nav_depth |
| System Popup | `/components/popups/system-popup` | pop_anatomy, pop_size, pop_align, pop_contents |
| Toast Popup | `/components/popups/toast-popup` | Toast1, Toast2, Toast3 |
| Tabs | `/components/segmented-menu` | Segmented1, Segmented2, Segmented4, Segmented7 |
| Checkbox | `/components/selections/checkbox` | Checkbox1(embedded), Checkbox2, Checkbox4 |
| Radio | `/components/selections/radio` | radio1(embedded), radio2, radio3 |
| Switch | `/components/selections/switches` | Switch1(embedded), Switch2, Switch3 |
| Spinner | `/components/spinner` | Picker1, Picker4, Picker7 |
| System Notification | `/components/notification/system-notification` | system_noti, system_types, system_properties |
| Toast | `/components/toast` | Toast1, Toast2, Toast3 |
| Widgets | `/components/widgets` | Widget1(SVG), Widget2/3/4(PNG임에도 alt 확장자는 svg) |

위 상대 URL의 접두사는 `https://document.pleos.ai/docs/connect/guide/docs-design`이다. 전체 웹 페이지·도해를 확인한 뒤 사실·구현 계약으로 재작성했으며 원문 페이지의 읽기를 구현 LLM에 다시 요구하지 않는다.

검출한 충돌: 웹 secondary/tertiary/quaternary 일부 text base #1B1C1E/Figma #131417; Toast Light 웹배경#131417@0.84/Figma#44464E; Toast Dark는첨부보완#E0E1E6배경/#131417문자; Popup Medium 웹760/Figma808; Figma Extended720/1000 추가; Spinner 웹600/500 및 gap24/Figma540/480 및 gap20; Notification 주 CTA 웹Basic/FigmaFilled. 복사 오류: Text Field `Samll`, Number Field 설명의 `Text Field`, Page Navigation Properties 설명 혼입, Radio anatomy의 `Checkbox`, Switch disabled 설명의 `Button`. 의미를 정규화하고 원본 오류를 API 명세로 확산하지 말라.
