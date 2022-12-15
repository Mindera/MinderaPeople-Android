package com.mindera.people.people

import org.koin.dsl.module

val peopleModule = module {
    single<PeopleRepository> { PeopleRepositoryImpl(get()) }
    single<PeopleService> { PeopleServiceImpl(get()) }

    factory { GetPersonUseCase(get()) }
    factory { GetMyUserUseCase(get(), get()) }
    factory { GetPersonAddressUseCase(get()) }
    factory { UpdatePersonUseCase(get()) }
}
