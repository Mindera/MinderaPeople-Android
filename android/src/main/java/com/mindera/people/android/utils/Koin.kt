package com.mindera.people.android.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import org.koin.androidx.compose.get
import org.koin.core.parameter.parametersOf
import org.koin.mp.KoinPlatformTools

@Composable
inline fun <reified T> getWith(vararg params: Any?): T =
    get(parameters = { parametersOf(*params) })

@Suppress("unused")
inline fun <reified T : Any> ViewModel.injectWith(
    vararg params: Any?,
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED
) = lazy(mode) {
    KoinPlatformTools.defaultContext().get().get<T>(parameters = { parametersOf(*params) })
}
