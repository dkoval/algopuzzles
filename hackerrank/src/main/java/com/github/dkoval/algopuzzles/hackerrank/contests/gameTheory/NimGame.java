package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/day-2-nim-game">Problem:</a>
 * Max Score: 15 Difficulty: Easy
 */
public class NimGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] s = new int[n];
            for (int si = 0; si < n; si++) {
                s[si] = in.nextInt();
            }
            int answer = solve(s);
            System.out.println(answer == 1 ? "First" : "Second");
        }
    }

    // Good reading: https://web.stanford.edu/class/cs97si/05-combinatorial-games.pdf, page 19
    static int solve(int[] s) {
        int nimSum = 0;
        for (int si : s) {
            nimSum ^= si;
        }
        return (nimSum != 0) ? 1 : 2;
    }
}
