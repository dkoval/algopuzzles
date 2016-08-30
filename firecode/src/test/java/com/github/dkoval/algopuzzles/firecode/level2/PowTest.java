package com.github.dkoval.algopuzzles.firecode.level2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Pow} solution.
 */
@RunWith(Parameterized.class)
public class PowTest {
    private final double x;
    private final int n;
    private final double expected;

    public PowTest(double x, int n, double expected) {
        this.x = x;
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1.0, 4, 1.0},
                {2.0, 0, 1.0},
                {2.0, 1, 2.0},
                {2.0, 3, 8.0},
                {2.0, -1, 0.5},
                {2.0, -2, 0.25},
                {-2.0, 0, 1.0},
                {-2.0, 2, 4.0},
                {0.0, Integer.MAX_VALUE, 0.0},
                {0.0, Integer.MIN_VALUE, 0.0},
        });
    }

    @Test
    public void pow() throws Exception {
        double actual = Pow.pow(x, n);
        assertEquals(expected, actual, 1E-6);
    }
}