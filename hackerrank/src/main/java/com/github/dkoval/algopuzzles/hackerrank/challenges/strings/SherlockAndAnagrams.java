package com.github.dkoval.algopuzzles.hackerrank.challenges.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/sherlock-and-anagrams">Problem:</a>
 * Max Score: 50, Difficulty: Moderate
 * <p>
 * Given a string S, find the number of "unordered anagrammatic pairs" of substrings.
 * <p>
 * Input Format
 * <p>
 * First line contains T, the number of testcases. Each testcase consists of string S in one line.
 * <p>
 * Constraints
 * <ul>
 * <li>1<= T <=10</li>
 * <li>2<= length(S) <=100 </li>
 * <li>String S contains only the lowercase letters of the English alphabet</li>
 * </ul>
 * <p>
 * Output Format
 * <p>
 * For each testcase, print the required answer in one line.
 */
public class SherlockAndAnagrams {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfTestCases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < numOfTestCases; i++) {
            String input = scan.nextLine();
            int answer = numOfUnorderedAnagrammaticPairs(input);
            System.out.println(answer);
        }
        scan.close();
    }

    static int numOfUnorderedAnagrammaticPairs(String input) {
        Map<String, Integer> frequencyTable = generateSubstringsFrequencyTable(input);
        return calculateNumOfUnorderedAnagrammaticPairs(frequencyTable);
    }

    private static Map<String, Integer> generateSubstringsFrequencyTable(String input) {
        // generate frequency table of all possible substrings of length 1, 2, ..., N
        final Map<String, Integer> frequencyTable = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                String subs = input.substring(i, j + 1);
                // NOTE: two string S1 and S2 of the same length are anagrammatic
                // if they remain equal after being alphabetically sorted
                String sortedSubs = sort(subs);
                // update frequency table. If sorted substring's frequency k is greater or equal to 2,
                // it means that k anagrammatic substrings were found
                updateSubstringFrequency(frequencyTable, sortedSubs);
            }
        }
        return frequencyTable;
    }

    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static void updateSubstringFrequency(Map<String, Integer> frequencyTable, String subs) {
        Integer freq = frequencyTable.get(subs);
        if (freq == null) {
            frequencyTable.put(subs, 1);
        } else {
            frequencyTable.put(subs, ++freq);
        }
    }

    private static int calculateNumOfUnorderedAnagrammaticPairs(Map<String, Integer> frequencyTable) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : frequencyTable.entrySet()) {
            // if there are k anagrammatic strings, number of unordered anagrammatic pairs is
            // C(k, 2) = A(k, 2) / 2! = k * (k - 1) / 2
            Integer freq = entry.getValue();
            sum += freq * (freq - 1) / 2;
        }
        return sum;
    }
}
