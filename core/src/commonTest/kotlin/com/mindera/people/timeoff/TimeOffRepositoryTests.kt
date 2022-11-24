package com.mindera.people.timeoff

import com.mindera.people.BaseTest
import com.mindera.people.defaultApiPersonTimeOff
import com.mindera.people.defaultApiTeamTimeOffList
import com.mindera.people.defaultPersonTimeOff
import com.mindera.people.defaultTeamTimeOffList
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


class TimeOffRepositoryTests : BaseTest() {
    @Mock
    private val service = mock(classOf<TimeOffService>())


    private lateinit var repository: TimeOffRepository

    @BeforeTest
    override fun setup() {
        super.setup()
        repository = TimeOffRepositoryImpl(service)
    }

    @Test
    fun `test getUser save a given UserTimeOff properly`() = runTest {
        given(service).coroutine { getUser() }.thenReturn(defaultApiPersonTimeOff)

        val result = repository.getUser()

        assertEquals(defaultPersonTimeOff, result)
    }

    @Test
    fun `test getUserTimeOffCalendar save a given TeamTimeOffList properly`() = runTest {
        given(service).coroutine { getUserTimeOffCalendar("2") }.thenReturn(defaultApiTeamTimeOffList)

        val result = repository.getUserTimeOffCalendar("2")

        assertEquals(defaultTeamTimeOffList.hashCode(), result.hashCode())
    }

    @Test
    fun `test getTeamTimeOffCalendar save a given TeamTimeOffList properly`() = runTest {
        given(service).coroutine { getTeamTimeOffCalendar("2") }.thenReturn(defaultApiTeamTimeOffList)

        val result = repository.getTeamTimeOffCalendar("2")

        assertEquals(defaultTeamTimeOffList.hashCode(), result.hashCode())
    }
}
