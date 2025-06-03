package com.example.testcompose.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    isDarkMode: Boolean,
    toggleTheme: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Dark Mode is ${if (isDarkMode) "ON" else "OFF"}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = toggleTheme) {
            Text("Toggle Dark Mode")
        }
    }
}