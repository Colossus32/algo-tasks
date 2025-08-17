package algorithms

import org.colossus.algorithms.smallestDifference
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestDifferenceKtTest {
    @Test
    fun `empty list returns null`() {
        assertNull(smallestDifference(emptyList(), listOf(1, 2, 3)))
        assertNull(smallestDifference(listOf(1, 2, 3), emptyList()))
        assertNull(smallestDifference(emptyList(), emptyList()))
    }

    @Test
    fun `identical elements return zero`() {
        assertEquals(0, smallestDifference(listOf(1), listOf(1)))
        assertEquals(0, smallestDifference(listOf(1, 2, 3), listOf(2, 5, 7)))
    }

    @Test
    fun `finds smallest difference`() {
        assertEquals(1, smallestDifference(listOf(1, 3, 5), listOf(2, 4, 6)))
        assertEquals(2, smallestDifference(listOf(10, 20, 30), listOf(12, 22, 32)))
    }

    @Test
    fun `works with negative numbers`() {
        assertEquals(1, smallestDifference(listOf(-5, -3, -1), listOf(-4, -2, 0)))
        assertEquals(2, smallestDifference(listOf(-10, -5), listOf(-7, 0, 5)))
    }

    @Test
    fun `large lists performance`() {
        val bigList1 = List(100_000) { it * 2 }  // Even numbers
        val bigList2 = List(100_000) { it * 2 + 1 }  // Odd numbers
        assertEquals(1, smallestDifference(bigList1, bigList2))
    }

    @Test
    fun `uneven list sizes`() {
        assertEquals(1, smallestDifference(listOf(1, 10, 100), listOf(2, 11, 99, 101)))
        assertEquals(5, smallestDifference(listOf(5), listOf(0, 10, 20)))
    }
}