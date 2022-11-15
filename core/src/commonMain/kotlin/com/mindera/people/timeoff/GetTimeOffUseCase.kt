package com.mindera.people.timeoff

import com.mindera.people.people.PersonTimeOff
import com.mindera.people.utils.UseCaseOut

class GetTimeOffUseCase(
    private val repository: TimeOffRepository,
    override val block: suspend () -> PersonTimeOff = { repository.getUser() },
) : UseCaseOut<PersonTimeOff>()
