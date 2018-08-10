package com.github.dkoval.algopuzzles.codefights;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://app.codesignal.com/interview-practice/task/BG94ZFECSNo6Kv7XW/">kthLargestElement</a>
 * Find the kth largest element in an unsorted array. This will be the kth largest element in sorted order,
 * not the kth distinct element.
 */
public class KthLargestElement {

    static int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        int res = pq.poll();
        while (k-- > 1) {
            res = pq.poll();
        }
        return res;
    }
}
