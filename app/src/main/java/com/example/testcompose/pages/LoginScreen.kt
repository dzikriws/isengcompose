package com.example.testcompose.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import com.example.testcompose.service.UserService
import com.example.testcompose.utils.SessionManager
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val sessionManager = remember { SessionManager(context) }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    coroutineScope.launch {
                        if (email.isBlank() || password.isBlank()) {
                            snackbarHostState.showSnackbar("Email dan password harus diisi.")
                            return@launch
                        }

                        try {

//                            val response = UserService.login(email, password)
//                            sessionManager.saveUserSession(
//                                token = response.token,
//                                userId = response.userId,
//                                username = response.username
//                            )
//                            navController.navigate("home") {
//                                popUpTo("login") { inclusive = true }
//                            }
                            if (email == "admin" && password == "admin") {
                                sessionManager.saveUserSession(
                                    token = "dummy_token_123",
                                    userId = "1",
                                    username = "admin"
                                )
                                navController.navigate("home") {
                                    popUpTo("login") { inclusive = true }
                                }
                            }
                        } catch (e: HttpException) {
                            snackbarHostState.showSnackbar("Login gagal: ${e.message()}")
                        } catch (e: IOException) {
                            snackbarHostState.showSnackbar("Tidak dapat terhubung ke server.")
                            println(e)
                        } catch (e: Exception) {
                            snackbarHostState.showSnackbar("Terjadi kesalahan: ${e.localizedMessage}")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }
        }
    }
}
