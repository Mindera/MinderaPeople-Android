package com.mindera.people.settings.skill


interface SkillRepository {
    suspend fun getSkill(): Skill
}

internal class SkillRepositoryImpl(private val skillService: SkillService) : SkillRepository {
    override suspend fun getSkill(): Skill = skillService.getSkill().toSkill()
}
