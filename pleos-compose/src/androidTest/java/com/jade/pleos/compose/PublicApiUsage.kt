package com.jade.pleos.compose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jade.pleos.tokens.*

/** README의 공개 API 예제를 앱 모듈 없이 컴파일합니다. */
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
