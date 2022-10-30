package com.mindera.people.home

import com.mindera.people.user.User
import com.mindera.people.user.UserRepository
import com.mindera.people.utils.StateViewModel
import com.mindera.people.utils.safeLaunch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val userRepository: UserRepository
) : StateViewModel<HomeViewModel.Action, HomeState>(initialState = HomeState.Idle) {

    init {
        scope.safeLaunch {
            val user = userRepository.authenticated
            enqueueAction(Action.UserAuthenticationUpdate(user = user))
        }
    }

    override suspend fun processAction(action: Action, latestState: HomeState): HomeState =
        when (action) {
            is Action.Authenticate -> {
                runCatching {
                    withContext(ioDispatcher) {
                        userRepository.authenticateUser(action.user)
                    }
                }
                .fold(onSuccess = { HomeState.AuthenticationState(user = action.user) },
                      onFailure = { HomeState.AuthenticationState(error = it) })
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
