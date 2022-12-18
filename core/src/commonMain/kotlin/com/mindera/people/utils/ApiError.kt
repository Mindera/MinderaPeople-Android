package com.mindera.people.utils

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.MissingFieldException


@OptIn(ExperimentalSerializationApi::class)
fun Throwable.userDescription(): String {
    return when (this) {
        is MissingFieldException -> {
            "Require field"
        }
        else -> {
            "An unknown error occurred."
        }
    }
}