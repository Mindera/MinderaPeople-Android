package com.mindera.people.android.utils

import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import com.mindera.people.utils.safeLaunchIn
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip

open class ViewModel : androidx.lifecycle.ViewModel() {
    open val mainDispatcher = DispatchersProvider.main
    open val ioDispatcher = DispatchersProvider.io
    val scope get() = viewModelScope
}

@OptIn(FlowPreview::class)
@Suppress("unused")
abstract class StateViewModel<A, S>(initialState: S): ViewModel() {
    @Suppress("PropertyName")
    internal val _state = MutableStateFlow(value = initialState)

    @Suppress("PropertyName")
    private val _action = MutableSharedFlow<A>(extraBufferCapacity = Int.MAX_VALUE)

    private val logger: Logger by injectWith(this::class.simpleName)

    val state: StateFlow<S> = _state

    init {
        _action.zip(_state, ::processAction)
            .flatMapConcat { it }
            .onEach { _state.value = it }
            .safeLaunchIn(scope)
    }

    fun enqueueAction(action: A) {
        logger.d { "enqueueing action = $action" }
        _action.tryEmit(action)
    }

    protected abstract fun processAction(action: A, latestState: S): Flow<S>
}
