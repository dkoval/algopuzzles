package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem">Hash Tables: Ice Cream Parlor</a>
 * Max Score: 35 Difficulty: Medium
 */
public class IceCreamParlor {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            while (t-- > 0) {
                int money = in.nextInt();
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                int[] ans = solve(arr, money);
                System.out.println(Arrays.stream(ans)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" ")));
            }
        }
    }

    static int[] solve(int[] arr, int money) {
        Map<Integer, Integer> val2Idx = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rest = money - arr[i];
            Integer j = val2Idx.get(rest);
            if (j != null) {
                // Each flavor is numbered sequentially with a unique ID number from 1 to n
                return new int[]{j + 1, i + 1};
            }
            val2Idx.put(arr[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }
}
