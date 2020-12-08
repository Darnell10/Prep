package com.company.integer;

import java.util.Arrays;

public class ReverseInteger {

    public static void main(String[] args) {

        /** Given a integer Input - 4321 Output - 1234 */

        System.out.println(reverseInteger(4321));

        System.out.println(reverseInteger2(4321));

    }

    public static int reverseInteger(int number) {
        int reverse = 0;
        while (number != 0) {
            reverse = reverse * 10;
            reverse = reverse + (number % 10);
            number = number / 10;
        }

        return reverse;

    }

    public static int reverseInteger2(int number) {

        String reverse = "";
        String num = String.valueOf(number);

        for (int i = num.length() - 1; i <= 0; i--) {
            reverse += reverse + i;
        }


        int result = Integer.parseInt(reverse);
        return result;

    }
}
