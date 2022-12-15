package com.mindera.people.settings.office

import org.koin.dsl.module

val officeModule = module {
    single<OfficeRepository> { OfficeRepositoryImpl(get()) }
    single<OfficeService> { OfficeServiceImpl(get()) }
    factory { GetOfficeUseCase(get()) }
}
