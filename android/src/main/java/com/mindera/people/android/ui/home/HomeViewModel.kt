package com.mindera.people.android.ui.home

import com.mindera.people.android.utils.StateViewModel
import com.mindera.people.auth.User
import com.mindera.people.people.GetMyUserUseCase
import com.mindera.people.utils.UiState
import com.mindera.people.utils.safeLaunch
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    private val getMyUserUseCase: GetMyUserUseCase
) : StateViewModel<HomeViewModel.Action, UiState<User>>(initialState = UiState.Idle) {

    init {
        scope.safeLaunch {
            enqueueAction(Action.Authenticate)
        }
    }

    override fun processAction(
        action: Action,
        latestState: UiState<User>
    ): Flow<UiState<User>> {
        return processAuthentication()
    }

    private fun processAuthentication() = getMyUserUseCase()

    sealed class Action {
        object Authenticate : Action()
    }
}