package com.mindera.people.network.people

import com.mindera.people.network.models.UserAddressDTO
import com.mindera.people.network.models.UserAddressDTOMapper
import com.mindera.people.network.models.UserAddressDomain
import com.mindera.people.network.models.UserDTO
import com.mindera.people.network.models.UserDTOMapper
import com.mindera.people.network.models.UserDomain
import com.mindera.people.network.service.PeopleService

interface PeopleRepository {
    suspend fun getPeopleById(id: String): UserDomain
    suspend fun getPeopleAddressById(id: String): UserAddressDomain
    suspend fun updatePeopleById(user: UserDomain)
}

class PeopleRepositoryImpl(
    private val peopleService: PeopleService,
    private val userMapper: UserDTOMapper,
    private val userAddressMapper: UserAddressDTOMapper
) : PeopleRepository {

    override suspend fun getPeopleById(id: String): UserDomain {
        return userMapper.mapperToDomain(peopleService.getPeopleById(id))
    }

    override suspend fun getPeopleAddressById(id: String): UserAddressDomain {
        return userAddressMapper.mapperToDomain(peopleService.getPeopleAddressById(id))
    }

    override suspend fun updatePeopleById(user: UserDomain) {
        return peopleService.updatePeopleById(userMapper.mapperToDTO(user))
    }


}