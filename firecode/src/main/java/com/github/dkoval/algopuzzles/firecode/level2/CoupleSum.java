package com.github.dkoval.algopuzzles.firecode.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they sum up to a specific target.
 * The method coupleSum should return the indices of the two numbers in the array, where index1 must be less than index2.
 * Please note that the indices are not zero based, and you can assume that each input has exactly one solution.
 * Target linear runtime and space complexity.
 */
public class CoupleSum {

    public static int[] coupleSum(int[] numbers, int target) {
        Map<Integer, Integer> alreadySeenNumbers = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int left = target - numbers[i];
            Integer j = alreadySeenNumbers.get(left);
            if (j != null) {
                // since output is not zero-indexed, increment by 1 here
                return new int[]{++j, ++i};
            }
            alreadySeenNumbers.put(numbers[i], i);
        }
        return new int[0];
    }
}
