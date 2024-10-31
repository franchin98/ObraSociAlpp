package com.softchin.obrasocialpp.ui.components

sealed class Screen(val route: String,) {
    data object HomeScreen: Screen("Home")
    data object HealthScreen: Screen("Health")
}
