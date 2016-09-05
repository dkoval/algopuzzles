package com.github.dkoval.algopuzzles.firecode.level3;

/**
 * You're given a game board that has m x n squares on it, represented by an m x n array.
 * Write a method - countPaths that takes in m and n and returns the number of possible paths
 * from the top left corner to the bottom right corner.
 * Only down and right directions of movement are permitted.
 * <p>
 * Note:
 * Your method should output the result in a reasonable amount of time for large values of m and n.
 * If you're thinking of using DFS, consider the tree depth and branching factor for m and n > 15!
 */
public class CountPaths {

    public static int countPaths(int m, int n) {
        int[][] memo = initMemo(m, n);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[m - 1][n - 1];
    }

    private static int[][] initMemo(int m, int n) {
        int[][] memo = new int[m][n];
        // init first column with 1
        for (int i = 0; i < m; i++) {
            memo[i][0] = 1;
        }
        // init first row with 1
        for (int j = 1; j < n; j++) {
            memo[0][j] = 1;
        }
        return memo;
    }
}
