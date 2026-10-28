# Figma 상세 컴포넌트 부록 인덱스

> **원본 부록:** 웹과 다른 옛 값은 이력이다. 최신 구현은 01·02·03·08번의 웹 최종값을 적용한다. 원본 snapshot 색을 새 웹 token 위에 다시 덮지 않는다.

각 파일은 하나의 구현 영역에 해당한다. 먼저 공통 토큰과 구현 프롬프트를 읽고, 해당 영역을 구현할 때 이 부록을 찾아 필요한 variant 및 하위 레이어만 읽는다. 전체 파일을 한 번에 컨텍스트에 넣을 필요는 없다.

| File | Masters | Bytes |
| --- | ---: | ---: |
| 10_figma_actions.md | 104 | 363208 |
| 11_figma_sliders.md | 50 | 147952 |
| 12_figma_stepper.md | 1 | 6003 |
| 13_figma_dropdown.md | 18 | 303236 |
| 14_figma_fields.md | 20 | 65831 |
| 15_figma_navigation.md | 9 | 249394 |
| 16_figma_popups.md | 11 | 367021 |
| 17_figma_tabs.md | 29 | 203662 |
| 18_figma_selections.md | 27 | 47058 |
| 19_figma_spinner.md | 7 | 64368 |
| 20_figma_notification.md | 10 | 94182 |
| 21_figma_bars.md | 6 | 9849 |
| 22_figma_display_support.md | 10 | 17995 |

assets 대상 master 292개를 중복 없이 분할했다. display 지원 master10개는 다른 원본 파일이므로 별도 유지한다.

display 부록의 `utility/indicator`는 차량 utility 내부 구성 요소이며, 웹의 일반 Indicator와 같은 공개 API라는 증거는 없다. `ivi_window_bar`는 원본에 같은 이름의 다른 master2세트(각3variants)가 있으므로 ID로 식별한다.
