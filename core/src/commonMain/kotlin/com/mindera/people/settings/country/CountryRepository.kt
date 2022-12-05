package com.mindera.people.settings.country


interface CountryRepository {
    suspend fun getCountry(): Country
}

internal class CountryRepositoryImpl(private val countryService: CountryService) : CountryRepository {
    override suspend fun getCountry(): Country = countryService.getCountry().toCountry()
}
