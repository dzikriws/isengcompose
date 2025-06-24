package com.example.testcompose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testcompose.pages.*
import com.example.testcompose.pages.home.PulsaScreen
import com.example.testcompose.pages.home.TokenScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    isDarkMode: Boolean,
    toggleTheme: () -> Unit,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("login") {LoginScreen((navController))}
        composable("home") { HomeScreen(navController) }
        composable("qris") { QrisScreen() }
        composable("settings") { SettingsScreen(isDarkMode, toggleTheme, navController) }
        composable("pulsa") { PulsaScreen(navController) }
        composable("token") { TokenScreen(navController) }
        composable("promotion") { PromotionScreen(navController) }
        composable("history") { HistoryScreen(navController) }
    }
}
