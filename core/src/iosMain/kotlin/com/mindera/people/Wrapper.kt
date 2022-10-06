package com.mindera.people

import co.touchlab.kermit.Logger
import co.touchlab.kermit.LoggerConfig
import com.mindera.people.utils.MainScope
import org.koin.core.component.KoinComponent
import org.koin.dsl.module

object MinderaPeopleWrapper : KoinComponent {
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
//            .onEach { callback(it) }
//            .launchIn(mainScope)
//    }
//
//    suspend fun getCurrentIpInfo(): IpInfo? = konnection.getCurrentIpInfo()

    private fun setupKoin() {
        initKoin {
            modules(
                module {
                    val baseKermit = Logger(config = LoggerConfig.default, tag = "MinderaPeople")
                    factory { (tag: String?) -> if (tag != null) baseKermit.withTag(tag) else baseKermit }
                }
            )
        }
    }
}
