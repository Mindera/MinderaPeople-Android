package com.mindera.people.settings.location

import com.mindera.people.api.model.Location as ApiLocation

internal fun List<ApiLocation>.toLocations(): List<Location> = this.map { it.toLocation() }

internal fun ApiLocation.toLocation(): Location =
    Location(
        id = this.id ?: 0,
        organizationId = this.organizationId ?: 0,
        name = this.name ?: "",
        country = this.country ?: "",
        countryId = this.countryId ?: 0
    )
