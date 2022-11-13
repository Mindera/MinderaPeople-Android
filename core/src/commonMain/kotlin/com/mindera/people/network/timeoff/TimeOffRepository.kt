package com.mindera.people.network.timeoff

import com.mindera.people.network.models.UserTimeOffDTOMapper
import com.mindera.people.network.models.UserTimeOffDomain
import com.mindera.people.network.service.TimeOffService

interface TimeOffRepository {
    suspend fun getUser(): UserTimeOffDomain
    suspend fun getTimeOffCalendar(id: String)
}

class TimeOffRepositoryImpl(
    private val timeOffService: TimeOffService,
    private val userTimeOffDTOMapper: UserTimeOffDTOMapper,
) : TimeOffRepository {

    override suspend fun getUser(): UserTimeOffDomain {
        return  userTimeOffDTOMapper.mapperToDomain(timeOffService.getUser())
    }

    override suspend fun getTimeOffCalendar(id: String) {
        return  timeOffService.getTimeOffCalendar(id)
    }
}