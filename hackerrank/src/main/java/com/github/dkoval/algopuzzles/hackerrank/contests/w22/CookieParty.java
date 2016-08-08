package com.github.dkoval.algopuzzles.hackerrank.contests.w22;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/w22/challenges/cookie-party">Problem:</a>
 * Max Score: 10 Difficulty: Easy
 */
public class CookieParty {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int ans = solve(n, m);
        System.out.println(ans);
    }

    static int solve(int n, int m) {
        return (m % n == 0) ? 0 : (m / n + 1) * n - m;
    }
}
