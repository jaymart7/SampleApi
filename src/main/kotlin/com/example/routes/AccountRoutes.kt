package com.example.routes

import com.example.model.BaseResponse
import com.example.model.LoginRequest
import com.example.model.mapper.toAccount
import com.example.model.mapper.toAccountResponse
import com.example.model.request.AccountRequest
import com.example.plugins.accountStorage
import com.example.plugins.json
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import java.util.*

fun Route.accountRouting() {
    route("/login") {
        post {
            val loginRequest = call.receive<LoginRequest>()
            val account = accountStorage.find { account ->
                account.username == loginRequest.username && account.password == loginRequest.password
            }

            val response = BaseResponse(
                data = account?.toAccountResponse(),
                message = "Successfully login"
            )
            call.respondText(
                json.encodeToString(response),
                status = HttpStatusCode.OK
            )
        }
    }

    route("/register") {
        post {
            val accountRequest = call.receive<AccountRequest>()
            val id = Random().nextInt(1000)
            accountStorage.add(accountRequest.toAccount(id))
            val response = BaseResponse(
                data = accountRequest.toAccountResponse(),
                message = "Successfully registered"
            )
            call.respond(response)
        }
    }
}