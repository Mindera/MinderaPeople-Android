package com.mindera.people.auth

import com.mindera.people.encryptedSettings
import com.mindera.people.getWith
import org.koin.core.qualifier.named
import org.koin.dsl.module

val authModule = module {
    factory<AuthRepository> {
        AuthRepositoryImpl(log = getWith("UserRepo"),
            encryptedSettings = get(named(encryptedSettings)))
    }

    // use cases
    factory {
        GetAuthenticatedUserUseCase(
            authRepository = get(),
            log = getWith("GetAuthenticatedUserUseCase"))
    }
    factory { SignInUseCase(authRepository = get(), log = getWith("SignInUseCase")) }
    factory { SignOutUseCase(authRepository = get(), log = getWith("SignOutUseCase")) }
}
