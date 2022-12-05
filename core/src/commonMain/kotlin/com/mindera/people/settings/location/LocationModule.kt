package com.mindera.people.settings.location

import org.koin.dsl.module

val locationModule = module {
    single<LocationRepository> { LocationRepositoryImpl(get()) }
    single<LocationService> { LocationServiceImpl(get()) }
    factory { GetLocationUseCase(get()) }
}
