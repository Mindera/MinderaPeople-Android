package com.mindera.people

import com.mindera.people.auth.authModule
import com.mindera.people.data.dataModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(platformModule, dataModule, authModule)
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
