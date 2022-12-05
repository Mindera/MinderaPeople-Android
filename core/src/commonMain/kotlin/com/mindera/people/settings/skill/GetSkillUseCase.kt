package com.mindera.people.settings.skill

import com.mindera.people.utils.UseCaseOut

class GetSkillUseCase(
    private val repository: SkillRepository,
    override val block: suspend () -> Skill = { repository.getSkill() }
) : UseCaseOut<Skill>()
