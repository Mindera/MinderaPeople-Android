package com.mindera.people.data

/**
 * A proper Error class that has comparison support.
 * The [kotlin.Error] class doesn't implement equals() and hashCode().
 */
open class Error(override val cause: Throwable): Throwable(cause) {
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

fun Throwable.toError(): Error = when (this) {
    is Error -> this
    else -> Error(cause = this)
}
