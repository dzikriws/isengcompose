package com.example.testcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.testcompose.navigation.Screen

@Composable
fun BottomNavBar(
    navController: NavController,
    items: List<Screen>
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    val isOdd = items.size % 2 != 0
    val middleIndex = if (isOdd) items.size / 2 else -1

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        items.forEachIndexed { index, screen ->
            val isSelected = currentRoute == screen.route

            val iconModifier = if (isOdd && index == middleIndex) {
                Modifier
                    .size(48.dp)
                    .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f), CircleShape)
                    .padding(8.dp)
            } else {
                Modifier.size(24.dp)
            }

            NavigationBarItem(
                icon = {
                    when {
                        screen.iconResId != null -> {
                            Icon(
                                painter = painterResource(id = screen.iconResId),
                                contentDescription = screen.label,
                                tint = LocalContentColor.current,
                                modifier = iconModifier
                            )
                        }
                        screen.iconVector != null -> {
                            Icon(
                                imageVector = screen.iconVector,
                                contentDescription = screen.label,
                                modifier = iconModifier
                            )
                        }
                    }
                },
                label = { Text(screen.label) },
                selected = isSelected,
                onClick = {
                    if (!isSelected) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            )
        }
    }
}
