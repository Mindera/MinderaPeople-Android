package com.mindera.people.network.service

import com.mindera.people.network.URL_USER
import com.mindera.people.network.URL_USER_FILTER
import com.mindera.people.network.models.UserAllocationDTO
import com.mindera.people.network.models.UserDTO
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*

interface UserService {
    suspend fun getUser(): UserDTO
    suspend fun getUserAllocationsById(id: String): UserAllocationDTO
}

class UserServiceImpl(private val client: HttpClient) : UserService {

    override suspend fun getUser(): UserDTO {
        return client.get(URL_USER).body()
    }

    override suspend fun getUserAllocationsById(id: String): UserAllocationDTO {
        return client.get(URL_USER_FILTER) {
            parameter("personId", id)
        }.body()
    }
}