package com.softchin.obrasocialpp.ui.screens.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel : ViewModel() {
    private val _selectedFilters = MutableStateFlow<Map<String, List<String>>>(emptyMap())
    val selectedFilters: StateFlow<Map<String, List<String>>> = _selectedFilters

    fun selectFilter(category: String, option: String) {
        val updatedFilters = _selectedFilters.value.toMutableMap()
        val currentOptions = updatedFilters[category]?.toMutableList() ?: mutableListOf()

        if (!currentOptions.contains(option)) {
            currentOptions.add(option)
            updatedFilters[category] = currentOptions
            _selectedFilters.value = updatedFilters
        }
    }

    fun removeFilter(category: String, option: String) {
        val updatedFilters = _selectedFilters.value.toMutableMap()
        val currentOptions = updatedFilters[category]?.toMutableList() ?: return

        currentOptions.remove(option)
        if (currentOptions.isEmpty()) {
            updatedFilters.remove(category)
        } else {
            updatedFilters[category] = currentOptions
        }
        _selectedFilters.value = updatedFilters
    }
}
