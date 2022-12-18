package com.mindera.people.timeoff

import com.mindera.people.people.PersonTimeOff
import com.mindera.people.people.TeamTimeOffList
import com.mindera.people.settings.policy.Policy
import com.mindera.people.settings.policy.toPolicy

interface TimeOffRepository {
    suspend fun getUser(): PersonTimeOff
    suspend fun getUserTimeOffCalendar(id: String): TeamTimeOffList
    suspend fun getTeamTimeOffCalendar(id: String): TeamTimeOffList
    suspend fun getSummary(id: String): Policy
}

internal class TimeOffRepositoryImpl(private val service: TimeOffService) : TimeOffRepository {
    override suspend fun getUser(): PersonTimeOff = service.getUser().toPersonTimeOff()
    override suspend fun getUserTimeOffCalendar(id: String) = service.getUserTimeOffCalendar(id).toTeamTimeOffList()
    override suspend fun getTeamTimeOffCalendar(id: String) = service.getTeamTimeOffCalendar(id).toTeamTimeOffList()
    override suspend fun getSummary(id: String) = service.getSummary(id).toPolicy()
}
