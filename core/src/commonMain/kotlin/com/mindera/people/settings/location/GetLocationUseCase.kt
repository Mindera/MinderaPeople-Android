package com.mindera.people.settings.location

import com.mindera.people.utils.UseCaseOut

class GetLocationUseCase(
    private val repository: LocationRepository,
    override val block: suspend () -> List<Location> = { repository.getLocations() }
) : UseCaseOut<List<Location>>()
