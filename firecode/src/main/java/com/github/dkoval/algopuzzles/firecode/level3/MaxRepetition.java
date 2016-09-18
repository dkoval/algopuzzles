package com.github.dkoval.algopuzzles.firecode.level3;

/**
 * Given an Array of integers, write a method that will return the integer with the maximum number of repetitions.
 * Your code is expected to run with O(n) time complexity and O(1) space complexity.
 * The elements in the array are between 0 to size(array) - 1 and the array will not be empty.
 */
public class MaxRepetition {

    // Good reading: http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
    public static int getMaxRepetition(int[] a) {
        final int n = a.length;
        // for every element arr[i], increment arr[arr[i] % k] by k
        for (int i = 0; i < n; i++) {
            a[a[i] % n] += n;
        }
        // find index of the maximum repeating element
        int maxElemIndex = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[maxElemIndex]) {
                maxElemIndex = i;
            }
        }
        return maxElemIndex;
    }
}
