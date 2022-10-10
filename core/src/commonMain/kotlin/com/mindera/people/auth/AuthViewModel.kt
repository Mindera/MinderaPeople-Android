package com.mindera.people.auth

import com.mindera.people.auth.AuthViewModel.Action
import com.mindera.people.user.User
import com.mindera.people.user.UserRepository
import com.mindera.people.utils.StateViewModel

class AuthViewModel(
    private val userRepository: UserRepository
) : StateViewModel<Action, AuthState>(
    initialState = AuthState.Idle
) {
    fun authenticate(user: User) {
        enqueueAction(Action.Authenticate(user))
    }

    override suspend fun processAction(latestState: AuthState, action: Action): AuthState =
        when (action) {
            is Action.Authenticate -> processAuthentication(action.user)
        }

    private fun processAuthentication(user: User): AuthState =
        runCatching { userRepository.authenticateUser(user) }
            .fold(onSuccess = { AuthState.AuthSuccess(user) },
                  onFailure = { AuthState.AuthError(it) })

    sealed class Action {
        data class Authenticate(val user: User): Action()
    }
}
