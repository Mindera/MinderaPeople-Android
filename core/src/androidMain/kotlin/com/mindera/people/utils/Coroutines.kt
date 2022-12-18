package com.mindera.people.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/** Util for Tests, it allows the possibilities to override the Dispatchers used on the App. */
internal object DispatchersProvider {
    var main: CoroutineDispatcher = Dispatchers.Main
        internal set

    var io: CoroutineDispatcher = Dispatchers.IO
        internal set
}
