package com.mindera.people.auth

import co.touchlab.kermit.Logger
import com.mindera.people.utils.emailAddressRegex
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.Settings
import com.russhwolf.settings.serialization.decodeValueOrNull
import com.russhwolf.settings.serialization.encodeValue
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.builtins.serializer

interface AuthRepository {
    val authenticated: User?
    val token: String?
    fun authenticateUser(user: User)
    fun authenticateToken(token: String)
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

    override val token: String?
        get() {
            val token = encryptedSettings.decodeValueOrNull(String.serializer(), TOKEN_SETTING)
            log.d { "authenticated token  $token" }
            return token
        }

    override fun authenticateUser(user: User) {
        log.d { "authenticate user $user" }
        encryptedSettings.encodeValue(User.serializer(), USER_SETTING, user)
    }

    override fun authenticateToken(token: String) {
        log.d { "authenticate token $token" }
        encryptedSettings.encodeValue(String.serializer(), TOKEN_SETTING, token)
    }

    override fun clearUser() {
        log.d { "clearing authenticated user" }
        encryptedSettings.remove(USER_SETTING)
        encryptedSettings.remove(TOKEN_SETTING)
    }

    companion object {
        private const val USER_SETTING = "user"
        private const val TOKEN_SETTING = "token"
    }
}
