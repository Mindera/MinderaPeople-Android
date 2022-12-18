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

class UpdatePersonUseCaseTests {
    @Mock
    private val repository = mock(classOf<PeopleRepository>())

    private lateinit var useCase: UpdatePersonUseCase

    @BeforeTest
    fun setup() {
        useCase = UpdatePersonUseCase(repository)
    }

    @Test
    fun `When execute then returns expected User`() = runTest {
        // Given
        given(repository).coroutine { updatePersonById(defaultPerson) }
            .thenReturn(Unit)

        // When
        useCase(defaultPerson).test {
            assertEquals(UiState.Success(Unit), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { updatePersonById(defaultPerson) }.wasInvoked(exactly = once)
    }
}
