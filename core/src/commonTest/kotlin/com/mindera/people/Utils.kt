package com.mindera.people

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest

abstract class BaseTest<T: Any> {
    protected lateinit var subject: T

    abstract fun subjectFactory(): T

    @BeforeTest
    open fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        setupDispatchers(StandardTestDispatcher())
        subject = subjectFactory()
    }

    @AfterTest
    open fun tearDown() {
        Dispatchers.resetMain()
    }
}

expect fun setupDispatchers(testDispatcher: CoroutineDispatcher)
