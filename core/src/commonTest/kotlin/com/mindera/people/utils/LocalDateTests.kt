package com.mindera.people.utils

import kotlinx.datetime.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateTests {
    // today -> Clock.System.todayIn(TimeZone.currentSystemDefault())

    @Test
    fun `test withDayOfMonth`() {
        val currentDate = LocalDate(year = 2022, monthNumber = 12, dayOfMonth = 25)
        val expected = LocalDate(year = 2022, monthNumber = 12, dayOfMonth = 1)
        assertEquals(expected, currentDate.withDayOfMonth(dayOfMonth = 1))
    }

    @Test
    fun `test atEndOfMonth`() {
        val currentDate = LocalDate(year = 2022, monthNumber = 12, dayOfMonth = 25)
        val expected = LocalDate(year = 2022, monthNumber = 12, dayOfMonth = 31)
        assertEquals(expected, currentDate.atEndOfMonth)
    }

    @Test
    fun `test week day`() {
        val currentDate = LocalDate(year = 2022, monthNumber = 12, dayOfMonth = 25)
        assertEquals(52, currentDate.weekNumber)
    }
}
