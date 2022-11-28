package com.mindera.people.people

import com.mindera.people.api.model.Person as ApiPerson
import com.mindera.people.api.model.PersonAddress as ApiPersonAddress

internal fun ApiPerson.toPerson(): Person =
    Person(
        id = this.id ?: 0,
        email = this.email ?: "",
        name = this.name,
        photo = this.photo,
        slack = this.slack,
        skype = this.skype,
        phone = this.phone,
        primaryRoleId = this.primaryRoleId ?: 0,
        primarySeniorityId = this.primarySeniorityId ?: 0,
        primarySkillId = this.primarySkillId ?: 0,
        primaryLocationId = this.primaryLocationId ?: 0,
        countryId = this.countryId ?: 0,
        primaryCtc = this.primaryCtc ?: 0,
        primaryRate = this.primaryRate ?: 0,
        primaryCurrency = this.primaryCurrency ?: "",
        primaryOfficeId = this.primaryOfficeId ?: 0
    )

internal fun ApiPersonAddress.toPersonAddress(): PersonAddress =
    PersonAddress(
        id = this.id ?: 0,
        type = PersonAddress.Type.mapperEnum(type),
        personId = this.personId ?: 0,
        street = this.street ?: "",
        state = this.state ?: "",
        postCode = this.postCode ?: "",
        city = this.city ?: ""
    )

internal fun Person.toApiModel(): ApiPerson =
    ApiPerson(
        id = this.id,
        name = this.name,
        email = this.email,
        photo = this.photo,
        slack = this.slack,
        skype = this.skype,
        phone = this.phone,
        primaryRoleId = this.primaryRoleId,
        primarySeniorityId = this.primarySeniorityId,
        primarySkillId = this.primarySkillId,
        primaryLocationId = this.primaryLocationId,
        countryId = this.countryId,
        primaryCtc = this.primaryCtc,
        primaryRate = this.primaryRate,
        primaryCurrency = this.primaryCurrency,
        primaryOfficeId = this.primaryOfficeId
    )
