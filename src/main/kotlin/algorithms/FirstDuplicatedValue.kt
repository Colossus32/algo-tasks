package org.colossus.algorithms

import kotlin.math.abs

/**
 * Finds the first duplicated value in an array using HashSet.
 *
 * Algorithm: Uses HashSet to track seen elements, returns first duplicate encountered.
 * Time Complexity: O(n) where n is array size
 * Space Complexity: O(n) for the HashSet
 *
 * @param array Input array of integers
 * @return First duplicated value or null if no duplicates found
 */
fun getFirstDuplicatedValue(array: IntArray): Int? {
    if (array.isEmpty()) return null
    val seen = mutableSetOf<Int>()

    for (element in array) {
        if (element in seen) return element
        seen.add(element)
    }

    return null
}

/**
 * Finds the first duplicated value in an array with elements in range [1, n]
 * using in-place marking with negative values.
 *
 * Constraints: 0 < array[i] <= array.size
 * Algorithm: Uses elements as indices and marks visited positions as negative
 * Time Complexity: O(n) where n is array size
 * Space Complexity: O(1)
 *
 * @param array Input array with elements in range [1, n]
 * @return First duplicated value or null if no duplicates found
 */
fun getFirstDuplicatedValueInGoodArray(array: IntArray): Int? {
    if (array.isEmpty()) return null

    for (i in array.indices) {
        val currentValue = abs(array[i])
        val targetIndex = currentValue - 1

        if (array[targetIndex] < 0) {
            return currentValue
        }
        array[targetIndex] = -array[targetIndex]
    }

    return null
}
