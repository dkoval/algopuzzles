package com.github.dkoval.algopuzzles.hackerrank.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/palindrome-index">Problem:</a>.
 * Max Score: 25, Difficulty: Easy
 * <p>
 * Given a string of lowercase letters, determine the index of the character whose removal will make the string
 * a palindrome. If the string is already a palindrome, then print −1−1. There will always be a valid solution.
 * <p>
 * Input Format
 * <p>
 * The first line contains T (the number of test cases).
 * The  subsequent lines of test cases each contain a single string to be checked.
 * <p>
 * Constraints
 * <ul>
 * <li>1≤T≤20</li>
 * <li>1≤ length of string ≤100005</li>
 * <li>All characters are Latin lower case indexed.</li>
 * </ul>
 * <p>
 * Output Format
 * <p>
 * Print the zero-indexed position (integer) of a character whose deletion will result in a palindrome;
 * if there is no such character (i.e.: the string is already a palindrome), print -1.
 * Any correct answer will be accepted; e.g.: for a string such as bcbc, we can either remove b at index 0
 * or c at index 3 — both answers are acceptable.
 */
public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numOfTestCases; i++) {
            String input = scan.nextLine();
            Integer answer = palindromeIndex(input);
            System.out.println(answer);
        }
        scan.close();
    }

    static int palindromeIndex(String input) {
        final int N = input.length();
        for (int i = 0; i < N / 2; i++) {
            int ridx = N - i - 1;
            // if the input string is not a palindrome, do the following...
            if (input.charAt(i) != input.charAt(ridx)) {
                // try to exclude the character from the left half of the input string
                // and see if the remaining string forms a palindrome
                if (isPalindrome(excludeCharAt(input, i))) {
                    return i;
                }
                // if not, do the similar check for the right half of the input string
                if (isPalindrome(excludeCharAt(input, ridx))) {
                    return ridx;
                }
            }
        }
        // If the string is already a palindrome, then return −1.
        // The problem specification states that there will always be a valid solution.
        return -1;
    }

    private static boolean isPalindrome(String s) {
        final int N = s.length();
        for (int i = 0; i < N / 2; i++) {
            char lch = s.charAt(i);
            char rch = s.charAt(N - i - 1);
            if (lch != rch) {
                return false;
            }
        }
        return true;
    }

    private static String excludeCharAt(String s, int index) {
        return s.substring(0, index) + s.substring(index + 1);
    }
}
