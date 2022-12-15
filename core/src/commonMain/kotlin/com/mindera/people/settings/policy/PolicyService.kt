package com.mindera.people.settings.policy

import com.mindera.people.api.URL_POLICES
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.mindera.people.api.model.Policy as ApiPolicy

interface PolicyService {
    suspend fun getPolicies(): List<ApiPolicy>
}

internal class PolicyServiceImpl(private val client: HttpClient) : PolicyService {

    override suspend fun getPolicies(): List<ApiPolicy>{
        return client.get(URL_POLICES).body()
    }
}
