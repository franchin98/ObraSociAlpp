package com.softchin.obrasocialpp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.softchin.obrasocialpp.domain.CentroResultado

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(
    initialText: String = "",
    placeholderText: String = "Search",
    onQueryChange: (String) -> Unit = {},
    onSearch: () -> Unit = {},
    onActiveChange: (Boolean) -> Unit = {},
    listForSearch: State<List<CentroResultado>>? = mutableStateOf(listOf()),
    filterList: (String) -> Unit = {},
) {
    var text by remember { mutableStateOf(initialText) }
    var active by remember { mutableStateOf(false) }
    var filtersOpen by remember { mutableStateOf(false) }

    val widthFraction = animateFloatAsState(if (active) 1f else 0.96f, label = "")

    val selectedFilters = mapOf(
        "Ubicación" to listOf("Ubicación Actual"),
        "Obra Social" to listOf("Swiss Medical", "OSDE", "Galeno"),
        "Especialidad" to listOf("Cardiología", "Pediatría", "Traumatología"),
    )

    val toggleFilters = {
        filtersOpen = !filtersOpen
    }

    SearchBar(
        modifier =
        Modifier
            .fillMaxWidth(widthFraction.value)
            .background(Color.Transparent),
        query = text,
        onQueryChange = { newText ->
            text = newText
            onQueryChange(newText)
        },
        onSearch = {
            active = false
            onSearch()
        },
        active = active,
        onActiveChange = { isActive ->
            active = isActive
            onActiveChange(isActive)
        },
        placeholder = {
            Text(placeholderText)
        },
        leadingIcon = {
            if (active) {
                Icon(
                    modifier =
                    Modifier.clickable {
                        active = false
                    },
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Icon",
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Filter Icon",
                )
            }
        },
        trailingIcon = {
            if (active) {
                Icon(
                    modifier =
                    Modifier
                        .clickable {
                            if (text.isNotEmpty()) {
                                text = ""
                            } else {
                                active = false
                            }
                        },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Filter Icon",
                )
            }
        },
        shadowElevation = 4.dp,
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    ) {
        // /aca deberia poner el resultado de la busqueda
        LaunchedEffect(key1 = text) {
            filterList(text)
        }
        Button(
            onClick = toggleFilters, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onTertiary
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 2.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp
            )
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.List,
                contentDescription = "Filter Icon"
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text("Filtros", fontFamily = MaterialTheme.typography.displaySmall.fontFamily)
        }
        AnimatedVisibility(filtersOpen) {
            FilterBar(
                selectedFilters = selectedFilters,
                onFilterSelected = { _, _ -> },
                onFilterRemoved = { _, _ -> }
            )
        }
        LazyColumn {
            items(/*listForSearch!!.value*/CentroResultado.getMocks()) { centro ->
                CentroBusqueda(centro)
            }
        }
    }
}