package com.mindera.people.settings.country

import com.mindera.people.api.model.Country as ApiCountry

internal fun List<ApiCountry>.toCountries(): List<Country> = this.map { it.toCountry() }

internal fun ApiCountry.toCountry(): Country =
    Country(
        id = this.id ?: 0,
        value = this.value ?: ""
    )
