package com.mindera.people.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Role(
    @SerialName("id") val id: Int? = null,
    @SerialName("organization_id") val organizationId: Int? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("code") val code: String? = null,
    @SerialName("role_group") val roleGroup: String? = null,

)
