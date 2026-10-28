# 규격 결정

최우선 기준은 사용자의 현행 요청이며, 이어서 동봉 00~08과 부록을 적용합니다. 샘플·데모·카탈로그 요구는 제외합니다. 웹/Figma 추가 접속을 하지 않았습니다. `WebLatest20261028`은 조사 메타데이터이며 구버전 전환 옵션을 제공하지 않습니다.

| 항목 | 적용 | 구분과 근거 |
| --- | --- | --- |
| 모듈 | 초기 app 제거, tokens/compose/aaos 세 Android Library | 사용자 확정 |
| 버전 | AGP 9.4.1·Gradle 9.6.0 유지, 내장 Kotlin 2.2.10·동일 Compose plugin·UI 1.9.0 | 로컬 AGP POM 및 실제 컴파일로 확인 |
| minSdk | 28 | 사용자 확정, compileSdk 37 유지 |
| 색상 | 웹 149행을 마지막에 적용 | 01·08; 11개 충돌 회귀 테스트 |
| slash 별칭 | 명시적 source mapping 우선, 웹 단독 행 namespace 별칭 보완 | 10_COLOR_TOKEN_MAPPING 및 tools/token_aliases.json; 단순 치환만으로 연결하지 않음 |
| divider | 주 collection 2:15157의 5/10/20% | JSON supplementalDividers의 provenance 사용 |
| 알파 | 원본 float와 raw RGBA를 보존, Compose sRGB 렌더 시 8비트 반올림 | 값 검사 허용오차 1/255; 재차 alpha를 곱하지 않음 |
| Stepper | 폭 400, 중앙 영역 112, 112+32+112+32+112 | 웹 최신; 420/148 미적용 |
| Popup | Medium 760, Large 1200 | 웹 최신; Extended도 폭 상속 |
| Popup Extended | padding/radius 40, gap 33, 버튼 최소 높이 84, header 아래 12 | 03 §4; 폰트는 현재 Asta Sans와 공개 메트릭 사용 |
| Spinner | Date 600, Time 500, 열 간격 24 | 웹 최신; DateTime 합성 1124 |
| 큰 글자 Spinner | 선택 글자의 sp 줄높이를 기준으로 행·패널을 확장, 제한된 높이에서는 실제 viewport 중심 정렬 | 기본 배율의 웹 치수 유지 |
| Spinner Medium | 높이 288·행 96의 첨부 보완 | 별도 웹 크기로 주장하지 않음 |
| Window bar | 길이 140→100, alpha .2→.5, disabled 0, 300ms cubic(.16,1,.3,1) | 웹 최신; 160→80과 alpha .4 미적용 |
| Scroll bar | pressed basic_900, enabled alpha 200 | 웹 최신 |
| Toggle Small disabled | 모든 크기 button/switch/disabled | 웹 공통; 원본 한 노드의 예외 미적용 |
| Icon Large | 100×100, icon 64, radius 24 | 명시된 보완 기본값; IconButtonMetrics로 교체 |
| Toggle floating | checked와 독립, On에 shadow 허용 | 명시된 보완 정책 |
| Toast Light | #131417, alpha .84, 흰색 문자 | 웹 최신 |
| Toast Dark | #E0E1E6, #131417 문자 | 웹 공백의 Figma 보완 |
| Notification CTA | 일반 Single/Horizontal/Vertical 모두 Basic | 웹 최신; Call 전용 색과 상태는 별도 |
| scoped text | Light의 #1B1C1E 지정은 Field placeholder·Nav subtitle·Popup/Notification 설명·Tabs·Spinner에만 적용 | 전역 text 토큰을 바꾸지 않음 |
| 폰트 | 동봉 Asta Sans, weight 300~800 명시 | 옛 Manrope·42dot·브랜드 폰트를 현재 UI에 적용하지 않음 |
| 글자 배율 | 시스템 sp 사용, fontScale 강제 고정 없음 | 큰 배율에서는 높이 확장·재배치·스크롤 |
| 폼팩터 | S/L/W/Waterfall의 개별 바인딩 사용 | 전체 비율 축소 없음; 바인딩 없는 값은 1u=1dp의 기본값 |
| S-14.6/S-15.6 | 컴포넌트 assets에 해당 모드가 없어 S 사용, Display collection 별도 조회 | 임의 보간 없음; 호스트가 overrides 제공 가능 |
| 모드 정규화 | U+0008 제거, 파일·collection 분리 | raw JSON의 modeSelections와 원본 mode ID를 AAR에 보존 |
| line height | 직접 line_height_sp가 없으면 같은 기준값의 size_sp 모드값 보완, 없으면 원본 기준값 | 구현 보완; PleosMetrics에서 교체 가능 |
| 작은 아이콘 | 실제 원본 TL 반경을 사용 | 원본 W Small BR 1613 오기는 감사 데이터에만 보존 |
| shadow | source offset·blur·alpha 다중 레이어, software bitmap | API28 fallback; 캐시당 최대 150만 픽셀, 큰 mask는 샘플링; 공식 renderer와 blur 일치 미검증 |
| focus | 4dp·바깥 간격 4dp, positive 색 | 명시된 구현 기본값 |
| hit target | 최소 48dp, 원본의 더 큰 영역 우선 | 명시된 구현 기본값 |
| 미정의 전환 | pressed 120ms·expand 200ms 정책 노출, reduced motion 지원 | 웹 Loading/Window bar 모션을 대체하지 않음 |
| Loading | 30fps, 0~60 keyframe, op61; Linear/Tension | 라이프사이클 비활성·모션 제한에서는 정적 busy 표현 |
| Numeric layout | colgap24, rowgap40, padding48, 기본 744×648 | 웹 측정+명시된 보완 기본값 |
| QWERTY layout | gap10, side/bottom24, handle top56·없으면24, 공간키 잔여 폭 | 측정+보완; 좁은 창에서는 가로 스크롤 |
| 한글·음성 | typed key 이벤트 및 TextInputAdapter로 호스트에 위임 | 자모 연결 reducer를 한글 IME로 주장하지 않음 |
| TextField disabled | readOnly 표면·기본 border·quaternary text | 명시된 보완 스타일 |
| 입력 커서 | TextField 3×32, NumberField 4×48의 실제 사각형; 기본은 정적 표시 | 원본 치수, 스크롤 여백도 dp→px 변환 적용; blink는 미정의 보완 정책 |
| 비밀번호 | 표시 변환과 InputText 의미론 모두 마스킹 | Compose 1.9의 InputText 원문 노출을 계측에서 발견하여 보완 |
| Number Field | ASCII 0~9, digitCount 초과 입력 자름, 외부 무효 값 예외 | 선행 0·부분 입력 문자열 유지; 기존 칸 탭은 한 자리 선택·덮어쓰기, 완성 전이에서 한 번 요청 |
| Slider | 유한 범위·유효 step 검사, 외부 값 clamp, max 끝점 도달 허용 | step은 값 간격; Float가 표현할 수 없는 전체 span은 거부 |
| Stepper | BigDecimal, 외부 값 범위 clamp | 부동소수점 누적 없음; 반복 입력 기능은 기본 제공하지 않음 |
| Date | 기본 범위 1900-01-01~2100-12-31, 외부 범위 초과는 표시만 clamp | 구현 기본값; min/max를 공개 인자로 교체 |
| Time | 60을 나누는 minuteStep만 허용, 초·나노초 제거, 비정렬 분은 아래 격자로 표시 | 입력을 자동으로 emit하지 않음; 조정한 값만 요청 |
| Wheel | 유한·기본 wrap off, 월말/윤년 clamp | 호스트 거부 시 외부 값으로 복원, 동기·지연 확정 후 onSettled |
| Dropdown | 투명한 앱 Dialog에 anchor 정렬, 일반 선택/Action/Footer 후 닫힘, Switch는 유지 | policy 인자로 변경 가능; 비활성 전환은 Replaced 사유로 닫기 요청 |
| Popup | confirm/cancel의 business callback이 표시 상태를 결정 | Back·Outside·CloseAction은 별도 사유; restoreFocusRequester 선택 가능 |
| Toast 큐 | FIFO·대기 최대3, 동일 ID 갱신, overflow 시 가장 오래된 대기 교체 | Short 3000ms·Long 5000ms, 접근성 timeout 우선 |
| Toast 수명 | host STARTED 이상에서만 타이머 실행, 중지 중 남은 시간 보존 | item ID+generation으로 이전 타이머 결과 차단 |
| Widget | 앱 내부 HMI 카드, Show/Hidden 상태와 current key는 호스트 소유 | hidden 160×64·hit240×80·hide거리 .35; 실제 OS widget 배포 아님 |
| AAOS 기본 정책 | 제한 정보 없으면 입력·복잡한 조작·모션·OS 알림을 차단 | 호스트 mapper 필수, 속도·기어로 재구성하지 않음 |
| Rotary | 정규화 이벤트·편집 세션만 제공 | OEM RotaryService·FocusArea/FocusParkingView 통합은 호스트 책임 |
| Manifest | 차량·인터넷 권한·서비스·distractionOptimized 없음 | android.car는 aaos에서만 optional uses-library |

