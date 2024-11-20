package com.softchin.obrasocialpp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.softchin.obrasocialpp.R
import com.softchin.obrasocialpp.domain.ReseniaCentro

@Composable
fun ReseniaDetalle(reseniaCentro: ReseniaCentro) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            //.background(color = MaterialTheme.colorScheme.secondaryContainer)
            //.border(2.dp, MaterialTheme.colorScheme.onSecondaryContainer, RoundedCornerShape(10.dp))
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            model = reseniaCentro.avatar,
            placeholder = painterResource(id = R.drawable.profile_avatar_placeholder_large),
            contentDescription = "Usuario",
            modifier = Modifier
                .size(50.dp)
                .padding(5.dp)
                .fillMaxSize()
                .weight(1f)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(6f)) {
            Text(
                text = reseniaCentro.usuario,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = reseniaCentro.resenia,
                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 18.sp
            )
        }
    }
}