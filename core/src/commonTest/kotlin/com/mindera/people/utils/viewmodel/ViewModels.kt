package com.mindera.people.utils.viewmodel

import com.mindera.people.utils.StateViewModel
import com.mindera.people.utils.viewmodel.TestViewModel.Action
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds

data class CombinedState(val items: List<Int>)

class TestViewModel: StateViewModel<Action, CombinedState>(
    initialState = CombinedState(items = emptyList())
) {
    override val mainDispatcher: CoroutineDispatcher get() = StandardTestDispatcher()
    override val ioDispatcher: CoroutineDispatcher get() = StandardTestDispatcher()

    fun action1() { enqueueAction(Action.Action1) }
    fun action2() { enqueueAction(Action.Action2) }
    fun action3() { enqueueAction(Action.Action3) }

    override suspend fun processAction(action: Action, latestState: CombinedState): CombinedState =
        withContext(Dispatchers.Default) {
            return@withContext when (action) {
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
