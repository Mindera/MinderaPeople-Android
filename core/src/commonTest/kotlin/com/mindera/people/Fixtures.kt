package com.mindera.people

import com.mindera.people.people.Person
import com.mindera.people.people.PersonAddress
import com.mindera.people.people.PersonTimeOff
import com.mindera.people.policy.Policy
import com.mindera.people.timeoff.TimeOffStatus
import com.mindera.people.timeoff.TimeOffTypes

// region Policy
val defaultPolicy = Policy(
    id = 123,
    name = "",
    isAllowance = false,
    description = "",
    countryId = 0,
    contractType = "",
    organizationId = 0,
    carryover = 0,
    hasTeamAcknowledgement = true,
    isRequiresApproval = false,
    accrue = 0,
    notify = true,
    hasWorking = true,
    isDashboard = false,
    colour = "#FFFFFF",
    maxMonthlyAllowance = 0,
    isAllowanceOverflow = false,
    icon = "",
    isShortcut = false,
    isOverflowRequiresApproval = false,
    periodEndDate = "",
    periodStartDate = ""
)
// endregion

// region Person
val defaultPerson = Person(
    id = 123,
    email = "person@mindera.com",
    name = "Minder",
    photo = null,
    slack = "@minder",
    skype = null,
    phone = null,
    primaryRoleId = 0,
    primarySeniorityId = 0,
    primarySkillId = 0,
    primaryLocationId = 0,
    countryId = 351,
    primaryCtc = 0,
    primaryRate = 0,
    primaryCurrency = "EUR",
    primaryOfficeId = 0
)

val defaultPersonAddressFixtures = PersonAddress(
    id = 123456,
    type = PersonAddress.Type.CURRENT,
    personId = 123,
    street = "Street X",
    state = "State X",
    postCode = "9999",
    city = "City X"
)

val defaultPersonTimeOff = PersonTimeOff(
    id = 123,
    startDate = "",
    endDate = "",
    timeOffPolicyId = 0,
    personId = 123,
    details = "",
    type = TimeOffTypes.FULL_DAY,
    status = TimeOffStatus.APPROVED,
    hours = "",
    timeOffPolicy = defaultPolicy,
    modifiedBy = "",
    modifiedAt = ""
)
// endregion
