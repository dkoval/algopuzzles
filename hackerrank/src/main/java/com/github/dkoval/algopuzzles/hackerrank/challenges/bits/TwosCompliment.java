package com.github.dkoval.algopuzzles.hackerrank.challenges.bits;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/2s-complement/problem">2's complement</a>
 * Max Score: 70 Difficulty: Advanced
 */
public class TwosCompliment {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            while (t-- > 0) {
                int a = in.nextInt();
                int b = in.nextInt();
                long result = twosCompliment(a, b);
                System.out.println(result);
            }
        }
    }

    static long twosCompliment(int a, int b) {
        if (a >= 0 && b >= 0) {
            return bitCountInPositiveRange(a, b);
        } else if (a < 0 && b >= 0) {
            return bitCountInNegativeRange(a, -1) + bitCountInPositiveRange(0, b);
        } else {
            return bitCountInNegativeRange(a, b);
        }
    }

    // [a, b]
    private static long bitCountInPositiveRange(long a, long b) {
        long res = bitCountInZeroToNRange(b);
        return (a > 0) ? res - bitCountInZeroToNRange(a - 1) : res;
    }
    // 2's complement of [-a, -b] = [2^32 - a, 2^32 - b]
    private static long bitCountInNegativeRange(long a, long b) {
        return bitCountInPositiveRange((1L << 32) + a, (1L << 32) + b);
    }

    // [0, n]
    private static long bitCountInZeroToNRange(long n) {
        // very nice explanation: https://stackoverflow.com/a/7943292
        if (n == 0) {
            return 0;
        } else if (n % 2 == 0) {
            return bitCountInZeroToNRange(n - 1) + Long.bitCount(n);
        } else {
            return 2 * bitCountInZeroToNRange(n / 2)
                    // trick to prevent overflow if a = Long.MAX_VALUE: (n + 1) / 2 = n + (1 - n) / 2
                    + (n + (1 - n) / 2);
        }
    }
}
