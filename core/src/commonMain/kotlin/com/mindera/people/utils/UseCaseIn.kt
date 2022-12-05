package com.mindera.people.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class UseCaseIn<IN> {
    operator fun invoke(param: IN): Flow<UiState<Unit>> = flow {
        emit(
            try {
                UiState.Success(block(param))
            } catch (ex: Exception) {
                UiState.Error(ex.userDescription())
            }
        )
    }

    protected abstract val block: suspend (param: IN) -> Unit
}

abstract class UseCaseInFlow<IN> {
    operator fun invoke(param: IN): Flow<UiState<Unit>> = build(param)
        .map { UiState.Success(data = it) }
        .catch { UiState.Error(it.userDescription()) }

    protected abstract fun build(param: IN): Flow<Unit>
}
