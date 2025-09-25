package cal.viewmodel

import androidx.lifecycle.ViewModel
import cal.constants.CalculatorKeys


class CalculationRepo() : ViewModel() {
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

    fun performCalculation(
        firstValue: String, secondValue: String, operator: String?
    ): String {
        val a = firstValue.toIntOrNull() ?: return "Error"
        val b = secondValue.toIntOrNull() ?: return "Error"
        println("IND-4A--first valaue " + firstValue)
        println("IND-4A--secondValue valaue " + secondValue)
        println("IND-4A--operatoe valaue " + operator)
        return when (operator) {
            CalculatorKeys.PLUS -> add(a, b).toString()
            CalculatorKeys.MINUS -> subtract(a, b).toString()
            CalculatorKeys.MULTIPLY -> multiply(a, b).toString()
            CalculatorKeys.DIVIDE -> divide(a, b).toString()
            else -> "Invalid Op"
        }
    }
}

