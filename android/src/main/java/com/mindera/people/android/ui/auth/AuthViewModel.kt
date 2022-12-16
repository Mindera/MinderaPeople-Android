package com.mindera.people.android.ui.auth

import com.mindera.people.android.navigation.Navigator
import com.mindera.people.android.ui.auth.AuthViewModel.Action
import com.mindera.people.android.utils.StateViewModel
import com.mindera.people.auth.SignInUseCase
import com.mindera.people.auth.SignOutUseCase
import com.mindera.people.auth.User
import com.mindera.people.data.toError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class AuthViewModel(
    private val signInUseCase: SignInUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val navigator: Navigator
) : StateViewModel<Action, AuthState>(initialState = AuthState.Idle) {

    fun startAuthentication() {
        _state.value = AuthState.Loading
    }

    fun validateAuthentication(user: User) {
        enqueueAction(Action.Authenticate(user))
    }

    fun handleError(throwable: Throwable?) {
        enqueueAction(Action.HandleError(throwable ?: Throwable()))
    }

    fun clear() {
        enqueueAction(Action.Clear)
    }

    override fun processAction(action: Action, latestState: AuthState): Flow<AuthState> =
        when (action) {
            is Action.Authenticate -> processAuthentication(action.user)
            is Action.Clear -> processClear()
            is Action.HandleError -> flowOf(AuthState.AuthError(action.throwable.toError()))
        }

    private fun processAuthentication(user: User): Flow<AuthState> = flow {
        signInUseCase(user).fold(
            onSuccess = {
                emit(AuthState.AuthSuccess(it))
                navigator.navigateToHome()
            },
            onFailure = {
                emit(AuthState.AuthError(it.toError()))
            }
        )
    }

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
        data class HandleError(val throwable: Throwable) : Action()
    }
}
