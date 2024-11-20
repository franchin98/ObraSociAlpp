package com.softchin.obrasocialpp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.softchin.obrasocialpp.R
import com.softchin.obrasocialpp.domain.CentroResultado

@Composable
fun DetailsScreen(centroId: Int = 1, navController: NavController) {
    val centro = CentroResultado.getMocks().find { it.id == centroId }!!
    val obrasSociales = centro.obrasSociales.joinToString(", ") { it.nombre }
    var offset by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                orientation = Orientation.Vertical,
                state = rememberScrollableState { delta ->
                    offset += delta
                    delta
                })
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                content = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(40.dp).padding(start = 10.dp),
                    )
                },
                modifier = Modifier
                    .zIndex(1f)
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            )
            Text(
                text = centro.nombre,
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(top = 20.dp, bottom = 20.dp, end = 30.dp)
                    .weight(10f)
            )
        }
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Spacer(modifier = Modifier.padding(10.dp))
            AsyncImage(
                model = centro.foto,
                placeholder = painterResource(
                    R.drawable.hospital_placeholder_512x512_1
                ),
                contentDescription = "Imagen del centro",
                modifier = Modifier
                    .size(width = 500.dp, height = maxOf(200.dp, Dp.Unspecified))
                    .padding(bottom = 5.dp)
                    .clip(RoundedCornerShape(size = 10.dp))
                    .border(
                        8.dp,
                        MaterialTheme.colorScheme.secondaryContainer,
                        RoundedCornerShape(10.dp)
                    )
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
                    .padding(10.dp)
            ) {
                Text(
                    "Ubicación",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    centro.ubicacion,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .padding(10.dp)
                )
            }
            Spacer(modifier = Modifier.padding(1.dp))
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
                    .padding(10.dp)
            ) {
                Text(
                    "Horarios",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    centro.horarios,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .padding(10.dp)
                )
            }
            Spacer(modifier = Modifier.padding(1.dp))
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
                    .padding(10.dp)
            ) {
                Text(
                    "Obras Sociales / Prepagas",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    obrasSociales,
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                        .padding(10.dp)
                )
            }
        }
    }
}