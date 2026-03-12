package com.company.AlgoExpert.arrays

/** find 2 numbers in the array that when added equal the target number */

fun main() {
    val array = intArrayOf(10, 3, 6, 8, 3, 34, 21, 3, 12)
    //3,3,3,6,8,10,12,21,34

    println(twoNumberSum1(array, 20).contentToString())
    println(twoNumberSum2(array, 34).contentToString())
    println(twoNumberSum3(array, 21).contentToString())
}

/**
 * `twoNumberSum2` — HashMap
 * For each number, it checks if its complement (`target - num`) is already in the map.
 * Time: O(n)
 * Space: O(n) — stores numbers in the HashMap
 */
fun twoNumberSum2(array: IntArray, target: Int): IntArray {
    val myHash = HashMap<Int, Boolean>()
    for (num in array) {
        val match = target - num
        if (myHash.containsKey(match)) {
            return intArrayOf(match, num)
        } else {
            myHash[num] = true
        }
    }
    return intArrayOf()
}

/**
 * `twoNumberSum1` — Brute Force
 * Nested loops check every possible pair.
 * Time: O(n²) — every pair is checked
 * Space: O(1)
 */
fun twoNumberSum1(array: IntArray, target: Int): IntArray {
    for (i in 0 until array.size - 1) {
        val firstNum = array[i]
        for (j in i + 1 until array.size) {
            val secondNum = array[j]
            if (firstNum + secondNum == target) {
                return intArrayOf(firstNum, secondNum)
            }
        }
    }
    return intArrayOf()
}

/**
 * `twoNumberSum3` — Sort + Two Pointers
 * Sorts the array, then uses a left and right pointer moving inward:
 * - Sum too small → advance left pointer (increase sum)
 * - Sum too large → advance right pointer (decrease sum)
 * - Sum matches → return the pair
 * Time: O(n log n), Space: O(1)
 */
fun twoNumberSum3(array: IntArray, target: Int): IntArray {
    array.sort()
    var leftPointer = 0
    var rightPointer = array.size - 1

    while (leftPointer < rightPointer) {
        val currentSum = array[leftPointer] + array[rightPointer]
        when {
            currentSum == target -> return intArrayOf(array[leftPointer], array[rightPointer])
            currentSum < target -> leftPointer++
            else -> rightPointer--
        }
    }
    return intArrayOf()
}
