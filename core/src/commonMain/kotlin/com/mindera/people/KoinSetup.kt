package com.mindera.people

import com.mindera.people.api.apiModule
import com.mindera.people.data.dataModule
import com.mindera.people.people.peopleModule
import com.mindera.people.settings.country.countryModule
import com.mindera.people.settings.location.locationModule
import com.mindera.people.settings.office.officeModule
import com.mindera.people.settings.policy.policyModule
import com.mindera.people.settings.role.roleModule
import com.mindera.people.settings.skill.skillModule
import com.mindera.people.timeoff.timeOffModule
import com.mindera.people.user.userModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        platformModule,
        dataModule,
        apiModule,
        userModule,
        peopleModule,
        timeOffModule,
        policyModule,
        roleModule,
        skillModule,
        officeModule,
        locationModule,
        countryModule
    )
}

inline fun <reified T> Scope.getWith(vararg params: Any?): T =
    get(parameters = { parametersOf(*params) })

expect val platformModule: Module

// region Koin Qualifiers
const val STORAGE_NAME = "UNENCRYPTED_SETTINGS"
const val ENCRYPTED_STORAGE_NAME = "ENCRYPTED_SETTINGS"
const val encryptedSettings = "encryptedSettings"
const val unencryptedSettings = "unencryptedSettings"
// endregion
