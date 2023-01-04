package com.mindera.people.timeoff

import app.cash.turbine.test
import com.mindera.people.defaultPersonTimeOff
import com.mindera.people.defaultSummary
import com.mindera.people.utils.UiState
import io.mockative.*
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetTimeOffSummaryUseCaseTests {
    @Mock
    private val repository = mock(classOf<TimeOffRepository>())

    private lateinit var useCase: GetTimeOffSummaryUseCase

    @BeforeTest
    fun setup() {
        useCase = GetTimeOffSummaryUseCase(repository)
    }

    @Test
    fun `when execute then returns expected Summary User`() = runTest {
        // Given
        given(repository).coroutine { getSummary(2) }
            .thenReturn(defaultSummary)

        // When
        useCase(2).test {
            assertEquals(UiState.Success(defaultSummary), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getSummary(2) }.wasInvoked(exactly = once)
    }
}