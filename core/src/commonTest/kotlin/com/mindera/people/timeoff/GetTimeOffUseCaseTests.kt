package com.mindera.people.timeoff

import app.cash.turbine.test
import com.mindera.people.defaultPersonTimeOff
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

class GetTimeOffUseCaseTests {
    @Mock private val repository = mock(classOf<TimeOffRepository>())

    private lateinit var useCase: GetTimeOffUseCase

    @BeforeTest
    fun setup() {
        useCase = GetTimeOffUseCase(repository)
    }

    @Test
    fun `when execute then returns expected TimeOff User`() = runTest {
        // Given
        given(repository).coroutine { getTimeOffEvents(2) }
            .thenReturn(listOf(defaultPersonTimeOff))

        // When
        useCase(2).test {
            assertEquals(UiState.Success(listOf(defaultPersonTimeOff)), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getTimeOffEvents(2) }.wasInvoked(exactly = once)
    }
}