# 07 — 첨부 Figma 컴포넌트 상세·추출 범위·적용 방법

## 1. 원본 식별과 분석 범위

두 파일 모두 ZIP 컨테이너 안의 `canvas.fig`를 직접 읽고, 각 파일에 내장된 Kiwi schema로 노드·속성·변수·도형 경로를 디코딩했다. 썸네일만 보고 규격을 추정한 결과가 아니다. 원본은 수정하지 않았다.

| 구분 | design assets | display guide |
| --- | --- | --- |
| 원본 파일 | `Pleos_Connect_design_assets_215(1).fig` | `Pleos_Connect_display_guide_215.fig` |
| 파일 크기 | 2,477,386 bytes | 44,427,926 bytes |
| 내부 문서명 | Pleos_Connect_design_assets_215 | Pleos Connect display guide 2.1.5 |
| 내장 export timestamp | 2026-10-16T06:58:20.025Z | 2026-09-30T02:32:53.359Z |
| canvas format | fig-kiwi version106 | fig-kiwi version106 |
| 전체 노드 | 4,548 | 13,278 |
| SYMBOL 노드 | 567 | 1,318 |
| INSTANCE 노드 | 859 | 1,840 |
| VARIABLE 노드 | 722 | 1,009 |
| COLOR / FLOAT / STRING 변수 | 209 / 512 / 1 | 278 / 726 / 5 |
| VARIABLE_SET | 17 | 31 |
| binary geometry blob | 2,908 | 7,424 |
| ZIP 내 raster image | 21 | 169 |
| 고아 노드 | 0 | 0 |

SHA-256:

- assets: `64ddc591e4a12f765c1d3b4b36473c22c3de312c78b241aab1bf9b680a228db6`
- guide: `2283dfc1dfe871cf14fd8e15ee8831441125ef5ec471909fa17d1a03cf0bd25b`

assets에는 `✦ Foundation`, `❖ Components`, `Internal Only Canvas`가 있다. display guide에는 `Form factors & Display`, `Internal Only Canvas`가 있다. 내부 canvas에 포함된 플랫폼 디자인과 imported master는 일반 앱이 제어할 수 있는 기능 범위라는 뜻이 아니다.

## 2. 구현용 부록 구성

`05_FIGMA_ASSET_TOKENS.md`는 assets의 722개 변수를 모두 포함하고, `06_FIGMA_DISPLAY_TOKENS.md`는 guide의 1,009개 변수를 모두 포함한다. 같은 이름이라도 원본 collection/node/key가 다르면 별도 행으로 유지한다. COLOR의 Light/Dark를 비롯한 모든 모드 값과 FLOAT의 form-factor별 값을 보존한다. 이 표를 읽는 데 `.fig` 파서나 네트워크는 필요 없다.

`appendices/figma_components/00_INDEX.md`의 가족별 부록에는 assets의 구현 관련 master292개를 중복 없이 배분했다. 모든 master와 자식 레이어를 전개하면 5,924개 레이어다. INSTANCE는 master 기본값에 `symbolOverrides`, `derivedSymbolData`, component property assignment를 합성했다. 중첩 instance의 텍스트·visible·geometry도 적용했으며 외부 master 누락은 0개다. 별도 display 부록에는 window bar, fullscreen, utility indicator 관련 master10개와 47개 레이어를 보존했다.

| 구현 영역 | assets master 수 | 대표 구조 |
| --- | ---: | --- |
| Actions | 104 | basic18, toggle18, text6, icon18, numeric keypad8, normal keypad18, static keypad18 |
| Sliders | 50 | centered6, centered track6, knob2, continuous4, common track20, slider buttons12 |
| Stepper | 1 | `ivi_stepper` |
| Dropdown | 18 | dropdown2, menus2, button6, item8 |
| Fields | 20 | text12, number8 |
| Page Navigation | 9 | header6, title3 |
| Popups | 11 | system4, header2, actions2, example content1, toast popup2 |
| Tabs | 29 | solid9, goast_button10, line2, line_button8 |
| Selections | 27 | checkbox9, radio6, switch12 |
| Spinner | 7 | spinner4, wheels3 |
| System Notification | 10 | container3, button4, images3 |
| Bar 지원 master | 6 | app bar3, scroll bar3 |

