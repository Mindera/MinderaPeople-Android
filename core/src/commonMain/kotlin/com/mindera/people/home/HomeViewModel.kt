package com.mindera.people.home

import com.mindera.people.user.User
import com.mindera.people.user.UserRepository
import com.mindera.people.utils.StateViewModel
import com.mindera.people.utils.safeLaunch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
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

    override suspend fun processAction(action: Action, latestState: HomeState): Flow<HomeState> =
        when (action) {
            is Action.Authenticate -> processAuthentication(action.user)
            is Action.UserAuthenticationUpdate ->
                processAuthenticationUpdate(user = action.user, error = action.error)
        }

    fun fetchSignInUser(email: String, name: String?) {
        setUser(email, name)
    }

    fun setUser(email: String, name: String?) {
        val user = User(email = email, name = name)
        enqueueAction(Action.Authenticate(user))
    }

    private fun processAuthentication(user: User): Flow<HomeState> = flow {
        emit(HomeState.Loading)

        runCatching {
            withContext(ioDispatcher) {
                userRepository.authenticateUser(user)
            }
        }
        .fold(onSuccess = { emit(HomeState.AuthenticationState(user = user)) },
              onFailure = { emit(HomeState.AuthenticationState(error = it)) })
    }

    private fun processAuthenticationUpdate(user: User?, error: Throwable?): Flow<HomeState> =
        flowOf(HomeState.AuthenticationState(user = user, error = error))

    sealed class Action {
        data class Authenticate(val user: User) : Action()
        data class UserAuthenticationUpdate(
            val user: User? = null,
            val error: Throwable? = null
        ) : Action()
    }
}
