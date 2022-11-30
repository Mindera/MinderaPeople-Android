package com.mindera.people

import java.util.Enumeration

/**
 * Extension function for converting a {@link List} to an {@link Enumeration}
 */
fun <T> List<T>.toEnumeration(): Enumeration<T> =
    object : Enumeration<T> {
        var count = 0

        override fun hasMoreElements(): Boolean = this.count < size

        override fun nextElement(): T {
            if (this.count < size) return get(this.count++)
            throw NoSuchElementException("List enumeration asked for more elements than present")
        }
    }
