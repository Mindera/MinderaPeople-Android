package com.mindera.people.settings.policy

interface PolicyRepository {
    suspend fun getPolicies(): List<Policy>
}

internal class PolicyRepositoryImpl(private val policyService: PolicyService) : PolicyRepository {
    override suspend fun getPolicies(): List<Policy> = policyService.getPolicies().toPolicies()
}
