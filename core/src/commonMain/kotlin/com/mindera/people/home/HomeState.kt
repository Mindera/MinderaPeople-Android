package com.mindera.people.home

import com.mindera.people.data.Error
import com.mindera.people.user.User

sealed class HomeState {
    object Idle: HomeState()
    object Loading : HomeState()

    data class AuthenticationState(
        val user: User? = null,
        val error: Error? = null
    ): HomeState()
}
