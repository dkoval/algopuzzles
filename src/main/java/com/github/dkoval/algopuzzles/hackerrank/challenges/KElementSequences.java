package com.github.dkoval.algopuzzles.hackerrank.challenges;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/infinitum15/challenges/k-element-sequences">Problem:</a>
 * Max Score: 20 Difficulty: Easy
 * <p>
 * Given two integers, N and K, find the number of sequences that meet the following criteria:
 * <ul>
 * <li>The sequence is of size K (i.e., contains K integers).</li>
 * <li>Each element in the sequence is a positive integer.</li>
 * <li>The sum of all elements in the sequence is N.</li>
 * </ul>
 * Input Format
 * <p>
 * The first line contains the number of test cases, T.
 * The T subsequent lines each describe a test case as two space-separated integers, N and K.
 * <p>
 * Constraints
 * <ul>
 * <li>1≤T≤1000</li>
 * <li>1≤K≤N≤2×10^6</li>
 * </ul>
 * Output Format
 * <p>
 * For each test case, print the total number of possible K-element sequences of positive integers such that
 * the sum of the elements in each sequence is N. As the answer may be large, output your answer modulo (10^9+7).
 */
public class KElementSequences {

    // As the answer may be large, output your answer modulo (10^9 + 7)
    private static final long MOD = 1000_000_007;

    // precomputed factorials modulo MOD
    private static long[] factorial = factorials();

    private static long[] factorials() {
        long[] factorial = new long[2 * 1000_001];
        factorial[0] = factorial[1] = 1;
        for (int i = 2; i < factorial.length; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }
        return factorial;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numOfTestCases; i++) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            long answer = solve(n, k);
            System.out.println(answer);
        }
        scan.close();
    }

    static long solve(int n, int k) {
        // https://en.wikipedia.org/wiki/Composition_(combinatorics)#Number_of_compositions
        // C(n - 1, k - 1) = (n - 1)! / ((n - k)! * (k - 1)!)
        long c = factorial[n - 1];
        c = (c * modInverse(factorial[k - 1])) % MOD;
        c = (c * modInverse(factorial[n - k])) % MOD;
        return c;
    }

    private static long modInverse(long a) {
        // In the special case when m is a prime:
        // https://en.wikipedia.org/wiki/Modular_multiplicative_inverse#Using_Euler.27s_theorem
        return pow(a, MOD - 2, MOD);
    }

    private static long pow(long a, long b, long mod) {
        // O(log n) algorithm of calculating pow(a, b)
        // http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
        if (a == 0) {
            return 0;
        }
        long p = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                // this block here will be entered at least once, when b = 1:
                // previous b = 2; b / 2 = 1; 1 is odd
                p = (p * a) % mod;
            }
            a = (a * a) % mod;
            b /= 2;
        }
        return p;
    }
}