package com.mindera.people

sealed class UiState<out T> {
    object Idle: UiState<Nothing>()
    object Loading: UiState<Nothing>()
    object Error: UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
}
