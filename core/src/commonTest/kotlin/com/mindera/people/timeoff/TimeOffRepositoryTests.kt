package com.mindera.people.timeoff

import com.mindera.people.network.models.PolicyDTO
import com.mindera.people.network.models.PolicyDTOMapper
import com.mindera.people.network.models.PolicyDomain
import com.mindera.people.network.models.TimeOffStatus
import com.mindera.people.network.models.TimeOffTypes
import com.mindera.people.network.models.UserAddressDTO
import com.mindera.people.network.models.UserAddressDTOMapper
import com.mindera.people.network.models.UserAddressDomain
import com.mindera.people.network.models.UserAddressType
import com.mindera.people.network.models.UserDTO
import com.mindera.people.network.models.UserDTOMapper
import com.mindera.people.network.models.UserDomain
import com.mindera.people.network.models.UserTimeOffDTO
import com.mindera.people.network.models.UserTimeOffDTOMapper
import com.mindera.people.network.models.UserTimeOffDomain
import com.mindera.people.network.people.PeopleRepositoryImpl
import com.mindera.people.network.policy.PolicyRepositoryImpl
import com.mindera.people.network.service.PeopleService
import com.mindera.people.network.service.TimeOffService
import com.mindera.people.network.timeoff.TimeOffRepository
import com.mindera.people.network.timeoff.TimeOffRepositoryImpl
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class TimeOffRepositoryTests {

    private lateinit var timeOffService: TimeOffService
    private lateinit var timeOffMapper: UserTimeOffDTOMapper
    private lateinit var repository: TimeOffRepository

    @BeforeTest
    fun setup() {
        timeOffMapper = mockk()
        timeOffService = mockk()
        repository = TimeOffRepositoryImpl(timeOffService, timeOffMapper)
    }

    private val userTimeOffDTO = UserTimeOffDTO()
    private val userTimeOffDomain = UserTimeOffDomain(
        startDate = "",
        endDate = "",
        id = 0,
        timeOffPolicyId = 0,
        personId = 0,
        details = "",
        type = TimeOffTypes.ANOTHER,
        status = TimeOffStatus.ANOTHER,
        hours = "",
        timeOffPolicy = null,
        modifiedBy = "",
        modifiedAt = ""
    )

    @Test
    fun `test getUser save a given UserTimeOff properly`() {
        runBlocking {
            // When
            coEvery { timeOffService.getUser() } returns userTimeOffDTO

            coEvery { timeOffMapper.mapperToDomain(userTimeOffDTO) } returns userTimeOffDomain

            val actual = repository.getUser()

            // Then
            coVerify(exactly = 1) { timeOffService.getUser() }
            assertEquals(userTimeOffDomain, actual)
        }
    }

    @Test
    fun `test getTimeOffCalendar save a given Unit properly`() {
        runBlocking {
            // When
            coEvery { timeOffService.getTimeOffCalendar("2") } returns Unit

            val actual = repository.getTimeOffCalendar("2")

            // Then
            coVerify(exactly = 1) { timeOffService.getTimeOffCalendar("2") }
            assertEquals(Unit, actual)
        }
    }
}