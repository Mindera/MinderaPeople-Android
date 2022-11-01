package com.mindera.people.auth

import com.mindera.people.auth.AuthViewModel.Action
import com.mindera.people.user.User
import com.mindera.people.user.UserRepository
import com.mindera.people.utils.StateViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuthViewModel(
    private val userRepository: UserRepository
) : StateViewModel<Action, AuthState>(
    initialState = AuthState.Idle
) {
    fun authenticate(user: User) {
        enqueueAction(Action.Authenticate(user))
    }

    fun clear() {
        enqueueAction(Action.Clear)
    }

    override suspend fun processAction(action: Action, latestState: AuthState): Flow<AuthState> =
        when (action) {
            is Action.Authenticate -> processAuthentication(action.user)
            is Action.Clear -> processClear()
        }

    private fun processAuthentication(user: User): Flow<AuthState> = flow {
        runCatching { userRepository.authenticateUser(user) }
            .fold(onSuccess = { emit(AuthState.AuthSuccess(user)) },
                  onFailure = { emit(AuthState.AuthError(it)) })
    }.flowOn(ioDispatcher)

    private fun processClear(): Flow<AuthState> = flow {
        // necessary to prevent no emission in case the prior `state` is UserCleared
        emit(AuthState.Idle)
        // clear the user authenticated
        runCatching { userRepository.clearUser() }
            .fold(onSuccess = { emit(AuthState.UserCleared) },
                  onFailure = { emit(AuthState.AuthError(it)) })
    }.flowOn(ioDispatcher)

    sealed class Action {
        data class Authenticate(val user: User) : Action()
        object Clear : Action()
    }
}
