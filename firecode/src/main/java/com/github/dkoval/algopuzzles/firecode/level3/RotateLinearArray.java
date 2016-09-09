package com.github.dkoval.algopuzzles.firecode.level3;

/**
 * Rotate an array to the left by k positions without using extra space.
 * k can be greater than the size of the array.
 */
public class RotateLinearArray {

    public static int[] rotateLeft(int[] arr, int k) {
        k %= arr.length;
        // rotate the entire array
        rotateInPlace(arr, 0, arr.length);
        // rotate the left portion of the array
        rotateInPlace(arr, 0, arr.length - k);
        // rotate the right portion of the array
        rotateInPlace(arr, arr.length - k, k);
        return arr;
    }

    private static void rotateInPlace(int[] arr, int offset, int count) {
        for (int i = 0; i < count / 2; i++) {
            int l = offset + i;
            int r = offset + (count - i - 1);
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
    }
}
