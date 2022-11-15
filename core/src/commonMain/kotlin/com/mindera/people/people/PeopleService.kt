package com.mindera.people.people

import com.mindera.people.api.URL_PEOPLE
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.mindera.people.api.model.Person as ApiPerson
import com.mindera.people.api.model.PersonAddress as ApiPersonAddress

internal interface PeopleService {
    suspend fun getPeopleById(id: String): ApiPerson
    suspend fun getPeopleAddressById(id: String): ApiPersonAddress
    suspend fun updatePeopleById(apiUser: ApiPerson)
}

internal class PeopleServiceImpl(private val client: HttpClient) : PeopleService {
    override suspend fun getPeopleById(id: String): ApiPerson =
        client.get(URL_PEOPLE) { parameter("personId", id) }.body()

    override suspend fun getPeopleAddressById(id: String): ApiPersonAddress =
        client.get(URL_PEOPLE) { parameter("personId", id) }.body()

    override suspend fun updatePeopleById(apiUser: ApiPerson) =
        client.put(URL_PEOPLE) { setBody(apiUser) }.body<Unit>()
}
