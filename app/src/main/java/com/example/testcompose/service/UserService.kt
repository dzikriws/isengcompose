package com.example.testcompose.service

import com.example.testcompose.model.LoginRequest
import com.example.testcompose.model.LoginResponse

object UserService {
    private val api = ApiClient.retrofit.create(ApiService::class.java)

    suspend fun login(username: String, password: String): LoginResponse {
        return api.login(LoginRequest(username, password))
    }
}
