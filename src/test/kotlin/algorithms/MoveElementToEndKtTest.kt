package algorithms

import org.colossus.algorithms.moveElementToEnd
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class MoveElementToEndKtTest {

    @Test
    fun `empty array returns same`() {
        val input = intArrayOf()
        assertContentEquals(input, moveElementToEnd(input, 1))
    }

    @Test
    fun `array without target returns same`() {
        val input = intArrayOf(1, 2, 3, 4)
        assertContentEquals(input, moveElementToEnd(input, 5))
    }

    @Test
    fun `all elements are target`() {
        val input = intArrayOf(2, 2, 2, 2)
        assertContentEquals(input, moveElementToEnd(input, 2))
    }

    @Test
    fun `moves single target to end`() {
        val input = intArrayOf(1, 2, 3, 2, 4)
        val expected = intArrayOf(1, 4, 3, 2, 2)
        assertContentEquals(expected, moveElementToEnd(input, 2))
    }

    @Test
    fun `moves multiple targets to end`() {
        val input = intArrayOf(3, 1, 2, 4, 2, 2, 5)
        val expected = intArrayOf(3, 1, 5, 4, 2, 2, 2)
        assertContentEquals(expected, moveElementToEnd(input, 2))
    }

    @Test
    fun `maintains order of non-target elements`() {
        val input = intArrayOf(5, 1, 5, 5, 3, 2, 5, 4)
        val expected = intArrayOf(4, 1, 2, 3, 5, 5, 5, 5)
        assertContentEquals(expected, moveElementToEnd(input, 5))
    }

    @Test
    fun `works with negative numbers`() {
        val input = intArrayOf(-1, -3, 2, -3, 4)
        val expected = intArrayOf(-1, 4, 2, -3, -3)
        assertContentEquals(expected, moveElementToEnd(input, -3))
    }
}