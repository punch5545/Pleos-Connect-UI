# Pleos Connect AAOS Kotlin UI Library — 실행 프롬프트

> 이 파일과 같은 폴더의 번호가 붙은 Markdown 명세를 함께 제공한 뒤, 아래 지시를 수행하라. URL은 출처 식별용이다. 웹 검색, Figma 서버 접속, 원본 `.fig` 재해독 없이 구현할 수 있도록 확인한 값과 동작을 본 묶음에 기록했다. **지금 수행할 작업은 실제 Kotlin 라이브러리 구현이다. 계획이나 예제 몇 개로 끝내지 마라.**
>
> 조사 기준일: **2026-10-28 (UTC)**. `215`는 제공된 파일명의 식별자이며, 공식 제품 버전 번호라고 단정하지 않는다. 이 문서는 현대자동차그룹이 발행한 공식 SDK가 아니라, 제공 자료를 바탕으로 작성한 구현 지시서다.

## 1. 역할과 완성 목표

너는 Android Automotive OS(AAOS), Kotlin, Jetpack Compose, 디자인 시스템과 접근성에 숙련된 라이브러리 엔지니어다. **Pleos Connect 디자인 가이드의 아래 22개 말단 컴포넌트와 그 하위 종류·크기·상태·선택적 슬롯을 모두 제공하는 재사용 가능한 Android 라이브러리**를 구현하라.

기본 기술 선택은 **Kotlin + Jetpack Compose UI/Foundation**이다. 프로젝트에 이미 확정된 기술 스택이 있다면 그 제약을 보존하고, 달라지는 부분만 명시하라. Material 컴포넌트의 기본 모양에 색상만 바꾸는 구현은 허용하지 않는다. Foundation의 입력·레이아웃·접근성 기능을 활용하고 Pleos의 치수·타이포그래피·도형·상태 표현은 명세대로 구현하라. Canvas를 쓸 때도 개별 컨트롤의 semantics와 조작 동작을 제공하라.

생산물은 다음을 포함한다.

1. 독립적으로 소비할 수 있는 Android Library/AAR, 공개 Kotlin API, Light/Dark 테마, 폼팩터별 토큰, 정확한 상태 모델.
2. 모든 변형을 탐색하고 조작할 수 있는 실행 가능한 AAOS 샘플/카탈로그 앱.
3. 상태·이벤트·접근성·스크린샷 검증과 실행 결과. 실제 실행하지 못한 검증은 결과를 꾸미지 말고 제한을 기록한다.
4. 사용 예제, 설치 방법, 토큰 확장 방법, 출처별 차이, 미확정 값의 결정 내역을 담은 개발자 문서.

## 2. 입력 파일과 읽는 순서

| 순서 | 파일 | 역할 |
| --- | --- | --- |
| 1 | `00_MASTER_PROMPT.md` | 범위, 출처 우선순위, 실행 순서, 완료 조건 |
| 2 | `01_FOUNDATIONS_AND_DISPLAY.md` | 공통 색상·타입·그림자·아이콘·디스플레이 및 단위 |
| 3 | `02_ACTIONS_BARS_CONTROLLERS.md` | Actions 5종, Bar, Controllers, Indicator, Dropdown |
| 4 | `03_FIELDS_NAVIGATION_FEEDBACK.md` | Fields, Page Navigation, Popups, Tabs, Selections, Spinner, Notification, Toast, Widgets |
| 5 | `04_AAOS_API_AND_ACCEPTANCE.md` | 라이브러리 구조, 공개 API 계약, AAOS·접근성·검증 |
| 6 | `05_FIGMA_ASSET_TOKENS.md` | 첨부 design-assets의 전체 변수와 모드별 값·별칭 |
| 7 | `06_FIGMA_DISPLAY_TOKENS.md` | 첨부 display-guide의 전체 변수와 추가 폼팩터·브랜드 모드 |
| 8 | `07_FIGMA_COMPONENT_DETAILS.md` | 첨부 컴포넌트의 실제 계층·속성·변형·노드 식별자 |
| 9 | `08_SOURCES_CONFLICTS_AND_COVERAGE.md` | 출처 목록, 충돌 해결, 누락 방지 체크리스트, 자료 한계 |
| 10 | `assets/README.md` | 동봉 폰트·아이콘의 사용법, 원본과 변환 한계 |

