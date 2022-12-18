package com.mindera.people.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class UseCase {
    operator fun invoke(): Flow<UiState<Unit>> = flow {
        emit(
            try {
                UiState.Success(block())
            } catch (ex: Exception) {
                UiState.Error(ex.userDescription())
            }
        )
    }

    protected abstract val block: suspend () -> Unit
}

abstract class UseCaseFlow {
    operator fun invoke(): Flow<UiState<Unit>> = build()
        .map { UiState.Success(data = it) }
        .catch { UiState.Error(it.userDescription()) }

    protected abstract fun build(): Flow<Unit>
}
