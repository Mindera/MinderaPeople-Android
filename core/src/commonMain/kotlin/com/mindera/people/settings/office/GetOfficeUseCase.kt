package com.mindera.people.settings.office

import com.mindera.people.utils.UseCaseOut

class GetOfficeUseCase(
    private val repository: OfficeRepository,
    override val block: suspend () -> Office = { repository.getOffice() }
) : UseCaseOut<Office>()
