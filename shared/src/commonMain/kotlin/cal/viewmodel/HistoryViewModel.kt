package cal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cal.repo.HistoryRepository
import kotlinx.coroutines.launch

class HistoryViewModel(private val repository: HistoryRepository) : ViewModel() {
    val history = repository.history

    fun addToHistory(expression: String, result: String) {
        viewModelScope.launch {
            repository.add(expression, result)
        }
    }

    fun clearHistory() {
        viewModelScope.launch {
            repository.clear()
        }
    }
}
