package com.mindera.people.settings.office


interface OfficeRepository {
    suspend fun getOffice(): Office
}

internal class OfficeRepositoryImpl(private val officeService: OfficeService) : OfficeRepository {
    override suspend fun getOffice(): Office = officeService.getOffice().toOffice()
}
