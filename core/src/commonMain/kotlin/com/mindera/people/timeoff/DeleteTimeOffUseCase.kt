package com.mindera.people.timeoff

import com.mindera.people.people.PersonTimeOff
import com.mindera.people.utils.UseCaseInOut

class DeleteTimeOffUseCase(
    private val repository: TimeOffRepository,
    override val block: suspend (deleteTimeOff: DeleteTimeOffRequest) -> PersonTimeOff = { repository.deleteTimeOff(it.timeOffID, it.personID) }
) : UseCaseInOut<DeleteTimeOffRequest, PersonTimeOff>()
