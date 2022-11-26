package com.mindera.people.auth

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val email: String,
    val name: String?
)
