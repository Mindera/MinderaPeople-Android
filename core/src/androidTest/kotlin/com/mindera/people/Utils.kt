package com.mindera.people

import com.mindera.people.utils.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import java.util.*

actual fun setupDispatchers(testDispatcher: CoroutineDispatcher) {
    DispatchersProvider.main = testDispatcher
    DispatchersProvider.io = testDispatcher
}

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
