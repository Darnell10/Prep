package com.company.arrays;

import java.util.ArrayList;

public class RemoveEven {

    /**
     * Remove Even Integers from Array
     */

    public static void main(String[] args) {

        ArrayList<Integer> numberArray = new ArrayList<>();
        numberArray.add(1);
        numberArray.add(2);
        numberArray.add(3);
        numberArray.add(4);
        numberArray.add(5);
        numberArray.add(6);
        numberArray.add(7);
        numberArray.add(8);
        numberArray.add(9);
        numberArray.add(10);

        System.out.println(removeEven(numberArray));


    }

    public static ArrayList<Integer> removeEven(ArrayList<Integer> numberArray) {

        for (int i = 0; i < numberArray.size(); i++) {
            int even = numberArray.get(i) % 2;
            if (even == 0) {
                numberArray.remove(numberArray.remove(i));
            }
        }
        return numberArray;
    }
}
