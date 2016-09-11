package com.github.dkoval.algopuzzles.firecode.level3;

/**
 * You are given a square 2D image matrix where each integer represents a pixel.
 * Write a method rotateSquareImageCW to rotate the image clockwise - in-place.
 * Rotating an image clockwise can be achieved by taking the transpose of the image matrix
 * and then flipping it on its vertical axis.
 */
public class RotateSquareImageClockwise {

    public static void rotateSquareImageCW(int[][] matrix) {
        int[][] tr = transpose(matrix);
        flipOnVerticalAxis(tr);
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
