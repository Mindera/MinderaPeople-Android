package com.mindera.people

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlin.test.AfterTest
import kotlin.test.BeforeTest

open class BaseTest {
    @BeforeTest
    open fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        setupDispatchers(StandardTestDispatcher())
    }

    @AfterTest
    open fun tearDown() {
        Dispatchers.resetMain()
    }
}

expect fun setupDispatchers(testDispatcher: CoroutineDispatcher)
