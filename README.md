# Pleos Connect Kotlin UI

동봉된 2026-10-28 설계 스냅샷을 기반으로 구현한 Android UI 라이브러리입니다. 현대자동차그룹의 공식 배포 SDK가 아닙니다. 샘플 앱·데모 앱·카탈로그 모듈은 포함하지 않습니다.

| 모듈 | 책임 |
| --- | --- |
| `pleos-tokens` | Light/Dark 색상, Asta Sans, 폼팩터, 출처 식별자, 최신 웹 override, 테마 |
| `pleos-compose` | Foundation 기반 22개 컴포넌트, 접근성, 입력, 인앱 overlay |
| `pleos-aaos` | 호스트의 UX 제한 manager 연결, rotary 편집 세션, OS 알림 adapter |

minSdk 28, compileSdk 37, JVM bytecode 11입니다. AGP 9.4.1·Gradle 9.6.0은 초기 프로젝트 버전을 유지했습니다. AGP 내장 Kotlin 2.2.10과 같은 버전의 Compose compiler plugin 및 Compose UI/Foundation 1.9.0을 고정했습니다. 실행 JDK는 기존 Android Studio의 JDK 25입니다. 실제 검증 결과는 [VERIFICATION.md](VERIFICATION.md)에 기록합니다.

## 빌드와 배포

```sh
export JAVA_HOME='/Applications/Android Studio.app/Contents/jbr/Contents/Home'
./gradlew assembleRelease testDebugUnitTest lintRelease
./gradlew :pleos-compose:connectedDebugAndroidTest :pleos-aaos:connectedDebugAndroidTest
./gradlew publishAllPublicationsToProjectLocalRepository
```

릴리스 AAR는 각 모듈의 `build/outputs/aar/`, 소스 JAR와 의존성 메타데이터를 포함한 로컬 Maven 저장소는 `build/maven/`에 생성됩니다. 공개 배포 좌표는 인증된 GitHub 네임스페이스 `io.github.punch5545`를 사용합니다. Kotlin 패키지 이름은 `com.jade.pleos.*`로 유지하며, 공식 Pleos 좌표가 아닙니다.

완성된 배포 묶음은 `dist/pleos-connect-ui-0.1.0.zip`입니다. 세 모듈의 AAR·소스·Maven 메타데이터와 빌드 가능한 프로젝트 소스·설계/검증 문서를 포함합니다. 개별 AAR와 SHA-256 목록은 `dist/aar/`, `dist/SHA256SUMS.txt`에 있습니다. 재포장은 검증 후 `python3 tools/package_release.py`로 수행합니다.

AAR를 단독 복사하면 다른 두 모듈 및 AndroidX 의존성이 자동 설치되지 않습니다. 소비 앱에는 세 모듈의 Maven 배포물을 함께 제공하는 방법을 권장합니다. 일반 UI 소비 앱은 `pleos-compose`만 의존하면 토큰이 전이됩니다. AAOS adapter를 사용할 때만 `pleos-aaos`를 추가하십시오.

```kotlin
repositories {
    google()
    mavenCentral()
}
dependencies {
    implementation("io.github.punch5545:pleos-compose:0.1.0")
    // 플랫폼 adapter가 필요한 AAOS 호스트에서 추가합니다.
    implementation("io.github.punch5545:pleos-aaos:0.1.0")
}
```

Central 배포 절차·서명·POM·bundle 검증은 [PUBLISHING.md](PUBLISHING.md)에 기록합니다.

현재 Central 게시는 라이선스 확정과 GPG 서명을 기다리는 상태입니다. 게시 완료 전에는 위 Maven 의존성이 Central에서 조회되지 않습니다.

## 사용 예제

아래 예제의 API 사용은 계측 테스트 소스 `PublicApiUsage.kt`에서도 컴파일합니다. 앱 모듈을 만들지 않습니다.

```kotlin
@Composable
fun SettingsPanel() {
    var enabled by remember { mutableStateOf(false) }
    var volume by remember { mutableFloatStateOf(50f) }
    val toasts = rememberPleosToastHostState()
    PleosTheme(
        darkTheme = false,
        formFactor = PleosFormFactor.Standard17,
        capabilities = PleosCapabilities.Unrestricted,
    ) {
        Box(Modifier.fillMaxSize()) {
            Column(Modifier.padding(24.dp)) {
                PleosToggleButton("기능", enabled, { enabled = it })
                PleosSlider(volume, { volume = it }, valueRange = 0f..100f, step = 1f)
                PleosBasicButton("적용", { toasts.show("설정을 적용했습니다.") })
            }
            PleosToastHost(toasts)
        }
    }
}
```

예제의 `Unrestricted`는 일반 Android 호스트·테스트에서 명시적으로 선택하는 정책입니다. 실제 차량에서는 승인된 제한 상태를 공급하십시오. 기본 `PleosCapabilities()`는 제한 정보가 없는 상태이므로 텍스트 입력·복잡한 선택·장식 모션·시스템 알림을 허용하지 않습니다.

상태는 소비 앱이 소유합니다. `value`, `checked`, `selectedId`, `expanded` 등의 콜백은 변경 요청이며, 네트워크나 실제 차량 제어 성공을 의미하지 않습니다. `TextFieldValue` 오버로드로 커서·선택·한글 조합 정보를 유지할 수 있습니다. 숫자 필드는 문자열을 사용하여 선행 0을 보존합니다.

