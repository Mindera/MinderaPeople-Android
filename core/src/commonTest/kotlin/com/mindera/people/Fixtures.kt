package com.mindera.people

import com.mindera.people.api.model.SummaryList
import com.mindera.people.auth.User
import com.mindera.people.people.Person
import com.mindera.people.people.PersonAddress
import com.mindera.people.people.PersonTimeOff
import com.mindera.people.people.TeamTimeOff
import com.mindera.people.people.TeamTimeOffList
import com.mindera.people.settings.country.Country
import com.mindera.people.settings.location.Location
import com.mindera.people.settings.office.Office
import com.mindera.people.settings.policy.Policy
import com.mindera.people.settings.role.Role
import com.mindera.people.settings.skill.Skill
import com.mindera.people.timeoff.Summary
import com.mindera.people.timeoff.TimeOffStatus
import com.mindera.people.timeoff.TimeOffTypes
import com.mindera.people.api.model.Country as ApiCountry
import com.mindera.people.api.model.Location as ApiLocation
import com.mindera.people.api.model.Office as ApiOffice
import com.mindera.people.api.model.Person as ApiPerson
import com.mindera.people.api.model.PersonAddress as ApiPersonAddress
import com.mindera.people.api.model.PersonTimeOff as ApiPersonTimeOff
import com.mindera.people.api.model.Policy as ApiPolicy
import com.mindera.people.api.model.Role as ApiRole
import com.mindera.people.api.model.Skill as ApiSkill
import com.mindera.people.api.model.TeamTimeOff as ApiTeamTimeOff
import com.mindera.people.api.model.TeamTimeOffList as ApiTeamTimeOffList
import com.mindera.people.api.model.SummaryList as ApiSummaryList
import com.mindera.people.api.model.Summary as ApiSummary

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

val defaultApiPolicy = ApiPolicy(
    id = 123,
    name = "",
    allowance = false,
    description = "",
    countryId = 0,
    contractType = "",
    organizationId = 0,
    carryover = 0,
    teamAcknoledgment = true,
    requiresApproval = false,
    accrue = 0,
    notify = true,
    isWorking = true,
    dashboard = false,
    colour = "#FFFFFF",
    maxMonthlyAllowance = 0,
    allowAllowanceOverflow = false,
    icon = "",
    isShortcut = false,
    overflowRequiresApproval = false,
    periodEndDate = "",
    periodStartDate = ""
)
// endregion

// region User
val defaultUser = User(
    id = 123,
    email = "person@mindera.com",
    name = "Minder",
    photo = null,
)
// end User

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

val defaultApiPerson = ApiPerson(
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

val defaultPersonAddress = PersonAddress(
    id = 123456,
    type = PersonAddress.Type.CURRENT,
    personId = 123,
    street = "Street X",
    state = "State X",
    postCode = "9999",
    city = "City X"
)

val defaultApiPersonAddress = ApiPersonAddress(
    id = 123456,
    type = "CURRENT",
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
    hours = 0,
    timeOffPolicy = defaultPolicy
)

val defaultApiPersonTimeOff = ApiPersonTimeOff(
    id = 123,
    startDate = "",
    endDate = "",
    timeoffPolicyId = 0,
    personId = 123,
    details = "",
    type = "FULL_DAY",
    status = "APPROVED",
    hours = 0,
    timeOffPolicy = defaultApiPolicy,
    modifiedBy = "",
    modifiedAt = ""
)

val defaultApiTeamTimeOffList = ApiTeamTimeOffList(
    parent = 123,
    data = listOf(
        ApiTeamTimeOff(
            id = 123,
            client = "mindera",
            parent = 123,
            open = false,
            data = defaultApiPersonTimeOff
        )
    )
)

val defaultApiTeamTimeOff = ApiTeamTimeOff(
    id = 123,
    client = "mindera",
    parent = 123,
    open = false,
    data = defaultApiPersonTimeOff
)

val defaultTeamTimeOffList = TeamTimeOffList(
    parent = 123,
    data = listOf(
        TeamTimeOff(
            id = 123,
            client = "mindera",
            parent = 123,
            isOpen = false,
            data = defaultPersonTimeOff
        )
    )
)

val defaultTeamTimeOff = TeamTimeOff(
    id = 123,
    client = "",
    parent = 123,
    isOpen = false,
    data = defaultPersonTimeOff
)

val defaultRole = Role(
    id = 123456,
    organizationId = 12,
    description = "description",
    code = "code",
    roleGroup = "roleGroup"
)

val defaultApiRole = ApiRole(
    id = 123456,
    organizationId = 12,
    description = "description",
    code = "code",
    roleGroup = "roleGroup"
)

val defaultSkill = Skill(
    id = 123456,
    organizationId = 12,
    skill = "skill"
)

val defaultApiSkill = ApiSkill(
    id = 123456,
    organizationId = 12,
    skill = "skill"
)


val defaultOffice = Office(
    id = 123456,
    organizationId = 12,
    name = "name",
    maxCapacity = 10,
    locationId = 1
)

val defaultApiOffice = ApiOffice(
    id = 123456,
    organizationId = 12,
    name = "name",
    maxCapacity = 10,
    locationId = 1
)

val defaultLocation = Location(
    id = 123456,
    organizationId = 12,
    name = "name",
    country = "country",
    countryId = 1
)

val defaultApiLocation = ApiLocation(
    id = 123456,
    organizationId = 12,
    name = "name",
    country = "country",
    countryId = 1
)


val defaultCountry = Country(
    id = 123456,
    value = "value",
)

val defaultApiCountry = ApiCountry(
    id = 123456,
    value = "value",
)

val defaultApiSummaryList = listOf(
    ApiSummaryList(
        id = 5279,
        summary = ApiSummary(
            allowedAllowance = 1,
            used = 1F
        )
    )
)

val defaultSummary = Summary(
    allowedAllowance = "1",
    used = "1.0"
)


// endregion
