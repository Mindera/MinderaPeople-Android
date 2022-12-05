package com.mindera.people.settings.policy

import org.koin.dsl.module

val policyModule = module {
    single<PolicyRepository> { PolicyRepositoryImpl(get()) }
    single<PolicyService> { PolicyServiceImpl(get()) }
    factory { GetPolicyUseCase(get()) }
}