## 테마와 크기

창 폭으로 차종을 추측하지 않습니다. `PleosFormFactor`는 명시적인 호스트 프로필이고, 실제 가용 창과 인셋은 별도로 처리합니다. S/L/W/Waterfall의 개별 토큰을 사용하며 전체 UI를 하나의 비율로 축소하지 않습니다. S-14.6/S-15.6에는 전체 컴포넌트용 assets 모드가 없으므로 S를 사용하고, 별도 Display collection은 `displayValue(collectionId, path, fallback)`로 조회합니다.

`PleosColors(dark, overrides)`와 `PleosMetrics(formFactor, overrides)`를 테마에 주입할 수 있습니다. override는 앱 확장이며 공식 규격으로 표시하지 마십시오. 원본 토큰은 `PleosSourceTokens`에서 파일·노드·collection·stable key와 함께 조회하고, AAR의 `assets/pleos/source/`에서 raw alias와 정규화 기록을 확인할 수 있습니다. 원본 색상 조회를 최신 테마 색상 대신 사용하지 마십시오.

폰트는 동봉 Asta Sans variable font입니다. 400/700/800 등 weight를 명시하고, 대체 `FontFamily`를 테마에 주입할 수 있습니다. SVG 80개의 원본 경로를 VectorDrawable로 옮겼으며 `PleosIcons`에서 원본 ID를 포함한 이름으로 제공합니다. 폰트 OFL과 출처를 AAR의 assets에 포함합니다.

## 입력과 플랫폼 통합

Foundation의 터치·키보드·D-pad 입력을 사용합니다. Slider/Wheel은 Enter 또는 D-pad center로 편집에 진입하고, 방향키로 조정하며 Back/Escape로 빠져나옵니다. 탐색 모드에서 방향키를 가로채지 않습니다. 접근성 증감 action은 편집 모드와 별도로 제공합니다.

AAOS `RotaryService`의 회전·nudge 이벤트 경로는 OEM 호스트가 연결해야 합니다. `PleosRotaryEditSession`은 정규화한 이벤트를 처리하며, 자체적으로 OEM 호환성이나 `FocusArea`/`FocusParkingView` 구성을 보장하지 않습니다. 자세한 연동 경계는 [AAOS_INTEGRATION.md](AAOS_INTEGRATION.md)를 참고하십시오.

System Popup은 앱 Dialog이며 전역 overlay 권한을 요구하지 않습니다. Toast와 알림 카드는 비모달 인앱 UI입니다. 실제 OS 알림은 소비 앱이 채널·권한·작은 아이콘·PendingIntent를 구성해 별도 adapter로 제출합니다. Widget은 앱 내부 HMI 카드이며 Android `AppWidgetProvider` 배포물을 의미하지 않습니다.

## 명세 재대조에서 추가한 API

`PleosSearchNavigation`은 TextFieldValue·검색 IME·뒤로·닫기 요청을 연결하고, `fieldModifier`로 호스트 포커스를 받습니다. `PleosNavigationDropdown`은 제목용 메뉴 모양과 Dropdown의 선택/닫힘/포커스 복원을 함께 제공합니다. 일반 Dropdown의 `preferredWidth`는 기본 600dp이며 다른 폭 또는 null로 부모 제약을 사용할 수 있습니다.

Popup의 header와 action은 본문 스크롤에서 분리됩니다. 일반 Column body는 기본 스크롤을 사용합니다. LazyColumn처럼 자체 스크롤을 가진 body는 `bodyScroll = false`로 전달하십시오. `confirmAction = null`로 안내 전용 팝업을 만들 수 있습니다. action 전체보다 창이 낮으면 버튼 영역도 스크롤할 수 있습니다.

```kotlin
PleosPopupSurface(
    title = "목록",
    confirmAction = PleosPopupAction("ok", "확인", onConfirm),
    bodyScroll = false,
    body = { LazyColumn { items(entries) { PleosText(it) } } },
)
```

Continuous Slider의 앞/뒤 icon 슬롯은 track 내부에 배치하며 양 끝 버튼은 방향 화살표를 유지합니다. 기본 음량 아이콘은 `showVolumeIcon = false`로 숨길 수 있습니다. Centered Number는 `valueContent`로 단위·특수 서체를 교체할 수 있습니다. Widget은 Handle을 아래로 끌어 숨기며, Hidden 상태의 화살표를 탭해 복귀합니다.

## 추적과 검증

- [명세 재대조 기록](SPEC_AUDIT.md)
- [구현 매트릭스](IMPLEMENTATION_MATRIX.md)
- [규격 결정과 보완 정책](SPEC_DECISIONS.md)
- [공개 API 목록](PUBLIC_API.md)
- [검증 결과와 한계](VERIFICATION.md)

동봉 원본 문서는 `docs/`에 보존합니다. 웹/Figma 접속 없이 `python3 tools/generate_spec.py`로 토큰·벡터·원본 master 목록을 재생성할 수 있습니다. `python3 tools/verify_spec.py`는 원본 무결성과 토큰 참조·벡터 경로·폰트·라이브러리 경계를 검사합니다. 생성 재현성은 생성기 실행 전후의 파일 해시를 비교하여 별도로 검증했습니다.
