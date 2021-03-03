package com.company.AlgoExpert.arrays;

public class IsMonotonic {

    public static void main(String[] args) {

        int[] array = {2,2,2,1,4,5};
        int[] array2 = {1,2,3,4,4,5};

        System.out.println(isMonotonic(array));
        System.out.println(isMonotonic(array2));

    }

    public static boolean isMonotonic(int[] array) {
        boolean isNonDecreasing = true;
        boolean isNonIncreasing = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                isNonDecreasing = false;
            }
            if (array[i] > array[i - 1]) {
                isNonIncreasing = false;
            }
        }

        return isNonDecreasing || isNonIncreasing;
    }
}
