package com.example.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.testcompose.components.BottomNavBar
import com.example.testcompose.components.AppNavigation
import com.example.testcompose.navigation.Screen
import com.example.testcompose.ui.theme.*
import androidx.compose.ui.platform.LocalContext
import com.example.testcompose.components.TopNavBar
import com.example.testcompose.utils.SessionManager


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }

            Theme(useDarkTheme = isDarkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(
                        isDarkMode = isDarkMode,
                        toggleTheme = { isDarkMode = !isDarkMode }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    isDarkMode: Boolean,
    toggleTheme: () -> Unit
) {
    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }
    val isLoggedIn = remember { sessionManager.isLoggedIn() }

    val navController = rememberNavController()

    val startDestination = if (isLoggedIn) "home" else "login"

    val navScreens = listOf(Screen.Home, Screen.Promotion, Screen.Qris, Screen.History, Screen.Settings)
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val showBar = navScreens.any { it.route == currentRoute }

    Scaffold(
        topBar = {
            if (showBar) {
                TopNavBar()
            }
        },
        bottomBar = {
            if (showBar) {
                BottomNavBar(navController = navController, items = navScreens)
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) { padding ->
        AppNavigation(
            navController = navController,
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            isDarkMode = isDarkMode,
            toggleTheme = toggleTheme,
            startDestination = startDestination
        )
    }
}
