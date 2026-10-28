# 04 — Kotlin API, AAOS 통합, 상태 계약과 검증

이 장의 모듈/API/기본 동작 정책은 **[DECISION] 구현 지시**다. 플랫폼 사실의 출처는 마지막 절에 적었다. 디자인 수치는 01~03과 Figma 부록을 따른다. 여기의 API 이름이 Pleos에서 배포한 공식 SDK의 API라는 의미는 아니다.

## 1. 설계 경계

UI의 현재 값과 차량의 실제 상태를 분리하라. 라이브러리 컨트롤은 사용자의 의도를 콜백으로 전달한다. 실제 HVAC·차량·계정·네트워크 변경은 소비 앱이 수행하며, 비동기 결과를 다음 UI state로 돌려준다. UI가 차량 상태 변경에 성공했다고 스스로 확정하지 않는다.

`pleos-compose`는 일반 Android 기기에서도 preview/test할 수 있어야 한다. `android.car` 클래스, Pleos Vehicle SDK, privileged permission, 특정 DI/Navigation 프레임워크, Google Play services를 공용 UI API의 필수 조건으로 만들지 않는다. 실제 차량 연결은 `pleos-aaos` adapter나 소비 앱에서 주입한다.

공통 객체의 역할은 다음과 같다.

| 모델 | 책임 |
| --- | --- |
| `PleosTheme` | light/dark, form factor, 웹 최신 규격의 색·타입·shape·metrics·behavior 제공 |
| `PleosSpecVersion` (메타데이터) | 조사 스냅샷과 source mapping 식별. 옛 Figma로 전환하는 런타임 옵션이 아님 |
| `PleosFormFactor` | Standard17/Standard14_6/Legacy12_9/Wide/WideExtended/Waterfall, 첨부 확장15_6 |
| `PleosInputMode` | Touch, Keyboard, Rotary. 선택 상태와 독립 |
| `PleosCapabilities` | host가 허용한 UX/입력/시스템 기능, read-only snapshot |
| `PleosBehaviorDefaults` | 공식값이 없는 transition, focus indication, timeout, repeat 정책 |
| `PleosOverlayHostState` | 인앱 popup/toast/notification의 큐·수명·중복·dismiss 관리 |

`FormFactor`와 앱의 현재 `WindowSize`는 다른 값이다. 차량이 Wide여도 앱은 좁은 secondary window일 수 있다. 차종별 토큰 선택과 부모 constraints에 따른 reflow를 각각 수행한다. theme/form-factor 변경을 관찰 가능한 state로 전달하고 변경 시 UI가 갱신되게 하라.

## 2. 공개 API 계약

아래는 최소 기능 계약이다. Kotlin 기본 인자와 타입을 다듬을 수 있으나, 필요한 상태·slot·콜백을 삭제하지 않는다. API마다 KDoc에 단위, 기본값, 유효 조합, invalid 입력 처리, source ID를 설명한다. 매개변수에 넘긴 `Modifier`가 실제 root에 적용되어야 한다. 상세 장에 명시된 DateTimeSpinner, DropdownMenu/Item, WidgetHost/Card, NumericKey/KeyboardKey 등의 특화 API도 필수이며 공통 렌더러를 재사용하는 wrapper로 제공한다.

