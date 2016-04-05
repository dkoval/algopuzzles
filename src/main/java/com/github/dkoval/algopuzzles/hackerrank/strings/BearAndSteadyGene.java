package com.github.dkoval.algopuzzles.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/bear-and-steady-gene">Problem:</a>
 * Max Score: 50, Difficulty: Moderate
 * <p>
 * A gene is represented as a string of length n (where n is divisible by 4), composed of the letters A, C, T, and G.
 * It is considered to be steady if each of the four letters occurs exactly n/4 times.
 * For example, GACT and AAGTGCCT are both steady genes.
 * <p>
 * Bear Limak is a famous biotechnology scientist who specializes in modifying bear DNA to make it steady.
 * Right now, he is examining a gene represented as a string s. It is not necessarily steady.
 * Fortunately, Limak can choose one (maybe empty) substring of s and replace it with any substring of the same length.
 * <p>
 * Modifying a large substring of bear genes can be dangerous. Given a string s, can you help Limak find the length of
 * the smallest possible substring that he can replace to make s a steady gene?
 * <p>
 * Note: A substring of a string S is a subsequence made up of zero or more consecutive characters of S.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer nn divisible by 4, denoting the length of a string s.
 * The second line contains a string s of length n. Each character is one of the four: A, C, T, G.
 * <p>
 * Constraints
 * <ul>
 * <li>4 <= n <= 500000</li>
 * <li>n is divisible by 4</li>
 * </ul>
 * Subtask
 * <p>
 * 4 <= n <= 2000 in tests worth 30% points.
 * Output Format
 * <p>
 * On a new line, print the minimum length of the substring replaced to make s stable.
 */
public class BearAndSteadyGene {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // ignore the first line containing an integer n divisible by 4, denoting the length of a string s
        scan.nextLine();
        String input = scan.nextLine();
        scan.close();
        int answer = minLengthOfSubstringReplacedToMakeGeneStable(input);
        System.out.println(answer);
    }

    static int minLengthOfSubstringReplacedToMakeGeneStable(String gene) {
        final int N = gene.length();
        final int steadyLetterFrequency = N / 4;

        Map<Character, Integer> letterFrequencyTable = letterFrequencyTable(gene);
        if (isSteady(letterFrequencyTable, steadyLetterFrequency)) {
            return 0;
        } else {
            int min = N;
            int end = 0;
            // for each possible starting index of the interval let's find the nearest possible ending index
            for (int begin = 0; begin < N; begin++) {
                while (end < N && !isSteady(letterFrequencyTable, steadyLetterFrequency)) {
                    // keep 'removing' letters until the remaining sequence forms a steady gene
                    decreaseLetterFrequency(letterFrequencyTable, gene.charAt(end));
                    end++;
                }
                // once got a steady sequence, check if it is the smallest possible
                if (isSteady(letterFrequencyTable, steadyLetterFrequency)) {
                    min = Math.min(min, end - begin);
                }
                // next iteration will increment the starting index,
                // thus rollback the initial frequency value of a letter at this index
                increaseLetterFrequency(letterFrequencyTable, gene.charAt(begin));
            }
            return min;
        }
    }

    private static Map<Character, Integer> letterFrequencyTable(String gene) {
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < gene.length(); i++) {
            char letter = gene.charAt(i);
            Integer frequency = table.get(letter);
            if (frequency == null) {
                table.put(letter, 1);
            } else {
                table.put(letter, ++frequency);
            }
        }
        return table;
    }

    private static void decreaseLetterFrequency(Map<Character, Integer> letterFrequencyTable, char letter) {
        int frequency = letterFrequencyTable.get(letter);
        letterFrequencyTable.put(letter, --frequency);
    }

    private static void increaseLetterFrequency(Map<Character, Integer> letterFrequencyTable, char letter) {
        int frequency = letterFrequencyTable.get(letter);
        letterFrequencyTable.put(letter, ++frequency);
    }

    private static boolean isSteady(Map<Character, Integer> letterFrequencyTable, int steadyLetterFrequency) {
        for (Map.Entry<Character, Integer> entry : letterFrequencyTable.entrySet()) {
            int letterFrequency = entry.getValue();
            if (letterFrequency > steadyLetterFrequency) {
                return false;
            }
        }
        return true;
    }
}
