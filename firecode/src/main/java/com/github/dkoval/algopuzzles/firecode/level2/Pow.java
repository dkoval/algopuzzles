package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * Write a method - powRecursive(x,n) that returns the value of x raised to the power of n (x^n).
 * n can be negative!
 */
public class Pow {

    public static double powRecursive(double x, int n) {
        if (Double.compare(x, 0d) == 0) {
            return 0d;
        }
        return (n < 0) ? 1 / doPowRecursive(x, -n) : doPowRecursive(x, n);
    }

    /* n is expected to be a non-negative number here */
    private static double doPowRecursive(double x, int n) {
        if (n == 0) {
            return 1d;
        }
        double half = doPowRecursive(x, n / 2);
        return (n % 2 == 0) ? half * half : half * half * x;
    }

    public static double powIterative(double x, int n) {
        if (Double.compare(x, 0d) == 0) {
            return 0d;
        }
        return (n < 0) ? 1 / doPowIterative(x, -n) : doPowIterative(x, n);
    }

    /* n is expected to be a non-negative number here */
    private static double doPowIterative(double x, int n) {
        double p = (n % 2 == 0) ? 1d : x;
        while (n > 1) {
            p *= x * x;
            n /= 2;
        }
        return p;
    }
}
