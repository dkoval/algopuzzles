package com.github.dkoval.algopuzzles.hackerrank.contests.infinitum15;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/infinitum15/challenges/modular-roots">Problem:</a>
 * Max Score: 30 Difficulty: Moderate
 */
public class ModularRoots {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long p = in.nextLong();
        int numOfTestCases = in.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            long k = in.nextLong();
            long n = in.nextLong();
            //List<Long> roots = find(k, n, p);
           // print(roots);
        }
        in.close();
    }

    private static void print(List<Long> nums) {
        if (nums.isEmpty()) {
            System.out.println("NONE");
        }

        for (long n : nums) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    /**
     * Given a prime p and integers k and n, finds all the k-th roots of n modulo p.
     * To avoid double counting, only values in the set {0,1,2,…,p−1} are considered.
     *
     * @param k the k-th root to find.
     * @param n the number for which the k-th root is to be found.
     * @param p the modulo; p is always prime.
     * @return all k-th roots of n modulo p.
     */
    static List<Integer> find(long k, long n, long p) {
        // p is prime, p does not divide n and gcd(k, p - 1) = 1
        if (n % p != 0 && gcd(k, p - 1) == 1) {

        }
        return Collections.emptyList();
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private static long[] extendedGcd(long a, long b) {
        // extended Euclid's algorithm https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm
        // gives not just d = gcd(a, b), but also two integers x, y such that a*x + b*y = d
        long d = -1, x = -1, y = -1;
        return new long[] {d, x, y};
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
