package com.mindera.people

import co.touchlab.kermit.Logger
import co.touchlab.kermit.LoggerConfig
import com.mindera.people.utils.MainScope
import org.koin.dsl.module

object MinderaPeopleWrapper {
    private val mainScope = MainScope()
//    private val konnection = Konnection(enableDebugLog = true)
//
//    fun hasNetworkConnection(): Boolean = konnection.isConnected()

    fun start() {
        initKoin {
            modules(
                module {
                    val baseKermit = Logger(config = LoggerConfig.default, tag = "MinderaPeople")
                    factory { (tag: String?) -> if (tag != null) baseKermit.withTag(tag) else baseKermit }
                }
            )
        }
    }

    fun stop() {
     // konnection.stop()
     // mainScope.cancel()
    }

//    fun networkConnectionObservation(callback: (NetworkConnection?) -> Unit) {
//        konnection.observeNetworkConnection()
//            .onEach { callback(it) }
//            .launchIn(mainScope)
//    }
//
//    suspend fun getCurrentIpInfo(): IpInfo? = konnection.getCurrentIpInfo()
}
