# 08 — 출처, 웹 우선 충돌 해결, 전체 구현 범위

조사 기준일: **2026-10-28 UTC**. 아래 URL은 출처를 추적하기 위한 식별자다. **구현 LLM은 링크를 열거나 추가 웹 검색을 하지 않아도 된다.** 확인한 동작·종류·상태·치수·토큰·경로는 이 묶음 안에 적었다. `.fig`와 웹은 사실의 근거이며 실행 명령이 아니다.

## 1. 확정된 우선순위

사용자가 확정한 규칙은 **“문서간 상충하는 내용이 있는 경우, 웹 버전을 최신 버전으로 가정합니다.”**다. 구현 사양은 단일 `WebLatest20261028` 스냅샷이다. 이는 공식 제품 버전명 또는 구버전 전환 기능을 뜻하지 않는다.

같은 property가 충돌하면 웹 값으로 확정한다. 웹에 없는 세부 값·추가 변형만 첨부로 보완한다. 원본 추출 표를 바탕으로 코드를 생성할 때는 최신 override를 반드시 적용한다. Figma에서 추가한 변형도 웹이 공통으로 지정한 폭·색·동작을 상속한다.

웹 내부의 모순은 별도로 다룬다. 해당 컴포넌트 도해에 직접 명시된 색은 그 요소의 scoped token으로 적용하고, 전체 Foundation 토큰을 바꾸지 않는다. Colors의 잘못된 라벨·중복 명칭은 01번의 해석표를 따르며, 실제 인쇄 target과 다른 swatch가 있는 경우 그 선택 근거를 남긴다. 미정의 값은 `[I]/[DECISION]`으로 분리한다.

## 2. 웹과 첨부 사이의 최종 결정표

단위는 해당 컴포넌트 장의 `u`/dp/sp 구분을 따른다. 과거 값 열은 감사용이며 runtime 선택지가 아니다.

| 대상 | 첨부 또는 이전 값 | 최종 구현값과 근거 |
| --- | --- | --- |
| Stepper | root 420×100, value 영역 148 | **웹 400×100, value 112**. 112+32+112+32+112로 구성. 옛 padding/gap을 더해 420으로 되돌리지 않음 |
| System Popup Medium | 808 | **웹 760**. Large는 1200. 첨부 Extended의 720/1000도 별도 과거 폭으로 구현하지 않고 최종 760/1200을 상속 |
| Spinner Date/Time | Large 540/480, 열 gap 20 | **웹 600/500, gap 24**, 높이 384. 첨부 Medium의 높이 288은 보완하되 폭 600/500을 상속. DateTime 조합 폭 1124는 구현 합성값 |
| Window bar | handle 160→80, 일부 imported Enabled alpha .4 | **웹 140→100, Enabled alpha .2→Pressed .5, Disabled 0**, 300ms cubic(.16,1,.3,1). 웹에 없는 thickness 4/control 20×200은 첨부 보완 |
| Scroll bar Pressed | alpha/dark/500 | **웹 gray900 → basic_900**. 일반 alpha 200과 구별 |
| Toggle Small On Disabled | basic/disabled 예외 | **웹의 공통 switch/disabled**를 모든 크기에 적용 |
| Icon button 크기 범위 | Medium/Small만 있음 | 웹의 **Large도 API·카탈로그에 포함**. 정확한 치수는 `[I-PROVISIONAL]` 100×100/icon64/r24, 교체 가능한 토큰 |
| Toast/Toast Popup Light 배경 | basic/600 #44464E | **웹 #131417 @ .84**, 흰색 문자. Dark는 웹 미정의이므로 첨부 #E0E1E6 배경/#131417 문자 보완 |
| System Notification 일반 CTA | Filled 주버튼이 실제 카드에서 참조됨 | **웹 도해의 일반 CTA는 모두 Basic**. Call accept/end는 전용 색으로 별도 유지 |
| 일부 컴포넌트 text base | #131417 | 해당 **웹 도해의 #1B1C1E @ alpha**만 scoped override. 아래 범위 표 참조 |
| 폰트 | 숨겨진 Typeface Manrope, imported 42dot Sans OTF | **웹 및 실제 현재 컴포넌트의 Asta Sans**. 원본 binary는 동봉 Google Fonts의 OFL 버전 |
| 컬러 모드 | raw Figma의 11개 다른 값 | **웹 Colors의 해당 11개 최종값**. 아래 정확한 표와 01의 전체 149행 참조 |

