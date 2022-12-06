package com.mindera.people.role

import com.mindera.people.BaseTest
import com.mindera.people.defaultApiPolicy
import com.mindera.people.defaultApiRole
import com.mindera.people.defaultPolicy
import com.mindera.people.defaultRole
import com.mindera.people.settings.policy.PolicyRepository
import com.mindera.people.settings.policy.PolicyRepositoryImpl
import com.mindera.people.settings.role.RoleRepository
import com.mindera.people.settings.role.RoleRepositoryImpl
import com.mindera.people.settings.role.RoleService
import com.mindera.people.timeoff.TimeOffService
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class RoleRepositoryTests {
    @Mock
    private val service = mock(classOf<RoleService>())


    private lateinit var repository: RoleRepository

    @BeforeTest
    fun setup() {
        repository = RoleRepositoryImpl(service)
    }

    @Test
    fun `test getRole save a given Policy properly`() = runTest {
        given(service).coroutine { getRole() }.thenReturn(defaultApiRole)

        val result = repository.getRole()

        assertEquals(defaultRole, result)
    }

}
