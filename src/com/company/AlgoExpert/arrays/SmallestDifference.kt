package com.company.AlgoExpert.arrays

import java.util.*

fun main() {

    // Test 1: Standard case — expect [28, 26]
    val arrayOne = intArrayOf(-1, 5, 10, 20, 28, 3)
    val arrayTwo = intArrayOf(26, 134, 135, 15, 17)
    println(smallestDifference(arrayOne, arrayTwo).contentToString())

    // Test 2: Exact match exists — expect [0, 0] (diff = 0)
    val arrayThree = intArrayOf(0, 5, 10)
    val arrayFour = intArrayOf(3, 0, 8)
    println(smallestDifference(arrayThree, arrayFour).contentToString())

    // Test 3: Negative numbers — expect [-3, -3] (diff = 0)
    val arrayFive = intArrayOf(-5, -3, 10)
    val arraySix = intArrayOf(-3, 2, 15)
    println(smallestDifference(arrayFive, arraySix).contentToString())
}

/**
 * What it Does
 * Given two integer arrays, find the pair of numbers (one from each array) whose absolute difference is the
 * smallest, and return that pair as a two-element array.
 * ## Algorithm — Sort + Two Pointers
 *
 * Step 1 — Sort both arrays. Sorting enables the two-pointer technique to work efficiently.
 *
 * Step 2 — Walk both arrays simultaneously__ with pointers `indexOne` and `indexTwo`:
 * If `firstNum < secondNum` → the difference is `secondNum - firstNum`, advance `indexOne`
 * (try to close the gap by getting a bigger number from arrayOne)
 * If `secondNum < firstNum` → the difference is `firstNum - secondNum`, advance `indexTwo`
 * (try to close the gap by getting a bigger number from arrayTwo)
 * If `firstNum == secondNum` → difference is `0`, which is the smallest possible → __return immediately__
 *
 * Step 3 — Track the best pair.__ After computing `current`, if it's less than `smallest`, update `smallest`
 * and record the pair.
 *
 * ## Complexity
 * Time  O(n log n + m log m) — dominated by sorting both arrays (n = arrayOne length, m = arrayTwo length);
 * the two-pointer walk is O(n + m)
 * Space O(1) — sorting is in-place, only a few integer variables and a fixed-size result array of
 * 2 elements are used
 */
fun smallestDifference(arrayOne: IntArray, arrayTwo: IntArray): IntArray? {
    Arrays.sort(arrayOne)
    Arrays.sort(arrayTwo)
    var indexOne = 0
    var indexTwo = 0
    var smallest = Int.Companion.MAX_VALUE
    var current = Int.Companion.MAX_VALUE
    var smallestPair = IntArray(2)

    while (indexOne < arrayOne.size && indexTwo < arrayTwo.size) {
        val firstNum = arrayOne[indexOne]
        val secondNum = arrayTwo[indexTwo]

        if (firstNum < secondNum) {
            current = secondNum - firstNum
            indexOne++
        } else if (secondNum < firstNum) {
            current = firstNum - secondNum
            indexTwo++
        } else {
            return intArrayOf(firstNum, secondNum)
        }

        if (smallest > current) {
            smallest = current
            smallestPair = intArrayOf(firstNum, secondNum)
        }
    }
    return smallestPair
}