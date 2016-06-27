package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/common-child">Problem:</a>
 * Max Score: 60 Difficulty: Dificult
 */
public class CommonChild {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int answer = solve(s1, s2);
        System.out.println(answer);
    }

    // Good reading: https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
    static int solve(String s1, String s2) {
        // dynamic programming implementation of LCS problem
        final int m = s1.length();
        final int n = s2.length();
        // memo[i][j] contains length of LCS of S1[0..i-1] and s2[0..j-1]
        int[][] memo = new int[m + 1][n + 1];
        // row 0 and column 0 are already initialised with 0
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        // memo[m][n] contains length of LCS for s1[0..m-1] and s2[0..n-1]
        return memo[m][n];
    }
}
