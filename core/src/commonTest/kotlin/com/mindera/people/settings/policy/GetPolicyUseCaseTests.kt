package com.mindera.people.settings.policy

import app.cash.turbine.test
import com.mindera.people.defaultPolicy
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

class GetPolicyUseCaseTests {
    @Mock private val repository = mock(classOf<PolicyRepository>())

    private lateinit var useCase: GetPolicyUseCase

    @BeforeTest
    fun setup() {
        useCase = GetPolicyUseCase(repository)
    }

    @Test
    fun `when execute then returns expected Policy`() = runTest {
        // Given
        given(repository).coroutine { repository.getPolicies() }
            .thenReturn(listOf(defaultPolicy))

        // When
        useCase().test {
            assertEquals(UiState.Success(listOf(defaultPolicy)), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getPolicies() }.wasInvoked(exactly = once)
    }
}
