package com.mindera.people.settings.skill

import com.mindera.people.api.URL_SKILLS
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import com.mindera.people.api.model.Skill as ApiSkill

interface SkillService {
    suspend fun getSkill(): ApiSkill
}

internal class SkillServiceImpl(private val client: HttpClient) : SkillService {

    override suspend fun getSkill(): ApiSkill {
        return client.get(URL_SKILLS).body()
    }
}