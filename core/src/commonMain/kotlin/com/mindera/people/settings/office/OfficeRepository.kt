package com.mindera.people.settings.office


interface OfficeRepository {
    suspend fun getOffices(): List<Office>
}

internal class OfficeRepositoryImpl(private val officeService: OfficeService) : OfficeRepository {
    override suspend fun getOffices(): List<Office> = officeService.getOffices().toOffices()
}
