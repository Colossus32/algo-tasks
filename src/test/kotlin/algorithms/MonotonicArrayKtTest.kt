package algorithms

import org.colossus.algorithms.isMonotonicArray
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MonotonicArrayKtTest {

    @Test
    fun `empty array is monotonic`() {
        assertTrue(isMonotonicArray(intArrayOf()))
    }

    @Test
    fun `single element array is monotonic`() {
        assertTrue(isMonotonicArray(intArrayOf(1)))
    }

    @Test
    fun `two equal elements are monotonic`() {
        assertTrue(isMonotonicArray(intArrayOf(2, 2)))
    }

    @Test
    fun `strictly increasing array is monotonic`() {
        assertTrue(isMonotonicArray(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `strictly decreasing array is monotonic`() {
        assertTrue(isMonotonicArray(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun `non-decreasing array with duplicates is monotonic`() {
        assertTrue(isMonotonicArray(intArrayOf(1, 2, 2, 3, 4)))
    }

    @Test
    fun `non-increasing array with duplicates is monotonic`() {
        assertTrue(isMonotonicArray(intArrayOf(4, 3, 3, 2, 1)))
    }

    @Test
    fun `array with both increases and decreases is not monotonic`() {
        assertFalse(isMonotonicArray(intArrayOf(1, 3, 2, 4)))
    }

    @Test
    fun `array with plateau then increase is not monotonic`() {
        assertFalse(isMonotonicArray(intArrayOf(1, 1, 2, 1)))
    }

    @Test
    fun `large monotonic array`() {
        val largeArray = IntArray(100_000) { it }  // 0..99999
        assertTrue(isMonotonicArray(largeArray))
    }

    @Test
    fun `large non-monotonic array`() {
        val largeArray = IntArray(100_000) { if (it % 2 == 0) it else -it }
        assertFalse(isMonotonicArray(largeArray))
    }
}