package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-big-o/problem">Time Complexity: Primality</a>
 * Max Score: 30 Difficulty: Medium
 */
public class Primality {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int p = in.nextInt();
            for (int i = 0; i < p; i++) {
                int n = in.nextInt();
                boolean ans = isPrime(n);
                System.out.println(ans ? "Prime" : "Not prime");
            }
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
