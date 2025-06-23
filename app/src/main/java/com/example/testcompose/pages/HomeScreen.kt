package com.example.testcompose.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testcompose.components.IconMenuGrid
import com.example.testcompose.components.MenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.Alignment

@Composable
fun HomeScreen(navController: NavController) {
    val menuItems = listOf(
        MenuItem("Pulsa", Icons.Default.Phone) {
            navController.navigate("pulsa")
        },
        MenuItem("Token", Icons.Default.Face) {
            navController.navigate("token")
        },
        MenuItem("Settings", Icons.Default.Settings) {
            navController.navigate("settings")
        } ,
        MenuItem("Settings", Icons.Default.Settings) {
            navController.navigate("settings")
        },
        MenuItem("Settings", Icons.Default.Settings) {
            navController.navigate("settings")
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to Home",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        IconMenuGrid( title = "Pembayaran",items = menuItems)
    }
}
