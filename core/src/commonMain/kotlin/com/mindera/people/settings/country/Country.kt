package com.mindera.people.settings.country

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val id: Int? = null,
    val value: String? = null
)
