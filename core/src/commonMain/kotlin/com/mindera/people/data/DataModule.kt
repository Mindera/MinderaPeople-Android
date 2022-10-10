package com.mindera.people.data

import com.mindera.people.getWith
import com.mindera.people.unencryptedSettings
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single<SettingsStorage> {
        SettingsStorageImpl(log = getWith("Settings"),
                            settings = get(named(unencryptedSettings)))
    }
}
