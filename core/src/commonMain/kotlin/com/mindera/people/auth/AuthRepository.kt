package com.mindera.people.auth

import co.touchlab.kermit.Logger
import com.mindera.people.utils.emailAddressRegex
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.serialization.decodeValueOrNull
import com.russhwolf.settings.serialization.encodeValue
import kotlinx.serialization.ExperimentalSerializationApi

interface AuthRepository {
    val authenticated: User?
    fun authenticateUser(user: User)
    fun clearUser()
}

@OptIn(ExperimentalSerializationApi::class, ExperimentalSettingsApi::class)
class AuthRepositoryImpl(
    private val log: Logger,
    private val encryptedSettings: Settings
) : AuthRepository {

    override val authenticated: User?
        get() {
            val user = encryptedSettings.decodeValueOrNull(User.serializer(), USER_SETTING)
            log.d { "authenticated user $user" }
            return user
        }

    override fun authenticateUser(user: User) {
        if (user.email.isNullOrBlank() || !emailAddressRegex.matches(user.email)) {
            val error = IllegalArgumentException("User $user is invalid!")
            log.d(error) { "error when try authenticateUser" }
            throw error
        }
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
