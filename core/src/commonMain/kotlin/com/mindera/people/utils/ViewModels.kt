package com.mindera.people.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip

expect open class ViewModel() {
    open val mainDispatcher: CoroutineDispatcher
    open val ioDispatcher: CoroutineDispatcher
    val scope: CoroutineScope
}

@Suppress("unused")
abstract class StateViewModel<A, S>(initialState: S): ViewModel() {
    @Suppress("PropertyName")
    private val _state = MutableStateFlow(value = initialState)

    @Suppress("PropertyName")
    private val _action = MutableSharedFlow<A>(extraBufferCapacity = Int.MAX_VALUE)

    val state: StateFlow<S> = _state

    init {
        _action.zip(_state, ::processAction)
            .onEach { _state.value = it }
            .safeLaunchIn(scope)
    }

    fun enqueueAction(action: A) {
        _action.tryEmit(action)
    }

    abstract suspend fun processAction(action: A, latestState: S): S
}
