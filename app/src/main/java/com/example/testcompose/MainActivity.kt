package com.example.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.example.testcompose.ui.theme.BottomNav
import com.example.testcompose.pages.*
import com.example.testcompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }

            Theme(useDarkTheme = isDarkMode) {
                BottomNav {
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
    val navController = rememberNavController()
    val items = listOf(Screen.Home, Screen.Profile, Screen.Settings)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
                    items.forEach { screen ->
                        NavigationBarItem(
                            icon = { Icon(screen.icon, contentDescription = screen.label) },
                            label = { Text(screen.label) },
                            selected = currentDestination == screen.route,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId)
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                }
            },
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                composable(Screen.Home.route) { HomeScreen() }
                composable(Screen.Profile.route) { ProfileScreen() }
                composable(Screen.Settings.route) {
                    SettingsScreen(isDarkMode = isDarkMode, toggleTheme = toggleTheme)
                }
            }
        }
    }
}



sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    data object Home : Screen("home", "Home", Icons.Default.Home)
    data object Profile : Screen("profile", "Profile", Icons.Default.Person)
    data object Settings : Screen("settings", "Settings", Icons.Default.Settings)
}
