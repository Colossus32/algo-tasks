import org.colossus.algorithms.getFirstDuplicatedValue
import org.colossus.algorithms.getFirstDuplicatedValueInGoodArray
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class DuplicatedValueTest {

    // Tests for getFirstDuplicatedValue (general version)
    @Test
    fun `empty array returns null`() {
        assertNull(getFirstDuplicatedValue(intArrayOf()))
    }

    @Test
    fun `no duplicates returns null`() {
        assertNull(getFirstDuplicatedValue(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `finds first duplicate`() {
        assertEquals(2, getFirstDuplicatedValue(intArrayOf(1, 2, 3, 2, 1)))
        assertEquals(5, getFirstDuplicatedValue(intArrayOf(5, 1, 3, 5, 2, 3)))
    }

    @Test
    fun `works with negative numbers`() {
        assertEquals(-2, getFirstDuplicatedValue(intArrayOf(1, -2, 3, -2, 1)))
    }

    @Test
    fun `works with zeros`() {
        assertEquals(0, getFirstDuplicatedValue(intArrayOf(1, 0, 3, 0, 2)))
    }

    // Tests for getFirstDuplicatedValueInGoodArray (optimized version)
    @Test
    fun `optimized empty array returns null`() {
        assertNull(getFirstDuplicatedValueInGoodArray(intArrayOf()))
    }

    @Test
    fun `optimized no duplicates returns null`() {
        assertNull(getFirstDuplicatedValueInGoodArray(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `optimized finds first duplicate`() {
        assertEquals(2, getFirstDuplicatedValueInGoodArray(intArrayOf(1, 2, 3, 2)))
        assertEquals(3, getFirstDuplicatedValueInGoodArray(intArrayOf(3, 1, 3, 2, 4)))
    }

    @Test
    fun `optimized multiple duplicates returns first`() {
        assertEquals(2, getFirstDuplicatedValueInGoodArray(intArrayOf(2, 1, 2, 3, 3)))
    }

    @Test
    fun `optimized large array`() {
        val largeArray = IntArray(10000) { it + 1 } // 1..10000
        largeArray[9999] = 1 // Duplicate first element at the end
        assertEquals(1, getFirstDuplicatedValueInGoodArray(largeArray))
    }

    @Test
    fun `optimized edge case single element`() {
        assertNull(getFirstDuplicatedValueInGoodArray(intArrayOf(1)))
    }

    @Test
    fun `optimized edge case two elements`() {
        assertEquals(1, getFirstDuplicatedValueInGoodArray(intArrayOf(1, 1)))
        assertNull(getFirstDuplicatedValueInGoodArray(intArrayOf(1, 2)))
    }

    // Comparative tests
    @Test
    fun `both versions return same result for valid input`() {
        val testArray = intArrayOf(3, 1, 2, 3, 4)
        assertEquals(
            getFirstDuplicatedValue(testArray.copyOf()),
            getFirstDuplicatedValueInGoodArray(testArray.copyOf())
        )
    }
}