package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/day-1-a-chessboard-game">Problem:</a>
 * Max Score: 15 Difficulty: Easy
 */
public class ChessboardGame {

    /**
     * The chessboard size.
     */
    private static final int N = 15;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int answer = solve(x, y);
            System.out.println(answer == 1 ? "First" : "Second");
        }
    }

    static int solve(int x, int y) {
        // The coordinate of the upper left cell is (1, 1),
        // and the coordinate of the lower right cell is (15, 15).
        return doSolve(new int[N][N], x - 1, y - 1);
    }

    // Running time complexity is O(N^2)
    private static int doSolve(int[][] board, int x, int y) {
        // player #2 is not able to make a move, player #1 wins
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return 1;
        }

        // the winning player is known at this stage
        if (board[x][y] != 0) {
            return board[x][y];
        }

        // For each cell, try to see if player #1 can move to a losing position.
        // If YES, then player #1 can force the opponent into a losing state and win the game.
        // If NO, then player #1 in a losing state and won't be able to win the game.
        boolean lost =
                doSolve(board, x - 2, y + 1) == 2
                || doSolve(board, x - 2, y - 1) == 2
                || doSolve(board, x + 1, y - 2) == 2
                || doSolve(board, x - 1, y - 2) == 2;
        board[x][y] = lost ? 1 : 2;
        return board[x][y];
    }
}
