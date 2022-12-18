package com.mindera.people.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Policy(
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("allowance") val allowance: Boolean? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("country_id") val countryId: Int? = null,
    @SerialName("contract_type") val contractType: String? = null,
    @SerialName("organization_id") val organizationId: Int? = null,
    @SerialName("carryover") val carryover: Int? = null,
    @SerialName("team_acknoledgment") val teamAcknoledgment: Boolean? = null,
    @SerialName("requires_approval") val requiresApproval: Boolean? = null,
    @SerialName("accrue") val accrue: Int? = null,
    @SerialName("notify") val notify: Boolean? = null,
    @SerialName("is_working") val isWorking: Boolean? = null,
    @SerialName("dashboard") val dashboard: Boolean? = null,
    @SerialName("colour") val colour: String? = null,
    @SerialName("max_monthly_allowance") val maxMonthlyAllowance: Int? = null,
    @SerialName("allow_allowance_overflow") val allowAllowanceOverflow: Boolean? = null,
    @SerialName("icon") val icon: String? = null,
    @SerialName("is_shortcut") val isShortcut: Boolean? = null,
    @SerialName("overflow_requires_approval") val overflowRequiresApproval: Boolean? = null,
    @SerialName("period_end_date") val periodEndDate: String? = null,
    @SerialName("period_start_date") val periodStartDate: String? = null
)
