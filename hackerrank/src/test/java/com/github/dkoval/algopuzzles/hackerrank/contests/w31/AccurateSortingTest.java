package com.github.dkoval.algopuzzles.hackerrank.contests.w31;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link AccurateSorting} solution.
 */
@RunWith(Parameterized.class)
public class AccurateSortingTest {
    private final int[] arr;
    private final boolean expected;

    public AccurateSortingTest(int[] arr, boolean expected) {
        this.arr = arr;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 0, 3, 2}, true},
                {new int[]{2, 1, 0}, false},
        });
    }

    @Test
    public void solve() throws Exception {
        boolean actual = AccurateSorting.solve(arr);
        assertEquals(expected, actual);
    }
}