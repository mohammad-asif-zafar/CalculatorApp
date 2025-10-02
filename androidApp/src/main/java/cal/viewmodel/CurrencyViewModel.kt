package cal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cal.constants.CurrencyCode
import cal.repo.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CurrencyViewModel(
    private val repository: CurrencyRepository
) : ViewModel() {

    // raw list loaded once
    private val _all = MutableStateFlow<List<CurrencyCode>>(emptyList())

    // UI query entered by user
    private val _query = MutableStateFlow("")

    // expose query so UI can update it
    val query: StateFlow<String> = _query.asStateFlow()

    // filtered results exposed to UI (debounced)
    private val _filtered = MutableStateFlow<List<CurrencyCode>>(emptyList())
    val filtered: StateFlow<List<CurrencyCode>> = _filtered.asStateFlow()

    init {
        loadAll()
        observeQueryAndFilter()
    }

    private fun loadAll() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repository.getAllCurrencies()
            _all.value = list
            _filtered.value = list // default show all
        }
    }

    private fun observeQueryAndFilter() {
        // Debounce user input and do filtering on IO
        viewModelScope.launch {
            _query
                .debounce(300) // wait for typing to settle
                .map { it.trim() } // normalize
                .distinctUntilChanged()
                .flatMapLatest { q ->
                    // perform filtering on IO dispatcher
                    flow {
                        val result = if (q.isEmpty()) {
                            _all.value
                        } else {
                            val lower = q.lowercase()
                            _all.value.filter { cur ->
                                cur.code.lowercase().contains(lower) ||
                                        cur.fullName.lowercase().contains(lower) ||
                                        cur.symbol.lowercase().contains(lower)
                            }
                        }
                        emit(result)
                    }.flowOn(Dispatchers.Default)
                }
                .collect { list ->
                    _filtered.value = list
                }
        }
    }

    // UI calls this to update query
    fun setQuery(q: String) {
        _query.value = q
    }

    // optional: clear query
    fun clearQuery() {
        _query.value = ""
    }

    // optional: refresh from repo
    fun refresh() {
        loadAll()
    }
}
