package com.mindera.people.network.models

import kotlinx.serialization.Serializable

@Serializable
data class UserAllocationDTO(
    val email: String?,
    val end_date: String?,
    val id: Int?,
    val location_id: Int?,
    val name: String?,
    val override_end_date: Int?,
    val percentage: Int?,
    val person_id: Int?,
    val photo: String?,
    val pnl_company_id: Int?,
    val primary_office_id: Int?,
    val role_id: Int?,
    val skill_id: Int?,
    val start_date: String?,
    val state: String?,
    val team_end_date: String?,
    val team_id: Int?,
)

interface UserAllocationDTOMapper {
    fun mapperToDomain(userAllocationDTO: UserAllocationDTO): UserAllocationDomain
}

class UserAllocationDTOMapperImpl : UserAllocationDTOMapper {

    override fun mapperToDomain(userAllocationDTO: UserAllocationDTO): UserAllocationDomain {
        return userAllocationDTO.run {
            UserAllocationDomain(
                email = email ?: "",
                endDate = end_date ?: "",
                id = id ?: 0,
                locationId = location_id ?: 0,
                name = name ?: "",
                overrideEndDate = override_end_date ?: 0,
                percentage = percentage ?: 0,
                personId = primary_office_id ?: 0,
                photo = photo ?: "",
                pnlCompanyId = pnl_company_id ?: 0,
                primaryOfficeId = primary_office_id ?: 0,
                roleId = role_id ?: 0,
                skillId = skill_id ?: 0,
                startDate = start_date ?: "",
                state = state ?: "",
                teamEndDate = team_end_date ?: "",
                teamId = team_id ?: 0,
            )
        }
    }

}

data class UserAllocationDomain(
    val email: String,
    val endDate: String,
    val id: Int,
    val locationId: Int,
    val name: String,
    val overrideEndDate: Int,
    val percentage: Int,
    val personId: Int,
    val photo: String,
    val pnlCompanyId: Int,
    val primaryOfficeId: Int,
    val roleId: Int,
    val skillId: Int,
    val startDate: String,
    val state: String,
    val teamEndDate: String,
    val teamId: Int,
)

