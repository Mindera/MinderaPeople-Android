package com.mindera.people.android.ui.home

import com.mindera.people.auth.AuthState
import com.mindera.people.auth.AuthViewModel
import com.mindera.people.user.User
import com.mindera.people.utils.StateViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel(
    private val authViewModel: AuthViewModel
) : StateViewModel<HomeViewModel.Action, HomeState>(initialState = HomeState.Idle) {

    init {
        authViewModel.state.onEach {
            when (it) {
                is AuthState.Idle -> {/* no-op */}
                is AuthState.AuthSuccess ->
                    enqueueAction(Action.UserAuthenticationUpdate(user = it.user))
                is AuthState.AuthError ->
                    enqueueAction(Action.UserAuthenticationUpdate(error = it.error))
            }
        }
        .launchIn(scope)
    }

    override suspend fun processAction(action: Action, latestState: HomeState): HomeState =
        when (action) {
            is Action.Authenticate -> {
                authViewModel.authenticate(action.user)
                HomeState.Loading
            }
            is Action.UserAuthenticationUpdate ->
                HomeState.AuthenticationState(user = action.user, error = action.error)
        }

    fun fetchSignInUser(email: String, name: String?) {
        setUser(email, name)
    }

    fun setUser(email: String, name: String?) {
        val user = User(email = email, name = name)
        enqueueAction(Action.Authenticate(user))
    }

    sealed class Action {
        data class Authenticate(val user: User) : Action()
        data class UserAuthenticationUpdate(
            val user: User? = null,
            val error: Throwable? = null
        ) : Action()
    }
}