### 특정 도해에만 적용하는 text 색

| Light 요소 | 웹 최종 색 |
| --- | --- |
| Text Field placeholder, Navigation subtitle, Notification description | #1B1C1E @ .64 |
| System Popup description, Tabs unselected label | #1B1C1E @ .84 |
| Spinner unselected label | #1B1C1E @ .32 |

이 목록을 전역 `text/dark/*`의 변경으로 확대하지 않는다. 해당 Dark 값이 웹에 없다면 명세의 semantic/Figma Dark 보완값을 따른다. Light 그림을 모든 테마의 static 색이라고 단정하지 않는다.

### 웹 Colors와 Figma가 다른 11개 모드 값

| Canonical token | Mode | Figma 이전 값 | 웹 최종값 |
| --- | --- | --- | --- |
| `button_switch_pressed` | dark | #FFFFFF @ 0.1 | **#FFFFFF @ 0.2** |
| `button_switch_disabled` | dark | #131417 @ 0.3 | **#FFFFFF @ 0.3** |
| `controller_stepper_background` | dark | #FFFFFF @ 0.1 | **#131417 @ 0.1** |
| `driving_charging_deep` | dark | #00B975 @ 1 | **#0082FC @ 1** |
| `keyboard_normal_secondary_pressed` | dark | #686A72 @ 1 | **#44464E @ 1** |
| `keyboard_static_secondary_pressed` | dark | #686A72 @ 1 | **#44464E @ 1** |
| `keyboard_static_background` | dark | #131417 @ 1 | **#313236 @ 1** |
| `keyboard_static_icon_light` | dark | #FFFFFF @ 1 | **#A4A8AE @ 1** |
| `keyboard_static_icon_dark` | dark | #131417 @ 1 | **#A4A8AE @ 1** |
| `keyboard_static_text` | light | #FFFFFF @ 1 | **#313236 @ 1** |
| `keyboard_static_text` | dark | #FFFFFF @ 1 | **#A4A8AE @ 1** |


`driving_charging_deep` Dark는 웹 swatch의 녹색과 인쇄된 #0082FC가 서로 다르다. 여기서는 최신 웹의 **인쇄된 semantic target #0082FC**를 선택했으며, 이 웹 내부 불일치를 명시적으로 보존한다. Figma 녹색으로 조용히 회귀하지 않는다.

## 3. 웹 자체의 표기 오류와 의미 정규화

