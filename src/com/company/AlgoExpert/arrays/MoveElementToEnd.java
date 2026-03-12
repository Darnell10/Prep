package com.company.AlgoExpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
    /**
     * if  elements in an array  match the Target element move it to the back of the array
     * <p>
     * ## Algorithm — Two-Pointer Approach
     * Time O(n) — each pointer moves at most n steps total.
     * Space O(1) — in-place, only two integer variables used.
     * Two pointers start at opposite ends of the list:
     * - `i` starts at the __left__ (index 0)
     * - `j` starts at the __right__ (last index)
     * <p>
     * Step 1 — Shrink `j`:While `j` already points to `toMove`, move it left. This ensures we never swap `toMove`
     * into a position that should already hold `toMove`.
     * Step 2 — Check `i`:If the element at `i` equals `toMove`, swap `array[i]` and `array[j]`.
     * Step 3 — Advance `i`:Move `i` forward. Repeat until `i >= j`.
     */
    public static void main(String[] args) {

    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            while (i < j && array.get(j) == toMove) j--;
            if (array.get(i) == toMove) swap(i, j, array);
            i++;
        }

        return array;
    }

    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }
}
