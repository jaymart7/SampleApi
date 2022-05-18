package com.example.repository

import com.example.model.LoginRequest
import com.example.model.mapper.toAccount
import com.example.model.mapper.toAccountResponse
import com.example.model.presentation.Account
import com.example.model.request.AccountRequest
import com.example.model.response.AccountResponse
import com.example.plugins.accountStorage
import java.util.*


val accountStorage = mutableListOf<Account>()

interface AccountRepository {

    fun addAccount(accountRequest: AccountRequest)

    fun login(loginRequest: LoginRequest): AccountResponse?
}

class AccountRepositoryImpl : AccountRepository {

    override fun addAccount(accountRequest: AccountRequest) {
        val id = Random().nextInt(1000)
        accountStorage.add(accountRequest.toAccount(id))
    }

    override fun login(loginRequest: LoginRequest): AccountResponse? =
        accountStorage.find { account ->
            account.username == loginRequest.username && account.password == loginRequest.password
        }?.toAccountResponse()

}