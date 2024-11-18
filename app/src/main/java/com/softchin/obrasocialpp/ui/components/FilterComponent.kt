package com.softchin.obrasocialpp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.softchin.obrasocialpp.domain.Especialidad
import com.softchin.obrasocialpp.domain.ObraSocial
import com.softchin.obrasocialpp.utils.StringUtils

@Composable
fun FilterBar(
    selectedFilters: Map<String, List<String>>,
    onFilterSelected: (String, String) -> Unit,
    onFilterRemoved: (String, String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            FilterDropdownButton(
                text = "Ubicación",
                options = listOf(
                    "Ubicación Actual",
                    "Morón",
                    "Castelar",
                    "Ituzaingó",
                    "San Justo",
                    "Haedo",
                    "Merlo",
                    "Moreno",
                    "Tablada",
                    "Villa Luzuriaga",
                ),
                isMultipleSelectionAllowed = false,
                selectedFilters = selectedFilters["Location"] ?: emptyList(),
                onOptionSelected = { option ->
                    onFilterSelected("Location", option)
                }
            )
            FilterDropdownButton(
                text = "Obra Social",
                options = ObraSocial.entries.map { it.nombre },
                isMultipleSelectionAllowed = false,
                selectedFilters = selectedFilters["Social Security"] ?: emptyList(),
                onOptionSelected = { option ->
                    onFilterSelected("Social Security", option)
                }
            )
            FilterDropdownButton(
                text = "Especialidad",
                options = Especialidad.entries.map { it.nombre },
                isMultipleSelectionAllowed = true,
                selectedFilters = selectedFilters["Specialty"] ?: emptyList(),
                onOptionSelected = { option ->
                    onFilterSelected("Specialty", option)
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // FlowRow for displaying selected filters as Mercado Libre style chips
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp
        ) {
            selectedFilters.forEach { (category, filters) ->
                filters.forEach { filter ->
                    SelectedFilterChip(
                        text = "$category: $filter",
                        onRemove = { onFilterRemoved(category, filter) }
                    )
                }
            }
        }
    }
}

@Composable
fun FilterDropdownButton(
    text: String,
    options: List<String>,
    isMultipleSelectionAllowed: Boolean,
    selectedFilters: List<String>,
    onOptionSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .background(
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .clickable { expanded = true }
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = Color.Gray
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.border(
                2.dp,
                MaterialTheme.colorScheme.tertiary,
                RoundedCornerShape(8.dp)
            )
        ) {
            options.forEach { option ->
                val isSelected = option in selectedFilters
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        if (isMultipleSelectionAllowed) {
                            onOptionSelected(option)
                        } else {
                            if (!isSelected) {
                                onOptionSelected(option)
                            }
                        }
                        expanded = false
                    },
                    modifier = Modifier
                        .background(
                            color = if (isSelected) MaterialTheme.colorScheme.secondary else Color.Transparent
                        )
                )
            }
        }
    }
}

@Composable
fun SelectedFilterChip(text: String, onRemove: () -> Unit) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(16.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text, color = Color.White, fontSize = 12.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .clickable { onRemove() },
                tint = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterBarPreview() {
    val selectedFilters = mapOf(
        "Location" to listOf("Current Location"),
        "Social Security" to listOf("My Social Security"),
        "Specialty" to listOf("General Practitioner", "Dermatologist"),
        "Doctors" to listOf("Available Doctors")
    )

    FilterBar(
        selectedFilters = selectedFilters,
        onFilterSelected = { _, _ -> },
        onFilterRemoved = { _, _ -> }
    )
}



