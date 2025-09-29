package cal.viewmodel

import androidx.lifecycle.ViewModel
import cal.constants.CalculatorKeys
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Locale
import kotlin.math.abs


class CalculationRepo() : ViewModel() {
    private val MAX_DIGITS = 10


    fun add(firstNumber: Double, secondNumber: Double): Double {
        return (firstNumber + secondNumber)
    }

    fun subtract(firstNumber: Double, secondNumber: Double): Double {
        return if (firstNumber > secondNumber) (firstNumber - secondNumber)
        else (secondNumber - firstNumber)

    }

    fun multiply(firstNumber: Double, secondNumber: Double): Double {
        return (firstNumber * secondNumber)
    }

    fun divide(firstNumber: Double, secondNumber: Double): Double {
        if (secondNumber == 0.0) {
            throw ArithmeticException("Division by zero is not allowed")
        }
        return firstNumber / secondNumber
    }

    fun module(a: Double, b: Double): Double {
        return a.mod(b)
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
        val a = firstValue.toDoubleOrNull() ?: 0.0
        val b = secondValue.toDoubleOrNull() ?: 0.0

        return when (operator) {
            CalculatorKeys.PLUS -> add(a, b).toString()
            CalculatorKeys.MINUS -> subtract(a, b).toString()
            CalculatorKeys.MULTIPLY -> multiply(a, b).toString()
            CalculatorKeys.DIVIDE -> divide(a, b).toString()
            CalculatorKeys.MODE -> module(a, b).toString()
            else -> "Invalid Op"
        }
    }

    fun performCalculationMultipleOperation(str: String): String {
        // Remove trailing operator if present

        var longCal = str
        if (isOperator(longCal[longCal.length - 1])) longCal =
            longCal.substring(0, longCal.length - 1);
        //  now maths operation
        var number: StringBuilder = StringBuilder()
        var result = ""
        var op = ""


        for (i in longCal.indices) {
            val ch: Char = longCal[i]
            if (Character.isDigit(ch) || ch == '.') {
                number.append(ch)
            } else if (isOperator(ch)) {
                if (result.isEmpty()) {
                    result = number.toString();
                } else {
                    result = performCalculation(result, number.toString(), ch.toString())

                }
                number.setLength(0);
                op = ch.toString()

            }

        }
        // Last number
        if (result.isEmpty()) {
            result = number.toString()
        } else {
            result = performCalculation(result, number.toString(), op)
        }

        // ✅ Format result: 3 decimals max, max 9 digits
        val numeric = result.toDoubleOrNull()
        return if (numeric != null) {
            formatResultOfDecimal(numeric)   // <-- uses the helper below
        } else {
            result
        }

    }


    fun isOperator(ch: Char): Boolean {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%'
    }

    // Format result: remove ".0" if integer
    fun formatResult(value: Double): String {
        return if (value % 1.0 == 0.0) {
            value.toInt().toString()   // remove .0
        } else {
            value.toString()           // keep decimal
        }
    }


    fun formatResultOfDecimal(value: Double): String {
        if (value.isNaN()) return "NaN"
        if (value.isInfinite()) return if (value > 0) "Infinity" else "-Infinity"

        val absVal = abs(value)

        // Count digits in integer part
        val integerPart = absVal.toLong()
        val integerLength = integerPart.toString().length

        // If integer part too long -> scientific notation
        if (integerLength > 9) {
            return String.format(Locale.US, "%.3e", value)
        }

        // Otherwise round to 3 decimal places
        val bd = BigDecimal(value.toString()).setScale(3, RoundingMode.HALF_UP).stripTrailingZeros()

        // If no fractional part -> show as int
        return if (bd.scale() <= 0) {
            bd.toBigInteger().toString()
        } else {
            bd.toPlainString()
        }
    }
}

