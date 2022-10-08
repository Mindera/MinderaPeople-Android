package com.mindera.people.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

actual open class ViewModel {
    actual val scope get() = object : CoroutineScope {
        override val coroutineContext: CoroutineContext
            get() = MainDispatcher + SupervisorJob()
    }
}
