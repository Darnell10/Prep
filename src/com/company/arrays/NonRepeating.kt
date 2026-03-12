package com.company.arrays

    /**
     * First Non-Repeating Integer in an Array
     *
     * Time Complexity: O(n) Two linear passes through the array — one to build the frequency map,
     * one to find the first non-repeating element.
     *
     * pace Complexity: O(n) The `HashMap` holds at most one entry per unique element, which in the worst case (all
     * unique elements) is `n` entries.
     *
     * This is the optimal solution for this problem — you cannot achieve better than O(n) time since every element
     * must be examined at least once.
     *
     */
    fun main() {
        val array = intArrayOf(9, 4, 9, 6, 7, 4)
        val myHashMap = HashMap<Int, Int>()

        for (num in array) {
            myHashMap[num] = myHashMap.getOrDefault(num, 0) + 1
        }

        println(myHashMap)

        for (i in array.indices) {
            val x = array[i]

            if (myHashMap.get(x) == 1) {
                println(x)
                break
            }
        }
    }
