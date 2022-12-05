package com.mindera.people.settings.skill

import com.mindera.people.api.model.Skill as ApiSkill

internal fun ApiSkill.toSkill(): Skill =
    Skill(
        id = this.id ?: 0,
        organizationId = this.organizationId ?: 0,
        skill = this.skill ?: ""
    )
