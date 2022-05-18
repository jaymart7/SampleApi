package com.example.routes

import com.example.model.BaseResponse
import com.example.model.LoginRequest
import com.example.model.mapper.toAccountResponse
import com.example.model.request.AccountRequest
import com.example.plugins.json
import com.example.repository.AccountRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString

fun Route.accountRouting(accountRepository: AccountRepository) {

    route("/login") {
        post {
            val loginRequest = call.receive<LoginRequest>()

            val accountResponse = accountRepository.login(loginRequest)

            if (accountResponse == null) {
                call.respondText(
                    "Account not found",
                    status = HttpStatusCode.NotFound
                )
            } else {
                val response = BaseResponse(
                    data = accountResponse,
                    message = "Successfully login"
                )
                call.respondText(
                    json.encodeToString(response),
                    status = HttpStatusCode.OK
                )
            }
        }
    }

    route("/register") {
        post {
            val accountRequest = call.receive<AccountRequest>()

            accountRepository.addAccount(accountRequest)

            val response = BaseResponse(
                data = accountRequest.toAccountResponse(),
                message = "Successfully registered"
            )
            call.respond(response)
        }
    }
}