package com.mindera.people

import com.mindera.people.utils.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher

actual fun setupDispatchers(testDispatcher: CoroutineDispatcher) {
    DispatchersProvider.main = testDispatcher
}
