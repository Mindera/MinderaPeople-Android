package com.mindera.people.android.ui.auth

import app.cash.turbine.test
import com.mindera.people.android.utils.BaseTest
import com.mindera.people.auth.SignInUseCase
import com.mindera.people.auth.SignOutUseCase
import com.mindera.people.auth.User
import com.mindera.people.data.toError
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AuthViewModelTests : BaseTest<AuthViewModel>() {

    private val signInUseCase = mockk<SignInUseCase>()
    private val signOutUseCase = mockk<SignOutUseCase>()

    override fun createSubject() = AuthViewModel(signInUseCase, signOutUseCase)

    @Test
    fun `test ViewModel emits Error when authenticate fails`() = runTest {
        val error = Throwable("some crazy error!").toError()
        val user = User(email = "test@mail.com", name = "Test User")

        every { signInUseCase(user) } returns Result.failure(error)

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // try authenticate [user]
            testSubject.authenticate(user)
            // check ViewModel State emits Loading
            assertEquals(AuthState.Loading, awaitItem())
            // check if error is emit to the ViewModel State
            assertEquals(AuthState.AuthError(error), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits Success when authenticate complete`() = runTest {
        val user = User(email = "test@mail.com", name = "Test User")

        every { signInUseCase(user) } returns Result.success(user)

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // try authenticate [user]
            testSubject.authenticate(user)
            // check ViewModel State emits Loading
            assertEquals(AuthState.Loading, awaitItem())
            // check if success is emit to the ViewModel State
            assertEquals(AuthState.AuthSuccess(user), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits Error when clear fails`() = runTest {
        val error = Throwable("some crazy error!").toError()

        every { signOutUseCase() } returns Result.failure(error)

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // try cleat current user
            testSubject.clear()
            // check if error is emit to the ViewModel State
            assertEquals(AuthState.AuthError(error), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits UserCleared when clear complete`() = runTest {
        every { signOutUseCase() } returns Result.success(Unit)

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // try cleat current user
            testSubject.clear()
            // check no events is emitted
            assertEquals(AuthState.UserCleared, awaitItem())
        }
    }
}
