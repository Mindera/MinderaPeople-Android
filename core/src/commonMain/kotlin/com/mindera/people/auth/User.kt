package com.mindera.people.auth

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val email: String?,
    val photo: String?,
    val name: String?
)
