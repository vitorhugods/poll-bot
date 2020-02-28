package com.wire.bots.polls.setup

/**
 * Contains variables that are loaded from the environment.
 */
object EnvConfigVariables {
    /**
     * Id of the current bot.
     */
    const val SERVICE_CODE = "SERVICE_CODE"
    /**
     * Token which is used for the auth of proxy.
     */
    const val SERVICE_TOKEN = "SERVICE_TOKEN"
    /**
     * Key for connecting to the web socket of the proxy.
     */
    const val APP_KEY = "APP_KEY"
    /**
     * Determines whether to use web sockets for connection to proxy or not eg. true
     */
    const val USE_WEB_SOCKETS = "USE_WEB_SOCKETS"
    /**
     * Host name for the connection to web socket eg."proxy.services.zinfra.io"
     */
    const val PROXY_WS_HOST = "PROXY_WS_HOST"
    /**
     * Path to web socket at proxy eg. "/await"
     */
    const val PROXY_WS_PATH = "PROXY_WS_PATH"
    /**
     * Domain used for sending the messages from the bot to proxy eg. "https://proxy.services.zinfra.io"
     */
    const val PROXY_DOMAIN = "PROXY_DOMAIN"
}
