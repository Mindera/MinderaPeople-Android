package com.mindera.people.utils

import app.cash.turbine.test
import com.mindera.people.BaseTest
import com.mindera.people.utils.ViewModelTests.TestViewModel.Action
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.milliseconds

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

    private data class CombinedState(val items: List<Int>)

    private class TestViewModel: StateViewModel<Action, CombinedState>(
        initialState = CombinedState(items = emptyList())
    ) {
        override val mainDispatcher: CoroutineDispatcher get() = StandardTestDispatcher()
        override val ioDispatcher: CoroutineDispatcher get() = StandardTestDispatcher()

        fun action1() { enqueueAction(Action.Action1) }
        fun action2() { enqueueAction(Action.Action2) }
        fun action3() { enqueueAction(Action.Action3) }

        override suspend fun processAction(action: Action, latestState: CombinedState): CombinedState =
            withContext(Dispatchers.Default) {
                when (action) {
                    is Action.Action1 -> {
                        delay(100.milliseconds)
                        CombinedState(items = listOf(1))
                    }
                    is Action.Action2 -> {
                        delay(200.milliseconds)
                        latestState.copy(items = latestState.items + listOf(2))
                    }
                    is Action.Action3 -> {
                        delay(100.milliseconds)
                        latestState.copy(items = latestState.items + listOf(3))
                    }
                }
            }

        sealed class Action {
            object Action1: Action()
            object Action2: Action()
            object Action3: Action()
        }
    }
}
