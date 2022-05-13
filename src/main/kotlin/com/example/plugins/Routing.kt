package com.example.plugins

import com.example.model.Customer
import com.example.routes.customerRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

val customerStorage = mutableListOf<Customer>()
val json = Json { ignoreUnknownKeys = true }

fun Application.configureRouting() {
    customerStorage.add(Customer("1", "Jaymart", "Araga", "jaymart@yahoo.com"))
    routing {
        customerRouting()
    }
}
