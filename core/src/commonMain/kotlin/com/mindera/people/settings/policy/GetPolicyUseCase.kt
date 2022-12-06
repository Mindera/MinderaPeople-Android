package com.mindera.people.settings.policy

import com.mindera.people.utils.UseCaseOut

class GetPolicyUseCase(
    private val repository: PolicyRepository,
    override val block: suspend () -> Policy = { repository.getPolicy() }
) : UseCaseOut<Policy>()
