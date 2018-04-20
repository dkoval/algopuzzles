package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem">Recursion: Davis' Staircase</a>
 * Max Score: 30 Difficulty: Medium
 */
public class DavisStaircase {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int s = in.nextInt();
            for (int i = 0; i < s; i++) {
                int n = in.nextInt();
                int ans = numWaysToClimbStaircase(n);
                System.out.println(ans);
            }
        }
    }

    static int numWaysToClimbStaircase(int n) {
        Integer[] memo = new Integer[n + 1];
        memo[0] = 1;
        return doNumWaysToClimbStaircase(n, memo);
    }

    private static int doNumWaysToClimbStaircase(int n, Integer[] memo) {
        if (n < 0) {
            return 0;
        }
        if (memo[n] == null) {
            memo[n] = doNumWaysToClimbStaircase(n - 1, memo)
                    + doNumWaysToClimbStaircase(n - 2, memo)
                    + doNumWaysToClimbStaircase(n - 3, memo);
        }
        return memo[n];
    }
}
