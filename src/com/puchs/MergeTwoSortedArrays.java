package com.puchs;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println("MergeTwoSortedArrays");

        int[] arr1 = {12, 15, 18, 28, 55, 67, 77, 88, 98, 99};

        int[] arr2 = {10, 13, 16, 29, 45, 57, 58, 111, 118, 99};

        int[] result = getMergedOutput(arr1, arr2);
        System.out.println("Result = " + Arrays.toString(result));
    }

    private static int[] getMergedOutput(int[] arr1, int[] arr2) {
        if(arr1.length == 0)
            return arr2;

        if(arr2.length ==0) {
            return arr1;
        }
        int len = arr1.length + arr2.length;
        int result[] = new int[len];
        int k = 0, i = 0, j = 0 ; ;
        for(;i < arr1.length && k < len && j < arr2.length ; k++) {
            if(arr1[i] <= arr2[j]) {
                result[k] = arr1[i++];
            } else {
                result[k] = arr2[j++];
            }
        }
            while(k < len && i < arr1.length) {
                result[k++] = arr1[i++];
            }

            while(k < len && j < arr2.length) {
                result[k++] = arr2[j++];
            }
        return result;
    }
}
