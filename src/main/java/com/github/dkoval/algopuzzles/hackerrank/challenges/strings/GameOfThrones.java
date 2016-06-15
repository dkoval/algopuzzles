package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/game-of-thrones">Problem:</a>
 * Max Score: 30, Difficulty: Easy
 * <p>
 * Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven
 * and plans to lock the single door through which the enemy can enter his kingdom. But, to lock the door he needs
 * a key that is an anagram of a certain palindrome string.
 * <p>
 * The king has a string composed of lowercase English letters. Help him figure out whether any anagram of the string
 * can be a palindrome or not.
 * <p>
 * Input Format
 * A single line which contains the input string.
 * <p>
 * Constraints
 * <ul>
 * <li>1≤ length of string ≤10^5</li>
 * <li>Each character of the string is a lowercase English letter.</li>
 * </ul>
 * <p>
 * Output Format
 * <p>
 * A single line which contains YES or NO in uppercase.
 */
public class GameOfThrones {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        boolean answer = anagramCanBePalindrome(input);
        System.out.println(answer ? "YES" : "NO");
    }

    static boolean anagramCanBePalindrome(String input) {
        Map<Character, Integer> charFreqMap = buildCharFrequencyMap(input);
        // some anagram of the input string can be a palindrome
        // if at most one character has uneven frequency
        boolean gotCharWithUnevenFreq = false;
        for (Map.Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            Integer freq = entry.getValue();
            boolean even = (freq % 2) == 0;
            if (!even) {
                if (gotCharWithUnevenFreq) {
                    return false;
                } else {
                    gotCharWithUnevenFreq = true;
                }
            }
        }
        return true;
    }

    private static Map<Character, Integer> buildCharFrequencyMap(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer freq = charFreqMap.get(ch);
            if (freq == null) {
                charFreqMap.put(ch, 1);
            } else {
                charFreqMap.put(ch, ++freq);
            }
        }
        return charFreqMap;
    }
}
