package com.mindera.people.viewmodels

import app.cash.turbine.test
import com.mindera.people.BaseTest
import com.mindera.people.home.HomeState
import com.mindera.people.home.HomeViewModel
import com.mindera.people.user.User
import com.mindera.people.user.UserRepository
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class HomeViewModelTests : BaseTest() {

    @Mock private val userRepository = mock(classOf<UserRepository>())

    private lateinit var viewModel: HomeViewModel

    @BeforeTest
    override fun setup() {
        super.setup()
        viewModel = HomeViewModel(userRepository)
        given(userRepository).invocation { authenticated }.thenReturn(value = null)
    }

    @Test
    fun `test ViewModel emits AuthenticationState with no user when init`() = runTest {
        given(userRepository).invocation { authenticated }.thenReturn(value = null)

        viewModel.state.test {
            // first state on ViewModel is Idle
            assertEquals(HomeState.Idle, awaitItem())
            // check ViewModel State emits no User authenticated
            assertEquals(HomeState.AuthenticationState(user = null, error = null), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits AuthenticationState with authenticated user when init`() = runTest {
        val user = User(email = "test@mail.com", name = "Test User")

        given(userRepository).invocation { authenticated }.thenReturn(user)

        viewModel.state.test {
            // first state on ViewModel is Idle
            assertEquals(HomeState.Idle, awaitItem())
            // check ViewModel State emits no User authenticated
            assertEquals(HomeState.AuthenticationState(user = user, error = null), awaitItem())
        }
    }

    @Test @Ignore
    fun `test ViewModel emits AuthenticationState with Error when setUser fails`() = runTest {
        val error = Throwable("some crazy error!")
        val user = User(email = "test@mail.com", name = "Test User")

        given(userRepository).invocation { authenticateUser(user) }.thenThrow(error)

        viewModel.state.test {
            // first state on ViewModel is Idle
            assertEquals(HomeState.Idle, awaitItem())
            // check ViewModel State emits no User authenticated
            assertEquals(HomeState.AuthenticationState(user = null, error = null), awaitItem())
            // try setUser
            viewModel.setUser(user)
            // check ViewModel State emits Loading
            assertEquals(HomeState.Loading, awaitItem())
            // check ViewModel State emits no User authenticated and the Error
            assertEquals(HomeState.AuthenticationState(user = null, error = error), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits AuthenticationState with User when setUser success`() = runTest {
        val user = User(email = "test@mail.com", name = "Test User")

        given(userRepository).invocation { authenticateUser(user) }.thenReturn(Unit)

        viewModel.state.test {
            // first state on ViewModel is Idle
            assertEquals(HomeState.Idle, awaitItem())
            // check ViewModel State emits no User authenticated
            assertEquals(HomeState.AuthenticationState(user = null, error = null), awaitItem())
            // try setUser
            viewModel.setUser(user)
            // check ViewModel State emits Loading
            assertEquals(HomeState.Loading, awaitItem())
            // check ViewModel State emits no User authenticated and the Error
            assertEquals(HomeState.AuthenticationState(user = user, error = null), awaitItem())
        }
    }
}
