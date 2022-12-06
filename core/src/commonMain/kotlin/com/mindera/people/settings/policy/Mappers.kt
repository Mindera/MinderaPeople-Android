package com.mindera.people.settings.policy

import com.mindera.people.api.model.Policy as ApiPolicy

internal fun List<ApiPolicy>.toPolicies(): List<Policy> = this.map { it.toPolicy() }

internal fun ApiPolicy.toPolicy(): Policy =
    Policy(
        id = this.id ?: 0,
        name = this.name ?: "",
        isAllowance = this.allowAllowanceOverflow ?: false,
        description = this.description ?: "",
        countryId = this.countryId ?: 0,
        contractType = this.contractType ?: "",
        organizationId = this.organizationId ?: 0,
        carryover = this.carryover ?: 0,
        hasTeamAcknowledgement = this.teamAcknoledgment ?: false,
        isRequiresApproval = this.requiresApproval ?: false,
        accrue = this.accrue ?: 0,
        notify = this.notify ?: false,
        hasWorking = this.isWorking ?: false,
        isDashboard = this.dashboard ?: false,
        colour = this.colour ?: "",
        maxMonthlyAllowance = this.maxMonthlyAllowance ?: 0,
        isAllowanceOverflow = this.allowAllowanceOverflow ?: false,
        icon = this.icon ?: "",
        isShortcut = this.isShortcut ?: false,
        isOverflowRequiresApproval = this.overflowRequiresApproval ?: false,
        periodEndDate = this.periodEndDate ?: "",
        periodStartDate = this.periodStartDate ?: ""
    )
