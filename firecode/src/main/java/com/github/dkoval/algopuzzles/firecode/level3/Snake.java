package com.github.dkoval.algopuzzles.firecode.level3;

import java.util.ArrayList;

/**
 * Let's have some fun with 2D Matrices! Write a method findSpiral to traverse a 2D matrix of ints
 * in a clockwise spiral order and append the elements to an output ArrayList of Integers.
 * <pre>
 * Example:
 *
 * Input Matrix:
 * {1, 2, 3}
 * {4, 5, 6}
 * {7, 8, 9}
 *
 * Output ArrayList: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * </pre>
 */
public class Snake {

    public static ArrayList<Integer> findSpiral(int[][] arr) {
        ArrayList<Integer> output = new ArrayList<>();
        int currentRow = 0, currentColumn = 0;
        int rowsLeft = arr.length, columnsLeft = arr[0].length;
        while (currentRow < rowsLeft && currentColumn < columnsLeft) {
            // first row
            for (int j = currentColumn; j < columnsLeft; j++) {
                output.add(arr[currentRow][j]);
            }
            currentRow++;

            // last column
            for (int i = currentRow; i < rowsLeft; i++) {
                output.add(arr[i][columnsLeft - 1]);
            }
            columnsLeft--;

            // last row
            if (currentRow < rowsLeft) {
                for (int j = columnsLeft - 1; j >= currentColumn; j--) {
                    output.add(arr[rowsLeft - 1][j]);
                }
                rowsLeft--;
            }

            // first column
            if (currentColumn < columnsLeft) {
                for (int i = rowsLeft - 1; i >= currentRow; i--) {
                    output.add(arr[i][currentColumn]);
                }
                currentColumn++;
            }
        }
        return output;
    }
}
