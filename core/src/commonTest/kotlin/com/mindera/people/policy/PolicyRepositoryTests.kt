package com.mindera.people.policy

import com.mindera.people.network.models.PolicyDTO
import com.mindera.people.network.models.PolicyDTOMapper
import com.mindera.people.network.models.PolicyDomain
import com.mindera.people.network.models.UserAddressDTO
import com.mindera.people.network.models.UserAddressDTOMapper
import com.mindera.people.network.models.UserAddressDomain
import com.mindera.people.network.models.UserAddressType
import com.mindera.people.network.models.UserDTO
import com.mindera.people.network.models.UserDTOMapper
import com.mindera.people.network.models.UserDomain
import com.mindera.people.network.people.PeopleRepositoryImpl
import com.mindera.people.network.policy.PolicyRepository
import com.mindera.people.network.policy.PolicyRepositoryImpl
import com.mindera.people.network.service.PeopleService
import com.mindera.people.network.service.TimeOffService
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class PolicyRepositoryTests {

    private lateinit var timeOffService: TimeOffService
    private lateinit var policyMapper: PolicyDTOMapper
    private lateinit var repository: PolicyRepository

    @BeforeTest
    fun setup() {
        policyMapper = mockk()
        timeOffService = mockk()
        repository = PolicyRepositoryImpl(timeOffService, policyMapper)
    }

    private val policyDTO = PolicyDTO()
    private val policyDomain = PolicyDomain(
        id = 0,
        name = "",
        isAllowance = false,
        description = "",
        countryId = 0,
        contractType = "",
        organizationId = 0,
        carryover = 0,
        hasTeamAcknowledgement = false,
        isRequiresApproval = false,
        accrue = 0,
        notify = false,
        hasWorking = false,
        isDashboard = false,
        colour = "",
        maxMonthlyAllowance = 0,
        isAllowanceOverflow = false,
        icon = "",
        isShortcut = false,
        isOverflowRequiresApproval = false,
        periodEndDate = "",
        periodStartDate = ""
    )

    @Test
    fun `test getSummary save a given Policy properly`() {
        runBlocking {
            // When
            coEvery { timeOffService.getSummary("2") } returns policyDTO

            coEvery { policyMapper.mapperToDomain(policyDTO) } returns policyDomain

            val actual = repository.getSummary("2")

            // Then
            coVerify(exactly = 1) { timeOffService.getSummary("2") }
            assertEquals(policyDomain, actual)
        }
    }
}