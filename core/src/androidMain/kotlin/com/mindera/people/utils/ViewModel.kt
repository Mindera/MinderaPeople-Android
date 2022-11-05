package com.mindera.people.utils

import androidx.lifecycle.viewModelScope

actual open class ViewModel : androidx.lifecycle.ViewModel() {
    actual open val mainDispatcher = DispatchersProvider.main
    actual open val ioDispatcher = DispatchersProvider.io
    actual val scope get() = viewModelScope
}
