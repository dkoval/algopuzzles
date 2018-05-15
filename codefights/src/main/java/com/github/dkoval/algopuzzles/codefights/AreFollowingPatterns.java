package com.github.dkoval.algopuzzles.codefights;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://codefights.com/interview-practice/task/3PcnSKuRkqzp8F6BN">areFollowingPatterns</a>
 * Given an array strings, determine whether it follows the sequence given in the patterns array.
 * In other words, there should be no i and j for which strings[i] = strings[j] and patterns[i] ≠ patterns[j]
 * or for which strings[i] ≠ strings[j] and patterns[i] = patterns[j].
 */
public class AreFollowingPatterns {

    static boolean areFollowingPatterns(String[] strings, String[] patterns) {
        Map<String, String> string2Pattern = new HashMap<>();
        Map<String, String> pattern2String = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String newString = strings[i];
            String newPattern = patterns[i];
            String existingString = pattern2String.computeIfAbsent(newPattern, k -> newString);
            String existingPattern = string2Pattern.computeIfAbsent(newString, k -> newPattern);
            if (!newString.equals(existingString) || !newPattern.equals(existingPattern)) {
                return false;
            }
        }
        return true;
    }
}
