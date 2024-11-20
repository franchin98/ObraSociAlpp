package com.softchin.obrasocialpp.ui.screens.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.softchin.obrasocialpp.domain.CentroResultado
import com.softchin.obrasocialpp.domain.FavoriteResultModel
import com.softchin.obrasocialpp.ui.components.CentroBusqueda
import com.softchin.obrasocialpp.ui.components.MyFavoriteItem
import com.softchin.obrasocialpp.ui.theme.displayFontFamily

@Preview
@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    val centros = CentroResultado.getMocks().filter { it.esFavorito }

    LazyColumn(
        modifier =
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
            .padding(bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Favoritos",
                    fontSize = 42.sp,
                    fontFamily = displayFontFamily,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(20.dp),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        items(centros) { item ->
            CentroBusqueda(item, navController = navController)
        }
    }
}