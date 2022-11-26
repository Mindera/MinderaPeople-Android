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

class SignOutUseCaseTests : BaseTest<SignOutUseCase>() {

    @Mock private val authRepository = mock(classOf<AuthRepository>())

    override fun createSubject() = SignOutUseCase(
        authRepository = authRepository,
        log = Logger(LoggerConfig.default)
    )

    @Test
    fun `test SignOutUseCase when clearing success`() {
        given(authRepository).invocation { clearUser() }.thenDoNothing()
        assertEquals(Result.success(Unit), testSubject())
    }

    @Test
    fun `test SignOutUseCase when authentication fails`() {
        val throwable = Throwable("some crazy error!")

        given(authRepository).invocation { clearUser() }.thenThrow(throwable)

        assertEquals(Result.failure(throwable.toError()), testSubject())
    }
}
