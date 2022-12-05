package com.mindera.people.settings.role

import com.mindera.people.api.model.Role as ApiRole

internal fun ApiRole.toRole(): Role =
    Role(
        id = this.id ?: 0,
        description = this.description ?: "",
        organizationId = this.organizationId ?: 0,
        code = this.code ?: "",
        roleGroup = this.roleGroup ?: "",
    )
