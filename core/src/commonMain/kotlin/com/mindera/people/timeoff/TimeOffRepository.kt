package com.mindera.people.timeoff

import com.mindera.people.people.PersonTimeOff
import com.mindera.people.people.TeamTimeOffList
import com.mindera.people.settings.policy.Policy
import com.mindera.people.settings.policy.toPolicy

interface TimeOffRepository {
    suspend fun getUser(id: Int): List<PersonTimeOff>
    suspend fun getUserTimeOffCalendar(id: String): TeamTimeOffList
    suspend fun getTeamTimeOffCalendar(id: String): TeamTimeOffList
    suspend fun getSummary(id: Int): Summary
}

internal class TimeOffRepositoryImpl(private val service: TimeOffService) : TimeOffRepository {
    override suspend fun getUser(id: Int) = service.getUser(id).toPersonTimeOffList()
    override suspend fun getUserTimeOffCalendar(id: String) = service.getUserTimeOffCalendar(id).toTeamTimeOffList()
    override suspend fun getTeamTimeOffCalendar(id: String) = service.getTeamTimeOffCalendar(id).toTeamTimeOffList()
    override suspend fun getSummary(id: Int) = service.getSummary(id).toSummary()
}
