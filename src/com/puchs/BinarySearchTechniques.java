package com.puchs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Binary Search always applicable to Sorted array
 */
public class BinarySearchTechniques {
    public static void main(String[] args) {
        System.out.println("BinarySearchTechniques");

        int[] sortedArr = {12, 15, 17, 19, 21, 23, 26, 29, 31, 34, 43, 91};
        System.out.println("Given sorted arr = " + Arrays.toString(sortedArr));
        System.out.println("Enter num to search in arr = ");
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        binarySearch(sortedArr, num);

        int[] sortedArrWithDuplicates = {1, 2, 2, 2, 2, 7, 7, 7, 7, 7, 7, 7, 7, 7, 15, 17, 19, 21, 23, 26, 29, 31, 34, 43, 91};
        System.out.println("Given sorted arr = " + Arrays.toString(sortedArrWithDuplicates));
        System.out.println("Enter num to search in arr(Leftmost) = ");
        Scanner input = new Scanner(System.in);
        int search = Integer.parseInt(input.nextLine());
        binarySearchLeftMost(sortedArrWithDuplicates, search);
    }

    private static void binarySearch(int[] arr, int num) {
        if(arr.length == 0 || (arr.length == 1 && arr[0] != num) || arr[0] > num || arr[arr.length-1] < num)
            System.out.println("Not found");

        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == num) {
                System.out.println("Element found at index = " + mid);
                return;
            } else if (arr[mid] > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("Element NOT found.");
    }


    private static void binarySearchLeftMost(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while(start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == num) {
                //Difference start here
                if(mid == 0 || arr[mid] > arr[mid-1]) { // For right side --> arr[mid] < arr[mid-1]
                    System.out.println("Element found at index = " + mid);
                    return;
                } else {
                    end = mid - 1; // For right side --> start = mid + 1;
                }
                //Difference END here

            } else if (arr[mid] > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println("Element NOT found.");
    }
}
