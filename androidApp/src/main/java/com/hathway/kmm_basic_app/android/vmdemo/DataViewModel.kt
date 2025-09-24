package com.hathway.kmm_basic_app.android.vmdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class DataViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun loadData() {
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)
            try {
                delay(2000)
                _uiState.value = UiState(data = "Fetched data!")
            } catch (e: Exception) {
                _uiState.value = UiState(error = e.message)
            }
        }
    }
}

data class UiState(
    val isLoading: Boolean = false, val data: String? = null, val error: String? = null
)