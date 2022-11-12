package com.mindera.people.utils

import app.cash.turbine.test
import com.mindera.people.BaseTest
import com.mindera.people.utils.ViewModelTests.TestViewModel.Action
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.milliseconds

class ViewModelTests : BaseTest()  {

    private lateinit var stateViewModel: TestViewModel

    @BeforeTest
    override fun setup() {
        super.setup()
        stateViewModel = TestViewModel()
    }

    @Test
    fun `test StateViewModel actions handling waiting for all events`() = runTest {
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

    private class TestViewModel : StateViewModel<Action, CombinedState>(
        initialState = CombinedState(items = emptyList())
    ) {
        fun action1() { enqueueAction(Action.Action1) }
        fun action2() { enqueueAction(Action.Action2) }
        fun action3() { enqueueAction(Action.Action3) }

        override fun processAction(
            action: Action,
            latestState: CombinedState
        ): Flow<CombinedState> = flow {
            when (action) {
                is Action.Action1 -> {
                    delay(100.milliseconds)
                    emit(CombinedState(items = listOf(1)))
                }
                is Action.Action2 -> {
                    delay(200.milliseconds)
                    emit(latestState.copy(items = latestState.items + listOf(2)))
                }
                is Action.Action3 -> {
                    delay(100.milliseconds)
                    emit(latestState.copy(items = latestState.items + listOf(3)))
                }
            }
        }.flowOn(mainDispatcher)

        sealed class Action {
            object Action1: Action()
            object Action2: Action()
            object Action3: Action()
        }
    }
}
