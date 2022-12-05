package com.mindera.people.settings.role


interface RoleRepository {
    suspend fun getRole(): Role
}

internal class RoleRepositoryImpl(private val roleService: RoleService) : RoleRepository {
    override suspend fun getRole(): Role = roleService.getRole().toRole()
}
