package com.company.AlgoExpert.arrays

/**
 * if  elements in an array  match the Target element move it to the back of the array
 *
 * ## Algorithm — Two-Pointer Approach
 * Time O(n) — each pointer moves at most n steps total.
 * Space O(1) — in-place, only two integer variables used.
 * Two pointers start at opposite ends of the list:
 * - `i` starts at the __left__ (index 0)
 * - `j` starts at the __right__ (last index)
 *
 * Step 1 — Shrink `j`:While `j` already points to `toMove`, move it left. This ensures we never swap `toMove`
 * into a position that should already hold `toMove`.
 * Step 2 — Check `i`:If the element at `i` equals `toMove`, swap `array[i]` and `array[j]`.
 * Step 3 — Advance `i`:Move `i` forward. Repeat until `i >= j`.
 */
fun main() {

}

fun moveElementToEnd(array: MutableList<Int?>, toMove: Int): MutableList<Int?> {
    var i = 0
    var j = array.size - 1
    while (i < j) {
        while (i < j && array.get(j) == toMove) j--
        if (array.get(i) == toMove) swap(i, j, array)
        i++
    }

    return array
}

fun swap(i: Int, j: Int, array: MutableList<Int?>) {
    val temp: Int = array.get(j)!!
    array.set(j, array.get(i))
    array.set(i, temp)
}
