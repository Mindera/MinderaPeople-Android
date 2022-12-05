package com.mindera.people.settings.policy

import com.mindera.people.utils.UseCaseInOut

class GetPolicyUseCase(
    private val repository: PolicyRepository,
    override val block: suspend (id: String) -> Policy = { repository.getSummary(it) }
) : UseCaseInOut<String, Policy>()
