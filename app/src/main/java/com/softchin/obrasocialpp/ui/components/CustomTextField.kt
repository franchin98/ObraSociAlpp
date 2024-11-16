package com.softchin.obrasocialpp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    placeHolderText: String,
    icon: ImageVector,
    iconDescription: String,
) {
    val inputTextColor = MaterialTheme.colorScheme.onSurface
    val textFieldContainerColor = MaterialTheme.colorScheme.inverseOnSurface
    val leadingIconColor = MaterialTheme.colorScheme.onSurface
    val placeHolderColor = MaterialTheme.colorScheme.outline


    TextField(
        value = text,
        onValueChange = { onTextChange(it) },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
            .clip(RoundedCornerShape(7.dp)),
        singleLine = true,
        placeholder = { Text(text = placeHolderText) },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription
            )
        },
        keyboardOptions = if (placeHolderText == "Correo electrónico") KeyboardOptions(keyboardType = KeyboardType.Email) else KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        colors = TextFieldDefaults.colors(
            focusedTextColor = inputTextColor,
            unfocusedTextColor = inputTextColor,
            disabledContainerColor = textFieldContainerColor,
            focusedContainerColor = textFieldContainerColor,
            unfocusedContainerColor = textFieldContainerColor,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            focusedLeadingIconColor = leadingIconColor,
            unfocusedLeadingIconColor = leadingIconColor,
            unfocusedPlaceholderColor = placeHolderColor,
            focusedPlaceholderColor = placeHolderColor
        )
    )
}