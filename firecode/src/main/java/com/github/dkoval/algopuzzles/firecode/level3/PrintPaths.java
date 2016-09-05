package com.github.dkoval.algopuzzles.firecode.level3;

import java.util.ArrayList;

/**
 * You're given a 2D board which contains an m x n matrix of chars - char[][] board. Write a method - printPaths
 * that prints all possible paths from the top left cell to the bottom right cell. Your method should return an
 * ArrayList of Strings, where each String represents a path with characters appended in the order of movement.
 * You're only allowed to move down and right on the board. The order of String insertion in the ArrayList does not matter.
 */
public class PrintPaths {

    public static ArrayList<String> printPaths(char[][] board) {
        ArrayList<String> paths = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return paths;
        }
        // start the search at the top left corner
        doPrintPaths(board, 0, 0, new StringBuilder(), paths);
        return paths;
    }

    private static void doPrintPaths(char[][] board, int i, int j, StringBuilder currentPath, ArrayList<String> paths) {
        int m = board.length, n = board[0].length;
        if (i > m - 1 || j > n - 1) {
            return;
        }
        // mark current cell
        currentPath.append(board[i][j]);
        // check if the bottom right corner is reached
        if (i == m - 1 && j == n - 1) {
            paths.add(currentPath.toString());
        } else {
            // search the bottom and right cells
            doPrintPaths(board, i + 1, j, currentPath, paths);
            doPrintPaths(board, i, j + 1, currentPath, paths);
        }
        // un-mark current cell
        currentPath.deleteCharAt(currentPath.length() - 1);
    }
}
