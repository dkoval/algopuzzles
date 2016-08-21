package com.github.dkoval.algopuzzles.firecode;

/**
 * Implement the merge() method that takes in
 * two sorted arrays and returns a third sorted array that contains elements of both the input arrays.
 * <p>
 * You can assume that the input arrays will always be sorted in ascending order and can have different sizes.
 */
public class MergeTwoSortedArrays {

    public static int[] merge(int[] arrLeft, int[] arrRight) {
        int[] arrMerged = new int[arrLeft.length + arrRight.length];
        int l = 0, r = 0, m = 0;
        while (l < arrLeft.length && r < arrRight.length) {
            if (arrLeft[l] < arrRight[r]) {
                arrMerged[m++] = arrLeft[l++];
            } else {
                arrMerged[m++] = arrRight[r++];
            }
        }
        // append the remaining elements in case left and right arrays have different sizes
        while (l < arrLeft.length) {
            // left array is longer in size
            arrMerged[m++] = arrLeft[l++];
        }
        while (r < arrRight.length) {
            // right array is longer in size
            arrMerged[m++] = arrRight[r++];
        }
        return arrMerged;
    }
}
