package com.mindera.people.settings.country

import app.cash.turbine.test
import com.mindera.people.defaultCountry
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

class GetCountryUseCaseTests {
    @Mock private val repository = mock(classOf<CountryRepository>())

    private lateinit var useCase: GetCountryUseCase

    @BeforeTest
    fun setup() {
        useCase = GetCountryUseCase(repository)
    }

    @Test
    fun `when execute then returns expected Country`() = runTest {
        // Given
        given(repository).coroutine { repository.getCountries() }
            .thenReturn(listOf( defaultCountry))

        // When
        useCase().test {
            assertEquals(UiState.Success(listOf(defaultCountry)), awaitItem())
            awaitComplete()
        }

        // Then
        verify(repository).coroutine { getCountries() }.wasInvoked(exactly = once)
    }
}
