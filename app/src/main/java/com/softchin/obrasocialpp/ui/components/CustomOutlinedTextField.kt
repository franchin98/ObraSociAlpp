package com.softchin.obrasocialpp.ui.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTouchIcon: () -> Unit = {},
    readOnly: Boolean = false,
    @DrawableRes drawableId: Int = 0
) {

    val primaryColor = MaterialTheme.colorScheme.primary
    val onPrimaryContainerColor = MaterialTheme.colorScheme.onPrimaryContainer

    OutlinedTextField(
        value = text,
        visualTransformation = visualTransformation,
        trailingIcon = {
            if (drawableId != 0) Icon(
                modifier = Modifier.size(35.dp).padding(end = 7.dp).clickable { onTouchIcon() },
                painter = painterResource(drawableId),
                contentDescription = "Icon"
            )
        },
        keyboardOptions = keyboardOptions,
        onValueChange = { onTextChange(it) },
        readOnly = readOnly,
        singleLine = true,
        label = { Text(label) },
        colors = TextFieldDefaults.colors(
            focusedLabelColor = primaryColor,
            unfocusedLabelColor = onPrimaryContainerColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp, vertical = 5.dp)
    )
}