| 공개 요소 | 외부 상태/핵심 옵션 | 이벤트/slot 계약 |
| --- | --- | --- |
| `PleosBasicButton` | label, hierarchy, size, enabled, loading | onClick, leadingIcon, trailingIcon, loadingIndicator; 로딩 중 폭 유지 |
| `PleosToggleButton` | checked, size, enabled, floating | onCheckedChange(next), icon/label slots; 선택 commit은 host |
| `PleosTextButton` | label, size, enabled, loading | onClick, prefix/suffix icon; 문서상의 배치 |
| `PleosIconButton` | icon, contentDescription, Basic/Plain/Circle, size, enabled | onClick; decorative icon과 interactive label 구분 |
| `PleosKeypad` | key layout, enabledKeys, display state, 입력 모드 | `onKey(KeyAction)`; 숫자, 지움, 확인, 특수키를 typed action으로 구분 |
| `PleosWindowControlBar` | interaction state, orientation, enabled, spec metrics | drag/click callbacks; 실제 OS resize는 host adapter |
| `PleosAppControlBar` (첨부 지원 primitive) | interaction state, enabled | click/drag action; 웹 Bar의 독립 세 번째 타입으로 주장하지 않음 |
| `PleosScrollBar` | viewport extent, content extent, scroll offset, dragging 지원 | onScrollTo; thumb min/max·clamp·접근성 |
| `PleosSlider` | value, valueRange, variant, size, enabled, discrete step 정의 | onValueChange, onValueChangeFinished, label/valueFormatter, optional icons |
| `PleosStepper` | decimal-safe value, min/max, step, enabled | onValueChange, decrement/increment; step 0 금지 |
| `PleosPageIndicator` | pageCount, currentPage, spacing type, optional onPageSelected | 현재 항목 semantics, 비interactive 기본값 |
| `PleosDropdown` | items, selectedKey, expanded, enabled, size, single/action/switch row kind | onExpandedChange, onSelectionChange, itemSlot; 다중선택은 원본에 없는 선택적 확장 |
| `PleosTextField` | value, onValueChange, label/placeholder, enabled, readOnly, invalid/error, password | IME action, focus, leading/trailing/helper slots, 명시 keyboardOptions |
| `PleosNumberField` | 문자열 value, 입력규칙, enabled/readOnly/invalid, password mode | onValueChange, onSubmit; 선행0·미완성 편집값 보존 |
| `PleosPageNavigation` | level, title, navigation/search/dropdown state | onBack, actions, leading/trailing/title slots; back 부재 처리 |
| `PleosSystemPopup` | visible, size, content type, action arrangement, dismiss policy | onDismissRequest(reason), header/body/actions slots; focus trap/복원 |
| `PleosToastPopup` | visible, message, optional icon, margin, duration | onDismiss(reason); timer와 lifecycle. action은 원본에 없는 선택적 확장 |
| `PleosTabs` | items, selectedKey, type, size, enabled keys | onSelect, icon/label slots; 무효 조합 사전 검증 |
| `PleosCheckbox` | `ToggleableState`, enabled, optional validation semantics[DECISION] | onStateChange 또는 onClick; tri-state와 그룹 선택 모델 구분 |
| `PleosRadioButton` / `PleosRadioGroup` | selectedKey, items, enabled keys, validation state | onSelectionChange; 단일 선택, group semantics |
| `PleosSwitch` | checked, enabled, size, optional validation semantics[DECISION] | onCheckedChange; external state가 시각 상태의 기준 |
| `PleosDateSpinner` | LocalDate value, min/max date, locale, size | onDateChange, onSettled; 날짜 간 제약·월 길이·윤년 |
| `PleosTimeSpinner` | LocalTime value, 12/24h, minuteStep, locale, size | onTimeChange, onSettled; 오전/오후와12시 변환 |
| `PleosLoadingIndicator` (지원 primitive) | Linear/Tension, 크기, Light/Dark, animation enabled | 01번의 공식 원형·keyframe. Date/Time Spinner와 독립 |
| `PleosSystemNotificationCard` | title/body, leading imagery, CTA arrangement, optional metadata | onAction, onDismiss, content slots; 카드만으로 HUN 권한을 얻지 않음 |
| `PleosToastHost` | queue state, duration policy, safe-area placement | show/dismiss, 중복/우선순위 policy, 접근성 알림 |
| `PleosWidgetHost/Card` 및 제시 하위타입 | Show/Hidden×Enabled/Pressed, currentKey, title/action/information; loading/empty/error는 선택적[DECISION]확장 | widget-specific callbacks; 실제 AppWidget/차량 SDK 연결은 별도 |

### 2.1 API 형태 예시

아래 선언은 **계약 스케치**다. 실제 프로젝트에서는 완전한 함수 body와 필요한 타입을 구현하라. `...`, 빈 body, `TODO()`를 납품하지 않는다.

