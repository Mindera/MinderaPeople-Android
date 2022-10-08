package com.mindera.people.utils

import androidx.lifecycle.viewModelScope

actual open class ViewModel : androidx.lifecycle.ViewModel() {
    actual val scope get() = viewModelScope
}
