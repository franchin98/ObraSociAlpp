package com.softchin.obrasocialpp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route: String, @Contextual val icon: ImageVector) {

    @Serializable
    data object LoginScreen: Screen("Login", Icons.Default.Person)

    @Serializable
    data object HomeScreen: Screen("Home", Icons.Default.Home)

    @Serializable
    data object FavoritesScreen: Screen("Favorites", Icons.Default.Favorite)

    @Serializable
    data object ProfileScreen: Screen("Profile", Icons.Default.Person)
}
