package com.company.arrays;

public class SecondLargest {

    /**
     * Find Second Maximum Value in an Array
     */
    public static void main(String[] args) {

        int[] myArray = {1000,2,4,5,10,21,100};

        System.out.println(secondMaxNumber(myArray));

    }

    public static int secondMaxNumber(int[] array) {

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                secondLargest = largest;
                largest = array[i];
            } else if (array[i] > secondLargest) {
                secondLargest = array[i];
            }
        }

        return secondLargest;
    }
}
