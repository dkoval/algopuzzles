package com.github.dkoval.algopuzzles.codefights;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://codefights.com/interview-practice/task/rMe9ypPJkXgk3MHhZ">possibleSums</a>
 * You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in it.
 * You want to know how many distinct sums you can make from non-empty groupings of these coins.
 */
public class PossibleSums {

    static int possibleSums(int[] coins, int[] quantity) {
        Set<Integer> distinctSums = new HashSet<>();
        distinctSums.add(0);
        for (int i = 0; i < coins.length; i++) {
            Set<Integer> prevDistinctSums = new HashSet<>(distinctSums);
            for (int j = 1; j <= quantity[i]; j++) {
                for (Integer prevDistinctSum : prevDistinctSums) {
                    distinctSums.add(prevDistinctSum + j * coins[i]);
                }
            }
        }
        return distinctSums.size() - 1;
    }
}
