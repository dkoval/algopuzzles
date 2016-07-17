package com.github.dkoval.algopuzzles.hackerrank.contests.worldCodesprintApril;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/world-codesprint-april/challenges/beautiful-triplets">Problem:</a>
 * Max Score: 20 Difficulty: Easy
 */
public class BeautifulTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = in.nextInt();
        }
        int answer = solve(seq, d);
        System.out.println(answer);
    }

    static int solve(int[] seq, int d) {
        int n = seq.length;
        int numOfTriplets = 0;
        int second, third;
        for (int i = 0; i < n; i++) {
            second = third = -1;
            int j, k;
            // find 2-nd element
            for (j = i + 1; j < n; j++) {
                if (seq[j] - seq[i] == d) {
                    second = seq[j];
                    break;
                }
            }
            // find 3-rd element
            for (k = j + 1; second != -1 && k < n; k++) {
                if (seq[k] - second == d) {
                    third = seq[k];
                    break;
                }
            }
            // found a beautiful triplet
            if (second != -1 && third != -1) {
                numOfTriplets++;
            }
        }
        return numOfTriplets;
    }
}
