package com.github.dkoval.algopuzzles.codefights;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://codefights.com/interview-practice/task/njfXsvjRthFKmMwLC">containsCloseNums</a>
 * Given an array of integers nums and an integer k, determine whether there are two distinct indices i and j
 * in the array where nums[i] = nums[j] and the absolute difference between i and j is less than or equal to k.
 */
public class ContainsCloseNums {

    static boolean containsCloseNums(int[] nums, int k) {
        Map<Integer, Integer> num2Idx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer j = num2Idx.get(num);
            if (j != null) {
                int diff = Math.abs(i - j);
                if (diff <= k) {
                    return true;
                }
            }
            num2Idx.put(num, i);
        }
        return false;
    }
}
