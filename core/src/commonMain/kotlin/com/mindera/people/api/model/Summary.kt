package com.mindera.people.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SummaryList(
    @SerialName("id") val id: Int? = null,
    @SerialName("summary") val summaryList: List<Summary>? = null,
)

@Serializable
data class Summary(
    @SerialName("allowed_allowance") val allowedAllowance: Int? = null,
    @SerialName("used") val used: Int? = null,
)
