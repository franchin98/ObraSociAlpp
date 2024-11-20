package com.softchin.obrasocialpp.ui.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun ModalResenia(
    onDismissRequest: () -> Unit = {}
) {
    val context = LocalContext.current

    Dialog(
        onDismissRequest = {
            onDismissRequest()
        },
        content = {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(width = 400.dp, height = 300.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.secondaryContainer)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Escribir Reseña",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.secondary,
                    fontFamily = MaterialTheme.typography.displayLarge.fontFamily,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp),
                    label = { Text(text = "Reseña", color = MaterialTheme.colorScheme.secondary) },
                    leadingIcon = {
                        Icon(Icons.Filled.Edit, contentDescription = "Edit")
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = MaterialTheme.colorScheme.onSecondary,
                        backgroundColor = MaterialTheme.colorScheme.onSecondary,
                        focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                        unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    TextButton(
                        onClick = {
                            onDismissRequest()
                        },
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
//                            .background(color = MaterialTheme.colorScheme.secondary)
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.secondary,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .width(100.dp)
                    ) {
                        Text(
                            text = "Cerrar",
                            color = MaterialTheme.colorScheme.secondary,
                            fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(50.dp))
                    TextButton(
                        onClick = {
                            Toast.makeText(context, "Reseña enviada", Toast.LENGTH_SHORT).show()
                            onDismissRequest()
                        },
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
//                            .background(color = MaterialTheme.colorScheme.secondary)
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.secondary,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .width(100.dp)
                    ) {
                        Text(
                            text = "Enviar", color = MaterialTheme.colorScheme.secondary,
                            fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        },
    )
}