package com.softchin.obrasocialpp.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.softchin.obrasocialpp.R
import com.softchin.obrasocialpp.ui.theme.bodyFontFamily
import com.softchin.obrasocialpp.ui.theme.displayFontFamily

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Mi perfil",
            fontSize = 42.sp,
            fontFamily = displayFontFamily,
            modifier = Modifier.padding(20.dp)
        )
        Spacer(modifier = Modifier.size(100.dp))
        AsyncImage(
            model = "https://d1ccp1bhyyxewc.cloudfront.net/019305c1-5a19-7a50-a4b3-640ccf551676/square/crop/019305c1-6679-7636-b69c-6d9360e20c4a/i.jpg",
            contentDescription = "Foto de Perfil",
            placeholder = painterResource(id = R.drawable.profile_avatar_placeholder_large),
            modifier = Modifier
                .padding(20.dp)
                .size(180.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(10.dp))
        )
        Text(
            text = "Hernán Marrapodi",
            fontSize = 24.sp,
            fontFamily = bodyFontFamily,
            modifier = Modifier.padding(5.dp)
        )
        Text(text = "Obra Social: OSECAC", fontSize = 16.sp, fontFamily = bodyFontFamily)
        Text(text = "Favoritos: 3", fontSize = 16.sp, fontFamily = bodyFontFamily)
        Spacer(modifier = Modifier.size(100.dp))
        TextButton(
            colors = ButtonColors(
                containerColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
                disabledContainerColor = MaterialTheme.colors.primaryVariant,
                disabledContentColor = MaterialTheme.colors.onPrimary
            ),
            onClick = { navController.navigate("login") },
            modifier = Modifier
                .height(70.dp)
                .width(280.dp)
        ) {
            Text(text = "Cerrar sesión", fontSize = 20.sp, fontFamily = bodyFontFamily)
        }
    }
}