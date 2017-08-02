package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-coin-change">DP: Coin Change</a>
 * Max Score: 60 Difficulty: Hard
 */
public class CoinChange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int i = 0; i < m; i++) {
            coins[i] = in.nextInt();
        }
        long answer = numWaysToMakeChange(n, coins);
        System.out.println(answer);
    }

    static long numWaysToMakeChange(int n, int[] coins) {
        long[][] memo = new long[coins.length][n + 1];
        for (int i = 0; i < coins.length; i++) {
            memo[i][0] = 1; // only 1 way to reach 0
            for (int amount = 1; amount <= n; amount++) {
                int coin = coins[i];
                long numWaysWithoutThisCoin = (i >= 1) ? memo[i - 1][amount] : 0;
                long numWaysWithThisCoin = (amount >= coin) ? memo[i][amount - coin] : 0;
                memo[i][amount] = numWaysWithoutThisCoin + numWaysWithThisCoin;
            }
        }
        return memo[coins.length - 1][n];
    }
}
