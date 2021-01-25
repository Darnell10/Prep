package com.company.AlgoExpert.arrays;

import java.util.*;

/**
 *
 */
public class ThreeNumberSum {

    public static void main(String[] args) {

    }

    /**
     * Time : O(n^2) , Space : O(n)
     */
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> triplets = new ArrayList<Integer[]>();
        for (int i = 0; i < array.length - 2; i++) {
            int leftPointer = i + 1;
            int rightPointer = array.length - 1;
            while (leftPointer < rightPointer) {
                int currentSum = array[i] + array[leftPointer] + array[rightPointer];
                if (currentSum == targetSum) {
                    Integer[] newTriple = {array[i], array[leftPointer], array[rightPointer]};
                    triplets.add(newTriple);
                    leftPointer++;
                    rightPointer--;
                } else if (currentSum < targetSum){
                    leftPointer++;
                } else if(currentSum > targetSum){
                    rightPointer--;
                }
            }
        }
        return triplets;
    }
}
