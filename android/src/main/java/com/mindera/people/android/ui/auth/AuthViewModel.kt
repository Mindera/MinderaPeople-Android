package com.mindera.people.android.ui.auth

import com.mindera.people.android.navigation.Navigator
import com.mindera.people.android.ui.auth.AuthViewModel.Action
import com.mindera.people.android.utils.StateViewModel
import com.mindera.people.auth.SignInUseCase
import com.mindera.people.data.toError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class AuthViewModel(
    private val navigator: Navigator,
    private val signInUseCase: SignInUseCase,
) : StateViewModel<Action, AuthState>(initialState = AuthState.Idle) {

    fun startAuthentication() {
        enqueueAction(Action.Authenticate)
    }

    fun validateAuthentication(token: String) {
        enqueueAction(Action.AuthenticateToken(token))
    }

    override fun processAction(action: Action, latestState: AuthState): Flow<AuthState> =
        when (action) {
            is Action.Authenticate -> processAuthentication()
            is Action.AuthenticateToken -> processAuthenticationToken(action.token)
            is Action.HandleError -> flowOf(AuthState.AuthError(action.throwable.toError()))
        }

    private fun processAuthenticationToken(token: String): Flow<AuthState> = flow {
        signInUseCase(token).fold(
            onSuccess = {
                emit(AuthState.AuthSuccess)
                navigator.navigateToHome()
            },
            onFailure = {
                emit(AuthState.AuthError(it.toError()))
            }
        )
    }

    private fun processAuthentication(): Flow<AuthState> = flow {
        emit(AuthState.Idle)
        _state.value = AuthState.AuthWebView
    }

    sealed class Action {
        object Authenticate : Action()
        data class AuthenticateToken(val token: String) : Action()
        data class HandleError(val throwable: Throwable) : Action()
    }
}
