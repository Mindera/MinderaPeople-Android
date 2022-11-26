package com.mindera.people.android.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

@OptIn(ExperimentalCoroutinesApi::class)
abstract class BaseTest<T: Any> {
    protected lateinit var testSubject: T

    /** the [testSubject] factory. */
    abstract fun createSubject(): T

    @Before
    open fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        setupDispatchers(StandardTestDispatcher())
        testSubject = createSubject()
    }

    @After
    open fun tearDown() {
        Dispatchers.resetMain()
    }

    private fun setupDispatchers(testDispatcher: CoroutineDispatcher) {
        DispatchersProvider.main = testDispatcher
        DispatchersProvider.io = testDispatcher
    }
}
