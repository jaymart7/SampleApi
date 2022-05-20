package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.*

fun main() {
    embeddedServer(Netty, watchPaths = listOf("classes"), port = 8081, host = "localhost") {
        install(CORS) {
            anyHost()
            allowHeader(HttpHeaders.ContentType)
        }
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}