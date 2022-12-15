package com.mindera.people.android.ui.auth

import com.mindera.people.data.Error

sealed class AuthState {
    object Idle: AuthState()
    object Loading : AuthState()
    object AuthWebView : AuthState()
    object AuthSuccess: AuthState()
    data class AuthError(val error: Error?): AuthState()

    object UserCleared: AuthState()
}
