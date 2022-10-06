package com.mindera.people

import com.mindera.people.settings.SettingsStorage
import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.KeychainSettings
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

@OptIn(ExperimentalSettingsImplementation::class)
actual val platformModule: Module = module {
    single<Settings>(named(SettingsStorage.encryptedSettingsName)) {
        KeychainSettings(service = SettingsStorage.ENCRYPTED_STORAGE_NAME)
    }
    single<Settings>(named(SettingsStorage.unencryptedSettingsName)) {
        NSUserDefaultsSettings.Factory().create(SettingsStorage.STORAGE_NAME)
    }
}
