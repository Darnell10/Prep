package com.company.AlgoExpert.arrays;

import java.util.List;

public class ValidateSubsequence {
    /**
     * Validate whether or not an array is a subsequence of a larger array.
     * must contain some numbers from the original array and items must be in the same order
     */
    public static void main(String[] args) {


    }

    public static Boolean isValidSequence(List<Integer> array, List<Integer> sequence) {
        int arrayIndex = 0;
        int sequenceIndex = 0;

        while (arrayIndex < array.size() && sequenceIndex < sequence.size()) {
            if (array.get(arrayIndex) == sequence.get(sequenceIndex)) {
                sequenceIndex++;
            }
            arrayIndex++;
        }
        return sequenceIndex == sequence.size();
    }

}
