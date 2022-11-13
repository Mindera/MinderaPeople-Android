package com.mindera.people.network.models

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val id: Int? = null,
    val name: String? = null,
    val email: String? = null,
    val photo: String? = null,
    val slack: String? = null,
    val skype: String? = null,
    val phone: String? = null,
    val primary_role_id: Int? = null,
    val primary_seniority_id: Int? = null,
    val primary_skill_id: Int? = null,
    val primary_location_id: Int? = null,
    val country_id: Int? = null,
    val primary_ctc: Int? = null,
    val primary_rate: Int? = null,
    val primary_currency: String? = null,
    val primary_office_id: Int? = null,
)

interface UserDTOMapper {
    fun mapperToDomain(userDTO: UserDTO): UserDomain
    fun mapperToDTO(userDomain: UserDomain): UserDTO
}

class UserDTOMapperImpl : UserDTOMapper {

    override fun mapperToDomain(userDTO: UserDTO): UserDomain {
        return userDTO.run {
            UserDomain(
                id = id ?: 0,
                name = name ?: "",
                email = email ?: "",
                photo = photo ?: "",
                slack = slack ?: "",
                skype = skype ?: "",
                phone = phone ?: "",
                primaryRoleId = primary_role_id ?: 0,
                primarySeniorityId = primary_seniority_id ?: 0,
                primarySkillId = primary_skill_id ?: 0,
                primaryLocationId = primary_location_id ?: 0,
                countryId = country_id ?: 0,
                primaryCtc = primary_ctc ?: 0,
                primaryRate = primary_rate ?: 0,
                primaryCurrency = primary_currency ?: "",
                primaryOfficeId = primary_office_id ?: 0
            )
        }
    }

    override fun mapperToDTO(userDomain: UserDomain): UserDTO {
        return userDomain.run {
            UserDTO(
                id = id,
                name = name,
                email = email,
                photo = photo,
                slack = slack,
                skype = skype,
                phone = phone,
                primary_role_id = primaryRoleId,
                primary_seniority_id = primarySeniorityId,
                primary_skill_id = primarySkillId,
                primary_location_id = primaryLocationId,
                country_id = countryId,
                primary_ctc = primaryCtc,
                primary_rate = primaryRate,
                primary_currency = primaryCurrency,
                primary_office_id = primaryOfficeId
            )
        }
    }

}

data class UserDomain(
    val id: Int,
    val name: String,
    val email: String,
    val photo: String,
    val slack: String,
    val skype: String,
    val phone: String,
    val primaryRoleId: Int,
    val primarySeniorityId: Int,
    val primarySkillId: Int,
    val primaryLocationId: Int,
    val countryId: Int,
    val primaryCtc: Int,
    val primaryRate: Int,
    val primaryCurrency: String,
    val primaryOfficeId: Int,
)
