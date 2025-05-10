package com.example.scrollablelist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ItemViewModel : ViewModel() {
    private val _selectedItem = MutableStateFlow<ItemData?>(null)
    val selectedItem = _selectedItem.asStateFlow()

    fun setSelectedItem(item: ItemData) {
        _selectedItem.value = item
    }
}
