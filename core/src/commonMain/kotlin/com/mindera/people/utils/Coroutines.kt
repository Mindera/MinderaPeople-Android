package com.mindera.people.utils

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun CoroutineScope.safeLaunch(block: suspend CoroutineScope.() -> Unit): Job =
    launch(context = scopeExceptionHandler(this::class.simpleName ?: "safeLaunch"),
        block = block)

fun <T> Flow<T>.safeLaunchIn(scope: CoroutineScope): Job =
    scope.launch(context = scopeExceptionHandler(this::class.simpleName ?: "safeLaunchIn"),
        block = { collect() })

internal fun scopeExceptionHandler(tag: String): CoroutineExceptionHandler =
    CoroutineExceptionHandler { _, throwable ->
        Logger.e(tag, throwable)
    }
