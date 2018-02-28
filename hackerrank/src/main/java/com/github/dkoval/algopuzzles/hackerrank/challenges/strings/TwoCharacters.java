package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <a href="https://www.hackerrank.com/challenges/two-characters/problem">Two Characters</a>
 * Max Score: 20, Difficulty: Easy
 */
public class TwoCharacters {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int l = in.nextInt();
            String s = in.next();
            int result = twoCharaters(s);
            System.out.println(result);
        }
    }

    static int twoCharaters(String s) {
        Set<Character> distinctChars = distinctChars(s);
        int maxLength = 0;
        for (char first : distinctChars) {
            for (char second : distinctChars) {
                // choose two distinct characters to be present in string t
                if (first == second) {
                    continue;
                }
                // check if string s can be converted to t
                int length = lengthOfStringWithTwoDistinctAlternatingChars(s, first, second);
                if (length > 0) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    private static Set<Character> distinctChars(String s) {
        Set<Character> distinctChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            distinctChars.add(c);
        }
        return distinctChars;
    }

    private static int lengthOfStringWithTwoDistinctAlternatingChars(String s, char first, char second) {
        int length = 0;
        char alt = first;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // only consider `first` and `second` characters
            if (c != first && c != second) {
                continue;
            }
            // make sure that `first` and `second` characters appear in alternating order
            if (c == alt) {
                length++;
                alt = (alt == first) ? second : first;
            } else {
                return -1;
            }
        }
        return length;
    }
}
