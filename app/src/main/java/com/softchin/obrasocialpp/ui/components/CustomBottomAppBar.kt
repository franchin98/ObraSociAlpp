package com.softchin.obrasocialpp.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun CusttomBottomAppBar(bottomNavController: NavController) {

    val screens = listOf(Screen.HomeScreen, Screen.HealthScreen)

    BottomNavigation {

        val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
        val actualDestination = navBackStackEntry?.destination

        screens.forEach { currentScreen ->
            BottomNavigationItem(
                selected = actualDestination?.hierarchy?.any { it.route == currentScreen.route } == true,
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.White,
                icon = {
                    when (currentScreen) {
                        is Screen.HomeScreen -> {
                            Icon(Icons.Outlined.Home, contentDescription = null)
                        }

                        is Screen.HealthScreen -> {
                            Icon(Icons.Outlined.Favorite, contentDescription = null)
                        }
                    }
                },

                onClick = {
                    bottomNavController.navigate(currentScreen.route) {
                        popUpTo(bottomNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}