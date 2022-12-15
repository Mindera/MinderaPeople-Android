package com.mindera.people.viewmodels

import app.cash.turbine.test
import com.mindera.people.BaseTest
import com.mindera.people.data.toError
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.thenDoNothing
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

//class HomeViewModelTests : BaseTest<HomeViewModel>() {
//
//    @Mock private val userRepository = mock(classOf<UserRepository>())
//
//    override fun createSubject() = HomeViewModel(userRepository)
//
//    @BeforeTest
//    override fun setup() {
//        super.setup()
//        given(userRepository).invocation { authenticated }.thenReturn(value = null)
//    }
//
//    @Test
//    fun `test ViewModel emits AuthenticationState with no user when init`() = runTest {
//        given(userRepository).invocation { authenticated }.thenReturn(value = null)
//
//        testSubject.state.test {
//            // first state on ViewModel is Idle
//            assertEquals(HomeState.Idle, awaitItem())
//            // check ViewModel State emits no User authenticated
//            assertEquals(HomeState.AuthenticationState(user = null, error = null), awaitItem())
//        }
//    }
//
//    @Test
//    fun `test ViewModel emits AuthenticationState with authenticated user when init`() = runTest {
//        val user = User(email = "test@mail.com", token = "crazytoken!", name = "Test User")
//
//        given(userRepository).invocation { authenticated }.thenReturn(user)
//
//        testSubject.state.test {
//            // first state on ViewModel is Idle
//            assertEquals(HomeState.Idle, awaitItem())
//            // check ViewModel State emits no User authenticated
//            assertEquals(HomeState.AuthenticationState(user = user, error = null), awaitItem())
//        }
//    }
//
//    @Test
//    fun `test ViewModel emits AuthenticationState with Error when setUser fails`() = runTest {
//        val throwable = Throwable("some crazy error!")
//        val user = User(email = "test@mail.com", token = "crazytoken!", name = "Test User")
//
//        given(userRepository).invocation { authenticateUser(user) }.thenThrow(throwable)
//
//        testSubject.state.test {
//            // first state on ViewModel is Idle
//            assertEquals(HomeState.Idle, awaitItem())
//            // check ViewModel State emits no User authenticated
//            assertEquals(HomeState.AuthenticationState(user = null, error = null), awaitItem())
//            // try setUser
//            testSubject.setUser(user)
//            // check ViewModel State emits Loading
//            assertEquals(HomeState.Loading, awaitItem())
//            // check ViewModel State emits no User authenticated and the Error
//            assertEquals(HomeState.AuthenticationState(user = null, error = throwable.toError()), awaitItem())
//        }
//    }
//
//    @Test
//    fun `test ViewModel emits AuthenticationState with User when setUser success`() = runTest {
//        val user = User(email = "test@mail.com", token = "crazytoken!", name = "Test User")
//
//        given(userRepository).invocation { authenticateUser(user) }.thenDoNothing()
//
//        testSubject.state.test {
//            // first state on ViewModel is Idle
//            assertEquals(HomeState.Idle, awaitItem())
//            // check ViewModel State emits no User authenticated
//            assertEquals(HomeState.AuthenticationState(user = null, error = null), awaitItem())
//            // try setUser
//            testSubject.setUser(user)
//            // check ViewModel State emits Loading
//            assertEquals(HomeState.Loading, awaitItem())
//            // check ViewModel State emits no User authenticated and the Error
//            assertEquals(HomeState.AuthenticationState(user = user, error = null), awaitItem())
//        }
//    }
//}
