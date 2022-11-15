package com.mindera.people.timeoff

import com.mindera.people.api.URL_TIME_OFF_CALENDAR
import com.mindera.people.api.URL_TIME_OFF_SUMMARY
import com.mindera.people.api.URL_TIME_OFF_USER
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.mindera.people.api.model.PersonTimeOff as ApiPersonTimeOff
import com.mindera.people.api.model.Policy as ApiPolicy

internal interface TimeOffService {
    suspend fun getUser(): ApiPersonTimeOff
    suspend fun getTimeOffCalendar(id: String)
    suspend fun getSummary(id: String): ApiPolicy
}

internal class TimeOffServiceImpl(private val client: HttpClient) : TimeOffService {

    override suspend fun getUser(): ApiPersonTimeOff = client.get(URL_TIME_OFF_USER).body()

    override suspend fun getTimeOffCalendar(id: String) =
        client.get(URL_TIME_OFF_CALENDAR) { parameter("personId", id) }.body<Unit>()

    override suspend fun getSummary(id: String): ApiPolicy =
        client.get(URL_TIME_OFF_SUMMARY) { parameter("personId", id) }.body()
}
