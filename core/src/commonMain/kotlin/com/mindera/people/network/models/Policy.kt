package com.mindera.people.network.models

import kotlinx.serialization.Serializable

@Serializable
data class PolicyDTO(
    val id: Int? = null,
    val name: String? = null,
    val allowance: Boolean? = null,
    val description: String? = null,
    val country_id: Int? = null,
    val contract_type: String? = null,
    val organization_id: Int? = null,
    val carryover: Int? = null,
    val team_acknoledgment: Boolean? = null,
    val requires_approval: Boolean? = null,
    val accrue: Int? = null,
    val notify: Boolean? = null,
    val is_working: Boolean? = null,
    val dashboard: Boolean? = null,
    val colour: String? = null,
    val max_monthly_allowance: Int? = null,
    val allow_allowance_overflow: Boolean? = null,
    val icon: String? = null,
    val is_shortcut: Boolean? = null,
    val overflow_requires_approval: Boolean? = null,
    val period_end_date: String? = null,
    val period_start_date: String? = null,
)

interface PolicyDTOMapper {
    fun mapperToDomain(policyDTO: PolicyDTO): PolicyDomain
}

class PolicyDTOMapperImpl : PolicyDTOMapper {

    override fun mapperToDomain(policyDTO: PolicyDTO): PolicyDomain {
        return policyDTO.run {
            PolicyDomain(
                id = id ?: 0,
                name = name ?: "",
                isAllowance = allow_allowance_overflow ?: false,
                description = description ?: "",
                countryId = country_id ?: 0,
                contractType = contract_type ?: "",
                organizationId = organization_id ?: 0,
                carryover = carryover ?: 0,
                hasTeamAcknowledgement = team_acknoledgment ?: false,
                isRequiresApproval = requires_approval ?: false,
                accrue = accrue ?: 0,
                notify = notify ?: false,
                hasWorking = is_working ?: false,
                isDashboard = dashboard ?: false,
                colour = colour ?: "",
                maxMonthlyAllowance = max_monthly_allowance ?: 0,
                isAllowanceOverflow = allow_allowance_overflow ?: false,
                icon = icon ?: "",
                isShortcut = is_shortcut ?: false,
                isOverflowRequiresApproval = overflow_requires_approval ?: false,
                periodEndDate = period_end_date ?: "",
                periodStartDate = period_start_date ?: ""
            )
        }
    }

}

data class PolicyDomain(
    val id: Int,
    val name: String,
    val isAllowance: Boolean,
    val description: String,
    val countryId: Int,
    val contractType: String,
    val organizationId: Int,
    val carryover: Int,
    val hasTeamAcknowledgement: Boolean,
    val isRequiresApproval: Boolean,
    val accrue: Int,
    val notify: Boolean,
    val hasWorking: Boolean,
    val isDashboard: Boolean,
    val colour: String,
    val maxMonthlyAllowance: Int,
    val isAllowanceOverflow: Boolean,
    val icon: String,
    val isShortcut: Boolean,
    val isOverflowRequiresApproval: Boolean,
    val periodEndDate: String,
    val periodStartDate: String,
)