```kotlin
enum class PleosButtonSize { Large, Medium, Small }
enum class PleosButtonHierarchy { Primary, Secondary }

@Composable
fun PleosBasicButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: PleosButtonSize = PleosButtonSize.Medium,
    hierarchy: PleosButtonHierarchy = PleosButtonHierarchy.Primary,
    enabled: Boolean = true,
    loading: Boolean = false,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    interactionSource: MutableInteractionSource? = null,
)

@Composable
fun PleosSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    variant: PleosSliderVariant = PleosSliderVariant.Continuous,
    enabled: Boolean = true,
    onValueChangeFinished: (() -> Unit)? = null,
    valueFormatter: (Float) -> String = { it.toString() },
)

sealed interface PleosDismissReason {
    data object Back : PleosDismissReason
    data object Outside : PleosDismissReason
    data object Timeout : PleosDismissReason
    data object CloseAction : PleosDismissReason
    data class Action(val actionId: String) : PleosDismissReason
    data object Replaced : PleosDismissReason
}
```

이 스케치의 size/hierarchy enum은 본문상의 모든 변형을 검토한 후 완성한다. Basic button의 Primary는 `button/basic/*`, Secondary는 `button/filled/*` 토큰에 대응한다. 특정 컴포넌트에 없는 크기를 공통 enum에 맞추기 위해 가짜로 추가하지 않는다. `selected`, `expanded`, `checked`는 서로 다른 상태이며 하나의 Boolean 공용 모델로 합치지 않는다.

### 2.2 토큰 모델과 코드 생성

`ColorTokenId`, `MetricTokenId`, `TypographyTokenId`의 원본 식별자와 Kotlin 식별자 mapping을 유지한다. 변수명 `/`, `-`, 공백, 제어문자, 중복 이름을 단순 제거해 같은 identifier로 충돌시키지 않는다. 원본 `file + id/key + collection + mode`가 식별 기준이다.

변수의 alias는 같은 모드·같은 의미의 collection에서 재귀 해석하고 순환/미해결 참조를 검출한다. 폼팩터 모드명 앞의 원본 제어문자는 정규화 기록을 남겨 처리한다. 서로 다른 collection의 `Light`와 `Hyundai-Light`, `connect-l`과 `connect-s-14`를 이름이 비슷하다는 이유로 자동 병합하지 않는다.

색상 JSON의 `hexRGBA`는 `#RRGGBBAA`이다. Android의 `Color(0xAARRGGBB)` 또는 color resource로 변환할 때 순서를 바꾸어라. 가능한 한 float RGBA/alpha를 유지하고, 투명도를 중복 적용하지 않는다. fill paint의 alpha, paint opacity, node opacity, 조상 opacity의 곱을 실제 합성에 반영한다. 단순히 문자열 hex를 정수로 캐스팅하지 않는다.

토큰 변경으로 공개 API가 깨지지 않게, semantic token과 source alias를 분리한다. source에서 `normal`/`goast` 등의 오타를 발견해도 원본 키를 보존하고 공개 Kotlin 이름에서만 정리한다.

## 3. 상태와 이벤트 불변조건

### 3.1 공통 입력

| 상황 | 반드시 지킬 동작 |
| --- | --- |
| down → up inside | 단 한 번의 click/change callback |
| down → cancel/밖으로 이동 후 취소 | click이 발생하지 않고 pressed 해제 |
| pointer press 도중 disabled/loading 변경 | 진행 중 interaction 정리, 후속 commit 억제 |
| enabled=false | 터치/키/접근성 action 모두 비활성; 시각 상태만 회색인 구현 금지 |
| loading=true | 지원 버튼의 중복 실행 억제, loading semantics, 레이아웃 흔들림 최소화 |
| focus 이동 | 선택 상태를 자동 변경하지 않음. 문서가 선택 동작을 명시하는 경우만 예외 |
| 외부 값 변경 | 지체 없이 표시 갱신. 내부 remember 값으로 덮어쓰지 않음 |
| recomposition | 타이머/콜백이 의도 없이 재실행되지 않음 |
| 오류 | 원인 텍스트/semantics, 색만으로 의미를 전달하지 않음 |

Pressed는 실제 interaction source에서 관찰하고 preview/test에서만 제어 가능한 별도 presentation state를 허용한다. 호출자가 pressed를 수동으로 바꿔야 동작하는 버튼을 기본 API로 만들지 않는다.

### 3.2 Slider/Stepper/Scroll/Spinner

