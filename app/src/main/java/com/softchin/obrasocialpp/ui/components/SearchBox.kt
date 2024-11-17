package com.softchin.obrasocialpp.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBox(
    initialText: String = "",
    placeholderText: String = "Search",
    onQueryChange: (String) -> Unit = {},
    onSearch: () -> Unit = {},
    onActiveChange: (Boolean) -> Unit = {},
    listForSearch: State<List<String>>? = null,
    filterList: (String) -> Unit = {},
) {
    var text by remember { mutableStateOf(initialText) }
    var active by remember { mutableStateOf(false) }

    val widthFraction = animateFloatAsState(if (active) 1f else 0.96f, label = "")

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
            containerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
        )
    ) {
        // /aca deberia poner el resultado de la busqueda
        LaunchedEffect(key1 = text) {
            filterList(text)
        }
        LazyColumn {
            items(listForSearch!!.value) { publication ->
               //model de los resultados
            }
        }
    }
}