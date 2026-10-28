# 01 — 공통 디자인 토큰·타이포그래피·모션·디스플레이

**적용 우선순위: 웹 최신 규격 → 웹에 없는 첨부 Figma 보완값 → 명시적인 구현 기본값.** 원본 추출 부록에 다른 값이 있어도 아래 웹 최종값을 되돌리지 않는다. 이 장에서 `[WEB]`, `[FIG]`, `[DECISION]`은 각각 공식 웹 사실, 첨부 사실, 구현 선택을 뜻한다. 개별 컴포넌트 장의 `[W]/[F]/[M]/[I]`는 같은 구분이며 `[M]`은 웹 SVG 좌표 측정이다.

## 1. 공통 경험 기준

출처: [Pleos UI Design Guide](https://document.pleos.ai/docs/connect/guide/docs-design/Introduction/intro).

`[WEB]` 한 손으로 짧고 단순하게 조작할 수 있게 하고, 주요 내용은 1~2초 안에 파악할 수 있도록 구성한다. 입력 후 0.25초 안에 시각적 반응을 주며, 처리가 오래 걸리면 진행 중임을 알린다. 주행 중 시선을 끄는 영상·장식 애니메이션·자동 스크롤은 억제한다. 텍스트·아이콘 등은 배경과 4.5:1 이상의 대비를 목표로 한다. 주간/야간, 여러 언어, 다양한 표시 영역에 대응한다.

`[WEB]` 콘텐츠 작성 제한은 영어 단일 메시지120자 또는24단어, 한 줄80자, 문단 최대3줄이다. 일본어 단일 메시지는30자로 제시되어 있으나 웹의 단위 설명에 오기가 있으므로 한국어에 같은 문자 수를 기계적으로 대입하지 않는다. 주요 정보의 글자 높이5mm, 보조 정보3mm 기준은 물리 디스플레이 검증 항목이다. 알림은 운전자에게 필요한 정보를 간결하게 전달하며 광고 용도로 사용하지 않는다. 아이콘은 이해 가능한 표상과 라벨을 사용하고 가능한 환경에서 촉각·음성 피드백을 연결한다.

`[DECISION]` 위 콘텐츠 제한을 지키기 위해 편집 중인 원문을 임의로 잘라 삭제하지 않는다. 표시 정책·검증 안내를 제공하며, 중요한 오류나 확인 문구를 의미 없이 숨기지 않는다. 컴포넌트의 원본 disabled 색과 접근성 대비 목표가 맞지 않는 경우 원본을 은폐하지 말고 상태별 대비 결과와 host의 접근성 강화 옵션을 기록한다.

## 2. 단위와 폼팩터

### 2.1 단위를 혼동하지 않는 방법

- `[WEB/FIG]` 아래 디스플레이 표의 Resolution/Landscape/Portrait는 **dp**로 명시된 값이다. 이미지 파일의 가로 픽셀 수와 다르다.
- `[FIG]` Figma `size`, `padding`, `transform`의 숫자는 원본 design unit(`u`)이다. form_factor 변수에는 차량 종류별 값이 별도로 들어 있고, typo 변수의 `font_size_sp`, `line_height_sp`는 글자 단위 의도를 명시한다.
- `[DECISION]` 구현의 기준은 **Connect-S 기본 프로필에서 layout 1u=1dp**다. 각 폼팩터의 명시된 layout 변수값을 `Dp`로, typography sp 변수값을 `Sp`로 옮긴다. 이 mapping은 디자인 보드의 픽셀을 기기 물리 픽셀로 그대로 쓰라는 뜻이 아니다.
- 폼팩터를 바꿀 때는 **해당 토큰의 모드 값**을 선택한다. 모든 값을 `1920/2560` 같은 한 비율로 축소하지 않는다. 예를 들어 Basic Large 높이는 S100/L88/W84/Waterfall106으로 토큰마다 별도 정의되어 있다.
- 웹에 최신 치수가 명시되면 그 property는 웹 값으로 override한다. 다른 폼팩터에 대한 최신 대응값이 따로 없으면 '옛 값으로 복귀'하지 말고 웹 기본값+현재 가용 constraints를 사용하고 `[DECISION]`으로 기록한다. 웹과 무관한 padding/폰트 등은 해당 모드의 보완 토큰을 사용한다.
- 원본에 mode binding이 없는 값은 우선 기본 design-unit mapping을 적용하고, 비례 축소를 새 공식값처럼 만들지 않는다. `PleosMetrics`에서 교체 가능하게 한다.
- 물리 렌더링은 Android density로 한 번만 변환한다. 기본적으로 `px = dp × density`다. `sp`는 접근성 글자 배율과 플랫폼의 font scaling을 따른다. Android의 비선형 font scaling까지 무시하고 모든 `sp`를 `dp×fontScale` 수식 하나로 대체하지 않는다.
- Figma root의 절대 x/y는 문서 보드 배치 좌표다. runtime에는 부모 상대 레이아웃·constraint·padding만 반영한다. 그림 전체 viewport와 컴포넌트 root 크기를 구별한다.

### 2.2 화면과 앱 윈도 표

출처: [Display Layout](https://document.pleos.ai/docs/connect/guide/docs-design/getting-started/layout)의 도해 및 첨부 display-guide `2203:14913` 표. 아래 ratio는 원문 표기이며 레이아웃 계산에서는 실제 dp 치수를 사용한다.

| 화면 | 원문 비율 | inch | 문서 DPI | 전체 표시 영역 dp | Landscape 앱 dp | Portrait 앱 dp | 근거 |
| --- | --- | ---: | ---: | --- | --- | --- | --- |
| Connect-S-17, 기본 | 16:9 | 17 | 160 | 2560×1440 | 1700×1184 | 840×1184 | WEB+FIG |
| Connect-S-14.6 | 16:9 | 14.6 | 200 | 2048×1152 | 1360×948 | 672×948 | WEB+FIG |
| Connect-L-12.9, 현재 S 계열 | 16:9 | 12.9 | 160 | 1920×1080 | 1274×855 | 628×855 | WEB+FIG |
| Connect-W-Standard | 9:2 | 24.6 | 160 | 3840×850 | 1640×810 | 800×810 | WEB+FIG |
| Connect-W-Extended | 24:9 | 24.6 | 160 | 3840×1440 | 1640×1400 | 800×1400 | WEB+FIG |
| Connect-WF / Waterfall | 32:9 | 18.5 | 200 | 3072×816 | 1256×800 | 648×800 | WEB+FIG |
| Connect-S-15.6 | 16:9 | 15.6 | 160 | 2172×1222 | 1408×1018 | 692×1018 | FIG 추가; 웹 표에는 없음 |

`[WEB]` Connect-L은 현재 Connect-S 계열로 분류된다. 화면은 Status bar, Driving view, GNB, Application window로 구성된다. 앱 위에 시스템 패널·키보드가 올라올 수 있다. 일반 앱은 landscape/portrait 양쪽 표시 영역을 지원한다. Connect-S는 두 앱1:1 또는 한 앱2:0, Wide는2:1 또는1:2 배치가 있으며 앱 가용 영역이 바뀐다. 시스템 window bar/3-finger 조작 등 전역 배치 정책은 OS 책임이다. 앱 화면이 가려지는 것을 프로세스 종료로 해석하지 않는다.

`[DECISION]` 명시적 host device profile을 우선한다. 현재 window 폭만으로 기기 모델을 추측하지 않는다. profile이 없으면 기본 Connect-S metrics와 실제 window constraints를 사용하고 host가 지정할 수 있게 한다. 표의 DPI는 UI 밀도 정보로 읽고, 실제 글자 mm 검증에 필요한 물리 PPI와 같다고 가정하지 않는다. popup/toast/dropdown은 전체 차량 해상도 대신 **현재 앱 패널과 인셋**을 기준으로 배치한다.

## 3. Typography

출처: [Typography](https://document.pleos.ai/docs/connect/guide/docs-design/foundations/typography), 첨부 assets Foundation/Typography 및 컴포넌트 실제 text nodes.

### 3.1 기본 서체와 scale

`[WEB]` 기본 서체는 **Asta Sans**, 한국어·영어 지원이다. 아래는 기본 Connect-S의 font size/line height다. 해당 토큰이 있는 다른 폼팩터는 05·06번의 typo 모드값을 사용한다.

| 계층 | 크기 | font size | line height | 제공 weight |
| --- | --- | ---: | ---: | --- |
| Headline | Large | 60 | 80 | ExtraBold, Bold |
| Headline | Medium | 56 | 72 | ExtraBold, Bold |
| Headline | Small | 48 | 64 | ExtraBold, Bold |
| Title | Large | 40 | 52 | ExtraBold, Bold, Regular |
| Title | Medium | 36 | 44 | ExtraBold, Bold, Regular |
| Title | Small | 32 | 40 | ExtraBold, Bold, Regular |
| Body | Large | 30 | 38 | Strong, Normal |
| Body | Medium | 28 | 36 | Strong, Normal |
| Body | Small | 26 | 34 | Strong, Normal |
| Label | Medium | 24 | 28 | Normal |
| Label | Small | 20 | 24 | Normal |

`[FIG/DECISION]` actual text nodes의 Regular/Bold/ExtraBold에 맞춰 Normal=400, Strong=700, ExtraStrong=800으로 정규화한다. 웹의 ExtraBold/Bold도 각각800/700이다. font category `Label`과 버튼 안의 slot 이름 `Label`은 동일하지 않다. 예를 들어 Large Basic button의 라벨은32/40 Bold이므로 Label category24를 임의 대입하지 않는다. 컴포넌트별 typography가 있으면 해당 값을 우선한다.

`[FIG]` 추가 Feature 표에는 Speed112/134 Bold, Traffic sign36/44 Bold, Ambient bubble30/48 ExtraStrong 또는 Strong, List number28/36 Strong이 있다. 일반 버튼·필드에 이를 기본 적용하지 말고 위젯 등 필요한 slot에서 명시 선택할 수 있게 한다.

### 3.2 서체 원본 혼재 처리

Figma Foundation 표의 숨겨진 Typeface 열에는 Manrope 문자열이 남아 있고 imported style에는42dot Sans OTF가 존재한다. 현재 웹 지시와 실제 컴포넌트 노드는 Asta Sans를 가리킨다. **최종 서체는 Asta Sans**다. 옛 설명 문자열만 보고 Manrope로 변경하지 않는다.

동봉 `assets/fonts/asta_sans_variable.ttf`는 Google Fonts의 Asta Sans, version1.000, weight axis300~800이며 한글 glyph를 포함한다. 원본 variable font의 default axis가300이므로 Regular/Bold를 표시할 때400/700/800을 명시적으로 적용한다. Android resource에서 `asta_sans_variable` 이름으로 사용하고 OFL 파일을 보존한다. 외부 폰트 다운로드가 필수인 구현을 만들지 않는다.

`[DECISION]` 플랫폼/Compose 버전의 variable-font API를 확인해 weight를 지정한다. 특정 환경에서 variable font를 사용할 수 없으면 동봉 원본으로 필요한 static weight를 생성하거나 host FontFamily 주입을 허용하되, system sans fallback을 Asta Sans 원본 일치로 표현하지 않는다. 한국어·영어 외 glyph fallback은 Android font fallback chain을 허용하며 locale 테스트를 한다.

### 3.3 측정 규칙

line height, font weight, letter spacing, maxLines, alignment를 개별 원본대로 적용한다. 예시 문자열 폭을 고정 폭으로 복사하지 않는다. 큰 글자 배율에서 먼저 content-aware height와 줄바꿈을 사용하고, 버튼 action이 가려지거나 텍스트가 잘리지 않게 한다. 숫자용 monospace/tabular 옵션은 원본 또는 명시적 slot 정책이 있을 때만 적용한다.

웹에서12sp·18px 관련 설명이 있지만 이는 해당 문서의 권장 설명이다. `12sp≈12dp`는 기본 배율의 특수 조건이며 이를 일반 공식으로 삼아 접근성 배율을 강제로1로 고정하지 않는다. 이 라이브러리의 정상 텍스트는 위 scale 및 컴포넌트별 큰 크기를 사용한다.

## 4. 아이콘과 이미지

출처: [Iconography](https://document.pleos.ai/docs/connect/guide/docs-design/foundations/contents-creation/iconography).

`[WEB]` 기본 제작 grid는48×48dp이며 Filled/Outlined 두 스타일이 있다. 하나의 원형을 필요한 크기로 조절한다. 이것은 모든 컴포넌트에48dp icon을 강제하라는 의미가 아니다. 버튼·필드별 icon container와 실제 glyph 크기는02·03번이 우선한다.

`[FIG]` 동봉80개 SVG는 첨부의 실제 vector path를 복원한 것이다. 원본 node ID, 이름, viewport는 `assets/icons/manifest.json`과 `appendices/09_ICON_PATHS.md`에 있다. 뒤로가기/화살표/체크/닫기/눈/키패드 등의 도형을 이 자료에서 생성하라. SVG가 없는 raster+gradient app imagery, 사람 사진, 타이어/차량 그림 등은 Image/Painter slot으로 받아 처리한다. 벡터80개가 원본의 모든 이미지·법규 telltale을 포함한다는 뜻은 아니다.

`[DECISION]` VectorDrawable 또는 Compose ImageVector로 변환할 때 viewBox·path fill rule·transform·opacity를 보존한다. mono icon의 tint는 해당 component state token으로 주입하되 multi-tone·브랜드·알림 이미지의 색을 무조건 덮지 않는다. outline path를 다시 stroke하여 두껍게 만들지 않는다. 좌우 탐색 의미가 있는 아이콘만 RTL auto-mirror하고 숫자·차량·브랜드는 자동 반전하지 않는다.

아이콘이 독립 action이면 접근 가능한 이름이 필수다. 라벨과 함께 있는 장식 아이콘은 중복 읽기를 생략한다. 외형과 hit target의 크기를 구별한다.

## 5. 그림자와 elevation

출처: [Shadow](https://document.pleos.ai/docs/connect/guide/docs-design/foundations/shadow). 단위는 원본 design unit, black은#000000이다.

| 레벨 | layer | offset X | offset Y | blur | spread | alpha | 원문 Android ARGB |
| --- | --- | ---: | ---: | ---: | ---: | ---: | --- |
| Level1 | 1 | 0 | 6 | 24 | 0 | 8% | #14000000 |
| Level2 | 1 | 0 | 8 | 32 | 0 | 16% | #29000000 |
| Level2 | 2 | 0 | 2 | 2 | 0 | 8% | #14000000 |
| Level3 | 1 | 0 | 20 | 40 | 0 | 24% | #3D000000 |
| Level3 | 2 | 0 | 2 | 4 | 0 | 20% | #33000000 |

낮은 surface는Level1, 더 높은 surface는Level2, 최상위 overlay는Level3의 표현을 사용하며 구체 컴포넌트가 지정한 레벨을 우선한다. alpha8%를8-bit로 바꾼#14와0.08은 반올림 차이가 있으므로 source float를 유지하고 golden renderer 조건을 기록한다.

`[DECISION]` Compose/Android의 `shadow(elevation=...)`는 이 다중 blur layer와 자동으로 동일하지 않다. radius·offset·blur·spread·alpha를 보존할 수 있는 렌더러를 제공하고 API28부터 동작하는 fallback을 구현한다. 그림자가 부모 clip에 잘리지 않도록 그림자 영역과 content clipping을 분리한다. 렌더 비용이 큰 blur mask는 크기·shape·token 변화가 없을 때 재사용한다.

## 6. Loading 애니메이션

출처: [Animation](https://document.pleos.ai/docs/connect/guide/docs-design/foundations/animation) 및 페이지의 공식 `Loading-a564bf9ddfbe2fa3c9640ec7708d9e1d.zip`에 포함된4개 animation JSON을 직접 확인했다. 이 절만으로 순수 Compose renderer를 구현할 수 있다. **Date/Time Spinner와 다른 지원 primitive**다.

### 6.1 형태와 테마

| 항목 | 확인값 |
| --- | --- |
| viewport | 64×64 |
| 원 중심 | (32,32) |
| 원의 중심선 반경 | 24 |
| stroke width | 8 |
| 전체 바깥 지름 / viewport 여백 | 56 / 각4 |
| foreground arc | round cap, alpha0.84 |
| background ring | 원 전체, alpha0.10 |
| Light stroke RGB | #131417 |
| Dark stroke RGB | #FFFFFF |
| trim start / angular offset | 0% / −90° |

동일색의 전경/후경을 별개 레이어로 합성한다. 최상위 layer name에 `1B1C1E`가 있어도 실제 color channel은#131417이다. 이름보다 JSON의 실제 color 값을 사용한다. 경로는 원점을 중심으로 `(24,0),(0,24),(−24,0),(0,−24)` 네 점과 각 tangent 크기13.255인 닫힌 cubic circle이며, group/layer transform 결과 중심은(32,32)다. 정확한 circle API로 구현할 수 있고 원본 tangent 근사와의 차이는 검증한다.

### 6.2 시간과 keyframe

| 항목 | Linear | Tension |
| --- | --- | --- |
| composition | 30fps, ip=0, op=61 | 동일 |
| 회전 | frame0=0°, frame60=1080° | 동일 |
| arc trim end | 고정28% = 100.8° | frame0=1%, frame30=60%, frame60=1% |
| keyframe easing | out(.167,.167), in(.833,.833), 결과 선형 보간 | 동일한 선형 보간 |
| 반복 | 재생 구간을 반복 | 재생 구간을 반복 |

모션 keyframe의0~60frame은2초다. 원본 composition의 재생 구간[0,61)은61/30초(약2.0333초)이며 마지막 keyframe 이후 끝까지의 구간을 구별한다. 원본 재생과 동등하게 구현하고, 임의의1000ms 한 바퀴 spinner로 바꾸지 않는다. `Tension`이라는 이름만 보고 spring easing을 임의로 추가하지 않는다. Linear는 일정한 arc, Tension은 arc 길이도 늘고 줄어드는 타입이다.

`[DECISION]` 버튼 안의 viewport는 Large40, Medium32, Small24u를 기본으로 사용할 수 있다. 이는 버튼별 배치 선택이고 원본이 지정한 치수가 아니다. 기준viewport64×64와stroke8을 균등하게 축소하므로 stroke는5/4/3u다. Label의 원래 측정 폭을 유지해 loading 진입 시 버튼 폭이 흔들리지 않게 한다. motion off/reduced motion에서는 정적 arc와 처리 중 semantics를 제공한다.

Window bar의 별도 모션은300ms, cubic-bezier(.16,1,.3,1)이며02번에 있다. 이 easing을 모든 컴포넌트의 공통값이라고 확대하지 않는다.

## 7. 공식에 없는 공통 기본값

아래는 미정의 부분을 재현 가능하게 만드는 **[DECISION]** 기본 정책이다. 공식값이 확인된 컴포넌트에는 그 값이 우선한다.

| 항목 | 구현 기본값 |
| --- | --- |
| 일반 색/pressed 전환 | 120ms; 값은 `PleosBehaviorDefaults`에서 주입 |
| 선택/확장/접힘 전환 | 200ms; reduced motion이면0ms |
| focus ring | 4dp 선,4dp 바깥 간격, informative positive 색을 기본으로 하되 충분한 대비 확보 |
| minimum hit target | 48×48dp; 원본의 더 큰 control 영역 우선, 인접 target 중첩 금지 |
| toast Short / Long | 3000 / 5000ms, Custom 지원; 접근성 권장 timeout 우선 |
| toast queue | FIFO, 최대3개 대기, 안정적인 ID의 중복은 현재 항목 갱신; overflow는 가장 오래된 대기 항목 교체 |
| widget hide gesture |03번의 거리 threshold 적용; velocity기반 숨김은 기본off, 명시적으로 켜면1000dp/s 기준, 방향잠금 후 평가 |
| button repeat | 기본 off; 켜는 경우 최초500ms 후100ms 간격, 취소·up·focus loss 즉시 종료 |
| theme | host의 Light/Dark 변경을 따름; 임의 시간표로 낮/밤 판정하지 않음 |

수명/큐 정책은 각 API의 한 지점에서 설정 가능해야 한다. 오래된 timer가 새 toast를 닫지 않게 item ID와 generation을 검사한다. UI 상태 표시로 필요한 animation과 주행 중 제한 대상 장식 motion을 host capability로 구분한다.

## 8. 컬러의 표현과 적용 순서

웹의25개 컬러 도해를 primitive와 semantic token 표로 전사한 내용이 다음 절에 이어진다. semantic token은 Light/Dark에서 각각 지정된 target을 재귀 해석한다. 이름의 dark/light는 항상 현재 테마라는 뜻이 아니며 `basic_static_light_*`/`basic_static_dark_*` primitive는 테마에 따라 뒤집지 않는다. `keyboard_static_*` 등의 semantic은 별도로 제시된 Light/Dark alias를 그대로 적용한다.

Figma 원본 토큰은05·06번에 모두 보존했다. 같은 property의 최신 웹 값이 다르면 **다음 웹 표/보정표를 마지막에 적용**한다. raw `#RRGGBBAA`와 Android `#AARRGGBB` 순서를 구별한다. 예: raw `#1314171A`는 Android `0x1A131417`이다. 이 값에 다시alpha0.10을 곱하면 투명도가1%가 되어 잘못된다.

02·03번에서 특정 웹 도해의 요소에 직접 지정된 `#1B1C1E @ alpha` 등을 확인한 경우 해당 요소용 scoped token에만 적용한다. 전역 `text/dark/*`의 모든 사용처를 한꺼번에 바꾸지 않는다. Light 예시의 색만 확인되었다면 Dark에도 같은 RGB를 무조건 강제하지 말고, Dark의 명시 token 또는 첨부 모드로 보완하고 근거를 남긴다. Toast/ToastPopup의 Light는 웹#131417@0.84/흰색 텍스트, 별도 웹Dark값이 없는 부분은 첨부 `basic/600` Dark=#E0E1E6 및 `basic/00` Dark=#131417 텍스트로 보완한다. 이를 웹이 지정한 static overlay라고 주장하지 않는다.

웹 내부에서 alpha 색상 라벨과 실제 swatch가 서로 반대이거나 light/dark token 이름이 중복 인쇄된 행은 아래 오류 해석표의 보정값을 적용한다. 이는 구버전 Figma를 우선하는 정책이 아니라 웹 내부 모순을 식별해 정리한 것이다.

## 9. 웹 Colors 전체 수치 표

출처: https://document.pleos.ai/docs/connect/guide/docs-design/foundations/colors

공식 페이지의 25개 PNG를 직접 확인했다. 사용자 지시에 따라 웹을 최신 버전으로 간주한다. 아래 semantic alias/HEX는 웹에 인쇄된 target로 확정하며 Figma snapshot으로 되돌리지 않는다. 모든 구현값은 RGB와 alpha를 분리한다. Alpha RGB 방향, Icon/Text 이름 중복, Media 8자리 형식처럼 웹 내부에서 충돌하는 표기는 웹 자체의 swatch·토큰명·사용 맥락으로 해석한 결정을 명시한다. Figma는 이 해석의 부수 확인 자료이며 최신 웹을 덮는 근거가 아니다. 원문 표기도 함께 보존한다.

### Primitive / basic

| Token | Light 구현값 | Dark 구현값 | 원문 Light / Dark | Figma ID |
| --- | --- | --- | --- | --- |
| basic_00 | #FFFFFF | #131417 | #FFFFFF / #131417 | 67:4943 |
| basic_50 | #F7F8FA | #1D1E21 | #F7F8FA / #1D1E21 | 67:4971 |
| basic_100 | #EDEEF2 | #313236 | #EDEEF2 / #313236 | 67:4972 |
| basic_200 | #E0E1E6 | #44464E | #E0E1E6 / #44464E | 67:4973 |
| basic_300 | #C7C9CE | #686A72 | #C7C9CE / #686A72 | 67:4974 |
| basic_400 | #A4A8AE | #A4A8AE | #A4A8AE / #A4A8AE | 67:4975 |
| basic_500 | #686A72 | #C7C9CE | #686A72 / #C7C9CE | 67:4976 |
| basic_600 | #44464E | #E0E1E6 | #44464E / #E0E1E6 | 67:4977 |
| basic_700 | #313236 | #EDEEF2 | #313236 / #EDEEF2 | 67:4978 |
| basic_800 | #1D1E21 | #F7F8FA | #1D1E21 / #F7F8FA | 67:4979 |
| basic_900 | #131417 | #FFFFFF | #131417 / #FFFFFF | 67:4980 |
| basic_alpha_dark_50 | #131417 @ 5% | #FFFFFF @ 5% | #FFFFFF @ 5% / #131417 @ 5% | 67:4944 |
| basic_alpha_dark_100 | #131417 @ 10% | #FFFFFF @ 10% | #FFFFFF @ 10% / #131417 @ 10% | 67:4987 |
| basic_alpha_dark_200 | #131417 @ 20% | #FFFFFF @ 20% | #FFFFFF @ 20% / #131417 @ 20% | 67:4988 |
| basic_alpha_dark_300 | #131417 @ 30% | #FFFFFF @ 30% | #FFFFFF @ 30% / #131417 @ 30% | 67:4989 |
| basic_alpha_dark_400 | #131417 @ 40% | #FFFFFF @ 40% | #FFFFFF @ 40% / #131417 @ 40% | 67:4990 |
| basic_alpha_dark_500 | #131417 @ 50% | #FFFFFF @ 50% | #FFFFFF @ 50% / #131417 @ 50% | 67:4991 |
| basic_alpha_light_50 | #FFFFFF @ 5% | #131417 @ 5% | #131417 @ 5% / #FFFFFF @ 5% | 67:4981 |
| basic_alpha_light_100 | #FFFFFF @ 10% | #131417 @ 10% | #131417 @ 10% / #FFFFFF @ 10% | 67:4983 |
| basic_alpha_light_200 | #FFFFFF @ 20% | #131417 @ 20% | #131417 @ 20% / #FFFFFF @ 20% | 67:4982 |
| basic_alpha_light_300 | #FFFFFF @ 30% | #131417 @ 30% | #131417 @ 30% / #FFFFFF @ 30% | 67:4984 |
| basic_alpha_light_400 | #FFFFFF @ 40% | #131417 @ 40% | #131417 @ 40% / #FFFFFF @ 40% | 67:4985 |
| basic_alpha_light_500 | #FFFFFF @ 50% | #131417 @ 50% | #131417 @ 50% / #FFFFFF @ 50% | 67:4986 |
| basic_static_dark_100 | #131417 | #131417 | #131417 / #131417 | 2:15158 |
| basic_static_dark_200 | #131417 @ 84% | #131417 @ 84% | #131417 @ 84% / #131417 @ 84% | 67:4995 |
| basic_static_dark_300 | #131417 @ 64% | #131417 @ 64% | #131417 @ 64% / #131417 @ 64% | 67:4996 |
| basic_static_dark_400 | #131417 @ 32% | #131417 @ 32% | #131417 @ 32% / #131417 @ 32% | 67:4997 |
| basic_static_light_100 | #FFFFFF | #FFFFFF | #FFFFFF / #FFFFFF | 2:15159 |
| basic_static_light_200 | #FFFFFF @ 84% | #FFFFFF @ 84% | #FFFFFF @ 84% / #FFFFFF @ 84% | 67:4992 |
| basic_static_light_300 | #FFFFFF @ 64% | #FFFFFF @ 64% | #FFFFFF @ 64% / #FFFFFF @ 64% | 67:4993 |
| basic_static_light_400 | #FFFFFF @ 32% | #FFFFFF @ 32% | #FFFFFF @ 32% / #FFFFFF @ 32% | 67:4994 |

### Background

원문 이미지: `system-color-background-7bee5722e2912af73a71dd8267a463f0.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| background_primary | basic_50 | basic_50 | — | #F7F8FA | #1D1E21 |  |
| background_secondary | basic_00 | basic_00 | — | #FFFFFF | #131417 |  |
| background_popup | basic_00 | basic_100 | — | #FFFFFF | #313236 |  |

### Button

원문 이미지: `system-color-button-7fe4b0136b1e45f7264ce44b7297c896.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| button_basic_enabled | alpha_dark_50 | alpha_dark_50 | — | #131417 @ 5% | #FFFFFF @ 5% |  |
| button_basic_pressed | alpha_dark_100 | alpha_dark_100 | — | #131417 @ 10% | #FFFFFF @ 10% |  |
| button_basic_disabled | alpha_light_200 | alpha_light_200 | — | #FFFFFF @ 20% | #131417 @ 20% |  |
| button_switch_enabled | basic_00 | alpha_dark_200 | button-basic-active-enabled | #FFFFFF | #FFFFFF @ 20% |  |
| button_switch_pressed | alpha_light_500 | alpha_dark_200 | button-basic-active-pressed | #FFFFFF @ 50% | #FFFFFF @ 20% | CONFLICT dark: Figma #FFFFFF @ 10% |
| button_switch_disabled | alpha_light_300 | alpha_dark_300 | button-basic-active-disabled | #FFFFFF @ 30% | #FFFFFF @ 30% | CONFLICT dark: Figma #131417 @ 30% |
| button_filled_enabled | basic_600 | basic_600 | — | #44464E | #E0E1E6 |  |
| button_filled_pressed | basic_700 | basic_500 | — | #313236 | #C7C9CE |  |
| button_filled_disabled | alpha_dark_50 | alpha_dark_50 | — | #131417 @ 5% | #FFFFFF @ 5% |  |

### Controller

원문 이미지: `system-color-controller-35efcfe0a72a4e0023b8c9240dc8e35c.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| controller_slider_normal | alpha_dark_200 | alpha_dark_100 | — | #131417 @ 20% | #FFFFFF @ 10% |  |
| controller_slider_pressed | alpha_dark_300 | alpha_dark_200 | — | #131417 @ 30% | #FFFFFF @ 20% |  |
| controller_slider_knob | basic_00 | alpha_dark_300 | — | #FFFFFF | #FFFFFF @ 30% |  |
| controller_tab_background | alpha_dark_50 | alpha_dark_50 | — | #131417 @ 5% | #FFFFFF @ 5% |  |
| controller_stepper_background | basic_00 | alpha_light_100 | — | #FFFFFF | #131417 @ 10% | CONFLICT dark: Figma #FFFFFF @ 10% |

### Climate

원문 이미지: `system-color-climate-3cfaf745bdffaed6b7ec6eb5c1316450.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| climate_button_enabled | basic_200 | basic_50 | — | #E0E1E6 | #1D1E21 | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=button_enabled |
| climate_button_selected | basic_00 | basic_200 | — | #FFFFFF | #44464E | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=button_selected |
| climate_button_border_enabled | alpha_dark_200 | alpha_dark_100 | — | #131417 @ 20% | #FFFFFF @ 10% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=button_border_enabled |
| climate_button_border_disabled | alpha_dark_50 | alpha_dark_50 | — | #131417 @ 5% | #FFFFFF @ 5% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=button_border_disabled |
| climate_toggle_selected | alpha_dark_100 | alpha_light_300 | — | #131417 @ 10% | #131417 @ 30% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=toggle_selected |
| climate_toggle_pressed | alpha_dark_200 | alpha_light_400 | — | #131417 @ 20% | #131417 @ 40% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=toggle_pressed |
| climate_slider_background | basic_00 | basic_100 | — | #FFFFFF | #313236 | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=slider_background |
| climate_airvent_button_opened | basic_00 | basic_600 | — | #FFFFFF | #E0E1E6 | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=airvent_button_opened |
| climate_airvent_button_closed | alpha_light_400 | alpha_dark_200 | — | #FFFFFF @ 40% | #FFFFFF @ 20% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=airvent_button_closed |
| climate_airvent_symbol_opened | static_dark_200 | static_dark_200 | — | #131417 @ 84% | #131417 @ 84% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=airvent_symbol_opened |
| climate_airvent_symbol_closed | static_dark_400 | static_dark_300 | — | #131417 @ 32% | #131417 @ 64% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=airvent_symbol_closed |
| climate_airvent_opened | static_light_300 | static_light_400 | — | #FFFFFF @ 64% | #FFFFFF @ 32% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=airvent_opened |
| climate_airvent_closed | alpha_light_200 | alpha_dark100 | — | #FFFFFF @ 20% | #FFFFFF @ 10% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=airvent_closed |

### Dropdown

원문 이미지: `system-color-dropdown-620bef747dd4576c638f685729b6a118.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| dropdown_normal | basic_00 | basic_alpha_dark100 | — | #FFFFFF | #FFFFFF @ 10% |  |
| dropdown_pressed | basic_100 | basic_alpha_dark300 | — | #EDEEF2 | #FFFFFF @ 30% |  |

### Dim

원문 이미지: `system-color-dim-a3ad1a1be06b6c8ceac154f03d3979b9.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| dim_dark_primary | alpha_dark_50 | alpha_dark_50 | — | #131417 @ 5% | #FFFFFF @ 5% |  |
| dim_dark_secondary | alpha_dark_100 | alpha_dark_100 | — | #131417 @ 10% | #FFFFFF @ 10% |  |
| dim_dark_tertiary | alpha_dark_200 | alpha_dark_200 | — | #131417 @ 20% | #FFFFFF @ 20% |  |
| dim_light_primary | alpha_light_500 | alpha_light_500 | — | #FFFFFF @ 50% | #131417 @ 50% |  |
| dim_light_secondary | alpha_light_400 | alpha_light_400 | — | #FFFFFF @ 40% | #131417 @ 40% |  |
| dim_light_tertiary | alpha_light_300 | alpha_light_300 | — | #FFFFFF @ 30% | #131417 @ 30% |  |

### Driving

원문 이미지: `system-color-driving-aadbdd18cf6fe678339d3a733572d685.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| driving_gearshift_background | basic_900 | basic_100 | — | #131417 | #313236 | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=gearshitft_background |
| driving_charging_normal | #00DB25 | #00DB25 | — | #00DB25 | #00DB25 | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=charging_normal |
| driving_charging_deep | #00B975 | #0082FC | — | #00B975 | #0082FC | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=charging_deep; CONFLICT dark: Figma #00B975 |
| driving_gradient_end | basic_00 | basic_00 | — | #FFFFFF | #131417 | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=gradient_end |
| driving_gradient_start | FFFFFF, 0% | 131417, 0% | — | #FFFFFF @ 0% | #131417 @ 0% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=gradient_start |

### Fields

원문 이미지: `system-color-fields-31d4597576ec64442fe48e232078b8b8.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| field_background | basic_00 | basic_00 | — | #FFFFFF | #131417 |  |
| field_focused | basic_700 | basic_700 | — | #313236 | #EDEEF2 |  |

### Gleo AI

원문 이미지: `system-color-gleo-ai-47aaf3b0e321a56c557c6a98088a165c.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| gleo_surface_primary | basic_00 | basic_200 | ambient_ai_surface_primary | #FFFFFF | #44464E |  |
| gleo_surface_secondary | alpha_dark_50 | alpha_light_200 | ambient_ai_surface_secondary | #131417 @ 5% | #131417 @ 20% |  |
| gleo_bubble_primary | #9BA8E2 | #545F93 | ambient_ai_bubble_primary | #9BA8E2 | #545F93 |  |
| gleo_bubble_secondary | #8896D3 | #3E4976 | ambient_ai_bubble_secondary | #8896D3 | #3E4976 |  |
| gleo_bubble_tertiary | basic_00 | basic_100 | ambient_ai_bubble_tertiary | #FFFFFF | #313236 |  |
| gleo_bubble_speaker | #3F4B81 | #B6C1F3 | ambient_ai_bubble_speaker | #3F4B81 | #B6C1F3 |  |

### Icon

원문 이미지: `system-color-icon-e9b6e7d15a6a5927758f457e39c68eda.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| icon_dark_primary | static_dark_100 | static_light_100 | — | #131417 | #FFFFFF |  |
| icon_dark_secondary | static_dark_200 | static_light_200 | — | #131417 @ 84% | #FFFFFF @ 84% |  |
| icon_dark_tertiary | static_dark_300 | static_light_300 | — | #131417 @ 64% | #FFFFFF @ 64% |  |
| icon_dark_quaternary | static_dark_400 | static_light_400 | — | #131417 @ 32% | #FFFFFF @ 32% |  |
| icon_light_primary | static_light_100 | static_dark_100 | — | #FFFFFF | #131417 | 웹 하단4행의 dark 이름 중복: 같은 웹의 static_light→static_dark 값 패턴에 따라 light 이름으로 구분; sourceToken 보존. Figma는 부수 확인. |
| icon_light_secondary | static_light_200 | static_dark_200 | — | #FFFFFF @ 84% | #131417 @ 84% | 웹 하단4행의 dark 이름 중복: 같은 웹의 static_light→static_dark 값 패턴에 따라 light 이름으로 구분; sourceToken 보존. Figma는 부수 확인. |
| icon_light_tertiary | static_light_300 | static_dark_300 | — | #FFFFFF @ 64% | #131417 @ 64% | 웹 하단4행의 dark 이름 중복: 같은 웹의 static_light→static_dark 값 패턴에 따라 light 이름으로 구분; sourceToken 보존. Figma는 부수 확인. |
| icon_light_quaternary | static_light_400 | static_dark_400 | — | #FFFFFF @ 32% | #131417 @ 32% | 웹 하단4행의 dark 이름 중복: 같은 웹의 static_light→static_dark 값 패턴에 따라 light 이름으로 구분; sourceToken 보존. Figma는 부수 확인. |

### Informative

원문 이미지: `system-color-informative-ef19e6a5596f00f102603ca3413577e3.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| informative_active | #02C265 | #00E074 | — | #02C265 | #00E074 |  |
| informative_positive | #0064FF | #0082FF | — | #0064FF | #0082FF |  |
| informative_negative | #FE3D16 | #FF4C28 | — | #FE3D16 | #FF4C28 |  |
| informative_autonomous_driving | #5A46FA | #6A57FF | — | #5A46FA | #6A57FF |  |

### Keyboard Normal

원문 이미지: `system-color-keyboard1-24ccff8da02ecbeef3797527d39a50e8.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| keyboard_normal_primary_normal | basic_00 | basic_300 | — | #FFFFFF | #686A72 |  |
| keyboard_normal_primary_pressed | basic_100 | basic_200 | — | #EDEEF2 | #44464E |  |
| keyboard_normal_secondary_normal | basic_300 | basic_200 | — | #C7C9CE | #44464E |  |
| keyboard_normal_secondary_pressed | basic_400 | basic_200 | — | #A4A8AE | #44464E | CONFLICT dark: Figma #686A72 |
| keyboard_normal_active_normal | basic_600 | basic_300 | — | #44464E | #686A72 |  |
| keyboard_normal_active_pressed | basic_700 | basic_200 | — | #313236 | #44464E |  |
| keyboard_normal_accents_normal | basic_600 | basic_500 | — | #44464E | #C7C9CE |  |
| keyboard_normal_accents_pressed | basic_700 | basic_400 | — | #313236 | #A4A8AE |  |
| keyboard_normal_background | basic_200 | basic_100 | — | #E0E1E6 | #313236 |  |

### Keyboard Static

원문 이미지: `system-color-keyboard2-cf104d403970ba502279fee50a4165a5.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| keyboard_static_primary_normal | basic_500 | basic_300 | — | #686A72 | #686A72 |  |
| keyboard_static_primary_pressed | basic_600 | basic_200 | — | #44464E | #44464E |  |
| keyboard_static_secondary_normal | basic_600 | basic_200 | — | #44464E | #44464E |  |
| keyboard_static_secondary_pressed | basic_500 | basic_200 | — | #686A72 | #44464E | CONFLICT dark: Figma #686A72 |
| keyboard_static_active_normal | basic_500 | basic_300 | — | #686A72 | #686A72 |  |
| keyboard_static_active_pressed | basic_700 | basic_200 | — | #313236 | #44464E |  |
| keyboard_static_accents_normal | basic_300 | basic_500 | — | #C7C9CE | #C7C9CE |  |
| keyboard_static_accents_pressed | basic_400 | basic_400 | — | #A4A8AE | #A4A8AE |  |
| keyboard_static_background | basic_900 | basic_100 | — | #131417 | #313236 | CONFLICT dark: Figma #131417 |
| keyboard_static_icon_light | basic_00 | basic_400 | — | #FFFFFF | #A4A8AE | CONFLICT dark: Figma #FFFFFF |
| keyboard_static_icon_dark | basic_900 | basic_400 | — | #131417 | #A4A8AE | CONFLICT dark: Figma #131417 |
| keyboard_static_icon_disabled | alpha_light_100 | alpha_dark_100 | — | #FFFFFF @ 10% | #FFFFFF @ 10% |  |
| keyboard_static_text | basic_700 | basic_400 | — | #313236 | #A4A8AE | CONFLICT light: Figma #FFFFFF; CONFLICT dark: Figma #FFFFFF |

### Media

원문 이미지: `system-color-media-30d93aa4acfffa1ed3a5400e41308ea8.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| media_radio_primary | #C911E7FF | #C911E7FF | — | #C911E7 | #C911E7 | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=radio_primary; 웹 내부 해석 결정: 원문8자리 primary는 같은 웹의 보라/파랑 불투명 swatch에 따라 RRGGBBAA로 해석. Figma도 일치. |
| media_music_primary | #4781FFFF | #4781FFFF | — | #4781FF | #4781FF | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=music_primary; 웹 내부 해석 결정: 원문8자리 primary는 같은 웹의 보라/파랑 불투명 swatch에 따라 RRGGBBAA로 해석. Figma도 일치. |
| media_radio_gradient_start | #00FFFFFF | #001D1E21 | — | #FFFFFF @ 0% | #1D1E21 @ 0% | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=radio_gradient_start; 웹 내부 해석 결정: 원문8자리 gradient는 start의 투명 swatch와 end의 불투명 swatch에 따라 AARRGGBB로 해석. Figma alpha도 일치. |
| media_radio_gradient_end | #FFFFFFFF | #FF1D1E21 | — | #FFFFFF | #1D1E21 | 코드 namespace를 위해 category prefix 또는 철자 정규화; 원문명=radio_gradient_end; 웹 내부 해석 결정: 원문8자리 gradient는 start의 투명 swatch와 end의 불투명 swatch에 따라 AARRGGBB로 해석. Figma alpha도 일치. |

### Overlay

원문 이미지: `system-color-overlay-493e63cdf04dd8383fd8cf80a0356ab4.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| overlay_default | alpha_dark_200 | alpha_light_500 | — | #131417 @ 20% | #131417 @ 50% |  |

### Phone

원문 이미지: `system-color-phone-6b626a71744074d5178034b411925c7c.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| phone_call_normal | #32B957 | #3BD665 | — | #32B957 | #3BD665 |  |
| phone_call_pressed | #279E47 | #2DB752 | — | #279E47 | #2DB752 |  |
| phone_end_normal | #FE3D16 | #FF4C28 | — | #FE3D16 | #FF4C28 |  |
| phone_end_pressed | #E73612 | #DF4323 | — | #E73612 | #DF4323 |  |

### Regulation

원문 이미지: `system-color-regulation-0d00f934044ffc500b2dfabaa1e51fc7.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| regulation_blue | #0064FF | #0082FF | — | #0064FF | #0082FF |  |
| regulation_green | #00BA13 | #55F165 | — | #00BA13 | #55F165 |  |
| regulation_yellow | #FFC224 | #FFC224 | — | #FFC224 | #FFC224 |  |
| regulation_orange | #FF8A00 | #FF8A00 | — | #FF8A00 | #FF8A00 |  |
| regulation_red | #F62E24 | #FF4339 | — | #F62E24 | #FF4339 |  |
| regulation_bluetooth | #0082FC | #0082FC | — | #0082FC | #0082FC |  |

### Surface

원문 이미지: `system-color-surface-d06b9b9d696cedf82963437c12832af3.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| surface_basic | basic_00 | basic_50 | — | #FFFFFF | #1D1E21 |  |
| surface_low | basic_50 | basic_00 | — | #F7F8FA | #131417 |  |
| surface_high | basic_100 | basic_100 | — | #EDEEF2 | #313236 |  |
| surface_accent | basic_200 | basic_200 | — | #E0E1E6 | #44464E |  |

### Switch

원문 이미지: `system-color-switch-33bed2234a2b0da3b2467160e60d09c6.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| switch_on | informative_active | informative_active | — | #02C265 | #00E074 |  |
| switch_off | alpha_dark_300 | alpha_dark_100 | — | #131417 @ 30% | #FFFFFF @ 10% |  |
| switch_disabled | alpha_dark_100 | alpha_dark_100 | — | #131417 @ 10% | #FFFFFF @ 10% |  |
| switch_knob_on | basic_00 | basic_900 | — | #FFFFFF | #FFFFFF |  |
| switch_knob_off | basic_00 | basic_400 | — | #FFFFFF | #A4A8AE |  |
| switch_knob_disabled | basic_00 | alpha_dark_200 | — | #FFFFFF | #FFFFFF @ 20% |  |

### Text

원문 이미지: `system-color-text-e7366a153c7953a16d9d7939a9ce2b25.png`

| Token | Light target | Dark target | Old name | Light resolved | Dark resolved | Note |
| --- | --- | --- | --- | --- | --- | --- |
| text_dark_primary | static_dark_100 | static_light_100 | — | #131417 | #FFFFFF |  |
| text_dark_secondary | static_dark_200 | static_light_200 | — | #131417 @ 84% | #FFFFFF @ 84% |  |
| text_dark_tertiary | static_dark_300 | static_light_300 | — | #131417 @ 64% | #FFFFFF @ 64% |  |
| text_dark_quaternary | static_dark_400 | static_light_400 | — | #131417 @ 32% | #FFFFFF @ 32% |  |
| text_light_primary | static_light_100 | static_dark_100 | — | #FFFFFF | #131417 | 웹 하단4행의 dark 이름 중복: 같은 웹의 static_light→static_dark 값 패턴에 따라 light 이름으로 구분; sourceToken 보존. Figma는 부수 확인. |
| text_light_secondary | static_light_200 | static_dark_200 | — | #FFFFFF @ 84% | #131417 @ 84% | 웹 하단4행의 dark 이름 중복: 같은 웹의 static_light→static_dark 값 패턴에 따라 light 이름으로 구분; sourceToken 보존. Figma는 부수 확인. |
| text_light_tertiary | static_light_300 | static_dark_300 | — | #FFFFFF @ 64% | #131417 @ 64% | 웹 하단4행의 dark 이름 중복: 같은 웹의 static_light→static_dark 값 패턴에 따라 light 이름으로 구분; sourceToken 보존. Figma는 부수 확인. |
| text_light_quaternary | static_light_400 | static_dark_400 | — | #FFFFFF @ 32% | #131417 @ 32% | 웹 하단4행의 dark 이름 중복: 같은 웹의 static_light→static_dark 값 패턴에 따라 light 이름으로 구분; sourceToken 보존. Figma는 부수 확인. |

### Figma 값과 다른 행

모든 행의 구현 결정은 Web target이다. Figma 열은 출처 감사용이다. 원본 Figma component snapshot의 HEX를 이 표의 구현값 위에 다시 적용하지 않는다. 비교는 assets의 주 Color collection과 이름/역할을 명시적으로 대응시킨 일부 imported collection을 대상으로 하며 collection/key를 JSON에 별도로 보존했다.

| Token | Mode | Web target → resolved (구현) | Figma token @ ID → resolved (기록) |
| --- | --- | --- | --- |
| button_switch_pressed | dark | basic_alpha_dark_200 → #FFFFFF @ 20% | button/switch/pressed @67:22165 → #FFFFFF @ 10% |
| button_switch_disabled | dark | basic_alpha_dark_300 → #FFFFFF @ 30% | button/switch/disabled @67:22166 → #131417 @ 30% |
| controller_stepper_background | dark | basic_alpha_light_100 → #131417 @ 10% | controller/stepper_background @67:25149 → #FFFFFF @ 10% |
| driving_charging_deep | dark | #0082FC → #0082FC | Miscellaneous/Charging/deep @67:5027 → #00B975 |
| keyboard_normal_secondary_pressed | dark | basic_200 → #44464E | keyboard/normal/secondary_pressed @67:5049 → #686A72 |
| keyboard_static_secondary_pressed | dark | basic_200 → #44464E | keyboard/static/secondary_pressed @67:5058 → #686A72 |
| keyboard_static_background | dark | basic_100 → #313236 | keyboard/static/background @67:5063 → #131417 |
| keyboard_static_icon_light | dark | basic_400 → #A4A8AE | keyboard/static/icon_light @67:5064 → #FFFFFF |
| keyboard_static_icon_dark | dark | basic_400 → #A4A8AE | keyboard/static/icon_dark @67:5065 → #131417 |
| keyboard_static_text | light | basic_700 → #313236 | keyboard/static/text @67:5067 → #FFFFFF |
| keyboard_static_text | dark | basic_400 → #A4A8AE | keyboard/static/text @67:5067 → #FFFFFF |

### 웹 자체의 표기 충돌과 해석 결정

- Alpha 12행: 인쇄 RGB는 dark 계열의 Light=#FFFFFF/Dark=#131417, light 계열은 그 반대다. 같은 웹의 swatch는 dark 계열 Light가 짙은 전경색의 투명도 증가, Dark가 흰색 전경을 나타내고 light 계열은 그 반대다. 토큰의 dark/light 이름과 해당 전경색 사용 맥락에 따라 구현 RGB 방향을 위 표처럼 해석했다. 인쇄된 RGB 방향은 위 표의 원문 열에 보존했다. 이는 웹 내부 모순의 명시적인 해석이며 Figma의 구버전 값을 웹 위에 덮은 결정이 아니다.
- Icon/Text 하단 4행씩: token name이 dark로 중복 인쇄되지만 같은 행의 Light target는 static_light, Dark target는 static_dark다. 값은 웹 그대로 유지하고 고유 코드 이름만 light로 구분했다. JSON에 sourceToken을 보존했다.
- Media 4행: primary의 8자리 HEX는 보라/파랑 불투명 swatch와 맞는 RGBA, gradient는 투명 start와 불투명 end에 맞는 ARGB로 해석했다. 위 표의 RGB+alpha를 사용한다.
- 여러 semantic PNG의 swatch가 인쇄 target과 다르다. 예를 들어 driving_charging_deep Dark는 초록 swatch이지만 HEX 문구는 #0082FC다. 이 부록의 semantic 구현값은 인쇄 target를 따른다. swatch로 웹 target를 임의 복원하지 않는다. JSON의 swatchSample은 합성된 그림의 관찰값이며 alpha를 역추정한 primitive가 아니다.
- sourceToken/sourceLight/sourceDark, PNG 파일명, row index, Figma node ID·collection·key는 JSON에 보존했다. Figma와 웹이 다른 값은 모두 웹 우선으로 확정했다.

합계: primitive 31행, semantic 118행, Figma 비교값 차이 11개(mode별).
