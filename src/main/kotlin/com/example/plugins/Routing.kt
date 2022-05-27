package com.example.plugins

import com.example.model.Customer
import com.example.model.presentation.Account
import com.example.repository.AccountRepositoryImpl
import com.example.repository.accountStorage
import com.example.routes.accountRouting
import com.example.routes.customerRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

val customerStorage = mutableListOf<Customer>()
val json = Json { ignoreUnknownKeys = true }

fun Application.configureRouting() {

    val accountRepository = AccountRepositoryImpl()

    initializeDatabase()
    routing {
        customerRouting()
        accountRouting(accountRepository)
    }
}

fun initializeDatabase() {
    customerStorage.add(Customer("1", "Jaymart", "Araga", "jaymart@yahoo.com"))

    accountStorage.add(Account(1, "Jaymart", "a", "a"))
}