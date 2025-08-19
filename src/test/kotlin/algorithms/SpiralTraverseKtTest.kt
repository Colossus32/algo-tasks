package algorithms

import org.colossus.algorithms.spiralTraverse
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SpiralTraverseKtTest {

    @Test
    fun `empty array returns empty list`() {
        assertEquals(emptyList<Int>(), spiralTraverse(emptyArray()))
    }

    @Test
    fun `single element array`() {
        assertEquals(listOf(1), spiralTraverse(arrayOf(intArrayOf(1))))
    }

    @Test
    fun `single row array`() {
        assertEquals(listOf(1, 2, 3), spiralTraverse(arrayOf(intArrayOf(1, 2, 3))))
    }

    @Test
    fun `single column array`() {
        assertEquals(listOf(1, 2, 3), spiralTraverse(arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(3)
        )))
    }

    @Test
    fun `2x2 matrix`() {
        assertEquals(listOf(1, 2, 4, 3), spiralTraverse(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )))
    }

    @Test
    fun `3x3 matrix`() {
        assertEquals(listOf(1, 2, 3, 6, 9, 8, 7, 4, 5), spiralTraverse(arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )))
    }

    @Test
    fun `4x4 matrix`() {
        assertEquals(listOf(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10),
            spiralTraverse(arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12),
                intArrayOf(13, 14, 15, 16)
            )))
    }

    @Test
    fun `rectangular matrix 3x4`() {
        assertEquals(listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
            spiralTraverse(arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12)
            )))
    }

    @Test
    fun `rectangular matrix 2x5`() {
        assertEquals(listOf(1, 2, 3, 4, 5, 10, 9, 8, 7, 6),
            spiralTraverse(arrayOf(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(6, 7, 8, 9, 10)
            )))
    }
}