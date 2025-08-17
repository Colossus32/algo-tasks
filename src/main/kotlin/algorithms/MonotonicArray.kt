package org.colossus.algorithms

/**
 * Checks if the given array is monotonic (either entirely non-increasing or non-decreasing).
 *
 * Algorithm uses single pass through the array with two flags:
 * - Tracks if array could be non-decreasing
 * - Tracks if array could be non-increasing
 *
 * Time Complexity: O(n) where n is array size
 * Space Complexity: O(1)
 *
 * @param array The array to check
 * @return true if array is monotonic, false otherwise
 */
fun isMonotonicArray(array: IntArray): Boolean {

    if (array.size <= 2) return true

    var isNonDecreasing = true
    var isNonIncreasing = true

    for (i in 1 until array.size) {
        when {
            array[i] > array[i - 1] -> isNonIncreasing = false
            array[i] < array[i - 1] -> isNonDecreasing = false
        }
        if (!isNonIncreasing && !isNonDecreasing) return false
    }

    return isNonIncreasing || isNonDecreasing
}
