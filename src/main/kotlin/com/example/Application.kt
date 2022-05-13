package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

fun main() {
    embeddedServer(Netty, watchPaths = listOf("classes"), port = 8081, host = "localhost") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