- Slider는 유한값·min≤max·유효 step을 검증한다. min==max는 고정값이며 모든 변경을 차단한다. `NaN`/infinity를 그래픽 좌표로 전달하지 않는다. 외부 범위를 벗어난 값 처리 방침을 API 문서에 고정한다.
- Slider의 step/snap 옵션에서 `steps`가 '중간 tick 수'인지 '구간 수'인지 명시한다. 값의 목록을 받는 방식이면 목록 기반으로 snap하고 숫자 간격을 잘못 가정하지 않는다.
- Centered slider는 중심/중립값과 knob 위치를 별도 모델로 둔다. 원본의 전체 gradient track을 유지하며 임의의 progress fill을 추가하지 않는다. RTL의 화면 방향과 값 증가 방향 정책을 검증한다.
- Stepper는 decimal step을 누적할 때 부동소수점 표시 오류가 없도록 정수 단위 또는 BigDecimal을 사용한다. 양 끝에서 해당 증감 버튼만 비활성화한다. long-press 반복이 원자료에 없으면 기본 off로 하고 지원 시 명시 옵션으로 둔다.
- Scrollbar는 `content <= viewport`일 때 처리, thumb 최소 길이, 0으로 나누기, offset clamp를 정의한다. lazy list의 추정 길이는 정확한 pixel 길이라고 표현하지 않는다.
- Date Spinner는 1월31일→2월, 윤년2월29일, min/max date 제한을 안전하게 조정한다. 잘못된 LocalDate를 잠시 생성하지 않는다. 월/일 변경을 하나의 일관된 값으로 emit한다.
- Time Spinner는 12 AM=00, 12 PM=12를 정확히 처리한다. minuteStep이60을 나누지 못하는 정책, 끝값 snap을 문서화한다. 입력 중 값과 snap 완료 이벤트를 구분한다.
- Wheel의 읽기 순서·선택값 semantics·증가/감소 action을 제공한다. 손가락 fling이 필수인 유일한 조작 경로가 되지 않게 한다.

### 3.3 입력 필드

IME 조합 중 한글 자모가 유실되지 않게 composition 범위를 보존한다. 커서 이동·선택·붙여넣기·삭제·하드웨어 입력을 검증한다. `onValueChange`에서 무조건 포맷해 cursor를 끝으로 점프시키지 않는다.

Number Field는 값의 의미와 표시 문자열을 분리한다. PIN/전화/인증코드는 수학적 정수로 변환하지 않는다. 길이·허용 문자·최솟값/최댓값 검증을 구분한다. locale별 소수점 처리는 숫자 편집 모드에서만 제공한다. 비밀번호 필드의 값은 로그/semantics에 평문 노출하지 않는다.

readOnly와 disabled는 다르다. readOnly는 필요하면 focus·선택·복사 가능하지만 값 변경은 불가하다. password toggle/clear button 등 trailing action도 parent의 enabled 정책을 따른다.

## 4. AAOS 통합

### 4.1 플랫폼과 배포 구분

AAOS에서 실행되는 앱 내부 UI 라이브러리를 만든다. Android Auto의 호스트 템플릿 UI와 동일한 API라고 가정하지 않는다. Car App Library의 템플릿에서 임의 Compose 화면을 그대로 렌더링할 수 있다고 설명하지 않는다.

시각적인 `SystemNotificationCard`나 `SystemPopup`을 구현하는 것과, OS의 실제 heads-up notification 또는 시스템 전역 overlay를 생성하는 것은 별개다. 일반 앱은 시스템 권한을 임의로 획득할 수 없다. 라이브러리에서는 인앱 host와 명시적인 adapter 인터페이스를 제공한다. 실제 Android Notification은 소비 앱이 notification channel·권한·OS 정책을 통해 등록하며, 시스템에서 최종 렌더링한 모습이 커스텀 카드와 같다고 보장하지 않는다.

Widgets 역시 재사용 가능한 Compose UI·카탈로그 구현과 실제 런처/AppWidget/Pleos host 통합을 구분한다. RemoteViews/Glance/Pleos 호스트가 요구하는 표현 제약을 확인하지 않은 채 일반 Composable을 그대로 배포 가능한 OS widget이라고 주장하지 않는다. 데이터/액션 모델과 렌더러를 분리해 실제 host adapter가 추가될 수 있게 하라.

