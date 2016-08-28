package com.github.dkoval.algopuzzles.firecode.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a method that checks if two strings are permutations of each other.
 */
public class Permutations {

    public static boolean permutation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> freqTable = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            // str1
            char c = str1.charAt(i);
            Integer count = freqTable.get(c);
            if (count == null) {
                freqTable.put(c, 1);
            } else {
                freqTable.put(c, ++count);
            }
            // str2
            c = str2.charAt(i);
            count = freqTable.get(c);
            if (count == null) {
                freqTable.put(c, -1);
            } else {
                freqTable.put(c, --count);
            }
        }
        for (Map.Entry<Character, Integer> charFreq : freqTable.entrySet()) {
            if (charFreq.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
