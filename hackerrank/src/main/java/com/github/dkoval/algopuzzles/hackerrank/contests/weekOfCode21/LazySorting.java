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
        // http://www.cut-the-knot.org/Probability/LengthToFirstSuccess.shtml
        // Expected value E = 1 * p + 2 * q * p + 3 * q^2 * p + ... = 1 / p
        // On the other hand, p = 1 / numOfPerms, therefore E = numOfPerms
        return numOfPerms(seq);
    }

    // Good reading: https://en.wikipedia.org/wiki/Permutation
    private static double numOfPerms(int[] seq) {
        // Note that the sequence may potentially have repeating elements
        Map<Integer, Long> freq = Arrays.stream(seq)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // https://en.wikipedia.org/wiki/Permutation#Permutations_of_multisets
        double numOfPerms = factorial(seq.length);
        for (long uniqElemFreq : freq.values()) {
            // according to the problem description, max size of permutation is in [2..18] range
            numOfPerms /= factorial((int) uniqElemFreq);
        }
        return numOfPerms;
    }

    private static long factorial(int n) {
        return factorial[n];
    }
}
