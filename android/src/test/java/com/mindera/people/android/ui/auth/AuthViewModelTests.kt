package com.mindera.people.android.ui.auth

import app.cash.turbine.test
import com.mindera.people.android.navigation.Navigator
import com.mindera.people.android.utils.BaseTest
import com.mindera.people.auth.SignInUseCase
import com.mindera.people.auth.SignOutUseCase
import com.mindera.people.auth.User
import com.mindera.people.data.toError
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class AuthViewModelTests : BaseTest<AuthViewModel>() {

    private val signInUseCase = mockk<SignInUseCase>()
    private val navigator = mockk<Navigator>() {
        every { navigateToHome() } returns Unit
    }

    override fun createSubject() = AuthViewModel(navigator = navigator, signInUseCase = signInUseCase)

    @Test
    fun `test ViewModel emits Error when authentication validation fails`() = runTest {
        val error = Throwable("some crazy error!").toError()
        val token = "crazyToken!"

        every { signInUseCase(token) } returns Result.failure(error)

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // try authenticate [token]
            testSubject.validateAuthentication(token)
            // check if error is emit to the ViewModel State
            assertEquals(AuthState.AuthError(error), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits Success when authentication validation completes`() = runTest {
        val token = "crazyToken!"

        every { signInUseCase(token) } returns Result.success(Unit)

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // try authenticate [token]
            testSubject.validateAuthentication(token)
            // check if success is emit to the ViewModel State
            assertEquals(AuthState.AuthSuccess, awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits Loading when authentication is started`() = runTest {
        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // then start authentication is called
            testSubject.startAuthentication()
            // check ViewModel State emits Loading
            assertEquals(AuthState.Loading, awaitItem())

        }
    }
}
