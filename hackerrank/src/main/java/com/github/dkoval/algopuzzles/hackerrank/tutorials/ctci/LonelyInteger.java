package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-lonely-integer/problem">Bit Manipulation: Lonely Integer</a>
 * Max Score: 25 Difficulty: Easy
 */
public class LonelyInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int ans = findLonelyInteger(a);
        System.out.println(ans);
    }

    static int findLonelyInteger(int[] a) {
        int ans = 0;
        for (int ai : a) {
            ans ^= ai;
        }
        return ans;
    }
}
