package com.github.dkoval.algopuzzles.hackerrank.sorting;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/insertionsort1">Problem:</a>
 * Max Score: 30 Difficulty: Easy
 */
public class InsertionSortPart1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertIntoSorted(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    static void insertIntoSorted(int[] ar) {
        int e = ar[ar.length - 1];
        int i = ar.length - 2;
        while (i >= 0 && ar[i] > e) {
            // shift one cell to the right
            ar[i + 1] = ar[i];
            i--;
            printArray(ar);
        }
        ar[i + 1] = e;
        printArray(ar);
    }
}
