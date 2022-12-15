package com.mindera.people.settings.country


interface CountryRepository {
    suspend fun getCountries(): List<Country>
}

internal class CountryRepositoryImpl(private val countryService: CountryService) : CountryRepository {
    override suspend fun getCountries(): List<Country> = countryService.getCountries().toCountries()
}
