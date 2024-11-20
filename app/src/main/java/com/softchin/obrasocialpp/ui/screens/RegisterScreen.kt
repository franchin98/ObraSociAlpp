package com.softchin.obrasocialpp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.softchin.obrasocialpp.R
import com.softchin.obrasocialpp.domain.GrupoSanguineo
import com.softchin.obrasocialpp.domain.ObraSocial
import com.softchin.obrasocialpp.ui.components.CustomOutlinedTextField
import com.softchin.obrasocialpp.ui.theme.displayFontFamily

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer),
            horizontalArrangement = Arrangement.Center,
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                content = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Volver",
                        tint = MaterialTheme.colorScheme.primary,
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
                text = "Registro",
                textAlign = TextAlign.Center,
                fontSize = 42.sp,
                fontFamily = displayFontFamily,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(top = 20.dp, bottom = 20.dp, end = 30.dp)
                    .weight(10f),
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var name by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                text = name,
                onTextChange = { newText -> name = newText },
                label = "Nombres"
            )

            var lastName by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                text = lastName,
                onTextChange = { newText -> lastName = newText },
                label = "Apellidos"
            )

            var email by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                text = email,
                onTextChange = { newText -> email = newText },
                label = "Email",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            var password by remember { mutableStateOf("") }
            var touchViewPassword by remember { mutableStateOf(false) }

            CustomOutlinedTextField(
                text = password,
                onTextChange = { newText -> password = newText },
                label = "Clave",
                visualTransformation = if (!touchViewPassword) PasswordVisualTransformation() else VisualTransformation.None,
                onTouchIcon = { touchViewPassword = !touchViewPassword },
                drawableId = if (!touchViewPassword) R.drawable.visibilty else R.drawable.visibility_off
            )

            var phone by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                text = phone,
                onTextChange = { newText -> phone = newText },
                label = "Teléfono",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            var state by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                text = state,
                onTextChange = { newText -> state = newText },
                label = "Provincia"
            )

            var city by remember { mutableStateOf("") }

            CustomOutlinedTextField(
                text = city,
                onTextChange = { newText -> city = newText },
                label = "Ciudad"
            )

            var medicalPlan by remember { mutableStateOf("") }
            var tapDropDownMenu by remember { mutableStateOf(false) }

            CustomOutlinedTextField(
                modifier = Modifier.clickable { tapDropDownMenu = true },
                text = medicalPlan,
                onTextChange = { newText -> medicalPlan = newText },
                label = "Obra social",
                readOnly = true,
                onTouchIcon = { tapDropDownMenu = !tapDropDownMenu },
                drawableId = if (!tapDropDownMenu) R.drawable.keyboard_arrow_down else R.drawable.keyboard_arrow_up
            )

            val medicalPlans = ObraSocial.entries

            DropdownMenu(
                expanded = tapDropDownMenu,
                onDismissRequest = { tapDropDownMenu = !tapDropDownMenu },
                offset = DpOffset(x = 25.dp, y = 0.dp),
                modifier = Modifier.background(color = MaterialTheme.colorScheme.primaryContainer)
            ) {
                medicalPlans.forEach { currentMedicalPlan ->
                    DropdownMenuItem(
                        text = { Text(text = currentMedicalPlan.nombre) },
                        onClick = {
                            medicalPlan = currentMedicalPlan.nombre
                            tapDropDownMenu = !tapDropDownMenu
                        }
                    )
                }
            }

            var grupoSanguineo by remember { mutableStateOf("") }
            var tapDropDownMenuGrupoSanguineo by remember { mutableStateOf(false) }

            CustomOutlinedTextField(
                modifier = Modifier.clickable { tapDropDownMenuGrupoSanguineo = true },
                text = grupoSanguineo,
                onTextChange = { newText -> grupoSanguineo = newText },
                label = "Grupo Sanguíneo",
                readOnly = true,
                onTouchIcon = { tapDropDownMenuGrupoSanguineo = !tapDropDownMenuGrupoSanguineo },
                drawableId = if (!tapDropDownMenuGrupoSanguineo) R.drawable.keyboard_arrow_down else R.drawable.keyboard_arrow_up
            )

            val gruposSanguineos = GrupoSanguineo.entries

            DropdownMenu(
                expanded = tapDropDownMenuGrupoSanguineo,
                onDismissRequest = {
                    tapDropDownMenuGrupoSanguineo = !tapDropDownMenuGrupoSanguineo
                },
                offset = DpOffset(x = 25.dp, y = 0.dp),
                modifier = Modifier.background(color = MaterialTheme.colorScheme.primaryContainer)
            ) {
                gruposSanguineos.forEach { grupoSanguineoActual ->
                    DropdownMenuItem(
                        text = { Text(text = grupoSanguineoActual.nombre) },
                        onClick = {
                            grupoSanguineo = grupoSanguineoActual.nombre
                            tapDropDownMenuGrupoSanguineo = !tapDropDownMenuGrupoSanguineo
                        }
                    )
                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp, vertical = 10.dp),
                onClick = { },
                colors = androidx.compose.material.ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSurface
                )
            ) {
                Text(text = "Registrarme")
            }
        }
    }
}