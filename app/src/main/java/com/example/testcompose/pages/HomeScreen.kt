package com.example.testcompose.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to Home", style = MaterialTheme.typography.headlineSmall)

        Button(onClick = { navController.navigate("pulsa") }) {
            Text("Bayar Pulsa")
        }

        Button(onClick = { navController.navigate("token") }) {
            Text("Token Listrik")
        }
    }
}
