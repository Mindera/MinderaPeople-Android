package com.mindera.people.auth

import co.touchlab.kermit.Logger
import co.touchlab.kermit.LoggerConfig
import com.mindera.people.BaseTest
import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertEquals

class UserRepositoryTests : BaseTest<AuthRepository>() {

    override fun createSubject() = AuthRepositoryImpl(
        log = Logger(LoggerConfig.default),
        encryptedSettings = MapSettings()
    )

    @Test
    fun `test UserRepository save a given User properly`() {
        val user = User(email = "user@mail.com", name = "user")
        testSubject.authenticateUser(user)
        assertEquals(user, testSubject.authenticated)
    }
}
