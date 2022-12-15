package com.mindera.people.user

import org.koin.dsl.module

val userModule = module {
    factory<UserService> {
        UserServiceImpl(get())
    }
}
