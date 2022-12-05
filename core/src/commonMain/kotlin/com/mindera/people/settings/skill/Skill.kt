package com.mindera.people.settings.skill

import kotlinx.serialization.Serializable

@Serializable
data class Skill(
    val id: Int? = null,
    val organizationId: Int? = null,
    val skill: String? = null
)
