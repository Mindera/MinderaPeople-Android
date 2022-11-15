package com.mindera.people.policy

import app.cash.turbine.test
import com.mindera.people.BaseTest
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

class GetPolicyUseCaseTests : BaseTest() {
    @Mock private val repository = mock(classOf<PolicyRepository>())

    private lateinit var useCase: GetPolicyUseCase

    @BeforeTest
    override fun setup() {
        super.setup()
        useCase = GetPolicyUseCase(repository)
    }

    @Test
    fun `when execute then returns expected Policy`() = runTest {
        // Given
        given(repository).coroutine { repository.getSummary("2") }
            .thenReturn(defaultPolicy)

        // When
        useCase("2").test {
            assertEquals(UiState.Success(defaultPolicy), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getSummary("2") }.wasInvoked(exactly = once)
    }
}
