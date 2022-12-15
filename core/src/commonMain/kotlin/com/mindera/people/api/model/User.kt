package com.mindera.people.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ApiUser(
    @SerialName("person") val user: User?,
)

@Serializable
data class User(
    @SerialName("id") val id: Int?,
    @SerialName("email") val email: String?,
    @SerialName("photo") val photo: String?,
    @SerialName("name") val name: String?
)
