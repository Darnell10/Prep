package com.company.arrays

/**
 * Merge Two Sorted Arrays
 * Time: O(n) — single pass through both arrays, where n = total combined length
 * Space: O(n) — the merged output array
 *
 * This is a classic two-pointer merge of two already-sorted arrays:
 *
 * 1.Allocate a result array of size `myArray.length + aliceArray.length`.
 *
 * 2.Maintain three indices — one for each input array and one for the output.
 *
 * 3.Loop until the merged array is full. On each iteration:
 *
 *  - If `myArray` is not exhausted AND (`aliceArray` IS exhausted OR the current element of `myArray` is smaller) → take from `myArray`.
 *  - Otherwise → take from `aliceArray`.
 *
 * 4. Return the merged, sorted array.
 *
 * Time Complexity: O(n) — single pass through both arrays, where n = total combined length\
 * Space Complexity: O(n) — the output array
 *
 */
fun main() {

    val firstArray = intArrayOf(1, 3, 5, 7, 8, 9, 11)
    val secondArray = intArrayOf(0, 2, 4, 6, 8, 10, 12)

    println(mergeArrays(firstArray, secondArray).contentToString())
}

fun mergeArrays(myArray: IntArray, aliceArray: IntArray): IntArray {

    // set up our merged array / size is equal to both arrays combined
    val mergedArray = IntArray(myArray.size + aliceArray.size)

    var currentIndexMine = 0
    var currentIndexAlice = 0
    var currentIndexMerged = 0

    while (currentIndexMerged < mergedArray.size) {

        val isMyArrayExhausted = currentIndexMine >= myArray.size
        val isAlicesArrayExhausted = currentIndexAlice >= aliceArray.size

        /** Case: next comes from my array
         *  my array must not be exhausted, and EITHER:
         *  1) Alice's array IS exhausted, or
         *  2) the current element in my array is less
         *     than the current element in Alice's array
         */
        if (!isMyArrayExhausted && (isAlicesArrayExhausted ||
                    myArray[currentIndexMine] < aliceArray[currentIndexAlice])) {

            mergedArray[currentIndexMerged] = myArray[currentIndexMine]
            currentIndexMine++

            /** Case: Alice's array isn't exhausted */
        } else {

            mergedArray[currentIndexMerged] = aliceArray[currentIndexAlice]
            currentIndexAlice++
        }
        currentIndexMerged++
    }

    return mergedArray
}
