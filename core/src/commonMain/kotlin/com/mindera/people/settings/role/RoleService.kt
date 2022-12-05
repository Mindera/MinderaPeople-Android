package com.mindera.people.settings.role

import com.mindera.people.api.URL_ROLES
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.mindera.people.api.model.Role as ApiRole

interface RoleService {
    suspend fun getRole(): ApiRole
}

internal class RoleServiceImpl(private val client: HttpClient) : RoleService {

    override suspend fun getRole(): ApiRole{
        return client.get(URL_ROLES).body()
    }
}