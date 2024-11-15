package com.softchin.obrasocialpp.ui.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.softchin.obrasocialpp.ui.components.FilterBar
import com.softchin.obrasocialpp.ui.components.SearchBox

@Composable
fun SearchScreen(viewModel: SearchViewModel ) {
    val selectedFilters by viewModel.selectedFilters.collectAsState()

    Column {
        SearchBox()
        Spacer(modifier = Modifier.height(16.dp)) // Optional space between the two elements
        FilterBar(
            selectedFilters = selectedFilters,
            onFilterSelected = { category, option ->
                viewModel.selectFilter(category, option)
            },
            onFilterRemoved = { category, option ->
                viewModel.removeFilter(category, option)
            }
        )
    }
}
