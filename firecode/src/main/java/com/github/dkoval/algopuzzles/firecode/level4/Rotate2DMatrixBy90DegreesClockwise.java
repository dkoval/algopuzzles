package com.github.dkoval.algopuzzles.firecode.level4;

/**
 * You are given an n x n square 2D matrix that represents the pixels of an image.
 * Rotate it by 90 degrees in the clockwise direction.
 * <p>
 * Already solved a similar problem {@link com.github.dkoval.algopuzzles.firecode.level3.RotateSquareImageClockwise} before.
 * Recap the main idea here.
 */
public class Rotate2DMatrixBy90DegreesClockwise {

    public static int[][] rotate(int[][] matrix) {
        int[][] tr = transpose(matrix);
        return flipOnVerticalAxis(tr);
    }

    private static int[][] transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        return matrix;
    }

    private static int[][] flipOnVerticalAxis(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int greenwich = n / 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < greenwich; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
        return matrix;
    }
}
