package com.github.dkoval.algopuzzles.firecode;

/**
 * Selection sort offers improved performance over bubble sort, especially for arrays with a large number of elements.
 * Where bubble sort accumulated the largest elements towards the end of the array, selection sort accumulates the
 * smallest elements at the beginning of the array.
 * <p>
 * Write a method that uses the selection sort algorithm to sort an input array of integers.
 */
public class SelectionSort {

    public static int[] selectionSortArray(int[] arr) {
        for (int k = 0; k < arr.length - 1; k++) {
            int minElemPos = k;
            for (int i = k + 1; i < arr.length; i++) {
                if (arr[i] < arr[minElemPos]) {
                    minElemPos = i;
                }
            }
            swap(arr, k, minElemPos);
        }
        return arr;
    }

    private static void swap(int arr[], int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
