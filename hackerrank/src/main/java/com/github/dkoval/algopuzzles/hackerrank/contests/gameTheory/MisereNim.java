package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/misere-nim">Problem:</a>
 * Max Score: 20 Difficulty: Easy
 */
public class MisereNim {

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

    static int solve(int[] s) {
        // Misère Nim is exactly like the standard Nim game, except for one critical difference.
        // If the size of every pile is 1, then we count the number of piles.
        // If the count is even, then the first player will win;
        // if the count is odd, then the first player will lose.
        boolean everyPileIsOne = Arrays.stream(s).allMatch(si -> si == 1);
        if (everyPileIsOne) {
            return (s.length % 2 == 0) ? 1 : 2;
        } else {
            // canonical Nim http://www.suhendry.net/blog/?p=1586
            return (nimSum(s) != 0) ? 1 : 2;
        }
    }

    private static int nimSum(int[] s) {
        int nimSum = 0;
        for (int si : s) {
            nimSum ^= si;
        }
        return nimSum;
    }
}
