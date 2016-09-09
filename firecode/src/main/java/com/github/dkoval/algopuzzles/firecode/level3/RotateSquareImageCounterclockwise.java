package com.github.dkoval.algopuzzles.firecode.level3;

/**
 * You are given a square 2D image matrix where each integer represents a pixel.
 * Write a method rotateSquareImageCCW to rotate the image counterclockwise - in-place.
 * Rotating an image counterclockwise can be achieved by taking the transpose of the image matrix
 * and then flipping it on its horizontal axis.
 */
public class RotateSquareImageCounterclockwise {

    public static void rotateSquareImageCCW(int[][] matrix) {
        int[][] tr = transpose(matrix);
        flipOnHorizontalAxis(tr);
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

    private static int[][] flipOnHorizontalAxis(int[][] matrix) {
        int equator = matrix.length / 2;
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < equator; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = tmp;
            }
        }
        return matrix;
    }
}
