package com.mindera.people.settings.policy

import kotlinx.serialization.Serializable

@Serializable
data class Policy(
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
    val periodStartDate: String
)
