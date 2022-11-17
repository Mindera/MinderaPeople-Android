package com.mindera.people.timeoff

import com.mindera.people.BaseTest
import com.mindera.people.defaultApiPersonTimeOff
import com.mindera.people.defaultPersonTimeOff
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
    fun `test getTimeOffCalendar save a given Unit properly`() = runTest {
        given(service).coroutine { getTimeOffCalendar("2") }.thenReturn(Unit)

        val result = repository.getTimeOffCalendar("2")

        assertEquals(Unit, result)
    }
}
