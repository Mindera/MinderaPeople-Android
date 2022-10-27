package com.mindera.people.user

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String?,
    val name: String?
)
