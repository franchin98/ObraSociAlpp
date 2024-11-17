package com.softchin.obrasocialpp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val icon: ImageVector) {
    data object LoginScreen: Screen("Login", Icons.Default.Person)
    data object HomeScreen: Screen("Home", Icons.Default.Home)
    data object FavoritesScreen: Screen("Favorites", Icons.Default.Favorite)
    data object ProfileScreen: Screen("Profile", Icons.Default.Person)
}
