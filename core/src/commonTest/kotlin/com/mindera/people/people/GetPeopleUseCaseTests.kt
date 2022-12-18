package com.mindera.people.people

import app.cash.turbine.test
import com.mindera.people.defaultPerson
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

class GetPeopleUseCaseTests {
    @Mock private val repository = mock(classOf<PeopleRepository>())

    private lateinit var useCase: GetPersonUseCase

    @BeforeTest
    fun setup() {
        useCase = GetPersonUseCase(repository)
    }

    @Test
    fun `When execute then returns expected User`() = runTest {
        // Given
        given(repository).coroutine { getPersonById("2") }
            .thenReturn(defaultPerson)

        // When
        useCase("2").test {
            assertEquals(UiState.Success(defaultPerson), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getPersonById("2") }.wasInvoked(exactly = once)
    }
}
