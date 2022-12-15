package com.mindera.people.settings.role

import com.mindera.people.utils.UseCaseOut

class GetRoleUseCase(
    private val repository: RoleRepository,
    override val block: suspend () -> List<Role> = { repository.getRoles() }
) : UseCaseOut<List<Role>>()
