package com.mindera.people.settings.country

import com.mindera.people.utils.UseCaseOut

class GetCountryUseCase(
    private val repository: CountryRepository,
    override val block: suspend () -> List<Country> = { repository.getCountries() }
) : UseCaseOut<List<Country>>()
