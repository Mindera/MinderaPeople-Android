package com.mindera.people.settings.office

import com.mindera.people.api.model.Office as ApiOffice

internal fun ApiOffice.toOffice(): Office =
    Office(
        id = this.id ?: 0,
        organizationId = this.organizationId ?: 0,
        name = this.name ?: "",
        maxCapacity = this.maxCapacity ?: 0,
        locationId = this.locationId ?: 0
    )
