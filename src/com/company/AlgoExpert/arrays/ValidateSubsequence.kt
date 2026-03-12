package com.company.AlgoExpert.arrays

import java.util.*

    /**
     * Validate whether an array is a subsequence of a larger array.
     * must contain some numbers from the original array and items must be in the same order
     * Goal: Check if a sequence is a valid subsequence of a larger array.
     * Valid means every element of sequence appears in array in the same relative order (but not necessarily adjacent).
     */
    fun main() {
        // Test 1: valid subsequence → true
        val array1 = mutableListOf<Int?>(5, 1, 22, 25, 6, -1, 8, 10)
        val sequence1 = mutableListOf<Int?>(1, 6, -1, 10)
        println("Test 1 (expect true):  " + isValidSequence(array1, sequence1))

        // Test 2: wrong order — not a valid subsequence → false
        val array2 = mutableListOf<Int?>(5, 1, 22, 25, 6, -1, 8, 10)
        val sequence2 = mutableListOf<Int?>(10, 6, 1)
        println("Test 2 (expect false): " + isValidSequence(array2, sequence2))

        // Test 3: large values (validates .equals() fix) → true
        val array3 = mutableListOf<Int?>(200, 400, 100, 300)
        val sequence3 = mutableListOf<Int?>(200, 300)
        println("Test 3 (expect true):  " + isValidSequence(array3, sequence3))
    }

    /**Time: O(n), Space: O(1)
     * - Two index variables walk both lists simultaneously.
     *
     * - Every iteration, `arrayIndex` advances unconditionally.
     *
     * - `sequenceIndex` only advances when a match is found.
     *
     * - If `sequenceIndex` reaches the end of `sequence`, all elements were matched in order → `true`.
     *
     * */
    fun isValidSequence(array: MutableList<Int?>, sequence: MutableList<Int?>): Boolean {
        var arrayIndex = 0
        var sequenceIndex = 0

        while (arrayIndex < array.size && sequenceIndex < sequence.size) {
            if (array[arrayIndex] == sequence[sequenceIndex]) {
                sequenceIndex++
            }
            arrayIndex++
        }
        return sequenceIndex == sequence.size
    }
