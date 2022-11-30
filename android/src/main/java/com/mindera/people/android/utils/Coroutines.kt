package com.mindera.people.android.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/** Util for Tests, it allows the possibilities to override the Dispatchers used on the App. */
object DispatchersProvider {
    var main: CoroutineDispatcher = Dispatchers.Main
        internal set

    var io: CoroutineDispatcher = Dispatchers.IO
        internal set
}
