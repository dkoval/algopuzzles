package com.github.dkoval.algopuzzles.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/reverse-shuffle-merge">Problem:</a>
 * Max Score: 50, Difficulty: Advanced
 */
public class ReverseShuffleMerge {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        String answer = solve(input);
        System.out.println(answer);
    }

    static String solve(String s) {
        // construct frequency table of input S
        Map<Character, Integer> frequencyTable = frequencyTable(s);
        // halve the frequencies to determine the frequencies of each char in the answer
        frequencyTable = halveFrequencies(frequencyTable);

        int lastPickedUpSmallestCharPos = s.length();
        StringBuilder answer = new StringBuilder(s.length() / 2);
        while (!frequencyTable.isEmpty()) {
            // find the smallest window which holds all the remaining chars as a subsequence
            Map<Character, Integer> copyOfFrequencyTable = new HashMap<>(frequencyTable);
            int windowSize = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                removeCharFromFrequencyTable(copyOfFrequencyTable, ch);
                if (copyOfFrequencyTable.isEmpty()) {
                    break;
                }
                windowSize++;
            }

            Character smallestChar = null;
            for (int i = lastPickedUpSmallestCharPos - 1; i >= windowSize; i--) {
                char ch = s.charAt(i);
                // ignore the characters which have already been seen
                if (!frequencyTable.containsKey(ch)) {
                    continue;
                }
                if (smallestChar == null || smallestChar > ch) {
                    smallestChar = ch;
                    lastPickedUpSmallestCharPos = i;
                }
            }
            answer.append(smallestChar);
            removeCharFromFrequencyTable(frequencyTable, smallestChar);
        }
        return answer.toString();
    }

    private static Map<Character, Integer> frequencyTable(String s) {
        Map<Character, Integer> frequencyTable = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Integer freq = frequencyTable.get(ch);
            if (freq == null) {
                frequencyTable.put(ch, 1);
            } else {
                frequencyTable.put(ch, ++freq);
            }
        }
        return frequencyTable;
    }

    private static Map<Character, Integer> halveFrequencies(Map<Character, Integer> frequencyTable) {
        for (Map.Entry<Character, Integer> entry : frequencyTable.entrySet()) {
            Integer frequency = entry.getValue();
            entry.setValue(frequency / 2);
        }
        return frequencyTable;
    }

    private static void removeCharFromFrequencyTable(Map<Character, Integer> frequencyTable, Character ch) {
        Integer freq = frequencyTable.get(ch);
        if (freq == null) {
            return;
        }
        if (freq > 1) {
            frequencyTable.put(ch, --freq);
        } else {
            frequencyTable.remove(ch);
        }
    }
}