package com.company.arrays;

import java.util.HashMap;

public class NonRepeating {
    /**
     * First Non-Repeating Integer in an Array
     */

    public static void main(String[] args) {

        int[] array = {9, 4, 9, 6, 7, 4};
        HashMap<Integer, Integer> myHashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            int currentNumber = array[i];

            if (!myHashMap.containsKey(currentNumber)) {
                myHashMap.put(currentNumber, 1);
            } else {
                myHashMap.put(currentNumber, myHashMap.get(currentNumber) + 1);
            }
        }

        System.out.println(myHashMap);

        for (int i = 0; i < array.length; i++) {

            int x = array[i];

            if (myHashMap.get(x) == 1){
                System.out.println(x);
                break;

            }
        }
    }
}
