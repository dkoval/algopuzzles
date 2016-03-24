package com.github.dkoval.algopuzzles.hackerrank.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/the-love-letter-mystery">Problem:</a>
 * Max Score: 20, Difficulty: Easy
 * <p>
 * James found a love letter his friend Harry has written for his girlfriend.
 * James is a prankster, so he decides to meddle with the letter.
 * He changes all the words in the letter into palindromes.
 * <p>
 * To do this, he follows two rules:
 * <ol>
 * <li>He can reduce the value of a letter, e.g. he can change d to c, but he cannot change c to d.</li>
 * <li>In order to form a palindrome, if he has to repeatedly reduce the value of a letter,
 * he can do it until the letter becomes a. Once a letter has been changed to a, it can no longer be changed.</li>
 * </ol>
 * Each reduction in the value of any letter is counted as a single operation.
 * Find the minimum number of operations required to convert a given string into a palindrome.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer T, i.e., the number of test cases.
 * The next T lines will contain a string each. The strings do not contain any spaces.
 * <p>
 * Constraints
 * <p>
 * 1 ≤ T ≤ 10
 * <br/>
 * 1 ≤ length of string ≤ 10^4
 * <br/>
 * All characters are lower case English letters.
 * <p>
 * Output Format
 * <p>
 * A single line containing the number of minimum operations corresponding to each test case.
 */
public class LoveLetterMystery {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numTestCases; i++) {
            String input = scan.nextLine();
            int answer = minNumOfOpsToFormPalindrome(input);
            System.out.println(answer);
        }
        scan.close();
    }

    public static int minNumOfOpsToFormPalindrome(String input) {
        final int N = input.length();
        int numOfOps = 0;
        for (int i = 0; i < N / 2; i++) {
            char lch = input.charAt(i);
            char rch = input.charAt(N - i - 1);
            // Rule #1: He can reduce the value of a letter, e.g. he can change d to c, but he cannot change c to d.
            // Rule #2: Once a letter has been changed to a, it can no longer be changed.
            while (lch != rch) {
                // always try to reduce a 'greater' letter
                if (rch > lch) {
                    rch -= 1;
                } else {
                    lch -= 1;
                }
                numOfOps++;
            }
        }
        return numOfOps;
    }
}
