package com.mindera.people.people

import com.mindera.people.utils.StateViewModel
import com.mindera.people.utils.UiState
import kotlinx.coroutines.flow.Flow

class PeopleViewModel(
    private val getPersonUseCase: GetPersonUseCase
) : StateViewModel<PeopleViewModel.Action, UiState<Person>>(initialState = UiState.Idle) {

    fun loadPersonData(id: String) {
        enqueueAction(Action.Get(id))
    }

    override fun processAction(action: Action, latestState: UiState<Person>) =
        when (action) {
            is Action.Get -> processGetPerson(action.id)
        }

    private fun processGetPerson(id: String): Flow<UiState<Person>> = getPersonUseCase(id)

    sealed class Action {
        data class Get(val id: String) : Action()
    }
}
