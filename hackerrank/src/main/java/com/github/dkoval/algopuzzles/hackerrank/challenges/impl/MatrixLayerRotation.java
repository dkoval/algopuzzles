package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/matrix-rotation-algo">Problem:</a>
 * Max Score: 80 Difficulty: Difficult
 */
public class MatrixLayerRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ans = solve(in);
        System.out.println(ans);
    }

    static String solve(Scanner in) {
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        return mkString(doSolve(arr, m, n, r));
    }

    private static String mkString(int[][] arr) {
        return Arrays.stream(arr)
                .map(row -> Arrays.stream(row)
                        .boxed()
                        .map(Object::toString)
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
    }

    private static int[][] doSolve(int[][] arr, int m, int n, int r) {
        int[][] ans = new int[m][n];
        int numOfLevels = Math.min(m / 2, n / 2);
        for (int i = 0; i < numOfLevels; i++) {
            Map<Integer, Matrix2DCoord> stripe1DTo2DCoordMap = stripe1DToMatrix2DCoordMap(m, n);
            int stripeLen = stripe1DTo2DCoordMap.keySet().size();
            for (int j = 0; j < stripeLen; j++) {
                Matrix2DCoord curr = stripe1DTo2DCoordMap.get(j);
                Matrix2DCoord next = stripe1DTo2DCoordMap.get((j + r) % stripeLen);
                ans[curr.row + i][curr.col + i] = arr[next.row + i][next.col + i];
            }
            m -= 2;
            n -= 2;
        }
        return ans;
    }

    private static class Matrix2DCoord {
        private final int row;
        private final int col;

        public Matrix2DCoord(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Matrix2DCoord{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    private static Map<Integer, Matrix2DCoord> stripe1DToMatrix2DCoordMap(int m, int n) {
        Map<Integer, Matrix2DCoord> map = new LinkedHashMap<>();
        int stripeLen = 2 * (m + n - 2);
        for (int i = 0; i < stripeLen; i++) {
            map.put(i, stripe1DToMatrix2DCoord(i, m, n));
        }
        return map;
    }

    private static Matrix2DCoord stripe1DToMatrix2DCoord(int i, int m, int n) {
        if (i <= n - 1) {
            // going →
            return new Matrix2DCoord(0, i);
        } else if (i <= m + n - 2) {
            // going ↓
            return new Matrix2DCoord(i - (n - 1), n - 1);
        } else if (i <= m + 2 * n - 3) {
            // going ←
            return new Matrix2DCoord(m - 1, n - i + (m + n - 2) - 1);
        } else {
            // going ↑
            return new Matrix2DCoord(m - i + (m + 2 * n - 3) - 1, 0);
        }
    }
}
