package com.mindera.people.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

actual open class ViewModel {
    actual open val mainDispatcher = DispatchersProvider.main
    actual open val ioDispatcher = DispatchersProvider.main

    actual val scope get() = object : CoroutineScope {
        override val coroutineContext: CoroutineContext
            get() = mainDispatcher + SupervisorJob()
    }
}
