package com.mindera.people.android.utils

import co.touchlab.kermit.Logger
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

@OptIn(ExperimentalCoroutinesApi::class)
abstract class BaseTest<T: Any> {
    protected val logger = mockk<Logger>(relaxed = true)

    protected lateinit var testSubject: T

    /** the [testSubject] factory. */
    abstract fun createSubject(): T

    @Before
    open fun setup() {
        startKoin {
            modules(
                module {
                    factory { this@BaseTest.logger }
                }
            )
        }
        Dispatchers.setMain(StandardTestDispatcher())
        setupDispatchers(StandardTestDispatcher())
        testSubject = createSubject()
    }

    @After
    open fun tearDown() {
        Dispatchers.resetMain()
        stopKoin()
    }

    private fun setupDispatchers(testDispatcher: CoroutineDispatcher) {
        DispatchersProvider.main = testDispatcher
        DispatchersProvider.io = testDispatcher
    }
}
