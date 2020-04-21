package com.wire.bots.polls.routing

import com.wire.bots.polls.utils.createLogger
import io.ktor.routing.Routing
import org.kodein.di.ktor.kodein

internal val routingLogger by lazy { createLogger("RoutingLogger") }

/**
 * Register routes to the KTor.
 */
fun Routing.registerRoutes() {
    val k by kodein()

    serviceRoutes(k)
    messages(k)
}
