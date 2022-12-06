package com.mindera.people.settings.skill

import app.cash.turbine.test
import com.mindera.people.defaultSkill
import com.mindera.people.utils.UiState
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.once
import io.mockative.verify
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetSkillUseCaseTests {
    @Mock private val repository = mock(classOf<SkillRepository>())

    private lateinit var useCase: GetSkillUseCase

    @BeforeTest
    fun setup() {
        useCase = GetSkillUseCase(repository)
    }

    @Test
    fun `when execute then returns expected Skill`() = runTest {
        // Given
        given(repository).coroutine { repository.getSkills() }
            .thenReturn(listOf(defaultSkill))

        // When
        useCase().test {
            assertEquals(UiState.Success(listOf(defaultSkill)), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getSkills() }.wasInvoked(exactly = once)
    }
}
