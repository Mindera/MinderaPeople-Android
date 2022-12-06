package com.mindera.people.settings.skill

import com.mindera.people.BaseTest
import com.mindera.people.defaultApiPolicy
import com.mindera.people.defaultApiSkill
import com.mindera.people.defaultPolicy
import com.mindera.people.defaultSkill
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

class SkillRepositoryTests {
    @Mock
    private val service = mock(classOf<SkillService>())


    private lateinit var repository: SkillRepository

    @BeforeTest
    fun setup() {
        repository = SkillRepositoryImpl(service)
    }

    @Test
    fun `test getSummary save a given Policy properly`() = runTest {
        given(service).coroutine { getSkill() }.thenReturn(defaultApiSkill)

        val result = repository.getSkill()

        assertEquals(defaultSkill, result)
    }

}