### 4.2 UX 제한 adapter

호스트가 `CarUxRestrictionsManager` 등 승인된 플랫폼 경로로 제공한 제한 상태를 사용하라. 기어/속도 값만 보고 '운전 중 제한'을 재구성하지 않는다. 디스플레이·OEM·시장별 정책이 다를 수 있다.

순수 UI 모듈에는 아래 의미의 `PleosCapabilities`를 주입한다: 현재 허용된 텍스트 입력, 복잡한 설정/목록 조작, 애니메이션/영상, 시스템 알림 통합. 이들 flag의 정확한 플랫폼 매핑은 host 정책이며 UI 라이브러리가 임의 지정하지 않는다. 앱 시작 전까지 제한 정보가 없을 때의 보수적인 기본값과 연결 실패 상태를 문서화한다.

설정 변경 시 즉시 재평가하고, 진행 중인 제한 대상 상호작용을 정리하며, 해제 뒤 재활성화한다. 제한으로 비활성화된 경우 이유를 접근 가능한 메시지로 전달할 수 있게 한다. 라이브러리가 `distractionOptimized=true`를 consuming app manifest에 자동으로 추가하지 않는다. 인증·배포 판단은 UI 라이브러리 범위가 아니다.

### 4.3 키보드, D-pad와 RotaryService

1. 모든 interactive 요소에 focusable/semantics와 시각적 focus 표시를 제공한다. 화면/탭/다이얼로그 이동 후 focus 시작점과 복원 위치를 정한다.
2. DPAD_CENTER/Enter 활성화, 방향 탐색, Back 처리를 구현하고 disabled 요소의 선택 불가를 보장한다. center down/up와 click listener를 중복 실행하지 않는다.
3. AAOS RotaryService는 View/접근성 계층과 car-ui integration의 영향을 받는다. AOSP 지침의 `FocusParkingView`, `FocusArea`는 실제 호스트와 지원 car-ui-library에서 구성한다. FocusArea를 중첩하지 않는다. toolbar·탭·본문 등 탐색 구역을 정의한다.
4. **하나의 ComposeView에 여러 virtual node가 있다는 이유만으로 모든 OEM RotaryService에서 개별 focus가 작동한다고 가정하지 않는다.** 실제 대상 emulator/기기에서 rotation/nudge/center/back이 컴포넌트별로 동작하는지 검증한다. 필요한 경우 View-host/bridge renderer 또는 호스트 승인 input adapter를 사용하고 제한을 문서화한다.
5. Slider/Spinner의 direct manipulation은 탐색 모드와 편집 모드를 분리한다. center로 편집 진입, rotation으로 값 조정, back/confirm으로 종료하고 focus를 유지한다. 하드웨어 이벤트 형식은 실제 호스트가 전달한 경로에 맞춘다. Wear OS용 rotary modifier만 적용하고 AAOS 검증을 대신하지 않는다.
6. 터치로 전환하면 필요 없는 focus highlight를 제거하되 값/선택 상태를 바꾸지 않는다. OS가 처리하는 Home나 시스템 전체 제스처를 가로채지 않는다.

전용 car-ui 라이브러리나 장치가 없으면 keyboard/D-pad 결과와 rotary 미검증을 구분해 납품한다. UI의 나머지 구현을 중단할 이유는 아니다.

### 4.4 윈도와 생명주기

실제 Activity의 window bounds, `WindowInsets`, IME, cutout/safe-area를 사용한다. 전체 차량 display 해상도를 앱 가용 크기로 가정하지 않는다. portrait/landscape 및 split 비율 변경에 따라 레이아웃이 재계산되어야 한다.

host의 lifecycle이 inactive일 때 timer/animation/작업을 suspend 또는 종료하는 정책을 명시한다. `Car` 연결·listener는 사용 종료 시 해제한다. focus를 이동시킨 System Popup 또는 Dropdown이 닫히면 anchor로 focus를 복원하며, anchor가 사라진 경우 합리적인 fallback을 선택한다. 비모달 Toast Popup/Toast는 focus를 강제로 이동하거나 복원하지 않는다. 재구성·화면 회전마다 같은 알림이 재발생하지 않도록 이벤트와 현재 상태를 분리한다.

## 5. 접근성 계약