추가 필수 부록은 `appendices/figma_components/00_INDEX.md`의 13개 컴포넌트 상세 파일, `appendices/09_ICON_PATHS.md`, `appendices/10_COLOR_TOKEN_MAPPING.md`다. 07번의 경로 표를 따라 해당 부분을 읽는다.

토큰 JSON과 SVG는 자동 코드 생성 및 정확한 도형 복원을 돕는 보조 데이터다. 요구사항과 수치의 의미는 Markdown을 기준으로 해석한다. 원본 Figma 파일은 재검토용이며, 이 묶음으로 작업할 때 필수 입력이 아니다.

문맥 한도가 부족하면 파일을 생략하지 말고 단계별로 읽어라. 먼저 공통 규칙과 작업 중인 컴포넌트 장을 읽고, 필요한 토큰·원본 노드 행을 찾아 적용한다. 각 단계가 끝날 때 저장된 코드, 구현 목록과 다음 작업을 기록하고 이어서 수행한다.

## 3. 반드시 구현할 범위

| ID | 가이드 분류 | 필수 컴포넌트/하위 범위 |
| --- | --- | --- |
| A01 | Actions / Basic button | hierarchy·size·선행/후행 슬롯·pressed/disabled/loading |
| A02 | Actions / Toggle button | 모든 제시 크기·selected 및 입력 상태 |
| A03 | Actions / Text button | 텍스트·아이콘 슬롯, 제시 상태와 크기 |
| A04 | Actions / Icon button | Basic/Plain/Circle·크기·pressed/disabled; 원본에 없는 selected/loading은 필수가 아님 |
| A05 | Actions / Keypad | 숫자 키패드 및 첨부에 포함된 키 종류·배열·입력 동작 |
| B01 | Bar | Window bar, Scroll bar 및 제시 상태; 첨부 app-control primitive는 지원 요소로 구분 |
| C01 | Controllers | Continuous/Centered Slider, Stepper, 부속 버튼·track·label; step/snap은 값 정책 |
| I01 | Indicator | Wide/Narrow, 현재 위치·비현재 위치·페이지 수 |
| D01 | Dropdown | 기본 필드/트리거, 메뉴 패널, 아이템 종류, 선택·확장·비활성 |
| F01 | Fields / Text Field | 크기, focus·value·validation·password 등 슬롯/상태 |
| F02 | Fields / Number Field | 숫자·비밀번호 입력, focus/invalid, 키패드 연동 |
| N01 | Page Navigation | 깊이별 탐색 헤더·뒤로가기·제목·메뉴·검색 등 명세의 구성 |
| P01 | Popups / System Popup | 크기·버튼 배열·콘텐츠 유형·dismiss·modal 동작 |
| P02 | Popups / Toast Popup | 팝업형 간단 피드백의 모든 제시 유형·크기·닫힘 |
| T01 | Tabs | Box(첨부 변수명 solid)/Line, 크기·항목 수·선택 상태·내용 슬롯 |
| S01 | Selections / Checkbox | checked/unchecked/indeterminate 및 제시 입력 상태 |
| S02 | Selections / Radio button | 단일 선택 그룹과 개별 아이템, 상태 |
| S03 | Selections / Switch | 크기·on/off·enabled/pressed/disabled 입력 상태 |
| SP01 | Spinner | **Date/Time wheel picker**와 첨부의 크기·시간 형식. 로딩 스피너와 구분 |
| SN01 | System Notification | 정보 카드·미디어/이미지 슬롯·CTA 배열·인앱 표시 host |
| TO01 | Toast | 일반 Toast의 배치·메시지·닫힘/시간 규칙 |
| W01 | Widgets | 가이드에 제시된 모든 레이아웃·크기·콘텐츠 슬롯·상태 |

`Bar`와 OS의 Status bar/GNB는 같은 범위가 아니다. 실제 시스템 바, 런처, 차량 제어 서비스 자체를 이 라이브러리의 필수 구현으로 확대하지 않는다. 다만 이들이 앱 표시 영역을 가리는 환경은 레이아웃 검증에 반영한다. `System Popup`, `Toast Popup`, `Toast`, `System Notification`은 각각 독립된 공개 모델과 카탈로그 항목을 둔다.

