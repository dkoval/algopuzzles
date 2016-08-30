package com.github.dkoval.algopuzzles.firecode.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings - input1 and input2, determine if they are isomorphic.
 * Two strings are isomorphic if the letters in one string can be remapped to get the second string.
 * Remapping a letter means replacing all occurrences of it with another letter.
 * The ordering of the letters remains unchanged.
 * You can also think of isomorphism as it is used in chemistry - i.e. having the same form or overall shape.
 * Target linear time and space complexity with your solution.
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String input1, String input2) {
        if (input1 == null || input2 == null || input1.length() != input2.length()) {
            return false;
        }
        Map<Character, Integer> freqTable1 = buildFrequencyTable(input1);
        Map<Character, Integer> freqTable2 = buildFrequencyTable(input2);
        // iterate over both the Strings and compare the character count values stored in the corresponding maps.
        // If at any stage the count is not the same, return false.
        for (int i = 0; i < input1.length(); i++) {
            int counter1 = freqTable1.get(input1.charAt(i));
            int counter2 = freqTable2.get(input2.charAt(i));
            if (counter1 != counter2) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> buildFrequencyTable(String str) {
        Map<Character, Integer> freqTable = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer counter = freqTable.get(c);
            if (counter != null) {
                freqTable.put(c, ++counter);
            } else {
                freqTable.put(c, 1);
            }
        }
        return freqTable;
    }
}
