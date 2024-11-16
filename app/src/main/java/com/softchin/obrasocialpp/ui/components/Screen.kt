package com.softchin.obrasocialpp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector) {
    data object HomeScreen: Screen("Home", Icons.Default.Home)
    data object HealthScreen: Screen("Health", Icons.Default.Favorite)
    data object LoginScreen: Screen("Login", Icons.Default.Person)
}