세부 명세에 있는 추가 변형은 이 표에 생략되어 있어도 구현 대상이다. 반대로 변수 저장소나 Internal Only Canvas에 남은 모든 과거 실험·표·문서 장식 요소를 제품 API로 노출할 필요는 없다. 실제 컴포넌트 구현에 필요한 원형·아이콘·스타일은 포함하라.

## 4. 출처와 충돌을 처리하는 규칙

각 요구사항은 다음 중 하나로 식별한다.

- **[WEB]**: 공식 가이드 본문/표에 직접 있는 규칙.
- **[WEB-SVG]**: 공식 도해의 벡터 좌표나 눈금·라벨에서 확인한 값. 스크린샷 화면 확대율을 Android 크기로 오인하지 않는다.
- **[FIG]**: 사용자가 첨부한 `.fig`의 실제 노드, 변수, component property, override에서 추출한 값.
- **[DECISION]**: 구현을 완성하기 위한 이 프롬프트의 설계 선택. 공식 Pleos 규칙이라고 표현하지 않는다.
- **[UNSPECIFIED]**: 자료에 근거가 없거나 복수 해석이 가능한 부분. 아래 결정 절차로 처리한다.

### 4.1 웹 버전을 최신으로 간주한다 — 사용자 확정 지시

**문서 간 상충이 있으면 웹 버전을 최신으로 간주하고 웹 값을 최종 구현 규격으로 사용하라.** 구현 사양은 하나다. `WebLatest20261028`이라는 표현은 조사 스냅샷 식별자이며 런타임에서 구버전으로 전환하라는 뜻이 아니다.

1. 웹에 명시된 타입·상태·치수·동작·색이 첨부와 다르면 **웹으로 확정**한다. 08번 문서의 최종값/override를 따른다.
2. 웹에 없는 세부값과 추가 변형은 첨부 Figma로 보완한다. 보완 항목에 `[FIG]` 출처를 남기고, 해당 변형에서도 웹이 공통으로 지정한 축은 웹 규칙을 상속한다.
3. Figma 추출 부록은 원본 증거를 보존하기 위해 수정하지 않았다. 따라서 부록의 옛 값은 본문 최종값을 덮어쓸 수 없다. 코드 생성 시 웹 override를 마지막에 적용한다.
4. 첨부의 이전 값은 비교·변경 이력에만 남긴다. 이전 사양을 별도 제품 모드로 구현하는 것은 필수 범위가 아니다.
5. 웹 내부에서 표·라벨·도해가 서로 모순되는 경우에는 이것을 '웹 대 Figma' 충돌로 숨기지 않는다. 08번의 웹 내부 오류 판단과 보정 근거를 따르고, 확정할 수 없는 항목은 `[UNSPECIFIED]`로 남긴다.

대표적인 최종값은 Stepper 폭400, System Popup Medium 폭760, Spinner Date/Time 폭600/500, Window bar 길이140→100이다. 값의 단위·부가 치수는 해당 컴포넌트 장을 따른다. Figma의 대응 옛 값을 동시에 레이아웃에 강제하지 마라.

### 4.2 명시하지 않은 값과 가이드 오기

1. 본문 표의 설명이 해당 컴포넌트와 맞지 않거나 같은 표가 반복되면 도해와 Figma를 확인해, 의도된 상태와 모양을 분리하라. 이 묶음에 정리한 수정 판단을 따른다.
2. 상태가 표에만 있고 시각 변형이 없으면, 상태 의미와 콜백 제한은 구현하되 임의 색을 공식 토큰으로 만들지 않는다. 접근성/검증 상태와 교체 가능한 fallback 스타일을 제공하고 `[DECISION]`으로 기록한다.
3. 미정의 hover·focus ring·애니메이션 duration·dismiss timeout 등은 `PleosBehaviorDefaults`에 모아 교체 가능하게 한다. 확인된 공식 수치와 섞지 않는다.
4. 누락 때문에 해당 컴포넌트를 TODO로 남기지 않는다. 컴파일되고 조작 가능한 기본 구현을 만든 뒤, 확인이 필요한 항목을 `SPEC_DECISIONS.md`에 남긴다. 정확한 원본 복원을 하지 못한 부분을 완료했다고 주장하지 않는다.
5. 출처에 없는 브랜드 색상, 최신 SDK 버전, API 엔드포인트, 시스템 권한, 디자인 치수를 공식 규격처럼 추측해 추가하지 않는다. 미명시 사항은 명시된 `[DECISION]` 보완 기본값을 사용하고 출처·결정 목록에 남긴다.

