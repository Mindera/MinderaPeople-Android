package com.mindera.people

import com.mindera.people.data.SettingsStorage
import com.mindera.people.data.SettingsStorageImpl
import com.mindera.people.user.UserRepository
import com.mindera.people.user.UserRepositoryImpl
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(platformModule, coreModule)
}

private val coreModule = module {
    single<SettingsStorage> {
        SettingsStorageImpl(
            log = getWith("Settings"),
            settings = get(named(unencryptedSettings))
        )
    }

    factory<UserRepository> {
        UserRepositoryImpl(
            log = getWith("UserRepo"),
            encryptedSettings = get(named(encryptedSettings))
        )
    }
}

inline fun <reified T> Scope.getWith(vararg params: Any?): T =
    get(parameters = { parametersOf(*params) })

expect val platformModule: Module

// region Koin Qualifiers
const val STORAGE_NAME = "UNENCRYPTED_SETTINGS"
const val ENCRYPTED_STORAGE_NAME = "ENCRYPTED_SETTINGS"
const val encryptedSettings = "encryptedSettings"
const val unencryptedSettings = "unencryptedSettings"
// endregion
