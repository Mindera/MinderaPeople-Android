package com.mindera.people.network.people

import com.mindera.people.auth.AuthViewModel
import com.mindera.people.network.models.UserDomain
import com.mindera.people.user.User
import com.mindera.people.utils.StateViewModel
import com.mindera.people.utils.UiState
import kotlinx.coroutines.flow.Flow

class PeopleViewModel(
    private val getPeopleUseCase: GetPeopleUseCase
) : StateViewModel<PeopleViewModel.Action, UiState<UserDomain>>(initialState = UiState.Idle) {

    fun getPeopleData(id: String) {
        enqueueAction(Action.Get(id))
    }

    override suspend fun processAction(
        action: Action,
        latestState: UiState<UserDomain>
    ) = when (action) {
        is Action.Get -> processGetPeople(action.id)
    }


    private fun processGetPeople(id: String): Flow<UiState<UserDomain>> = getPeopleUseCase(id)

    sealed class Action {
        data class Get(val id: String) : Action()
    }
}