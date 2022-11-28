package com.mindera.people.people

import com.mindera.people.policy.Policy
import com.mindera.people.timeoff.TimeOffStatus
import com.mindera.people.timeoff.TimeOffTypes
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val id: Int,
    val email: String,
    val name: String?,
    val photo: String?,
    val slack: String?,
    val skype: String?,
    val phone: String?,
    val primaryRoleId: Int,
    val primarySeniorityId: Int,
    val primarySkillId: Int,
    val primaryLocationId: Int,
    val countryId: Int,
    val primaryCtc: Int,
    val primaryRate: Int,
    val primaryCurrency: String,
    val primaryOfficeId: Int
)

data class PersonAddress(
    val id: Int,
    val type: Type,
    val personId: Int,
    val street: String,
    val state: String,
    val postCode: String,
    val city: String
) {
    enum class Type {
        FISCAL, CURRENT, ANOTHER;

        companion object {
            fun mapperEnum(data: String?): Type = try {
                data?.let { valueOf(it) } ?: ANOTHER
            } catch (exception: IllegalArgumentException) {
                ANOTHER
            }
        }
    }
}

@Serializable
data class PersonAllocation(
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

@Serializable
data class TeamTimeOffList(
    val parent: Int,
    val data: List<TeamTimeOff>
)

@Serializable
data class TeamTimeOff(
    val id: Int,
    val client: String?,
    val parent: Int,
    val isOpen: Boolean,
    val data: PersonTimeOff
)

@Serializable
data class PersonTimeOff(
    val id: Int,
    val startDate: String,
    val endDate: String,
    val timeOffPolicyId: Int,
    val personId: Int,
    val details: String,
    val type: TimeOffTypes,
    val status: TimeOffStatus,
    val hours: String,
    val timeOffPolicy: Policy? = null,
    val modifiedBy: String,
    val modifiedAt: String,
)
