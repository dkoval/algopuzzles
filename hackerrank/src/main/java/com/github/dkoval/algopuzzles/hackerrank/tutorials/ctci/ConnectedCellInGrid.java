package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid">DFS: Connected Cell in a Grid</a>
 * Max Score: 45 Difficulty: Hard
 */
public class ConnectedCellInGrid {

    private static final int[][] neighbours = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        int answer = numCellsInLargestRegion(grid);
        System.out.println(answer);
    }

    static int numCellsInLargestRegion(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        boolean[][] visited = new boolean[numRows][numCols];
        int result = Integer.MIN_VALUE;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if ((grid[row][col] == 1) && !visited[row][col]) {
                    int numCellsInRegion = dfs(grid, row, col, visited, 1);
                    result = Math.max(result, numCellsInRegion);
                }
            }
        }
        return result;
    }

    private static int dfs(int[][] grid, int row, int col, boolean[][] visited, int numCellsInRegion) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        // mark (row, col) cell as visited
        visited[row][col] = true;
        // recur for all connected neighbours
        for (int k = 0; k < 8; k++) {
            int nextRow = row + neighbours[k][0];
            int nextCol = col + neighbours[k][1];
            if (isCellWithinGridBoundaries(nextRow, nextCol, numRows, numCols)
                    && (grid[nextRow][nextCol] == 1)
                    && !visited[nextRow][nextCol]) {
                numCellsInRegion = dfs(grid, nextRow, nextCol, visited, ++numCellsInRegion);
            }
        }
        return numCellsInRegion;
    }

    private static boolean isCellWithinGridBoundaries(int row, int col, int numRows, int numCols) {
        return (row >= 0) && (row < numRows) && (col >= 0) && (col < numCols);
    }
}
