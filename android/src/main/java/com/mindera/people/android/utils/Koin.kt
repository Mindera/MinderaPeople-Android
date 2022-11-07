package com.mindera.people.android.utils

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.get
import org.koin.core.parameter.parametersOf

@Composable
inline fun <reified T> getWith(vararg params: Any?): T =
    get(parameters = { parametersOf(*params) })
