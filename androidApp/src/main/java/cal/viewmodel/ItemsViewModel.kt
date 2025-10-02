package cal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cal.constants.CalculatorKeys
import cal.model.CalculatorKey
import cal.repo.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ItemsViewModel(
    private val repo: CalculationRepo = CalculationRepo(),
    private val historyRepository: HistoryRepository? = null
) : ViewModel() {

    private val UiEvent = MutableLiveData("")
    val _UiEvent: LiveData<String> = UiEvent

    private val _smallRes = MutableStateFlow("") // private mutable
    var smallRes: StateFlow<String> = _smallRes.asStateFlow() // public read-only

    private var _largeRes = MutableStateFlow("") // private mutable
    val largeRes: StateFlow<String> = _largeRes.asStateFlow() // public read-only

    private var firstValue = MutableStateFlow("") // private mutable
    private val secondValue = MutableStateFlow("") // private mutable
    private var currentOperator: String? = ""

    private var f: Boolean = false
    private var s: Boolean = false
    private var op: Boolean = false

    fun setTextField() {
        firstValue.value = ""
        secondValue.value = ""
        currentOperator = ""
        _smallRes.value = ""
        _largeRes.value = ""
        f = false
        s = false
        op = false
    }

    fun buttonClickItem(calculatorKey: CalculatorKey) {
        println("BTN -> $calculatorKey.item")

        when (calculatorKey.label) {

            CalculatorKeys.SPECIAL_MODE -> {
            }

            CalculatorKeys.MODE -> {
                if (!repo.isSameAsLast(_largeRes.value, calculatorKey.label)) {
                    _largeRes.value += calculatorKey.label
                }
            }

            CalculatorKeys.ALL_CLEAR ->// AC
                setTextField()

            CalculatorKeys.CLEAR_ITEM -> {
                _largeRes.value = repo.removeLastItem(_largeRes.value)
            }

            CalculatorKeys.DOT -> {
                if (repo.isValidDecimal(_largeRes.value)) {
                    _largeRes.value += calculatorKey.label
                }
            }

            CalculatorKeys.EQUALS -> {  // =
                val expression = _largeRes.value.let { expr ->
                    if (expr.isNotEmpty() && repo.isOperator(expr.last())) expr.dropLast(1) else expr
                }
                val result = repo.formatResult(
                    repo.performCalculationMultipleOperation(expression).toDouble() // precedence is not
                )
                _smallRes.value = expression
                _largeRes.value = result

                viewModelScope.launch {
                    historyRepository?.add(expression = expression, result = result)
                }
            }

            // +,-,*,/
            CalculatorKeys.PLUS, CalculatorKeys.MINUS, CalculatorKeys.MULTIPLY, CalculatorKeys.DIVIDE -> {
                if (!repo.isSameAsLast(_largeRes.value, calculatorKey.label)) {
                    _largeRes.value += calculatorKey.label
                    op = true
                    f = false
                    s = true
                }
            }
            // digits (0-9)
            else -> {

                if (!f && !op) {
                    if (repo.hasReachedMaxDigits(firstValue.value)) {
                        firstValue.value += calculatorKey.label
                        _largeRes.value += calculatorKey.label
                        println(_largeRes.value)
                    }
                } else if (op && s && !f) {
                    if (repo.hasReachedMaxDigits(secondValue.value)) {
                        secondValue.value += calculatorKey.label
                        _largeRes.value += calculatorKey.label
                    }
                }
            }
        }
    }
}
