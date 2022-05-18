package com.example.model.response

import kotlinx.serialization.Serializable

@Serializable
data class AccountResponse(
    val name: String,
    val username: String
)