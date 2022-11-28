package com.mindera.people.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

abstract class UseCaseOut<OUT> {
    operator fun invoke(): Flow<UiState<OUT>> = flow {
        emit(
            try {
                UiState.Success(block())
            } catch (ex: Exception) {
                UiState.Error(ex.userDescription())
            }
        )
    }

    protected abstract val block: suspend () -> OUT
}

abstract class UseCaseOutFlow<OUT> {
    operator fun invoke(): Flow<UiState<OUT>> = build()
        .map { UiState.Success(data = it) }
        .catch { UiState.Error(it.userDescription()) }

    protected abstract fun build(): Flow<OUT>
}