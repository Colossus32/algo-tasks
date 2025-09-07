package org.colossus.algorithms

/**
 * Finds all starting indices of p's anagrams in s.
 *
 * Algorithm uses sliding window technique with frequency maps:
 * 1. Create frequency map of pattern string p
 * 2. Maintain a sliding window frequency map for current window in s
 * 3. Compare frequency maps to find anagram matches
 *
 * Time Complexity: O(n) where n is length of s
 * Space Complexity: O(1) (fixed 26 letters)
 *
 * @param s The string to search in
 * @param p The pattern string to find anagrams of
 * @return List of starting indices of anagrams
 */
fun findAnagrams(s: String, p: String): List<Int> {

    if (s.length < p.length) return listOf()

    val pattern = p.pattern()
    val store = mutableMapOf<Char, Int>()
    var left = 0
    var size = p.length
    val ind = mutableListOf<Int>()

    for (right in s.indices) {
        val char = s[right]
        store[char] = store.getOrDefault(char, 0) + 1

        if (right - left == size - 1) {
            if (equalsMap(pattern, store)) ind.add(left)
            store[s[left]] = store.getOrDefault(s[left], 0) - 1
            if (store[s[left]] == 0) store.remove(s[left])
            left++
        }
    }

    return ind
}

private fun String.pattern(): MutableMap<Char, Int> {
    val pattern = mutableMapOf<Char, Int>()
    for (char in this) pattern[char] = pattern.getOrDefault(char, 0) + 1
    return pattern
}

private fun equalsMap(first: Map<Char, Int>, second: Map<Char, Int>): Boolean {
    for ((char, count) in first) {
        if (!second.containsKey(char) || second[char] != count) return false
    }
    return true
}

/**
 * Checks if a permutation of s1 exists as a substring in s2.
 *
 * Algorithm uses sliding window technique with frequency array:
 * 1. Create frequency count array for s1 characters
 * 2. Use sliding window in s2 and maintain net frequency count
 * 3. When all counts are <= 0, it means current window contains a permutation of s1
 *
 * Time Complexity: O(n) where n is length of s2
 * Space Complexity: O(1) (fixed 26 letters)
 *
 * @param s1 The pattern string to check permutation of
 * @param s2 The string to search in
 * @return true if s2 contains a permutation of s1, false otherwise
 */
fun checkInclusion(s1: String, s2: String): Boolean {
    if (s1.length > s2.length) return false

    val count = IntArray(26)
    for (char in s1) count[char - 'a']++

    for ((right, char) in s2.withIndex()) {
        count[char - 'a']--
        if (right >= s1.length) count[s2[right-s1.length] - 'a']++
        if (count.all { it <= 0 }) return true
    }
    return false
}