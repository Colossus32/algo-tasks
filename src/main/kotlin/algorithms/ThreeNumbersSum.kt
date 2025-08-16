package org.colossus.algorithms

/**
 * Finds all unique triplets in the array which gives the sum of target.
 *
 * Algorithm: Modified "3Sum" with two pointers approach
 * Time Complexity: O(n^2) - where n is the size of input list
 * Space Complexity: O(1) (excluding output storage) or O(n) (if counting sorting space)
 *
 * @param source List of integers to search in
 * @param target Target sum to achieve
 * @return List of Triples (value1, value2, value3) that sum to target, or null if input too small
 */
fun findThreeNumbersSum(source: List<Int>, target: Int): List<Triple<Int, Int, Int>>? {
    if (source.size < 3) return null

    val result: MutableList<Triple<Int, Int, Int>> = mutableListOf()
    source.sorted()
        .let {
            for (i in 0 until source.size - 2) {

                if (i > 0 && it[i] == it[i - 1]) continue

                var leftPointer = i + 1
                var rightPointer = it.size - 1

                while (leftPointer < rightPointer) {
                    val baseValue = it[i]
                    val leftValue = it[leftPointer]
                    val rightValue = it[rightPointer]
                    val sum = baseValue + leftValue + rightValue

                    when {
                        sum == target -> {
                            result.add(Triple(baseValue, leftValue, rightValue))
                            leftPointer++
                            rightPointer--

                            while (leftPointer < rightPointer && it[leftPointer - 1] == it[leftPointer]) leftPointer++
                            while (leftPointer < rightPointer && it[rightPointer + 1] == it[rightPointer]) rightPointer--
                        }
                        sum > target -> rightPointer--
                        else -> leftPointer++
                    }
                }
            }
        }

    return result
}
