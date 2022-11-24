package com.mindera.people.timeoff

import com.mindera.people.people.TeamTimeOffList
import com.mindera.people.utils.UseCaseInOut

class GetTimeOffCalendarUseCase(
    private val repository: TimeOffRepository,
    override val block: suspend (id: String) -> TeamTimeOffList = { repository.getTeamTimeOffCalendar(it) },
) : UseCaseInOut<String, TeamTimeOffList>()
