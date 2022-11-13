package com.mindera.people.policy

import com.mindera.people.network.models.PolicyDTO
import com.mindera.people.network.models.PolicyDTOMapper
import com.mindera.people.network.models.PolicyDTOMapperImpl
import com.mindera.people.network.models.PolicyDomain
import com.mindera.people.network.models.UserDTO
import com.mindera.people.network.models.UserDTOMapperImpl
import com.mindera.people.network.models.UserDomain
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class PolicyDTOMapperTests {

    private lateinit var mapper: PolicyDTOMapper


    @BeforeTest
    fun setUp() {
        mapper = PolicyDTOMapperImpl()
    }

    @Test
    fun `Given policyDTO when toUiModel then return expected result`() {
        // Given
        val policyDTO = PolicyDTO(
            id = 2,
            name = "name",
            allowance = true,
            description = "description",
            country_id = 2,
            contract_type = "contract",
            organization_id = 2,
            carryover = 2,
            team_acknoledgment = true,
            requires_approval = true,
            accrue = 2,
            notify = true,
            is_working = true,
            dashboard = true,
            colour = "colour",
            max_monthly_allowance = 2,
            allow_allowance_overflow = true,
            icon = "icon",
            is_shortcut = true,
            overflow_requires_approval = true,
            period_end_date = "period_end",
            period_start_date = "period_start"
        )

        val expected = PolicyDomain(
            id = 2,
            name = "name",
            isAllowance = true,
            description = "description",
            countryId = 2,
            contractType = "contract",
            organizationId = 2,
            carryover = 2,
            hasTeamAcknowledgement = true,
            isRequiresApproval = true,
            accrue = 2,
            notify = true,
            hasWorking = true,
            isDashboard = true,
            colour = "colour",
            maxMonthlyAllowance = 2,
            isAllowanceOverflow = true,
            icon = "icon",
            isShortcut = true,
            isOverflowRequiresApproval = true,
            periodEndDate = "period_end",
            periodStartDate = "period_start"
        )

        // When
        val actualValue = mapper.mapperToDomain(policyDTO)

        // Then
        assertEquals(expected, actualValue)
    }

    @Test
    fun `Given no userDTO when toUiModel then return expected result`() {
        // Given
        val policyDTO = PolicyDTO()

        val expected = PolicyDomain(
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


        // When
        val actualValue = mapper.mapperToDomain(policyDTO)

        // Then
        assertEquals(expected, actualValue)
    }
}