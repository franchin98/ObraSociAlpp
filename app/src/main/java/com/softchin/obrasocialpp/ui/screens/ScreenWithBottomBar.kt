package com.softchin.obrasocialpp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.softchin.obrasocialpp.ui.components.CusttomBottomAppBar

@Composable
fun ScreenWithBottomBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(bottomBar = { CusttomBottomAppBar(navController) }) { paddingValues ->
        content(paddingValues)
    }
}