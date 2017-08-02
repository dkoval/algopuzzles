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
    private final int expected;

    public CoinChangeTest(int n, int[] coins, int expected) {
        this.n = n;
        this.coins = coins;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, new int[]{1, 2, 3}, 4},
                {10, new int[]{2, 5, 3, 6}, 5},
        });
    }

    @Test
    public void numWaysToMakeChange() throws Exception {
        int actual = CoinChange.numWaysToMakeChange(n, coins);
        assertThat(actual, equalTo(expected));
    }
}
