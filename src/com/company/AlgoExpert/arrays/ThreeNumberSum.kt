package com.company.AlgoExpert.arrays

import java.util.*
import java.util.function.Consumer

/**
 *
 */
fun main(args: Array<String>) {
    val array = intArrayOf(1, -8, 2, -6, 3, 5, 12, 6)

    // Test 1: target = 0 → [[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
    println("Target 0:")
    threeNumberSum(array, 0).forEach(Consumer { t: Array<Int?>? -> println(t.contentToString()) })

    // Test 2: target = 3 → [[-8, 5, 6], [-6, 3, 6]]
    println("Target 3:")
    threeNumberSum(array, 3).forEach(Consumer { t: Array<Int?>? -> println(t.contentToString()) })

    // Test 3: target = 10 → [[-8, 6, 12], [1, 3, 6], [2, 3, 5]]
    println("Target 10:")
    threeNumberSum(array, 10).forEach(Consumer { t: Array<Int?>? -> println(t.contentToString()) })
}

/**
 * ## ThreeNumberSum — Algorithm Summary
 * Goal: Find all unique triplets in an array whose values sum to a given `targetSum`.
 *
 * How it works:
 * 1.Sort the array ascending — this is what makes the two-pointer technique work.
 * 2.Fix one element at index `i` (the outer loop). This is the "anchor" of the triplet.
 * 3.Use two pointers__ on the remaining subarray to the right of `i`:
 * - `leftPointer` starts just right of `i`
 * - `rightPointer` starts at the end of the array
 * 4.Move the pointers inward__ based on the current sum of all three:
 * - `sum == target` → valid triplet found, save it, advance __both__ pointers
 * - `sum < target` → need a larger sum → move `leftPointer` __right__
 * - `sum > target` → need a smaller sum → move `rightPointer` __left__
 * 5. Repeat until all anchors are exhausted.
 * Why sorting matters:
 * Sorting gives the array a predictable order so that shifting a pointer in one direction __always__
 * moves the sum in a known direction. Without sorting, two pointers would not reliably converge on all solutions.
 * Time : O(n^2) , Space : O(n)
 */
fun threeNumberSum(array: IntArray, targetSum: Int): MutableList<Array<Int?>?> {
    // Sort array, items from least to greatest.
    Arrays.sort(array)
    // create list of arrays to store the value to be returned.
    val triplets: MutableList<Array<Int?>?> = ArrayList<Array<Int?>?>()
    for (i in 0..<array.size - 2) {
        var leftPointer = i + 1
        var rightPointer = array.size - 1
        while (leftPointer < rightPointer) {
            val currentSum = array[i] + array[leftPointer] + array[rightPointer]
            if (currentSum == targetSum) {
                val newTriple = arrayOf<Int?>(array[i], array[leftPointer], array[rightPointer])
                triplets.add(newTriple)
                leftPointer++
                rightPointer--
            } else if (currentSum < targetSum) {
                leftPointer++
            } else if (currentSum > targetSum) {
                rightPointer--
            }
        }
    }
    return triplets
}
