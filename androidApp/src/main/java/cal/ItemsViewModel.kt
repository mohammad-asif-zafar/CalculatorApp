package cal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cal.viewmodel.CalculationRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ItemsViewModel(private val repo: CalculationRepo = CalculationRepo()) : ViewModel() {

    private var _itemState = MutableStateFlow("") // private mutable
    val itemState: StateFlow<String> = _itemState.asStateFlow() // public read-only


    private val _result = MutableStateFlow("") // private mutable
    val result: StateFlow<String> = _result.asStateFlow() // public read-only

    private var firstValue = MutableStateFlow("") // private mutable
    private val secondValue = MutableStateFlow("") // private mutable
    private var currentOperator: String? = null


    fun setTextField() {

        firstValue.value = ""
        secondValue.value = ""
        currentOperator = null
        _result.value = ""

        println("IND-1A" + firstValue.value)
        println("IND-1A--secondValue valaue " + secondValue.value)
        println("IND-1A--currentOperator  " + currentOperator)
    }

    fun buttonClickItem(item: String) {
        println("IND-2A- $item")
        when (item) {
            "AC" -> setTextField()
            "=" -> {
                if (firstValue.value.isNotBlank() && secondValue.value.isNotBlank()) performCalculation()
                firstValue.value = _result.value.toString()
                println("IND-3A::firstvalue after " + firstValue.value)
            }

            "+", "-", "*", "/" -> {
                currentOperator = item
                secondValue.value = ""
                _result.value += item

            }

            "AC" -> setTextField()
            else -> {
                // assume numeric button (0-9)
                if (firstValue.value.isBlank()) {
                    firstValue.value = item
                    _result.value = item

                } else if (firstValue.value.isNotBlank() && secondValue.value.isBlank() && !currentOperator.isNullOrBlank()) {
                    secondValue.value = item;
                    _result.value += item
                }
            }
        }

    }

    fun itemData(): List<String> {
        return listOf(
            "(",
            ")",
            "/",
            "AC",
            "7",
            "8",
            "9",
            "/",
            "4",
            "5",
            "6",
            "*",
            "1",
            "2",
            "3",
            "-",
            "0",
            ".",
            "=",
            "+",
        )  // just static  value
    }

    fun performCalculation() {
        viewModelScope.launch {
            println("IND-4A--first valaue " + firstValue.value)
            println("IND-4A--secondValue valaue " + secondValue.value)
            println("IND-4A--operatoe valaue " + currentOperator)
            _result.value = ""
            if (currentOperator.equals("+")) _result.value =
                repo.add(firstValue.value.toInt(), secondValue.value.toInt()).toString()
            else if (currentOperator.equals("-")) _result.value =
                repo.subtract(firstValue.value.toInt(), secondValue.value.toInt()).toString()
            else if (currentOperator.equals("*")) _result.value =
                repo.multiply(firstValue.value.toInt(), secondValue.value.toInt()).toString()
            else if (currentOperator.equals("/")) _result.value =
                repo.divide(firstValue.value.toInt(), secondValue.value.toInt()).toString()
            //firstValue.value = _result.value.toString()
        }
    }

}