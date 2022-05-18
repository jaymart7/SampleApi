package com.example.model.mapper

import com.example.model.presentation.Account
import com.example.model.request.AccountRequest
import com.example.model.response.AccountResponse

fun AccountRequest.toAccount(id: Int): Account = Account(
    id = id,
    name = name,
    username = username,
    password = password
)

fun Account.toAccountResponse(): AccountResponse = AccountResponse(
    name = name,
    username = username
)

fun AccountRequest.toAccountResponse(): AccountResponse = AccountResponse(
    name = name,
    username = username
)