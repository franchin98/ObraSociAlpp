package com.softchin.obrasocialpp.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.softchin.obrasocialpp.R
import com.softchin.obrasocialpp.domain.CentroResultado
import com.softchin.obrasocialpp.ui.theme.bodyFontFamily
import com.softchin.obrasocialpp.ui.theme.displayFontFamily
import com.softchin.obrasocialpp.utils.StringUtils

@Preview(showBackground = true)
@Composable
fun CentroHome(
    centro: CentroResultado = CentroResultado.getMock(),
    mostrarFoto: Boolean = true,
    navController: NavController = rememberNavController()
) {
    val obrasSociales = StringUtils.getObrasSociales(centro.obrasSociales)
    var modifier = Modifier.padding(5.dp)

    if (centro.coincideObraSocial)
        modifier = modifier.border(
            5.dp,
            MaterialTheme.colorScheme.primaryContainer,
            RoundedCornerShape(10.dp)
        )

    Row {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainer,
                contentColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            modifier = modifier.clickable {
                navController.navigate(
                    "${Screen.DetailsScreen.route}/${centro.id}"
                )
            }
        ) {
            Column(Modifier.padding(10.dp)) {
                Text(
                    text = centro.nombre,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontFamily = MaterialTheme.typography.displayMedium.fontFamily
                )
                if (mostrarFoto) {
                    Spacer(modifier = Modifier.padding(5.dp))
                    AsyncImage(
                        model = centro.foto,
                        placeholder = painterResource(
                            R.drawable.hospital_placeholder_512x512_1
                        ),
                        contentDescription = "Imagen del centro",
                        modifier = Modifier
                            .clip(RoundedCornerShape(size = 10.dp))
                            .padding(bottom = 5.dp)
                            .size(width = 300.dp, height = 200.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Horarios",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        centro.ubicacion,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontFamily = MaterialTheme.typography.bodySmall.fontFamily
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.schedule_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                        contentDescription = "Horarios",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        centro.horarios,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontFamily = MaterialTheme.typography.bodySmall.fontFamily
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.health_and_safety_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                        contentDescription = "Horarios",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        obrasSociales,
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontFamily = MaterialTheme.typography.bodySmall.fontFamily
                    )
                }
            }
        }
    }
}