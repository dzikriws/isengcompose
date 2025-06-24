package com.example.testcompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Promotion : Screen("promotion", "Promotion", Icons.Default.Menu)
    object Qris : Screen("qris", "Qris", Icons.Default.Warning)
    object History : Screen("history", "History", Icons.Default.Add)
    object Settings : Screen("settings", "Settings", Icons.Default.Settings)
}
