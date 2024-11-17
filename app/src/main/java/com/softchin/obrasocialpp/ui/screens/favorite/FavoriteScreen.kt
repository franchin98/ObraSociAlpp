package com.softchin.obrasocialpp.ui.screens.favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.softchin.obrasocialpp.domain.FavoriteResultModel
import com.softchin.obrasocialpp.ui.components.MyFavoriteItem

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier) {
//    val viewModel: FavoriteViewModel
    val list =
        listOf(
            FavoriteResultModel(
                name = "Hospital 1",
                address = "Av. Siempre viva 123",
                coveredByHealthInsurance = true,
                photoUrl = ""
            ),
            FavoriteResultModel(
                name = "Hospital 2",
                address = "Av. Siempre viva 123",
                coveredByHealthInsurance = true,
                photoUrl = ""
            ),
            FavoriteResultModel(
                name = "Hospital 3",
                address = "Av. Siempre viva 123",
                coveredByHealthInsurance = true,
                photoUrl = ""
            ),
            FavoriteResultModel(
                name = "Hospital 4",
                address = "Av. Siempre viva 123",
                coveredByHealthInsurance = false,
                photoUrl = ""
            ),
            FavoriteResultModel(
                name = "Hospital 5",
                address = "Av. Siempre viva 123",
                coveredByHealthInsurance = false,
                photoUrl = ""
            ),
            FavoriteResultModel(
                name = "Hospital 6",
                address = "Av. Siempre viva 123",
                coveredByHealthInsurance = true,
                photoUrl = ""
            ),
            FavoriteResultModel(
                name = "Hospital 7",
                address = "Av. Siempre viva 123",
                coveredByHealthInsurance = true,
                photoUrl = ""
            ),
            FavoriteResultModel(
                name = "Hospital 8",
                address = "Av. Siempre viva 123",
                coveredByHealthInsurance = true,
                photoUrl = ""
            ),
            FavoriteResultModel(
                name = "Hospital 9",
                address = "Av. Siempre viva 123",
                coveredByHealthInsurance = true,
                photoUrl = ""
            ),
        )

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        LazyColumn {
            items(list) { item ->
                MyFavoriteItem(item, onClick = {})
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFavorite() {
    FavoriteScreen()
}