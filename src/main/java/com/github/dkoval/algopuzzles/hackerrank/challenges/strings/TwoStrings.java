package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/two-strings">Problem:</a>
 * Max Score: 25, Difficulty: Moderate
 * <p>
 * You are given two strings, A and B. Find if there is a substring that appears in both A and B.
 * <p>
 * Input Format
 * <p>
 * Several test cases will be given to you in a single file. The first line of the input will contain a single integer T,
 * the number of test cases.
 * <p>
 * Then there will be T descriptions of the test cases. Each description contains two lines.
 * The first line contains the string A and the second line contains the string B.
 * <p>
 * Output Format
 * <p>
 * For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.
 * <p>
 * Constraints
 * <ul>
 * <li>All the strings contain only lowercase Latin letters.</li>
 * <li>1<=T<=10</li>
 * <li>1<=|A|,|B|<=10^5</li>
 * </ul>
 */
public class TwoStrings {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numOfTestCases; i++) {
            String first = scan.nextLine();
            String second = scan.nextLine();
            boolean answer = thereIsCommonSubstring(first, second);
            System.out.println(answer ? "YES" : "NO");
        }
        scan.close();
    }

    static boolean thereIsCommonSubstring(String first, String second) {
        // Observation: if two strings have least one common character,
        // i.e. a substring of length 1, we can state that the answer to the solution is YES.
        return (useOfLettersBitSet(first) & useOfLettersBitSet(second)) != 0;
    }

    private static int useOfLettersBitSet(String s) {
        // there are 26 letters in English alphabet, thus int data type (4 bytes = 32 bits) can be used
        // to keep track of all used letters in the given string.
        int useOfLettersBitSet = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int pos = ch - 'a';
            // 1-bit at position i indicates that the character with index i (a - 0, b - 1, ..., z - 25)
            // is present in the input string
            useOfLettersBitSet |= 1 << pos;
        }
        return useOfLettersBitSet;
    }
}
