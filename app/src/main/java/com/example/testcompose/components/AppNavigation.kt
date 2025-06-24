package com.example.testcompose.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testcompose.pages.*

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
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen(isDarkMode, toggleTheme, navController) }
        composable("pulsa") { PulsaScreen(navController) }
        composable("token") { TokenScreen(navController) }
    }
}
