package cal.model

import cal.constants.CalculatorKeys


object CalculatorKeysList {
    val keys = listOf(

        // Row 0
        CalculatorKey(1, CalculatorKeys.ALL_CLEAR, KeyType.CLEAR),
        CalculatorKey(2, CalculatorKeys.CLEAR_ITEM, KeyType.CLEAR_ITEM),
        CalculatorKey(3, CalculatorKeys.MODE, KeyType.MODE),
        CalculatorKey(4, CalculatorKeys.DIVIDE, KeyType.OPERATOR),

        // Row 1
        CalculatorKey(6, CalculatorKeys.EIGHT, KeyType.DIGIT),
        CalculatorKey(5, CalculatorKeys.SEVEN, KeyType.DIGIT),
        CalculatorKey(7, CalculatorKeys.NINE, KeyType.DIGIT),
        CalculatorKey(8, CalculatorKeys.MULTIPLY, KeyType.OPERATOR),

        // Row 2
        CalculatorKey(10, CalculatorKeys.FIVE, KeyType.DIGIT),
        CalculatorKey(9, CalculatorKeys.FOUR, KeyType.DIGIT),
        CalculatorKey(11, CalculatorKeys.SIX, KeyType.DIGIT),
        CalculatorKey(12, CalculatorKeys.MINUS, KeyType.OPERATOR),

        // Row 3
        CalculatorKey(14, CalculatorKeys.TWO, KeyType.DIGIT),
        CalculatorKey(13, CalculatorKeys.ONE, KeyType.DIGIT),
        CalculatorKey(15, CalculatorKeys.THREE, KeyType.DIGIT),
        CalculatorKey(16, CalculatorKeys.PLUS, KeyType.OPERATOR),

        // Row 4 (bottom row)
        CalculatorKey(18, CalculatorKeys.ZERO, KeyType.DIGIT),
        CalculatorKey(17, CalculatorKeys.SPECIAL_MODE, KeyType.SPECIAL_MODE),
        CalculatorKey(19, CalculatorKeys.DOT, KeyType.DOT),
        CalculatorKey(20, CalculatorKeys.EQUALS, KeyType.EQUALS)
    )
}