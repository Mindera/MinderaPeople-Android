package com.mindera.people.people

import com.mindera.people.network.models.UserAddressDTOMapper
import com.mindera.people.network.models.UserDTOMapper
import com.mindera.people.network.models.UserDomain
import com.mindera.people.network.people.GetPeopleUseCase
import com.mindera.people.network.people.PeopleRepository
import com.mindera.people.network.people.PeopleRepositoryImpl
import com.mindera.people.network.people.UpdatePeopleUseCase
import com.mindera.people.network.service.PeopleService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test

internal class UpdatePeopleUseCaseTests {
    private lateinit var repository: PeopleRepository
    private lateinit var useCase: UpdatePeopleUseCase

    @BeforeTest
    fun setup() {
        repository = mockk()
        useCase = UpdatePeopleUseCase(repository)
    }
    private val userDomain = UserDomain(
        id = 0,
        name = "",
        email = "",
        photo = "",
        slack = "",
        skype = "",
        phone = "",
        primaryRoleId = 0,
        primarySeniorityId = 0,
        primarySkillId = 0,
        primaryLocationId = 0,
        countryId = 0,
        primaryCtc = 0,
        primaryRate = 0,
        primaryCurrency = "",
        primaryOfficeId = 0
    )

    @Test
    fun `When execute then returns expected User`() {
        runBlocking {
            // Given
            coEvery { repository.updatePeopleById(userDomain) } returns Unit

            // When
            useCase(userDomain).first()

            // Then
            coVerify(exactly = 1) { repository.updatePeopleById(userDomain) }
        }
    }
}