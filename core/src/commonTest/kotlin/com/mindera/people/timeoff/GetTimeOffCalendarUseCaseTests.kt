package com.mindera.people.timeoff

import app.cash.turbine.test
import com.mindera.people.BaseTest
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

class GetTimeOffCalendarUseCaseTests : BaseTest() {
    @Mock private val repository = mock(classOf<TimeOffRepository>())

    private lateinit var useCase: GetTimeOffCalendarUseCase

    @BeforeTest
    override fun setup() {
        super.setup()
        useCase = GetTimeOffCalendarUseCase(repository)
    }

    @Test
    fun `when execute then returns expected TimeOff User`() {
        runBlocking {
            // Given
            given(repository).coroutine { repository.getTimeOffCalendar("2") }
                .thenReturn(Unit)

            // When
            useCase("2").test {
                assertEquals(UiState.Success(Unit), awaitItem())
                awaitComplete()
            }

            // Then
            verify(repository).coroutine { getTimeOffCalendar("2") }.wasInvoked(exactly = once)
        }
    }
}