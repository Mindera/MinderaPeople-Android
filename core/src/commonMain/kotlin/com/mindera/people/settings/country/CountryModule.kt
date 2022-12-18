package com.mindera.people.settings.country

import org.koin.dsl.module

val countryModule = module {
    single<CountryRepository> { CountryRepositoryImpl(get()) }
    single<CountryService> { CountryServiceImpl(get()) }
    factory { GetCountryUseCase(get()) }
}
