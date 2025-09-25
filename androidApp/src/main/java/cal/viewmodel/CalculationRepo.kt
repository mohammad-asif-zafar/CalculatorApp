package cal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cal.constants.CalculatorKeys
import cal.model.CalculatorKey
import cal.model.KeyType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CalculationRepo : ViewModel() {
    private val MAX_DIGITS = 10  // you can change this


    fun add(firstNumber: Int, secondNumber: Int): Int {
        return (firstNumber + secondNumber)
    }

    fun subtract(firstNumber: Int, secondNumber: Int): Int {
        return if (firstNumber > secondNumber) (firstNumber - secondNumber)
        else (secondNumber - firstNumber)

    }

    fun multiply(firstNumber: Int, secondNumber: Int): Int {
        return (firstNumber * secondNumber)
    }

    fun divide(firstNumber: Int, secondNumber: Int): Int {
        return if (firstNumber > secondNumber) firstNumber / secondNumber
        else secondNumber / firstNumber
    }


    fun hasReachedMaxDigits(number: String, maxDigits: Int = MAX_DIGITS): Boolean {
        // Count only digits (ignore dot or minus sign)
        val digitCount = number.count {
            it.isDigit()
        }
        return digitCount <= maxDigits
    }

}

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
            CalculatorKeys.ALL_CLEAR ->
// reset everything: firstValue, secondValue, currentOperator, _itemState, _result
                setTextField()

            CalculatorKeys.EQUALS -> {
                if (!f && op && s) {
                    _smallRes.value = _largeRes.value
                    _largeRes.value = performCalculation()
                    firstValue.value = _largeRes.value.toString()
                    op = false
                    s = false
                    secondValue.value = ""
                    println("final :firstvalue:" + firstValue.value + "-second:" + secondValue.value)

                }
            }

            CalculatorKeys.PLUS, CalculatorKeys.MINUS, CalculatorKeys.MULTIPLY, CalculatorKeys.DIVIDE -> {
                currentOperator = item
                _largeRes.value += item
                op = true
                f = false
                s = true
                println("op" + item)
                println("+:firstvalue:" + firstValue.value + "-second:" + secondValue.value)

            }

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


    fun performCalculationa() {
        viewModelScope.launch {
            println("IND-4A--first valaue " + firstValue.value)
            println("IND-4A--secondValue valaue " + secondValue.value)
            println("IND-4A--operatoe valaue " + currentOperator)
            _smallRes.value = ""
            if (currentOperator.equals(CalculatorKeys.PLUS)) _smallRes.value =
                repo.add(firstValue.value.toInt(), secondValue.value.toInt()).toString()
            else if (currentOperator.equals(CalculatorKeys.MINUS)) _smallRes.value =
                repo.subtract(firstValue.value.toInt(), secondValue.value.toInt()).toString()
            else if (currentOperator.equals(CalculatorKeys.MULTIPLY)) _smallRes.value =
                repo.multiply(firstValue.value.toInt(), secondValue.value.toInt()).toString()
            else if (currentOperator.equals(CalculatorKeys.DIVIDE)) _smallRes.value =
                repo.divide(firstValue.value.toInt(), secondValue.value.toInt()).toString()
        }
    }

    fun performCalculation(): String {
        val a = firstValue.value.toIntOrNull() ?: return "Error"
        val b = secondValue.value.toIntOrNull() ?: return "Error"

        return when (currentOperator) {
            CalculatorKeys.PLUS -> repo.add(a, b).toString()
            CalculatorKeys.MINUS -> repo.subtract(a, b).toString()
            CalculatorKeys.MULTIPLY -> repo.multiply(a, b).toString()
            CalculatorKeys.DIVIDE -> repo.divide(a, b).toString()
            else -> "Invalid Op"
        }
    }
}

object CalculatorKeysList {
    val keys = listOf(

        // Row 0
        CalculatorKey(1, CalculatorKeys.ALL_CLEAR, KeyType.CLEAR),
        CalculatorKey(
            2, CalculatorKeys.CLEAR_ITEM, KeyType.MODE
        ),                // no constant yet → keep inline
        CalculatorKey(3, CalculatorKeys.MODE, KeyType.MODE),
        CalculatorKey(4, CalculatorKeys.DIVIDE, KeyType.OPERATOR),

        // Row 1
        CalculatorKey(5, CalculatorKeys.SEVEN, KeyType.DIGIT),
        CalculatorKey(6, CalculatorKeys.EIGHT, KeyType.DIGIT),
        CalculatorKey(7, CalculatorKeys.NINE, KeyType.DIGIT),
        CalculatorKey(8, CalculatorKeys.MULTIPLY, KeyType.OPERATOR),

        // Row 2
        CalculatorKey(9, CalculatorKeys.FOUR, KeyType.DIGIT),
        CalculatorKey(10, CalculatorKeys.FIVE, KeyType.DIGIT),
        CalculatorKey(11, CalculatorKeys.SIX, KeyType.DIGIT),
        CalculatorKey(12, CalculatorKeys.MINUS, KeyType.OPERATOR),

        // Row 3
        CalculatorKey(13, CalculatorKeys.ONE, KeyType.DIGIT),
        CalculatorKey(14, CalculatorKeys.TWO, KeyType.DIGIT),
        CalculatorKey(15, CalculatorKeys.THREE, KeyType.DIGIT),
        CalculatorKey(16, CalculatorKeys.PLUS, KeyType.OPERATOR),

        // Row 4 (bottom row)
        CalculatorKey(
            17, CalculatorKeys.SPECIAL_MODE, KeyType.MODE
        ),              // special → render icon in UI
        CalculatorKey(18, CalculatorKeys.ZERO, KeyType.DIGIT),
        CalculatorKey(19, CalculatorKeys.DOT, KeyType.DOT),
        CalculatorKey(20, CalculatorKeys.EQUALS, KeyType.EQUALS)
    )
}