## 5. 프로젝트와 빌드 기준

기존 프로젝트가 없으면 Gradle Kotlin DSL 멀티모듈 프로젝트를 생성하라. 기본 namespace는 소비자가 변경할 수 있는 `com.example.pleos.ui`를 사용한다. 브랜드의 공식 배포 좌표처럼 보이는 Maven group을 임의로 정하지 않는다.

| 모듈 | 책임 |
| --- | --- |
| `:pleos-tokens` | Color/typography/dimension/shape/motion token 모델, source-key mapping, 웹 최종 override·theme·form-factor resolver |
| `:pleos-compose` | 테마, 22개 컴포넌트와 하위 primitive, overlays, 공개 Compose API |
| `:pleos-aaos` | host가 연결하는 UX 제한/입력/알림 adapter와 capability 경계. Android car API 의존성은 이 모듈에 국한 |
| `:catalog` | 테마·폼팩터·상태 선택이 가능한 AAOS 데모, 샘플 데이터·접근성 데모 |

규모상 tokens와 compose를 한 Android library로 합칠 수는 있지만 AAOS 전용 의존성, 샘플 앱, 테스트의 경계는 유지하라. 소비 앱에 불필요한 차량 권한이나 인터넷 권한을 주입하지 않는다.

공식 시작 가이드에서 확인한 기준은 `minSdk >= 28`, Pleos Emulator의 Android API 34, Gradle 8.0 이상이다. **minSdk는 기본 28**로 둔다. compileSdk/targetSdk 및 Kotlin/AGP/Compose BOM은 기존 저장소·설치 SDK·의존성 캐시에서 호환되는 세트를 확인해 고정한다. API 34는 확인한 실행 환경 기준이며, 이를 배포 시점의 최신 targetSdk 정책이라고 단정하지 않는다. `+`, 무제한 최신 버전, 확인하지 않은 버전 조합을 쓰지 않는다.

네트워크 사용 불가 환경이라면 Gradle 캐시/로컬 Maven을 이용하라. 의존성이 없다면 정확한 미확보 좌표와 실패 로그를 남기고, 가능한 소스·토큰·문서 작업을 계속한다. 빌드 성공을 가장하기 위해 테스트를 삭제하거나 빈 함수를 넣지 않는다. Pleos Vehicle SDK는 UI 라이브러리의 필수 의존성이 아니다.

## 6. 공통 구현 원칙

- 모든 컴포넌트는 `Modifier`를 받고 외부로 끌어올린 상태를 기본으로 한다. `value`, `selected`, `checked`, `expanded`와 변경 콜백을 분리한다. 선택 상태와 focus/pressed는 다른 개념이다.
- `enabled=false` 및 `loading=true`의 입력 억제는 화면 모양, 키보드/rotary, 접근성 action 모두에서 일관되어야 한다. 재구성 중복 콜백이나 터치·키 이벤트 이중 처리를 막는다.
- 가이드에 실제 있는 조합을 명시적인 enum/sealed type/data class로 표현한다. Boolean을 무제한 교차시켜 무효 조합을 만들지 않는다. 문서의 상태 표현과 구현 API 이름은 매핑 표로 연결한다.
- 크기·패딩·반경·색·폰트·모션 상수는 해당 토큰 객체에서 읽는다. 포커스 표시와 터치 영역은 시각 크기와 구분한다. 글자 배율과 부모 constraints를 무시한 무조건 고정 박스를 사용하지 않는다.
- 터치, 키보드/D-pad, 접근성에 먼저 일관된 기본 동작을 구현한다. AAOS RotaryService 연동은 04번의 실제 플랫폼 제약을 따른다. Compose 키 입력 테스트만 통과하고 완전한 차량 rotary 지원을 주장하지 않는다.
- text/image/icon 슬롯, valueFormatter, 항목 stable key 등을 제공하되 명세 기본값을 보존한다. 순수 장식 아이콘에 중복 접근성 읽기를 만들지 않는다.
- overlay는 윈도 인셋·IME·안전 영역·화면 가장자리를 고려한다. Dialog/Popup의 dismiss, back, focus 복원과 timer lifecycle을 명시한다.
- 밝기 모드 변경, locale/RTL, 폼팩터/윈도 크기 변경에 대응한다. Figma 캔버스의 전체 데스크톱 좌표를 앱 절대좌표로 사용하지 않는다.
- 폰트/벡터 리소스는 동봉 자료를 사용한다. 모델이 아이콘을 임의로 그린 경우 원본과 같은 것처럼 표시하지 않는다. 폰트 라이선스 및 원본 출처를 결과물에 보존한다.

