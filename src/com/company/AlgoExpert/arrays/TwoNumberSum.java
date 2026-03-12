package com.company.AlgoExpert.arrays;

import java.util.Arrays;
import java.util.HashMap;

/** find 2 numbers in the array that when added equal the target number */
public class TwoNumberSum {

    public static void main(String[] args) {

        int[] array = {10, 3, 6, 8, 3, 34, 21, 3, 12};
        //3,3,3,6,8,10,12,21,34

        System.out.println(Arrays.toString(twoNumberSum1(array, 20)));

        System.out.println(Arrays.toString(twoNumberSum2(array, 34)));

        System.out.println(Arrays.toString(twoNumberSum3(array, 21)));

    }

    /**
     * `twoNumberSum2` — HashMap
     * For each number, it checks if its complement (`target - num`) is already in the map.
     * Time: O(n)
     * Space: O(n) — stores numbers in the HashMap
     * */

    public static int[] twoNumberSum2(int[] array, int target) {
        int[] myArray = {};
        HashMap<Integer, Boolean> myHash = new HashMap();
        for (int num : array) {
            int match = target - num;
            if (myHash.containsKey(match)) {
                return myArray = new int[]{match, num};
            } else {
                myHash.put(num, true);
            }
        }
        return myArray;
    }

    /**
     * `twoNumberSum1` — Brute Force
     * Nested loops check every possible pair.
     * Time: O(n²) — every pair is checked
     * Space: O(1)
     * */

    public static int[] twoNumberSum1(int[] array, int target) {
        int[] newArray = {};

        for (int i = 0; i < array.length - 1; i++) {
            int firstNum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int secondNum = array[j];
                if (firstNum + secondNum == target) {
                    newArray = new int[]{firstNum, secondNum};
                    return newArray;
                }
            }
        }
        return newArray;
    }

    /**
     *  `twoNumberSum3` — Sort + Two Pointers ✅
     * Sorts the array, then uses a left and right pointer moving inward:
     * - Sum too small → advance left pointer (increase sum)
     * - Sum too large → advance right pointer (decrease sum)
     * - Sum matches → return the pair
     * Time : O(nLog(n)), Space: O(1)
     */
    public static int[] twoNumberSum3(int[] array, int target) {
        //int[] newArray = new int[2];
        // Sort out array
        Arrays.sort(array);
        // create Pointers
        int leftPointer = 0;
        int rightPointer = array.length - 1;

        while (leftPointer < rightPointer) {
            // gives us the current sum of the left and right pointer.
            int currentSum = array[leftPointer] + array[rightPointer];
            // if the currentSum and target are equal then we add left and right pointer
            // to the newArray and return the new array
            if (currentSum == target) {
                return new int[] {array[leftPointer],array[rightPointer]};
                //if the currentSum is less than target slide left pointer
            } else if (currentSum < target) {
                leftPointer += 1;
                //if the currentSum is less than target slide right pointer
            } else if (currentSum > target){
                rightPointer -= 1;
            }
        }
        return new int[0];
    }

}
