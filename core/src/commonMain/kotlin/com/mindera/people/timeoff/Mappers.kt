package com.mindera.people.timeoff

import com.mindera.people.people.PersonTimeOff
import com.mindera.people.people.TeamTimeOff
import com.mindera.people.people.TeamTimeOffList
import com.mindera.people.settings.policy.toPolicy
import com.mindera.people.api.model.PersonTimeOff as ApiPersonTimeOff
import com.mindera.people.api.model.SummaryList as ApiSummaryList
import com.mindera.people.api.model.TeamTimeOff as ApiTeamTimeOff
import com.mindera.people.api.model.TeamTimeOffList as ApiTeamTimeOffList

internal fun List<ApiSummaryList>.toSummary(): Summary =
    first { it.id == 5279 }.summaryList?.first()?.run {
        Summary(
            allowedAllowance = allowedAllowance.toString(),
            used = used.toString()
        )
    } ?: kotlin.run { Summary() }


internal fun ApiTeamTimeOffList.toTeamTimeOffList(): TeamTimeOffList =
    TeamTimeOffList(
        parent = this.parent,
        data = this.data.map { it.toTeamTimeOff() }
    )

internal fun ApiTeamTimeOff.toTeamTimeOff(): TeamTimeOff =
    TeamTimeOff(
        id = this.id,
        client = this.client,
        parent = this.parent,
        isOpen = this.open,
        data = this.data.toPersonTimeOff()
    )

internal fun List<ApiPersonTimeOff>.toPersonTimeOffList(): List<PersonTimeOff> =
    map { it.toPersonTimeOff() }

internal fun ApiPersonTimeOff.toPersonTimeOff(): PersonTimeOff =
    PersonTimeOff(
        startDate = this.startDate ?: "",
        endDate = this.endDate ?: "",
        id = this.id ?: 0,
        timeOffPolicyId = this.timeoffPolicyId ?: 0,
        personId = this.personId ?: 0,
        details = this.details ?: "",
        type = TimeOffTypes.mapperEnum(type),
        status = TimeOffStatus.mapperEnum(status),
        hours = this.hours ?: 0,
        timeOffPolicy = this.timeOffPolicy?.toPolicy(),
    )
