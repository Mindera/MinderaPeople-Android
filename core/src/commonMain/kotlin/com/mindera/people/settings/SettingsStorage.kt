package com.mindera.people.settings

import co.touchlab.kermit.Logger
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

class SettingsStorage(
    private val log: Logger,
    private val encryptedSettings: Settings
) {
    var token: String?
        get() {
            val tokenn: String? = encryptedSettings[TOKEN_NAME]
            log.d { "Getting token $tokenn" }
            return tokenn
        }
        set(value) {
            log.d {"Setting token $value"}
            encryptedSettings[TOKEN_NAME] = value
        }

    companion object {
        const val STORAGE_NAME = "UNENCRYPTED_SETTINGS"
        const val ENCRYPTED_STORAGE_NAME = "ENCRYPTED_SETTINGS"
        const val encryptedSettingsName = "encryptedSettings"
        const val unencryptedSettingsName = "unencryptedSettings"

        private const val TOKEN_NAME = "TOKEN"
    }
}
