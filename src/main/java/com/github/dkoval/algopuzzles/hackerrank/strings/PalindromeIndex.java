package com.github.dkoval.algopuzzles.hackerrank.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/palindrome-index">Problem:</a>.
 * Max Score: 25, Difficulty: Easy
 * <p>
 */
public class PalindromeIndex {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numOfTestCases; i++) {
            String input = scan.nextLine();
            int answer = palindromeIndex(input);
            System.out.println(answer);
        }
        scan.close();
    }

    static int palindromeIndex(String input) {
        return 0;
    }
}
