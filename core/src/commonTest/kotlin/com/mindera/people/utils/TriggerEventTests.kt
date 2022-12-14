package com.mindera.people.utils

import app.cash.turbine.test
import com.mindera.people.BaseTest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class TriggerEventTests : BaseTest() {

    @Test
    fun `test MutableStateFlow of TriggerEvent`() = runTest {
        val myStateFlow = MutableStateFlow(TriggerEvent)
        var emissions = 1 // already start with one emission

        myStateFlow.test {
            myStateFlow.emit(TriggerEvent)
            assertNotEquals(TriggerEvent, awaitItem())
            emissions += 1
            myStateFlow.emit(TriggerEvent)
            assertNotEquals(TriggerEvent, awaitItem())
            emissions += 1
            cancelAndConsumeRemainingEvents()
        }

        assertEquals(3, emissions)
    }
}
