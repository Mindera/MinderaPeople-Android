package com.mindera.people.auth

import com.mindera.people.user.User

sealed class AuthState {
    object Idle: AuthState()
    data class AuthSuccess(val user: User): AuthState()
    data class AuthError(val error: Throwable): AuthState()
}
