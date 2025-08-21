package org.colossus.algorithms

fun findLongestPeak(array: IntArray): Int {
    if (array.size < 3) return 0

    var longestPeak = 0
    var i = 1

    while (i < array.size - 1) {
        // Проверяем, является ли элемент пиком
        val isPeak = array[i] > array[i - 1] && array[i] > array[i + 1]

        if (isPeak) {
            // Расширяем влево до начала возрастающей последовательности
            var left = i - 1
            while (left >= 0 && (left == 0 || array[left - 1] < array[left])) {
                if (left == 0) break
                left--
            }

            // Расширяем вправо до конца убывающей последовательности
            var right = i + 1
            while (right < array.size && (right == array.size - 1 || array[right] > array[right + 1])) {
                if (right == array.size - 1) break
                right++
            }

            // Вычисляем длину пика
            val peakLength = right - left + 1
            longestPeak = maxOf(longestPeak, peakLength)

            // Переходим к концу текущего пика
            i = right
        }
        i++
    }

    return longestPeak
}