| 위치 | 발견한 표기 | 적용할 해석 |
| --- | --- | --- |
| Basic button | Properties가 States 표를 반복 | hierarchy/size 도해의 Primary/Secondary와 L/M/S를 구현 |
| Toggle/Icon Pressed | 윈도 드래그 문구가 섞임 | 해당 버튼의 입력 중 상태로 구현; Window resize API를 버튼에 추가하지 않음 |
| Keypad | Pressed 행 반복, 숫자 예시를 Qwerty로 표기 | Numeric과 QWERTY를 실제 키·배열로 구분 |
| Window bar | 세로 handle 길이 변화 설명에서 width 용어 사용 | 실제 세로 길이 140→100을 적용 |
| Stepper | minus 쪽 i++, plus 쪽 i-- | minus는 감소, plus는 증가로 해석하며 min/max 범위를 적용 |
| Indicator | Root 설명이 App bar | 일반 페이지 위치 표시용 root로 해석 |
| Text Field | Samll | 공개 API는 Small |
| Number Field | Text Field 문구 혼입 | 숫자 입력 칸의 실제 상태와 구조로 해석 |
| Page Navigation | Properties 설명 혼입 | 실제 Main/Depth 및 optional slot 기준 |
| Radio/Switch | anatomy에 Checkbox, disabled에 Button | 각각 Radio/Switch의 역할 및 상태로 정규화 |
| Colors alpha | 이름·swatch와 반대인 RGB 라벨 12행 | dark는 Light #131417/Dark 흰색, light는 Light 흰색/Dark #131417로 해석. 원문 라벨도 01·JSON에 보존 |
| Colors Icon/Text | static light 행에도 dark 이름 반복 인쇄 | target 및 의미에 맞는 light canonical 명칭으로 정규화; 원문명은 metadata에 보존하고 전역에 중복 alias를 등록하지 않음 |
| Colors Media/gradient | 8자리 HEX 표기의 순서가 혼재 | Media 두 색은 RGBA, gradient는 ARGB로 읽고 RGB+alpha로 명시적으로 분리 |
| Loading JSON | 레이어명 1B1C1E, 실제 stroke RGB는 131417 | 이름이 아니라 실제 color/keyframe 값으로 구현 |
| Widgets 이미지 | alt는 svg이지만 실제 형식은 PNG인 자료 | 실제 파일 형식과 그림을 확인해 치수/동작만 전사 |

오기를 보정했다고 하여 임의 기능이나 상태를 공식 요구사항으로 만들지 않는다. Radio의 Invalid는 웹에 이름이 있으나 별도 시각 규격이 없으므로 오류 semantics를 제공하고 붉은 원형을 공식 스타일로 추가하지 않는다. Toggle의 임의 Loading과 Icon의 임의 Loading/Selected는 공식 필수가 아니다. Toggle의 On/Off 선택 상태는 필수다. Dropdown의 다중선택은 공식 필수 조합이 아니다.

## 4. 자료가 정하지 않은 부분의 처리

아래 기본값은 구현을 멈추지 않기 위한 명시적 선택이며 공식 수치가 아니다. `SPEC_DECISIONS.md`에 이유·교체점·검증 상태를 남긴다.

| 항목 | 결정 / 한계 |
| --- | --- |
| Icon Large | 100×100, icon 64, radius 24. 확인되지 않은 공식 치수로 표시하지 않음 |
| Toggle Floating | 상태와 독립된 shadow policy로 모델링; 첨부의 On 표면/Level2 근거를 유지 |
| Numeric keypad 전체 layout | colgap 24, 외부 LR/하단 48은 웹 측정값; rowgap 40/독립 top 48은 구현값. 기본 744×648이며 키 200×108과 산술적으로 연결 |
| QWERTY 전체 layout | gap 10, 외부 LR/하단 24, 핸들 포함 top 56, 예시 1268×520은 웹 SVG 측정값; 핸들이 없을 때의 top 24는 구현값 |
| Widget hidden 형상/gesture | hidden 160×64, hit 240×80, 제목 24/32 Bold 별도 토큰, 거리 .35×height. velocity는 기본 off이며, 켤 경우 1000dp/s는 구현값 |
| Toast timeout/queue | Short 3000ms/Long 5000ms, 최대 3개 대기 및 접근성 timeout 우선은 구현 정책 |
| 전환/포커스 | 일반 pressed 120ms, expand 200ms, focus 4dp/offset 4dp는 구현 기본값; 웹 windowbar 300ms와 loading 원본 keyframe에 이 값을 덮어쓰지 않음 |
| Text Field disabled | 웹/첨부에 독립 시각 상태가 없는 축. enabled/readOnly를 분리하고 명시적인 보완 스타일을 사용 |
| Number Field 그룹/입력 제약 | String으로 앞자리 0을 유지하며, paste/backspace/focus 정책은 04의 구현 계약을 따름 |
| 키보드 조합/음성 입력 | 한글 IME composition/voice 서비스는 adapter로 연결. 샘플 문자를 이어 붙인 결과를 완성된 IME라고 주장하지 않음 |
| OS 창 관리/시스템 알림/차량 서비스 | core UI와 host adapter를 분리. 일반 앱이 권한 없이 시스템을 통제한다고 가정하지 않음 |
| 화면·글자 배율 | default S의 1u=1dp 매핑과 fontScale 존중은 구현 선택. 원본 window dp·토큰 모드를 보존 |
| 이미지/법규 telltale | 일반 아이콘 80개 외 사진·차량 이미지는 slot으로 제공. 전체 법규 telltale 자산을 복원했다고 주장하지 않음 |

