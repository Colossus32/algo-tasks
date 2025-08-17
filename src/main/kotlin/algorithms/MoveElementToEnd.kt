package org.colossus.algorithms

/**
 * Moves all instances of the specified target integer to the end of the array.
 *
 * Algorithm uses two-pointer technique:
 * - Left pointer finds target elements
 * - Right pointer finds non-target elements
 * - Swaps elements when both are found
 *
 * Time Complexity: O(n) - single pass through the array
 * Space Complexity: O(1) - operates in-place
 *
 * @param array The input array to modify
 * @param target The value to move to the end
 * @return The modified array with target elements at the end
 */
fun moveElementToEnd(array: IntArray, target: Int): IntArray {
    var left = 0
    var right = array.size - 1

    while (left < right) {
        while (left < right && target == array[right]) right--

        if (array[left] == target) {
            array[left] = array[right]
            array[right] = target
        }
        left++
    }

    return array
}