## 7. 실행 순서

1. **입력 점검과 설계 기준 고정**: 파일을 읽고 `IMPLEMENTATION_MATRIX.md`를 생성한다. 22개 ID마다 변형·상태·슬롯·토큰·관련 원본 노드·테스트를 매핑한다. 알려진 충돌/가정과 웹 최종값을 기록한다.
2. **빌드와 테마**: 빌드 가능한 skeleton, 모든 토큰 resolver, Light/Dark와 form-factor resolver, 폰트, core primitives를 구현한다. 본문 사양과 웹 override를 먼저 고정한다.
3. **Actions·Selections·Fields**: 버튼·키패드·선택·필드의 입력/semantics 및 모든 명세 변형을 구현한다. 공통 primitive를 기반으로 다음 컴포넌트를 확장한다.
4. **Controllers·Dropdown·Tabs·Navigation·Indicator·Bar**: drag/scroll/selection/focus/값 변경을 구현하고 관련 상태 테스트를 작성한다.
5. **Popup·Spinner·Notification·Toast·Widgets**: overlay host, picker, layout, timer와 dismiss 흐름을 구현한다. 라이브러리의 시각 요소와 OS가 통제하는 실제 시스템 동작을 adapter로 연결한다.
6. **카탈로그와 검증**: 모든 변형을 화면에 올리고 웹 최신 규격·테마·부모 constraints·글자 배율·입력 모드별 검증을 실행한다. 발견한 결함을 수정한다.
7. **납품**: 공개 API, AAR/샘플 빌드, 사용 문서, 범위 매트릭스, 검증 결과, 미확정 결정표를 남긴다. 실행 명령과 결과를 요약한다.

작업을 승인 대기 중인 계획으로 멈추지 말고 주어진 개발 환경에서 완료 가능한 작업을 계속하라. 답변 길이 제한이 있으면 실제 파일을 생성하고 변경 내용을 요약한다. 부분 구현을 전체 구현으로 표현하지 않는다.

## 8. 완료 판정

다음 조건이 모두 충족되어야 완료다.

- 22개 ID 각각에 공개 구현, 카탈로그 페이지, 명세상 모든 변형의 추적 행이 있다.
- 웹 최신 규격의 상태·전환·치수·slot·색상·폰트와 첨부 보완값이 반영되어 있고, 구버전 값으로 회귀하지 않는 테스트가 있다.
- 클릭/선택/입력/drag/wheel/dismiss와 disabled/loading의 부정 조건을 검증했다.
- 빈 Composable, 고정된 스크린샷 이미지로 UI 전체 대체, `TODO()`, 무반응 이벤트, 임의 Material 대체가 없다.
- Date/Time Spinner와 로딩 indicator가 분리되어 있고, popup/toast/notification 종류가 혼동되지 않는다.
- light/dark, 대표 landscape/portrait, resize, 긴 한국어/영어, RTL, fontScale, focus/semantics가 검증되었다.
- 실제 시스템 권한/서비스 없이도 순수 UI 모듈과 카탈로그의 mock mode가 실행된다.
- 빌드·테스트 로그와 실행 환경을 기록했다. 플랫폼 연동/스크린샷 비교 중 실행할 수 없었던 부분은 명시했다.

마지막 보고에는 **구현한 범위, 핵심 설계 선택, 실행한 검증과 결과, 아직 확인하지 못한 부분**을 구분해 작성하라.
