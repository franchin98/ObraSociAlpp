package com.softchin.obrasocialpp.ui.components

import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.softchin.obrasocialpp.R
import com.softchin.obrasocialpp.domain.FavoriteResultModel

@Composable
fun MyFavoriteItem(
    item: FavoriteResultModel,
    onClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
    ) {
        ListItem(
            modifier = Modifier.clickable(onClick = onClick),
            headlineContent = {
                Text(
                    item.name,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                )
            },
            supportingContent = {
                Text(
                    item.address,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            },
            leadingContent = {
                val imagePainter =
                    if (item.photoUrl.isNotEmpty()) {
                        rememberAsyncImagePainter(
                            ImageRequest
                                .Builder(LocalContext.current)
                                .data(item.photoUrl)
                                .apply {
                                    crossfade(true)
                                    transformations(CircleCropTransformation())
                                }.build(),
                        )
                    } else {
                        painterResource(id = R.drawable.loading)
                    }

                Image(
                    painter = imagePainter,
                    contentDescription = null,
                    modifier =
                    Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
            },
            trailingContent = {
                Column {
                    Text(
                        if (item.coveredByHealthInsurance) "Cubre Obra Social" else "Particular",
                        style = MaterialTheme.typography.labelSmall,
                    )
                }
            },
        )
        HorizontalDivider()
    }
}