import cal.viewmodel.CalculationRepo
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CalculationRepoTest {
    private lateinit var repo: CalculationRepo

    @Before
    fun setup() {
        repo = CalculationRepo()
    }

    // Add method
    @Test
    fun ` Add method test cases with happy flow - Edge cases -  Invalid cases- Special cases `() {
        // --- Happy path ---
        assertEquals(8.0, repo.add(5.0, 3.0), 0.0) // normal
        assertEquals(7.0, repo.add(7.0, 0.0), 0.0)// add with zero

        // --- Edge cases ---
        val result2 = repo.add(Double.MAX_VALUE, Double.MAX_VALUE) // add large numbers overflow
        assertTrue(result2.isInfinite())

        val result3 = repo.add(Double.MIN_VALUE, Double.MIN_VALUE)// add tiny numbers
        assertTrue(result3 > 0.0)

        // --- Invalid cases ---

        val result4 = repo.add(Double.NaN, 5.0)//add NaN returns NaN
        assertTrue(result4.isNaN())

        val result5 = repo.add(Double.POSITIVE_INFINITY, 10.0) // add infinity returns infinity
        assertTrue(result5.isInfinite())

        val result6 = repo.add(Double.POSITIVE_INFINITY, 10.0)// add infinity returns infinity
        assertTrue(result6.isInfinite())

        // --- Special cases ---
        assertEquals(-2.0, repo.add(-5.0, 3.0), 0.0) // add negative and positive

        assertEquals(-8.0, repo.add(-5.0, -3.0), 0.0) // `add two negatives

        assertEquals(6.2, repo.add(2.5, 3.7), 0.0001) // allow precision tolerance with add decimals

        assertEquals(0.0, repo.add(5.0, -5.0), 0.0) // add opposites gives zero

    }


    @Test
    fun `Subtract method test cases with happy flow - Edge cases - Invalid cases - Special cases`() {
        // --- Happy path ---
        assertEquals(2.0, repo.subtract(5.0, 3.0), 0.0) // normal subtraction
        assertEquals(0.0, repo.subtract(7.0, 7.0), 0.0) // subtract same numbers

        // --- Edge cases ---
        val result1 = repo.subtract(Double.MAX_VALUE, Double.MIN_VALUE)
        assertTrue(result1 >= 0.0) // large - small stays large

        val result2 = repo.subtract(Double.MIN_VALUE, Double.MIN_VALUE)
        assertEquals(0.0, result2, 0.0) // subtract tiny numbers

        // --- Invalid cases ---
        val result3 = repo.subtract(Double.NaN, 5.0)
        assertTrue(result3.isNaN())

        val result4 = repo.subtract(Double.POSITIVE_INFINITY, 10.0)
        assertTrue(result4.isInfinite())

        // --- Special cases ---
        assertEquals(2.0, repo.subtract(-5.0, -7.0), 0.0) // negative subtraction
        assertEquals(8.0, repo.subtract(-5.0, 3.0), 0.0)  // one negative
    }

    @Test
    fun `Multiply method test cases with happy flow - Edge cases - Invalid cases - Special cases`() {
        // --- Happy path ---
        assertEquals(15.0, repo.multiply(5.0, 3.0), 0.0) // normal multiplication
        assertEquals(0.0, repo.multiply(7.0, 0.0), 0.0)  // multiply with zero

        // --- Edge cases ---
        val result1 = repo.multiply(Double.MAX_VALUE, 2.0)
        assertTrue(result1.isInfinite()) // overflow case

        val result2 = repo.multiply(Double.MIN_VALUE, 2.0)
        assertTrue(result2 >= 0.0) // still tiny but positive

        // --- Invalid cases ---
        val result3 = repo.multiply(Double.NaN, 5.0)
        assertTrue(result3.isNaN())

        val result4 = repo.multiply(Double.POSITIVE_INFINITY, 10.0)
        assertTrue(result4.isInfinite())

        // --- Special cases ---
        assertEquals(-15.0, repo.multiply(-5.0, 3.0), 0.0) // negative * positive
        assertEquals(15.0, repo.multiply(-5.0, -3.0), 0.0) // negative * negative
        assertEquals(3.75, repo.multiply(1.5, 2.5), 0.0001) // decimals
    }

    @Test
    fun `Divide method test cases with happy flow - Edge cases - Invalid cases - Special cases`() {
        // --- Happy path ---
        assertEquals(2.0, repo.divide(6.0, 3.0), 0.0) // normal division
        assertEquals(0.0, repo.divide(0.0, 5.0), 0.0) // zero divided by number

        // --- Edge cases ---
        val result1 = repo.divide(Double.MAX_VALUE, 2.0)
        assertTrue(result1 > 0.0) // still huge but finite

        val result2 = repo.divide(Double.MIN_VALUE, 2.0)
        assertTrue(result2 >= 0.0) // still very small positive

        // --- Invalid cases ---
        assertThrows(ArithmeticException::class.java) {
            repo.divide(5.0, 0.0) // division by zero
        }

        val result3 = repo.divide(Double.NaN, 5.0)
        assertTrue(result3.isNaN())

        val result4 = repo.divide(Double.POSITIVE_INFINITY, 10.0)
        assertTrue(result4.isInfinite())

        // --- Special cases ---
        assertEquals(-2.0, repo.divide(-6.0, 3.0), 0.0) // negative / positive
        assertEquals(2.0, repo.divide(-6.0, -3.0), 0.0) // negative / negative
        assertEquals(2.5, repo.divide(5.0, 2.0), 0.0001) // decimal division
    }

    @Test
    fun `Module method test cases with happy flow - Edge cases - Invalid cases - Special cases`() {
        // --- Happy path ---
        assertEquals(1.0, repo.module(5.0, 2.0), 0.0) // 5 % 2 = 1
        assertEquals(0.0, repo.module(6.0, 3.0), 0.0) // divisible case

        // --- Edge cases ---
        val result1 = repo.module(Double.MAX_VALUE, 2.0)
        assertTrue(result1 in 0.0..2.0) // remainder is always < divisor

        val result2 = repo.module(Double.MIN_VALUE, 1.0)
        assertTrue(result2 >= 0.0) // tiny remainder

        // --- Invalid cases ---
        val result4 = repo.module(5.0, 0.0)
        assertTrue(result4.isNaN())

        val result3 = repo.module(Double.NaN, 5.0)
        assertTrue(result3.isNaN())

        // --- Special cases ---
        assertEquals(1.0, repo.module(-5.0, 3.0), 0.0) // negative number
        assertEquals(0.5, repo.module(5.5, 2.5), 0.0001) // decimals
    }
}