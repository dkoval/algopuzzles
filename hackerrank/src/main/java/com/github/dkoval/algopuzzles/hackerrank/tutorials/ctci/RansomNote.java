package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-ransom-note/problem">Hash Tables: Ransom Note</a>
 * Max Score: 25 Difficulty: Easy
 */
public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String[] magazine = new String[m];
        for (int i = 0; i < m; i++) {
            magazine[i] = in.next();
        }
        String[] ransom = new String[n];
        for (int i = 0; i < n; i++) {
            ransom[i] = in.next();
        }
        boolean ans = solve(magazine, ransom);
        System.out.println(ans ? "Yes" : "No");
    }

    static boolean solve(String[] magazine, String[] ransom) {
        Map<String, Integer> wordFreqs = new HashMap<>();
        for (String word : magazine) {
            if (wordFreqs.containsKey(word)) {
                wordFreqs.computeIfPresent(word, (key, val) -> ++val);
            } else {
                wordFreqs.putIfAbsent(word, 1);
            }
        }
        for (String word : ransom) {
            Integer freq = wordFreqs.get(word);
            if (freq == null || freq == 0) {
                return false;
            }
            wordFreqs.computeIfPresent(word, (key, val) -> --val);
        }
        return true;
    }
}
