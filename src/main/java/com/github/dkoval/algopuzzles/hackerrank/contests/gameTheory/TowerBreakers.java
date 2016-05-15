package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/tower-breakers">Problem:</a>
 * Max Score: 15 Difficulty: Easy
 */
public class TowerBreakers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int answer = solve(n, m);
            System.out.println(answer);
        }
    }

    static int solve(int n, int m) {
        if (m == 1) {
            // player #1 has no move, so player #2 wins
            return 2;
        }
        // the best move is to always reduce the height of
        // any existing tower to a height of 1
        return (n % 2 != 0) ? 1 : 2;
    }
}
