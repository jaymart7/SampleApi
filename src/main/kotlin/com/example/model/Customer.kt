package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Customer(
    val id: String,
    var firstName: String,
    var lastName: String,
    var email: String
)