package com.mindera.people.android.ui.home

import androidx.lifecycle.viewModelScope
import com.mindera.people.android.utils.StateViewModel
import com.mindera.people.auth.User
import com.mindera.people.people.GetMyUserUseCase
import com.mindera.people.utils.UiState
import com.mindera.people.utils.safeLaunch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class HomeViewModel(
    private val getMyUserUseCase: GetMyUserUseCase
) : StateViewModel<HomeViewModel.Action, UiState<User>>(initialState = UiState.Idle) {

    init {
        viewModelScope.safeLaunch {
            enqueueAction(Action.Authenticate)
        }
    }

    override fun processAction(action: Action, latestState: HomeState): Flow<HomeState> =
        when (action) {
            is Action.Authenticate -> processAuthentication(action.user)
            is Action.UserAuthenticationUpdate ->
                processAuthenticationUpdate(user = action.user, error = action.error)
        }

    private fun processAuthentication() = getMyUserUseCase()

    sealed class Action {
        object Authenticate : Action()
    }
}