위 수는 공개 API 개수를 의미하지 않는다. 하나의 Kotlin 컴포넌트가 여러 Figma variants를 표현한다. `goast_button`, `Diabled`, `icon_sqaure` 같은 원본 이름 오타는 traceability를 위해 보존하되, 공개 Kotlin 이름은 일관된 철자를 사용하고 매핑을 남긴다.

## 3. 단위·모드 적용 시 주의할 실제 자료 차이

모든 노드 `size`, `padding`, `radius`, `fontSize`는 파일에 저장된 design unit이다. 예를 들어 basic large height는 form-factor mode에 따라 Connect-S100, Connect-L88, Connect-W84, Waterfall106이다. S의 수치를 단일 비율로 축소해 모든 변형을 만드는 방식으로 치환하지 않는다. 각 토큰에 저장된 mode 값을 우선 사용하고, 런타임 dp/sp 환산 및 디스플레이 프로필 선택은 메인 구현 프롬프트의 규칙을 적용한다.

여러 collection에 `connect-waterfall` 앞 U+0008 제어문자가 포함되어 있다. 동일한 원본 mode ID가 없을 때, 제어문자를 제거한 이름이 유일하게 일치하는 다른 collection의 mode ID와 연결했다. assets11개, guide74개 alias entry가 이 정규화를 거쳤다. 원본 이름·요청 ID·연결 ID를 각 토큰 부록 끝에 모두 기록했다. 정규화 후 미해결 변수 entry, 외부참조 누락, 순환참조는 모두 0개다. 값 자체는 대상 entry에 저장된 원본 숫자/색상을 사용했다.

HEX는 `#RRGGBBAA` 순서다. Android ARGB의 `#AARRGGBB`와 혼동하지 않는다. 노드 스타일 부록에 표시된 fill/stroke HEX는 snapshot의 color alpha와 paint opacity를 합성한 값이며, 별도 node opacity가 있으면 추가로 적용한다. 테마 토큰을 새로 적용하면서 snapshot alpha를 다시 곱하는 식의 이중 감쇠를 하지 않는다.

`root xy`는 Figma 보드 배치 좌표이므로 앱 배치 좌표가 아니다. 자식 xy는 부모 상대 위치다. root width도 예제 label에 맞춘 결과일 수 있으며, 별도의 min/max 및 Auto Layout sizing을 함께 읽는다. Figma에서 숨겨진 prefix/suffix/icon/label은 옵션의 기본 false 예시일 수 있으므로 구현에서 없애지 않는다.

## 4. 웹과 Figma의 근거 구분

- 웹에 소개된 전체 컴포넌트를 구현 범위로 유지한다. Figma에 별도 master가 없다고 해당 컴포넌트를 삭제하지 않는다.
- assets의 Icon button master는 Medium/Small18개다. 웹의 Large 소개는 별도 규격 보완 대상으로 취급한다.
- 일반 웹 Indicator와 Widgets의 완성된 독립 master는 assets Components에서 확인되지 않는다. display guide의 `utility/indicator`는 플랫폼 내부 utility 구성 요소이며 일반 Indicator와 같은 API라고 단정하지 않는다.
- 독립 웹 Toast 항목과 Figma `ivi_toast_popup`를 이름만 보고 중복 제거하지 않는다. 웹 동작/배치 구분을 유지한다.
- Foundation 타이포 표 안의 Typeface 문자열은 Manrope다. 그러나 current 컴포넌트 텍스트는 Asta Sans이며, imported legacy style에는 42dot Sans OTF가 남아 있다. 메인 프롬프트의 현재 Asta Sans 선택을 우선하고, 오래된 표 문자열을 근거로 컴포넌트 폰트를 Manrope로 바꾸지 않는다.
- 사용자 지시에 따라 웹을 최신 버전으로 간주한다. 웹과 Figma에서 색/규격이 충돌하면 웹의 명시값을 적용하고, 메인 프롬프트의 conflict ledger와 canonical override를 따른다. Figma 추출값은 웹에 없는 세부 규격을 보완하고 출처를 감사하는 자료다. 원본 Figma 표에 다른 값이 보인다는 이유로 최신 웹 값을 다시 덮거나 별도 구버전 런타임 profile을 만들지 않는다.
- Figma 파일은 폰트 이름·메트릭·일부 글리프 outline을 포함하지만 재배포 가능한 TTF/OTF font binary는 제공하지 않는다. 기본 라벨 글리프를 추출해 일반 폰트를 합성하지 않는다. 폰트 공급 및 fallback 정책은 메인 프롬프트를 따른다.

