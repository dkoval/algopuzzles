package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/nimble">Problem:</a>
 * Max Score: 20 Difficulty: Easy
 */
public class NimbleGame {

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

    static int solve(int[] c) {
        // Observation: a coin on square i can be seen as a nim-pile of size i.
        int nimSum = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 0) {
                // minor performance optimization: ignore empty squares
                continue;
            }
            // Facts: x ^ 0 = x; x ^ x = 0; x ^ x ^ x = x ^ (x ^ x) = x ^ 0 = x
            if (c[i] % 2 != 0) {
                nimSum ^= i;
            }
        }
        // canonical Nim http://www.suhendry.net/blog/?p=1586
        return (nimSum != 0) ? 1 : 2;
    }
}
