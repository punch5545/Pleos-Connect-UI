# 설계 명세 재대조

사용자의 재검토 요청에 따라 00~08·컴포넌트 부록·토큰 JSON·동봉 자산을 실제 소스와 다시 대조하고 아래 항목을 수정했습니다. 웹 우선 정책과 샘플/카탈로그 제외 지시를 유지했습니다. 검증 결과와 한계는 [VERIFICATION.md](VERIFICATION.md)에 기록합니다.

| ID | 대조 결과와 적용한 수정 | 근거 |
| --- | --- | --- |
| A01 | 종류·상태·슬롯·로딩 폭 유지 대조, 새 필수 누락 없음 | 02 §2, 10_figma_actions |
| A02 | On/Off·Floating·Small disabled 웹 우선 대조, 새 필수 누락 없음 | 02 §3, 08 |
| A03 | 크기·밑줄·로딩·양쪽 슬롯 대조, 새 필수 누락 없음 | 02 §4 |
| A04 | 비활성 Plain이 잔여 pressed 입력 때문에 배경을 표시하지 않게 보정 | 02 §5 |
| A05 | Submit 기능키를 canDelete와 분리, 숫자 disabled 색, Shift 활성 색·정렬과 Static icon 색, Voice 입력 제한 보정 | 02 §6, 원본 67:22949/22988 |
| B01 | Scrollbar의 키보드 편집과 접근성 증감, Window bar 키보드 조절·모션 제한 대조 | 02 §7, 04 §3 |
| C01 | 방향 화살표·track 내 icon 슬롯·5 volume 구간, 크기별 track 반경, Centered 값 영역과 서체/여백, Stepper 전체 action 영역 보정 | 02 §8, 11_figma_sliders 67:24499 |
| I01 | Wide/Narrow·0/1/N·정보/대화형 대조, 위젯 전용 점 간격 주입점 추가 | 02 §9, 03 §13 |
| D01 | Footer 정확한 높이, prefix/suffix/New 및 메뉴 gap/border의 모드 바인딩 보정, 600 최대 폭 제한 제거 | 02 §10, 13_figma_dropdown |
| F01 | ReadOnly 포커스 테두리, 표시 중인 비밀번호도 보호 의미론 유지 | 03 §1 |
| F02 | 큰 글자 배율에서 숫자 셀 높이 확장 | 03 §2, 공통 글자 배율 |
| N01 | Main 앱 아이콘과 메뉴 간격·Depth icon, Search 추가, header 배경/divider, 모드 바인딩과 전용 메뉴 primitive | 03 §3, 원본 67:27623/27641/27601 |
| P01 | radius와 padding 별도 바인딩, 큰 header title 내부 여백, header/body 분리와 우선 스크롤, 좁은 높이의 action 하단 배치, action 숨김과 Escape 정책 | 03 §4, popup/system 토큰 |
| P02 | 빈 메시지 제외, icon 변경에 따른 무의미한 timer 재시작 방지 | 03 §5·12 |
| T01 | 외부 선택 항목으로 자동 스크롤, prefix icon 모드 바인딩 | 03 §6 |
| S01 | Off/On/Mixed·9 상태·원본 icon 대조, pressed overlay가 체크 표시를 가리지 않도록 순서 보정 | 03 §7 |
| S02 | RadioGroup의 행 pressed를 시각 control에도 전달하고 선택된 Radio의 흰색 중심을 유지 | 03 §8 |
| S03 | 12 상태·RTL·현재 knob 위치·단일 입력 소유권 대조 | 03 §9 |
| SP01 | 웹 폭/열/행 우선 유지, 날짜·시간 확정/거부·모드 높이·heading 및 합성 폭 대조 | 03 §10 |
| SN01 | imagery/badge·간격/패딩의 모드 바인딩, header 최소 높이·위 정렬, Call 로딩 측정 유지 | 03 §11 |
| TO01 | 빈 메시지 제외·독립 message API·아이콘 모드 치수·수명 계약 대조 | 03 §12 |
| W01 | Handle에서만 수직 숨김, 자식 action의 방향키 소유권, Hidden 페이지 보존·중복 포커스, 세로 스크롤 부모와의 방향 소유권, 18 간격 pagination·별도 24/32 서체·공개 보완 metrics | 03 §13 |

최초 소스 해시는 `docs/verification/re-audit/baseline.json`, 읽기 전용 Claude CLI 검토는 같은 폴더의 `claude-spec-review.txt`에 보존합니다. 원본 픽셀 일치와 실차/OEM 검증의 기존 한계를 유지합니다.

후속 검토는 `claude-post-fix-review.txt`에 보존합니다. 최초 Footer의 두 P1 지적은 같은 구조 결함을 다른 관점으로 보고한 것이어서 중복 결함으로 집계하지 않습니다. Toast의 과거 모드별 최대폭 회귀 제안은 01 §2.1·08의 웹 우선 정책에 따라 적용하지 않았으며, 토큰 키와 주입점은 보정했습니다.

마지막 읽기 전용 검토는 `claude-final-focused-review.txt`입니다. 기존 지적의 해결 여부를 확인했으며, 남은 슬라이더 폭·최소 높이·포커스 반경의 주입점도 추가했습니다. 실제 모드 변수가 없는 폭에는 임의 비율을 적용하지 않고 공식 기본값과 공개 override를 유지합니다. 낮은 창에서 세로 action 두 개도 접근할 수 있도록 버튼 영역의 스크롤을 추가하고 회귀 검사에 포함했습니다.

명세 재대조 회귀 검사는 [PleosSpecRegressionTest.kt](pleos-compose/src/androidTest/java/com/jade/pleos/compose/PleosSpecRegressionTest.kt)에 있습니다. 최초 소스 대비 변경 목록과 패치는 `docs/verification/re-audit/source-change-summary.json`, `source-changes.patch`로 제공합니다. AAOS adapter 소스와 세 모듈 구성·도구 버전은 변경하지 않았습니다.
