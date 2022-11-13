package com.mindera.people.network.timeoff

import com.mindera.people.network.models.UserTimeOffDomain
import com.mindera.people.utils.UseCaseOut

class GetTimeOffUseCase(
    private val repository: TimeOffRepository,
    override val block: suspend () -> UserTimeOffDomain = { repository.getUser() },
) : UseCaseOut<UserTimeOffDomain>()