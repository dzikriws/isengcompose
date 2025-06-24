package com.example.testcompose.service

import android.content.Context
import com.example.testcompose.model.user.LoginRequest
import com.example.testcompose.model.user.LoginResponse

class UserService(private val context: Context) {
    private val api = ApiClient.create(context).create(ApiService::class.java)

    suspend fun login(username: String, password: String): LoginResponse {
        return api.login(LoginRequest(username, password))
    }
}
