package com.mindera.people.data

open class Error(open val cause: Throwable) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Error

        if (cause.message != other.cause.message) return false

        return true
    }

    override fun hashCode(): Int = cause.message.hashCode()
}

class ApiError(override val cause: Throwable): Error(cause)

fun Throwable.toError(): Error = Error(cause = this)
