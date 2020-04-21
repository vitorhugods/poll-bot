package com.wire.bots.polls.setup

import com.wire.bots.polls.utils.createLogger
import com.wire.bots.polls.utils.httpCall
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.JacksonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.observer.ResponseObserver
import io.micrometer.core.instrument.MeterRegistry

/**
 * Prepares HTTP Client with given keystore.
 */
fun createHttpClient(meterRegistry: MeterRegistry) =
    HttpClient(Apache) {
        install(JsonFeature) {
            serializer = JacksonSerializer()
        }

        install(ResponseObserver) {
            onResponse {
                meterRegistry.httpCall(it)
            }
        }

        install(Logging) {
            logger = Logger.TRACE
            level = LogLevel.ALL
        }
    }

/**
 * Debug logger for HTTP Requests.
 */
private val Logger.Companion.DEBUG: Logger
    get() = object : Logger, org.slf4j.Logger by createLogger("HttpCallsLogging") {
        override fun log(message: String) {
            debug(message)
        }
    }


/**
 * Trace logger for HTTP Requests.
 */
private val Logger.Companion.TRACE: Logger
    get() = object : Logger, org.slf4j.Logger by createLogger("HttpCallsLogging") {
        override fun log(message: String) {
            trace(message)
        }
    }
