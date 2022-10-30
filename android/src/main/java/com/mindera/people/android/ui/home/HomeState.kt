package com.mindera.people.android.ui.home

import com.mindera.people.user.User

sealed class HomeState {
    object Idle: HomeState()
    object Loading : HomeState()

    data class AuthenticationState(
        val user: User? = null,
        val error: Throwable? = null
    ): HomeState()
}
