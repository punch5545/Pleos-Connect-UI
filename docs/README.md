# Pleos Connect AAOS Kotlin 라이브러리 구현 프롬프트

이 묶음은 **웹 검색을 할 수 없는 LLM에게 전달하는 구현 지시서**다. Pleos Connect 웹 가이드와 사용자가 첨부한 두 Figma 파일을 분석해 22개 컴포넌트의 종류·크기·상태·동작·토큰·실제 벡터 경로·AAOS 계약을 정리했다. Kotlin 라이브러리 자체를 이미 구현한 결과물은 아니다.

**사용자가 확정한 우선순위: 웹 버전을 최신으로 간주한다.** 웹과 첨부가 충돌하면 웹의 값을 사용하고, 웹에 없는 세부 값만 첨부로 보완한다. 조사 스냅샷의 기준일은 2026-10-28 UTC다.

## 바로 사용하는 방법

1. 압축 파일을 풀고 이 폴더 전체를 구현 LLM이 읽을 수 있는 프로젝트나 작업 공간에 넣는다.
2. 아래 실행 문구를 입력한다.
3. 모델이 문맥 한도 때문에 한 번에 모든 부록을 읽을 수 없으면, 00의 실행 순서에 따라 공통 문서와 작업 중인 컴포넌트의 부록을 나누어 읽게 한다. 전체 토큰·변형 목록은 삭제하지 않는다.

```text
00_MASTER_PROMPT.md를 실행 지시로 삼아 Pleos Connect AAOS Kotlin UI 라이브러리를 구현하라.
같은 폴더의 01~08 문서, appendices, assets, data를 설계 입력으로 사용하라.
웹 버전을 최신으로 간주하고, 웹과 첨부가 상충하는 값은 08의 최종 결정표를 적용하라.
웹 검색이나 Figma 접속 없이 동봉 명세로 작업하라.
22개 컴포넌트의 모든 필수 변형, 카탈로그 앱, 공개 API, 검증과 개발자 문서를 완성하라.
미정의 값은 문서에 표시된 구현 기본값을 사용하고 SPEC_DECISIONS.md에 기록하라.
```

## 문서 구성

| 파일/폴더 | 내용 |
| --- | --- |
| `00_MASTER_PROMPT.md` | LLM의 역할·필수 범위·실행 순서·완료 조건 |
| `01_FOUNDATIONS_AND_DISPLAY.md` | Light/Dark 색상 149행, 타이포그래피, 그림자, Loading의 실제 모션, 디스플레이·단위 |
| `02_ACTIONS_BARS_CONTROLLERS.md` | Actions 5종, Bar, Controllers, Indicator, Dropdown |
| `03_FIELDS_NAVIGATION_FEEDBACK.md` | 나머지 13개 컴포넌트의 전체 명세 |
| `04_AAOS_API_AND_ACCEPTANCE.md` | Kotlin API·상태 계약·AAOS/rotary·접근성·검증 |
| `05_FIGMA_ASSET_TOKENS.md` | 첨부 design assets의 원본 변수 722개·모드·alias |
| `06_FIGMA_DISPLAY_TOKENS.md` | 첨부 display guide의 원본 변수 1009개·모드·alias |
| `07_FIGMA_COMPONENT_DETAILS.md` | 추출 범위·실제 부록 경로·계층 해석·원본 식별 |
| `08_SOURCES_CONFLICTS_AND_COVERAGE.md` | 웹 우선 최종값·오류 보정·미정의 항목·22개 컴포넌트의 범위 |
| `appendices/figma_components/` | 13개 영역의 상세 부록과 인덱스; assets의 master 292개·레이어 5924개 및 display 지원 master 10개 |
| `appendices/09_ICON_PATHS.md` | SVG 80개의 전체 코드·path 217개 |
| `appendices/10_COLOR_TOKEN_MAPPING.md` | 최신 웹 이름과 Figma ID/key/별칭의 매핑 |
| `appendices/11_WEB_SOURCE_INDEX.md` | 확인한 핵심 페이지 29개와 도해 참조 137개의 출처 |
| `assets/` | Asta Sans 폰트·OFL·SVG 80개·자산 사용 지침 |
| `data/` | 토큰·이름 매핑·충돌·출처의 JSON 복제본 |

토큰 722개와 1009개는 각각의 원본 파일에 있는 variable 레코드 수다. 두 파일에 역할이 중복되는 항목이 있으므로, 고유한 공개 토큰이 1731개라는 뜻은 아니다. master 292개도 공개 컴포넌트의 개수를 뜻하지 않는다. 실제 필수 최상위 범위는 22개 말단 컴포넌트다.

## 단일 Markdown 사용 시

별도로 배포한 `Pleos_AAOS_Implementation_Prompt_All_In_One.md`는 이 묶음의 모든 Markdown 문서를 경계 표시와 함께 하나로 합친 문서다. 전체 명세·모드별 토큰·전개된 variant·SVG 코드를 포함한다. 파일 크기가 크므로 파일 검색과 부분 읽기를 지원하는 LLM 환경을 권장한다. 본문에 나오는 상대 파일명은 같은 이름의 `BEGIN FILE` 절에 대응한다.

폰트 바이너리와 구조화된 JSON/SVG 파일은 ZIP에 동봉되어 있다. 단일 Markdown만 전달하는 환경에서는 코드 블록에서 SVG를 복원할 수 있다. 다만 정확한 폰트 바이너리를 사용하려면 ZIP의 `assets/fonts`도 함께 제공해야 한다. 문서 안의 수치와 요구사항을 읽는 데 웹 검색은 필요하지 않다.

## 구현 시 구별해야 할 사항

- Spinner는 Date/Time wheel picker다. 버튼의 Loading indicator는 별도 컴포넌트다.
- System Popup은 모달이고, Toast Popup/Toast는 비모달 피드백이다. 알림 카드의 UI와 OS 시스템 알림 발행은 구분한다.
- Large Icon button의 치수, Widget hidden 규격의 일부, 일반 motion/timeout 등 자료에 없는 항목은 공식값과 별도로 표시했다. 지정된 기본값을 교체할 수 있도록 구현한다.
- 원본 Figma 부록에 과거 값이 남아 있는 것은 출처를 보존하기 위해서다. Stepper 폭 400, Popup Medium 760, Spinner 폭 600/500 등 최신 웹의 최종값을 되돌리지 않는다.
- 테스트 결과·빌드 성공·실차 rotary 호환은 구현 환경에서 실제로 검증한 범위만 보고한다.
