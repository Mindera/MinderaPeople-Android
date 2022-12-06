package com.mindera.people.settings.policy

import com.mindera.people.timeoff.TimeOffService

interface PolicyRepository {
    suspend fun getPolicy(): Policy
}

internal class PolicyRepositoryImpl(private val policyService: PolicyService) : PolicyRepository {
    override suspend fun getPolicy(): Policy = policyService.getPolicy().toPolicy()
}
