package com.mindera.people.network.people

import com.mindera.people.network.models.UserAddressDomain
import com.mindera.people.network.models.UserDomain
import com.mindera.people.utils.UseCaseInOut

class GetPeopleAddressUseCase(
    private val repository: PeopleRepository,
    override val block: suspend (id: String) -> UserAddressDomain = { repository.getPeopleAddressById(it) },
) : UseCaseInOut<String, UserAddressDomain>()