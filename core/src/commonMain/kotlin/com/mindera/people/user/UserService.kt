package com.mindera.people.user

import com.mindera.people.api.URL_USER
import com.mindera.people.api.URL_USER_FILTER
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.mindera.people.api.model.Person as ApiUser
import com.mindera.people.api.model.PersonAllocation as ApiPersonAllocation

internal interface UserService {
    suspend fun getUser(): ApiUser
    suspend fun getUserAllocationsById(id: String): ApiPersonAllocation
}

internal class UserServiceImpl(private val client: HttpClient) : UserService {

    override suspend fun getUser(): ApiUser = client.get(URL_USER).body()

    override suspend fun getUserAllocationsById(id: String): ApiPersonAllocation =
        client.get(URL_USER_FILTER) { parameter("personId", id) }.body()
}
