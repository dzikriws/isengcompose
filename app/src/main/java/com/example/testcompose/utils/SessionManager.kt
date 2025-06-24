package com.example.testcompose.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("user_session", Context.MODE_PRIVATE)

    fun saveUserSession(token: String, userId: String, username: String) {
        prefs.edit().apply {
            putString("token", token)
            putString("userId", userId)
            putString("username", username)
            apply()
        }
    }

    fun isLoggedIn(): Boolean {
        return !prefs.getString("token", null).isNullOrEmpty()
    }

    fun clearSession() {
        prefs.edit().clear().apply()
    }
}
