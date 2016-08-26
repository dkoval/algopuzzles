package com.github.dkoval.algopuzzles.firecode.level2;

import java.util.Arrays;
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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
            Integer j = map.get(target - numbers[i]);
            if (j != null) {
                // since output is not zero-indexed, increment by 1 here
                int[] pairOfIndices = {++i, ++j};
                // index1 must be less than index2
                Arrays.sort(pairOfIndices);
                return pairOfIndices;
            }
        }
        return new int[0];
    }
}
