package com.puchs;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArrayGivenFindPairForSumS {
    public static void main(String[] args) {
        System.out.println("SortedArrayGivenFindPairForSumS");

        int[] sortedArray = {2, 6, 8, 12, 34, 45, 65, 66, 78, 81, 88, 90, 100};
        int len = sortedArray.length;
        System.out.println("Array = " + Arrays.toString(sortedArray));

        System.out.println("What sum you are looking for(enter positive int) = ");
        Scanner in = new Scanner(System.in);
        int sum = Integer.parseInt(in.nextLine());

        //Out of range can be ignored  here to avoid unnecessary work
        if(len <= 1 || sum <= sortedArray[0] || sum > (sortedArray[len-1] + sortedArray[len - 2])) {
            System.out.println("No such pair exists.");
        }

        findPairForSum(sortedArray, len, sum);
    }

    private static void findPairForSum(int[] arr, int len, int sum) {
        int i = 0,  j = len - 1;
        Pair<Integer, Integer> pair = null;
        while(i < j) {
            if(arr[i] + arr[j] == sum) {
                pair = new Pair<>(arr[i],arr[j]);
                break;
            }
            if(arr[i] + arr[j] < sum) {
                i++;
            }

            if(arr[i] + arr[j] > sum) {
                j--;
            }
        }
        System.out.println("Pair = " + pair);
    }
}
