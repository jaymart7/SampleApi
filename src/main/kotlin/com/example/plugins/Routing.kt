package com.example.plugins

import com.example.model.Customer
import com.example.routes.customerRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

val customerStorage = mutableListOf<Customer>()

fun Application.configureRouting() {
    customerStorage.add(Customer("1", "Jaymart", "Araga", "jaymart@yahoo.com"))
    routing {
        customerRouting()
    }
}
