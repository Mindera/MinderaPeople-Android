package com.mindera.people.people

import com.mindera.people.utils.UseCaseInOut

class GetPersonAddressUseCase(
    private val repository: PeopleRepository,
    override val block: suspend (id: String) -> PersonAddress = {
        repository.getPersonAddressById(it)
    },
) : UseCaseInOut<String, PersonAddress>()
