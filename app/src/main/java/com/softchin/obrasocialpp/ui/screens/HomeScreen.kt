package com.softchin.obrasocialpp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softchin.obrasocialpp.R
import com.softchin.obrasocialpp.domain.CentroResultado
import com.softchin.obrasocialpp.ui.components.CentroBusqueda
import com.softchin.obrasocialpp.ui.components.CentroHome
import com.softchin.obrasocialpp.ui.components.SearchBox
import com.softchin.obrasocialpp.ui.theme.bodyFontFamily
import com.softchin.obrasocialpp.ui.theme.displayFontFamily

@Preview
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val centros = CentroResultado.getMocks()

    Column(
        modifier = modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(5.dp))
        SearchBox()
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Bienvenido, Hernán",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 28.sp,
            fontFamily = MaterialTheme.typography.displayLarge.fontFamily
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Tus centros más cercanos",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            fontFamily = MaterialTheme.typography.displayMedium.fontFamily
        )
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow {
            items(centros) {
                CentroHome(it)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Centros que atienden tu Obra Social",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 20.sp,
            fontFamily = MaterialTheme.typography.displayMedium.fontFamily
        )
        Spacer(modifier = Modifier.height(2.dp))
        LazyRow {
            items(centros) {
                CentroHome(it, false)
            }
        }
    }
}