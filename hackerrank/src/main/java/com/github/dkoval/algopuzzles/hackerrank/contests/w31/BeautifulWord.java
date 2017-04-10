package com.github.dkoval.algopuzzles.hackerrank.contests.w31;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <a href="https://www.hackerrank.com/contests/w31/challenges/beautiful-word">Problem:</a>
 * Max Score: 10 Difficulty: Easy
 */
public class BeautifulWord {
    private static final Set<Character> NOT_ALLOWED_CHARS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        boolean ans = solve(word);
        System.out.println(ans ? "Yes" : "No");
    }

    public static boolean solve(String word) {
        if (word == null || word.length() < 2) {
            return false;
        }
        for (int i = 0; i < word.length() - 1; i++) {
            char first = word.charAt(i);
            char second = word.charAt(i + 1);
            if ((first == second) || (NOT_ALLOWED_CHARS.contains(first) && NOT_ALLOWED_CHARS.contains(second))) {
                return false;
            }
        }
        return true;
    }
}
