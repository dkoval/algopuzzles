package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-find-the-running-median">Heaps: Find the Running Median</a>
 * Max Score: 50 Difficulty: Hard
 */
public class FindRunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        double[] medians = getMedians(a);
        for (double median : medians) {
            System.out.printf("%.1f\n", median);
        }
    }

    static double[] getMedians(int[] numbers) {
        // lowerHalf stores the larger half seen so far
        PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        // upperHalf stores the smaller part seen so far
        PriorityQueue<Integer> upperHalf = new PriorityQueue<>();
        // perform calculation
        double[] medians = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            trackNumber(number, lowerHalf, upperHalf);
            rebalanceHeaps(lowerHalf, upperHalf);
            medians[i] = calculateMedian(lowerHalf, upperHalf);
        }
        return medians;
    }

    private static void trackNumber(int number, PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> upperHalf) {
        if (lowerHalf.isEmpty() || number < lowerHalf.peek()) {
            lowerHalf.add(number);
        } else {
            upperHalf.add(number);
        }
    }

    private static void rebalanceHeaps(PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> upperHalf) {
        // ensure lowerHalf and upperHalf have equal number of elements if an even number of elements is read;
        // otherwise, lowerHalf must have one more element than upperHalf
        if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.add(upperHalf.remove());
        } else if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.add(lowerHalf.remove());
        }
    }

    private static double calculateMedian(PriorityQueue<Integer> lowerHalf, PriorityQueue<Integer> upperHalf) {
        return (lowerHalf.size() == upperHalf.size()) ? 0.5 * (lowerHalf.peek() + upperHalf.peek()) : lowerHalf.peek();
    }
}
