package com.mindera.people.office

import app.cash.turbine.test
import com.mindera.people.defaultOffice
import com.mindera.people.settings.office.GetOfficeUseCase
import com.mindera.people.settings.office.OfficeRepository
import com.mindera.people.utils.UiState
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import io.mockative.once
import io.mockative.verify
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GetOfficeUseCaseTests {
    @Mock private val repository = mock(classOf<OfficeRepository>())

    private lateinit var useCase: GetOfficeUseCase

    @BeforeTest
    fun setup() {
        useCase = GetOfficeUseCase(repository)
    }

    @Test
    fun `when execute then returns expected Office`() = runTest {
        // Given
        given(repository).coroutine { repository.getOffice() }
            .thenReturn(defaultOffice)

        // When
        useCase().test {
            assertEquals(UiState.Success(defaultOffice), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getOffice() }.wasInvoked(exactly = once)
    }
}
