package com.mindera.people.settings.country

import com.mindera.people.BaseTest
import com.mindera.people.defaultApiCountry
import com.mindera.people.defaultApiPolicy
import com.mindera.people.defaultCountry
import com.mindera.people.defaultPolicy
import com.mindera.people.settings.policy.PolicyRepository
import com.mindera.people.settings.policy.PolicyRepositoryImpl
import com.mindera.people.timeoff.TimeOffService
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
        given(service).coroutine { getCountry() }.thenReturn(defaultApiCountry)

        val result = repository.getCountry()

        assertEquals(defaultCountry, result)
    }

}
