package com.mindera.people.network.policy

import com.mindera.people.network.models.PolicyDTOMapper
import com.mindera.people.network.models.PolicyDomain
import com.mindera.people.network.models.UserAddressDTO
import com.mindera.people.network.models.UserAddressDTOMapper
import com.mindera.people.network.models.UserAddressDomain
import com.mindera.people.network.models.UserDTO
import com.mindera.people.network.models.UserDTOMapper
import com.mindera.people.network.models.UserDomain
import com.mindera.people.network.service.PeopleService
import com.mindera.people.network.service.TimeOffService

interface PolicyRepository {
    suspend fun getSummary(id: String): PolicyDomain
}

class PolicyRepositoryImpl(
    private val timeOffService: TimeOffService,
    private val policyDTOMapper: PolicyDTOMapper,
) : PolicyRepository {

    override suspend fun getSummary(id: String): PolicyDomain {
        return  policyDTOMapper.mapperToDomain(timeOffService.getSummary(id))
    }
}