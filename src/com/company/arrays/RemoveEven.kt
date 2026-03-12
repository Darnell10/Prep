package com.company.arrays

    /**
     * Remove Even Integers from Array
     */
    fun main() {
        val numberArray = ArrayList<Int?>()
        numberArray.add(1)
        numberArray.add(2)
        numberArray.add(3)
        numberArray.add(4)
        numberArray.add(5)
        numberArray.add(6)
        numberArray.add(7)
        numberArray.add(8)
        numberArray.add(9)
        numberArray.add(10)

        println(removeEven(numberArray))
    }

    fun removeEven(numberArray: ArrayList<Int?>): ArrayList<Int?> {
        var i = 0
        while (i < numberArray.size) {
            if (numberArray.get(i)!! % 2 == 0) {
                numberArray.removeAt(i)
                i--
            }
            i++
        }
        return numberArray
    }
