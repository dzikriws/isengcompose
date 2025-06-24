package com.example.testcompose.service

import com.example.testcompose.model.user.LoginRequest
import com.example.testcompose.model.user.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}
