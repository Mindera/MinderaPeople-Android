package com.mindera.people.timeoff

import kotlinx.serialization.Serializable

@Serializable
data class Summary(
    val allowedAllowance: String = "0",
    val used: String = "0",
)
