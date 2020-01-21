package com.puchs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GetTheBiggestNumber {
    public static void main(String[] args) {
        int num;
        System.out.println("GetTheBiggestNumber : Enter input number (Positive Integer only) - ");
        Scanner in = new Scanner(System.in);
        num = Integer.parseInt(in. nextLine());
        int length = String.valueOf(num).length();
        System.out.println(" TheBiggestNumber can be -->  " + getTheBiggestNumber(num, length));
    }

    private static int getTheBiggestNumber(int num, int len) {
        if(num < 0) return -1; //Not Supported
        if(num < 9) return num;
        Integer[] digits = getDigits(num, len);
        Arrays.sort(digits, Collections.reverseOrder());
        System.out.println(Arrays.toString(digits));
        int result = digitsToNumber(digits);
        return result;
    }

    private static int digitsToNumber(Integer[] digits) {
        int n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i];
        }
        return n;
    }

    private static Integer[] getDigits(int num, int len) {
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
