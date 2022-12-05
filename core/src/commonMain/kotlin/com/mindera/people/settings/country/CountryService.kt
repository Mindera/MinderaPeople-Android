package com.mindera.people.settings.country

import com.mindera.people.api.URL_COUNTRIES
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.mindera.people.api.model.Country as ApiCountry

interface CountryService {
    suspend fun getCountry(): ApiCountry
}

internal class CountryServiceImpl(private val client: HttpClient) : CountryService {

    override suspend fun getCountry(): ApiCountry {
        return client.get(URL_COUNTRIES).body()
    }
}