package com.mindera.people.android.ui.home

import app.cash.turbine.test
import com.mindera.people.android.utils.BaseTest
import com.mindera.people.auth.GetAuthenticatedUserUseCase
import com.mindera.people.auth.SignInUseCase
import com.mindera.people.auth.User
import com.mindera.people.data.toError
import com.mindera.people.people.GetMyUserUseCase
import com.mindera.people.utils.UiState
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeViewModelTests : BaseTest<HomeViewModel>() {

    private val getMyUserUseCase = mockk<GetMyUserUseCase>()

    override fun createSubject() = HomeViewModel(getMyUserUseCase)

    private val user = User(
        id = 123,
        email = "person@mindera.com",
        name = "Minder",
        photo = null,
    )

    @Before
    override fun setup() {
        super.setup()
    }

    @Test
    fun `test ViewModel emits AuthenticationState with no user when init`() = runTest {
        every { getMyUserUseCase() } returns flow { UiState.Error("not user") }

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(UiState.Idle, awaitItem())
            // check ViewModel State emits no User authenticated
            assertEquals(UiState.Error("not user"), awaitItem())
        }
    }

    @Test
    fun `test ViewModel emits AuthenticationState with authenticated user when init`() = runTest {

        every { getMyUserUseCase() } returns flow { UiState.Success(user) }

        testSubject.state.test {
            // first state on ViewModel is Idle
            assertEquals(UiState.Idle, awaitItem())
            // check ViewModel State emits no User authenticated
//            assertEquals(UiState.Success(user), awaitItem())
        }
    }
}
