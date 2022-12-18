package com.mindera.people.people

import app.cash.turbine.test
import com.mindera.people.defaultPersonAddress
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

class GetPeopleAddressUseCaseTests {
    @Mock private val repository = mock(classOf<PeopleRepository>())

    private lateinit var useCase: GetPersonAddressUseCase

    @BeforeTest
    fun setup() {
        useCase = GetPersonAddressUseCase(repository)
    }

    @Test
    fun `when execute then returns expected Person Address`() = runTest {
        // Given
        given(repository).coroutine { getPersonAddressById("2") }
            .thenReturn(defaultPersonAddress)

        // When
        useCase("2").test {
            assertEquals(UiState.Success(defaultPersonAddress), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getPersonAddressById("2") }.wasInvoked(exactly = once)
    }
}
