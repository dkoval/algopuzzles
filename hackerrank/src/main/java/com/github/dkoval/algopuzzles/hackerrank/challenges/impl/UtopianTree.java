package com.github.dkoval.algopuzzles.hackerrank.challenges.impl;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/utopian-tree">Problem:</a>
 * Max Score: 20 Difficulty: Easy
 */
public class UtopianTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); in.nextLine();
        while (t > 0) {
            int n = in.nextInt();
            int myAnswer = solve(1, n);
            System.out.println(myAnswer);
            t--;
        }
    }

    static int solve(int h0, int n) {
        int h = h0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                h *= 2;
            } else {
                h += 1;
            }
        }
        return h;
    }
}
