package com.mindera.people.timeoff

import com.mindera.people.*
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


class TimeOffRepositoryTests {
    @Mock
    private val service = mock(classOf<TimeOffService>())


    private lateinit var repository: TimeOffRepository

    @BeforeTest
    fun setup() {
        repository = TimeOffRepositoryImpl(service)
    }

    @Test
    fun `test getTimeOffEvents save a given UserTimeOff properly`() = runTest {
        given(service).coroutine { getTimeOffEvents(2) }.thenReturn(listOf(defaultApiPersonTimeOff))

        val result = repository.getTimeOffEvents(2)

        assertEquals(listOf(defaultPersonTimeOff), result)
    }

    @Test
    fun `test getUserTimeOffCalendar save a given TeamTimeOffList properly`() = runTest {
        given(service).coroutine { getUserTimeOffCalendar("2") }
            .thenReturn(defaultApiTeamTimeOffList)

        val result = repository.getUserTimeOffCalendar("2")

        assertEquals(defaultTeamTimeOffList.hashCode(), result.hashCode())
    }

    @Test
    fun `test getTeamTimeOffCalendar save a given TeamTimeOffList properly`() = runTest {
        given(service).coroutine { getTeamTimeOffCalendar("2") }
            .thenReturn(defaultApiTeamTimeOffList)

        val result = repository.getTeamTimeOffCalendar("2")

        assertEquals(defaultTeamTimeOffList.hashCode(), result.hashCode())
    }

    @Test
    fun `test getSummary save a given TeamTimeOffList properly`() = runTest {
        given(service).coroutine { getSummary(2) }.thenReturn(defaultApiSummaryList)

        val result = repository.getSummary(2)

        assertEquals(defaultSummary, result)
    }

    @Test
    fun `test deleteEvent save a given delete timeOff event properly`() = runTest {
        given(service).coroutine { deleteTimeOff(timeOffID = 2, personID = 2) }
            .thenReturn(defaultApiPersonTimeOff)

        val result = repository.deleteTimeOff(timeOffID = 2, personID = 2)

        assertEquals(defaultPersonTimeOff, result)
    }
}
