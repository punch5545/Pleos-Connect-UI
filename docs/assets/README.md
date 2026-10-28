# 동봉 폰트·아이콘 사용 지침

이 폴더는 웹을 열 수 없는 구현 환경에서 필요한 글꼴과 벡터 경로를 제공한다. 문서의 최종 토큰과 컴포넌트 치수를 적용하여 Android 리소스로 변환한다.

## Asta Sans

- `fonts/asta_sans_variable.ttf`: Asta Sans variable font. 버전은 1.000, weight 범위는 300~800, 기본 축 값은 300이다. Regular 400/Bold 700/ExtraBold 800을 명시적으로 선택한다.
- `fonts/OFL.txt`: SIL Open Font License. 배포물에 보존한다. 폰트 바이너리를 수정하는 경우 라이선스의 이름·수정 조건도 따른다.
- `fonts/source.json`: 다운로드 출처, Git blob, 정확한 SHA256을 담고 있다.

Kotlin/Android의 로컬 font resource로 포함하고 런타임 다운로드를 필수로 하지 않는다. variable font를 직접 사용할 수 없는 도구 환경에서는 이 원본으로부터 필요한 weight의 static font를 생성하거나, host의 FontFamily 주입을 허용한다. 시스템 기본 글꼴로 fallback한 결과를 Asta Sans와 동일하다고 표시하지 않는다.

## SVG 80개

`icons/manifest.json`은 원본 node ID·이름·파일·viewport·pathCount를 대응시킨다. 실제 파일은 `icons/*.svg`이며, 동일한 코드를 `../appendices/09_ICON_PATHS.md`에도 모두 넣었다. 따라서 텍스트 입력만 가능한 경우에도 SVG를 복원할 수 있다.

원본 fill/stroke geometry의 명령 1845개를 해석해 아이콘 80개와 path 217개를 생성했다. XML 입력·렌더 검사와 전체 montage의 시각 검사를 수행했다. Figma 공식 renderer와 Android 출력을 픽셀 단위로 비교한 것은 아니다. 사용자가 제공한 원본 Figma 디자인 자산의 권리는 그대로 유지된다. 본문·자산에 별도의 임의 오픈소스 라이선스를 붙이지 않는다.

변환 규칙:

1. `viewBox`, `path d`, transform, fill rule, stroke/fill opacity를 보존한다. 가능한 경우 변환을 좌표에 적용하여 ImageVector/VectorDrawable의 동등한 path로 옮긴다.
2. `data-pleos-token`은 원본 semantic 참조 metadata다. 실제 runtime 색은 최신 웹 토큰과 현재 상태에 연결한다. 기존 snapshot alpha와 token alpha를 중복해서 곱하지 않는다.
3. 외곽 size는 사용처의 icon slot 토큰을 따른다. viewport 48을 모든 컴포넌트의 고정 48dp로 오인하지 않는다.
4. 의미상 방향성이 있는 뒤로 가기/탐색 아이콘만 RTL에서 반전한다. 숫자·차량·브랜드 이미지를 일괄 반전하지 않는다.
5. 이름이 중복되거나 오타가 있는 경우 manifest ID를 보존하고 Kotlin 공개 이름만 안정적으로 정규화한다.

`ic_app`의 raster+gradient 혼합 아이콘, 사진·커버·차량 이미지, 전체 법규 telltale은 이 80개 목록에 포함되지 않는다. 해당 컴포넌트는 Image/Painter slot으로 실제 앱 자산을 받는다. `ic_grid` 3종은 제작 참고용 그리드이며 runtime action으로 노출하지 않는다.

## 구조화 데이터

`../data`의 JSON은 Markdown 수치표의 기계 판독용 복제본과 provenance를 담고 있다. 최신 색상은 `web_color_tokens.json`, 이름 연결은 `web_color_alias_mapping.json`, 원본 변수는 `figma_asset_tokens.json`과 `figma_display_tokens.json`에 있다. 원본 Figma 토큰이 현재 웹의 값을 덮어쓰지 않도록 코드 생성 순서를 고정한다.
