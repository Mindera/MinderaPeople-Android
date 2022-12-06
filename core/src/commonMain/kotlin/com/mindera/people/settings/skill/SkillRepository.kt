package com.mindera.people.settings.skill


interface SkillRepository {
    suspend fun getSkills(): List<Skill>
}

internal class SkillRepositoryImpl(private val skillService: SkillService) : SkillRepository {
    override suspend fun getSkills(): List<Skill> = skillService.getSkills().toSkills()
}
