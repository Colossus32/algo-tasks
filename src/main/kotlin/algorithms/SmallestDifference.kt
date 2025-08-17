package org.colossus.algorithms

import kotlin.math.abs
import kotlin.math.min

/**
 * Finds the smallest absolute difference between any two elements from two lists.
 *
 * Algorithm uses two-pointer technique on sorted lists:
 * 1. First sorts both lists (O(n log n + m log m))
 * 2. Then compares elements using two pointers (O(n + m))
 *
 * Time Complexity: O(n log n + m log m) where n and m are list sizes
 * Space Complexity: O(1) (excluding space needed for sorting)
 *
 * @param list1 First list of integers
 * @param list2 Second list of integers
 * @return The smallest absolute difference or null if either list is empty
 */
fun smallestDifference(list1: List<Int>, list2: List<Int>): Int? {
    if (list1.isEmpty() || list2.isEmpty()) return null
    val sorted1 = list1.sorted()
    val sorted2 = list2.sorted()

    var pointer1 = 0
    var pointer2 = 0
    var minDifference = abs(sorted1[0] - sorted2[0])

    while (pointer1 < sorted1.size && pointer2 < sorted2.size) {
        val value1 = sorted1[pointer1]
        val value2 = sorted2[pointer2]
        val currentDifference = abs(value1 - value2)

        if (currentDifference == 0) return 0

        minDifference = min(minDifference, currentDifference)

        when {
            value1 < value2 -> pointer1++
            else -> pointer2++
        }
    }

    return minDifference
}