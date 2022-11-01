package com.mindera.people.utils

import kotlinx.datetime.DatePeriod
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus

/**
 * Returns this date with another day of month.
 *
 * @throws IllegalArgumentException if the resulting date is invalid or exceeds the platform-specific boundary.
 */
fun LocalDate.withDayOfMonth(dayOfMonth: Int): LocalDate =
    LocalDate(this.year, this.month, dayOfMonth)

/**
 * The beginning of the next month.
 */
val LocalDate.nextMonth: LocalDate
    get() = withDayOfMonth(1).plus(1, DateTimeUnit.MONTH)

/**
 * The last day of month.
 */
val LocalDate.atEndOfMonth: LocalDate
    get() = nextMonth - DatePeriod(days = 1)

/**
 * The week number of this [LocalDate].
 */
val LocalDate.weekNumber: Int
    get() {
        val jan1 = LocalDate(year = this.year, monthNumber = 1, dayOfMonth = 1)
        val firstYearSunday = if (jan1.dayOfWeek == DayOfWeek.SUNDAY) jan1
                              else jan1 + DatePeriod(days = (7 - jan1.dayOfWeek.value))
        val weekSunday = if (this.dayOfWeek == DayOfWeek.SUNDAY) this
                         else this - DatePeriod(days = this.dayOfWeek.value)
        return (firstYearSunday.dayOfYear ..weekSunday.dayOfYear step 7).count()
    }

private val DayOfWeek.value: Int
    get() = when (this) {
        DayOfWeek.MONDAY -> 1
        DayOfWeek.TUESDAY -> 2
        DayOfWeek.WEDNESDAY -> 3
        DayOfWeek.THURSDAY -> 4
        DayOfWeek.FRIDAY -> 5
        DayOfWeek.SATURDAY -> 6
        DayOfWeek.SUNDAY -> 7
        else -> 0
    }
