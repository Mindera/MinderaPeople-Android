package com.mindera.people.auth

import co.touchlab.kermit.Logger
import co.touchlab.kermit.LoggerConfig
import com.mindera.people.BaseTest
import com.mindera.people.data.toError
import com.mindera.people.defaultUser
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.thenDoNothing
import kotlin.test.Test
import kotlin.test.assertEquals

class GetAuthenticatedUserUseCaseTests : BaseTest<GetAuthenticatedUserUseCase>() {

    @Mock private val authRepository = mock(classOf<AuthRepository>())

    override fun createSubject() = GetAuthenticatedUserUseCase(
        authRepository = authRepository,
        log = Logger(LoggerConfig.default)
    )

    @Test
    fun `test SignInUseCase when authentication success`() {
        given(authRepository).invocation { authenticateUser(defaultUser) }.thenDoNothing()

        assertEquals(authRepository.authenticated, testSubject())

    }

    @Test
    fun `test SignInUseCase when authentication fails`() {
        assertEquals(authRepository.authenticated, testSubject())
    }
}
