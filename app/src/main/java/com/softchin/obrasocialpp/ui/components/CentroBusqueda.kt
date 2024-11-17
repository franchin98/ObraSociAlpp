package com.softchin.obrasocialpp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softchin.obrasocialpp.domain.CentroResultado
import com.softchin.obrasocialpp.utils.StringUtils

@Preview(showBackground = true)
@Composable
fun CentroBusqueda(centro: CentroResultado = CentroResultado.getMock()) {
    val obrasSociales = StringUtils.getObrasSociales(centro.obrasSociales)

    Row {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            ),
            modifier = Modifier.padding(10.dp)
        ) {
            Column(Modifier.padding(10.dp)) {
                Text(
                    text = centro.nombre,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSecondary
                )
                Text(centro.ubicacion, fontSize = 15.sp, color = MaterialTheme.colorScheme.onSecondary)
                Text(centro.horarios, fontSize = 15.sp, color = MaterialTheme.colorScheme.onSecondary)
                Text(obrasSociales, fontSize = 15.sp, color = MaterialTheme.colorScheme.onSecondary)
            }
        }
    }
}