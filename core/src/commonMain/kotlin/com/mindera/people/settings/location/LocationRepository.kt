package com.mindera.people.settings.location


interface LocationRepository {
    suspend fun getLocations(): List<Location>
}

internal class LocationRepositoryImpl(private val locationService: LocationService) : LocationRepository {
    override suspend fun getLocations(): List<Location> = locationService.getLocations().toLocations()
}
