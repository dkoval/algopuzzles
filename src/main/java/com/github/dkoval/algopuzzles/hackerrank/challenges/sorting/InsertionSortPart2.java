package com.github.dkoval.algopuzzles.hackerrank.challenges.sorting;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/insertionsort2">Problem:</a>
 * Max Score: 30 Difficulty: Easy
 */
public class InsertionSortPart2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortPart2(ar);
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    static void insertionSortPart2(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int key = ar[i];
            int j = i - 1;
            while(j >= 0 && ar[j] > key) {
                // shift one cell to the right
                ar[j + 1] = ar[j];
                j--;
            }
            ar[j + 1] = key;
            printArray(ar);
        }
    }
}
