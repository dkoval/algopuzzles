package com.github.dkoval.algopuzzles.hackerrank.algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/closest-numbers">Problem:</a>
 * Max Score: 35 Difficulty: Easy
 */
public class ClosestNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] answer = solve(a);
        printArray(answer);
    }

    static int[] solve(int[] a) {
        int minDiff = Integer.MAX_VALUE;
        List<Integer> pairsList = new LinkedList<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            int curDiff = Math.abs(a[i] - a[i + 1]);
            if (curDiff > minDiff) {
                // skip
                continue;
            }
            if (curDiff < minDiff) {
                // update the smallest difference
                minDiff = curDiff;
                pairsList.clear();
            }
            pairsList.add(a[i]);
            pairsList.add(a[i + 1]);
        }
        return pairsList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
