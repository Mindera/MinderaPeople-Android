package com.mindera.people.auth

import com.mindera.people.data.Error
import com.mindera.people.user.User

sealed class AuthState {
    object Idle: AuthState()
    object Loading : AuthState()

    data class AuthSuccess(val user: User): AuthState()
    data class AuthError(val error: Error): AuthState()

    object UserCleared: AuthState()
}
