package com.mindera.people.user

import co.touchlab.kermit.Logger
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.serialization.decodeValueOrNull
import com.russhwolf.settings.serialization.encodeValue
import kotlinx.serialization.ExperimentalSerializationApi

interface UserRepository {
    val authenticated: User?
    fun authenticateUser(user: User)
    fun clearUser()
}

@OptIn(ExperimentalSerializationApi::class, ExperimentalSettingsApi::class)
class UserRepositoryImpl(
    private val log: Logger,
    private val encryptedSettings: Settings
) : UserRepository {

    override val authenticated: User?
        get() {
            val user = encryptedSettings.decodeValueOrNull(User.serializer(), USER_SETTING)
            log.d { "authenticated user $user" }
            return user
        }

    override fun authenticateUser(user: User) {
        log.d { "authenticate user $user" }
        encryptedSettings.encodeValue(User.serializer(), USER_SETTING, user)
    }

    override fun clearUser() {
        log.d { "clearing authenticated user" }
        encryptedSettings.remove(USER_SETTING)
    }

    companion object {
        private const val USER_SETTING = "user"
    }
}
