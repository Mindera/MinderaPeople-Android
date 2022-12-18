package com.mindera.people.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

actual open class ViewModel actual constructor() {
    actual open val mainDispatcher: CoroutineDispatcher
        get() = TODO("Not yet implemented")
    actual open val ioDispatcher: CoroutineDispatcher
        get() = TODO("Not yet implemented")
    actual val scope: CoroutineScope
        get() = TODO("Not yet implemented")
}