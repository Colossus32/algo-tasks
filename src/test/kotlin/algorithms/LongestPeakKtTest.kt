package algorithms

import org.colossus.algorithms.findLongestPeak
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LongestPeakKtTest {

    @Test
    fun `array too small returns zero`() {
        assertEquals(0, findLongestPeak(intArrayOf()))
        assertEquals(0, findLongestPeak(intArrayOf(1)))
        assertEquals(0, findLongestPeak(intArrayOf(1, 2)))
    }

    @Test
    fun `no peaks returns zero`() {
        assertEquals(0, findLongestPeak(intArrayOf(1, 2, 3, 4, 5))) // Strictly increasing
        assertEquals(0, findLongestPeak(intArrayOf(5, 4, 3, 2, 1))) // Strictly decreasing
        assertEquals(0, findLongestPeak(intArrayOf(1, 2, 2, 1)))    // Plateau in middle
    }

    @Test
    fun `single peak`() {
        assertEquals(3, findLongestPeak(intArrayOf(1, 3, 2))) // Simple peak
        assertEquals(5, findLongestPeak(intArrayOf(1, 2, 3, 2, 1))) // Symmetric peak
    }

    @Test
    fun `multiple peaks`() {
        assertEquals(6, findLongestPeak(intArrayOf(1, 2, 3, 2, 1, 2, 3, 4, 3, 2))) // Two peaks
        assertEquals(5, findLongestPeak(intArrayOf(1, 2, 3, 2, 1, 2, 1))) // Peaks of different lengths
    }

    @Test
    fun `peak at beginning`() {
        // Правильный пик в начале: [4, 1, 2] где 4 > 1 и 4 > 2
        assertEquals(0, findLongestPeak(intArrayOf(4, 1, 2, 3, 4, 5)))
    }

    @Test
    fun `peak at end`() {
        // [1, 2, 3, 4, 3] - пик на позиции 3 (значение 4)
        assertEquals(5, findLongestPeak(intArrayOf(1, 2, 3, 4, 3)))
    }

    @Test
    fun `complex peak sequences`() {
        // [1, 2, 3, 3, 2, 1] - плато, пика нет
        assertEquals(0, findLongestPeak(intArrayOf(1, 2, 3, 3, 2, 1)))

        // [1, 2, 3, 4, 3, 2, 1, 2, 3, 2] - два пика
        // Первый: [1,2,3,4,3,2,1] = 7, второй: [1,2,3,2] = 4
        assertEquals(7, findLongestPeak(intArrayOf(1, 2, 3, 4, 3, 2, 1, 2, 3, 2)))
    }

    @Test
    fun `large array with peaks`() {
        val largeArray = IntArray(1000) { index ->
            when {
                index < 499 -> index + 1                    // 1..499 (возрастание)
                index == 499 -> 1000                        // ПИК: 1000
                else -> 1000 - (index - 499)                // 999, 998, ..., 1 (убывание)
            }
        }
        // Самый длинный пик: от 1 до 1000 до 1 = 1000 элементов
        assertEquals(1000, findLongestPeak(largeArray))
    }

    @Test
    fun `edge cases with plateaus`() {
        assertEquals(0, findLongestPeak(intArrayOf(1, 1, 1))) // All equal
        assertEquals(0, findLongestPeak(intArrayOf(1, 2, 2, 1))) // Plateau at peak
        assertEquals(4, findLongestPeak(intArrayOf(1, 2, 3, 2, 2, 1))) // Plateau after peak
    }
}