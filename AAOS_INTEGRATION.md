# AAOS 호스트 통합

일반 UI는 `pleos-compose`만 사용합니다. `pleos-aaos`의 차량 타입을 참조하는 코드는 Automotive 기기 및 `android.car` 제공 여부를 확인한 뒤 생성하십시오. optional uses-library만 선언하며 차량 권한, 인터넷 권한, 서비스나 distractionOptimized 메타데이터를 추가하지 않습니다.

AAOS 호스트의 Gradle 설정에도 SDK의 선택 라이브러리를 연결하십시오.

```kotlin
android { useLibrary("android.car", false) }
```

`PleosUxRestrictionsAdapter`는 호스트가 승인된 플랫폼 경로로 획득한 디스플레이별 `CarUxRestrictionsManager`를 공급받습니다. `start()`·`close()`는 메인 스레드에서 호출합니다. `DefaultLifecycleObserver`이므로 호스트 lifecycle에 등록해 START/STOP에 연결할 수 있습니다. adapter는 자신의 listener를 해제하며, Car 객체의 연결·해제는 소유한 호스트가 담당합니다. 같은 manager에 listener를 등록하는 다른 소비자와 공유하지 마십시오.

`mapRestrictions`는 필수 인자입니다. `CarUxRestrictions`의 비트와 textInput/complexInteraction/animations/video/systemNotifications 간 정확한 정책은 OEM·시장·디스플레이에 따라 호스트가 결정합니다. 기어 또는 속도에서 운전 제한을 추론하지 않습니다. 초기 상태 및 서비스 실패·중지 상태에서는 보수적인 `PleosCapabilities()`를 사용합니다.

```kotlin
val adapter = PleosUxRestrictionsAdapter(
    managerProvider = { approvedDisplayManager },
    mapRestrictions = { restrictions -> hostPolicy.resolve(restrictions) },
)
lifecycle.addObserver(adapter)
// Compose의 PleosTheme(capabilities = adapter.capabilities)에 공급합니다.
// 화면/서비스 소유자가 끝날 때 observer 제거 및 adapter.close()를 호출합니다.
```

텍스트 입력과 키패드는 textInput, 휠은 complexInteraction을 반영합니다. 앱의 어떤 설정·목록·차량 제어가 복잡한 상호작용에 해당하는지는 호스트에서 판단하고 관련 컨트롤의 enabled에 정책을 전달하십시오. 제한 사유는 접근 가능한 설명에 연결할 수 있습니다.

`PleosRotaryEditSession`은 Center로 편집 진입/확정, Rotate로 조정 요청, Back/FocusLost/Touch로 종료합니다. disabled 전환은 진행 중 편집을 취소합니다. OEM의 회전·nudge·center·back 전달을 이 모델에 연결해야 하며, Compose virtual node의 존재만으로 개별 rotary 포커스 지원을 보장하지 않습니다. `FocusArea`/`FocusParkingView`와 direct manipulation bridge는 대상 호스트에서 구성하고 실기 검증해야 합니다.

`AndroidPleosNotificationAdapter`는 호스트가 만든 `Notification`을 제출합니다. 시스템 알림 capability, 알림 허용 상태, channel 및 작은 아이콘을 확인하고 불허 시 `Rejected`를 반환합니다. 채널 생성·알림 권한 요청·PendingIntent·수신자·실제 통화 기능은 소비 앱이 구현합니다. 인앱 알림 카드와 실제 OS HUN의 최종 렌더링은 동일하다고 보장하지 않습니다.

`PleosWindowManagementAdapter`는 앱 윈도의 실제 pixel drag를 호스트가 처리하도록 하는 경계입니다. 일반 앱에서 시스템 창 배치나 런처를 제어하는 권한을 제공하지 않습니다. Widget 역시 앱 내부 카드이며 RemoteViews/AppWidget/Pleos 전용 호스트 배포 API로 자동 변환하지 않습니다.
