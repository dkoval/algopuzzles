package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/a-game-of-stones">Problem:</a>
 * Max Score: 15 Difficulty: Easy
 */
public class GameOfStones {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            in.nextLine();
            int answer = solve(n);
            System.out.println(answer == 1 ? "First" : "Second");
        }
    }

    static int solve(int n) {
        return doSolve(n, new int[n + 1], new int[]{2, 3, 5});
    }

    // Good reading: http://www.users.miamioh.edu/fishert4/docs/fisher-algo.pdf
    private static int doSolve(int n, int[] memo, int s[]) {
        if (n == 0) {
            memo[0] = 2;
            return 2;
        }
        for (int si : s) {
            if (n - si >= 0) {
                int winner = memo[n - si];
                if (winner == 2) {
                    memo[n] = 1;
                    return 1;
                } else if (winner == 0) {
                    // winner is not yet known, do recursive call
                    int x = doSolve(n - si, memo, s);
                    // if possible to move to a position marked, the current n is a player #1
                    // winning position
                    if (x == 2) {
                        memo[n] = 1;
                        return 1;
                    }
                }
            }
        }
        // if no move to a player #2 winning position is available,
        // then  the  current is a player #2 winning position
        memo[n] = 2;
        return 2;
    }
}