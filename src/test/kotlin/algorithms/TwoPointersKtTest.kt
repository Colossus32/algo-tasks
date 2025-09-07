package algorithms

import org.colossus.algorithms.containerWithMostWater
import org.colossus.algorithms.partitionLabels
import org.colossus.algorithms.sortedSquares
import org.colossus.algorithms.subarraySum
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class TwoPointersKtTest {

    @Test
    fun `example from problem statement`() {
        assertEquals(49, containerWithMostWater(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }

    @Test
    fun `minimum size array`() {
        assertEquals(1, containerWithMostWater(intArrayOf(1, 1)))
    }

    @Test
    fun `tall on edges short in middle`() {
        assertEquals(16, containerWithMostWater(intArrayOf(4, 1, 1, 1, 4)))
    }

    @Test
    fun `tall in middle`() {
        assertEquals(8, containerWithMostWater(intArrayOf(1, 2, 8, 8, 2, 1)))
    }

    @Test
    fun `increasing heights`() {
        assertEquals(6, containerWithMostWater(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `decreasing heights`() {
        assertEquals(6, containerWithMostWater(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun `with zeros`() {
        assertEquals(4, containerWithMostWater(intArrayOf(0, 2, 0, 3, 0)))
    }

    @Test
    fun `large difference in heights`() {
        assertEquals(4, containerWithMostWater(intArrayOf(1, 10, 1, 1, 1)))
    }

    @Test
    fun `symmetric array`() {
        assertEquals(10, containerWithMostWater(intArrayOf(1, 5, 10, 5, 1)))
    }

    @Test
    fun `all same height`() {
        assertEquals(12, containerWithMostWater(intArrayOf(3, 3, 3, 3, 3)))
    }

    @Test
    fun `two elements different heights`() {
        assertEquals(2, containerWithMostWater(intArrayOf(2, 5)))
    }

    @Test
    fun `three elements test`() {
        assertEquals(4, containerWithMostWater(intArrayOf(2, 1, 3)))
    }

    @Test
    fun `example from problem`() {
        assertEquals(listOf(9, 7, 8), partitionLabels("ababcbacadefegdehijhklij"))
    }

    @Test
    fun `single character`() {
        assertEquals(listOf(1), partitionLabels("a"))
    }

    @Test
    fun `all same characters`() {
        assertEquals(listOf(5), partitionLabels("aaaaa"))
    }

    @Test
    fun `all different characters`() {
        assertEquals(listOf(1, 1, 1, 1, 1), partitionLabels("abcde"))
    }

    @Test
    fun `two partitions`() {
        assertEquals(listOf(3, 1, 1, 1, 1), partitionLabels("abacdef"))
    }

    @Test
    fun `overlapping partitions`() {
        assertEquals(listOf(6, 1, 1), partitionLabels("abcdeafg"))
    }

    @Test
    fun `complex case`() {
        assertEquals(listOf(2, 1, 1, 1, 1, 1, 1, 1, 1), partitionLabels("aabcdefghi"))
    }

    @Test
    fun `with repeated characters`() {
        assertEquals(listOf(7, 1), partitionLabels("ababacad"))
    }

    @Test
    fun `empty string`() {
        assertEquals(emptyList<Int>(), partitionLabels(""))
    }

    @Test
    fun `large alphabet`() {
        val largeString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        assertEquals(listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), partitionLabels(largeString))
    }

    @Test
    fun `mixed case sensitivity`() {
        assertEquals(listOf(1, 1, 1, 1, 1, 1), partitionLabels("aAbBcC"))
    }

    @Test
    fun `multiple same partitions`() {
        assertEquals(listOf(4,4), partitionLabels("ababcdcd"))
    }

    @Test
    fun `empty array`() {
        assertContentEquals(intArrayOf(), sortedSquares(intArrayOf()))
    }

    @Test
    fun `single element`() {
        assertContentEquals(intArrayOf(4), sortedSquares(intArrayOf(2)))
        assertContentEquals(intArrayOf(4), sortedSquares(intArrayOf(-2)))
    }

    @Test
    fun `all positive sorted`() {
        assertContentEquals(intArrayOf(1, 4, 9, 16, 25), sortedSquares(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `all negative sorted`() {
        assertContentEquals(intArrayOf(1, 4, 9, 16, 25), sortedSquares(intArrayOf(-5, -4, -3, -2, -1)))
    }

    @Test
    fun `mixed positive and negative`() {
        assertContentEquals(intArrayOf(1, 4, 9, 16, 25), sortedSquares(intArrayOf(-5, -3, 1, 2, 4)))
    }

    @Test
    fun `with zeros 2`() {
        assertContentEquals(intArrayOf(0, 0, 1, 4, 9), sortedSquares(intArrayOf(-3, -1, 0, 0, 2)))
    }

    @Test
    fun `all zeros`() {
        assertContentEquals(intArrayOf(0, 0, 0), sortedSquares(intArrayOf(0, 0, 0)))
    }

    @Test
    fun `large positive numbers`() {
        assertContentEquals(intArrayOf(100, 400, 900), sortedSquares(intArrayOf(10, 20, 30)))
    }

    @Test
    fun `large negative numbers`() {
        assertContentEquals(intArrayOf(100, 400, 900), sortedSquares(intArrayOf(-30, -20, -10)))
    }

    @Test
    fun `mixed large numbers`() {
        assertContentEquals(intArrayOf(100, 400, 900, 1600), sortedSquares(intArrayOf(-40, -20, 10, 30)))
    }

    @Test
    fun `symmetric array 2`() {
        assertContentEquals(intArrayOf(0, 1, 1, 4, 4, 9, 9), sortedSquares(intArrayOf(-3, -2, -1, 0, 1, 2, 3)))
    }

    @Test
    fun `only one negative`() {
        assertContentEquals(intArrayOf(1, 4, 9), sortedSquares(intArrayOf(-3, 1, 2)))
    }

    @Test
    fun `only one positive`() {
        assertContentEquals(intArrayOf(1, 4, 9), sortedSquares(intArrayOf(-3, -2, 1)))
    }

    @Test
    fun `example from problem2`() {
        assertEquals(2, subarraySum(intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun `single element equals k`() {
        assertEquals(1, subarraySum(intArrayOf(5), 5))
    }

    @Test
    fun `single element not equals k`() {
        assertEquals(0, subarraySum(intArrayOf(5), 3))
    }

    @Test
    fun `multiple subarrays with same sum`() {
        assertEquals(5, subarraySum(intArrayOf(1, 2, 3, 0, 3), 3))
    }

    @Test
    fun `negative numbers`() {
        assertEquals(6, subarraySum(intArrayOf(1, -1, 1, -1, 1), 1))
    }

    @Test
    fun `zeros in array`() {
        assertEquals(10, subarraySum(intArrayOf(0, 0, 0, 0), 0))
    }

    @Test
    fun `large k value`() {
        assertEquals(1, subarraySum(intArrayOf(100, 200, 300), 600))
    }

    @Test
    fun `empty array2`() {
        assertEquals(0, subarraySum(intArrayOf(), 5))
    }

    @Test
    fun `all elements same`() {
        assertEquals(3, subarraySum(intArrayOf(2, 2, 2, 2), 4))
    }

    @Test
    fun `k is zero with no zeros`() {
        assertEquals(0, subarraySum(intArrayOf(1, 2, 3), 0))
    }

    @Test
    fun `mixed positive and negative2`() {
        assertEquals(4, subarraySum(intArrayOf(3, 4, -7, 1, 3, 3, 1, -4), 7))
    }

    @Test
    fun `large array performance`() {
        val largeArray = IntArray(10000) { 1 }
        assertEquals(10000, subarraySum(largeArray, 1))
        assertEquals(9999, subarraySum(largeArray, 2))
    }

    @Test
    fun `prefix sum overflow case`() {
        assertEquals(1, subarraySum(intArrayOf(Int.MAX_VALUE, 1), Int.MIN_VALUE))
    }
}