package com.mindera.people.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

abstract class UseCaseIn<IN> {
    operator fun invoke(param: IN): Flow<UiState<Unit>> = flow {
        emit(
            try {
                UiState.Success(block(param))
            } catch (ex: Exception) {
                UiState.Error
            }
        )
    }
    protected abstract val block: suspend (param: IN) -> Unit
}

abstract class UseCaseInFlow<IN> {
    operator fun invoke(param: IN): Flow<UiState<Unit>> = try {
        build(param).map { UiState.Success(data = it) }
    } catch (ex: Exception) {
        flowOf(UiState.Error)
    }

    protected abstract fun build(param: IN): Flow<Unit>
}