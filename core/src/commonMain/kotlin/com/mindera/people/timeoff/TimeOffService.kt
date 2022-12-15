package com.mindera.people.timeoff

import com.mindera.people.api.URL_TIME_OFF_CALENDAR
import com.mindera.people.api.URL_TIME_OFF_SUMMARY
import com.mindera.people.api.URL_TIME_OFF_USER
import com.mindera.people.utils.plusOneMonth
import com.mindera.people.utils.today
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.datetime.LocalDate
import org.koin.core.parameter.parametersOf
import com.mindera.people.api.model.PersonTimeOff as ApiPersonTimeOff
import com.mindera.people.api.model.Policy as ApiPolicy
import com.mindera.people.api.model.TeamTimeOffList as ApiTeamTimeOffList

internal interface TimeOffService {
    suspend fun getUser(): ApiPersonTimeOff
    suspend fun getUserTimeOffCalendar(id: String): ApiTeamTimeOffList
    suspend fun getTeamTimeOffCalendar(id: String): ApiTeamTimeOffList
    suspend fun getSummary(id: String): ApiPolicy
}

internal class TimeOffServiceImpl(private val client: HttpClient) : TimeOffService {

    override suspend fun getUser(): ApiPersonTimeOff = client.get(URL_TIME_OFF_USER).body()

    override suspend fun getUserTimeOffCalendar(id: String): ApiTeamTimeOffList =
        client.get(URL_TIME_OFF_CALENDAR) {
            parametersOf(
                "personId", id,
                "startDate", LocalDate.today(),
                "endDate", LocalDate.today()
            )
        }.body()

    override suspend fun getTeamTimeOffCalendar(id: String): ApiTeamTimeOffList =
        client.get(URL_TIME_OFF_CALENDAR) {
            parametersOf(
                "personId", id,
                "startDate", LocalDate.today(),
                "endDate", LocalDate.plusOneMonth()
            )
        }.body()

    override suspend fun getSummary(id: String): ApiPolicy =
        client.get(URL_TIME_OFF_SUMMARY) { parameter("personId", id) }.body()
}
