package com.mindera.people.viewmodels

import app.cash.turbine.test
import com.mindera.people.BaseTest
import com.mindera.people.auth.AuthState
import com.mindera.people.auth.AuthViewModel
import com.mindera.people.user.User
import com.mindera.people.user.UserRepository
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AuthViewModelTests : BaseTest() {

    @Mock private val userRepository = mock(classOf<UserRepository>())

    private val viewModel by lazy { AuthViewModel(userRepository) }

    @Test
    fun `test ViewModel emits Error when authenticate fails`() = runTest {
        val error = Throwable("some crazy error!")
        val user = User(email = "test@mail.com", name = "Test User")

        given(userRepository).invocation { authenticateUser(user) }.thenThrow(error)

        viewModel.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // try authenticate [user]
            viewModel.authenticate(user)
            // check if error is emit to the ViewModel State
            assertEquals(AuthState.AuthError(error), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits Success when authenticate complete`() = runTest {
        val user = User(email = "test@mail.com", name = "Test User")

        given(userRepository).invocation { authenticateUser(user) }.thenReturn(Unit)

        viewModel.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // try authenticate [user]
            viewModel.authenticate(user)
            // check if success is emit to the ViewModel State
            assertEquals(AuthState.AuthSuccess(user), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits Error when clear fails`() = runTest {
        val error = Throwable("some crazy error!")

        given(userRepository).invocation { clearUser() }.thenThrow(error)

        viewModel.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // try cleat current user
            viewModel.clear()
            // check if error is emit to the ViewModel State
            assertEquals(AuthState.AuthError(error), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits UserCleared when clear complete`() = runTest {
        given(userRepository).invocation { clearUser() }.thenReturn(Unit)

        viewModel.state.test {
            // first state on ViewModel is Idle
            assertEquals(AuthState.Idle, awaitItem())
            // try cleat current user
            viewModel.clear()
            // check no events is emitted
            assertEquals(AuthState.UserCleared, awaitItem())
        }
    }
}
