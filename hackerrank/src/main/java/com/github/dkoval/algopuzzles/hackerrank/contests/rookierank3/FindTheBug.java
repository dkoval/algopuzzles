package com.github.dkoval.algopuzzles.hackerrank.contests.rookierank3;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/rookierank-3/challenges/find-the-bug">Find the Bug</a>
 * Max Score: 10 Difficulty: Easy
 */
public class FindTheBug {

    static int[] findTheBug(String[] grid){
        for (int i = 0; i < grid.length; i++) {
            String row = grid[i];
            int j = row.indexOf('X');
            if (j != -1) {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        // Return an array containing [r, c]
        int[] result = findTheBug(grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "," : ""));
        }
        System.out.println("");
    }
}
