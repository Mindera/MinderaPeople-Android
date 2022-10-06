package com.mindera.people.user

import com.mindera.people.data.SettingsStorage
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.eq
import io.mockative.given
import io.mockative.mock
import io.mockative.once
import io.mockative.thenDoNothing
import io.mockative.verify
import kotlin.test.Test

class UserRepositoryTests {

    @Mock val storage = mock(classOf<SettingsStorage>())

    private val repository: UserRepository by lazy {
        UserRepositoryImpl(storage)
    }

    @Test
    fun `test UserRepository save a given User properly`() {
        val testUser = User(email = "user@mail.com")

        given(storage).invocation { user = testUser }.thenDoNothing()
        given(storage).invocation { user }.thenReturn(testUser)

        repository.authenticateUser(testUser)

        verify(storage).setter(storage::user)
            .with(eq(testUser))
            .wasInvoked(exactly = once)
    }
}
