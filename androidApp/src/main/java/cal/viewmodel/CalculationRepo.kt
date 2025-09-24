package cal.viewmodel

import androidx.lifecycle.ViewModel


class CalculationRepo : ViewModel() {


    fun add(firstNumber: Int, secondNumber: Int): Int {
        println("IND-A:3$firstNumber--$secondNumber")
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

}