| 요소 | 필수 semantics/상호작용 |
| --- | --- |
| Button/Icon/Text/Keypad | role=Button, 명확한 label, enabled/disabled, 필요 시 stateDescription |
| Checkbox | checked/unchecked/indeterminate, toggleable, 전체 label row의 적절한 클릭 영역 |
| Radio group | selectableGroup, 각 item의 selected, role=RadioButton, 유일한 선택 |
| Switch | toggleable state, role=Switch, label과 상태의 읽기 |
| Tabs | tab 선택/비선택, collection 정보, 선택된 항목과 focus 독립 |
| Slider | 현재값/범위/step, progress semantics, SetProgress 및 증가·감소 지원 |
| Stepper | 현재값 + 감소/증가 두 action, 한계값에서 부정 action 억제 |
| Field | editable/readOnly/disabled, label/placeholder/helper/error, password 보호 |
| Dropdown | 선택값·확장 상태, 메뉴 item 읽기 순서, 닫힘과 focus 복원 |
| Date/Time wheel | 선택값/열의 의미, 증가·감소/스크롤 action, 시간 형식 설명 |
| System Popup(모달) | pane 제목, modal 영역, focus 이동/복원, 명시 close/back 정책 |
| Toast Popup/Toast/Notification | 필요한 live announcement; 짧은 timer로 읽기 끊김을 강요하지 않는 접근성 시간 정책 |
| Indicator | 페이지 n/m; 비interactive 점을 각각 불필요한 focus stop으로 만들지 않음 |

화면에 있는 텍스트를 contentDescription으로 다시 읽게 하여 중복 announcement를 만들지 않는다. 장식 아이콘은 null description, 단독 조작 아이콘은 필수 label을 받게 한다. error/checked/selected를 색상 하나만으로 전달하지 않는다.

가이드상의 시각 크기가 작은 아이콘/checkbox/radio/scroll thumb는 주변 패딩/row로 조작 영역을 확보한다. **[DECISION] 테스트 기본 목표는 최소48dp 터치 영역**이며, 더 큰 차량용 hit area가 지정된 경우 해당 값을 우선한다. 인접 요소와 확장 영역이 겹치지 않게 한다. 화면 전체를 Canvas 하나로 그려 접근성 노드를 하나로 합치지 않는다.

## 6. 카탈로그 앱

카탈로그에는 22개 ID의 탐색, 검색/필터, Light/Dark, form-factor, locale/RTL, fontScale, enabled/loading/selected/error controls를 제공한다. 잘못된 조합은 선택할 수 없게 하고 이유를 표시한다. 웹과 첨부가 다른 항목은 최종 웹 값과 출처를 설명한다.

각 컴포넌트 화면에서 다음을 확인할 수 있어야 한다.

- 실제 public API 호출 예제와 사용한 token ID.
- 모든 공식 종류/크기/상태와 첨부에 추가된 변형의 비교.
- hover/focus 등 구현용 확장 상태의 분명한 표시.
- 이벤트 로그, 입력값/선택값의 변화, min/max·빈 목록·긴 텍스트 예제.
- popup/dropdown의 화면 가장자리, IME 열린 상태, narrow-window 동작.
- 제한된 UX 모드 및 플랫폼 서비스가 없는 mock mode.

실제 시스템 권한 없이 UI 카드·위젯·차량 컨트롤을 시연할 수 있게 한다. mock 데이터를 실제 차량 데이터처럼 설명하지 않는다.

## 7. 검증 계획과 합격 조건

### 7.1 정적/빌드 검증

선택한 toolchain의 버전 catalog, Gradle wrapper, Kotlin options를 고정한다. Android library와 catalog에 대해 실제 assemble, lint 및 관련 단위/UI 테스트를 수행한다. 공개 API를 소비하는 최소 별도 예제 또는 catalog로 타입/리소스/manifest 충돌을 확인한다. 필요 없는 manifest 권한·서비스가 합쳐지지 않는지 확인한다.

### 7.2 상태/계산 검증

