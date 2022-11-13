package com.mindera.people.network.service

import com.mindera.people.network.URL_PEOPLE
import com.mindera.people.network.models.UserAddressDTO
import com.mindera.people.network.models.UserDTO
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface PeopleService {
    suspend fun getPeopleById(id: String): UserDTO
    suspend fun getPeopleAddressById(id: String): UserAddressDTO
    suspend fun updatePeopleById(userDTO: UserDTO)
}

class PeopleServiceImpl(private val client: HttpClient) : PeopleService {

    override suspend fun getPeopleById(id: String): UserDTO {
        return client.get(URL_PEOPLE) {
            parameter("personId", id)
        }.body()
    }

    override suspend fun getPeopleAddressById(id: String): UserAddressDTO {
        return client.get(URL_PEOPLE) {
            parameter("personId", id)
        }.body()
    }

    override suspend fun updatePeopleById(userDTO: UserDTO) {
        return client.put(URL_PEOPLE) {
            setBody(userDTO)
        }.body()
    }
}