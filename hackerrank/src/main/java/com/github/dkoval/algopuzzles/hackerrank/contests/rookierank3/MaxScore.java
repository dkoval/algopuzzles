package com.github.dkoval.algopuzzles.hackerrank.contests.rookierank3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/contests/rookierank-3/challenges/max-score">Max Score</a>
 * Max Score: 35 Difficulty: Medium
 */
public class MaxScore {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] a = new long[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextLong();
        }
        long maxScore = getMaxScore(a);
        System.out.println(maxScore);
    }

    static long getMaxScore(long[] numbers) {
        Map<Long, Long> memo = new HashMap<>();
        long sum = 0L;
        for (long number : numbers) {
            sum += number;
        }
        return doGetMaxScore(numbers, 0L, sum, memo);
    }

    private static long doGetMaxScore(long[] numbers, long bitMask, long sum, Map<Long, Long> memo) {
        Long res = memo.get(bitMask);
        if (res != null) {
            return res;
        }
        long maxScore = 0L;
        for (int i = 0; i < numbers.length; i++) {
            // set & test ith bit
            int bitToCheck = 1 << i;
            if ((bitMask & bitToCheck) != 0) {
                continue;
            }

            // add ith bit to mask
            bitMask |= bitToCheck;

            // run calculation for ith number & update maxScore
            long number = numbers[i];
            long score = (sum - number) % number + doGetMaxScore(numbers, bitMask, sum - number, memo);
            maxScore = Math.max(score, maxScore);

            // clear ith bit
            bitMask &= ~bitToCheck;

            // cache calculated maxScore
            memo.put(bitMask, maxScore);
        }
        return maxScore;
    }
}