| 테스트군 | 필수 사례 |
| --- | --- |
| Tokens | 모든 참조 resolve, 모드별 차이, alpha 순서·중복 적용, source-key 충돌, 웹 override 우선순위 |
| Button | 정상1회 click, cancel0회, disabled0회, loading0회, 선택값 외부 반영 |
| Selection | tri-state, radio 유일선택, switch on/off, 그룹비활성, focus와선택 분리 |
| Slider/Stepper | min/max, snap, centered knob/gradient, decimal 누적, invalid range, RTL 방향 |
| Fields | 한글 IME composition, 커서·붙여넣기, leading0, password, readOnly, invalid |
| Dropdown/Tabs | empty/single/긴목록, selected key 삭제, expanded dismiss, 무효 tab count |
| Spinner | 윤년, 월 경계, date bound, 오전/오후12시, minuteStep, snap 완료 콜백 |
| Overlay | back/outside/action/timeout별 결과, timer 재시작 기준, 중복요청, lifecycle 종료, focus 복원 |
| Layout | 좁은 부모 constraints, 큰 fontScale, 긴문자열, safe-area/IME, resize, 양방향 텍스트 |
| AAOS | 제한 상태 전환, 서비스 미연결, touch↔keyboard/rotary, 실제 RotaryService 결과 분리 |

UI 구현을 그대로 복제하는 테스트 대신 사용자 관점의 동작과 경계값을 검증하라. 불가 조합까지 모두 Cartesian product로 테스트할 필요는 없다. 모든 공식 변형의 기본/disabled/선택상태와 대표 결합을 우선한다.

### 7.3 시각 검증

01번의 실제 앱 window 크기를 기준으로 대표 스크린샷을 생성한다. Light/Dark × 명세의 각 타입/크기/핵심 상태를 cover하는 screenshot matrix를 만든다. 웹 최신값을 기준으로 하며, 동작이 같은 상태의 모든 폼팩터 조합을 무제한 증식시키지 말고 토큰이 실제 달라지는 경계를 선택한다.

웹 최종 숫자와 웹에서 규정하지 않은 부분의 Figma 보완값 및 동봉 벡터를 기하 기준으로 사용한다. 웹/원본 이미지를 직접 비교할 수 없는 환경에서는 'pixel perfect'라고 주장하지 않는다. 생성한 최초 스크린샷을 스스로 golden으로 저장하고 원본 일치 검증을 했다고 표현하지 않는다. 기준 이미지가 있는 경우 같은 density/font/spec/locale로 맞추고 crop·anti-aliasing 차이를 고려한다.

**[DECISION] 기하 검증 목표**: 정수 치수 토큰은 정확히 일치, 렌더링 반올림은1 물리pixel 이내를 기본 허용오차로 둔다. 글리프 rasterization이나 shadow blur의 플랫폼 차이는 영역별로 검토한다. 공통 pixel-diff 퍼센트 하나만으로 텍스트 잘림·상태 색 오류를 통과시키지 않는다.

### 7.4 결과 문서

`IMPLEMENTATION_MATRIX.md`의 각 행에 구현 위치, 최종 source 값, 웹 우선 적용 여부, 카탈로그 예제, 검증 상태를 기록한다. `SPEC_DECISIONS.md`에는 미정의 값·선택 이유·교체점·확인할 담당 범위를 기록한다. `VERIFICATION.md`에는 실제 실행 명령, 환경, pass/fail, 실행하지 못한 검증과 이유를 기록한다.

## 8. 플랫폼 참고 출처

아래 URL의 핵심 원칙은 위 본문에 이미 반영했다. 구현 중 링크 열람을 요구하지 않는다.

- Pleos 개발 시작: <https://document.pleos.ai/docs/pleos-only/getting-started> — minSdk28/API34 실행 기준.
- Pleos 개발 환경: <https://document.pleos.ai/docs/connect/guide/getting-started/application-development/setup-connect-sdk-emulator> — Gradle8 이상, Kotlin/Java, 에뮬레이터 기준.
- AOSP rotary: <https://source.android.com/docs/automotive/hmi/rotary_controller/app_developers> — View focus, FocusArea/FocusParkingView, 실제 장치 검증.
- AAOS parked-app 통합: <https://developer.android.com/training/cars/parked/automotive-os> — UX restrictions, lifecycle, window insets.
- Compose semantics: <https://developer.android.com/develop/ui/compose/accessibility/semantics> — role/state/progress/collection/error 의미론.
