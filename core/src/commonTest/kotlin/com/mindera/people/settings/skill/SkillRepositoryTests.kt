package com.mindera.people.settings.skill

import com.mindera.people.defaultApiSkill
import com.mindera.people.defaultSkill
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
        given(service).coroutine { getSkills() }.thenReturn(listOf(defaultApiSkill))

        val result = repository.getSkills()

        assertEquals(listOf(defaultSkill), result)
    }

}
