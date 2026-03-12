package com.company.AlgoExpert.arrays;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {
    /**
     * Validate whether or not an array is a subsequence of a larger array.
     * must contain some numbers from the original array and items must be in the same order
     */
    public static void main(String[] args) {

        // Test 1: valid subsequence → true
        List<Integer> array1 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence1 = Arrays.asList(1, 6, -1, 10);
        System.out.println("Test 1 (expect true):  " + isValidSequence(array1, sequence1));

        // Test 2: wrong order — not a valid subsequence → false
        List<Integer> array2 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence2 = Arrays.asList(10, 6, 1);
        System.out.println("Test 2 (expect false): " + isValidSequence(array2, sequence2));

        // Test 3: large values (validates .equals() fix) → true
        List<Integer> array3 = Arrays.asList(200, 400, 100, 300);
        List<Integer> sequence3 = Arrays.asList(200, 300);
        System.out.println("Test 3 (expect true):  " + isValidSequence(array3, sequence3));
    }
    /**Time: O(n), Space: O(1)*/
    public static Boolean isValidSequence(List<Integer> array, List<Integer> sequence) {
        int arrayIndex = 0;
        int sequenceIndex = 0;

        while (arrayIndex < array.size() && sequenceIndex < sequence.size()) {
            if (array.get(arrayIndex).equals(sequence.get(sequenceIndex))) {
                sequenceIndex++;
            }
            arrayIndex++;
        }
        return sequenceIndex == sequence.size();
    }

}
