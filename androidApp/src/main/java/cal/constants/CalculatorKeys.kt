package cal.constants


object CalculatorKeys {
    // Brackets
    const val LEFT_PAREN = "("
    const val RIGHT_PAREN = ")"

    // Clear & Equals
    const val ALL_CLEAR = "AC"
    const val CLEAR_ITEM = "CE"
    const val EQUALS = "="

    // Operators
    const val DIVIDE = "/"
    const val MULTIPLY = "*"
    const val MINUS = "-"
    const val PLUS = "+"

    // Digits
    const val ZERO = "0"
    const val ONE = "1"
    const val TWO = "2"
    const val THREE = "3"
    const val FOUR = "4"
    const val FIVE = "5"
    const val SIX = "6"
    const val SEVEN = "7"
    const val EIGHT = "8"
    const val NINE = "9"
    const val MODE = "%"
    const val SPECIAL_MODE = "~"

    // Decimal
    const val DOT = "."

    // Group into a keypad list
    val keys = listOf(
        LEFT_PAREN,
        RIGHT_PAREN,
        ALL_CLEAR,
        DIVIDE,
        SEVEN,
        EIGHT,
        NINE,
        MULTIPLY,
        FOUR,
        FIVE,
        SIX,
        MINUS,
        ONE,
        TWO,
        THREE,
        PLUS,
        ZERO,
        DOT,
        EQUALS,
        MODE
    )
}