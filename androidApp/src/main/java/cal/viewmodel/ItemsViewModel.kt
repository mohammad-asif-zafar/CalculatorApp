package cal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cal.constants.CalculatorKeys
import cal.repo.HistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class  ItemsViewModel(
    private val repo: CalculationRepo = CalculationRepo(),
    private val historyRepository: HistoryRepository? = null
) : ViewModel() {


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
        println("IND-1A" + firstValue.value)
        println("IND-1A--secondValue valaue " + secondValue.value)
        println("IND-1A--currentOperator  " + currentOperator)
    }

    fun buttonClickItem(item: String) {
        println("BTN -> $item")
        when (item) {

            CalculatorKeys.MODE -> {
                _largeRes.value += item
            }

            CalculatorKeys.ALL_CLEAR ->// AC
                setTextField()

            CalculatorKeys.DOT ->
                _largeRes.value += item

            CalculatorKeys.EQUALS -> {  // =
                val expression = _largeRes.value
                    .let { expr ->
                        // If user ended on an operator, trim it off before evaluation
                        if (expr.isNotEmpty() && repo.isOperator(expr.last())) expr.dropLast(1) else expr
                    }

                val result = repo.formatResult(
                    repo.performCalculationMultipleOperation(expression).toDouble()
                )

                _smallRes.value = expression
                _largeRes.value = result

                viewModelScope.launch {
                    historyRepository?.add(expression = expression, result = result)
                }
            }

            // +,-,*,/
            CalculatorKeys.PLUS, CalculatorKeys.MINUS, CalculatorKeys.MULTIPLY, CalculatorKeys.DIVIDE -> {
                _largeRes.value += item
                op = true
                f = false
                s = true
                println("op" + item)
                println("+:firstvalue:" + firstValue.value + "-second:" + secondValue.value)

            }
            // digits (0-9)
            else -> {
                println("intial :firstvalue:" + firstValue.value + "-second:" + secondValue.value)
                println("MAX-First" + repo.hasReachedMaxDigits(firstValue.value))
                if (!f && !op) {
                    if (repo.hasReachedMaxDigits(firstValue.value)) {
                        firstValue.value += item
                        _largeRes.value += item
                        println(_largeRes.value)
                        println("after first item:firstvalue:" + firstValue.value + "-second:" + secondValue.value)
                    }
                } else if (op && s && !f) {
                    if (repo.hasReachedMaxDigits(secondValue.value)) {
                        println("IND--" + secondValue.value)
                        secondValue.value += item
                        _largeRes.value += item
                        println("after second:firstvalue:" + firstValue.value + "-second:" + secondValue.value)
                    }
                }
            }
        }
    }

    /*  fun addToHistory(expression: String, result: String) {
          println("his "+expression+"r"+result)

          val newItem = HistoryItem(expression, result)
          _history.value = listOf(newItem) + _history.value  // add to top
      }*/
}
