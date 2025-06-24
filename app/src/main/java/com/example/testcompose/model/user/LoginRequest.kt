package com.example.testcompose.model.user

data class LoginResponse(
    val token: String,
    val userId: String,
    val username: String
)
