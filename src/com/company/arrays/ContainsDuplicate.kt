package com.company.arrays

fun main() {
    val firstArray = intArrayOf(1,2,3,4,4)
    val secondArray = intArrayOf(1,2,3,4,)

    println(containsDuplicate(firstArray))
    println(containsDuplicate2(secondArray))
}

fun containsDuplicate(nums: IntArray): Boolean {
    val seen = HashSet<Int>()
    for (num in nums) {
        if (!seen.add(num)) return true
    }
    return false
}

fun containsDuplicate2(nums: IntArray): Boolean =
    nums.toSet().size != nums.size
