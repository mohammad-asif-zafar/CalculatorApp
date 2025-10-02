package cal.model

data class CalculatorKey(
    val id: Int, val label: String, val type: KeyType
)

enum class KeyType {
    DIGIT, OPERATOR, CLEAR, EQUALS, DOT, BRACKET, MODE,SPECIAL_MODE,CLEAR_ITEM
}