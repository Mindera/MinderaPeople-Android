package com.mindera.people.people

import com.mindera.people.utils.UseCaseIn

class UpdatePersonUseCase(
    private val repository: PeopleRepository,
    override val block: suspend (user: Person) -> Unit = { repository.updatePersonById(it) },
) : UseCaseIn<Person>()
