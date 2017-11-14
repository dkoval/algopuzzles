package com.github.dkoval.algopuzzles.hackerrank.contests.w35;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/w35/challenges/triple-recursion">Triple Recursion</a>
 * Max Score: 20 Difficulty: Easy
 */
public class TripleRecursion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[][] a = tripleRecursion(n, m, k);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", a[i][j]);
            }
            System.out.println();
        }
        in.close();
    }

    static int[][] tripleRecursion(int n, int m, int k) {
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    a[i][j] = m;
                } else if (i == j) {
                    a[i][j] = a[i - 1][j - 1] + k;
                } else if (i > j) {
                    a[i][j] = a[i - 1][j] - 1;
                } else if (i < j) {
                    a[i][j] = a[i][j - 1] - 1;
                }
            }
        }
        return a;
    }
}
