package com.mindera.people.office

import com.mindera.people.BaseTest
import com.mindera.people.defaultApiOffice
import com.mindera.people.defaultApiPolicy
import com.mindera.people.defaultOffice
import com.mindera.people.defaultPolicy
import com.mindera.people.settings.office.OfficeRepository
import com.mindera.people.settings.office.OfficeRepositoryImpl
import com.mindera.people.settings.office.OfficeService
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

class OfficeRepositoryTests {
    @Mock
    private val service = mock(classOf<OfficeService>())


    private lateinit var repository: OfficeRepository

    @BeforeTest
    fun setup() {
        repository = OfficeRepositoryImpl(service)
    }

    @Test
    fun `test getOffice save a given Policy properly`() = runTest {
        given(service).coroutine { getOffice() }.thenReturn(defaultApiOffice)

        val result = repository.getOffice()

        assertEquals(defaultOffice, result)
    }

}
