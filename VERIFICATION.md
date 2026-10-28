# 검증 결과

동봉 명세와 실제 구현 22종을 다시 대조하여 수정한 최종 소스의 실행 결과입니다. 웹 검색·Figma 접속은 하지 않았습니다. 세 Android Library만 유지하며, UI 검증용 Activity는 `androidTest`에만 있습니다. 변경 내역은 [SPEC_AUDIT.md](SPEC_AUDIT.md), 구현 보완값은 [SPEC_DECISIONS.md](SPEC_DECISIONS.md)에 기록합니다.

## 실행 환경

| 항목 | 실제 환경 |
| --- | --- |
| 프로젝트 | `/Users/jade/AndroidStudioProjects/PleosConnectUI` |
| AGP / Gradle | 초기 버전 9.4.1 / 9.6.0 유지 |
| Kotlin / Compose compiler | AGP 내장 Kotlin과 같은 2.2.10 |
| Compose UI / Foundation | 1.9.0 고정 |
| JDK | Android Studio 내장 JDK 25, 출력 bytecode 11 |
| Android | compileSdk 37 / minSdk 28 |
| 이번 공용 UI 실행 | Google APIs API 36 arm64, 독립 임시 AVD `PleosSpecAudit` |
| 화면 | 2560×1440, density 160, RAM 4096MB |
| AAOS adapter 계측 | 최초 구현에서 Pleos API 34 arm64로 실행한 기존 결과 보존, 이번에는 재실행하지 않음 |

AAOS adapter 소스는 이번 재대조에서 변경하지 않았습니다. 이번 단위 검사에는 aaos 1개도 포함했습니다. 기존 사용자 AVD를 수정하거나 초기화하지 않고 `/private/tmp`에 전용 AVD를 생성하여 cold boot했습니다. 재대조 실행 로그는 `docs/verification/re-audit/`에 있습니다.

## 최종 실행 결과

| 검증 | 결과 | 근거 |
| --- | --- | --- |
| 릴리스 AAR 3개 | 성공 | [final-build.log](docs/verification/re-audit/final-build.log) |
| 단위 테스트 | 16개 통과, 실패 0 — tokens 6 / compose 9 / aaos 1 | [check-summary.json](docs/verification/re-audit/check-summary.json) 및 모듈별 XML/HTML 보고서 |
| Lint Release | 오류 0, 경고 13 | check-summary.json 및 모듈별 `build/reports/lint-results-release.html` |
| 로컬 Maven AAR·소스·POM·Gradle metadata | 성공, 세 AAR와 게시 AAR의 바이트 일치 | final-build.log, check-summary.json |
| Compose UI 계측 | API 36에서 45개 통과 — 기존 20 + 새 회귀 24 + 변형 표시 검사 1 | [ui-tests-final.log](docs/verification/re-audit/ui-tests-final.log), [ui-summary.json](docs/verification/re-audit/ui-summary.json) |
| 필수 변형 표시 fixture | 444개 표시, 의도하지 않은 초기 콜백 0 | [variant-coverage.txt](docs/verification/re-audit/screenshots/files/variant-coverage.txt) |
| 대표 화면 | 최신 코드의 22종 × Light/Dark = PNG 44개 | [screenshots](docs/verification/re-audit/screenshots/files/pleos-evidence) |
| 설계 입력·생성 자산 | 원본 120개 해시·1731개 토큰·149행 웹 색상·80개 아이콘 통과 | [spec-check.json](docs/verification/re-audit/spec-check.json) |
| 생성 재현성 | 생성기 실행 전후 확인한 121개 파일의 해시 변화 0 | [generator-reproducibility.json](docs/verification/re-audit/generator-reproducibility.json) |
| Claude CLI 정적 검토 | 읽기 전용 검토 3회, 지적 사항 보정·웹 우선에 따른 미적용 결정 기록 | [첫 검토](docs/verification/re-audit/claude-spec-review.txt), [후속 검토](docs/verification/re-audit/claude-post-fix-review.txt), [마지막 검토](docs/verification/re-audit/claude-final-focused-review.txt) |
| AAOS adapter 계측 기존 결과 | 최초 구현의 API 34에서 1개 통과, 이번 재실행 결과가 아님 | [aaos-device-tests.log](docs/verification/aaos-device-tests.log) |

