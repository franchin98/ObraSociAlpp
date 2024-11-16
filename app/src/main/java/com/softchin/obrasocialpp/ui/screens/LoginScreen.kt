package com.softchin.obrasocialpp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.softchin.obrasocialpp.R
import com.softchin.obrasocialpp.ui.components.CustomTextField
import com.softchin.obrasocialpp.ui.components.ProviderAuthButton

@Preview
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.app_logo),
            contentDescription = "Logo Buscartilla",
            modifier = Modifier
                .size(300.dp)
                .padding(20.dp)
        )

        var emailInput by remember { mutableStateOf("") }
        var passwordInput by remember { mutableStateOf("") }

        CustomTextField(
            modifier = Modifier.padding(vertical = 12.dp),
            text = emailInput,
            onTextChange = { newText -> emailInput = newText },
            placeHolderText = "Correo electrónico",
            icon = Icons.Default.Email,
            iconDescription = "Ícono de email"
        )

        CustomTextField(
            modifier = Modifier.padding(vertical = 12.dp),
            text = passwordInput,
            onTextChange = { newText -> passwordInput = newText },
            placeHolderText = "Clave",
            icon = Icons.Default.Lock,
            iconDescription = "Ícono de clave"
        )

        HorizontalDivider(
            modifier = Modifier.padding(top = 10.dp, bottom = 20.dp)
        )

        ProviderAuthButton(
            textProvider = "Continuar con Google",
            painter = R.drawable.google_logo
        )

        ProviderAuthButton(
            modifier = Modifier.padding(top = 12.dp),
            textProvider = "Continuar con Facebook",
            painter = R.drawable.facebook_3_2
        )

        Row(modifier = Modifier.padding(top = 33.dp)) {
            Text("¿No tienes una cuenta?")
            Text("Registrate.",
                modifier = Modifier
                    .padding(start = 2.dp)
                    .clickable { TODO("Navegar a Pantalla de Registro") },
                fontWeight = FontWeight.SemiBold
            )
        }

        Text("o", modifier = Modifier.padding(top = 5.dp))

        Text("Continuar como invitado.", modifier = Modifier.padding(top = 5.dp))

    }
}