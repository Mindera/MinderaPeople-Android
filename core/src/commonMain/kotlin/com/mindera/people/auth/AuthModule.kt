package com.mindera.people.auth

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val authModule = module {
    factoryOf(::AuthViewModel)
}
