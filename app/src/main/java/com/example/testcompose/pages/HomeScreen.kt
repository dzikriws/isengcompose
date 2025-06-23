package com.example.testcompose.pages

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testcompose.components.IconMenuGrid
import com.example.testcompose.components.MenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.example.testcompose.components.TopNavBar
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    val menuItemsPembayaran = listOf(
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

    val menuItemsPembayaran2 = listOf(
        MenuItem("Pulsa", Icons.Default.Phone) {
            navController.navigate("pulsa")
        },
        MenuItem("Token", Icons.Default.Face) {
            navController.navigate("token")
        },
        MenuItem("Settings", Icons.Default.Settings) {
            navController.navigate("settings")
        }
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        TopNavBar()

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            IconMenuGrid(title = "Pembayaran", items = menuItemsPembayaran)
            IconMenuGrid(title = "Pembayaran", items = menuItemsPembayaran)
            IconMenuGrid(title = "Pembayaran", items = menuItemsPembayaran)
            IconMenuGrid(title = "Tagihan", items = menuItemsPembayaran2)
        }
    }
}
