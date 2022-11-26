package com.mindera.people.android.ui.home

import com.mindera.people.android.utils.StateViewModel
import com.mindera.people.auth.GetAuthenticatedUserUseCase
import com.mindera.people.auth.SignInUseCase
import com.mindera.people.auth.User
import com.mindera.people.data.toError
import com.mindera.people.utils.safeLaunch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class HomeViewModel(
    private val getAuthenticatedUserUseCase: GetAuthenticatedUserUseCase,
    private val signInUseCase: SignInUseCase
) : StateViewModel<HomeViewModel.Action, HomeState>(initialState = HomeState.Idle) {

    init {
        scope.safeLaunch {
            enqueueAction(Action.UserAuthenticationUpdate(user = getAuthenticatedUserUseCase()))
        }
    }

    override fun processAction(action: Action, latestState: HomeState): Flow<HomeState> =
        when (action) {
            is Action.Authenticate -> processAuthentication(action.user)
            is Action.UserAuthenticationUpdate ->
                processAuthenticationUpdate(user = action.user, error = action.error)
        }

    fun setUser(user: User) {
        enqueueAction(Action.Authenticate(user))
    }

    private fun processAuthentication(user: User): Flow<HomeState> = flow {
        emit(HomeState.Loading)
        signInUseCase(user).fold(
            onSuccess = { emit(HomeState.AuthenticationState(user = user)) },
            onFailure = { emit(HomeState.AuthenticationState(error = it.toError())) }
        )
    }.flowOn(ioDispatcher)

    private fun processAuthenticationUpdate(user: User?, error: Throwable?): Flow<HomeState> =
        flowOf(HomeState.AuthenticationState(user = user, error = error?.toError()))

    sealed class Action {
        data class Authenticate(val user: User) : Action()
        data class UserAuthenticationUpdate(
            val user: User? = null,
            val error: Throwable? = null
        ) : Action()
    }
}
