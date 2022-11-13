package com.mindera.people.network.models

import kotlinx.serialization.Serializable

@Serializable
data class UserTimeOffDTO(
    val start_date: String? = null,
    val end_date: String? = null,
    val id: Int? = null,
    val timeoff_policy_id: Int? = null,
    val person_id: Int? = null,
    val details: String? = null,
    val type: String? = null,
    val status: String? = null,
    val hours: String? = null,
    val timeOffPolicy: PolicyDTO? = null,
    val modified_by: String? = null,
    val modified_at: String? = null,
)

interface UserTimeOffDTOMapper {
    fun mapperToDomain(userTimeOffDTO: UserTimeOffDTO): UserTimeOffDomain
}

class UserTimeOffDTOMapperImpl(private val policyDTOMapper: PolicyDTOMapper) :
    UserTimeOffDTOMapper {

    override fun mapperToDomain(userTimeOffDTO: UserTimeOffDTO): UserTimeOffDomain {
        return userTimeOffDTO.run {
            UserTimeOffDomain(
                startDate = start_date ?: "",
                endDate = end_date ?: "",
                id = id ?: 0,
                timeOffPolicyId = timeoff_policy_id ?: 0,
                personId = person_id ?: 0,
                details = details ?: "",
                type = type?.let { TimeOffTypes.mapperEnum(it) }
                    ?: kotlin.run { TimeOffTypes.ANOTHER },
                status = status?.let { TimeOffStatus.mapperEnum(it) }
                    ?: kotlin.run { TimeOffStatus.ANOTHER },
                hours = hours ?: "",
                timeOffPolicy = timeOffPolicy?.let { policyDTOMapper.mapperToDomain(it) },
                modifiedBy = modified_by ?: "",
                modifiedAt = modified_at ?: ""
            )
        }
    }

}


data class UserTimeOffDomain(
    val startDate: String,
    val endDate: String,
    val id: Int,
    val timeOffPolicyId: Int,
    val personId: Int,
    val details: String,
    val type: TimeOffTypes,
    val status: TimeOffStatus,
    val hours: String,
    val timeOffPolicy: PolicyDomain? = null,
    val modifiedBy: String,
    val modifiedAt: String,
)

enum class TimeOffTypes {
    FULL_DAY,
    FIRST_PART_OF_DAY,
    SECOND_PART_OF_DAY,
    ANOTHER;

    companion object {
        fun mapperEnum(data: String): TimeOffTypes {
            return try {
                valueOf(data)
            } catch (exception: IllegalArgumentException) {
                ANOTHER
            }
        }
    }
}

enum class TimeOffStatus {
    APPROVED,
    ANOTHER;

    companion object {
        fun mapperEnum(data: String): TimeOffStatus {
            return try {
                valueOf(data)
            } catch (exception: IllegalArgumentException) {
                ANOTHER
            }
        }
    }
}
