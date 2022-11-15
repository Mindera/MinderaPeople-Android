package com.mindera.people.timeoff

import com.mindera.people.people.PersonTimeOff

interface TimeOffRepository {
    suspend fun getUser(): PersonTimeOff
    suspend fun getTimeOffCalendar(id: String)
}

internal class TimeOffRepositoryImpl(private val service: TimeOffService) : TimeOffRepository {
    override suspend fun getUser(): PersonTimeOff = service.getUser().toPersonTimeOff()
    override suspend fun getTimeOffCalendar(id: String) = service.getTimeOffCalendar(id)
}
