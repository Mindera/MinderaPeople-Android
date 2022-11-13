package com.mindera.people.network.policy

import com.mindera.people.network.models.PolicyDomain
import com.mindera.people.network.models.UserDomain
import com.mindera.people.utils.UseCaseInOut

class GetPolicyUseCase(
    private val repository: PolicyRepository,
    override val block: suspend (id: String) -> PolicyDomain = { repository.getSummary(it) },
) : UseCaseInOut<String, PolicyDomain>()