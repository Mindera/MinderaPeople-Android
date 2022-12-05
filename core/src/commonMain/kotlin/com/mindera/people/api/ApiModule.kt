package com.mindera.people.api

import com.mindera.people.user.UserRepository
import com.mindera.people.utils.LocalDateKSerializer
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.datetime.LocalDate
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import org.koin.dsl.module

val apiModule = module {
    single {
        val userRepository = get<UserRepository>()

        HttpClient {
            install(Logging) {
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    serializersModule = SerializersModule {
                        contextual(LocalDate::class, LocalDateKSerializer)
                    }
                }

                HttpResponseValidator {
                    validateResponse { response ->
                        val error: Error = response.body()
                        error.cause?.let {
                            throw it
                        }
                    }
                }
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }

            defaultRequest {
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
                bearerAuth(token = userRepository.authenticated?.token ?: "")
            }
        }
    }
}
