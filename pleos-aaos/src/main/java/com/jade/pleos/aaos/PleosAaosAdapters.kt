package com.jade.pleos.aaos

import android.app.Notification
import android.app.NotificationManager
import android.car.drivingstate.CarUxRestrictions
import android.car.drivingstate.CarUxRestrictionsManager
import android.os.Looper
import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.jade.pleos.tokens.*

sealed interface PleosUxConnectionState {
    data object Unknown : PleosUxConnectionState

    data class Connected(val capabilities: PleosCapabilities) : PleosUxConnectionState

    data class Unavailable(val reason: String) : PleosUxConnectionState
}

/**
 * 승인된 디스플레이별 manager를 호스트가 공급합니다. 기어·속도로 제한을 추측하지 않습니다. 매핑은 OEM/시장 정책을 알고 있는 호스트가 반드시 전달합니다. 메인
 * 스레드에서 사용합니다. host Car 연결의 소유권은 넘겨받지 않으며 이 adapter가 등록한 listener만 해제합니다.
 */
class PleosUxRestrictionsAdapter(
    private val managerProvider: () -> CarUxRestrictionsManager,
    private val mapRestrictions: (CarUxRestrictions) -> PleosCapabilities,
) : DefaultLifecycleObserver, AutoCloseable {
    private var manager: CarUxRestrictionsManager? = null
    private var started = false
    private val mutableState =
        mutableStateOf<PleosUxConnectionState>(PleosUxConnectionState.Unknown)
    val state: State<PleosUxConnectionState>
        get() = mutableState

    val capabilities: PleosCapabilities
        get() =
            (state.value as? PleosUxConnectionState.Connected)?.capabilities
                ?: PleosCapabilities(
                    restrictionReason =
                        (state.value as? PleosUxConnectionState.Unavailable)?.reason
                            ?: "사용 제한 정보가 아직 없습니다."
                )

    private val listener =
        CarUxRestrictionsManager.OnUxRestrictionsChangedListener { restrictions ->
            if (started)
                try {
                    mutableState.value =
                        PleosUxConnectionState.Connected(mapRestrictions(restrictions))
                } catch (_: RuntimeException) {
                    fail("사용 제한 정책을 적용하지 못했습니다.")
                }
        }

    private fun checkMain() {
        check(Looper.myLooper() == Looper.getMainLooper()) { "메인 스레드에서 호출해야 합니다." }
    }

    private fun fail(reason: String) {
        manager?.let { runCatching { it.unregisterListener() } }
        manager = null
        started = false
        mutableState.value = PleosUxConnectionState.Unavailable(reason)
    }

    fun start() {
        checkMain()
        if (started) return
        started = true
        try {
            val next = managerProvider()
            manager = next
            next.registerListener(listener)
            listener.onUxRestrictionsChanged(next.currentCarUxRestrictions)
        } catch (_: SecurityException) {
            fail("호스트에 사용 제한 서비스 접근 권한이 없습니다.")
        } catch (_: RuntimeException) {
            fail("사용 제한 서비스가 연결되지 않았습니다.")
        }
    }

    override fun onStart(owner: LifecycleOwner) = start()

    override fun onStop(owner: LifecycleOwner) = close()

    override fun close() {
        checkMain()
        started = false
        manager?.let { runCatching { it.unregisterListener() } }
        manager = null
        mutableState.value = PleosUxConnectionState.Unknown
    }
}

/** RotaryService의 실제 이벤트를 호스트 bridge에서 정규화한 후 전달합니다. */
sealed interface PleosRotaryEvent {
    data object Center : PleosRotaryEvent

    data class Rotate(val steps: Float) : PleosRotaryEvent {
        init {
            require(steps.isFinite())
        }
    }

    data object Back : PleosRotaryEvent

    data object FocusLost : PleosRotaryEvent

    data object Touch : PleosRotaryEvent
}

class PleosRotaryEditSession(
    private val onAdjust: (Float) -> Unit,
    private val onFinished: (Boolean) -> Unit,
) {
    var editing: Boolean = false
        private set

    var enabled: Boolean = true
        set(value) {
            field = value
            if (!value) cancel()
        }

    fun dispatch(event: PleosRotaryEvent): Boolean {
        if (!enabled) return false
        return when (event) {
            PleosRotaryEvent.Center -> {
                editing = !editing
                if (!editing) onFinished(true)
                true
            }
            is PleosRotaryEvent.Rotate ->
                if (editing) {
                    if (event.steps != 0f) onAdjust(event.steps)
                    true
                } else false
            PleosRotaryEvent.Back ->
                if (editing) {
                    editing = false
                    onFinished(false)
                    true
                } else false
            PleosRotaryEvent.FocusLost,
            PleosRotaryEvent.Touch -> {
                cancel()
                false
            }
        }
    }

    private fun cancel() {
        if (editing) {
            editing = false
            onFinished(false)
        }
    }
}

interface PleosWindowManagementAdapter {
    fun onDragStart()

    /** 현재 Android window의 물리 pixel delta입니다. */
    fun onDragDelta(x: Float, y: Float)

    fun onDragEnd()

    fun onDragCancel()
}

sealed interface PleosNotificationResult {
    data object Submitted : PleosNotificationResult

    data class Rejected(val reason: String) : PleosNotificationResult
}

fun interface PleosSystemNotificationAdapter {
    fun submit(tag: String?, id: Int, notification: Notification): PleosNotificationResult
}

/** channel·작은 아이콘·권한·PendingIntent는 소비 앱이 구성하며 OS의 최종 외형은 보장하지 않습니다. */
class AndroidPleosNotificationAdapter(
    private val manager: NotificationManager,
    private val capabilities: () -> PleosCapabilities,
) : PleosSystemNotificationAdapter {
    override fun submit(
        tag: String?,
        id: Int,
        notification: Notification,
    ): PleosNotificationResult {
        if (!capabilities().systemNotifications)
            return PleosNotificationResult.Rejected("호스트가 시스템 알림 통합을 허용하지 않았습니다.")
        if (!manager.areNotificationsEnabled())
            return PleosNotificationResult.Rejected("알림 권한 또는 알림 설정이 비활성화되어 있습니다.")
        val channel =
            notification.channelId ?: return PleosNotificationResult.Rejected("호스트 알림 채널이 없습니다.")
        if (manager.getNotificationChannel(channel) == null)
            return PleosNotificationResult.Rejected("호스트 알림 채널이 없습니다.")
        if (notification.smallIcon == null)
            return PleosNotificationResult.Rejected("알림의 작은 아이콘이 없습니다.")
        return try {
            manager.notify(tag, id, notification)
            PleosNotificationResult.Submitted
        } catch (_: SecurityException) {
            PleosNotificationResult.Rejected("OS가 알림 제출 권한을 허용하지 않았습니다.")
        }
    }
}
