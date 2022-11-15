package com.mindera.people.policy

import org.koin.dsl.module

val policyModule = module {
    single<PolicyRepository> { PolicyRepositoryImpl(get()) }
    factory { GetPolicyUseCase(get()) }
}