## 5. 전체 22개 컴포넌트 출처·완료 범위

아래 각 행에는 공개 구현·모든 필수 변형·카탈로그·입력/semantics 검증·웹 우선 시각 검증이 필요하다. 01의 공통 규칙과 04의 계약을 모든 행에 적용한다. 도해 수는 페이지별 참조 수이며, 같은 이미지를 다른 페이지에서 재사용한 경우도 각각 센다.

| ID | 컴포넌트 / 공식 웹 | 명세 | 페이지 도해 수 | 필수 범위 |
| --- | --- | --- | ---: | --- |
| A01 | [Basic button](https://document.pleos.ai/docs/connect/guide/docs-design/components/actions/basic-button) | 02 §2 | 4 | Primary/Secondary; L/M/S; Enabled/Pressed/Disabled/Loading; prefix/suffix |
| A02 | [Toggle button](https://document.pleos.ai/docs/connect/guide/docs-design/components/actions/toggle-button) | 02 §3 | 3 | Off/On; L/M/S; Enabled/Pressed/Disabled; Floating |
| A03 | [Text button](https://document.pleos.ai/docs/connect/guide/docs-design/components/actions/text-button) | 02 §4 | 3 | M/S; Enabled/Pressed/Disabled/Loading; prefix/suffix |
| A04 | [Icon button](https://document.pleos.ai/docs/connect/guide/docs-design/components/actions/icon-button) | 02 §5 | 4 | Basic/Plain/Circle; L/M/S; Enabled/Pressed/Disabled; Large 치수는 명시적 보완 |
| A05 | [Keypad](https://document.pleos.ai/docs/connect/guide/docs-design/components/actions/keypad) | 02 §6 | 5 | Numeric Number/Delete/Clear; QWERTY Normal/Static; 모든 special key; Shift/Text/Voice |
| B01 | [Bar](https://document.pleos.ai/docs/connect/guide/docs-design/components/bar) | 02 §7 | 7 | Window/Scroll; Enabled/Pressed/Dragging/Disabled; app-control primitive |
| C01 | [Controllers](https://document.pleos.ai/docs/connect/guide/docs-design/components/controllers) | 02 §8 | 21 | Continuous/Centered/Stepper; Basic/Floating; Button/Basic/Number; OFF; min/max/step |
| I01 | [Indicator](https://document.pleos.ai/docs/connect/guide/docs-design/components/indicator) | 02 §9 | 2 | Wide/Narrow; Present true/false; 페이지 수/현재 key |
| D01 | [Dropdown](https://document.pleos.ai/docs/connect/guide/docs-design/components/dropdown) | 02 §10 | 5 | M/S; trigger/menu/item; Opened/Selected; AppIcon/Icon/Switch/Footer |
| F01 | [Text Field](https://document.pleos.ai/docs/connect/guide/docs-design/components/fields/text-field) | 03 §1 | 4 | M/S; Enabled/Focused/Typing/Entered/ReadOnly/Error; Text/Tel/Url/Email/Password |
| F02 | [Number Field](https://document.pleos.ai/docs/connect/guide/docs-design/components/fields/number-field) | 03 §2 | 3 | M/L; Normal/Focused/Entered/Invalid; 단일 칸/그룹/PIN; String 값 |
| N01 | [Page Navigation](https://document.pleos.ai/docs/connect/guide/docs-design/components/page-navigation) | 03 §3 | 4 | Main/Depth; icon/title/subtitle; search/menu/actions; optional divider/back |
| P01 | [System Popup](https://document.pleos.ai/docs/connect/guide/docs-design/components/popups/system-popup) | 03 §4 | 4 | M/L; 기본/첨부 Extended; Single/Horizontal/Vertical; optional header/body |
| P02 | [Toast Popup](https://document.pleos.ai/docs/connect/guide/docs-design/components/popups/toast-popup) | 03 §5 | 3 | icon 없음/있음; 비모달 host; 외부 여백/최대폭/timeout |
| T01 | [Tabs](https://document.pleos.ai/docs/connect/guide/docs-design/components/segmented-menu) | 03 §6 | 4 | Box/Line; L/M 및 item 상태; Fitted/Start; text/icon; divider/underline |
| S01 | [Checkbox](https://document.pleos.ai/docs/connect/guide/docs-design/components/selections/checkbox) | 03 §7 | 3 | Off/On/Indeterminate × Enabled/Pressed/Disabled |
| S02 | [Radio button](https://document.pleos.ai/docs/connect/guide/docs-design/components/selections/radio) | 03 §8 | 3 | Off/On × Enabled/Pressed/Disabled; 단일 선택 그룹; Invalid semantics |
| S03 | [Switch](https://document.pleos.ai/docs/connect/guide/docs-design/components/selections/switches) | 03 §9 | 3 | M/S × Off/On × Enabled/Pressed/Disabled |
| SP01 | [Spinner](https://document.pleos.ai/docs/connect/guide/docs-design/components/spinner) | 03 §10 | 3 | Date/Time; Large/첨부 Medium; 12/24시간; wheel snap; DateTime 조합 |
| SN01 | [System Notification](https://document.pleos.ai/docs/connect/guide/docs-design/components/notification/system-notification) | 03 §11 | 3 | root: ImageText/OnlyText/Call; image 종류; CTA 배열: Single/Horizontal/Vertical |
| TO01 | [Toast](https://document.pleos.ai/docs/connect/guide/docs-design/components/toast) | 03 §12 | 3 | 공개 API는 구분하고 공통 surface/host 구현은 공유 가능; 메시지/아이콘/큐/timeout |
| W01 | [Widgets](https://document.pleos.ai/docs/connect/guide/docs-design/components/widgets) | 03 §13 | 4 | Show/Hidden × Enabled/Pressed; 페이지 전환/하단 숨김/복원; 콘텐츠 슬롯 |


첨부의 292개 component master는 위 22개 공개 분류의 실제 변형·부속 primitive·참조 구조를 확인하기 위해 전개했다. master 개수를 공개 API 개수로 오인하지 않는다. 추가 display master 10개는 별도 원본 자료다.

## 6. 공통 근거와 플랫폼 출처

| 자료 | 공식 주소 | 적용 문서 |
| --- | --- | --- |
| Design Guide 소개 | [https://document.pleos.ai/docs/connect/guide/docs-design/Introduction/intro](https://document.pleos.ai/docs/connect/guide/docs-design/Introduction/intro) | 01 |
| Display Layout | [https://document.pleos.ai/docs/connect/guide/docs-design/getting-started/layout](https://document.pleos.ai/docs/connect/guide/docs-design/getting-started/layout) | 01 |
| Colors 전체 25개 도해 | [https://document.pleos.ai/docs/connect/guide/docs-design/foundations/colors](https://document.pleos.ai/docs/connect/guide/docs-design/foundations/colors) | 01 |
| Typography | [https://document.pleos.ai/docs/connect/guide/docs-design/foundations/typography](https://document.pleos.ai/docs/connect/guide/docs-design/foundations/typography) | 01 |
| Iconography | [https://document.pleos.ai/docs/connect/guide/docs-design/foundations/contents-creation/iconography](https://document.pleos.ai/docs/connect/guide/docs-design/foundations/contents-creation/iconography) | 01 |
| Animation | [https://document.pleos.ai/docs/connect/guide/docs-design/foundations/animation](https://document.pleos.ai/docs/connect/guide/docs-design/foundations/animation) | 01 |
| Shadow | [https://document.pleos.ai/docs/connect/guide/docs-design/foundations/shadow](https://document.pleos.ai/docs/connect/guide/docs-design/foundations/shadow) | 01 |


추가 플랫폼 출처는 04 §8에 기록했다. 핵심 규칙도 본문에 이미 포함되어 있다.

- [Window 정책](https://document.pleos.ai/docs/connect/guide/docs-design/getting-started/window): 앱 패널·multiwindow·생명주기 경계의 보완 근거다.
- [공식 Loading 배포본](https://document.pleos.ai/assets/files/Loading-a564bf9ddfbe2fa3c9640ec7708d9e1d.zip): Linear/Tension, Light/Dark의 실제 JSON을 읽어 01에 geometry·alpha·keyframe·easing·frame 범위를 기록했다. 구현할 때 추가로 다운로드하지 않는다.
- [Asta Sans 원저장소](https://github.com/42dot/Asta-Sans), [Google Fonts 파일](https://github.com/google/fonts/tree/main/ofl/astasans): 동봉 폰트와 OFL의 출처다. 정확한 binary 해시는 `assets/fonts/source.json`에 있다.
- 첨부 2개 원본의 이름·크기·SHA256·export metadata는 07 §1에 있다. 파일명의 215와 숨겨진 legacy 스타일은 웹 최신 정책을 변경하지 않는다.

페이지별 도해 137개 참조의 파일명·URL·SHA256은 `appendices/11_WEB_SOURCE_INDEX.md`와 `data/source_manifest.json`에 보존했다. 구현 시 원본 웹 페이지나 그림을 추가로 열어야 하는 의존성을 만들지 않는다. 수치·상태·배치의 규범은 01~04에, 원본 확장은 05~07 및 관련 부록에 있다.

## 7. 코드 작성 전후의 필수 확인

1. 코드를 작성하기 전에 22개 행을 `IMPLEMENTATION_MATRIX.md`로 옮기고 원본 변형과 최종 웹 규격을 연결한다.
2. 색상은 01의 149행에, 이름은 `appendices/10_COLOR_TOKEN_MAPPING.md`에 연결한다. 단순한 slash 치환으로 잘못 연결하지 않는다.
3. Figma 기하·스타일 추출값을 코드에 옮긴 뒤 이 장의 웹 최종값을 적용한다. Stepper 400, Popup 760, Spinner 600/500, Window 140→100 등에 회귀 검증을 둔다.
4. 기본값 또는 추정치를 공식 사실로 표시하지 않는다. 미확정 치수를 변경할 지점은 토큰 객체로 모은다.
5. 라이브러리 core UI, AAOS 서비스 adapter, 카탈로그 mock mode가 각각 조작 가능한지 확인한다. 제약이 있는 실제 OS 통합은 검증 상태를 정확히 보고한다.
6. 모든 종류·크기·상태의 카탈로그와 실행한 테스트 결과를 작성한다. 확인하지 않은 스크린샷 일치나 차량 rotary 호환을 통과했다고 기록하지 않는다.

이 문서는 **구현을 위한 완전한 입력 묶음**이며, Android 라이브러리가 이미 생성되었다는 보고서가 아니다. 구현 LLM은 00의 지시에 따라 실제 소스·빌드·카탈로그·검증 자료를 생성해야 한다.
