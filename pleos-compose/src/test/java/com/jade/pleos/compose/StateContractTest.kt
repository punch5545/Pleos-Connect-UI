package com.jade.pleos.compose

import java.math.BigDecimal
import java.time.LocalDate
import org.junit.Assert.*
import org.junit.Test

class StateContractTest {
    @Test
    fun volumeBoundariesPrioritizeExactMaximum() {
        assertEquals(PleosVolumeLevel.Min, pleosVolumeLevel(0f))
        assertEquals(PleosVolumeLevel.Low, pleosVolumeLevel(.01f))
        assertEquals(PleosVolumeLevel.Low, pleosVolumeLevel(.25f))
        assertEquals(PleosVolumeLevel.Mid, pleosVolumeLevel(.26f))
        assertEquals(PleosVolumeLevel.Mid, pleosVolumeLevel(.75f))
        assertEquals(PleosVolumeLevel.High, pleosVolumeLevel(.76f))
        assertEquals(PleosVolumeLevel.High, pleosVolumeLevel(.999f))
        assertEquals(PleosVolumeLevel.Max, pleosVolumeLevel(1f))
        assertThrows(IllegalArgumentException::class.java) { pleosVolumeLevel(Float.NaN) }
    }

    @Test
    fun sliderAdjustmentsClampBeforeFloatOverflow() {
        assertEquals(Float.MAX_VALUE, shiftedPleosValue(3e38f, 1e38f, 0f..Float.MAX_VALUE, null))
        assertEquals(
            -Float.MAX_VALUE,
            shiftedPleosValue(-3e38f, -1e38f, -Float.MAX_VALUE..0f, null),
        )
    }

    @Test
    fun emptyToastNeverEntersTheQueueOrLeavesAnEmptySurface() {
        val state = PleosToastHostState()
        state.show("", "a")
        assertNull(state.current)
        state.show("첫째", "a")
        state.show("둘째", "b")
        state.show(" ", "b")
        assertTrue(state.queued.isEmpty())
        state.show("", "a")
        assertNull(state.current)
    }

    @Test
    fun decimalStepperReachesEndpointsWithoutDrift() {
        var v = BigDecimal.ZERO
        repeat(10) {
            v = stepPleosDecimal(v, BigDecimal.ZERO, BigDecimal.ONE, BigDecimal("0.1"), 1)
        }
        assertEquals(0, v.compareTo(BigDecimal.ONE))
        assertEquals(
            BigDecimal.ONE,
            stepPleosDecimal(v, BigDecimal.ZERO, BigDecimal.ONE, BigDecimal("0.1"), 1),
        )
        assertEquals(
            BigDecimal.ZERO,
            stepPleosDecimal(
                BigDecimal.ZERO,
                BigDecimal.ZERO,
                BigDecimal.ONE,
                BigDecimal("0.1"),
                -1,
            ),
        )
    }

    @Test
    fun sliderValidatesAndSnapsWithReachableEnd() {
        assertEquals(1f, normalizePleosValue(2f, 0f..1f, .3f))
        assertEquals(.6f, normalizePleosValue(.61f, 0f..1f, .3f), .0001f)
        assertEquals(5f, normalizePleosValue(9f, 5f..5f))
        assertThrows(IllegalArgumentException::class.java) {
            normalizePleosValue(Float.NaN, 0f..1f)
        }
        assertThrows(IllegalArgumentException::class.java) { normalizePleosValue(0f, 0f..1f, 0f) }
        assertThrows(IllegalArgumentException::class.java) { normalizePleosValue(0f, 1f..0f) }
    }

    @Test
    fun dateTransitionsNeverCreateInvalidDates() {
        assertEquals(
            LocalDate.of(2024, 2, 29),
            adjustPleosDate(LocalDate.of(2024, 1, 31), month = 2),
        )
        assertEquals(
            LocalDate.of(2025, 2, 28),
            adjustPleosDate(LocalDate.of(2024, 2, 29), year = 2025),
        )
        assertEquals(
            LocalDate.of(2024, 3, 10),
            adjustPleosDate(LocalDate.of(2024, 1, 31), month = 2, min = LocalDate.of(2024, 3, 10)),
        )
        assertEquals(0, pleosHour24(12, false))
        assertEquals(12, pleosHour24(12, true))
        assertEquals(13, pleosHour24(1, true))
    }

    @Test
    fun scrollbarHandlesZeroAndClamps() {
        assertEquals(PleosScrollGeometry(100f, 0f, 0f), pleosScrollGeometry(0f, 0f, 0f, 100f))
        val g = pleosScrollGeometry(100f, 1000f, 2000f, 200f)
        assertEquals(48f, g.thumbLength)
        assertEquals(152f, g.thumbOffset)
        assertEquals(900f, g.maxOffset)
        assertEquals(1e30f, pleosScrollGeometry(1e30f, 1e38f, 0f, 1e38f).thumbLength, 1e25f)
        assertEquals(0f, pleosScrollGeometry(100f, 1000f, -10f, 200f).thumbOffset)
    }

    @Test
    fun toastQueueUpdatesByIdAndRejectsStaleTimeout() {
        val state = PleosToastHostState(3)
        val reasons = mutableListOf<PleosDismissReason>()
        state.show("첫째", "a")
        val old = state.current!!.generation
        state.show("갱신", "a")
        state.dismiss("a", PleosDismissReason.Timeout, old)
        assertEquals("갱신", state.current!!.message)
        state.show("둘째", "b", onDismiss = { reasons.add(it) })
        state.show("셋째", "c")
        state.show("넷째", "d")
        state.show("다섯째", "e")
        assertEquals(listOf("c", "d", "e"), state.queued.map { it.id })
        assertEquals(listOf(PleosDismissReason.Replaced), reasons)
        state.dismiss("a", PleosDismissReason.CloseAction)
        assertEquals("c", state.current!!.id)
    }

    @Test
    fun keypadDeletesLogicalCharactersAndKeepsLeadingZero() {
        assertEquals("0", reducePleosText("00", PleosKeyAction.DeleteBackward))
        assertEquals("", reducePleosText("가", PleosKeyAction.DeleteBackward))
        assertEquals("", reducePleosText("e\u0301", PleosKeyAction.DeleteBackward))
        assertEquals("001", reducePleosText("00", PleosKeyAction.Character("1")))
    }
}
