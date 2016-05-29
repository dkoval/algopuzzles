package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/day-2-poker-nim">Problem:</a>
 * Max Score: 20 Difficulty: Easy
 */
public class PokerNim {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] c = new int[n];
            for (int ci = 0; ci < n; ci++) {
                c[ci] = in.nextInt();
            }
            int answer = solve(c, k);
            System.out.println(answer == 1 ? "First" : "Second");
        }
    }

    // Good reading: http://web.mit.edu/sp.268/www/nim.pdf, page 7
    static int solve(int[] c, int k) {
        // Observation: any time a player adds chips to a pile, the next player
        // can exactly reverse the move and return the game to its original position.
        // canonical Nim http://www.suhendry.net/blog/?p=1586
        return (nimSum(c) != 0) ? 1 : 2;
    }

    private static int nimSum(int[] s) {
        int nimSum = 0;
        for (int si : s) {
            nimSum ^= si;
        }
        return nimSum;
    }
}
