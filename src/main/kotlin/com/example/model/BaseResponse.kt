package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val data: T?,
    val message: String
)