package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/alternating-characters">Problem:</a>
 * Max Score: 20, Difficulty: Easy
 * <p>
 * Shashank likes strings in which consecutive characters are different. For example, he likes ABABA,
 * while he doesn't like ABAA. Given a string containing characters AA and BB only,
 * he wants to change it into a string he likes. To do this, he is allowed to delete the characters in the string.
 * <p>
 * Your task is to find the minimum number of required deletions.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer T, i.e. the number of test cases. The next T lines contain a string each.
 * <p>
 * Output Format
 * <p>
 * For each test case, print the minimum number of deletions required.
 * <p>
 * Constraints
 * <p>
 * 1 ≤ T ≤ 10
 * <br/>
 * 1 ≤ length of string ≤ 10^5
 */
public class AlternatingCharacters {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numTestCases; i++) {
            String input = scan.nextLine();
            int answer = minNumOfDeletions(input);
            System.out.println(answer);
        }
        scan.close();
    }

    static int minNumOfDeletions(String input) {
        char prev = input.charAt(0);
        int numOfDeletions = 0;
        for (int i = 1; i < input.length(); i++) {
            char next = input.charAt(i);
            if (next == prev) {
                numOfDeletions++;
            }
            prev = next;
        }
        return numOfDeletions;
    }
}
