package com.mindera.people.utils.viewmodel

import app.cash.turbine.test
import com.mindera.people.BaseTest
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ViewModelTests : BaseTest()  {

    private val stateViewModel by lazy { TestViewModel() }

    @Test
    fun `test StateViewModel actions handling waiting for all`() = runTest {
        stateViewModel.state.test {
            assertEquals(CombinedState(items = emptyList()), awaitItem())
            stateViewModel.action1()
            assertEquals(CombinedState(items = listOf(1)), awaitItem())
            stateViewModel.action2()
            assertEquals(CombinedState(items = listOf(1, 2)), awaitItem())
            stateViewModel.action3()
            assertEquals(CombinedState(items = listOf(1, 2, 3)), awaitItem())
        }
    }

    @Test
    fun `test StateViewModel actions handling not loses any event`() = runTest {
        stateViewModel.state.test {
            assertEquals(CombinedState(items = emptyList()), awaitItem())
            stateViewModel.action1()
            stateViewModel.action2()
            stateViewModel.action3()
            assertEquals(CombinedState(items = listOf(1)), awaitItem())
            assertEquals(CombinedState(items = listOf(1, 2)), awaitItem())
            assertEquals(CombinedState(items = listOf(1, 2, 3)), awaitItem())
        }
    }
}
