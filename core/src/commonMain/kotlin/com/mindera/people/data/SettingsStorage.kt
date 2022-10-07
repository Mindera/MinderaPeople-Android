package com.mindera.people.data

import co.touchlab.kermit.Logger
import com.russhwolf.settings.Settings

interface SettingsStorage {
    var isOnboarded: Boolean

    companion object {
        const val STORAGE_NAME = "UNENCRYPTED_SETTINGS"
        const val ENCRYPTED_STORAGE_NAME = "ENCRYPTED_SETTINGS"
        const val encryptedSettingsName = "encryptedSettings"
        const val unencryptedSettingsName = "unencryptedSettings"
    }
}

class SettingsStorageImpl(
    private val log: Logger,
    private val settings: Settings
): SettingsStorage {

    override var isOnboarded: Boolean
        get() {
            val value = settings.getBoolean(IS_ONBOARDED, false)
            log.d { "get isOnboarded=$value" }
            return value
        }
        set(value) {
            log.d { "set isOnboarded=$value" }
            settings.putBoolean(IS_ONBOARDED, value)
        }

    companion object {
        private const val IS_ONBOARDED = "onboarded"
    }
}
