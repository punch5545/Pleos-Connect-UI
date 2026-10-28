# 검증 결과

동봉 설계 스냅샷을 사용하여 로컬에서 실행했습니다. 웹 검색·Figma 접속은 하지 않았습니다. 샘플·데모·카탈로그 모듈은 만들지 않았으며, UI 검증용 Activity는 라이브러리의 `androidTest` 소스에만 있습니다.

## 실행 환경

| 항목 | 실제 환경 |
| --- | --- |
| 프로젝트 | `/Users/jade/AndroidStudioProjects/PleosConnectUI` |
| AGP / Gradle | 초기 버전 9.4.1 / 9.6.0 유지 |
| Kotlin / Compose compiler | AGP 내장 Kotlin과 같은 2.2.10 |
| Compose UI / Foundation | 1.9.0 고정 |
| JDK | Android Studio 내장 JDK 25, 출력 bytecode 11 |
| Android | compileSdk 37 / minSdk 28 |
| 공용 UI 실행 | 설치된 Google APIs API 36 arm64 이미지를 사용하는 임시 AVD |
| AAOS adapter 실행 | 설치된 Pleos API 34 arm64 이미지를 사용하는 임시 AVD |
| AVD 화면 | 2560×1440, density 160, RAM 4096MB |

기존 AVD는 스냅샷 복원 시 시스템 서비스가 정상 시작하지 않아 사용을 중단했습니다. 사용자 AVD를 초기화하지 않고 `/private/tmp`에 독립 검증용 AVD를 생성하여 같은 설치 이미지로 cold boot했습니다. 에뮬레이터 로그는 `docs/verification/temporary-emulator.log`에 있습니다.

Pleos 이미지에서 차량 제어 서비스의 재시작·화면 크기 구성 변경·입력 ANR도 관찰했습니다. 테스트용 Activity는 구성 변경을 받아 재배치하고 화면을 켜 두도록 설정했지만, 임시 AVD cold boot 후에도 불안정한 실행이 재현되었습니다. 따라서 공용 UI 최종 검증은 일반 Android API 36으로 옮겼고 AAOS adapter 검사는 API 34에서 별도로 실행했습니다. 테스트 계층이 소실된 실패와 중단 실행은 `device-tests-4.log`, `device-tests-5-interrupted.log`, `device-tests-6-aaos-anr.log`에 보존했습니다. Activity 재생성을 포함한 소비 앱 전체 상태 복원 검증을 수행한 것으로 해석하지 않습니다.

## 최종 실행 결과

| 검증 | 결과 | 근거 |
| --- | --- | --- |
| 릴리스 AAR 3개 | 성공 | [final-build.log](docs/verification/final-build.log) |
| 단위 테스트 | 12개 통과, 실패 0 | 모듈별 XML/HTML 보고서와 [check-summary.json](docs/verification/check-summary.json) |
| Lint Release | 오류 0, 경고 13 | 모듈별 `build/reports/lint-results-release.html` |
| 로컬 Maven AAR·소스·POM·Gradle metadata | 성공 | `build/maven/com/jade/pleos/`, final-build.log |
| Compose UI 계측 | 일반 Android API 36에서 21개 통과 | [device-tests-final.log](docs/verification/device-tests-final.log) |
| AAOS adapter 계측 | Pleos API 34에서 1개 통과 | [aaos-device-tests.log](docs/verification/aaos-device-tests.log) |
| 필수 변형 표시 fixture | 439개 표시, 의도하지 않은 초기 콜백 0 | [variant-coverage.txt](docs/verification/screenshots/files/variant-coverage.txt) |
| 대표 화면 | API 36의 22종 × Light/Dark = PNG 44개 | [screenshots](docs/verification/screenshots/files/pleos-evidence) |
| 설계 입력·생성 자산 | 통과 | [spec-check.json](docs/verification/spec-check.json) |
| 생성 재현성 | 120개 생성/자산 파일의 해시 변화 0 | [generator-reproducibility.json](docs/verification/generator-reproducibility.json) |
| Claude CLI 검토 | 실행 완료, 지적 사항 수정 | `docs/verification/claude-*.txt` |

Lint 경고는 업데이트 안내 9개, TOML 사용 권고 3개, 내부 Modifier factory 형태 권고 1개입니다. 버전을 자동 갱신하거나 경고를 일괄 비활성화하지 않았습니다. 단위 테스트는 tokens 5개, compose 6개, aaos 1개입니다. 계측의 변형 fixture 439개는 테스트 메서드 439개라는 의미가 아닙니다.

## 실제 검증 범위

