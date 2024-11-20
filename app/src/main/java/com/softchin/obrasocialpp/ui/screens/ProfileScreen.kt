package com.softchin.obrasocialpp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.softchin.obrasocialpp.R
import com.softchin.obrasocialpp.domain.Usuario
import com.softchin.obrasocialpp.ui.components.Screen
import com.softchin.obrasocialpp.ui.theme.bodyFontFamily
import com.softchin.obrasocialpp.ui.theme.displayFontFamily

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, navController: NavController) {
    val usuario = Usuario.getMock()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Mi perfil",
                fontSize = 42.sp,
                fontFamily = displayFontFamily,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            Spacer(modifier = Modifier.size(100.dp))
            Box() {
                IconButton(
                    onClick = {}, modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .background(
                            MaterialTheme.colorScheme.primaryContainer,
                            RoundedCornerShape(50)
                        )
                        .zIndex(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Icono de Cámara",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
                AsyncImage(
                    model = "https://d1ccp1bhyyxewc.cloudfront.net/019305c1-5a19-7a50-a4b3-640ccf551676/square/crop/019305c1-6679-7636-b69c-6d9360e20c4a/i.jpg",
                    contentDescription = "Foto de Perfil",
                    placeholder = painterResource(id = R.drawable.profile_avatar_placeholder_large),
                    modifier = Modifier
                        .padding(20.dp)
                        .size(180.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .border(
                            4.dp,
                            MaterialTheme.colorScheme.primaryContainer,
                            RoundedCornerShape(10.dp)
                        )
                )
            }
            Text(
                text = "${usuario.nombre} ${usuario.apellido}",
                fontSize = 24.sp,
                fontFamily = bodyFontFamily,
                modifier = Modifier.padding(5.dp)
            )
            Text(
                text = "Obra Social: ${usuario.obraSocial.nombre}",
                fontSize = 16.sp,
                fontFamily = bodyFontFamily
            )
            Text(
                text = "Grupo Sanguíneo: ${usuario.grupoSanguineo.nombre}",
                fontSize = 16.sp,
                fontFamily = bodyFontFamily
            )
            Text(text = "Email: ${usuario.email}", fontSize = 16.sp, fontFamily = bodyFontFamily)
            Text(
                text = "Localidad: ${usuario.ciudad}, ${usuario.provincia}",
                fontSize = 16.sp,
                fontFamily = bodyFontFamily
            )
            Text(text = "Favoritos: 5", fontSize = 16.sp, fontFamily = bodyFontFamily)
            Spacer(modifier = Modifier.size(100.dp))
            TextButton(
                colors = ButtonColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.error,
                    disabledContainerColor = MaterialTheme.colorScheme.inversePrimary,
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                onClick = { navController.navigate(Screen.LoginScreen.route) },
                modifier = Modifier
                    .height(70.dp)
                    .width(280.dp)
            ) {
                Text(text = "Cerrar sesión", fontSize = 20.sp, fontFamily = bodyFontFamily)
            }
        }
    }
}