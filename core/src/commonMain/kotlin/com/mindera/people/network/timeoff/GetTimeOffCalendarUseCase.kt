package com.mindera.people.network.timeoff

import com.mindera.people.utils.UseCaseIn

class GetTimeOffCalendarUseCase(
    private val repository: TimeOffRepository,
    override val block: suspend (id: String) -> Unit = { repository.getTimeOffCalendar(it) },
) : UseCaseIn<String>()