Lint 경고는 업데이트 안내 9개, TOML 사용 권고 3개, 내부 Modifier factory 형태 권고 1개입니다. 버전을 자동 갱신하거나 경고를 일괄 비활성화하지 않았습니다. 변형 fixture 444개는 테스트 메서드 444개라는 의미가 아닙니다. Claude는 정적 대조를 했으며 빌드나 테스트 실행 결과를 대신하지 않습니다. 마지막 검토에서 남았던 슬라이더 치수 주입점을 보정하고 낮은 창의 세로 action 스크롤도 추가한 후 위 45개를 실행했습니다.

## 실제 검증 범위

- 원본 입력 120개 SHA-256, Assets 722개·Display 1009개 토큰의 참조·모드·원본 문자열·순환/미해결 여부, 웹 색상 149행과 충돌 색상 11개를 검사했습니다. SVG 80개·경로 217개, VectorDrawable 경로 수, Asta Sans 동일성, master 추적 항목 302개도 확인했습니다.
- 세 AAR의 클래스 존재와 차량·인터넷 권한·서비스·Activity 부재, AAOS 의존성 경계를 확인했습니다. 빌드 AAR와 로컬 Maven AAR의 SHA-256을 기록했습니다.
- 기존 UI 20개는 버튼 실행·취소·disabled/loading·포커스 유지·키 중복 억제, 외부 선택 상태, Dropdown 닫힘 사유/포커스 복원, Field 조합·선택·커서·숫자 완성 전이, Slider/Stepper 유한값·경계, Wheel 윤년·월말·12시간 변환·확정/거부·D-pad 이탈, Toast 큐와 Widget 상태 등을 포함합니다.
- 새 회귀 24개는 Numeric 기능키와 삭제 정책 분리, Voice 입력 제한, Static/Shift 색상, Checkbox/Radio pressed overlay, Dropdown Footer 높이와 anchor 폭, Search 요청·헤더 높이·외부 Tabs 선택 스크롤, Popup header/body 간격·본문 스크롤·반경/패딩 분리·action 숨김·낮은 창의 한 개/두 개 action 접근을 검사합니다.
- ReadOnly 포커스와 표시 중인 비밀번호의 보호 의미론, Field 48dp hit 영역, 실제 sp 줄높이 기반 Number Field 확장, Toast 아이콘 재구성의 수명 유지, Widget Handle만의 숨김·Hidden 페이지 보존·자식 D-pad·부모 세로 스크롤·18dp 점 간격·별도 제목 서체, Stepper 전체 action hit 영역, Window/Scrollbar 키보드 편집도 검사합니다.
- Toast 타이머는 실제 대기 시간과 테스트용 LifecycleRegistry의 STARTED/CREATED 전환으로 남은 시간 보존을 확인했습니다. 실제 OS가 Activity를 백그라운드로 보내고 복구하는 통합 실행은 아닙니다.
- Stepper 400, Date 600, Time 500, Medium Popup 760의 렌더 폭과 Light/Dark·RTL·Waterfall·fontScale 1.5 표시를 확인했습니다. Popup 폭 760→400과 fontScale 2, Number Field fontScale 3 및 고밀도 커서 회귀 검사도 포함합니다. 공개 API 예제와 새 검색 API를 계측 APK로 컴파일했습니다. 별도 소비 앱은 만들지 않았습니다.
- 새 대표 화면 중 Dropdown·Popup·Controller·Widget을 육안 확인했습니다. 모든 변형의 원본 픽셀 일치를 검증한 결과는 아닙니다.

## 재현 명령

```sh
export JAVA_HOME='/Applications/Android Studio.app/Contents/jbr/Contents/Home'
./gradlew assembleRelease testDebugUnitTest lintRelease \
  publishAllPublicationsToProjectLocalRepository \
  :pleos-compose:assembleDebugAndroidTest :pleos-aaos:assembleDebugAndroidTest
python3 tools/verify_spec.py
python3 tools/generate_api_docs.py
```

최종 계측은 증거 회수를 위해 생성 APK를 직접 설치·실행했습니다. 아래 `adb`는 SDK의 `platform-tools/adb`이며, 기기 ID를 전용 검증 기기에 맞게 지정해야 합니다. 이번 실행은 `emulator-5556`을 사용했습니다.

