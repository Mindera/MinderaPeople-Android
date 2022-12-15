package com.mindera.people.auth

import co.touchlab.kermit.Logger
import co.touchlab.kermit.LoggerConfig
import com.mindera.people.BaseTest
import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertEquals

class AuthRepositoryTests : BaseTest<AuthRepository>() {

    override fun createSubject() = AuthRepositoryImpl(
        log = Logger(LoggerConfig.default),
        encryptedSettings = MapSettings()
    )

    @Test
    fun `test AuthRepository save a given User properly`() {
        val user = User(id = 1, email = "user@mail.com", name = "user", photo = "photo")
        testSubject.authenticateUser(user)
        assertEquals(user, testSubject.authenticated)
    }

    @Test
    fun `test AuthRepository save a given Token properly`() {
        val token = "crazyToken!"
        testSubject.authenticateToken(token)
        assertEquals(token, testSubject.token)
    }
}
