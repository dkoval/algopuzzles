package com.github.dkoval.algopuzzles.hackerrank.sorting;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/quicksort1">Problem:</a>
 * Max Score: 10 Difficulty: Easy
 */
public class QuickSortPart1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        in.close();
        partitionInPlace(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    static void partitionInPlace(int[] ar) {
        // pivot element
        int p = ar[0];

        // The algorithm uses 3 indices left, unknown, right, maintaining the invariant left <= unknown <= right.
        // These 3 indices maintain 4 regions in the array:
        // - A[0..left-1] region contains elements < p;
        // - A[left, unknown-1] region contains elements = p;
        // - A[unknown, right] region contains unknown elements, that we have to rearrange;
        // - A[right+1, n-1] region contains elements > p.
        int left = 0, unknown = 0, right = ar.length - 1;

        // Every time we check a new (unknown) element, pointed by index unknown,
        // we put the element in the proper region,
        // thus expanding its known region and shrinking the unknown region.
        while (unknown <= right) {
            if (ar[unknown] < p) {
                swap(ar, left, unknown);
                left++;
                unknown++;
            } else if (ar[unknown] > p) {
                swap(ar, unknown, right);
                right--;
            } else {
                unknown++;
            }
        }
        printArray(ar);
    }
}
