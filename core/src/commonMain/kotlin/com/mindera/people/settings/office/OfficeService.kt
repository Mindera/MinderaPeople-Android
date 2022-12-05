package com.mindera.people.settings.office

import com.mindera.people.api.URL_OFFICES
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.mindera.people.api.model.Office as ApiOffice

interface OfficeService {
    suspend fun getOffice(): ApiOffice
}

internal class OfficeServiceImpl(private val client: HttpClient) : OfficeService {

    override suspend fun getOffice(): ApiOffice {
        return client.get(URL_OFFICES).body()
    }
}