package com.jade.pleos.aaos

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jade.pleos.tokens.PleosCapabilities
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UxRestrictionAdapterTest {
    @Test
    fun missingServiceAndDisconnectionFailClosed() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            val adapter =
                PleosUxRestrictionsAdapter(
                    { throw IllegalStateException("service unavailable") },
                    { PleosCapabilities.Unrestricted },
                )
            assertFalse(adapter.capabilities.textInput)
            adapter.start()
            assertTrue(adapter.state.value is PleosUxConnectionState.Unavailable)
            assertFalse(adapter.capabilities.complexInteraction)
            adapter.close()
            assertEquals(PleosUxConnectionState.Unknown, adapter.state.value)
            assertFalse(adapter.capabilities.systemNotifications)
        }
    }
}
