package com.mindera.people.settings.office

import com.mindera.people.utils.UseCaseOut

class GetOfficeUseCase(
    private val repository: OfficeRepository,
    override val block: suspend () -> List<Office> = { repository.getOffices() }
) : UseCaseOut<List<Office>>()
