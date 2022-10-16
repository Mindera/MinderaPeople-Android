package com.mindera.people

import co.touchlab.kermit.CommonWriter
import co.touchlab.kermit.ExperimentalKermitApi
import co.touchlab.kermit.Logger
import co.touchlab.kermit.LoggerConfig
import co.touchlab.kermit.crashlytics.CrashlyticsLogWriter
import co.touchlab.kermit.crashlytics.setCrashlyticsUnhandledExceptionHook
import co.touchlab.kermit.setupUnhandledExceptionHook
import com.mindera.people.auth.AuthState
import com.mindera.people.auth.AuthViewModel
import com.mindera.people.user.User
import com.mindera.people.utils.MainScope
import com.mindera.people.utils.safeLaunchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.dsl.module

@OptIn(ExperimentalKermitApi::class)
object MinderaPeopleWrapper : KoinComponent {
    private val mainScope = MainScope()

    private val authViewModel: AuthViewModel by inject()

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

    fun authentication(user: User) {
        authViewModel.authenticate(user)
    }

    fun authStateObservation(callback: (AuthState) -> Unit) {
        authViewModel.state
            .onEach {callback.invoke(it) }
            .safeLaunchIn(mainScope)
    }

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
