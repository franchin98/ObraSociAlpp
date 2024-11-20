package com.softchin.obrasocialpp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.softchin.obrasocialpp.ui.components.Screen
import com.softchin.obrasocialpp.ui.screens.DetailsScreen
import com.softchin.obrasocialpp.ui.screens.HomeScreen
import com.softchin.obrasocialpp.ui.screens.LoginScreen
import com.softchin.obrasocialpp.ui.screens.ProfileScreen
import com.softchin.obrasocialpp.ui.screens.RegisterScreen
import com.softchin.obrasocialpp.ui.screens.ScreenWithBottomBar
import com.softchin.obrasocialpp.ui.screens.favorite.FavoriteScreen
import com.softchin.obrasocialpp.ui.theme.BusCartillaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusCartillaTheme {
                App()
            }
        }
    }

    @Composable
    private fun App() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.LoginScreen.route,
        ) {
            composable(route = Screen.LoginScreen.route) {
                LoginScreen(
                    onLoginSuccess = { navController.navigate(Screen.HomeScreen.route) },
                    onClickRegister = { navController.navigate(Screen.RegisterScreen) },
                    onClickContinueAsGuest = { navController.navigate(Screen.HomeScreen.route) }
                )
            }

            composable<Screen.RegisterScreen>(enterTransition = { slideInHorizontally()}) {
                RegisterScreen()
            }

            composable(
                route = Screen.HomeScreen.route,
                enterTransition = { slideInHorizontally() }
            ) {
                ScreenWithBottomBar(navController = navController) {
                    HomeScreen(navController = navController)
                }
            }

            composable(
                route = "${Screen.DetailsScreen.route}/{centroId}",
                arguments = listOf(navArgument("centroId") { type = NavType.IntType }),
                enterTransition = { slideInHorizontally() }
            ) { backStackEntry ->
                val centroId = backStackEntry.arguments?.getInt("centroId") ?: 1
                ScreenWithBottomBar(navController = navController) {
                    DetailsScreen(centroId = centroId, navController = navController)
                }
            }

            composable(
                route = Screen.FavoritesScreen.route,
                enterTransition = { slideInHorizontally() }) {
                ScreenWithBottomBar(navController = navController) {
                    FavoriteScreen()
                }
            }

            composable(
                route = Screen.ProfileScreen.route,
                enterTransition = { slideInHorizontally() }
            ) {
                ScreenWithBottomBar(navController = navController) {
                    ProfileScreen(navController = navController)
                }
            }
        }
    }
}