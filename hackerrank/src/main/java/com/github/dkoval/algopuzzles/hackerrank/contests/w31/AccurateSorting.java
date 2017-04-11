package com.github.dkoval.algopuzzles.hackerrank.contests.w31;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/w31/challenges/accurate-sorting">Problem:</a>
 * * Max Score: 25 Difficulty: Easy
 */
public class AccurateSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while (q-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            // solution
            boolean ans = solve(arr);
            System.out.println(ans ? "Yes" : "No");
        }
    }

    public static boolean solve(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int first = arr[i];
            int second = arr[i + 1];
            if (first > second) {
                if (first - second == 1) {
                    // try to keep the array sorted in ascending order by swapping two adjacent elements
                    // as long as the absolute difference between these elements is 1
                    arr[i] = second;
                    arr[i + 1] = first;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
