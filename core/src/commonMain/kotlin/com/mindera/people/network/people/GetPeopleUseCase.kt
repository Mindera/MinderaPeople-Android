package com.mindera.people.network.people

import com.mindera.people.network.models.UserDomain
import com.mindera.people.utils.UseCaseInOut

class GetPeopleUseCase(
    private val repository: PeopleRepository,
    override val block: suspend (id: String) -> UserDomain = { repository.getPeopleById(it) },
) : UseCaseInOut<String, UserDomain>()