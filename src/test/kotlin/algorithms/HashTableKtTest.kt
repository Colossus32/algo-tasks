package algorithms

import org.colossus.algorithms.checkInclusion
import org.colossus.algorithms.findAnagrams
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HashTableKtTest {
    @Test
    fun `example from problem`() {
        assertEquals(listOf(0, 6), findAnagrams("cbaebabacd", "abc"))
    }

    @Test
    fun `another example`() {
        assertEquals(listOf(0, 1, 2), findAnagrams("abab", "ab"))
    }

    @Test
    fun `no anagrams found`() {
        assertEquals(emptyList<Int>(), findAnagrams("abcdef", "xyz"))
    }

    @Test
    fun `pattern longer than string`() {
        assertEquals(emptyList<Int>(), findAnagrams("abc", "abcd"))
    }

    @Test
    fun `empty strings`() {
        assertEquals(emptyList<Int>(), findAnagrams("", "abc"))
        assertEquals(emptyList<Int>(), findAnagrams("abc", ""))
        assertEquals(emptyList<Int>(), findAnagrams("", ""))
    }

    @Test
    fun `single character pattern`() {
        assertEquals(listOf(0, 2, 4), findAnagrams("abaca", "a"))
    }

    @Test
    fun `same string`() {
        assertEquals(listOf(0), findAnagrams("hello", "hello"))
    }

    @Test
    fun `repeated characters`() {
        assertEquals(listOf(0, 1, 2), findAnagrams("aaaa", "aa"))
    }

    @Test
    fun `case sensitivity`() {
        assertEquals(emptyList<Int>(), findAnagrams("ABC", "abc")) // Assuming case sensitive
    }

    @Test
    fun `large input performance`() {
        val longString = "a".repeat(10000) + "b" + "a".repeat(10000)
        val pattern = "a".repeat(100)
        val result = findAnagrams(longString, pattern)
        assertEquals(10000 - 100 + 1 + 10000 - 100 + 1, result.size)
    }

    @Test
    fun `multiple anagrams with overlaps`() {
        assertEquals(listOf(0, 1, 2, 3, 4, 5, 6), findAnagrams("abababab", "ab"))
    }

    @Test
    fun `different character sets`() {
        assertEquals(listOf(3), findAnagrams("xyzabc", "abc"))
    }

    @Test
    fun `pattern with unique characters`() {
        assertEquals(listOf(0, 2), findAnagrams("cbabc", "abc"))
    }
    @Test
    fun `example from problem2`() {
        assertTrue(checkInclusion("ab", "eidbaooo"))
        assertFalse(checkInclusion("ab", "eidboaoo"))
    }

    @Test
    fun `exact match`() {
        assertTrue(checkInclusion("hello", "hello"))
    }

    @Test
    fun `permutation at beginning`() {
        assertTrue(checkInclusion("abc", "cbadef"))
    }

    @Test
    fun `permutation at end`() {
        assertTrue(checkInclusion("abc", "defcba"))
    }

    @Test
    fun `permutation in middle`() {
        assertTrue(checkInclusion("abc", "dabcef"))
    }

    @Test
    fun `no permutation exists`() {
        assertFalse(checkInclusion("xyz", "abcdef"))
    }

    @Test
    fun `pattern longer than string2`() {
        assertFalse(checkInclusion("abcdef", "abc"))
    }

    @Test
    fun `empty pattern`() {
        assertTrue(checkInclusion("", "abc"))
        assertFalse(checkInclusion("", ""))
    }

    @Test
    fun `single character`() {
        assertTrue(checkInclusion("a", "abc"))
        assertFalse(checkInclusion("z", "abc"))
    }

    @Test
    fun `repeated characters2`() {
        assertTrue(checkInclusion("aab", "baa"))
    }

    @Test
    fun `large input performance2`() {
        val longString = "a".repeat(10000) + "b" + "c".repeat(10000)
        assertTrue(checkInclusion("abc", longString))
    }

    @Test
    fun `multiple same characters`() {
        assertTrue(checkInclusion("aaa", "bbaaaccc"))
        assertFalse(checkInclusion("aaa", "bbaaccc")) // Only two 'a's
    }

    @Test
    fun `window size exactly pattern length`() {
        assertTrue(checkInclusion("abc", "cab"))
    }

}