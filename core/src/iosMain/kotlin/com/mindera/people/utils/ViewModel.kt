package com.mindera.people.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

actual open class ViewModel {
    actual open val mainDispatcher: CoroutineDispatcher = MainDispatcher
    actual open val ioDispatcher: CoroutineDispatcher = MainDispatcher

    actual val scope get() = object : CoroutineScope {
        override val coroutineContext: CoroutineContext
            get() = mainDispatcher + SupervisorJob()
    }
}
