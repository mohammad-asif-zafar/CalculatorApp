package cal.viewmodel

import androidx.lifecycle.ViewModel
import cal.model.HistoryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel : ViewModel() {
    private val _history = MutableStateFlow<List<HistoryItem>>(emptyList())
    val history = _history.asStateFlow()
}