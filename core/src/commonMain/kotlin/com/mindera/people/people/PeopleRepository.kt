package com.mindera.people.people

import com.mindera.people.auth.User
import com.mindera.people.auth.toUser

interface PeopleRepository {
    suspend fun getUser(): User
    suspend fun getPerson(): Person
    suspend fun getPersonById(id: String): Person
    suspend fun getPersonAddressById(id: String): PersonAddress
    suspend fun updatePersonById(person: Person)
}

internal class PeopleRepositoryImpl(
    private val peopleService: PeopleService
) : PeopleRepository {

    override suspend fun getPersonById(id: String): Person =
        peopleService.getPeopleById(id).toPerson()

    override suspend fun getPersonAddressById(id: String): PersonAddress =
        peopleService.getPeopleAddressById(id).toPersonAddress()

    override suspend fun updatePersonById(person: Person) =
        peopleService.updatePeopleById(person.toApiModel())

    override suspend fun getPerson(): Person =
        peopleService.getPerson().toPerson()

    override suspend fun getUser(): User =
        peopleService.getUser().toUser()
}
