package com.mindera.people.user

import com.mindera.people.api.URL_USER_FILTER
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.mindera.people.api.model.PersonAllocation as ApiPersonAllocation

interface UserService {
    suspend fun getUserAllocationsById(id: String): ApiPersonAllocation
}

internal class UserServiceImpl(private val client: HttpClient) : UserService {

    override suspend fun getUserAllocationsById(id: String): ApiPersonAllocation =
        client.get(URL_USER_FILTER) { parameter("personId", id) }.body()
}