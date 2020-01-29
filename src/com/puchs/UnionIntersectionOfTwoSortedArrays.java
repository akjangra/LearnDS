package com.puchs;

import java.util.ArrayList;
import java.util.List;

public class UnionIntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println("UnionIntersectionOfTwoSortedArrays");

        int[] A = {1, 3, 5, 7, 9, 13, 17, 19};
        int[] B = {2, 4, 5, 6, 9, 13, 18, 19, 21, 23};
        int lenA = A.length;
        int lenB = B.length;

        findInterSection(A, B, lenA, lenB);
        findUnion(A, B, lenA, lenB);
    }

    private static void findInterSection(int[] A, int[] B, int n, int m) {
        int i = 0, j = 0; //For A and B respectively
        List<Integer> list = new ArrayList<>(); //Declared list to avoid creating an int[] with unknown size

        while(i < n && j < m) {
            if(A[i] == B[j]) {
                list.add(A[i]);
                i++;
                j++;
            }
            else if(A[i] > B[j]) {
                j++;
            } else if(A[i] < B[j]) {
                i++;
            }
        }
        System.out.println("Intersection Result = " + list.toString());
    }

    private static void findUnion(int[] A, int[] B, int n, int m) {
        int i = 0, j = 0; //For A and B respectively
        List<Integer> list = new ArrayList<>(); //Declared list to avoid creating an int[] with unknown size

        while(i < n && j < m) {
            if(A[i] == B[j]) {
                list.add(A[i]);
                i++;
                j++;
            }
            else if(A[i] < B[j]) {  // Only to keep the sorted order
                list.add(A[i++]);   // Remember increment ++
            } else {
                list.add(B[j++]);   //Remember increment ++
            }
        }

        //Important if size of the arrays are different
        while (i < n) {
            list.add(A[i]);
            i++; // Remember increment ++
        }

        while (j < m) {
            list.add(B[j]);
            j++; // Remember increment ++
        }
        System.out.println("Union Result = " + list.toString());
    }
}
