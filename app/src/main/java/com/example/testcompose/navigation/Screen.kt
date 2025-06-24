package com.example.testcompose.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.testcompose.R

sealed class Screen(
    val route: String,
    val label: String,
    val iconVector: ImageVector? = null,
    @DrawableRes val iconResId: Int? = null
) {
    object Home : Screen("home", "Home", iconVector = Icons.Default.Home)
    object Promotion : Screen("promotion", "Promotion", iconVector = Icons.Default.Menu)
    object Qris : Screen("qris", "", iconResId = R.drawable.qr_code_scanner)
    object History : Screen("history", "History", iconResId = R.drawable.receipt_report)
    object Settings : Screen("settings", "Settings", iconVector = Icons.Default.Person)
}
