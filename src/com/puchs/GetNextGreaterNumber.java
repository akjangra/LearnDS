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

        int[] digits = numberToDigits(num, length);
        playWithDigits(digits, length);

    }

    private static void playWithDigits(int[] digits, int len) {
        int i = len - 1;
        while (i > 0) {
            if(digits[i] > digits[i-1]) {
                int temp = digits[len -1];
                digits[len - 1] = digits[i - 1];
                digits[i - 1] = temp;
                break;
            }
            i--;
        }

        if (i == 0) {
            System.out.println("Not possible");
            return;
        }

        //Sort remaining digits
        System.out.println("digits = before sort - " + Arrays.toString(digits));
        Arrays.sort(digits, i, len -1);
        System.out.println("digits = after sort - " + Arrays.toString(digits));
        int[] temp = new int[len-i];
        System.arraycopy(digits, i, temp ,0, len-i);
        System.out.println("temp = " + Arrays.toString(temp));
        Arrays.sort(temp);
        System.out.println("temp after sort= " + Arrays.toString(temp));
        System.arraycopy(temp, 0, digits, i, len - i);
        System.out.println("digits finally = " + Arrays.toString(digits));
        System.out.println( "NextGreaterNum is = " + digitsToNumber(digits));
    }


    private static int digitsToNumber(int[] digits) {
        int n = 0;
        for (int i = 0; i < digits.length; i++) {
            n = n * 10 + digits[i];
        }
        return n;
    }

    private static int[] numberToDigits(int num, int len) {
        int[] digits = new int[len];
        int i = len - 1;
        while(num > 0) {
            digits[i] = num % 10;
            num /= 10;
            i--;
        }
        System.out.println(Arrays.toString(digits));
        return digits;
    }
}
