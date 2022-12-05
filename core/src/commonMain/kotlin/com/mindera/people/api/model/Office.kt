package com.mindera.people.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Office(
    @SerialName("id") val id: Int? = null,
    @SerialName("organization_id") val organizationId: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("max_capacity") val maxCapacity: Int? = null,
    @SerialName("location_id") val locationId: Int? = null
)
