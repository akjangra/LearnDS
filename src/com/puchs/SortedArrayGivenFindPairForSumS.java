package com.puchs;

import com.sun.tools.javac.util.Pair;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArrayGivenFindPairForSumS {
    public static void main(String[] args) {
        System.out.println("SortedArrayGivenFindPairForSumS");

        int[] sortedArray = {2, 6, 8, 12, 34, 45, 65, 69, 78, 81, 88, 90, 100};
        int len = sortedArray.length;
        System.out.println("Array = " + Arrays.toString(sortedArray));

        System.out.println("What sum you are looking for(enter positive int) = ");
        Scanner in = new Scanner(System.in);
        int sum = Integer.parseInt(in.nextLine());

        //Out of range can be ignored  here to avoid unnecessary work
        if (len <= 1 || sum <= sortedArray[0] || sum > (sortedArray[len - 1] + sortedArray[len - 2])) {
            System.out.println("No such pair exists.");
        }

        findPairForSum(sortedArray, len, sum);  // Also called 2sum
        find3Sum(sortedArray, len, sum);        // Also called Triplets or 3sum
        find4Sum(sortedArray, len, sum);        // called 4sum
    }

    private static void findPairForSum(int[] arr, int len, int sum) {
        int i = 0, j = len - 1;
        Pair<Integer, Integer> pair = null;
        while (i < j) {
            if (arr[i] + arr[j] == sum) {
                pair = new Pair<>(arr[i], arr[j]);
                break;
            }
            if (arr[i] + arr[j] < sum) {
                i++;
            }

            if (arr[i] + arr[j] > sum) {
                j--;
            }
        }
        System.out.println("Pair = " + pair);
    }

    /**
     * Find3Sum - complexity : O(n2) where n is length of the input array ??
     *
     * @param arr    input Array
     * @param n      length of arr
     * @param target sum to find triplets for
     */
    private static void find3Sum(int[] arr, int n, int target) {
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (target == sum) {
                    System.out.println("\n Find3Sum : " + target + "   = " + arr[i] + " + " + arr[j] + " + " + arr[k]);
                    return; //Remember this -- very important
                } else if (sum < target) {
                    j++;
                } else { //sum > target
                    k--;
                }
            }
        }
        System.out.println("\n Find3Sum : " + target + "  No such 3 ints found");
    }

    /**
     * Find4Sum - complexity : O(n3) where n is length of the input array ??
     *
     * @param arr    input Array
     * @param n      length of arr
     * @param target sum to find triplets for
     */
    private static void find4Sum(int[] arr, int n, int target) {
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (target == sum) {
                        System.out.println("\n Find4Sum : " + target + "  = " + arr[i] + " + " + arr[j] + " + " + arr[k] + " + " + arr[l]);
                        return; //Remember this -- very important
                    } else if (sum < target) {
                        k++;
                    } else { //sum > target
                        l--;
                    }
                }
            }
        }
        System.out.println("\n Find4Sum : " + target + "  No such 4 ints found");
    }
}
