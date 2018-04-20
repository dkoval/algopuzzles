package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-bubble-sort/problem">Sorting: Bubble Sort</a>
 * Max Score: 30 Difficulty: Easy
 */
public class BubbleSort {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int numSwaps = bubbleSort(a);
            System.out.println("Array is sorted in " + numSwaps + " swaps.");
            System.out.println("First Element: " + a[0]);
            System.out.println("Last Element: " + a[n - 1]);
        }
    }

    static int bubbleSort(int[] a) {
        int numSwaps = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    numSwaps++;
                }
            }
        }
        return numSwaps;
    }
}
