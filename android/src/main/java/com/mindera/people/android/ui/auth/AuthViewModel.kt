package com.mindera.people.android.ui.auth

import com.mindera.people.android.ui.auth.AuthViewModel.Action
import com.mindera.people.android.utils.StateViewModel
import com.mindera.people.auth.SignInUseCase
import com.mindera.people.auth.SignOutUseCase
import com.mindera.people.auth.User
import com.mindera.people.data.toError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuthViewModel(
    private val signInUseCase: SignInUseCase,
    private val signOutUseCase: SignOutUseCase
) : StateViewModel<Action, AuthState>(initialState = AuthState.Idle) {

    fun authenticate(user: User) {
        enqueueAction(Action.Authenticate(user))
    }

    fun clear() {
        enqueueAction(Action.Clear)
    }

    override fun processAction(action: Action, latestState: AuthState): Flow<AuthState> =
        when (action) {
            is Action.Authenticate -> processAuthentication(action.user)
            is Action.Clear -> processClear()
        }

    private fun processAuthentication(user: User): Flow<AuthState> = flow {
        emit(AuthState.Loading)
        signInUseCase(user).fold(
            onSuccess = { emit(AuthState.AuthSuccess(it)) },
            onFailure = { emit(AuthState.AuthError(it.toError())) }
        )
    }.flowOn(ioDispatcher)

    private fun processClear(): Flow<AuthState> = flow {
        // necessary to prevent no emission in case the prior `state` is UserCleared
        emit(AuthState.Idle)
        // clear the user authenticated
        signOutUseCase().fold(
            onSuccess = { emit(AuthState.UserCleared) },
            onFailure = { emit(AuthState.AuthError(it.toError())) }
        )
    }.flowOn(ioDispatcher)

    sealed class Action {
        data class Authenticate(val user: User) : Action()
        object Clear : Action()
    }
}
