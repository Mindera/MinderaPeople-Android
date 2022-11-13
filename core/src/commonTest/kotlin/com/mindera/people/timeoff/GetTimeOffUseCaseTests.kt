package com.mindera.people.timeoff

import com.mindera.people.network.models.UserAddressDTOMapper
import com.mindera.people.network.models.UserDTOMapper
import com.mindera.people.network.models.UserDomain
import com.mindera.people.network.people.GetPeopleUseCase
import com.mindera.people.network.people.PeopleRepository
import com.mindera.people.network.people.PeopleRepositoryImpl
import com.mindera.people.network.service.PeopleService
import com.mindera.people.network.timeoff.GetTimeOffUseCase
import com.mindera.people.network.timeoff.TimeOffRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test

internal class GetTimeOffUseCaseTests {
    private lateinit var repository: TimeOffRepository
    private lateinit var useCase: GetTimeOffUseCase

    @BeforeTest
    fun setup() {
        repository = mockk()
        useCase = GetTimeOffUseCase(repository)
    }

    @Test
    fun `When execute then returns expected TimeOff User`() {
        runBlocking {
            // Given
            coEvery { repository.getUser() } returns mockk()

            // When
            useCase().first()

            // Then
            coVerify(exactly = 1) { repository.getUser() }
        }
    }
}