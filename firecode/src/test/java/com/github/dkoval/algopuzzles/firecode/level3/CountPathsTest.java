package com.github.dkoval.algopuzzles.firecode.level3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link CountPaths} solution.
 */
@RunWith(Parameterized.class)
public class CountPathsTest {
    private final int m;
    private final int n;
    private final int expected;

    public CountPathsTest(int m, int n, int expected) {
        this.m = m;
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1},
                {2, 2, 2},
                {3, 5, 15},
                {10, 12, 167960},
                {8, 10, 11440},
                {18, 17, 1166803110},
                {5, 3, 15},
                {4, 1, 1},
                {12, 6, 4368},
                {7, 15, 38760},
                {15, 16, 77558760},
        });
    }

    @Test
    public void countPaths() throws Exception {
        int actual = CountPaths.countPaths(m, n);
        assertEquals(expected, actual);
    }
}
