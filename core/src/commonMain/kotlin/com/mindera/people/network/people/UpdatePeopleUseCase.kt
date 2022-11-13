package com.mindera.people.network.people

import com.mindera.people.network.models.UserDTO
import com.mindera.people.network.models.UserDomain
import com.mindera.people.utils.UseCaseIn
import com.mindera.people.utils.UseCaseInOut

class UpdatePeopleUseCase(
    private val repository: PeopleRepository,
    override val block: suspend (userDomain: UserDomain) -> Unit = { repository.updatePeopleById(it) },
) : UseCaseIn<UserDomain>()