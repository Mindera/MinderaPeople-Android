package com.mindera.people.settings.office

import kotlinx.serialization.Serializable

@Serializable
data class Office(
    val id: Int? = null,
    val organizationId: Int? = null,
    val name: String? = null,
    val maxCapacity: Int? = null,
    val locationId: Int? = null
)
