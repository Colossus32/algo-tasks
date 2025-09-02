package algorithms

import org.colossus.algorithms.getArrayOfProducts
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArrayOfProductsTest {

    @Test
    fun `empty array returns empty array`() {
        assertEquals(0, getArrayOfProducts(intArrayOf()).size)
    }

    @Test
    fun `single element array returns array with 1`() {
        assertEquals(1, getArrayOfProducts(intArrayOf(5))[0])
    }

    @Test
    fun `two elements array`() {
        val result = getArrayOfProducts(intArrayOf(3, 4))
        assertEquals(4, result[0]) // Все кроме 3 = 4
        assertEquals(3, result[1]) // Все кроме 4 = 3
    }

    @Test
    fun `three elements array`() {
        val result = getArrayOfProducts(intArrayOf(1, 2, 3))
        assertEquals(6, result[0]) // 2 * 3
        assertEquals(3, result[1]) // 1 * 3
        assertEquals(2, result[2]) // 1 * 2
    }

    @Test
    fun `array with zero`() {
        val result = getArrayOfProducts(intArrayOf(1, 0, 3, 4))
        assertEquals(0, result[0])  // 0 * 3 * 4
        assertEquals(12, result[1]) // 1 * 3 * 4
        assertEquals(0, result[2])  // 1 * 0 * 4
        assertEquals(0, result[3])  // 1 * 0 * 3
    }

    @Test
    fun `multiple zeros`() {
        val result = getArrayOfProducts(intArrayOf(1, 0, 3, 0))
        assertEquals(0, result[0]) // 0 * 3 * 0
        assertEquals(0, result[1]) // 1 * 3 * 0
        assertEquals(0, result[2]) // 1 * 0 * 0
        assertEquals(0, result[3]) // 1 * 0 * 3
    }

    @Test
    fun `negative numbers`() {
        val result = getArrayOfProducts(intArrayOf(-1, 2, -3, 4))
        assertEquals(2 * -3 * 4, result[0])  // -24
        assertEquals(-1 * -3 * 4, result[1]) // 12
        assertEquals(-1 * 2 * 4, result[2])  // -8
        assertEquals(-1 * 2 * -3, result[3]) // 6
    }

    @Test
    fun `large array`() {
        val largeArray = IntArray(1000) { 1 }
        val result = getArrayOfProducts(largeArray)
        // Для массива из единиц: каждый элемент = 1 * 1 * ... * 1 = 1
        assertEquals(1, result[0])
        assertEquals(1, result[999])
    }
}
