package com.company.AlgoExpert.arrays;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {

        // Test 1: Standard case — expect [28, 26]
        int[] arrayOne = {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = {26, 134, 135, 15, 17};
        System.out.println(Arrays.toString(smallestDifference(arrayOne, arrayTwo)));

        // Test 2: Exact match exists — expect [0, 0] (diff = 0)
        int[] arrayThree = {0, 5, 10};
        int[] arrayFour = {3, 0, 8};
        System.out.println(Arrays.toString(smallestDifference(arrayThree, arrayFour)));

        // Test 3: Negative numbers — expect [-3, -3] (diff = 0)
        int[] arrayFive = {-5, -3, 10};
        int[] arraySix = {-3, 2, 15};
        System.out.println(Arrays.toString(smallestDifference(arrayFive, arraySix)));
    }

    /**
     * What it Does
     * Given two integer arrays, find the pair of numbers (one from each array) whose absolute difference is the
     * smallest, and return that pair as a two-element array.
     * ## Algorithm — Sort + Two Pointers
     * <p>
     * Step 1 — Sort both arrays. Sorting enables the two-pointer technique to work efficiently.
     * <p>
     * Step 2 — Walk both arrays simultaneously__ with pointers `indexOne` and `indexTwo`:
     * If `firstNum < secondNum` → the difference is `secondNum - firstNum`, advance `indexOne`
     * (try to close the gap by getting a bigger number from arrayOne)
     * If `secondNum < firstNum` → the difference is `firstNum - secondNum`, advance `indexTwo`
     * (try to close the gap by getting a bigger number from arrayTwo)
     * If `firstNum == secondNum` → difference is `0`, which is the smallest possible → __return immediately__
     * <p>
     * Step 3 — Track the best pair.__ After computing `current`, if it's less than `smallest`, update `smallest`
     * and record the pair.
     * <p>
     * ## Complexity
     * Time  O(n log n + m log m) — dominated by sorting both arrays (n = arrayOne length, m = arrayTwo length);
     * the two-pointer walk is O(n + m)
     * Space O(1) — sorting is in-place, only a few integer variables and a fixed-size result array of
     * 2 elements are used
     *
     */

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int indexOne = 0;
        int indexTwo = 0;
        int smallest = Integer.MAX_VALUE;
        int current = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];

        while (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
            int firstNum = arrayOne[indexOne];
            int secondNum = arrayTwo[indexTwo];

            if (firstNum < secondNum) {
                current = secondNum - firstNum;
                indexOne++;
            } else if (secondNum < firstNum) {
                current = firstNum - secondNum;
                indexTwo++;
            } else {
                return new int[]{firstNum, secondNum};
            }

            if (smallest > current) {
                smallest = current;
                smallestPair = new int[]{firstNum, secondNum};
            }
        }
        return smallestPair;
    }

}
