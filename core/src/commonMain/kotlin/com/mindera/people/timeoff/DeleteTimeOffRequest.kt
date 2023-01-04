package com.mindera.people.timeoff

import kotlinx.serialization.Serializable

@Serializable
data class DeleteTimeOffRequest(
    val timeOffID: Int,
    val personID: Int
)