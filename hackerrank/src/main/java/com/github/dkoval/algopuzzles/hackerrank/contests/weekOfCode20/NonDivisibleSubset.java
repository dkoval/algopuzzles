package com.github.dkoval.algopuzzles.hackerrank.contests.weekOfCode20;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/w20/challenges/non-divisible-subset">Problem:</a>
 * Max Score: 20 Difficulty: Easy
 */
public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.nextInt();
        }
        int answer = solve(s, k);
        System.out.println(answer);
    }

    static int solve(int[] s, int k) {
        int[] a = new int[k];
        for (int si : s) {
            // a[t] - number of integers which give the remainder t modulo k
            ++a[si % k];
        }

        // if k is even, then taking two integers with the remainder t = k /2
        // will lead us to the sum divisible by k, which is not what we want
        if (k % 2 == 0) {
            a[k / 2] = Math.min(a[k / 2], 1);
        }

        // we can't take 2 or more numbers with the remainder equal to t = 0
        // because their sum would be evenly divisible by k
        int answer = Math.min(a[0], 1);
        // for t > 0 if we take at least one integer with the remainder t and at least one with the remainder k - t,
        // then the sum of these two integers will be evenly divisible by k, therefore only consider t in [1..k / 2] range.
        for (int t = 1; t <= k / 2; t++) {
            answer += Math.max(a[t], a[k - t]);
        }
        return answer;
    }
}
