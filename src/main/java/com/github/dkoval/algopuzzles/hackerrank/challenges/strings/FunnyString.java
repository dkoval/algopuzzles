package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/funny-string">Problem:</a>
 * Max Score: 25, Difficulty: Easy
 * <p>
 * Suppose you have some string S having length N that is indexed from 0 to N−1.
 * You also have some string R that is the reverse of string S. S is funny if the condition
 * <pre>| S[j]−S[j−1] |=| R[j]−R[j−1] |</pre> is true for every j from 1 to N−1.
 * <p>
 * Note: For some string S, S[j] denotes the ASCII value of the j-th zero-indexed character in S.
 * The absolute value of some integer x is written as | x |.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, T (the number of test cases).
 * The T subsequent lines each contain a string, where the i-th line is string Si.
 * <p>
 * Constraints
 * <p>
 * 1 ≤ T ≤ 10
 * <br/>
 * 0 ≤ i ≤ T−1
 * 2 ≤ length of Si ≤ 10000
 * <p>
 * Output Format
 * <p>
 * For each Si, print Funny or Not Funny on a new line.
 */
public class FunnyString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numTestCases; i++) {
            String input = scan.nextLine();
            boolean isFunny = isFunny(input);
            System.out.println(isFunny ? "Funny" : "Not Funny");
        }
        scan.close();
    }

    static boolean isFunny(String input) {
        final int N = input.length();
        for (int i = 1; i < N; i++) {
            int directDiff = Math.abs(input.charAt(i) - input.charAt(i - 1));
            int reverseDiff = Math.abs(input.charAt(N - i) - input.charAt(N - i - 1));
            if (directDiff != reverseDiff) {
                return false;
            }
        }
        return true;
    }
}
