package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * You are given a square 2D image matrix where each integer represents a pixel.
 * Write a method transposeMatrix to transform the matrix into its Transpose - in-place.
 */
public class TransposeOfSquareMatrix {

    public static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
