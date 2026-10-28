package com.jade.pleos.tokens

import androidx.compose.ui.graphics.Color
import org.junit.Assert.*
import org.junit.Test

class TokenContractTest {
    @Test
    fun auditPreservesWebGeometryAndIndependentFigureMetrics() {
        for (profile in PleosFormFactor.entries) {
            val m = PleosMetrics(profile)
            assertEquals(100f, m.value("controller/stepper/height", 0f))
            assertEquals(384f, m.value("spinner/panel/large_height", 0f))
            assertEquals(88f, m.value("spinner/list_height", 0f))
            assertEquals(792f, m.value("popup/toast/max_width", 0f))
        }
        val legacy = PleosMetrics(PleosFormFactor.Legacy12_9)
        assertEquals(35f, legacy.value("popup/system/padding_large", 0f))
        assertEquals(42f, legacy.value("popup/system/radius_top_left", 0f))
        assertEquals(245f, legacy.value("spinner/panel/medium_height", 0f))
        for (dark in listOf(false, true)) {
            val c = PleosColors(dark)
            assertEquals(
                c["informative/positive"].copy(alpha = .9f),
                c["controller/slider/gradient_start"],
            )
            assertEquals(c["regulation/red"].copy(alpha = .9f), c["controller/slider/gradient_end"])
        }
    }

    @Test
    fun sourceIdentityAndModesArePreserved() {
        val all = PleosSourceTokens.all
        assertEquals(1731, all.size)
        assertEquals(1731, all.map { it.file to it.id }.distinct().size)
        assertEquals(722, all.count { it.file == SourceFile.Assets })
        assertEquals(1009, all.count { it.file == SourceFile.Display })
        all.forEach {
            assertTrue(it.key.isNotEmpty())
            assertTrue(it.collectionKey.isNotEmpty())
            assertTrue(it.modes.isNotEmpty())
            assertTrue(it.modes.keys.none { mode -> mode.any { c -> c.code < 32 } })
        }
    }

    @Test
    fun webLatestOverridesAreSinglePolicy() {
        val c = PleosColors(true)
        assertEquals(149, c.canonicalNames.size)
        assertEquals(.2f, c["button/switch/pressed"].alpha, .0001f)
        assertEquals(Color.White.copy(alpha = .3f), c["button/switch/disabled"])
        assertEquals(Color(0xFF131417).copy(alpha = .1f), c["controller/stepper_background"])
        assertEquals(Color(0xFF0082FC), c["driving_charging_deep"])
        for (key in
            listOf(
                "keyboard_normal_secondary_pressed",
                "keyboard_static_secondary_pressed",
            )) assertEquals(Color(0xFF44464E), c[key])
        assertEquals(Color(0xFF313236), c["keyboard_static_background"])
        for (key in
            listOf(
                "keyboard_static_icon_light",
                "keyboard_static_icon_dark",
                "keyboard_static_text",
            )) assertEquals(Color(0xFFA4A8AE), c[key])
        assertEquals(Color(0xFF313236), PleosColors(false)["keyboard_static_text"])
    }

    @Test
    fun sourceNamesAndAlphaAreResolvedExactlyOnce() {
        for (dark in listOf(false, true)) {
            val c = PleosColors(dark)
            c.canonicalNames.forEach {
                val x = c[it]
                assertTrue(x.alpha in 0f..1f)
            }
            assertEquals(.1f, c["divider/secondary"].alpha, 1f / 255)
            assertEquals(c["controller_slider_knob"], c["controller/slider/knop"])
            assertEquals(c["phone_call_normal"], c["phone/accept_normal"])
        }
    }

    @Test
    fun webOnlyAliasesNeverReadHistoricalFigmaColors() {
        for (dark in listOf(false, true)) {
            val c = PleosColors(dark)
            for (name in
                listOf(
                    "informative_negative",
                    "surface_low",
                    "regulation_yellow",
                    "regulation_bluetooth",
                )) assertEquals(c[name], c[name.replaceFirst('_', '/')])
        }
        assertEquals(
            TokenValue.Text("Radio"),
            PleosSourceTokens.find(SourceFile.Assets, "2:9523").modes["Eng"],
        )
    }

    @Test
    fun formFactorsUseIndividualValuesAndLatestWidths() {
        val expected =
            listOf(
                PleosFormFactor.Standard17 to 100f,
                PleosFormFactor.Legacy12_9 to 88f,
                PleosFormFactor.Wide to 84f,
                PleosFormFactor.Waterfall to 106f,
            )
        expected.forEach { (profile, height) ->
            val m = PleosMetrics(profile)
            assertEquals(height, m.value("buttons/basic/large/height", 0f))
            assertEquals(400f, m.value("controller/stepper/width", 0f))
            assertEquals(760f, m.value("popup/medium/width", 0f))
            assertEquals(600f, m.value("spinner/date/width", 0f))
        }
    }
}
