package com.mindera.people.timeoff

import com.mindera.people.utils.UseCaseInOut

class GetTimeOffSummaryUseCase(
    private val repository: TimeOffRepository,
    override val block: suspend (id: Int) -> Summary = { repository.getSummary(it) }
) : UseCaseInOut<Int, Summary>()