- 원본 입력 120개 SHA-256, Assets 토큰 722개·Display 토큰 1009개의 참조 해석, alias 순환/미해결 여부, 웹 색상 149행, 충돌 색상 11개, 모드 식별·원본 문자열을 검사했습니다.
- SVG 80개·경로 217개와 변환 VectorDrawable의 경로 수, Asta Sans 폰트 동일성, master 추적 항목 302개를 검사했습니다. 세 AAR의 클래스 존재와 manifest 권한·서비스·Activity 부재도 확인했습니다.
- 버튼 정상 실행·취소·disabled·loading·기존 포커스 유지·키 중복 실행 억제, 외부 선택 상태, Dropdown Switch 유지·일반 선택 닫힘, Back/Outside 사유·포커스 복원을 검사했습니다.
- 숫자 선행 0·한 번의 완성 콜백·선택 자리 덮어쓰기·이미 포커스된 칸의 키보드 재요청, TextFieldValue의 composition 보존·선택·readOnly·비밀번호 의미론, 긴 입력의 커서 스크롤과 밀도 1배·3배의 끝 커서 색상을 검사했습니다. 키보드 재요청은 controller 호출 횟수 검사이며 실제 IME 표시 검사는 아닙니다.
- decimal Stepper, Slider 유한값·범위·격자·끝점, 극단적인 Scrollbar 범위 연산, 윤년·월말·12시간 변환, wheel 접근성 변경·거부 값 복원·확정 콜백·D-pad 탐색 이탈을 검사했습니다.
- Toast 큐·중복·generation, Unicode 코드포인트 삭제, Widget 페이지 상태와 Hidden 복원, 연결 실패·종료 시 AAOS의 보수적인 제한 상태를 검사했습니다.
- Stepper 400, Date 600, Time 500, Medium Popup 760의 실제 렌더 폭을 확인했습니다. 22개 컴포넌트를 Light/Dark·RTL 및 Waterfall·fontScale 1.5 조건에서 표시했습니다. Popup은 폭 760→400과 fontScale 2에서 Lazy body·고정 action을 검사했습니다.
- 공개 API 사용 예제 `PublicApiUsage.kt`는 계측 APK 빌드에서 실제 컴파일했습니다. 별도 소비 앱을 만들지는 않았습니다.

## 재현 명령

```sh
export JAVA_HOME='/Applications/Android Studio.app/Contents/jbr/Contents/Home'
./gradlew assembleRelease testDebugUnitTest lintRelease \
  publishAllPublicationsToProjectLocalRepository \
  :pleos-compose:assembleDebugAndroidTest :pleos-aaos:assembleDebugAndroidTest
python3 tools/verify_spec.py
python3 tools/generate_api_docs.py
```

최종 기기 테스트는 증거 파일을 회수하기 위해 Gradle의 설치·삭제 절차 대신 생성된 계측 APK를 직접 실행했습니다. 아래 `adb`는 SDK의 `platform-tools/adb`입니다. 일반 재실행에는 README의 `connectedDebugAndroidTest` 작업도 사용할 수 있습니다.

```sh
adb install -r -t pleos-compose/build/outputs/apk/androidTest/debug/pleos-compose-debug-androidTest.apk
adb shell am instrument -w com.jade.pleos.compose.test/androidx.test.runner.AndroidJUnitRunner
adb install -r -t pleos-aaos/build/outputs/apk/androidTest/debug/pleos-aaos-debug-androidTest.apk
adb shell am instrument -w com.jade.pleos.aaos.test/androidx.test.runner.AndroidJUnitRunner
```

## 수정 이력과 미검증 범위

초기 실행에서 비밀번호 `InputText` 평문 의미론, 합성 Spinner의 무한 폭, 커서 끝 여백을 발견하여 수정했습니다. 마지막 Claude 검토가 발견한 고밀도 커서 폭 문제도 토큰의 dp→px 변환으로 수정했고 [밀도 회귀 검사](docs/verification/high-density-cursor-test.log)가 통과했습니다. Back/D-pad 테스트는 합성 키 이벤트 전에 Keyboard 입력 모드를 설정하도록 고쳤으며, Popup resize 테스트에는 화면 준비 대기를 추가했습니다. 실패한 초기 실행 로그도 삭제하지 않았습니다. 최종 성공 여부는 위 최종 로그를 기준으로 판단합니다.

API 34에서 회수한 별도 대표 화면 44개도 `docs/verification/screenshots-aaos/`에 보존합니다. 최종 변형 집계는 API 36의 439개 기록을 사용합니다.

대표 PNG는 실제 렌더 결과이며 원본과 대조한 golden이 아닙니다. 전체 439개 변형의 Light/Dark 원본 픽셀 비교, 모든 폼팩터·모드의 글리프/blur 오차, 대비율 자동 감사는 수행하지 않았습니다. 대표 화면의 배치·가독성을 육안 확인했지만 이를 전체 시각 일치로 표현하지 않습니다.

API 28 실제 기기 실행, 실제 한글 IME 서비스의 조합·음성 인식, TalkBack 사용자 흐름·timeout 통합, Toast 실제 타이머의 백그라운드/포그라운드 전환, OEM RotaryService·회전/nudge·FocusArea/FocusParkingView, 실차 다중 디스플레이·시스템 창 제어, 실제 Car UX manager의 성공 연결과 정책 전환, OS 알림 채널/권한 승인 후 실제 제출은 검증하지 않았습니다. API 36 공용 UI·API 34 adapter 계측과 순수 계산 검증의 결과를 이러한 플랫폼 검증의 성공으로 해석하지 마십시오. Widget은 인앱 카드이며 OS AppWidget 배포 검증은 구현 범위가 아닙니다.

검증 종료 후 이번 작업에서 생성한 두 임시 AVD를 종료·삭제했습니다. 사용자 기존 AVD 데이터는 초기화하지 않았습니다.