## 5. 벡터 자산

assets에서 fill/stroke geometry 명령1845개를 M/L/Q/C/Z SVG path로 디코딩했으며 명령 해석 오류0개다. 일반 컴포넌트와 관련된 pure-vector icon80개를 `assets/icons/`에 생성했고, 같은 내용을 `appendices/09_ICON_PATHS.md`의 SVG 코드블록에도 모두 넣었다. 실제 아이콘에 사용한 path는217개다. `assets/icons/manifest.json`은 node ID·이름·파일·viewport를 대응시킨다.

80개 SVG 모두 XML/렌더 입력으로 읽혔고, SVG→PNG 렌더 및 전체 montage 시각 검사를 통과했다. 화살표, 체크, 닫기, 메뉴, 더보기, 키보드 키, 눈, 볼륨, 정보, 라디오/체크 컨트롤에서 쓰는 glyph 등에 뚜렷한 누락이나 깨진 경로는 보이지 않았다. 이는 Figma 공식 renderer와 픽셀 비교를 완료했다는 뜻은 아니다.

`data-pleos-token` 속성은 원본 semantic color token을 기록한다. VectorDrawable/ImageVector 변환에서 path 좌표, winding rule, transform, alpha를 보존한다. SVG가 viewport48이라고 해서 모든 사용처에서48로 고정하는 것은 아니다. 상위 컴포넌트 icon slot 크기를 적용한다.

`ic_app`(67:25561)은 raster image와 gradient가 섞여 있어 pure-vector 목록에서 제외했다. 소비 앱의 실제 app icon을 slot으로 제공한다. 법규 telltale 전체와 앱 커버 이미지는 이 일반 아이콘 부록의 범위에 포함하지 않았다. `ic_grid`3개는 디자인 그리드 참고 자산이며 런타임 버튼 아이콘으로 사용하지 않는다.

## 6. 사용 순서

1. 메인 구현 프롬프트와 foundation/AAOS 규칙을 읽는다.
2. 구현할 컴포넌트의 웹 의미·동작·variant 요구사항을 읽는다.
3. 대응 Figma family 부록에서 variant, 자식 레이어, optional property, style/binding을 확인한다.
4. 웹의 최신 컬러/규격 표를 먼저 적용하고, 전체 Figma 토큰 표에서는 웹에 없는 값의 정확한 collection/key/모드를 찾아 코드 토큰에 매핑한다.
5. 필요한 SVG만 ImageVector/VectorDrawable로 변환하고, screenshot 검증 및 상태·접근성 테스트를 수행한다.

이 결과는 구현 지시를 위한 구조화 설계 증거다. Android SDK 권한, window 관리자 권한, 안전 규제, 제품 문구, 상태 전이 시간, 실제 사용자 데이터 모델을 Figma가 자동으로 확정해 주지는 않는다. 그 항목은 메인 프롬프트에 명시된 플랫폼 제약과 구현 결정으로 처리한다.


## 7. 실제 동봉 경로와 읽을 장

다음 파일에는 추출한 master별 이름·ID, variant property, Auto Layout, width/height, padding/gap, radius, visibility, 색·변수 binding, 텍스트 속성과 전개된 자식 레이어를 기록했다. **각 표는 Figma 원본의 증거이며 최신 웹 override는 01·02·03·08번에서 적용한다.** 공개 컴포넌트를 구현할 때 필요한 속성을 찾아 읽고, 문서 장식과 runtime 요소를 구별한다.

