package com.softchin.obrasocialpp.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun CusttomBottomAppBar(bottomNavController: NavController) {

    val screens = listOf(Screen.HomeScreen, Screen.FavoritesScreen, Screen.ProfileScreen)

    BottomNavigation(backgroundColor = MaterialTheme.colorScheme.primaryContainer) {

        val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
        val actualDestination = navBackStackEntry?.destination

        screens.forEach { currentScreen ->
            BottomNavigationItem(
                selected = actualDestination?.hierarchy?.any { it.route == currentScreen.route } == true,
                selectedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unselectedContentColor = MaterialTheme.colorScheme.onSecondary,
                icon = {
                    Icon(currentScreen.icon, contentDescription = null)
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