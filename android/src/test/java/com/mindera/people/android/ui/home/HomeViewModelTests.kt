package com.mindera.people.android.ui.home

import app.cash.turbine.test
import com.mindera.people.android.utils.BaseTest
import com.mindera.people.auth.GetAuthenticatedUserUseCase
import com.mindera.people.auth.SignInUseCase
import com.mindera.people.auth.User
import com.mindera.people.data.toError
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeViewModelTests : BaseTest<HomeViewModel>() {

    private val getAuthenticatedUserUseCase = mockk<GetAuthenticatedUserUseCase>()
    private val signInUseCase = mockk<SignInUseCase>()

    override fun createSubject() = HomeViewModel(getAuthenticatedUserUseCase, signInUseCase)

    @Before
    override fun setup() {
        super.setup()
        every { getAuthenticatedUserUseCase() } returns null
    }

    @Test
    fun `test ViewModel emits AuthenticationState with no user when init`() = runTest {
        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(HomeState.Idle, awaitItem())
            // check ViewModel State emits no User authenticated
            assertEquals(HomeState.AuthenticationState(user = null, error = null), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits AuthenticationState with authenticated user when init`() = runTest {
        val user = User(email = "test@mail.com", name = "Test User")

        every { getAuthenticatedUserUseCase() } returns user

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(HomeState.Idle, awaitItem())
            // check ViewModel State emits no User authenticated
            assertEquals(HomeState.AuthenticationState(user = user, error = null), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits AuthenticationState with Error when setUser fails`() = runTest {
        val error = Throwable("some crazy error!").toError()
        val user = User(email = "test@mail.com", name = "Test User")

        every { signInUseCase(user) } returns Result.failure(error)

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(HomeState.Idle, awaitItem())
            // check ViewModel State emits no User authenticated
            assertEquals(HomeState.AuthenticationState(user = null, error = null), awaitItem())
            // try setUser
            testSubject.setUser(user)
            // check ViewModel State emits Loading
            assertEquals(HomeState.Loading, awaitItem())
            // check ViewModel State emits no User authenticated and the Error
            assertEquals(HomeState.AuthenticationState(user = null, error = error), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits AuthenticationState with User when setUser success`() = runTest {
        val user = User(email = "test@mail.com", name = "Test User")

        every { signInUseCase(user) } returns Result.success(user)

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(HomeState.Idle, awaitItem())
            // check ViewModel State emits no User authenticated
            assertEquals(HomeState.AuthenticationState(user = null, error = null), awaitItem())
            // try setUser
            testSubject.setUser(user)
            // check ViewModel State emits Loading
            assertEquals(HomeState.Loading, awaitItem())
            // check ViewModel State emits no User authenticated and the Error
            assertEquals(HomeState.AuthenticationState(user = user, error = null), awaitItem())
        }
    }
}
