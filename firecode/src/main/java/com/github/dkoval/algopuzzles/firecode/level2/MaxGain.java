package com.github.dkoval.algopuzzles.firecode.level2;

/**
 * Given an array of integers, write a method - maxGain - that returns the maximum gain.
 * Maximum Gain is defined as the maximum difference between 2 elements in a list such that
 * the larger element appears after the smaller element. If no gain is possible, return 0.
 */
public class MaxGain {

    public static int maxGain(int[] a) {
        int minElemPos = 0, maxElemPos = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[minElemPos]) {
                minElemPos = i;
            }
            if (a[i] > a[maxElemPos]) {
                maxElemPos = i;
            }
        }
        return (maxElemPos > minElemPos) ? a[maxElemPos] - a[minElemPos] : 0;
    }
}