| 파일 | 대상 | master 수 |
| --- | --- | ---: |
| `appendices/figma_components/10_figma_actions.md` | Basic/Toggle/Text/Icon/Keypad | 104 |
| `appendices/figma_components/11_figma_sliders.md` | Continuous/Centered, track, knob, button | 50 |
| `appendices/figma_components/12_figma_stepper.md` | Stepper | 1 |
| `appendices/figma_components/13_figma_dropdown.md` | Dropdown, menu, trigger, item | 18 |
| `appendices/figma_components/14_figma_fields.md` | Text/Number Field | 20 |
| `appendices/figma_components/15_figma_navigation.md` | Navigation header/title | 9 |
| `appendices/figma_components/16_figma_popups.md` | System/Toast Popup, header/actions/body | 11 |
| `appendices/figma_components/17_figma_tabs.md` | Box/Line, 항목 상태 | 29 |
| `appendices/figma_components/18_figma_selections.md` | Checkbox/Radio/Switch | 27 |
| `appendices/figma_components/19_figma_spinner.md` | Date/Time, wheel | 7 |
| `appendices/figma_components/20_figma_notification.md` | Notification container/button/image | 10 |
| `appendices/figma_components/21_figma_bars.md` | App control/Scroll bar | 6 |
| `appendices/figma_components/22_figma_display_support.md` | display 원본의 window/utility 지원 자료 | 10 |

일반 Indicator·Widgets는 웹의 02·03번 규격을 구현한다. 대응 독립 master가 확인되지 않았다는 이유로 빈 구현을 만들지 않는다. 12번 Stepper 부록의 폭420/중앙148, 16번 Popup 부록의 폭808 등은 옛 값이므로 본문 웹 최종값으로 교체한다.

## 8. 이름과 코드 토큰의 연결

`appendices/10_COLOR_TOKEN_MAPPING.md`는 웹149행의 canonical 이름, Figma 이름/ID/key/collection, 단순 slash 치환으로 연결되지 않는30개 별칭, old name9개, 웹에 없는 divider 보완 역할을 모두 설명한다. 웹 행 중127개는 design-assets 변수와 직접 대응하며22개는 해당 파일에서 ID/key가 확인되지 않아 null로 보존했다. 미확인 웹 행도 웹 값으로 구현한다. 토큰 값 자체는01번이 최종값이다.

같은 `divider/secondary` 이름이 다른 imported collection에도 존재하므로 이름만으로 합치지 않는다. 기본 컴포넌트의 divider는 명시된 주 collection `2:15157`의 primary5%, secondary10%, tertiary20% alpha로 연결한다. `controller/slider/knop`은 `controller_slider_knob`, `phone/accept_normal`은 `phone_call_normal`이다.

전체 변수의 기계 판독용 복제본은 `data/figma_asset_tokens.json`, `data/figma_display_tokens.json`이다. 구조화 데이터의 원본 ID와 key는 삭제하지 않고 코드 생성 provenance에 남긴다. Markdown 토큰 표와 값은 동일한 추출 결과다. 최신 웹 값은 `data/web_color_tokens.json`, 충돌은 `data/web_color_conflicts.json`, 이름 대응은 `data/web_color_alias_mapping.json`이다.

## 9. 원본 충실도와 검증 범위

추출 완료는 Android 구현이 이미 존재하거나 픽셀 일치 검증을 완료했다는 뜻이 아니다. 숫자·variant·binding을 보존한 데이터, 실제 SVG 경로와 컴포넌트별 구현 계약을 입력으로 제공한 것이다. 구현 LLM은 코드와 카탈로그를 만든 후 04번의 검증을 수행한다.

현재 확인되지 않은 모든 항목을 추정 없이 공식값으로 채울 수는 없다. 해당 항목은 08번의 미정의 목록과 명시적 기본값을 따라 구현하고, 추후 정확한 원본을 받으면 토큰이나 adapter 한 곳에서 교체할 수 있도록 한다.
