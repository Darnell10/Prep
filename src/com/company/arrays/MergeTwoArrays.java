package com.company.arrays;

import java.util.Arrays;

public class MergeTwoArrays {
    /**
     * Merge Two Sorted Arrays
     *Time: O(n) — single pass through both arrays, where n = total combined length
     * Space: O(n) — the merged output array
     */
    public static void main(String[] args) {

        int[] firstArray = {1,3,5,7,8,9,11};
        int[] secondArray = {0,2,4,6,8,10,12};

        System.out.println(Arrays.toString(mergeArrays(firstArray, secondArray)));

    }

    public static int[] mergeArrays(int[] myArray, int[] aliceArray) {

        //set up out merged Array / size is equal to both arrays
        int[] mergedArray = new int[myArray.length + aliceArray.length];

        int currentIndexMine = 0;
        int currentIndexAlice = 0;
        int currentIndexMerged = 0;

        while (currentIndexMerged < mergedArray.length) {

            boolean isMyArrayExhausted = currentIndexMine >= myArray.length;
            boolean isAlicesArrayExhausted = currentIndexAlice >= aliceArray.length;
            /** Case: next comes from my array
             *  my array must not be exhausted, and EITHER:
             *  1) Alice's array IS exhausted, or
             *  2) the current element in my array is less
             *     than the current element in Alice's array
             * */
            if (!isMyArrayExhausted && (isAlicesArrayExhausted ||
                    (myArray[currentIndexMine] < aliceArray[currentIndexAlice]))) {

                mergedArray[currentIndexMerged] = myArray[currentIndexMine];
                currentIndexMine++;


                /** case : Alice's array isn't exhausted */
            } else {

                mergedArray[currentIndexMerged] = aliceArray[currentIndexAlice];
                currentIndexAlice++;
            }
            currentIndexMerged++;
        }

        return mergedArray;
    }

}
