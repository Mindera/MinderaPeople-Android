package com.mindera.people.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("id") val id: Int? = null,
    @SerialName("value") val value: String? = null
)
