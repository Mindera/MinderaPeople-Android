package com.mindera.people.network.service

import com.mindera.people.network.URL_TIME_OFF_CALENDAR
import com.mindera.people.network.URL_TIME_OFF_SUMMARY
import com.mindera.people.network.URL_TIME_OFF_USER
import com.mindera.people.network.models.PolicyDTO
import com.mindera.people.network.models.UserTimeOffDTO
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

interface TimeOffService {
    suspend fun getUser(): UserTimeOffDTO
    suspend fun getTimeOffCalendar(id: String)
    suspend fun getSummary(id: String): PolicyDTO
}

class TimeOffServiceImpl(private val client: HttpClient) : TimeOffService {

    override suspend fun getUser(): UserTimeOffDTO {
        return client.get(URL_TIME_OFF_USER).body()
    }

    override suspend fun getTimeOffCalendar(id: String) {
        return client.get(URL_TIME_OFF_CALENDAR) {
            parameter("personId", id)
        }.body()
    }

    override suspend fun getSummary(id: String): PolicyDTO {
        return client.get(URL_TIME_OFF_SUMMARY) {
            parameter("personId", id)
        }.body()
    }
}