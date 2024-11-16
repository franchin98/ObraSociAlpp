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
import com.softchin.obrasocialpp.ui.components.CustomBottomAppBar
import com.softchin.obrasocialpp.ui.components.Screen
import com.softchin.obrasocialpp.ui.screens.HealthScreen
import com.softchin.obrasocialpp.ui.screens.search.SearchViewModel
import com.softchin.obrasocialpp.ui.screens.search.SearchScreen
import com.softchin.obrasocialpp.ui.theme.ObraSociALppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ObraSociALppTheme {
                App()
            }
        }
    }


    @Composable
    private fun App() {
        val navController = rememberNavController()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { CustomBottomAppBar(bottomNavController = navController) }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Screen.HomeScreen.route
            ) {
                composable(Screen.HomeScreen.route, enterTransition = { slideInVertically() }) {
                   // HomeScreen(modifier = Modifier.padding(innerPadding))
                    val search = SearchViewModel()
                    SearchScreen(search)
                }

                composable(Screen.HealthScreen.route, enterTransition = { slideInHorizontally() }) {
                    HealthScreen(modifier = Modifier.padding(innerPadding))
                }

                composable(Screen.SearchScreen.route){
                    val search = SearchViewModel()
                    SearchScreen(search)
                }
            }
        }
    }
}