package org.colossus.algorithms

/**
 * Performs spiral traversal of a 2D array, collecting elements in clockwise spiral order.
 *
 * Algorithm uses boundary shrinking approach with four directional passes:
 * 1. Left to right along top row
 * 2. Top to bottom along right column
 * 3. Right to left along bottom row
 * 4. Bottom to top along left column
 *
 * Time Complexity: O(n*m) where n and m are matrix dimensions
 * Space Complexity: O(1) (excluding output storage)
 *
 * @param array 2D array to traverse
 * @return List of elements in spiral order
 */
fun spiralTraverse(array: Array<IntArray>): List<Int> {
    if (array.isEmpty()) return emptyList()

    var startCol = 0
    var endCol = array[0].size - 1
    var startRow = 0
    var endRow = array.size - 1

    val result = mutableListOf<Int>()

    while (startCol <= endCol && startRow <= endRow) {
        // Top row: left to right
        for (col in startCol..endCol) {
            result.add(array[startRow][col])
        }

        // Right column: top to bottom (skip first element)
        for (row in startRow + 1..endRow) {
            result.add(array[row][endCol])
        }

        // Bottom row: right to left (if there are multiple rows)
        if (startRow < endRow) {
            for (col in endCol - 1 downTo startCol) {
                result.add(array[endRow][col])
            }
        }

        // Left column: bottom to top (if there are multiple columns)
        if (startCol < endCol) {
            for (row in endRow - 1 downTo startRow + 1) {
                result.add(array[row][startCol])
            }
        }

        startCol++
        endCol--
        startRow++
        endRow--
    }

    return result
}