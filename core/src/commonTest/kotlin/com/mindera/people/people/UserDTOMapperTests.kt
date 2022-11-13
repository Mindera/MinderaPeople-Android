package com.mindera.people.people

import com.mindera.people.network.models.UserDTO
import com.mindera.people.network.models.UserDTOMapper
import com.mindera.people.network.models.UserDTOMapperImpl
import com.mindera.people.network.models.UserDomain
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class UserDTOMapperTests {

    private lateinit var mapper: UserDTOMapper

    @BeforeTest
    fun setUp() {
//        dateTransformer = mockk()
        mapper = UserDTOMapperImpl()
    }

    @Test
    fun `Given userDTO when toUiModel then return expected result`() {
        // Given
        val userDTO = UserDTO(
            id = 2,
            name = "name",
            email = "email",
            photo = "photo",
            slack = "slack",
            skype = "skype",
            phone = "phone",
            primary_role_id = 2,
            primary_seniority_id = 2,
            primary_skill_id = 2,
            primary_location_id = 2,
            country_id = 2,
            primary_ctc = 2,
            primary_rate = 2,
            primary_currency = "currency",
            primary_office_id = 2
        )

        val expected = UserDomain(
            id = 2,
            name = "name",
            email = "email",
            photo = "photo",
            slack = "slack",
            skype = "skype",
            phone = "phone",
            primaryRoleId = 2,
            primarySeniorityId = 2,
            primarySkillId = 2,
            primaryLocationId = 2,
            countryId = 2,
            primaryCtc = 2,
            primaryRate = 2,
            primaryCurrency = "currency",
            primaryOfficeId = 2
        )

//        every { dateTransformer.dateToDateString(buildDate("2019-12-11T12:00:00.000Z")) }
//            .returns("11-12-2019 at 12:00")
//        every { dateTransformer.dateToDateString(buildDate("2020-12-07T12:00:00.000Z")) }
//            .returns("07-12-2020 at 12:00")

        // When
        val actualValue = mapper.mapperToDomain(userDTO)

        // Then
        assertEquals(expected, actualValue)
    }

    @Test
    fun `Given no userDTO when toUiModel then return expected result`() {
        // Given
        val userDTO = UserDTO()

        val expected = UserDomain(
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

        // When
        val actualValue = mapper.mapperToDomain(userDTO)

        // Then
        assertEquals(expected, actualValue)
    }

    @Test
    fun `Given userDomain when toUiModel then return expected result`() {
        // Given
        val userDomain = UserDomain(
            id = 2,
            name = "name",
            email = "email",
            photo = "photo",
            slack = "slack",
            skype = "skype",
            phone = "phone",
            primaryRoleId = 2,
            primarySeniorityId = 2,
            primarySkillId = 2,
            primaryLocationId = 2,
            countryId = 2,
            primaryCtc = 2,
            primaryRate = 2,
            primaryCurrency = "currency",
            primaryOfficeId = 2
        )

        val expected = UserDTO(
            id = 2,
            name = "name",
            email = "email",
            photo = "photo",
            slack = "slack",
            skype = "skype",
            phone = "phone",
            primary_role_id = 2,
            primary_seniority_id = 2,
            primary_skill_id = 2,
            primary_location_id = 2,
            country_id = 2,
            primary_ctc = 2,
            primary_rate = 2,
            primary_currency = "currency",
            primary_office_id = 2
        )

//        every { dateTransformer.dateToDateString(buildDate("2019-12-11T12:00:00.000Z")) }
//            .returns("11-12-2019 at 12:00")
//        every { dateTransformer.dateToDateString(buildDate("2020-12-07T12:00:00.000Z")) }
//            .returns("07-12-2020 at 12:00")

        // When
        val actualValue = mapper.mapperToDTO(userDomain)

        // Then
        assertEquals(expected, actualValue)
    }

    @Test
    fun `Given no userDomain when toUiModel then return expected result`() {
        // Given
        val userDomain = UserDomain(
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

        val expected = UserDTO(
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

        // When
        val actualValue = mapper.mapperToDTO(userDomain)

        // Then
        assertEquals(expected, actualValue)
    }

}