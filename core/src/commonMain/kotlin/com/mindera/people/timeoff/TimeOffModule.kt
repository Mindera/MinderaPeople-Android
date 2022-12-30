package com.mindera.people.timeoff

import org.koin.dsl.module

val timeOffModule = module {
    single<TimeOffRepository> { TimeOffRepositoryImpl(get()) }
    single<TimeOffService> { TimeOffServiceImpl(get()) }

    factory { GetTimeOffUseCase(get()) }
    factory { GetTimeOffSummaryUseCase(get()) }
    factory { GetTimeOffCalendarUseCase(get()) }
}
