package com.mindera.people.auth

import co.touchlab.kermit.Logger
import co.touchlab.kermit.LoggerConfig
import com.mindera.people.BaseTest
import com.mindera.people.data.toError
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.thenDoNothing
import kotlin.test.Test
import kotlin.test.assertEquals

class SignInUseCaseTests : BaseTest<SignInUseCase>() {

    @Mock private val authRepository = mock(classOf<AuthRepository>())

    override fun createSubject() = SignInUseCase(
        authRepository = authRepository,
        log = Logger(LoggerConfig.default)
    )

    @Test
    fun `test SignInUseCase when clearing success`() {
        val token = "fdsjfdsjfdsnflnfklmalfdslkmflaks"
        given(authRepository).invocation { authenticateToken(token) }.thenDoNothing()
        assertEquals(Result.success(Unit), testSubject(token))
    }

    @Test
    fun `test SignInUseCase when authentication fails`() {
        val throwable = Throwable("some crazy error!")
        val token = "fdsjfdsjfdsnflnfklmalfdslkmflaks"

        given(authRepository).invocation { authenticateToken(token) }.thenThrow(throwable)

        assertEquals(Result.failure(throwable.toError()), testSubject(token))
    }
}
