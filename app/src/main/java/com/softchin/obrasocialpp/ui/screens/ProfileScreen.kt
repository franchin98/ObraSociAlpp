package com.softchin.obrasocialpp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.softchin.obrasocialpp.R
import com.softchin.obrasocialpp.domain.Usuario
import com.softchin.obrasocialpp.ui.components.ProfileTextField
import com.softchin.obrasocialpp.ui.components.Screen
import com.softchin.obrasocialpp.ui.theme.bodyFontFamily

@Preview
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {
    val usuario = Usuario.getMock()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(
                    MaterialTheme.colorScheme.primaryContainer
                ),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            Box {
                IconButton(
                    onClick = {}, modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 10.dp)
                        .size(40.dp)
                        .background(
                            MaterialTheme.colorScheme.primary,
                            RoundedCornerShape(50)
                        )
                        .zIndex(100f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        modifier = Modifier.size(25.dp),
                        contentDescription = "Icono de Cámara",
                        tint = MaterialTheme.colorScheme.onSecondary,
                    )
                }
                AsyncImage(
                    model = "https://d1ccp1bhyyxewc.cloudfront.net/019305c1-5a19-7a50-a4b3-640ccf551676/square/crop/019305c1-6679-7636-b69c-6d9360e20c4a/i.jpg",
                    contentDescription = "Foto de Perfil",
                    placeholder = painterResource(id = R.drawable.profile_avatar_placeholder_large),
                    modifier = Modifier
                        .padding(20.dp)
                        .size(90.dp)
                        .clip(CircleShape)
                        .border(
                            1.dp,
                            MaterialTheme.colorScheme.primary,
                            CircleShape
                        )
                        .zIndex(90F)
                )
            }

            Text(
                text = "${usuario.nombre} ${usuario.apellido}",
                fontSize = 24.sp,
                fontFamily = bodyFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 45.dp, start = 8.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            modifier = Modifier.fillMaxSize()
        ) {

            Text(
                "Tus datos personales",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp , top = 18.dp, bottom = 8.dp),
                textAlign = TextAlign.Start,
                fontSize = 20.sp,
                fontFamily = bodyFontFamily
            )

            ProfileTextField(
                text = usuario.obraSocial.nombre,
                label = "Obra social",
                enabled = false
            )

            ProfileTextField(
                text = usuario.grupoSanguineo.nombre,
                label = "Grupo sanguíneo",
                readOnly = true
            )


            var email by remember { mutableStateOf(usuario.email) }
            var isEditable by remember { mutableStateOf(false) }

            ProfileTextField(
                text = email,
                label = "Correo electrónico",
                readOnly = !isEditable,
                icon = Icons.Default.Edit,
                onValueChange = { newEmail -> email = newEmail },
                onClickEditIcon = { isEditable = !isEditable }
            )

            var phone by remember { mutableStateOf(usuario.telefono) }

            ProfileTextField(
                text = phone,
                label = "Telefono",
                readOnly = !isEditable,
                icon = Icons.Default.Edit,
                onValueChange = { newPhone -> phone = newPhone },
                onClickEditIcon = { isEditable = !isEditable }
            )

            var city by remember { mutableStateOf(usuario.ciudad) }

            ProfileTextField(
                text = city,
                label = "Localidad",
                readOnly = !isEditable,
                icon = Icons.Default.Edit,
                onClickEditIcon = { isEditable = !isEditable },
                onValueChange = { newCity -> city = newCity }
            )

            Spacer(modifier = Modifier.size(100.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp)
                    .clickable { navController.navigate(Screen.LoginScreen.route) },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painter = painterResource(R.drawable.logout),
                    contentDescription = "Cerrar sesión",
                    modifier = Modifier
                        .rotate(180F)
                        .padding(horizontal = 15.dp),
                    tint = MaterialTheme.colorScheme.error
                )
                Text(
                    text = "Cerrar sesión",
                    fontSize = 20.sp,
                    fontFamily = bodyFontFamily,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}