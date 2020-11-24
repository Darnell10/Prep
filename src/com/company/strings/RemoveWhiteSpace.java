package com.company.strings;

public class RemoveWhiteSpace {

    /*
     * Given a null terminated string, remove any white spaces (tabs or spaces).
     * Eg:  Input - "All greek  to me."
     *      Output - "Allgreektome"
     *
     * Runtime Complexity - Linear, O(n).
     * Memory Complexity - Constant, O(1).
     *
     * */

    public static void main(String[] args) {

        String string = "Amy Victoria Jervon Darnell";
        System.out.println(removeWhiteSpaces(string));

    }

    // time == O(n) /Space == O(1)
    public static String removeWhiteSpaces(String string) {
        // convert string to an Array
        char[] array = string.toCharArray();
        //track index
        int index = 0;
        // variable to return string
        String result = "";

        while (index < array.length && array[index] != '\0') {
            if (array[index] != ' ' && array[index] != '\t') {
                result += array[index];
            }
            index++;
        }

        return result;
    }

}
