package com.mindera.people.settings.location

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val id: Int? = null,
    val organizationId: Int? = null,
    val name: String? = null,
    val country: String? = null,
    val countryId: Int? = null
)
