package com.mindera.people.policy

import com.mindera.people.network.policy.GetPolicyUseCase
import com.mindera.people.network.policy.PolicyRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test

internal class GetPolicyUseCaseTests {
    private lateinit var repository: PolicyRepository
    private lateinit var useCase: GetPolicyUseCase

    @BeforeTest
    fun setup() {
        repository = mockk()
        useCase = GetPolicyUseCase(repository)
    }

    @Test
    fun `When execute then returns expected Policy`() {
        runBlocking {
            // Given
            coEvery { repository.getSummary("2") } returns mockk()

            // When
            useCase("2").first()

            // Then
            coVerify(exactly = 1) { repository.getSummary("2") }
        }
    }
}