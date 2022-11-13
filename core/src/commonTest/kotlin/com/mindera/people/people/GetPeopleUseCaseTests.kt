package com.mindera.people.people

import com.mindera.people.network.models.UserAddressDTOMapper
import com.mindera.people.network.models.UserDTOMapper
import com.mindera.people.network.models.UserDomain
import com.mindera.people.network.people.GetPeopleUseCase
import com.mindera.people.network.people.PeopleRepository
import com.mindera.people.network.people.PeopleRepositoryImpl
import com.mindera.people.network.service.PeopleService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test

internal class GetPeopleUseCaseTests {
    private lateinit var repository: PeopleRepository
    private lateinit var useCase: GetPeopleUseCase

    @BeforeTest
    fun setup() {
        repository = mockk()
        useCase = GetPeopleUseCase(repository)
    }

    @Test
    fun `When execute then returns expected User`() {
        runBlocking {
            // Given
            coEvery { repository.getPeopleById("2") } returns mockk()

            // When
            useCase("2").first()

            // Then
            coVerify(exactly = 1) { repository.getPeopleById("2") }
        }
    }
}