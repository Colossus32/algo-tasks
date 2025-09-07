package org.colossus.algorithms

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

/**
 * Finds the maximum area of water that can be contained between two vertical lines.
 *
 * Algorithm: Uses two-pointer technique starting from both ends and moving towards center.
 * The key insight is to move the pointer with the smaller height, as this may lead to a larger area.
 *
 * Time Complexity: O(n) where n is the array size
 * Space Complexity: O(1)
 *
 * @param array Array representing the height of vertical lines
 * @return Maximum area of water that can be contained
 */
fun containerWithMostWater(array: IntArray): Int {
    var leftPointer = 0
    var rightPointer = array.size - 1
    var maxArea = 0

    while (leftPointer < rightPointer) {
        val currentArea = (rightPointer - leftPointer) * min(array[leftPointer], array[rightPointer])
        maxArea = max(maxArea, currentArea)

        if (array[leftPointer] > array[rightPointer]) rightPointer--
        else leftPointer++
    }

    return maxArea
}

/**
 * Partitions a string into as many parts as possible so that each letter appears in at most one part.
 *
 * Algorithm:
 * 1. First pass: record the last occurrence of each character
 * 2. Second pass: maintain current partition start and end indices
 * 3. For each character, update end to be the max of current end and character's last occurrence
 * 4. When current index reaches end, found a partition
 *
 * Time Complexity: O(n) where n is string length
 * Space Complexity: O(1) (only 26 letters in alphabet)
 *
 * @param s Input string
 * @return List of partition sizes
 */
fun partitionLabels(s: String): List<Int> {
    val map = mutableMapOf<Char, Int>()
    for (i in s.indices) {
        map[s[i]] = i
    }

    val list = mutableListOf<Int>()
    var start = 0
    var end = 0

    for (i in 0 until s.length) {
        end = max(end, map.get(s[i])!!)
        if (i == end) {
            list.add(end - start + 1)
            start = i + 1
        }
    }

    return list
}

/**
 * Returns an array of the squares of each number sorted in non-decreasing order.
 *
 * Algorithm uses two different strategies:
 * 1. Fast path: if all numbers are non-negative, simply square and return (already sorted)
 * 2. Slow path: if there are negative numbers, use two-pointer technique to merge
 *    squares from both ends (since negatives squared become positive and reverse-ordered)
 *
 * Time Complexity: O(n) where n is array size
 * Space Complexity: O(n) for the output array
 *
 * @param nums Input array of integers sorted in non-decreasing order
 * @return Array of squares sorted in non-decreasing order
 */
fun sortedSquares(nums: IntArray): IntArray {
    if (nums.isEmpty()) return intArrayOf()
    return if (nums[0] >= 0) fast(nums) else slow(nums)
}

/**
 * Fast path for arrays with only non-negative numbers.
 * Since input is already sorted and all numbers are non-negative,
 * squares will also be sorted.
 */
private fun fast(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    for (i in nums.indices) {
        result[i] = nums[i] * nums[i]
    }
    return result
}

/**
 * Slow path for arrays with negative numbers.
 * Uses two-pointer technique to merge squares from both ends.
 */
private fun slow(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    var left = 0
    var right = nums.size - 1

    for (i in nums.size - 1 downTo 0) {
        if (abs(nums[left]) >= abs(nums[right])) {
            result[i] = nums[left] * nums[left]
            left++
        } else {
            result[i] = nums[right] * nums[right]
            right--
        }
    }
    return result
}

/**
 * Finds the total number of continuous subarrays whose sum equals to k.
 *
 * Algorithm uses prefix sum technique with HashMap:
 * 1. Maintain running sum and count of prefix sums encountered
 * 2. For each element, compute current prefix sum
 * 3. Check if (current_sum - k) exists in map - this means there's a subarray ending at current index with sum k
 * 4. Update frequency of current prefix sum
 *
 * Time Complexity: O(n) where n is array size
 * Space Complexity: O(n) for the HashMap
 *
 * @param nums Input array of integers
 * @param k Target sum
 * @return Number of contiguous subarrays with sum exactly equal to k
 */
fun subarraySum(nums: IntArray, k: Int): Int {
    val map = mutableMapOf<Int, Int>()
    map[0] = 1

    var count = 0
    var sum = 0

    for (n in nums) {
        sum += n
        count += map[sum - k] ?: 0
        map[sum] = (map[sum] ?: 0) + 1
    }

    return count
}
