package com.mindera.people.settings.policy

import com.mindera.people.defaultApiPolicy
import com.mindera.people.defaultPolicy
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PolicyRepositoryTests {
    @Mock
    private val service = mock(classOf<PolicyService>())


    private lateinit var repository: PolicyRepository

    @BeforeTest
    fun setup() {
        repository = PolicyRepositoryImpl(service)
    }

    @Test
    fun `test getSummary save a given Policy properly`() = runTest {
        given(service).coroutine { getPolicies() }.thenReturn(listOf(defaultApiPolicy))

        val result = repository.getPolicies()

        assertEquals(listOf(defaultPolicy), result)
    }

}
