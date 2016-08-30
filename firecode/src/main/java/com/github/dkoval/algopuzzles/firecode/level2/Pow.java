package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * Write a method - pow(x,n) that returns the value of x raised to the power of n (x^n).
 * n can be negative!
 */
public class Pow {

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (Double.compare(x, 0d) == 0) {
            return 0d;
        }
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return (n > 0) ? half * half * x : half * half / x;
        }
    }
}
