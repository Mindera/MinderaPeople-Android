package com.mindera.people

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

@OptIn(ExperimentalSettingsImplementation::class)
actual val platformModule: Module = module {
    single<Settings>(named(encryptedSettings)) {
        KeychainSettings(service = ENCRYPTED_STORAGE_NAME)
    }
    single<Settings>(named(unencryptedSettings)) {
        NSUserDefaultsSettings.Factory().create(name = STORAGE_NAME)
    }
}
