package com.github.dkoval.algopuzzles.hackerrank.tutorials.ctci;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

/**
 * Tests {@link FindRunningMedian} solution.
 */
@RunWith(Parameterized.class)
public class FindRunningMedianTest {
    private final int[] stream;
    private final double[] expected;

    public FindRunningMedianTest(int[] stream, double[] expected) {
        this.stream = stream;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{12, 4, 5, 3, 8, 7}, new double[]{12.0, 8.0, 5.0, 4.5, 5.0, 6.0}},
        });
    }

    @Test
    public void runningMedian() throws Exception {
        int[] a = new int[stream.length];
        for (int i = 0; i < stream.length; i++) {
            a[i] = stream[i];
            double actual = FindRunningMedian.calcRunningMedian(a[i]);
            assertThat(actual, closeTo(expected[i], 1e-3));
        }
    }
}
