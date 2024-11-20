package com.softchin.obrasocialpp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    placeHolderText: String,
    icon: ImageVector,
    iconDescription: String,
    @DrawableRes trailingIcon: Int = 0,
    onClickViewPassword: () -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None
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
        visualTransformation = visualTransformation,
        placeholder = { Text(text = placeHolderText) },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription
            )
        },
        trailingIcon = { if (trailingIcon != 0) Icon(painter = painterResource(trailingIcon), contentDescription = "", modifier = Modifier.size(35.dp).padding(end = 7.dp).clickable { onClickViewPassword() }) },
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