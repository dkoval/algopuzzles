package com.github.dkoval.algopuzzles.firecode.level4;

/**
 * You are given an n x n square 2D matrix that represents the pixels of an image.
 * Rotate it by 90 degrees in the clockwise direction.
 * <p>
 * This is an optimized version of {@link com.github.dkoval.algopuzzles.firecode.level3.RotateSquareImageClockwise} solution.
 */
public class Rotate2DMatrixBy90DegreesClockwise {

    // Good reading to understand the main idea behind the algorithm:
    // http://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
    public static int[][] rotate(int[][] matrix) {
        final int n = matrix.length;
        final int numOfCycles = n / 2;
        for (int i = 0; i < numOfCycles; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
        return matrix;
    }
}
