package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Tests {@link CoinChange} solution.
 */
@RunWith(Parameterized.class)
public class CoinChangeTest {
    private final int n;
    private final int[] coins;
    private final long expected;

    public CoinChangeTest(int n, int[] coins, long expected) {
        this.n = n;
        this.coins = coins;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, new int[]{1, 2, 3}, 4L},
                {10, new int[]{2, 5, 3, 6}, 5L},
                {250, new int[]{8, 47, 13, 24, 25, 31, 32, 35, 3, 19, 40, 48, 1, 4, 17, 38, 22, 30, 33, 15, 44, 46, 36, 9, 20, 49}, 3542323427L},
        });
    }

    @Test
    public void numWaysToMakeChange() throws Exception {
        long actual = CoinChange.numWaysToMakeChange(n, coins);
        assertThat(actual, equalTo(expected));
    }
}
