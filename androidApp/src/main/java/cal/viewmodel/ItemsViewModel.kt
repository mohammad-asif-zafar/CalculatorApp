package cal.viewmodel

import androidx.lifecycle.ViewModel
import cal.constants.CalculatorKeys
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ItemsViewModel(private val repo: CalculationRepo = CalculationRepo()) : ViewModel() {

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

            CalculatorKeys.ALL_CLEAR ->// AC
                setTextField()

            CalculatorKeys.EQUALS -> {  // =
                if (!f && op && s) {
                    _smallRes.value = _largeRes.value
                    _largeRes.value = repo.performCalculation(
                        firstValue = firstValue.value,
                        secondValue = secondValue.value,
                        operator = currentOperator
                    )
                    firstValue.value = _largeRes.value.toString()
                    op = false
                    s = false
                    secondValue.value = ""
                    println("final :firstvalue:" + firstValue.value + "-second:" + secondValue.value)
                }
            }
            // +,-,*,/
            CalculatorKeys.PLUS, CalculatorKeys.MINUS, CalculatorKeys.MULTIPLY, CalculatorKeys.DIVIDE -> {
                currentOperator = item
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

}
