package com.mindera.people.people

import com.mindera.people.utils.UseCaseInOut

class GetPersonUseCase(
    private val repository: PeopleRepository,
    override val block: suspend (id: String) -> Person = { repository.getPersonById(it) },
) : UseCaseInOut<String, Person>()
