package com.mindera.people.people

interface PeopleRepository {
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
}
