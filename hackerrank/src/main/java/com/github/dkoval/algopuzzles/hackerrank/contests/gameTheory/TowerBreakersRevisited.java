package com.github.dkoval.algopuzzles.hackerrank.contests.gameTheory;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/5-days-of-game-theory/challenges/tower-breakers-2">Problem:</a>
 * Max Score: 20 Difficulty: Moderate
 */
public class TowerBreakersRevisited {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = in.nextInt();
            }
            int answer = solve(h);
            System.out.println(answer);
        }
    }

    static int solve(int[] h) {
        // Think of each tower as a Nim pile with a value equal to the number of prime factors of h[i].
        // Reducing a tower to its divisor is the same as taking away a non-zero prime factor from it.
        int nimSum = 0;
        for (int hi : h) {
            int nimVal = numOfPrimeFactors(hi);
            nimSum ^= nimVal;
        }
        // canonical Nim http://www.suhendry.net/blog/?p=1586
        return (nimSum != 0) ? 1 : 2;
    }

    // Good reading: http://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number
    private static int numOfPrimeFactors(int n) {
        int numOfPrimeFactors = 0;
        // start with 2
        while (n % 2 == 0) {
            numOfPrimeFactors++;
            n /= 2;
        }
        // n must be odd at this point (note i = i + 2)
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                numOfPrimeFactors++;
                n /= i;
            }
        }
        // finally, handle the case when n is a prime number greater than 2
        if (n > 2) {
            numOfPrimeFactors++;
        }
        return numOfPrimeFactors;
    }
}
