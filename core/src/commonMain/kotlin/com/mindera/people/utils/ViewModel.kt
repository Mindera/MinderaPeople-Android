package com.mindera.people.utils

import kotlinx.coroutines.CoroutineScope

expect open class ViewModel() {
    val scope: CoroutineScope
}
