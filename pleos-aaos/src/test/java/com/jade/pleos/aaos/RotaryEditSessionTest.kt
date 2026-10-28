package com.jade.pleos.aaos

import org.junit.Assert.*
import org.junit.Test

class RotaryEditSessionTest {
    @Test
    fun navigationAndEditingAreSeparate() {
        val values = mutableListOf<Float>()
        val finishes = mutableListOf<Boolean>()
        val s = PleosRotaryEditSession({ values.add(it) }, { finishes.add(it) })
        assertFalse(s.dispatch(PleosRotaryEvent.Rotate(1f)))
        s.dispatch(PleosRotaryEvent.Center)
        s.dispatch(PleosRotaryEvent.Rotate(2f))
        assertEquals(listOf(2f), values)
        s.dispatch(PleosRotaryEvent.Back)
        assertEquals(listOf(false), finishes)
        assertFalse(s.editing)
        s.dispatch(PleosRotaryEvent.Center)
        s.enabled = false
        assertFalse(s.editing)
        assertFalse(s.dispatch(PleosRotaryEvent.Center))
        assertEquals(listOf(false, false), finishes)
    }
}
