package com.mindera.people.utils

sealed class UiState<out T> {
    object Idle: UiState<Nothing>()
    object Loading: UiState<Nothing>()
    data class Error(val error: String): UiState<Nothing>()
    data class Success<T>(val data: T) : UiState<T>()
}
