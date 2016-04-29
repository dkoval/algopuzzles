package com.github.dkoval.algopuzzles.hackerrank.contests.worldCodesprintApril;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/world-codesprint-april/challenges/jumping-on-the-clouds">Problem:</a>
 * Max Score: 15 Difficulty: Easy
 */
public class JumpingOnTheClouds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int answer = solve(c);
        System.out.println(answer);
    }

    static int solve(int[] c) {
        int n = c.length;
        int i = 0;
        int numOfJumps = 0;
        while (n - 1 - i > 2) {
            // jump as far as possible
            int c2 = c[i + 2];
            if (c2 == 0) {
                i += 2;
            } else {
                i += 1;
            }
            numOfJumps++;
        }
        // add +1 jump from position either n - 3 or n - 2 not covered by the loop above
        return ++numOfJumps;
    }
}
