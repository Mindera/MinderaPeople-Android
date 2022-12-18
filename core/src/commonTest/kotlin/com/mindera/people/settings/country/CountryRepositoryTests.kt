package com.mindera.people.settings.country

import com.mindera.people.defaultApiCountry
import com.mindera.people.defaultCountry
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.given
import io.mockative.mock
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CountryRepositoryTests {
    @Mock
    private val service = mock(classOf<CountryService>())


    private lateinit var repository: CountryRepository

    @BeforeTest
    fun setup() {
        repository = CountryRepositoryImpl(service)
    }

    @Test
    fun `test getCountry save a given Policy properly`() = runTest {
        given(service).coroutine { getCountries() }.thenReturn(listOf(defaultApiCountry))

        val result = repository.getCountries()

        assertEquals(listOf(defaultCountry), result)
    }

}
