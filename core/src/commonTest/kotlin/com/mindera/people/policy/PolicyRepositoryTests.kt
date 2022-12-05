package com.mindera.people.policy

import com.mindera.people.BaseTest
import com.mindera.people.defaultApiPolicy
import com.mindera.people.defaultPolicy
import com.mindera.people.settings.policy.PolicyRepository
import com.mindera.people.settings.policy.PolicyRepositoryImpl
import com.mindera.people.timeoff.TimeOffService
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PolicyRepositoryTests : BaseTest() {
    @Mock
    private val service = mock(classOf<TimeOffService>())


    private lateinit var repository: PolicyRepository

    @BeforeTest
    override fun setup() {
        super.setup()
        repository = PolicyRepositoryImpl(service)
    }

    @Test
    fun `test getSummary save a given Policy properly`() = runTest {
        given(service).coroutine { getSummary("2") }.thenReturn(defaultApiPolicy)

        val result = repository.getSummary("2")

        assertEquals(defaultPolicy, result)
    }

}
