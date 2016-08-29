package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 * The next number is found by adding up the two numbers before it.
 * <p>
 * Your goal is to write an optimal method - betterFibonacci that returns the nth Fibonacci number in the sequence.
 * n is 0 indexed, which means that in the sequence 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...,
 * n == 0 should return 0 and n == 3 should return 2.
 * <p>
 * Your method should exhibit a runtime complexity of O(n) and use constant O(1) space.
 * With this implementation, your method should be able to compute larger sequences where n > 40.
 */
public class BetterFibonacci {

    public static int betterFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fib = -1, nMinus2 = 0, nMinus1 = 1;
        for (int i = 2; i <= n; i++) {
            fib = nMinus1 + nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = fib;
        }
        return fib;
    }
}
