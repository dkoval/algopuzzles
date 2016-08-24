package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * Write a method {@link #isAnagram(String, String)} that checks if two lowercase input Strings are anagrams of each other.
 * An anagram of a String is a String that is formed by simply re-arranging its letters, using each letter
 * exactly once. Your algorithm should run in linear O(n) time and use constant O(1) space.
 */
public class Anagrams {

    public static boolean isAnagram(String input1, String input2) {
        if (input1 == null || input2 == null || input1.length() != input2.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < input1.length(); i++) {
            freq[input1.charAt(i) - 'a']++;
            freq[input2.charAt(i) - 'a']--;
        }
        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }
        return true;
    }
}
