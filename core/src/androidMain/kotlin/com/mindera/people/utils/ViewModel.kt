package com.mindera.people.utils

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual open class ViewModel : androidx.lifecycle.ViewModel() {
    actual open val mainDispatcher: CoroutineDispatcher = Dispatchers.Main
    actual open val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    actual val scope get() = viewModelScope
}
