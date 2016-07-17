package com.github.dkoval.algopuzzles.hackerrank.contests.w21;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/w21/challenges/kangaroo">Problem:</a>
 * Max Score: 10 Difficulty: Easy
 */
public class Kangaroo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        boolean answer = solve(x1, v1, x2, v2);
        System.out.println(answer ? "YES" : "NO");
    }

    static boolean solve(int x1, int v1, int x2, int v2) {
        return (x2 > x1) && (v1 > v2) && ((x2 - x1) % (v1 - v2) == 0);
    }
}
