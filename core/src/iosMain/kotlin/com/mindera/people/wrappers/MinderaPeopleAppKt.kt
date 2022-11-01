package com.mindera.people.wrappers

import co.touchlab.kermit.CommonWriter
import co.touchlab.kermit.ExperimentalKermitApi
import co.touchlab.kermit.Logger
import co.touchlab.kermit.LoggerConfig
import com.mindera.people.initKoin
import com.mindera.people.utils.MainScope
import org.koin.core.component.KoinComponent
import org.koin.dsl.module

@OptIn(ExperimentalKermitApi::class)
object MinderaPeopleAppKt : KoinComponent {
    private val mainScope = MainScope()

//    private val konnection = Konnection(enableDebugLog = true)
//
//    fun hasNetworkConnection(): Boolean = konnection.isConnected()

    fun start() {
        setupKoin()
    }

    fun stop() {
        // konnection.stop()
        // mainScope.cancel()
    }

//    fun networkConnectionObservation(callback: (NetworkConnection?) -> Unit) {
//        konnection.observeNetworkConnection()
//            .onEach { callback.invoke(it) }
//            .safeLaunchIn(mainScope)
//    }
//
//    suspend fun getCurrentIpInfo(): IpInfo? = konnection.getCurrentIpInfo()

    private fun setupKoin() {
        initKoin {
            modules(
                module {
                    val baseLogger = Logger(
                        config = LoggerConfig.default.copy(
                            logWriterList = listOf(CommonWriter() /*, CrashlyticsLogWriter()*/)
                        ),
                        tag = "MinderaPeople"
                    )/*.also { setCrashlyticsUnhandledExceptionHook() }*/
                    factory { (tag: String?) -> tag?.let { baseLogger.withTag(it) } ?: baseLogger }
                }
            )
        }
    }
}
