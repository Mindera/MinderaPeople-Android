package com.mindera.people.utils

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.parameter.parametersOf
import org.koin.mp.KoinPlatformTools

@Suppress("unused")
inline fun <reified T> KoinComponent.getWith(vararg params: Any?): T =
    get(parameters = { parametersOf(*params) })

@Suppress("unused")
inline fun <reified T : Any> KoinComponent.injectWith(
    vararg params: Any?,
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED
) = lazy(mode) {
    KoinPlatformTools.defaultContext().get().get<T>(parameters = { parametersOf(*params) })
}
