package com.mindera.people.settings.skill

import org.koin.dsl.module

val skillModule = module {
    single<SkillRepository> { SkillRepositoryImpl(get()) }
    single<SkillService> { SkillServiceImpl(get()) }
    factory { GetSkillUseCase(get()) }
}
