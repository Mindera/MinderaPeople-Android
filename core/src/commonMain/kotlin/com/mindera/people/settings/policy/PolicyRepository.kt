package com.mindera.people.settings.policy

import com.mindera.people.timeoff.TimeOffService

interface PolicyRepository {
    suspend fun getSummary(id: String): Policy
}

internal class PolicyRepositoryImpl(private val timeOffService: TimeOffService) : PolicyRepository {
    override suspend fun getSummary(id: String): Policy = timeOffService.getSummary(id).toPolicy()
}
