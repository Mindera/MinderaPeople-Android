package com.mindera.people.data

import co.touchlab.kermit.Logger
import com.mindera.people.user.User
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.serialization.decodeValueOrNull
import com.russhwolf.settings.serialization.encodeValue
import kotlinx.serialization.ExperimentalSerializationApi

interface SettingsStorage {
    var user: User?

    companion object {
        const val STORAGE_NAME = "UNENCRYPTED_SETTINGS"
        const val ENCRYPTED_STORAGE_NAME = "ENCRYPTED_SETTINGS"
        const val encryptedSettingsName = "encryptedSettings"
        const val unencryptedSettingsName = "unencryptedSettings"
    }
}

@OptIn(ExperimentalSerializationApi::class, ExperimentalSettingsApi::class)
class SettingsStorageImpl(
    private val log: Logger,
    private val encryptedSettings: Settings
): SettingsStorage {

    override var user: User?
        get() {
            val user: User? = encryptedSettings.decodeValueOrNull(User.serializer(), USER_SETTING)
            log.d { "Getting user $user" }
            return user
        }
        set(value) {
            log.d {"Setting user $value"}
            if (value == null) {
                encryptedSettings.remove(USER_SETTING)
            } else {
                encryptedSettings.encodeValue(User.serializer(), USER_SETTING, value)
            }
        }

    companion object {
        private const val USER_SETTING = "user"
    }
}
