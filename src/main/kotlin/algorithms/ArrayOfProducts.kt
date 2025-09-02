package org.colossus.algorithms

fun getArrayOfProducts(array: IntArray): IntArray {

    val products = IntArray(array.size) { 1 }
    val leftProducts = IntArray(array.size) { 1 }
    val rightProducts = IntArray(array.size) { 1 }

    var leftPointer = 1

    for (i in array.indices) {
        leftProducts[i] = leftPointer
        leftPointer *= array[i]
    }

    var rightPointer = 1
    for (i in array.size - 1 downTo 0) {
        rightProducts[i] = rightPointer
        rightPointer *= array[i]
    }

    for (i in array.indices) {
        products[i] = leftProducts[i] * rightProducts[i]
    }

    return products
}