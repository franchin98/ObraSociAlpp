package com.softchin.obrasocialpp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
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
import com.softchin.obrasocialpp.domain.ReseniaCentro
import com.softchin.obrasocialpp.ui.components.ModalResenia
import com.softchin.obrasocialpp.ui.components.ReseniaDetalle

@Composable
fun DetailsScreen(centroId: Int = 1, navController: NavController) {
    val centro = CentroResultado.getMocks().find { it.id == centroId }!!
    val obrasSociales = centro.obrasSociales.joinToString(", ") { it.nombre }
    val resenias = ReseniaCentro.getMocks()
    val mostrarModalResenia = remember { mutableStateOf(false) }

    fun toggleModal() {
        mostrarModalResenia.value = !mostrarModalResenia.value
    }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { toggleModal() },
                icon = {
                    Icon(
                        Icons.Filled.Edit,
                        "Reseña",
                        tint = MaterialTheme.colorScheme.secondary
                    )
                },
                text = {
                    Text(
                        text = "Reseña",
                        fontFamily = MaterialTheme.typography.displaySmall.fontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                },
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .offset(x = 2.dp, y = (-60).dp)
            )
        }, content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
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
                                modifier = Modifier
                                    .size(40.dp)
                                    .padding(start = 10.dp),
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
                LazyColumn(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.onSecondary)
                        .padding(start = 20.dp, end = 20.dp, bottom = 60.dp)
                ) {
                    item {
                        Spacer(modifier = Modifier.padding(10.dp))
                        AsyncImage(
                            model = centro.foto,
                            placeholder = painterResource(
                                R.drawable.hospital_placeholder_512x512_1
                            ),
                            contentScale = ContentScale.FillWidth,
                            contentDescription = "Imagen del centro",
                            modifier = Modifier
                                .size(500.dp, 250.dp)
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
                        Text(
                            text = centro.descripcion,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                        Column(
                            modifier = Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .fillMaxWidth()
                                .background(MaterialTheme.colorScheme.onSecondaryContainer)
                                .padding(10.dp)
                        ) {
                            Row {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "Horarios",
                                    tint = MaterialTheme.colorScheme.secondaryContainer
                                )
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(
                                    "Ubicación",
                                    fontSize = 20.sp,
                                    color = MaterialTheme.colorScheme.secondaryContainer,
                                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily
                                )
                            }
                            Text(
                                centro.ubicacion,
                                fontSize = 15.sp,
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .padding(1.dp)
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
                            Row {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = "Horarios",
                                    tint = MaterialTheme.colorScheme.secondaryContainer
                                )
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(
                                    "Horarios",
                                    fontSize = 20.sp,
                                    color = MaterialTheme.colorScheme.secondaryContainer,
                                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily
                                )
                            }
                            Text(
                                centro.horarios,
                                fontSize = 15.sp,
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                                modifier = Modifier
                                    .padding(1.dp)
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
                            Row {
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.health_and_safety_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                                    contentDescription = "Horarios",
                                    tint = MaterialTheme.colorScheme.secondaryContainer
                                )
                                Spacer(modifier = Modifier.padding(2.dp))
                                Text(
                                    "Obras Sociales / Prepagas",
                                    fontSize = 20.sp,
                                    color = MaterialTheme.colorScheme.secondaryContainer,
                                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily
                                )
                            }
                            Text(
                                obrasSociales,
                                fontSize = 15.sp,
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .padding(1.dp)
                            )
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        Text(
                            text = "Reseñas",
                            fontSize = 30.sp,
                            color = MaterialTheme.colorScheme.secondary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            fontFamily = MaterialTheme.typography.displayMedium.fontFamily,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                    }
                    items(items = resenias) {
                        ReseniaDetalle(it)
                        HorizontalDivider(
                            color = MaterialTheme.colorScheme.secondaryContainer
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                    }
                }
            }
            if(mostrarModalResenia.value) {
                ModalResenia(
                    onDismissRequest = { mostrarModalResenia.value = false },
                )
            }
        }
    )
}