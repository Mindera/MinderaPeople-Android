package com.mindera.people.api

private const val BASE_URL = "https://people.mindera.com/api"

// region User API's
internal const val URL_USER = "$BASE_URL/user"
internal const val URL_USER_FILTER = "$BASE_URL/allocation/view?filter[person_id]="
// endregion

// region People API's
internal const val URL_PEOPLE = "$BASE_URL/people/profile/"
internal const val URL_PEOPLE_ADDRESS = "$BASE_URL/people/profile/address"
// endregion

// region TimeOff API's
internal const val URL_TIME_OFF_USER = "$BASE_URL/timeoff/user/"
internal const val URL_TIME_OFF_CALENDAR = "$BASE_URL/timeoff/calendar"
internal const val URL_TIME_OFF_SUMMARY = "$BASE_URL/timeoff/summary/"
// endregion
