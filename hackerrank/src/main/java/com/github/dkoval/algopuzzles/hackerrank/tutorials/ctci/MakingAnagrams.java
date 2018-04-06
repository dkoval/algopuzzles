package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-making-anagrams/problem">Making Anagrams</a>
 * Max Score: 25 Difficulty: Easy
 */
public class MakingAnagrams {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

    public static int numberNeeded(String first, String second) {
        int[] freq = new int[26];
        for (int i = 0; i < first.length(); i++) {
            char  ch = first.charAt(i);
            freq[ch - 'a']++;
        }
        for (int i = 0; i < second.length(); i++) {
            char ch = second.charAt(i);
            freq[ch - 'a']--;
        }
        int numCharsToDelete = 0;
        for (int aFreq : freq) {
            numCharsToDelete += Math.abs(aFreq);
        }
        return numCharsToDelete;
    }
}
