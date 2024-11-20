package com.softchin.obrasocialpp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ProfileTextField(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    icon: ImageVector? = null,
    onValueChange : (String) -> Unit = {},
    onClickEditIcon: () -> Unit = { }
) {
    TextField(
        value = text,
        onValueChange = { onValueChange(it) },
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
        label = { Text(label) },
        enabled = enabled,
        readOnly = readOnly,
        trailingIcon = {
            if (icon != null) Icon(
                imageVector = icon,
                contentDescription = "",
                modifier = Modifier.clickable { onClickEditIcon() })
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp)
            .padding(horizontal = 15.dp, vertical = 5.dp)
    )
}