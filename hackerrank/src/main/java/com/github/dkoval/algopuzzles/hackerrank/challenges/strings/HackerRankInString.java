package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/hackerrank-in-a-string">HackerRank in a String!</a>
 * Max Score: 20, Difficulty: Easy
 */
public class HackerRankInString {

    private static final String WORD = "hackerrank";

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int q = in.nextInt();
            while (q-- > 0) {
                String s = in.next();
                String result = hackerrankInString(s);
                System.out.println(result);
            }
        }
    }

    static String hackerrankInString(String s) {
        if (s.length() < WORD.length()) {
            return "NO";
        }
        int posInWord = 0;
        for (int i = 0; i < s.length(); i++) {
            if (posInWord < WORD.length() && WORD.charAt(posInWord) == s.charAt(i)) {
                posInWord++;
            }
        }
        return posInWord == WORD.length() ? "YES" : "NO";
    }
}
