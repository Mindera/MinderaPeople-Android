package com.mindera.people.people

import app.cash.turbine.test
import com.mindera.people.auth.AuthRepository
import com.mindera.people.defaultPerson
import com.mindera.people.defaultUser
import com.mindera.people.utils.UiState
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.once
import io.mockative.verify
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetMyUserUseCaseTests {
    @Mock private val repository = mock(classOf<PeopleRepository>())
    @Mock private val repositoryAuth = mock(classOf<AuthRepository>())

    private lateinit var useCase: GetMyUserUseCase

    @BeforeTest
    fun setup() {
        useCase = GetMyUserUseCase(repository, repositoryAuth)
    }

    @Test
    fun `When execute then returns expected User`() = runTest {
        // Given
        given(repositoryAuth).coroutine { repositoryAuth.authenticateUser(defaultUser) }
            .thenReturn(Unit)

        given(repository).coroutine { repository.getUser() }
            .thenReturn(defaultUser)

        // When
        useCase().test {
            assertEquals(UiState.Success(defaultUser), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getUser() }.wasInvoked(exactly = once)
    }
}
