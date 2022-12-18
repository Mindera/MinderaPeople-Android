package com.mindera.people.android.ui.dashboard

import com.mindera.people.android.utils.StateViewModel
import com.mindera.people.utils.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DashboardViewModel : StateViewModel<DashboardViewModel.Action, UiState<Unit>>(initialState = UiState.Idle) {

    override fun processAction(
        action: Action,
        latestState: UiState<Unit>
    ): Flow<UiState<Unit>> {
        return flow { UiState.Idle }
    }

    sealed class Action {

    }
}