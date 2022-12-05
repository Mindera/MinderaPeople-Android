package com.mindera.people.settings.country

import com.mindera.people.utils.UseCaseOut

class GetCountryUseCase(
    private val repository: CountryRepository,
    override val block: suspend () -> Country = { repository.getCountry() }
) : UseCaseOut<Country>()
