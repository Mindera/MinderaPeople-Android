package com.mindera.people.timeoff

import com.mindera.people.people.PersonTimeOff
import com.mindera.people.policy.toPolicy
import com.mindera.people.api.model.PersonTimeOff as ApiPersonTimeOff

internal fun ApiPersonTimeOff.toPersonTimeOff(): PersonTimeOff =
    PersonTimeOff(
        startDate = this.startDate ?: "",
        endDate = this.endDate ?: "",
        id = this.id ?: 0,
        timeOffPolicyId = this.timeoffPolicyId ?: 0,
        personId = this.personId ?: 0,
        details = this.details ?: "",
        type = this.type?.let { TimeOffTypes.mapperEnum(it) } ?: TimeOffTypes.ANOTHER,
        status = this.status?.let { TimeOffStatus.mapperEnum(it) } ?: TimeOffStatus.ANOTHER,
        hours = this.hours ?: "",
        timeOffPolicy = this.timeOffPolicy?.toPolicy(),
        modifiedBy = this.modifiedBy ?: "",
        modifiedAt = this.modifiedAt ?: ""
    )
