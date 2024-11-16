package com.softchin.obrasocialpp.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProviderAuthButton(
    modifier: Modifier = Modifier,
    textProvider: String,
    painter: Int
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 17.dp)
            .border(Dp.Hairline, color = MaterialTheme.colorScheme.outline, shape = CircleShape)
            .clickable { },
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            painter = painterResource(id = painter),
            contentDescription = "",
            modifier = Modifier
                .padding(start = 12.dp)
                .size(30.dp)
        )

        Text(
            text = textProvider,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
    }
}