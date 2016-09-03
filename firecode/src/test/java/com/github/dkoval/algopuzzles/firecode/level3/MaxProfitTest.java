package com.github.dkoval.algopuzzles.firecode.level3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link MaxProfit} solution.
 */
@RunWith(Parameterized.class)
public class MaxProfitTest {
    private final int[] prices;
    private final int expected;

    public MaxProfitTest(int[] prices, int expected) {
        this.prices = prices;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 50, 10, 100, 30}, 140},
                {new int[]{100, 40, 20, 10}, 0},
                {new int[]{1, 1}, 0},
                {new int[]{0, 100, 0, 100, 0, 100}, 300},
                {new int[]{100, 100, 80, 20}, 0},
        });
    }

    @Test
    public void maxProfit() throws Exception {
        int actual = MaxProfit.maxProfit(prices);
        assertEquals(expected, actual);
    }
}
