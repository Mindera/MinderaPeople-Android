package com.mindera.people.settings.role

import kotlinx.serialization.Serializable

@Serializable
data class Role(
    val id: Int? = null,
    val organizationId: Int? = null,
    val description: String? = null,
    val code: String? = null,
    val roleGroup: String? = null
)
