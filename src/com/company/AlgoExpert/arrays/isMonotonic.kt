package com.company.AlgoExpert.arrays


fun main() {
    val array = intArrayOf(2, 2, 2, 1, 4, 5)
    val array2 = intArrayOf(1, 2, 3, 4, 4, 5)

    println(isMonotonic(array))
    println(isMonotonic(array2))
}

/**
 * Time Complexity: O(n)
 * The algorithm iterates through the array exactly once with a single `for` loop (from index `1` to `array.length - 1`).
 * Each element is visited once, so the time scales linearly with the size of the input array `n`.
 *
 * Space Complexity: O(1)
 * Only two boolean variables (`isNonDecreasing` and `isNonIncreasing`) are used regardless of the input size.
 * No additional data structures or recursive call stack are created. The space used is constant.
 *
 * */

fun isMonotonic(array: IntArray): Boolean {
    var isNonDecreasing = true
    var isNonIncreasing = true

    for (i in 1..<array.size) {
        if (array[i] < array[i - 1]) {
            isNonDecreasing = false
        }
        if (array[i] > array[i - 1]) {
            isNonIncreasing = false
        }
    }

    return isNonDecreasing || isNonIncreasing
}
