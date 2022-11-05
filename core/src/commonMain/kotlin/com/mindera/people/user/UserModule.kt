package com.mindera.people.user

import com.mindera.people.encryptedSettings
import com.mindera.people.getWith
import org.koin.core.qualifier.named
import org.koin.dsl.module

val userModule = module {
    factory<UserRepository> {
        UserRepositoryImpl(log = getWith("UserRepo"),
                           encryptedSettings = get(named(encryptedSettings)))
    }
}
