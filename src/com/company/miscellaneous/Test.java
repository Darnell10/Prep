package com.company.miscellaneous;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        int[] array = {1, 4, 6, 76, 34, 6, 9, 90, 100, 23, 42, 64};

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        int numberQuested = Arrays.binarySearch(array, 90);

        System.out.println(numberQuested);


    }

    public static int indexSearch(int[] array, int number) {
        Arrays.sort(array);

        int numberRequested = Arrays.binarySearch(array, number);

        int valueOfIndex = (int)Array.get(array,numberRequested);

        return valueOfIndex;
    }


}
