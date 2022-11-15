package com.mindera.people.timeoff

//import com.mindera.people.network.models.PolicyDTO
//import com.mindera.people.network.models.PolicyDTOMapper
//import com.mindera.people.network.models.PolicyDomain
//import com.mindera.people.network.models.TimeOffStatus
//import com.mindera.people.network.models.TimeOffTypes
//import com.mindera.people.network.models.UserTimeOffDTO
//import com.mindera.people.network.models.UserTimeOffDTOMapper
//import com.mindera.people.network.models.UserTimeOffDTOMapperImpl
//import com.mindera.people.network.models.UserTimeOffDomain
//import io.mockk.every
//import io.mockk.mockk
//import kotlin.test.BeforeTest
//import kotlin.test.Test
//import kotlin.test.assertEquals
//
//class UserTimeOffDTOMapperTests {
//
//    private lateinit var mapper: UserTimeOffDTOMapper
//    private lateinit var policyMapper: PolicyDTOMapper
//
//    @BeforeTest
//    fun setUp() {
////        dateTransformer = mockk()
//        policyMapper = mockk()
//        mapper = UserTimeOffDTOMapperImpl(policyMapper)
//    }
//
//    @Test
//    fun `Given userTimeOff when toUiModel then return expected result`() {
//        // Given
//        val policyDTO = PolicyDTO(
//            id = 2,
//            name = "name",
//            allowance = true,
//            description = "description",
//            country_id = 2,
//            contract_type = "contract",
//            organization_id = 2,
//            carryover = 2,
//            team_acknoledgment = true,
//            requires_approval = true,
//            accrue = 2,
//            notify = true,
//            is_working = true,
//            dashboard = true,
//            colour = "colour",
//            max_monthly_allowance = 2,
//            allow_allowance_overflow = true,
//            icon = "icon",
//            is_shortcut = true,
//            overflow_requires_approval = true,
//            period_end_date = "period_end",
//            period_start_date = "period_start"
//        )
//
//        val policyDomain = PolicyDomain(
//            id = 2,
//            name = "name",
//            isAllowance = true,
//            description = "description",
//            countryId = 2,
//            contractType = "contract",
//            organizationId = 2,
//            carryover = 2,
//            hasTeamAcknowledgement = true,
//            isRequiresApproval = true,
//            accrue = 2,
//            notify = true,
//            hasWorking = true,
//            isDashboard = true,
//            colour = "colour",
//            maxMonthlyAllowance = 2,
//            isAllowanceOverflow = true,
//            icon = "icon",
//            isShortcut = true,
//            isOverflowRequiresApproval = true,
//            periodEndDate = "period_end",
//            periodStartDate = "period_start"
//        )
//
//
//        val userTimeOffDTO = UserTimeOffDTO(
//            start_date = "start",
//            end_date = "end",
//            id = 2,
//            timeoff_policy_id = 2,
//            person_id = 2,
//            details = "details",
//            type = "type",
//            status = "status",
//            hours = "hours",
//            timeOffPolicy = policyDTO,
//            modified_by = "by",
//            modified_at = "at",
//        )
//
//        val expected = UserTimeOffDomain(
//            startDate = "start",
//            endDate = "end",
//            id = 2,
//            timeOffPolicyId = 2,
//            personId = 2,
//            details = "details",
//            type = TimeOffTypes.ANOTHER,
//            status = TimeOffStatus.ANOTHER,
//            hours = "hours",
//            timeOffPolicy = policyDomain,
//            modifiedBy = "by",
//            modifiedAt = "at"
//        )
//
//
////        every { dateTransformer.dateToDateString(buildDate("2019-12-11T12:00:00.000Z")) }
////            .returns("11-12-2019 at 12:00")
////        every { dateTransformer.dateToDateString(buildDate("2020-12-07T12:00:00.000Z")) }
////            .returns("07-12-2020 at 12:00")
//
//        every { policyMapper.mapperToDomain(policyDTO) }
//            .returns(policyDomain)
//
//        // When
//        val actualValue = mapper.mapperToDomain(userTimeOffDTO)
//
//        // Then
//        assertEquals(expected, actualValue)
//    }
//
//    @Test
//    fun `Given no userTimeOff when toUiModel then return expected result`() {
//        // Given
//        val userTimeOffDTO = UserTimeOffDTO()
//
//        val expected = UserTimeOffDomain(
//            startDate = "",
//            endDate = "",
//            id = 0,
//            timeOffPolicyId = 0,
//            personId = 0,
//            details = "",
//            type = TimeOffTypes.ANOTHER,
//            status = TimeOffStatus.ANOTHER,
//            hours = "",
//            timeOffPolicy = null,
//            modifiedBy = "",
//            modifiedAt = ""
//        )
//
//        // When
//        val actualValue = mapper.mapperToDomain(userTimeOffDTO)
//
//        // Then
//        assertEquals(expected, actualValue)
//    }
//
//}
