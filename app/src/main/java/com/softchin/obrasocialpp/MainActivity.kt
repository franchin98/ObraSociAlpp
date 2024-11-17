package com.softchin.obrasocialpp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.softchin.obrasocialpp.ui.components.CusttomBottomAppBar
import com.softchin.obrasocialpp.ui.components.Screen
import com.softchin.obrasocialpp.ui.screens.HealthScreen
import com.softchin.obrasocialpp.ui.screens.HomeScreen
import com.softchin.obrasocialpp.ui.screens.LoginScreen
import com.softchin.obrasocialpp.ui.screens.ProfileScreen
import com.softchin.obrasocialpp.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                App()
            }
        }
    }

    @Composable
    private fun App() {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { CusttomBottomAppBar(bottomNavController = navController) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.LoginScreen.route
            ) {
                composable(Screen.LoginScreen.route) {
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }

                composable(Screen.HomeScreen.route, enterTransition = { slideInHorizontally() }) {
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }

                composable(Screen.FavoritesScreen.route, enterTransition = { slideInHorizontally() }) {
                    HealthScreen(modifier = Modifier.padding(innerPadding))
                }

                composable(Screen.ProfileScreen.route, enterTransition = { slideInHorizontally() }) {
                    ProfileScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}