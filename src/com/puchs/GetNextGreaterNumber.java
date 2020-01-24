package com.puchs;

import java.util.Arrays;
import java.util.Scanner;

public class GetNextGreaterNumber {
    public static void main(String[] args) {
        System.out.println("Enter the num for GetNextGreaterNumber() (Positive Int only) : ");
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        int length = String.valueOf(num).length();

        if(num < 0) System.out.println("Invalid Input.");
        if(num <= 11) System.out.println("Not possible - " + num);

    }


    private static int digitsToNumber(Integer[] digits) {
        int n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i];
        }
        return n;
    }

    private static Integer[] numberToDigits(int num, int len) {
        Integer[] digits = new Integer[len];
        int i = 0;
        while(num > 0) {
            digits[i] = num % 10;
            num /= 10;
            i++;
        }
        System.out.println(Arrays.toString(digits));
        return digits;
    }
}
