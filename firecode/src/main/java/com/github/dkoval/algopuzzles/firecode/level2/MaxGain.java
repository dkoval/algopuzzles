package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * Given an array of integers, write a method - maxGain - that returns the maximum gain.
 * Maximum Gain is defined as the maximum difference between 2 elements in a list such that
 * the larger element appears after the smaller element. If no gain is possible, return 0.
 */
public class MaxGain {

    public static int maxGain(int[] a) {
        int maxGain = 0, min = a[0];
        for (int i = 1; i < a.length; i++) {
            min = Math.min(min, a[i]);
            maxGain = Math.max(maxGain, a[i] - min);
        }
        return maxGain;
    }
}
