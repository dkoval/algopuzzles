package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-find-the-running-median">Heaps: Find the Running Median</a>
 * Max Score: 50 Difficulty: Hard
 */
public class FindRunningMedian {

    /**
     * maxHeap stores the larger half seen so far.
     */
    private static final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(2, Collections.reverseOrder());

    /**
     * minHeap stores the smaller part seen so far.
     */
    private static final PriorityQueue<Integer> minHeap = new PriorityQueue<>(1);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            double median = calcRunningMedian(a[i]);
            System.out.printf("%.1f\n", median);
        }
    }

    static double calcRunningMedian(int x) {
        if (maxHeap.isEmpty()) {
            // this is the very first element
            maxHeap.add(x);
        } else {
            if (x >= maxHeap.peek()) {
                minHeap.add(x);
            } else {
                maxHeap.add(x);
            }
        }

        // ensure maxHeap and minHeap have equal number of elements if an even number of elements is read;
        // otherwise, maxHeap must have one more element than minHeap
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.remove());
        }
        return (maxHeap.size() == minHeap.size()) ? 0.5 * (maxHeap.peek() + minHeap.peek()) : maxHeap.peek();
    }
}
