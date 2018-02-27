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
        Character[] distinctChars = distinctChars(s);
        int result = 0;
        for (int i = 0; i < distinctChars.length; i++) {
            for (int j = 0; j < distinctChars.length; j++) {
                if (i == j) {
                    continue;
                }
                // choose two distinct characters to be present in string t,
                // characters must appear in alternating order in t
                Character first = distinctChars[i];
                Character second = distinctChars[j];
                // check if string s can be converted to t
                int length = lengthOfStringWithTwoDistinctAlternatingChars(s, first, second);
                if (length > 0) {
                    result = Math.max(result, length);
                }
            }
        }
        return result;
    }

    private static Character[] distinctChars(String s) {
        Set<Character> distinctChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            distinctChars.add(c);
        }
        return distinctChars.toArray(new Character[distinctChars.size()]);
    }

    private static int lengthOfStringWithTwoDistinctAlternatingChars(String s, char first, char second) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // only consider `first` and `second` characters
            if (c != first && c != second) {
                continue;
            }
            // make sure that `first` and `second` characters appear in alternating order
            if (c == first) {
                length++;
                char tmp = first;
                first = second;
                second = tmp;
            } else {
                return -1;
            }
        }
        return length;
    }
}
