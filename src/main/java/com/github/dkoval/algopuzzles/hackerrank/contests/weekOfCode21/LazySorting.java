package com.github.dkoval.algopuzzles.hackerrank.contests.weekOfCode21;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/contests/w21/challenges/lazy-sorting">Problem:</a>
 * Max Score: 30 Difficulty: Moderate
 */
public class LazySorting {
    private static final double eps = 1E-18;
    private static final int maxSizeOfPermutation = 18;
    private static long[] factorial = factorials();

    private static long[] factorials() {
        long[] factorial = new long[maxSizeOfPermutation + 1];
        factorial[0] = factorial[1] = 1;
        for (int i = 2; i < factorial.length; i++) {
            factorial[i] = (factorial[i - 1] * i);
        }
        return factorial;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = in.nextInt();
        }
        String answer = solve(seq);
        System.out.println(answer);
    }

    static String solve(int[] seq) {
        double answer = doSolve(seq);
        return String.format("%.6f", answer);
    }

    // Good reading: https://en.wikipedia.org/wiki/Expected_value
    private static double doSolve(int[] seq) {
        // Expected value = 1 * p + 2 * q * p + 3 * q^2 * p + ...
        final double p = p(seq), q = 1.0 - p;
        double term = p, expectedValue = term;
        int i = 2;
        while (Double.compare(term, eps) > 0) {
            term *= q;
            expectedValue += i * term;
            i++;
        }
        return expectedValue;
    }

    // Good reading: https://en.wikipedia.org/wiki/Permutation
    private static double p(int[] seq) {
        // Note that the sequence may potentially have repeating elements
        Map<Integer, Long> freq = Arrays.stream(seq)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // https://en.wikipedia.org/wiki/Permutation#Permutations_of_multisets
        long p = factorial(seq.length);
        for (long uniqElemFreq : freq.values()) {
            // according to the problem description, max size of permutation is in [2..18] range
            p /= factorial((int) uniqElemFreq);
        }
        return 1.0 / p;
    }

    private static long factorial(int n) {
        return factorial[n];
    }
}
