package com.github.dkoval.algopuzzles.hackerrank.challenges.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem">Minimum Absolute Difference in an Array</a>
 * Max Score: 15 Difficulty: Easy
 */
public class MinimumAbsoluteDifferenceInArray {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int result = minimumAbsoluteDifference(n, arr);
            System.out.println(result);
        }
    }

    static int minimumAbsoluteDifference(int n, int[] arr) {
        Arrays.sort(arr);
        int minAbsDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minAbsDiff = Math.min(minAbsDiff, Math.abs(arr[i] - arr[i - 1]));
        }
        return minAbsDiff;
    }
}
