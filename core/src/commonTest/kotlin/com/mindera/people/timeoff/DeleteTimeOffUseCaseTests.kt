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

class DeleteTimeOffUseCaseTests {
    @Mock
    private val repository = mock(classOf<TimeOffRepository>())

    private lateinit var useCase: DeleteTimeOffUseCase

    @BeforeTest
    fun setup() {
        useCase = DeleteTimeOffUseCase(repository)
    }

    @Test
    fun `when execute then returns expected Summary User`() = runTest {
        // Given
        given(repository).coroutine { deleteTimeOff(2,2) }
            .thenReturn(defaultPersonTimeOff)

        // When
        useCase(DeleteTimeOffRequest(timeOffID = 2, personID = 2)).test {
            assertEquals(UiState.Success(defaultPersonTimeOff), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { deleteTimeOff(2,2) }.wasInvoked(exactly = once)
    }
}