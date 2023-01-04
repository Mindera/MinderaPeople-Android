package com.mindera.people.android.ui.dashboard

import androidx.lifecycle.viewModelScope
import com.mindera.people.android.ui.auth.AuthViewModel
import com.mindera.people.android.utils.StateViewModel
import com.mindera.people.auth.GetAuthenticatedUserUseCase
import com.mindera.people.people.PersonTimeOff
import com.mindera.people.timeoff.DeleteTimeOffRequest
import com.mindera.people.timeoff.DeleteTimeOffUseCase
import com.mindera.people.timeoff.GetTimeOffSummaryUseCase
import com.mindera.people.timeoff.GetTimeOffUseCase
import com.mindera.people.utils.UiState
import com.mindera.people.utils.safeLaunch
import kotlinx.coroutines.flow.*

class DashboardViewModel(
    val getTimeOffSummaryUseCase: GetTimeOffSummaryUseCase,
    val getAuthenticatedUserUseCase: GetAuthenticatedUserUseCase,
    val getTimeOffUseCase: GetTimeOffUseCase,
    val deleteTimeOffUseCase: DeleteTimeOffUseCase,
) : StateViewModel<DashboardViewModel.Action, DashboardState>(initialState = DashboardState.Idle) {

    private val timeOffDataList: ArrayList<PersonTimeOff> = arrayListOf()

    init {
        viewModelScope.safeLaunch {
            enqueueAction(Action.GetData)
        }
    }

    fun createNewEvent() {
        enqueueAction(Action.CreateNewEvent)
    }

    fun deleteEvent(item: PersonTimeOff) {
        enqueueAction(Action.DeleteEvent(item))
    }

    override fun processAction(
        action: Action,
        latestState: DashboardState
    ) = when (action) {
        is Action.GetData -> processGetDataUser()
        is Action.DeleteEvent -> processDeleteEvent(action.item)
        else -> processNewEvent()

    }

    private fun processGetMyDataFromTimeOff(id: Int) =
        getTimeOffSummaryUseCase(id).onStart { UiState.Loading }

    private fun processGetMyTimeOffs(id: Int) =
        getTimeOffUseCase(id).onStart { UiState.Loading }

    private fun processNewEvent() = flow {
        emit(DashboardState.Idle)
        // Going to the calendar
    }

    private fun processDeleteEvent(item: PersonTimeOff) = flow {
//        deleteTimeOffUseCase(DeleteTimeOffRequest(item.id, item.personId)).collectLatest {
//            if (it is UiState.Success) {
                timeOffDataList.remove(item)
                emit(
                    (_state.value as DashboardState.AllData).copy(
                        myTimeOffList = UiState.Success(
                            timeOffDataList
                        )
                    )
                )
//            }
//        }
    }

    private fun processGetDataUser() = flow {
        getAuthenticatedUserUseCase()?.let {
            emit(
                DashboardState.AllData(
                    it,
                    processGetMyDataFromTimeOff(it.id).first(),
                    processGetMyTimeOffs(it.id).first().also { uiState ->
                        if (uiState is UiState.Success) {
                            timeOffDataList.addAll(uiState.data)
                        }
                    },
                )
            )
        } ?: kotlin.run { emit(DashboardState.DashboardError("")) }

    }

    sealed class Action {
        object GetData : Action()
        object CreateNewEvent : Action()
        data class DeleteEvent(val item: PersonTimeOff) : Action()
    }
}