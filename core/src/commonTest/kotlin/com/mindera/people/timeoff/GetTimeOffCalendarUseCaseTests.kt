package com.mindera.people.timeoff

import app.cash.turbine.test
import com.mindera.people.BaseTest
import com.mindera.people.defaultTeamTimeOffList
import com.mindera.people.utils.UiState
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.once
import io.mockative.verify
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetTimeOffCalendarUseCaseTests {
    @Mock private val repository = mock(classOf<TimeOffRepository>())

    private lateinit var useCase: GetTimeOffCalendarUseCase

    @BeforeTest
    fun setup() {
        useCase = GetTimeOffCalendarUseCase(repository)
    }

    @Test
    fun `when execute then returns expected TimeOff Team`() {
        runBlocking {
            // Given
            given(repository).coroutine { repository.getTeamTimeOffCalendar("2") }
                .thenReturn(defaultTeamTimeOffList)

            // When
            useCase("2").test {
                assertEquals(UiState.Success(defaultTeamTimeOffList), awaitItem())
                awaitComplete()
            }

            // Then
            verify(repository).coroutine { getTeamTimeOffCalendar("2") }.wasInvoked(exactly = once)
        }
    }
}