package com.github.dkoval.algopuzzles.hackerrank.contests.weekOfCode20;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/w20/challenges/divisible-sum-pairs">Problem:</a>
 * Max Score: 10 Difficulty: Easy
 */
public class DivisibleSumPairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int answer = solve(a, k);
        System.out.println(answer);
    }

    static int solve(int[] a, int k) {
        int answer = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if ((a[i] + a[j]) % k == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
