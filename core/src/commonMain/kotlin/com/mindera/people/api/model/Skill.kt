package com.mindera.people.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Skill(
    @SerialName("id") val id: Int? = null,
    @SerialName("organization_id") val organizationId: Int? = null,
    @SerialName("skill") val skill: String? = null
)
