package algorithms

import org.colossus.algorithms.findThreeNumbersSum
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class ThreeSumTest {

    @Test
    fun `test empty list returns null`() {
        assertNull(findThreeNumbersSum(emptyList(), 0))
    }

    @Test
    fun `test small list returns null`() {
        assertNull(findThreeNumbersSum(listOf(1, 2), 3))
    }

    @Test
    fun `test exact three elements match`() {
        assertEquals(
            listOf(Triple(1, 2, 3)),
            findThreeNumbersSum(listOf(1, 2, 3), 6)
        )
    }

    @Test
    fun `test multiple solutions`() {
        val result = findThreeNumbersSum(listOf(-1, 0, 1, 2, -1, -4), 0)
        assertEquals(
            listOf(
                Triple(-1, -1, 2),
                Triple(-1, 0, 1)
            ),
            result
        )
    }

    @Test
    fun `test no solution returns empty`() {
        assertEquals(
            emptyList<Triple<Int, Int, Int>>(),
            findThreeNumbersSum(listOf(1, 2, 3), 10)
        )
    }

    @Test
    fun `test with duplicates`() {
        val result = findThreeNumbersSum(listOf(0, 0, 0, 0), 0)
        assertEquals(
            listOf(Triple(0, 0, 0)),
            result
        )
    }

    @Test
    fun `test large input`() {
        val largeList = List(1000) { it }
        val target = 2994 // 999 + 998 + 997
        val result = findThreeNumbersSum(largeList, target)
        assertEquals(
            listOf(Triple(997, 998, 999)),
            result
        )
    }
}