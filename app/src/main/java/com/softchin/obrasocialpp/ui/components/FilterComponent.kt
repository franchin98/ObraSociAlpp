package com.softchin.obrasocialpp.ui.components

import androidx.compose.foundation.background
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
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FilterDropdownButton(
                text = "Location",
                options = listOf("Current Location", "Approximate Location"),
                isMultipleSelectionAllowed = false,
                selectedFilters = selectedFilters["Location"] ?: emptyList(),
                onOptionSelected = { option ->
                    onFilterSelected("Location", option)
                }
            )
            FilterDropdownButton(
                text = "Social Security",
                options = listOf("My Social Security", "Private", "All"),
                isMultipleSelectionAllowed = false,
                selectedFilters = selectedFilters["Social Security"] ?: emptyList(),
                onOptionSelected = { option ->
                    onFilterSelected("Social Security", option)
                }
            )
            FilterDropdownButton(
                text = "Specialty",
                options = listOf("General Practitioner", "Dermatologist", "Nutritionist", "Other"),
                isMultipleSelectionAllowed = true,
                selectedFilters = selectedFilters["Specialty"] ?: emptyList(),
                onOptionSelected = { option ->
                    onFilterSelected("Specialty", option)
                }
            )
            FilterDropdownButton(
                text = "Doctors",
                options = listOf("Available Doctors", "Private", "All"),
                isMultipleSelectionAllowed = true,
                selectedFilters = selectedFilters["Doctors"] ?: emptyList(),
                onOptionSelected = { option ->
                    onFilterSelected("Doctors", option)
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
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Row(
            modifier = Modifier
                .clickable { expanded = true }
                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text, style = MaterialTheme.typography.bodyMedium)
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
            onDismissRequest = { expanded = false }
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
                    }
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



