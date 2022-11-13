package com.mindera.people.people

import com.mindera.people.network.models.UserAddressDTO
import com.mindera.people.network.models.UserAddressDTOMapper
import com.mindera.people.network.models.UserAddressDomain
import com.mindera.people.network.models.UserAddressType
import com.mindera.people.network.models.UserDTO
import com.mindera.people.network.models.UserDTOMapper
import com.mindera.people.network.models.UserDomain
import com.mindera.people.network.people.PeopleRepository
import com.mindera.people.network.people.PeopleRepositoryImpl
import com.mindera.people.network.service.PeopleService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class PeopleRepositoryTests {

    private lateinit var peopleService: PeopleService
    private lateinit var userMapper: UserDTOMapper
    private lateinit var userAddressMapper: UserAddressDTOMapper
    private lateinit var repository: PeopleRepository

    @BeforeTest
    fun setup() {
        userMapper = mockk()
        userAddressMapper = mockk()
        peopleService = mockk()
        repository = PeopleRepositoryImpl(peopleService, userMapper, userAddressMapper)
    }

    private val userDTO = UserDTO()
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
    fun `test getPeopleById save a given User properly`() {
        runBlocking {
            // When
            coEvery { peopleService.getPeopleById("2") } returns userDTO

            coEvery { userMapper.mapperToDomain(userDTO) } returns userDomain

            val actual = repository.getPeopleById("2")

            // Then
            coVerify(exactly = 1) { peopleService.getPeopleById("2") }
            assertEquals(userDomain, actual)
        }
    }

    @Test
    fun `test updatePeopleById save a given Unit properly`() {
        val userDTO = UserDTO(
            id = 0,
            name = "",
            email = "",
            photo = "",
            slack = "",
            skype = "",
            phone = "",
            primary_role_id = 0,
            primary_seniority_id = 0,
            primary_skill_id = 0,
            primary_location_id = 0,
            country_id = 0,
            primary_ctc = 0,
            primary_rate = 0,
            primary_currency = "",
            primary_office_id = 0
        )
        runBlocking {
            // When
            coEvery { peopleService.updatePeopleById(userDTO) } returns Unit

            coEvery { userMapper.mapperToDTO(userDomain) } returns userDTO

            val actual = repository.updatePeopleById(userDomain)

            // Then
            coVerify(exactly = 1) { peopleService.updatePeopleById(userDTO) }
            assertEquals(Unit, actual)
        }
    }

    @Test
    fun `test getPeopleAddressById save a given UserAddress properly`() {
        val userAddressDTO = UserAddressDTO()
        val userAddressDomain = UserAddressDomain(
            id = 0,
            type = UserAddressType.ANOTHER,
            personId = 0,
            street = "",
            state = "",
            postCode = "",
            city = ""
        )

        runBlocking {
            // When
            coEvery { peopleService.getPeopleAddressById("2") } returns userAddressDTO

            coEvery { userAddressMapper.mapperToDomain(userAddressDTO) } returns userAddressDomain

            val actual = repository.getPeopleAddressById("2")

            // Then
            coVerify(exactly = 1) { peopleService.getPeopleAddressById("2") }
            assertEquals(userAddressDomain, actual)
        }
    }
}