package com.mindera.people.settings.location


interface LocationRepository {
    suspend fun getLocation(): Location
}

internal class LocationRepositoryImpl(private val locationService: LocationService) : LocationRepository {
    override suspend fun getLocation(): Location = locationService.getLocation().toLocation()
}
