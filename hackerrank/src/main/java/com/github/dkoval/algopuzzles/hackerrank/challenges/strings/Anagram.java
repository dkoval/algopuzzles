package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/anagram">Problem:</a>
 * Max Score: 25, Difficulty: Easy
 * <p>
 * Sid is obsessed with reading short stories. Being a CS student, he is doing some interesting frequency analysis
 * with the books. He chooses strings S1 and S2 in such a way that |len(S1)−len(S2)| ≤ 1.
 * <p>
 * Your task is to help him find the minimum number of characters of the first string he needs to change
 * to enable him to make it an anagram of the second string.
 * <p>
 * Note: A word x is an anagram of another word y if we can produce y by rearranging the letters of x.
 * <p>
 * Input Format
 * <p>
 * The first line will contain an integer, T, representing the number of test cases.
 * Each test case will contain a string having length len(S1)+len(S2), which will be concatenation of both the strings
 * described above in the problem. The given string will contain only characters from a to z.
 * <p>
 * Output Format
 * <p>
 * An integer corresponding to each test case is printed in a different line, i.e. the number of changes required
 * for each test case. Print −1 if it is not possible.
 * <p>
 * Constraints
 * <ul>
 * <li>1 ≤ T ≤ 100</li>
 * <li>1 ≤ len(S1)+len(S2) ≤ 10^4</li>
 * </ul>
 */
public class Anagram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numOfTestCases; i++) {
            String input = scan.nextLine();
            int answer = minNumOfChangesToMakeAnagram(input);
            System.out.println(answer);
        }
        scan.close();
    }

    static int minNumOfChangesToMakeAnagram(String input) {
        final int N = input.length();
        if (N % 2 == 1) {
            // It is not possible for two strings of unequal length to be anagram for each other.
            return -1;
        }

        final int half = N / 2;
        final String s1 = input.substring(0, half);
        final String s2 = input.substring(half, N);

        int numOfChanges = 0;
        Map<Character, Integer> charFreqMap = buildCharFrequencyMap(s2);
        for (int i = 0; i < s1.length(); i++) {
            Character ch = s1.charAt(i);
            Integer freq = charFreqMap.get(ch);
            if (freq == null) {
                // got a unique character that is not present in S2,
                // thus numOfChanges
                numOfChanges++;
            } else {
                if (freq > 1) {
                    // if the character is present more then once in S2,
                    // mark it as partially processed by decreasing its frequency
                    charFreqMap.put(ch, --freq);
                } else {
                    // otherwise, mark the character as completely processed
                    charFreqMap.remove(ch);
                }
            }
        }
        return numOfChanges;
    }

    private static Map<Character, Integer> buildCharFrequencyMap(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Integer freq = charFreqMap.get(ch);
            if (freq == null) {
                // new character
                charFreqMap.put(ch, 1);
            } else {
                // existing character
                charFreqMap.put(ch, ++freq);
            }
        }
        return charFreqMap;
    }
}
