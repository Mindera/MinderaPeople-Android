package com.mindera.people.android.ui.auth

import com.mindera.people.auth.User
import com.mindera.people.data.Error

sealed class AuthState {
    object Idle: AuthState()
    object Loading : AuthState()

    data class AuthSuccess(val user: User): AuthState()
    data class AuthError(val error: Error?): AuthState()

    object UserCleared: AuthState()
}