## 명세 재대조 후 보정

- `PleosNavigationType.Search`와 `PleosSearchNavigation`은 첨부 노드 67:27652의 추가 원형입니다. `PleosNavigationMenu`·`PleosNavigationDropdown`은 제목 메뉴의 40/52 서체·28 화살표·열림 상태·포커스 복원을 제공합니다. Search의 `fieldModifier`로 호스트가 포커스와 IME 경로를 연결합니다.
- Popup은 header/body/actions를 분리합니다. action을 먼저 측정하고 body가 남은 높이를 사용합니다. 0 높이 영역은 간격 계산에서 제외합니다. `bodyScroll=true`는 일반 콘텐츠용 기본 스크롤이며, LazyColumn처럼 자체 스크롤을 소유한 body에는 `false`를 전달합니다. confirm을 null로 전달하면 숨깁니다. header가 긴 경우 body에 남길 공간은 `min(96dp, action 측정 후 잔여 높이 / 2)`입니다. 96dp는 구현 보완 기본값이며 공식 Popup 치수로 주장하지 않습니다. action 전체 높이보다 창이 작으면 action 영역 자체의 세로 스크롤로 모든 버튼에 접근할 수 있습니다.
- Dropdown은 기본 선호 폭 600dp를 사용하되 호스트의 명시적 폭·상위 제약을 따릅니다. `preferredWidth=null`이면 이 선호 폭을 적용하지 않습니다. 메뉴는 실제 anchor 폭에 맞추며 더 이상 600dp를 최대 폭으로 제한하지 않습니다.
- Toast의 최종 최대 폭 792와 텍스트 최대 폭 712는 웹 우선으로 유지합니다. `popup/toast/max_width`의 Figma 과거 L696/W760 값은 다시 적용하지 않습니다. 내부 아이콘은 원본 모드 토큰, 외부 margin은 항상 24dp입니다. `popup/toast/icon_gap`, `popup/toast/text_max_width`는 출처를 연결한 의미 단위 주입점이며 새 원본 Figma 변수라고 주장하지 않습니다.
- Spinner Large는 웹의 384/88·fade60과 600/500·열120/200/140·gap24를 유지합니다. 첨부 Medium의 높이·행·fade는 개별 모드값을 사용합니다. 글자/locale 때문에 열 폭이 부족하면 실제 글자 측정으로 확장하고 viewport 스크롤을 유지합니다. panelWidth는 호스트 확장 옵션입니다.
- `controller/slider/gradient_start/end`는 원문에 이름이 없는 구현 파생 토큰입니다. 각각 `informative/positive`, `regulation/red`의 모드값에 alpha .9를 적용하고 별도 override를 허용합니다. Number형 값 영역은 67:24501/24502의 75+38 폭·60/68 Bold·40/64 ExtraBold를 적용합니다. 사용자 단위/장문 표현은 `valueContent`로 교체할 수 있습니다.
- `controller/slider/continuous/width_large/width_medium`의 기본 808/560, `controller/slider/minimum_touch_height`의 64, `controller/slider/focus_radius`의 24는 별도 원본 모드 변수가 없는 치수의 구현 주입점입니다. 모드 비율을 추정하여 확대·축소하지 않으며 호스트의 `PleosMetrics` override를 적용합니다.
- Widget의 수직 숨김은 Handle drag에만 연결합니다. Show Handle의 터치 탭은 상태를 바꾸지 않습니다. 키보드·접근성 대체 action은 제공합니다. Hidden 중 이전/다음 요청은 차단하여 currentKey를 보존합니다. 별도 WidgetTitleTypography 24/32와 pitch18을 적용합니다.
- Window bar는 click 콜백이 없는 기본형에서 Enter로 편집에 진입하고 방향키 1회에 48dp를 pixel로 변환하여 host의 start/delta/end를 호출합니다. Escape/Back으로 나옵니다. 직접 조절 Scrollbar도 Enter/방향키/Escape 경로를 제공합니다. 이 증분은 보완 입력 정책이며 OEM rotary detent 규격이 아닙니다.
- 빈 Toast 메시지는 같은 ID의 항목을 이벤트 없이 제거합니다. `icon` 람다의 재구성만으로 generation과 timer를 다시 시작하지 않습니다. `PleosToast(message, ...)`는 공유 surface를 직접 제공합니다.

검증 상태와 남은 플랫폼·시각 검증은 VERIFICATION.md에 별도로 기록합니다. 미검증 항목을 원본 일치나 실차 호환으로 표현하지 않습니다.

## 공개 Maven 배포

사용자가 Maven Central 배포와 Apache-2.0 적용을 승인했습니다. 인증된 네임스페이스 `io.github.punch5545`와 고정 버전 `0.1.0`을 공개 좌표로 사용합니다. 기존 Kotlin 패키지는 유지합니다. AGP·Gradle·Kotlin·Compose 버전은 변경하지 않았습니다. 라이선스 자산 경로는 로컬 AGP 9.4.1 소스에서 확인한 공개 `LibraryExtension` 타입을 사용하여 legacy SourceSet bridge의 타입 불일치를 피합니다. 동봉 원본 자산에는 코드 라이선스를 새로 부여하지 않습니다.
