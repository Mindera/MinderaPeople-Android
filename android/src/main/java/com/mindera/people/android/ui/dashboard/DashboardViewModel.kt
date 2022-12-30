package com.mindera.people.android.ui.dashboard

import androidx.lifecycle.viewModelScope
import com.mindera.people.android.utils.StateViewModel
import com.mindera.people.auth.GetAuthenticatedUserUseCase
import com.mindera.people.timeoff.GetTimeOffSummaryUseCase
import com.mindera.people.timeoff.GetTimeOffUseCase
import com.mindera.people.utils.safeLaunch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach

class DashboardViewModel(
    val getTimeOffSummaryUseCase: GetTimeOffSummaryUseCase,
    val getAuthenticatedUserUseCase: GetAuthenticatedUserUseCase,
    val getTimeOffUseCase: GetTimeOffUseCase,
) : StateViewModel<DashboardViewModel.Action, DashboardState>(initialState = DashboardState.Idle) {

    init {
        viewModelScope.safeLaunch {
            enqueueAction(Action.GetData)
        }
    }

    override fun processAction(
        action: Action,
        latestState: DashboardState
    ): Flow<DashboardState> {
        return processGetDataUser()
    }

    private fun processGetMyDataFromTimeOff(id: Int) = getTimeOffSummaryUseCase(id)

    private fun processGetMyTimeOffs(id: Int) = getTimeOffUseCase(id)

    private fun processGetDataUser() = flow {
        getAuthenticatedUserUseCase()?.let {
            emit(DashboardState.UserData(it))
            processGetMyTimeOffs(it.id).onEach { myTimeOff ->
                emit(DashboardState.MyTimeOffList(myTimeOff))
            }
            processGetMyDataFromTimeOff(it.id).onEach { timeOff ->
                emit(DashboardState.TimeOffData(timeOff))
            }
        } ?: kotlin.run { emit(DashboardState.DashboardError("")) }

    }

    sealed class Action {
        object GetData : Action()
    }
}