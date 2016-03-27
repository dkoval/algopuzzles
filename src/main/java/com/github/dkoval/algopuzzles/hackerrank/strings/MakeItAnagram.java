package com.github.dkoval.algopuzzles.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/make-it-anagram">Problem:</a>.
 * Max Score: 30, Difficulty: Easy
 * <p>
 * Alice recently started learning about cryptography and found that anagrams are very useful.
 * Two strings are anagrams of each other if they have same character set (and frequency of characters) and same length.
 * For example strings "bacdc" and "dcbac" are anagrams, while strings "bacdc" and "dcbad" are not.
 * <p>
 * Alice decides on an encryption scheme involving 2 large strings where encryption is dependent on the minimum number of
 * character deletions required to make the two strings anagrams. She need your help in finding out this number.
 * <p>
 * Given two strings (they can be of same or different length) help her in finding out the minimum number of character
 * deletions required to make two strings anagrams. Any characters can be deleted from any of the strings.
 * <p>
 * Input Format
 * <p>
 * Two lines each containing a string.
 * <p>
 * Constraints
 * <ul>
 * <li>1 <= Length of A,B <= 10000</li>
 * <li>A and B will only consist of lowercase latin letter.</li>
 * </ul>
 * <p>
 * Output Format
 * <p>
 * A single integer which is the number of character deletions.
 */
public class MakeItAnagram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String first = scan.nextLine();
        String second = scan.nextLine();
        scan.close();
        int answer = minNumOfCharDeletionsToMakeTwoStringsAnagrams(first, second);
        System.out.println(answer);
    }

    static int minNumOfCharDeletionsToMakeTwoStringsAnagrams(String first, String second) {
        int answer = 0;
        Map<Character, Integer> firstLetterFreqTable = letterFrequencyTable(first);
        Map<Character, Integer> secondLetterFreqTable = letterFrequencyTable(second);

        for (Map.Entry<Character, Integer> entry : firstLetterFreqTable.entrySet()) {
            char firstLetter = entry.getKey();
            int firstFreq = entry.getValue();

            // check if the letter from the `first` is present in the `second`
            Integer secondFreq = secondLetterFreqTable.get(firstLetter);
            if (secondFreq == null) {
                // is present in the `first` but is not present in the `second`
                answer += firstFreq;
            } else {
                // is present in both `first` and `second`
                answer += Math.abs(firstFreq - secondFreq);
                // exclude common characters to leave only those that are not present in the `first`
                secondLetterFreqTable.remove(firstLetter);
            }
        }

        // at this stage, the second letter frequency table contains only those letters
        // that are not present in the `first` string - count them
        for (Map.Entry<Character, Integer> entry : secondLetterFreqTable.entrySet()) {
            int freq = entry.getValue();
            answer += freq;
        }

        return answer;
    }

    private static Map<Character, Integer> letterFrequencyTable(String s) {
        Map<Character, Integer> letterFrequencyTable = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            Integer freq = letterFrequencyTable.get(letter);
            if (freq == null) {
                letterFrequencyTable.put(letter, 1);
            } else {
                letterFrequencyTable.put(letter, ++freq);
            }
        }
        return letterFrequencyTable;
    }
}
