package com.mindera.people.user

import co.touchlab.kermit.Logger
import co.touchlab.kermit.LoggerConfig
import com.russhwolf.settings.MapSettings
import kotlin.test.Test
import kotlin.test.assertEquals

class UserRepositoryTests {

    private val repository: UserRepository by lazy {
        UserRepositoryImpl(Logger(LoggerConfig.default), MapSettings())
    }

    @Test
    fun `test UserRepository save a given User properly`() {
        val user = User(email = "user@mail.com")
        repository.authenticateUser(user)
        assertEquals(user, repository.authenticated)
    }
}
