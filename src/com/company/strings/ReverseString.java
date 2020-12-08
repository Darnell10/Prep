package com.company.strings;

public class ReverseString {

    public static void main(String[] args) {

        System.out.println(reverseString("Darnell Otto"));

        System.out.println(" Amy Darnell Jervon Victoria");


    }


    public static String reverseString(String string) {
        String reverse = "";

        char[] charArr = string.toCharArray();
        for (int i = charArr.length - 1; i >= 0; i--) {
            reverse += charArr[i];
        }
        return reverse;
    }

    public static String reverseWord(String string) {
        String reverse = "";

        String[] array = string.split(" ");
        for (int i = array.length - 1; i >= 0; i--) {
            reverse += array[i] + " ";
        }

        return reverse;


    }
}
