package com.mindera.people.settings.location

import com.mindera.people.api.URL_LOCATIONS
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.mindera.people.api.model.Location as ApiLocation

interface LocationService {
    suspend fun getLocations(): List<ApiLocation>
}

internal class LocationServiceImpl(private val client: HttpClient) : LocationService {

    override suspend fun getLocations(): List<ApiLocation> {
        return client.get(URL_LOCATIONS).body()
    }
}