package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link BetterFibonacci} solution.
 */
@RunWith(Parameterized.class)
public class BetterFibonacciTest {
    private final int n;
    private final int expected;

    public BetterFibonacciTest(int n, int expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
                {7, 13},
                {8, 21},
                {9, 34},
                {10, 55},
                {15, 610},
                {20, 6765},
                {30, 832040},
                {35, 9227465},
                {40, 102334155},
        });
    }

    @Test
    public void betterFibonacci() throws Exception {
        int actual = BetterFibonacci.betterFibonacci(n);
        assertEquals(expected, actual);
    }
}