```sh
PLEOS_DEVICE_SERIAL=emulator-5556
adb -s "$PLEOS_DEVICE_SERIAL" install -r -t \
  pleos-compose/build/outputs/apk/androidTest/debug/pleos-compose-debug-androidTest.apk
adb -s "$PLEOS_DEVICE_SERIAL" shell am instrument -w \
  com.jade.pleos.compose.test/androidx.test.runner.AndroidJUnitRunner
python3 tools/package_release.py
```

## 실패 기록과 검증 한계

이번 초기 회귀 검사에서 ReadOnly 포커스 요청 노드와 Android 비선형 글자 배율의 테스트 기대값을 고쳤습니다. 실패 로그 `spec-regression-tests-1.log`와 수정 후 20개 통과 로그 `spec-regression-tests-2.log`를 보존합니다. 테스트 API 컴파일 실패도 `build-test-api-error.log`에 남겼습니다. 중간 44개 통과는 `ui-tests-before-last.log`, 최종 수정 후 45개 통과는 `ui-tests-final.log`입니다.

최초 구현 검증 이력은 [이전 검증 문서](docs/verification/VERIFICATION-before-re-audit.md)와 기존 로그·API 34 화면 44개에 보존합니다. 당시 Pleos 이미지에서 차량 제어 서비스 재시작·구성 변경·입력 ANR가 발생하여 공용 UI는 API 36으로 옮겼고, adapter는 API 34에서 따로 검사했습니다. 초기 실패를 성공으로 해석하지 않습니다.

대표 PNG는 실제 렌더 결과이며 원본과 대조한 golden이 아닙니다. 444개 변형의 전체 Light/Dark 픽셀 비교, 모든 폼팩터·모드의 글리프/blur 오차, 대비율 자동 감사는 수행하지 않았습니다. 원본과의 완전한 시각 일치를 보장하지 않습니다.

API 28 실제 기기, 실제 한글 IME 조합·음성 인식, TalkBack 사용자 흐름·timeout 통합, Toast의 실제 OS 백그라운드 복구, OEM RotaryService·nudge·FocusArea/FocusParkingView, 실차 다중 디스플레이·시스템 창 제어, 실제 Car UX manager의 성공 연결과 정책 전환, OS 알림 채널/권한 승인 후 실제 제출은 검증하지 않았습니다. 소프트웨어 키보드 재요청 검사는 controller 호출 횟수 확인이며 실제 IME 표시 검사는 아닙니다. 소비 앱 전체 Activity 재생성·상태 복원도 별도 검증이 필요합니다. Widget은 인앱 카드로 OS AppWidget 배포 범위가 아닙니다.

이번 재대조에 생성한 `PleosSpecAudit` 임시 AVD는 증거 회수 후 종료·삭제했습니다. 사용자 기존 AVD 데이터는 변경하지 않았습니다.

## Maven Central 릴리스 검증

Apache-2.0 LICENSE·NOTICE와 별도 자산 고지를 세 AAR·sources/API 문서 JAR에 포함했습니다. `io.github.punch5545`의 0.1.0 배포 파일 15개에 기존 GPG 키로 서명하고 전체 fingerprint를 검증했습니다. 서명 15개·체크섬 60개를 포함한 90개 bundle 항목을 확인했습니다. 결과는 [release-checks.json](docs/verification/publishing/release-checks.json), [bundle-validation.json](docs/verification/publishing/bundle-validation.json), [release-build.log](docs/verification/publishing/release-build.log)에 있습니다.

런타임 classes.jar는 UI 45개를 통과한 기존 AAR와 바이트가 같습니다. 이번 변경은 라이선스 자산과 배포 메타데이터이며 UI 계측은 재실행하지 않았습니다. 단위 16개 결과는 Gradle의 UP-TO-DATE로 재사용했고 lintRelease는 오류 0입니다. 초기 SourceSet 타입 실패는 `build-source-set-error.log`에 보존했으며 현재 AGP의 공개 DSL 타입으로 보정한 뒤 최종 빌드가 성공했습니다. Central의 실제 게시 여부는 [배포 상태 기록](https://github.com/punch5545/Pleos-Connect-UI/blob/main/docs/verification/publishing/status.json)을 기준으로 확인합니다.
