package com.mindera.people.settings.role

import com.mindera.people.defaultApiRole
import com.mindera.people.defaultRole
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
        given(service).coroutine { getRoles() }.thenReturn(listOf(defaultApiRole))

        val result = repository.getRoles()

        assertEquals(listOf(defaultRole), result)
    }

}
