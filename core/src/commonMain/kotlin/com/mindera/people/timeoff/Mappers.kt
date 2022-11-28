package com.mindera.people.timeoff

import com.mindera.people.people.PersonTimeOff
import com.mindera.people.people.TeamTimeOff
import com.mindera.people.people.TeamTimeOffList
import com.mindera.people.policy.toPolicy
import com.mindera.people.api.model.PersonTimeOff as ApiPersonTimeOff
import com.mindera.people.api.model.TeamTimeOffList as ApiTeamTimeOffList
import com.mindera.people.api.model.TeamTimeOff as ApiTeamTimeOff


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
        hours = this.hours ?: "",
        timeOffPolicy = this.timeOffPolicy?.toPolicy(),
        modifiedBy = this.modifiedBy ?: "",
        modifiedAt = this.modifiedAt ?: ""
    )
