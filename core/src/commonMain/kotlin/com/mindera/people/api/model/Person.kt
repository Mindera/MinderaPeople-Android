package com.mindera.people.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("email") val email: String? = null,
    @SerialName("photo") val photo: String? = null,
    @SerialName("slack") val slack: String? = null,
    @SerialName("skype") val skype: String? = null,
    @SerialName("phone") val phone: String? = null,
    @SerialName("primary_role_id") val primaryRoleId: Int? = null,
    @SerialName("primary_seniority_id") val primarySeniorityId: Int? = null,
    @SerialName("primary_skill_id") val primarySkillId: Int? = null,
    @SerialName("primary_location_id") val primaryLocationId: Int? = null,
    @SerialName("country_id") val countryId: Int? = null,
    @SerialName("primary_ctc") val primaryCtc: Int? = null,
    @SerialName("primary_rate") val primaryRate: Int? = null,
    @SerialName("primary_currency") val primaryCurrency: String? = null,
    @SerialName("primary_office_id") val primaryOfficeId: Int? = null
)

@Serializable
data class PersonAddress(
    @SerialName("id") val id: Int? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("personId") val personId: Int? = null,
    @SerialName("street") val street: String? = null,
    @SerialName("state") val state: String? = null,
    @SerialName("post_code") val postCode: String? = null,
    @SerialName("city") val city: String? = null
)

@Serializable
data class PersonAllocation(
    @SerialName("id") val id: Int?,
    @SerialName("email") val email: String?,
    @SerialName("end_date") val endDate: String?,
    @SerialName("location_id") val locationId: Int?,
    @SerialName("name") val name: String?,
    @SerialName("override_end_date") val overrideEndDate: Int?,
    @SerialName("percentage") val percentage: Int?,
    @SerialName("person_id") val personId: Int?,
    @SerialName("photo") val photo: String?,
    @SerialName("pnl_company_id") val pnlCompanyId: Int?,
    @SerialName("primary_office_id") val primaryOfficeId: Int?,
    @SerialName("role_id") val roleId: Int?,
    @SerialName("skill_id") val skillId: Int?,
    @SerialName("start_date") val startDate: String?,
    @SerialName("state") val state: String?,
    @SerialName("team_end_date") val teamEndDate: String?,
    @SerialName("team_id") val teamId: Int?
)

@Serializable
data class TeamTimeOffList(
    @SerialName("parent") val parent: Int,
    @SerialName("data") val data: List<TeamTimeOff>
)

@Serializable
data class TeamTimeOff(
    @SerialName("id") val id: Int,
    @SerialName("client") val client: String?,
    @SerialName("parent") val parent: Int,
    @SerialName("open") val open: Boolean,
    @SerialName("data") val data: PersonTimeOff
)

@Serializable
data class PersonTimeOff(
    @SerialName("id") val id: Int? = null,
    @SerialName("start_date") val startDate: String? = null,
    @SerialName("end_date") val endDate: String? = null,
    @SerialName("timeoff_policy_id") val timeoffPolicyId: Int? = null,
    @SerialName("person_id") val personId: Int? = null,
    @SerialName("details") val details: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("status") val status: String? = null,
    @SerialName("hours") val hours: Int? = null,
    @SerialName("timeOffPolicy") val timeOffPolicy: Policy? = null,
    @SerialName("modified_by") val modifiedBy: String? = null,
    @SerialName("modified_at") val modifiedAt: String? = null
)
