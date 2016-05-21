package com.github.dkoval.algopuzzles.hackerrank.contests.worldCodesprintMay;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/may-world-codesprint/challenges/compare-the-triplets">Problem:</a>
 * Max Score: 15 Difficulty: Easy
 */
public class CompareTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[3], b = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            b[i] = in.nextInt();
        }
        int[] scores = solve(a, b);
        System.out.println(scores[0] + " " + scores[1]);
    }

    static int[] solve(int[] a, int[] b) {
        int aliceScore = 0, bobScore = 0;
        for (int i = 0; i < 3; i++) {
            if (a[i]> b[i]) {
                aliceScore++;
            } else if (a[i] < b[i]) {
                bobScore++;
            }
        }
        return new int[] {aliceScore, bobScore};
    }
}
